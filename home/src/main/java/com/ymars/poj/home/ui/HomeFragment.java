package com.ymars.poj.home.ui;

import com.ymars.poj.base.ui.BaseFragment;
import com.ymars.poj.home.R;
import com.ymars.poj.home.ui.network.HomeRepository;

public class HomeFragment extends BaseFragment {
    private HomeRepository homeRepository;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doWork() {
        homeRepository.getArticleDataBean(0);
    }

    @Override
    protected void initData() {
        homeRepository = new HomeRepository();
    }


}