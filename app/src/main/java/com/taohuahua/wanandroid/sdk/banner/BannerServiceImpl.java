package com.taohuahua.wanandroid.sdk.banner;

import com.taohuahua.wanandroid.manager.BaseHttpService;
import com.taohuahua.wanandroid.manager.RetrofitServiceManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * banner接口实现
 */
public class BannerServiceImpl extends BaseHttpService {
    // 单例
    private static class InstanceHolder {
        private static final IBannerService SERVICE =
                RetrofitServiceManager.InstanceHolder.retrofit.create(IBannerService.class);
    }

    public Observable<BannerResponse> getHomeBanner() {
        Map<String, Object> params = new HashMap<>();
        return observe(InstanceHolder.SERVICE.getHomeBanner()).map(new Function<BannerResponse, BannerResponse>() {



            @Override
            public BannerResponse apply(BannerResponse bannerResponse) throws Exception {
                return bannerResponse;
            }
        });
    }
}
