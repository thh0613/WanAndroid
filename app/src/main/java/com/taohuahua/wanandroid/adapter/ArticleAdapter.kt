package com.taohuahua.wanandroid.adapter

import android.content.Context
import com.taohuahua.sdk.home.entity.ArticleEntity
import com.taohuahua.wanandroid.R
import com.taohuahua.wanandroid.widget.ArticleDetailView
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder

/**
 * 首页文章列表
 */
class ArticleAdapter(context: Context, layoutId: Int, articleEntityList: List<ArticleEntity>)
    : CommonAdapter<ArticleEntity>(context, layoutId, articleEntityList) {

    override fun convert(holder: ViewHolder?, articleEntity: ArticleEntity?, position: Int) {
        articleEntity?.run {
            holder?.run {
                setImageResource(R.id.collect, if (isCollect)
                    R.drawable.ic_collect_pressed else R.drawable.ic_collect_normal)
                setText(R.id.article_name, title)
                var articleDetailView: ArticleDetailView = getView(R.id.article_detail)
                articleDetailView.setDetailView(articleEntity)
            }
        }
    }

}