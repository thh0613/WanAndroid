package com.taohuahua.wanandroid.sdk.banner;

import com.taohuahua.sdk.ApiResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

import static com.taohuahua.wanandroid.constants.UrlConstants.BANNER_PATH;

/**
 * 首页banner位
 */
public interface IBannerService {

    @GET(BANNER_PATH)
    Flowable<ApiResponse<List<BannerEntity>>> getHomeBanner();

}
