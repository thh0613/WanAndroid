package com.taohuahua.sdk.home;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.home.entity.ArticleResponse;
import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.sdk.home.entity.HotKeyEntity;
import com.taohuahua.sdk.home.entity.HotWebsiteEntity;
import com.taohuahua.sdk.manager.BaseHttpService;
import com.taohuahua.sdk.manager.RetrofitServiceManager;

import java.util.List;

import io.reactivex.Flowable;


/**
 * home 相关接口实现
 */
public class HomeServiceImpl extends BaseHttpService {
    // 单例
    private static class InstanceHolder {
        private static final IHomeService SERVICE =
                RetrofitServiceManager.InstanceHolder.retrofit.create(IHomeService.class);
    }

    public Flowable<ApiResponse<List<BannerEntity>>> getHomeBanner() {
        return InstanceHolder.SERVICE.getHomeBanner();
    }

    public Flowable<ApiResponse<List<HotKeyEntity>>> getHotKeyList() {
        return InstanceHolder.SERVICE.getHotKeyList();
    }

    public Flowable<ApiResponse<ArticleResponse>> search(String key) {
        return InstanceHolder.SERVICE.search(key);
    }

    public Flowable<ApiResponse<ArticleResponse>> getHomeArticle() {
        return InstanceHolder.SERVICE.getHomeArticle();
    }

    public Flowable<ApiResponse<List<HotWebsiteEntity>>> getHotWebsite() {
        return InstanceHolder.SERVICE.getHotWebsite();
    }
}
