package com.taohuahua.wanandroid;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.taohuahua.wanandroid.sdk.banner.BannerViewModel;

/**
 * fragment的基类
 */
public class BaseFragment extends Fragment implements LifecycleOwner {
    private LifecycleRegistry registry = new LifecycleRegistry(this);
    private BannerViewModel mBannerViewModel;
    private Button mBtnClicked;

    @Override
    public Lifecycle getLifecycle() {
        return registry;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mBtnClicked.setOnClickListener(v -> mBannerViewModel.getBannerList().observe(getActivity(), listResource -> Log.i("thh", "onChanged")));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        initView(rootView);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView(View rootView) {
        mBtnClicked = rootView.findViewById(R.id.btn);
        mBannerViewModel = ViewModelProviders.of(getActivity()).get(BannerViewModel.class);
    }

}
