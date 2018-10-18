package com.taohuahua.sdk.home;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.NetworkBoundResource;
import com.taohuahua.sdk.Resource;
import com.taohuahua.sdk.home.entity.ArticleResponse;
import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.sdk.home.entity.HotKeyEntity;
import com.taohuahua.sdk.home.entity.HotWebsiteEntity;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;


/**
 * 仓库
 * Repository 模块负责数据处理，
 * 为应用的其他部分提供干净可靠的 API。
 * 你可以将其考虑为不同数据源（Web，缓存或数据库）与应用之间的中间层。
 */
public class HomeRepository {
    private HomeServiceImpl mHomeService;

    public HomeRepository() {
        if (mHomeService == null) {
            mHomeService = new HomeServiceImpl();
        }
    }

    public Flowable<Resource<List<BannerEntity>>> getBannerList() {
        return new NetworkBoundResource<List<BannerEntity>, List<BannerEntity>>() {

            @Override
            protected void saveCallResult(@NonNull List<BannerEntity> item) {
            }

            @Override
            protected boolean shouldFetch(@Nullable List<BannerEntity> data) {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<List<BannerEntity>> loadFromDb() {
                return null;
            }

            @NonNull
            @Override
            protected Flowable<ApiResponse<List<BannerEntity>>> createCall() {
                return mHomeService.getHomeBanner();
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);
    }

    public Flowable<Resource<List<HotKeyEntity>>> getHotKeyList() {
        return new NetworkBoundResource<List<HotKeyEntity>,List<HotKeyEntity>>() {

            @Override
            protected void saveCallResult(@NonNull List<HotKeyEntity> item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable List<HotKeyEntity> data) {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<List<HotKeyEntity>> loadFromDb() {
                return null;
            }

            @NonNull
            @Override
            protected Flowable<ApiResponse<List<HotKeyEntity>>> createCall() {
                return mHomeService.getHotKeyList();
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);
    }

    public Flowable<Resource<ArticleResponse>> search(String key) {
        return new NetworkBoundResource<ArticleResponse, ArticleResponse>() {

            @Override
            protected void saveCallResult(@NonNull ArticleResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable ArticleResponse data) {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<ArticleResponse> loadFromDb() {
                return null;
            }


            @NonNull
            @Override
            protected Flowable<ApiResponse<ArticleResponse>> createCall() {
                return mHomeService.search(key);
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);
    }

    public Flowable<Resource<ArticleResponse>> getHomeArticle() {
        return new NetworkBoundResource<ArticleResponse, ArticleResponse>() {

            @Override
            protected void saveCallResult(@NonNull ArticleResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable ArticleResponse data) {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<ArticleResponse> loadFromDb() {
                return null;
            }

            @NonNull
            @Override
            protected Flowable<ApiResponse<ArticleResponse>> createCall() {
                return mHomeService.getHomeArticle();
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);
    }

    public Flowable<Resource<List<HotWebsiteEntity>>> getHotWebsite() {
        return new NetworkBoundResource<List<HotWebsiteEntity>, List<HotWebsiteEntity>>() {


            @Override
            protected void saveCallResult(@NonNull List<HotWebsiteEntity> item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable List<HotWebsiteEntity> data) {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<List<HotWebsiteEntity>> loadFromDb() {
                return null;
            }

            @NonNull
            @Override
            protected Flowable<ApiResponse<List<HotWebsiteEntity>>> createCall() {
                return mHomeService.getHotWebsite();
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);
    }
}
