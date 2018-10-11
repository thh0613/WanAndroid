package com.taohuahua.sdk.manager;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

/**
 * 实现生命周期的监听
 */
public class ViewLifeObserver implements LifecycleObserver {
    private View mLifeView;

    public ViewLifeObserver(View view) {
        mLifeView = view;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.i("thh", "onResume");
        mLifeView.setBackgroundColor(Color.parseColor("#ff0000"));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        mLifeView.setBackgroundColor(Color.parseColor("#000000"));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }
}
