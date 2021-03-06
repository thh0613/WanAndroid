package com.taohuahua.wanandroid.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.adapter.ViewPagerAdapter;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeActivity extends BaseActivity {
    private static final int[] TAB_TITLES = new int[]{
            R.string.home_main,
            R.string.home_project,
            R.string.home_navi,
            R.string.home_me};

    private static final int[] TAB_IMGS = new int[]{
            R.drawable.tab_main_selector,
            R.drawable.tab_project_selector,
            R.drawable.tab_navi_selector,
            R.drawable.tab_me_selector
    };

    private List<BaseFragment> mTabFragments = new ArrayList<>();

    private HomeMainFragment mHomeMainFragment;
    private BaseFragment mHomeProjectFragment;
    private BaseFragment mHomeNaviFragment;
    private BaseFragment mHomeMeFragment;


    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    public void beforeInitView() {
        mViewPager = findViewById(R.id.home_view_pager);
        mTabLayout = findViewById(R.id.home_bottom_tab);
    }

    @Override
    public void initView() {
        setTabLayout();
        setViewPager();
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    private void setViewPager() {
        mHomeMainFragment = new HomeMainFragment();
        mHomeProjectFragment = new BaseFragment();
        mHomeNaviFragment = new BaseFragment();
        mHomeMeFragment = new BaseFragment();

        mTabFragments.add(mHomeMainFragment);
        mTabFragments.add(mHomeProjectFragment);
        mTabFragments.add(mHomeNaviFragment);
        mTabFragments.add(mHomeMeFragment);

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTabFragments);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    private void setTabLayout() {
        for (int i = 0; i < TAB_TITLES.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            View view = LayoutInflater.from(this).inflate(R.layout.item_bottom_tab, null);
            tab.setCustomView(view);


            TextView tv = view.findViewById(R.id.tab_text);
            ImageView img = view.findViewById(R.id.tab_img);

            tv.setText(TAB_TITLES[i]);
            img.setImageResource(TAB_IMGS[i]);
            mTabLayout.addTab(tab);
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_home;
    }
}
