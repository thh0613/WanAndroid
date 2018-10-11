package com.taohuahua.wanandroid;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.taohuahua.wanandroid.util.ContextUtil;

public class HomeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Fresco.initialize(this);
        ContextUtil.init(this);
    }
}
