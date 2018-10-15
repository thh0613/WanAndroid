package com.taohuahua.wanandroid.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taohuahua.sdk.home.HomeViewModel;
import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.widget.BannerSlideView;

/**
 * 首页
 */
public class HomeMainFragment extends BaseFragment {
    private HomeViewModel mHomeViewModel;
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
        getLifecycle().addObserver(mBannerSlideView);
        initView();
    }

    private void initView() {
        mHomeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        mHomeViewModel.getBannerList().observe(getActivity(),
                bannerData -> {
                    if (bannerData != null) {
                        mBannerSlideView.setBannerData(bannerData.data);
                    }
                });

        mHomeViewModel.getHotKeyList().observe(getActivity(), hotKeyData -> {
            if (hotKeyData != null) {
               Log.i("thh", "hotKey == " + hotKeyData.data.toString());
            }
        });

        mHomeViewModel.getHomeArticleResponse().observe(getActivity(), articleRes -> {
            if (articleRes.data != null) {
                Log.i("thh", "homeArticleRes == " + articleRes.data.getArticleList());
            }
        });

        mHomeViewModel.getSearchResponse("kotlin").observe(getActivity(), articleRes -> {
            if (articleRes.data != null) {
                Log.i("thh", "searchdata == " + articleRes.data.getArticleList());
            }
        });


    }
}
