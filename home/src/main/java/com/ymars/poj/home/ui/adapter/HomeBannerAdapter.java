package com.ymars.poj.home.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.home.R;
import com.zhpan.bannerview.BaseBannerAdapter;

public class HomeBannerAdapter extends BaseBannerAdapter<BannerBean, BannerViewHolder> {

    @Override
    protected void onBind(BannerViewHolder holder, BannerBean data, int position, int pageSize) {
        holder.bindData(data, position, pageSize);
        ImageView bannerIv = holder.itemView.findViewById(R.id.bannerIv);
        Glide.with(holder.itemView).load(data.getImagePath()).into(bannerIv);
    }

    @Override
    public BannerViewHolder createViewHolder(View itemView, int viewType) {

        return new BannerViewHolder(itemView);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.home_banner;
    }


}