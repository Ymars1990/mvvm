package com.ymars.poj.base.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ymars.poj.base.repository.BaseRepository;

public class BaseViewModel<T extends BaseRepository> extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}