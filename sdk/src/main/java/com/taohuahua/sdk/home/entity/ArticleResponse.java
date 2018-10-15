package com.taohuahua.sdk.home.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章data实体
 */
public class ArticleResponse {
    @SerializedName("curPage")
    private int mCurPage;

    @SerializedName("datas")
    private List<ArticleEntity> mArticleList;

    @SerializedName("offset")
    private int mOffset;

    @SerializedName("over")
    private boolean mIsOver;

    @SerializedName("pageCount")
    private int mPageCount;

    @SerializedName("size")
    private int mSize;

    @SerializedName("total")
    private int mTotal;

    public int getCurPage() {
        return mCurPage;
    }

    public List<ArticleEntity> getArticleList() {
        if (mArticleList == null) {
            return new ArrayList<>();
        }
        return mArticleList;
    }

    public int getOffset() {
        return mOffset;
    }

    public boolean isOver() {
        return mIsOver;
    }

    public int getPageCount() {
        return mPageCount;
    }

    public int getSize() {
        return mSize;
    }

    public int getTotal() {
        return mTotal;
    }
}
