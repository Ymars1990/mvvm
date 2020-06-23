package com.ymars.poj.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ymars.poj.comutils.LogTools;

public abstract class BaseFragment extends Fragment {
    protected View rootView = null;
    private String TAG =null ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TAG = this.getClass().getSimpleName();
        if (rootView == null) {
            rootView = inflater.inflate(setLayoutId(), container, false);
            initData();
            initView();
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogTools.e(TAG,"onActivityCreated" );
        doWork();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void doWork();

    protected abstract void initData();
}