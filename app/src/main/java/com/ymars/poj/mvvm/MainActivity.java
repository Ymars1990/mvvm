package com.ymars.poj.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ymars.poj.base.obsever.MyLifecycleObserver;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MyLifecycleObserver(TAG));
    }
}