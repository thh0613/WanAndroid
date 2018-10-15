package com.taohuahua.wanandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.taohuahua.sdk.home.entity.BannerEntity;
import com.taohuahua.wanandroid.R;
import com.taohuahua.wanandroid.widget.RecyclingPagerAdapter;

import java.util.List;

/**
 * banner adapter
 */
public class BannerAdapter extends RecyclingPagerAdapter {
    private final int FAKE_BANNER_SIZE = 100;
    private List<BannerEntity> mBannerViewList;
    private Context mContext;

    public BannerAdapter(Context context, List<BannerEntity> bannerList) {
        mContext = context;
        mBannerViewList = bannerList;
    }

    @Override
    public int getCount() {
        if (mBannerViewList.size() == 0 || mBannerViewList.size() == 1) {
            return mBannerViewList.size();
        } else {
            return FAKE_BANNER_SIZE;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup container) {
       ViewHolder viewHolder;
       View view;
        if (mBannerViewList.size() <= 0) {
            return new View(mContext);
        }

       position = position % mBannerViewList.size();
       BannerEntity bannerEntity = mBannerViewList.get(position);
       if (convertView == null) {
           view = LayoutInflater.from(mContext).inflate(R.layout.item_banner, container, false);
           viewHolder = new ViewHolder(view);
           view.setTag(viewHolder);
       } else {
           view = convertView;
           viewHolder = (ViewHolder) view.getTag();
       }

       viewHolder.bannerView.setImageURI(bannerEntity.getImagePath());
       return view;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    public void setBannerViewList(List<BannerEntity> bannerViewList) {
        mBannerViewList = bannerViewList;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        final SimpleDraweeView bannerView;

        public ViewHolder(View view) {
            bannerView = view.findViewById(R.id.banner_view);
        }
    }
}
