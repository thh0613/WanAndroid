package com.taohuahua.sdk;

import android.support.annotation.IntDef;
import android.support.annotation.Keep;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.taohuahua.sdk.Status.ERROR;
import static com.taohuahua.sdk.Status.LOADING;
import static com.taohuahua.sdk.Status.SUCCESS;


/**
 * 选项卡状态
 * Created by taohuahua on 18/1/12.
 */

@Keep
@Retention(RetentionPolicy.SOURCE)
@IntDef({SUCCESS, LOADING, ERROR})
public @interface Status {
    int SUCCESS = 0;
    int LOADING = 1;
    int ERROR = 2;
}
