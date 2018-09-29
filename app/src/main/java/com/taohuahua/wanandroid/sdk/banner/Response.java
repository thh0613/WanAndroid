package com.taohuahua.wanandroid.sdk.banner;

import java.io.Serializable;

/**
 * 接口返回的基础类
 */
public class Response implements Serializable {
    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }
}
