package com.ymars.poj.home.ui;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.base.BaseApplication;
import com.ymars.poj.base.ui.BaseFragment;
import com.ymars.poj.home.R;
import com.ymars.poj.home.databinding.FragmentHomeBinding;
import com.ymars.poj.home.ui.adapter.BannerViewHolder;
import com.ymars.poj.home.ui.adapter.HomeBannerAdapter;
import com.ymars.poj.home.ui.viewmodel.HomeViewModel;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements BannerViewPager.OnPageClickListener {
    private HomeViewModel homeViewModel;
    private BannerViewPager<BannerBean, BannerViewHolder> bannerViewPager;
    private RecyclerView articleRv;
    private HomeBannerAdapter bannerAdapter;
    private ArrayList<BannerBean> bannerBeans;

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
                .setIndicatorSliderGap(getResources().getDimensionPixelOffset(R.dimen.dp4))
                .setIndicatorSliderWidth(getResources().getDimensionPixelOffset(R.dimen.dp4), getResources().getDimensionPixelOffset(R.dimen.dp10))
                .setIndicatorSliderColor(getResources().getColor(R.color.gray), getResources().getColor(R.color.colorPrimary))
                .setOrientation(ViewPager2.ORIENTATION_VERTICAL)
                .setInterval(3000)
                .setAdapter(bannerAdapter)
                .registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                    }
                }).create(bannerBeans);

        articleRv = mVbinding.articleRv;
    }

    @Override
    protected void doWork() {
//        homeRepository.getArticleDataBean(0);
        bannerBeans.clear();
//        homeViewModel.getmArticleDataBean().observe(getViewLifecycleOwner(),);
        homeViewModel.getBannerBean();
//            bannerBeans.addAll(homeRepository.getBannerBean().getValue());

        bannerViewPager.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        bannerAdapter = new HomeBannerAdapter();
        bannerBeans = new ArrayList<>();
        homeViewModel = new HomeViewModel(BaseApplication.getInstance());
    }

    @Override
    public void onPageClick(int position) {

    }
}