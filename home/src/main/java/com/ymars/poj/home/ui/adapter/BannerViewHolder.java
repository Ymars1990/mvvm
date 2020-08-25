package com.ymars.poj.home.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.home.R;
import com.zhpan.bannerview.BaseViewHolder;

public class BannerViewHolder extends BaseViewHolder<BannerBean> {

    public BannerViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(BannerBean data, int position, int pageSize) {
        ImageView imageView = findView(R.id.bannerIv);
        Glide.with(imageView).load(data.getUrl()).into(imageView);
    }
}