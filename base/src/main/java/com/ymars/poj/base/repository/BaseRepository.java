package com.ymars.poj.base.repository;

import com.ymars.poj.base.apiservice.BaseApiService;

public abstract class BaseRepository<T extends BaseApiService> {
    protected T apiService;
}