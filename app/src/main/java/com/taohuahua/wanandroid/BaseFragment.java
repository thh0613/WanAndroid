package com.taohuahua.wanandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taohuahua.wanandroid.sdk.banner.BannerEntity;
import com.taohuahua.wanandroid.sdk.banner.BannerResponse;
import com.taohuahua.wanandroid.sdk.banner.BannerServiceImpl;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * fragment的基类
 */
public class BaseFragment extends Fragment {
    private BannerServiceImpl mService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        initView();
        return rootView;
    }

    @SuppressLint("CheckResult")
    private void initView() {
        mService = new BannerServiceImpl();
        mService.getHomeBanner().subscribe(new Consumer<BannerResponse>() {
            @Override
            public void accept(BannerResponse bannerResponse) throws Exception {
                Log.i("thh", bannerResponse.getData() + " ");
            }
        });
    }

}
