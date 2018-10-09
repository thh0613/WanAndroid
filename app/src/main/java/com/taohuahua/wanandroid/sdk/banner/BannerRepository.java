package com.taohuahua.wanandroid.sdk.banner;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.taohuahua.sdk.ApiResponse;
import com.taohuahua.sdk.NetworkBoundResource;
import com.taohuahua.sdk.Resource;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;


/**
 * 仓库
 * Repository 模块负责数据处理，
 * 为应用的其他部分提供干净可靠的 API。
 * 你可以将其考虑为不同数据源（Web，缓存或数据库）与应用之间的中间层。
 */
public class BannerRepository {
    private BannerServiceImpl mBannerService;

    public BannerRepository() {
        if (mBannerService == null) {
            mBannerService = new BannerServiceImpl();
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
                return mBannerService.getHomeBanner();
            }
        }.getAsLiveData().toFlowable(BackpressureStrategy.BUFFER);

    }
}
