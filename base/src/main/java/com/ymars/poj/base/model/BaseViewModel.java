package com.ymars.poj.base.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ymars.poj.base.apiservice.BaseApiService;
import com.ymars.poj.base.repository.BaseRepository;

public class BaseViewModel<T extends BaseApiService> extends AndroidViewModel {
    protected  String TAG = BaseViewModel.class.getSimpleName();
    protected T apiService;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        TAG = this.getClass().getSimpleName();
    }

}