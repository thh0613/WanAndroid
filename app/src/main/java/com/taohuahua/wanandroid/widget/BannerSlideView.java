package com.taohuahua.wanandroid.widget;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.taohuahua.sdk.banner.BannerEntity;
import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.adapter.BannerAdapter;
import com.taohuahua.wanandroid.simplelistener.SimplePageChangeListener;
import com.taohuahua.wanandroid.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * banner轮播图组件
 */
public class BannerSlideView extends ConstraintLayout {
    private static final long SCROLL_TIME_OFFSET = 3000;
    private BannerAdapter mBannerAdapter;
    private LinearLayout mDotContainer;
    private ViewPager mBannerViewPager;
    private List<BannerEntity> mBannerList;

    public BannerSlideView(Context context) {
        super(context);
    }

    public BannerSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        findView();
        initView();
    }

    private void findView() {
        mBannerViewPager = findViewById(R.id.banner_view_pager);
        mDotContainer = findViewById(R.id.dot_container);
    }

    private void initView() {
        mBannerAdapter = new BannerAdapter(getContext(), new ArrayList<>());
        mBannerViewPager.setAdapter(mBannerAdapter);
        mBannerViewPager.setCurrentItem(0);
        mBannerViewPager.addOnPageChangeListener(new SimplePageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (mBannerList.size() <= 0) {
                    return;
                }

                for (int idx = 0; idx < mDotContainer.getChildCount(); idx++) {
                    mDotContainer.getChildAt(idx).setEnabled(false);
                }

                if (mDotContainer.getChildAt(position) != null) {
                    mDotContainer.getChildAt(position).setEnabled(true);
                }
            }
        });
    }

    public void setBannerData(List<BannerEntity> bannerEntityList) {
        if (bannerEntityList != null && bannerEntityList.size() > 0) {
            mBannerAdapter.setBannerViewList(bannerEntityList);
            mBannerViewPager.setCurrentItem(0);
            mBannerList = bannerEntityList;
            mDotContainer.removeAllViews();
            int size = bannerEntityList.size();
            if (size > 1) {
                for (int idx = 0; idx < size; idx++) {
                    View dot = new View(getContext());
                    dot.setBackgroundResource(R.drawable.dot_bg_selector);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                            (DensityUtil.dip2px(6), DensityUtil.dip2px(6));
                    layoutParams.rightMargin = DensityUtil.dip2px(6);
                    dot.setEnabled(false);
                    mDotContainer.addView(dot, layoutParams);
                }
            }
        }
    }
}
