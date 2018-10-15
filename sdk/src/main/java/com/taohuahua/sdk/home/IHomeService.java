package com.taohuahua.sdk.home;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.constants.UrlConstants;
import com.taohuahua.sdk.home.entity.ArticleResponse;
import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.sdk.home.entity.HotKeyEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 首页banner位
 */
public interface IHomeService {

    @GET(UrlConstants.BANNER_PATH)
    Flowable<ApiResponse<List<BannerEntity>>> getHomeBanner();

    @GET(UrlConstants.HOT_KEY_PATH)
    Flowable<ApiResponse<List<HotKeyEntity>>> getHotKeyList();

    @FormUrlEncoded
    @POST(UrlConstants.SERACH_PATH)
    Flowable<ApiResponse<ArticleResponse>> search(@Field(value = "k", encoded = true) String key);

    @GET(UrlConstants.HOME_ARTICLE_PATH)
    Flowable<ApiResponse<ArticleResponse>> getHomeArticle();
}
