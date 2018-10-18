package com.eastmoney.mars.modulebase.base

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * BaseFragment
 */
abstract class BaseFragment : Fragment(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finishOnCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(getLayoutResId(), null, false)
        findView(rootView)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        beforeInitView()
        initView()
        finishInitView()
    }

    open fun finishOnCreate() {

    }

    open fun finishInitView() {

    }

    open fun beforeInitView() {

    }

    abstract fun getLayoutResId(): Int
    abstract fun findView(rootView: View)
    abstract fun initView()

    fun AppCompatActivity.toast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}