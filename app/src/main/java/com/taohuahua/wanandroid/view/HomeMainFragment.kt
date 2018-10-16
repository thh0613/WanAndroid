package com.taohuahua.wanandroid.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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

class HomeMainFragment : BaseFragment() {
    lateinit var mHomeViewModel: HomeViewModel
    lateinit var mBannerSlideView: BannerSlideView
    lateinit var mArticleRecycle: RecyclerView
    lateinit var mArticleAdapter: ArticleAdapter

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
            mBannerSlideView = findViewById(R.id.fragment_home_banner)
            mArticleRecycle = findViewById(R.id.home_article_list)
            lifecycle.addObserver(mBannerSlideView)
        }

        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mArticleRecycle.layoutManager = layoutManager
    }

    fun getData() {
        mHomeViewModel.bannerList.observe(activity!!, Observer { it ->
            mBannerSlideView.setBannerData(it?.data)
        })

        mHomeViewModel.homeArticleResponse.observe(activity!!, Observer { it ->
            if (it?.data != null) {
                mArticleAdapter = ArticleAdapter(context!!, R.layout.item_article, it.data!!.articleList)
                mArticleRecycle.adapter = mArticleAdapter
            }
        })

        /**
         *  mHomeViewModel.getHotKeyList().observe(getActivity(), hotKeyData -> {
        if (hotKeyData != null) {
        Log.i("thh", "hotKey == " + hotKeyData.data.toString());
        }
        });

        mHomeViewModel.getHomeArticleResponse().observe(getActivity(), articleRes -> {
        if (articleRes.data != null) {
        Log.i("thh", "homeArticleRes == " + articleRes.data.getArticleList());
        }
        });

        mHomeViewModel.getSearchResponse("kotlin").observe(getActivity(), articleRes -> {
        if (articleRes.data != null) {
        Log.i("thh", "searchdata == " + articleRes.data.getArticleList());
        }
        });
         */
    }
}