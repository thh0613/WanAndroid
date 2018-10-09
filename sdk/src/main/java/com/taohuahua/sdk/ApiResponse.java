package com.taohuahua.sdk;

import android.text.TextUtils;

public class ApiResponse<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    boolean isSuccessful() {
        return TextUtils.isEmpty(errorMsg);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
