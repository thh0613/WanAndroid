package com.taohuahua.sdk;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

import java.util.concurrent.Executors;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

// ResultType: Type for the Resource data
// RequestType: Type for the API response
public abstract class NetworkBoundResource<ResultType, RequestType> {
    private PublishSubject<Resource<ResultType>> result = PublishSubject.create();

    @MainThread
    public NetworkBoundResource() {
        result.onNext(Resource.loading(null));
        Flowable<ResultType> dbSource = loadFromDb();
        if (dbSource != null) {
            dbSource.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .take(1)
                    .subscribe(value -> {
                        dbSource.unsubscribeOn(Schedulers.io());
                        if (shouldFetch(value)) {
                            fetchFromNetwork();
                        } else {
                            result.onNext(Resource.success(value));
                        }
                    });
        } else {
            fetchFromNetwork();
        }
    }

    private void fetchFromNetwork() {
        Flowable<ApiResponse<RequestType>> apiResponse = createCall();

        // we re-attach dbSource as a new source,
        // it will dispatch its latest value quickly
        result.onNext(Resource.loading(null));
        apiResponse
                .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(3)))
                .observeOn(Schedulers.io())
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (!response.isSuccessful()) {
                                onFetchFailed();
                                result.onNext(Resource.error(response.getErrorMsg(), null));
                            } else {
                                Flowable<ResultType> dbSource = loadFromDb();
                                if (dbSource != null) {
                                    dbSource.subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .take(1)
                                            .subscribe(resultData -> {
                                                dbSource.unsubscribeOn(Schedulers.io());
                                                result.onNext(Resource.success(resultData));
                                            });
                                } else {
                                    result.onNext(Resource.success((ResultType)response.getData()));
                                }
                            }
                        }, error -> {
                            onFetchFailed();
                            result.onNext(Resource.error(error.getMessage(), null));
                        }

                );
    }

    /**
     * Called to save the result of the API response into the database
     */
    @WorkerThread
    protected abstract void saveCallResult(@NonNull RequestType item);

    /**
     * Called with the data in the database to decide whether it should be
     * fetched from the network.
     *
     * @param data
     * @return
     */

    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    /**
     * Called to get the cached data from the database
     *
     * @return
     */
    @NonNull
    @MainThread
    protected abstract Flowable<ResultType> loadFromDb();

    /**
     * Called to create the API call.
     *
     * @return
     */
    @NonNull
    @MainThread
    protected abstract Flowable<ApiResponse<RequestType>> createCall();


    /**
     * Called when the fetch fails. The child class may want to reset components
     * like rate limiter.
     */
    @MainThread
    protected void onFetchFailed() {
    }

    /**
     * returns a LiveData that represents the resource
     */
    public final PublishSubject<Resource<ResultType>> getAsLiveData() {
        return result;
    }
}