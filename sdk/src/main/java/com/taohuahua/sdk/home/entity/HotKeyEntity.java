package com.taohuahua.sdk.home.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 搜索热词
 */
public class HotKeyEntity {
   /* id: 6,
    link: "",
    name: "面试",
    order: 1,
    visible: 1*/

   @SerializedName("id")
   private int mKeyId;

   @SerializedName("link")
   private String mKeyLink;

   @SerializedName("name")
   private String  mKeyName;

   @SerializedName("order")
   private int mOrder;

   @SerializedName("visible")
   private int mVisible;


    @Override
    public String toString() {
        return "hotkey = " + "id = " + mKeyId
                + "\n mKeyLink = " + mKeyLink
                + "\n mKeyName = " + mKeyName
                + "\n mOrder = " + mOrder
                + "\n mVisible = " + mVisible;
    }

    public int getKeyId() {
        return mKeyId;
    }

    public void setKeyId(int keyId) {
        mKeyId = keyId;
    }

    public String getKeyLink() {
        return mKeyLink == null ? "" : mKeyLink;
    }

    public void setKeyLink(String keyLink) {
        mKeyLink = keyLink;
    }

    public String getKeyName() {
        return mKeyName == null ? "" : mKeyName;
    }

    public void setKeyName(String keyName) {
        mKeyName = keyName;
    }

    public int getOrder() {
        return mOrder;
    }

    public void setOrder(int order) {
        mOrder = order;
    }

    public int getVisible() {
        return mVisible;
    }

    public void setVisible(int visible) {
        mVisible = visible;
    }
}
