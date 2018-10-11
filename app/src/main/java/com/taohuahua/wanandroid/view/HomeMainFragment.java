package com.taohuahua.wanandroid.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taohuahua.sdk.banner.BannerViewModel;
import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.widget.BannerSlideView;

/**
 * 首页
 */
public class HomeMainFragment extends Fragment {
    private BannerViewModel mBannerViewModel;
    private BannerSlideView mBannerSlideView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_main, container, false);
        findView(rootView);
        return rootView;
    }

    private void findView(View rootView) {
        mBannerSlideView = rootView.findViewById(R.id.fragment_home_banner);
        initView();
    }

    private void initView() {
        mBannerViewModel = ViewModelProviders.of(getActivity()).get(BannerViewModel.class);
        mBannerViewModel.getBannerList().observe(getActivity(),
                bannerData -> {
                    if (bannerData != null) {
                        mBannerSlideView.setBannerData(bannerData.data);
                    }
                });
    }
}
