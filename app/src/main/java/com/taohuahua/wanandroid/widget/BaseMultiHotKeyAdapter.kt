package com.taohuahua.wanandroid.widget

import android.util.SparseArray
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.taohuahua.sdk.home.entity.HotKeyEntity
import kotlin.math.absoluteValue

abstract class BaseMultiHotKeyAdapter<T : HotKeyEntity, K : BaseViewHolder> : BaseQuickAdapter<T, K> {
    constructor(layoutResId: Int, dataList: List<T>) : super(layoutResId, dataList)

    var layouts: SparseArray<Int> = SparseArray()

    override fun getDefItemViewType(position: Int): Int {
        return 0
    }

    override fun onCreateDefViewHolder(parent: ViewGroup?, viewType: Int): K {
        return this.createBaseViewHolder(parent, getLayoutId(viewType))
    }

    open fun addItemType(type: Int, layoutResId: Int) {
        layouts.put(type, layoutResId)
    }

    override fun convert(helper: K, item: T) {
        convertMulti(helper, item)
    }

    override fun onBindViewHolder(holder: K, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position)
        } else {
            when (holder.itemViewType) {
                HEADER_VIEW, FOOTER_VIEW, LOADING_VIEW, EMPTY_VIEW -> {
                }
                else -> {
                    this.convertPart(holder, position, payloads)
                }
            }
        }
    }

    fun getLayoutId(viewType: Int): Int {
        return this.layouts[viewType].absoluteValue
    }

    abstract fun convertPart(holder: K, position: Int, payloads: List<Any>)
    abstract fun convertMulti(helper: K, item: T)
}