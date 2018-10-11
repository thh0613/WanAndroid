package com.taohuahua.wanandroid.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taohuahua.wanandroid.R;


/**
 * fragment的基类
 */
public class BaseFragment extends Fragment implements LifecycleOwner {
    private LifecycleRegistry registry = new LifecycleRegistry(this);

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

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
