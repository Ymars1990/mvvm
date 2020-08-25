package com.ymars.poj.home.ui.network;

import com.ymars.mvvm.poj.businesscom.bean.ArticleDataBean;
import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.base.apiservice.BaseApiService;
import com.ymars.poj.network.BaseResponesBean;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeApiService extends BaseApiService {

    @GET("/article/list/{page}/json")
    Observable<BaseResponesBean<ArticleDataBean>> getArticleDataBean(@Path(value = "page") int page);


    @GET("/banner/json")
    Observable<BaseResponesBean<List<BannerBean>>> getBannerBean();
}