package com.taohuahua.wanandroid.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.flexbox.FlexboxLayoutManager
import com.taohuahua.sdk.home.HomeViewModel
import com.taohuahua.sdk.home.entity.HotKeyEntity
import com.taohuahua.sdk.home.entity.HotWebsiteEntity
import com.taohuahua.wanandroid.R
import com.taohuahua.wanandroid.adapter.SearchHintAdapter

class SearchFragment : BaseFragment() {
    lateinit var mHomeViewModel: HomeViewModel

    lateinit var mHistoryDivider: View
    lateinit var mHotKeyDivider: View

    lateinit var mHistoryTv: TextView
    lateinit var mHotKeyTv: TextView
    lateinit var mWebsiteTv: TextView

    lateinit var mHistoryList: RecyclerView
    lateinit var mHotList: RecyclerView
    lateinit var mWebsiteList: RecyclerView

    lateinit var mHistoryAdapter: SearchHintAdapter<HotKeyEntity>
    lateinit var mHotKeyAdapter: SearchHintAdapter<HotKeyEntity>
    lateinit var mWebsiteAdapter: SearchHintAdapter<HotWebsiteEntity>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_search, container, false)
        findView(rootView)
        initView()
        initAdapterData()
        return rootView
    }

    fun findView(rootView: View) {
        with(rootView) {
            mHistoryTv = findViewById(R.id.history_hint)
            mHistoryList = findViewById(R.id.history_list)
            mHistoryDivider = findViewById(R.id.divider_history)

            mHotKeyTv = findViewById(R.id.hot_search_hint)
            mHotList = findViewById(R.id.hot_search_list)
            mHotKeyDivider = findViewById(R.id.divider_hot_key)

            mWebsiteTv = findViewById(R.id.hot_website_hint)
            mWebsiteList = findViewById(R.id.hot_website_list)
        }

        mHomeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        mHistoryAdapter = SearchHintAdapter(R.layout.item_search, arrayListOf())
        mHotKeyAdapter = SearchHintAdapter(R.layout.item_search, arrayListOf())
        mWebsiteAdapter = SearchHintAdapter(R.layout.item_search, arrayListOf(), true)
    }

    fun initView() {
        val layoutManager = FlexboxLayoutManager(context)
        mHistoryList.layoutManager = layoutManager
        mHotList.layoutManager = FlexboxLayoutManager(context)
        mWebsiteList.layoutManager = FlexboxLayoutManager(context)

        mHotList.adapter = mHotKeyAdapter
        mWebsiteList.adapter = mWebsiteAdapter
    }

    fun initAdapterData() {
        mHomeViewModel.hotKeyList.observe(activity!!, Observer { hotKeyRes -> mHotKeyAdapter.setNewData(hotKeyRes!!.data) })
        mHomeViewModel.hotWebsiteResponse.observe(activity!!, Observer { hotWebsiteRes -> mWebsiteAdapter.setNewData(hotWebsiteRes!!.data) })
    }
}