package com.taohuahua.sdk.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.taohuahua.sdk.Resource;
import com.taohuahua.sdk.home.entity.ArticleResponse;
import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.sdk.home.entity.HotKeyEntity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * banner
 */
public class HomeViewModel extends ViewModel {
    private HomeRepository mHomeRepository;
    private LiveData<Resource<List<BannerEntity>>> mBannerResponse = new MutableLiveData<>();
    private LiveData<Resource<List<HotKeyEntity>>> mHotKeyResponse = new MutableLiveData<>();
    private LiveData<Resource<ArticleResponse>> mSearchResponse = new MutableLiveData<>();
    private LiveData<Resource<ArticleResponse>> mHomeArticleResponse = new MutableLiveData<>();

    public HomeViewModel() {
        mHomeRepository = new HomeRepository();
        getBannerResponse();
    }

    public LiveData<Resource<List<BannerEntity>>> getBannerList() {
        return mBannerResponse;
    }

    public LiveData<Resource<List<HotKeyEntity>>> getHotKeyList() {
        if (mHotKeyResponse.getValue() == null) {
            mHotKeyResponse = LiveDataReactiveStreams.fromPublisher(mHomeRepository.getHotKeyList
                    ().observeOn(AndroidSchedulers.mainThread()));
        }
        return mHotKeyResponse;
    }

    public LiveData<Resource<ArticleResponse>> getSearchResponse(String key) {
        if (mSearchResponse.getValue() == null) {
            mSearchResponse = LiveDataReactiveStreams.fromPublisher(mHomeRepository.search(key).observeOn(AndroidSchedulers.mainThread()));
        }
        return mSearchResponse;
    }

    public LiveData<Resource<ArticleResponse>> getHomeArticleResponse() {
        if (mHomeArticleResponse.getValue() == null) {
            mHomeArticleResponse = LiveDataReactiveStreams.fromPublisher(mHomeRepository.getHomeArticle());
        }
        return mHomeArticleResponse;
    }

    private void getBannerResponse() {
        if (mBannerResponse.getValue() == null) {
            mBannerResponse = LiveDataReactiveStreams.fromPublisher(mHomeRepository.getBannerList
                    ().observeOn(AndroidSchedulers.mainThread()));
        }
    }
}
