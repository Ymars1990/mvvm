package com.ymars.poj.mvvm.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ymars.poj.base.ui.BaseActivity;
import com.ymars.poj.mvvm.R;
import com.ymars.poj.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    protected int setLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }
}