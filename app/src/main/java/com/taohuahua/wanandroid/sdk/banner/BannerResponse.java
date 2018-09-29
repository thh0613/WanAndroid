package com.taohuahua.wanandroid.sdk.banner;

import java.util.ArrayList;
import java.util.List;

/**
 * banner 返回的结果
 */
public class BannerResponse extends Response {
    private List<BannerEntity> data;

    public List<BannerEntity> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }

    public void setData(List<BannerEntity> data) {
        this.data = data;
    }
}
