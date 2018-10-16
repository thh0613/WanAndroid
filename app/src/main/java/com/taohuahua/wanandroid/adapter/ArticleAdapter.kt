package com.taohuahua.wanandroid.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.taohuahua.sdk.home.entity.ArticleEntity
import com.taohuahua.wanandroid.R
import com.taohuahua.wanandroid.widget.ArticleDetailView


/**
 * 首页文章列表
 */
class ArticleAdapter(layoutRes:Int, articleEntityList:ArrayList<ArticleEntity>)
    : BaseQuickAdapter<ArticleEntity, BaseViewHolder>(layoutRes, articleEntityList) {

    override fun convert(viewHolder: BaseViewHolder?, item: ArticleEntity?) {
        item?.run {
            viewHolder?.run {
                setImageResource(R.id.collect, if (isCollect)
                    R.drawable.ic_collect_pressed else R.drawable.ic_collect_normal)
                setText(R.id.article_name, title)
                var articleDetailView: ArticleDetailView = getView(R.id.article_detail)
                articleDetailView.setDetailView(item)
            }
        }
    }
}