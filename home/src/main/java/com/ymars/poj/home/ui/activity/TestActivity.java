package com.ymars.poj.home.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.ymars.poj.base.ui.BaseActivity;
import com.ymars.poj.home.R;

@Route(path = "/home/TestActivity")
public class TestActivity extends BaseActivity {


    SmartRefreshLayout srl;

    @Override
    protected int setLayoutId(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ImmersionBar.with(this).statusBarColor(com.ymars.poj.base.R.color.transparent).statusBarDarkFont(true).init();
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        srl = findViewById(R.id.srl);
//        srl.setEnableRefresh(false);
//        srl.setEnableLoadMore(false);
    }
}