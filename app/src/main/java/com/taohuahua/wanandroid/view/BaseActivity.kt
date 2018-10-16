package com.taohuahua.wanandroid.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        finishOnCreate(savedInstanceState)
    }


    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        setStatusBar()
        beforeInitView()
        initView()
        finishInitView()
    }

    open fun setStatusBar() {
    }


    open fun beforeOnCreate(savedInstanceState: Bundle?) {

    }

    open fun finishOnCreate(savedInstanceState: Bundle?) {

    }

    open fun beforeInitView() {

    }

    open fun finishInitView() {

    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()


    fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.addFragment(frameId: Int, fragment: Fragment) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }


    fun AppCompatActivity.replaceFragment(frameId: Int, fragment: Fragment) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }
}

