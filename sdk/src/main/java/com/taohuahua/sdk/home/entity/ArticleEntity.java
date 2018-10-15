package com.taohuahua.sdk.home.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章数据
 */
public class ArticleEntity {
/*
     "apkLink": "",
     "author": "xfhy",
     "chapterId": 294,
     "chapterName": "完整项目",
     "collect": false,
     "courseId": 13,
     "desc": "收藏,评论,用户:增加,更新头像,签到等,产品,兴趣",
     "envelopePic": "http://www.wanandroid
     .com/blogimgs/3d414bfe-7296-4695-98e3-ed0692bfc063.png",
     "fresh": false,
     "id": 3054,
     "link": "http://www.wanandroid.com/blog/show/2173",
     "niceDate": "2018-06-24",
     "origin": "",
     "projectLink": "https://github.com/xfhy/LifeHelper",
     "publishTime": 1529853044000,
     "superChapterId": 294,
     "superChapterName": "开源项目主Tab",
     "tags": [
           {
                 "name": "项目",
                 "url": "/project/list/1?cid=294"
             }
        ],
    "title": "毕业设计(100%纯<em class='highlight'>kotlin</em>组件化开发)-LifeHelper",
    "type": 0,
    "userId": -1,
    "visible": 1,
    "zan": 0*/

    @SerializedName("apkLink")
    private String mApkLink;

    @SerializedName("author")
    private String mAuthor;

    @SerializedName("chapterId")
    private int mChapterId;

    @SerializedName("chapterName")
    private String mChapterName;

    @SerializedName("collect")
    private boolean mIsCollect;

    @SerializedName("courseId")
    private int mCourseId;

    @SerializedName("desc")
    private String mDesc;

    @SerializedName("envelopePic")
    private String mEnvelopePic;

    @SerializedName("fresh")
    private boolean mIsFresh;

    @SerializedName("id")
    private int mId;

    @SerializedName("link")
    private String mLink;

    @SerializedName("nickDate")
    private String mNiceDate;

    @SerializedName("origin")
    private String mOrigin;

    @SerializedName("projectLink")
    private String mProjectLink;

    @SerializedName("publishTime")
    private String mPublishTime;

    @SerializedName("superChapterId")
    private int mSuperChapterId;

    @SerializedName("superChapterName")
    private String mSuperChapterName;

    @SerializedName("tags")
    private List<TagEntity> mTags;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("type")
    private int mType;

    @SerializedName("userId")
    private int mUserId;

    @SerializedName("visible")
    private int mVisible;

    @SerializedName("zan")
    private int mZanCnt;

    public String getApkLink() {
        return mApkLink == null ? "" : mApkLink;
    }

    public String getAuthor() {
        return mAuthor == null ? "" : mAuthor;
    }

    public int getChapterId() {
        return mChapterId;
    }

    public String getChapterName() {
        return mChapterName == null ? "" : mChapterName;
    }

    public boolean isCollect() {
        return mIsCollect;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public String getDesc() {
        return mDesc == null ? "" : mDesc;
    }

    public String getEnvelopePic() {
        return mEnvelopePic == null ? "" : mEnvelopePic;
    }

    public boolean isFresh() {
        return mIsFresh;
    }

    public int getId() {
        return mId;
    }

    public String getLink() {
        return mLink == null ? "" : mLink;
    }

    public String getNiceDate() {
        return mNiceDate == null ? "" : mNiceDate;
    }

    public String getOrigin() {
        return mOrigin == null ? "" : mOrigin;
    }

    public String getProjectLink() {
        return mProjectLink == null ? "" : mProjectLink;
    }

    public String getPublishTime() {
        return mPublishTime == null ? "" : mPublishTime;
    }

    public int getSuperChapterId() {
        return mSuperChapterId;
    }

    public String getSuperChapterName() {
        return mSuperChapterName == null ? "" : mSuperChapterName;
    }

    public List<TagEntity> getTags() {
        if (mTags == null) {
            return new ArrayList<>();
        }
        return mTags;
    }

    public String getTitle() {
        return mTitle == null ? "" : mTitle;
    }

    public int getType() {
        return mType;
    }

    public int getUserId() {
        return mUserId;
    }

    public int getVisible() {
        return mVisible;
    }

    public int getZanCnt() {
        return mZanCnt;
    }

    @Override
    public String toString() {
        return "id ==  " + mId + " author == " + mAuthor + " desc==  " + mDesc
                + " chaptername == " + mChapterName + "  title == " + mTitle + "\n";
    }
}
