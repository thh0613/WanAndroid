package com.taohuahua.wanandroid.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.taohuahua.sdk.home.entity.HotKeyEntity
import com.taohuahua.sdk.home.entity.HotWebsiteEntity
import com.taohuahua.wanandroid.R

/**
 * 搜索页面
 */
class SearchHintAdapter<T>(layoutResId: Int, data: List<T>)
    : BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data) {
    var isWebsite: Boolean = false

    constructor(layoutResId: Int, data: List<T>, isWebsite: Boolean) : this(layoutResId, data) {
        this.isWebsite = isWebsite
    }

    override fun convert(holder: BaseViewHolder?, item: T?) {
        if (this.isWebsite) {
            holder?.setText(R.id.search_name, (item as HotWebsiteEntity).name)
        } else {
            holder?.setText(R.id.search_name, (item as HotKeyEntity).name)
        }
    }

}