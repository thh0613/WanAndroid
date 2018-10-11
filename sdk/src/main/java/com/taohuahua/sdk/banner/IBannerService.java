package com.taohuahua.sdk.banner;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.constants.UrlConstants;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * 首页banner位
 */
public interface IBannerService {

    @GET(UrlConstants.BANNER_PATH)
    Flowable<ApiResponse<List<BannerEntity>>> getHomeBanner();

}
