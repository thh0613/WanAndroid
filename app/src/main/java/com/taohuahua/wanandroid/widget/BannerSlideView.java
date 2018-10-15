package com.taohuahua.wanandroid.widget;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.adapter.BannerAdapter;
import com.taohuahua.wanandroid.simplelistener.SimplePageChangeListener;
import com.taohuahua.wanandroid.util.DensityUtil;
import com.taohuahua.wanandroid.util.WeakHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * banner轮播图组件
 */
public class BannerSlideView extends ConstraintLayout implements LifecycleObserver {
    private static final long SCROLL_TIME_OFFSET = 3000;
    private BannerAdapter mBannerAdapter;
    private LinearLayout mDotContainer;
    private ViewPager mBannerViewPager;
    private List<BannerEntity> mBannerList;
    private WeakHandler mBannerHandler;
    private int mBannerPosition = 0;

    public BannerSlideView(Context context) {
        super(context);
    }

    public BannerSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        startAutoScroll();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        stopAutoScroll();
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

                int childCount = mDotContainer.getChildCount();
                for (int idx = 0; idx < childCount; idx++) {
                    mDotContainer.getChildAt(idx).setEnabled(false);
                }

                if (mDotContainer.getChildAt(position % childCount) != null) {
                    mDotContainer.getChildAt(position % childCount).setEnabled(true);
                }

                mBannerPosition = position % childCount;
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
            startAutoScroll();
        }
    }

    private void startAutoScroll() {
        if (mBannerHandler == null) {
            mBannerHandler = new WeakHandler();
        }

        mBannerHandler.removeCallbacksAndMessages(null);
        mBannerHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mDotContainer.getChildCount() == 0) {
                    return;
                }
                mBannerPosition = (mBannerPosition + 1) % mDotContainer.getChildCount();
                mBannerViewPager.setCurrentItem(mBannerPosition, true);
                mBannerHandler.postDelayed(this, SCROLL_TIME_OFFSET);

            }
        }, SCROLL_TIME_OFFSET);
    }

    private void stopAutoScroll() {
        if (mBannerHandler != null) {
            mBannerHandler.removeCallbacksAndMessages(null);
        }
    }
}
