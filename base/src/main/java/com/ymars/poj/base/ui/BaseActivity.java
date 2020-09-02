package com.ymars.poj.base.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.ymars.poj.base.obsever.MyLifecycleObserver;
import com.ymars.poj.comutils.LogTools;

/**
 * @author Mars
 * 基类Activity
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener {
    protected final String TAG = this.getClass().getSimpleName();
    protected Context mCtx;
    protected T viewBinding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        viewBinding = DataBindingUtil.setContentView(this, setLayoutId(savedInstanceState));
        getLifecycle().addObserver(new MyLifecycleObserver(TAG));
        initView();
    }

    @Override
    public void onClick(View v) {

    }

    protected abstract int setLayoutId(@Nullable Bundle savedInstanceState);
    protected abstract void initView();


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogTools.i(TAG, "onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogTools.i(TAG, "onNewIntent");
    }
}