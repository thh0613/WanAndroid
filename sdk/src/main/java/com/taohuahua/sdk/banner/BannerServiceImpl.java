package com.taohuahua.sdk.banner;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.manager.BaseHttpService;
import com.taohuahua.sdk.manager.RetrofitServiceManager;

import java.util.List;

import io.reactivex.Flowable;


/**
 * banner接口实现
 */
public class BannerServiceImpl extends BaseHttpService {
    // 单例
    private static class InstanceHolder {
        private static final IBannerService SERVICE =
                RetrofitServiceManager.InstanceHolder.retrofit.create(IBannerService.class);
    }

    public Flowable<ApiResponse<List<BannerEntity>>> getHomeBanner() {
        return InstanceHolder.SERVICE.getHomeBanner();
    }
}
