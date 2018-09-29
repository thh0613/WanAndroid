package com.taohuahua.wanandroid.sdk.banner;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.taohuahua.wanandroid.constants.UrlConstants.BANNER_PATH;

/**
 * 首页banner位
 */
public interface IBannerService {

    @GET(BANNER_PATH)
    Observable<BannerResponse> getHomeBanner();

}
