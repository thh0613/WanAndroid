package com.taohuahua.wanandroid.view

import android.os.Bundle
import com.taohuahua.wanandroid.R

/**
 * 搜索activity
 */
class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_search_container, SearchFragment())
                .commit()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_search
    }

    override fun initView() {

    }

}