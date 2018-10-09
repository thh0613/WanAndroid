package com.taohuahua.sdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Resource<T> {
    @NonNull
    public final int status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private Resource(@NonNull int status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Nullable
    public T getData() {
        return data;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }
}