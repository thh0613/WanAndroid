package com.taohuahua.wanandroid.widget

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.taohuahua.sdk.home.entity.ArticleEntity
import com.taohuahua.wanandroid.R
import com.taohuahua.wanandroid.util.DensityUtil
import com.taohuahua.wanandroid.util.TimeUtil

class ArticleDetailView : LinearLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    lateinit var mLabelContainer: LinearLayout
    lateinit var mFreshLabel: MsgView
    lateinit var mPublishTime: TextView
    lateinit var mAuthor: TextView
    lateinit var mCategory: TextView

    @Override
    override fun onFinishInflate() {
        super.onFinishInflate()
        findView()
    }

    fun findView() {
        mLabelContainer = findViewById(R.id.label_container)
        mPublishTime = findViewById(R.id.publish_time)
        mAuthor = findViewById(R.id.article_author)
        mCategory = findViewById(R.id.article_category)
        mFreshLabel = findViewById(R.id.fresh_label)
    }

    fun setDetailView(articleEntity: ArticleEntity) {
        with(articleEntity) {
            mFreshLabel.visibility = if (isFresh) View.VISIBLE else View.GONE
            mLabelContainer.removeAllViews()
            tags?.run {
                if (tags.size == 0) mLabelContainer.visibility = View.GONE
                for (tag in tags) {
                    var msgView = MsgView(context)
                    msgView.backgroundColor = Color.WHITE
                    msgView.cornerRadius = DensityUtil.dip2px(4.0f).toFloat()
                    msgView.strokeColor = ContextCompat.getColor(context, R.color.colorPrimary)
                    msgView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
                    msgView.strokeWidth = DensityUtil.dip2px(0.5f)
                    msgView.gravity = Gravity.CENTER
                    msgView.text = tag.tagName
                    msgView.textSize = 11.0f

                    var layoutParams = LayoutParams(DensityUtil.dip2px(50.0f), DensityUtil.dip2px(18.0f))
                    mLabelContainer.addView(msgView, layoutParams)
                }
            }
            mAuthor.text = "作者：" + author
            mPublishTime.text = TimeUtil.getTimeSpanFormatDate(publishTime.toLong())
            mCategory.text = "分类：" + superChapterName + "/" + chapterName
        }
    }
}