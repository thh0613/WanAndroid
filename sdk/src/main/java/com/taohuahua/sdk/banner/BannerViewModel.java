package com.taohuahua.sdk.banner;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.taohuahua.sdk.Resource;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * banner
 */
public class BannerViewModel extends ViewModel {
    private BannerRepository mBannerRepository;
    public LiveData<Resource<List<BannerEntity>>> bannerResponse = new MutableLiveData<>();

    public BannerViewModel() {
        mBannerRepository = new BannerRepository();
        getBannerResponse();
    }

    public LiveData<Resource<List<BannerEntity>>> getBannerList() {
        return bannerResponse;
    }

    private void getBannerResponse() {
        if (bannerResponse.getValue() == null) {
            loadBanner();
        }
    }

    private void loadBanner() {
        bannerResponse = LiveDataReactiveStreams.fromPublisher(mBannerRepository.getBannerList().observeOn(AndroidSchedulers.mainThread()));
    }

}
