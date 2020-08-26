package com.ymars.poj.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.ymars.poj.comutils.LogTools;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected String TAG = null;
    protected T mVbinding;

    protected Context mCtx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCtx = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TAG = this.getClass().getSimpleName();
        mVbinding = DataBindingUtil.inflate(inflater, setLayoutId(), container, false);
        initData();
        initView();
        if (mVbinding != null) {
            return mVbinding.getRoot();
        } else {
            return inflater.inflate(setLayoutId(), container, false);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogTools.e(TAG, "onActivityCreated");
        doWork();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void doWork();

    protected abstract void initData();
}