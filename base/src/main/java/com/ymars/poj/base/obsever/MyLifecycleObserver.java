package com.ymars.poj.base.obsever;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.ymars.poj.comutils.LogTools;

/**
 * @author Mars
 * 生命周期监听
 */
public class MyLifecycleObserver implements DefaultLifecycleObserver {
    private String TAG = this.getClass().getSimpleName();

    public MyLifecycleObserver() {
    }

    public MyLifecycleObserver(String tag) {
        TAG= tag;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onCreate");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onDestroy");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onPause");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onResume");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onStart");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        LogTools.i(TAG+"--Lifecycle", "onStop");
    }
}
