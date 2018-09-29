package com.taohuahua.wanandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.taohuahua.wanandroid.BaseFragment;

import java.util.List;

/**
 * 首页底部tab
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
