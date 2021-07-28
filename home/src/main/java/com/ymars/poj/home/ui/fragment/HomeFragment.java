package com.ymars.poj.home.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.ymars.mvvm.poj.businesscom.bean.ArticleBean;
import com.ymars.mvvm.poj.businesscom.bean.ArticleDataBean;
import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.base.BaseApplication;
import com.ymars.poj.base.ui.BaseFragment;
import com.ymars.poj.component.interf.RvItemOnclicker;
import com.ymars.poj.comutils.LogTools;
import com.ymars.poj.home.R;
import com.ymars.poj.home.databinding.FragmentHomeBinding;
import com.ymars.poj.home.adapter.ArticleAdapter;
import com.ymars.poj.home.adapter.BannerViewHolder;
import com.ymars.poj.home.adapter.HomeBannerAdapter;
import com.ymars.poj.home.viewmodel.HomeViewModel;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements BannerViewPager.OnPageClickListener, RvItemOnclicker<ArticleBean>, OnRefreshLoadMoreListener {
    private HomeViewModel homeViewModel;
    private BannerViewPager<BannerBean, BannerViewHolder> bannerViewPager;
    private RecyclerView articleRv;
    private HomeBannerAdapter bannerAdapter;
    private ArrayList<BannerBean> bannerBeans;


    private ArticleAdapter articleAdapter;
    private ArrayList<ArticleBean> articleBeans;
    private int page = 0;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        bannerViewPager = mVbinding.banner;
        bannerViewPager
                .setAutoPlay(true)
                .setScrollDuration(800)
                .setIndicatorStyle(IndicatorStyle.ROUND_RECT)
                .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                .setIndicatorSliderGap(getResources().getDimensionPixelOffset(R.dimen.dp4))
                .setIndicatorSliderWidth(getResources().getDimensionPixelOffset(R.dimen.dp4), getResources().getDimensionPixelOffset(R.dimen.dp10))
                .setIndicatorSliderColor(getResources().getColor(R.color.gray), getResources().getColor(R.color.colorPrimary))
                .setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
                .setInterval(3000)
                .setAdapter(bannerAdapter)
                .registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                    }
                }).create(bannerBeans);

        articleRv = mVbinding.articleRv;
        articleRv.setLayoutManager(new LinearLayoutManager(mCtx));
        articleRv.setAdapter(articleAdapter);

        mVbinding.srl.setEnableAutoLoadMore(false);
        mVbinding.srl.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void doWork() {
        homeViewModel.getArticleDataBean(page);

        homeViewModel.getBannerBean();
        homeViewModel.getmBannerBean().observe(getViewLifecycleOwner(), new Observer<List<BannerBean>>() {
            @Override
            public void onChanged(List<BannerBean> banners) {
                LogTools.i(TAG, String.format("Banner Data Change:%s", banners.toString()));
                bannerBeans.clear();
                mVbinding.srl.finishLoadMore();
                mVbinding.srl.finishRefresh();
                bannerBeans.addAll(banners);
                bannerViewPager.refreshData(bannerBeans);
                bannerViewPager.getAdapter().notifyDataSetChanged();
            }
        });

        homeViewModel.getmArticleDataBean().observe(getViewLifecycleOwner(), new Observer<ArticleDataBean>() {
            @Override
            public void onChanged(ArticleDataBean articleDataBean) {
                mVbinding.srl.finishLoadMore();
                mVbinding.srl.finishRefresh();
                LogTools.i(TAG, String.format("Article Data Change:%s", articleDataBean.toString()));
                if (page == 0) {
                    articleBeans.clear();
                }
                if (articleDataBean.getDatas() != null) {
                    if (articleDataBean.getDatas().size() >= 20) {
                        page++;
                    }
                    articleBeans.addAll(articleDataBean.getDatas());
                    articleAdapter.notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    protected void initData() {
        bannerAdapter = new HomeBannerAdapter();

        bannerBeans = new ArrayList<>();
        homeViewModel = new HomeViewModel(BaseApplication.getInstance());
        articleBeans = new ArrayList<>();
        articleAdapter = new ArticleAdapter(articleBeans, this, mCtx);
    }

    @Override
    public void onPageClick(int position) {
        LogTools.i(TAG, String.format("Banner OnClick:%s", bannerBeans.get(position).toString()));
    }

    @Override
    public void onRvItemClick(ArticleBean data, View v, int pos) {
        LogTools.i(TAG, data.toString());
        ARouter.getInstance().build("/home/TestActivity").withString("url", data.getLink()).navigation();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        homeViewModel.getArticleDataBean(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 0;
        homeViewModel.getBannerBean();
        homeViewModel.getArticleDataBean(page);
    }
}