package com.taohuahua.wanandroid.sdk.banner;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.taohuahua.sdk.Resource;

import java.util.List;

/**
 * banner
 */
public class BannerViewModel extends ViewModel {
    private BannerRepository mBannerRepository;
    public MutableLiveData<Resource<List<BannerEntity>>> bannerResponse = new MutableLiveData<>();

    public BannerViewModel() {
        mBannerRepository = new BannerRepository();
        getBannerResponse();
    }

    public MutableLiveData<Resource<List<BannerEntity>>> getBannerList() {
        return bannerResponse;
    }

    private void getBannerResponse() {
        if (bannerResponse.getValue() == null) {
            loadBanner();
        }
    }

    private void loadBanner() {
        bannerResponse.setValue(LiveDataReactiveStreams.fromPublisher(mBannerRepository
                .getBannerList()).getValue());
    }

}
