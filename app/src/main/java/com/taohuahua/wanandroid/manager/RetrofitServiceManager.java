package com.taohuahua.wanandroid.manager;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit 管理类
 */
public class RetrofitServiceManager {
    private static final int TIME_OUT = 30; //seconds

    public static class InstanceHolder {
        private static final OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

        public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
    }

    public static OkHttpClient getHttpClient() {
        return InstanceHolder.httpClient;
    }
}
