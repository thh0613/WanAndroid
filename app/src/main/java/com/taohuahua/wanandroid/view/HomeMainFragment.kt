package com.taohuahua.wanandroid.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taohuahua.sdk.home.HomeViewModel
import com.taohuahua.wanandroid.R
import com.taohuahua.wanandroid.adapter.ArticleAdapter
import com.taohuahua.wanandroid.widget.BannerSlideView
import com.taohuahua.wanandroid.widget.MsgView

class HomeMainFragment : BaseFragment() {
    lateinit var mHomeViewModel: HomeViewModel
    lateinit var mBannerSlideView: BannerSlideView
    lateinit var mArticleRecycle: RecyclerView
    lateinit var mArticleAdapter: ArticleAdapter
    lateinit var mSearchMsgView: MsgView

    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_home_main, container, false)
        findView(rootView)
        getData()
        return rootView
    }

    fun findView(rootView: View) {
        mHomeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        rootView.run {
            mSearchMsgView = findViewById(R.id.home_search_view)
            mBannerSlideView = LayoutInflater.from(context).inflate(R.layout.widget_banner_slide_view, null) as BannerSlideView
            mArticleRecycle = findViewById(R.id.home_article_list)
            lifecycle.addObserver(mBannerSlideView)
        }

        mSearchMsgView.setOnClickListener {
            var intent = Intent(activity!!, SearchActivity::class.java)
            startActivity(intent)
        }
        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mArticleRecycle.layoutManager = layoutManager
        mArticleAdapter = ArticleAdapter(R.layout.item_article, ArrayList())
        mArticleRecycle.adapter = mArticleAdapter
    }

    fun getData() {
        mHomeViewModel.bannerList.observe(activity!!, Observer { it ->
            mBannerSlideView.setBannerData(it?.data)
            mArticleAdapter.setHeaderView(mBannerSlideView)
            mArticleAdapter.setHeaderAndEmpty(true)
        })

        mHomeViewModel.homeArticleResponse.observe(activity!!, Observer { it ->
            if (it?.data != null) {
                mArticleAdapter.setNewData(it.data!!.articleList)
            }
        })
    }
}