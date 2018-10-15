package com.taohuahua.sdk.home.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 标签
 */
public class TagEntity {

    @SerializedName("name")
    private String mTagName;

    @SerializedName("url")
    private String mTagUrl;

    public String getTagName() {
        return mTagName == null ? "" : mTagName;
    }

    public void setTagName(String tagName) {
        mTagName = tagName;
    }

    public String getTagUrl() {
        return mTagUrl == null ? "" : mTagUrl;
    }

    public void setTagUrl(String tagUrl) {
        mTagUrl = tagUrl;
    }
}
