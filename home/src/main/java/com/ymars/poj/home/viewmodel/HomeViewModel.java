package com.ymars.poj.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ymars.mvvm.poj.businesscom.bean.ArticleDataBean;
import com.ymars.mvvm.poj.businesscom.bean.BannerBean;
import com.ymars.poj.base.model.BaseViewModel;
import com.ymars.poj.comutils.LogTools;
import com.ymars.poj.home.network.HomeApiService;
import com.ymars.poj.network.BaseObserver;
import com.ymars.poj.network.MyRetrofitManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel<HomeApiService> {
    private MutableLiveData<ArticleDataBean> mArticleDataBean = new MutableLiveData<>();
    private MutableLiveData<List<BannerBean>> mBannerBean = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        apiService = MyRetrofitManager.getInstance(HomeApiService.class);
    }

    public void getArticleDataBean(int page) {
        LogTools.i(TAG, "getArticleDataBean");
        apiService.getArticleDataBean(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ArticleDataBean>() {
                    @Override
                    public void onMyError(int errorCode, String msg) {
                        LogTools.e(TAG, String.format("errorCode:%s,Msg:%s", errorCode, msg));
                    }

                    @Override
                    public void onMySuccess(ArticleDataBean articleDataBean) {
                        LogTools.i(TAG, articleDataBean.toString());
                        mArticleDataBean.setValue(articleDataBean);
                    }
       });
    }

    public void getBannerBean() {
        LogTools.i(TAG, "getBannerBean");
        apiService.getBannerBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<BannerBean>>() {
                    @Override
                    public void onMyError(int errorCode, String msg) {
                        LogTools.e(TAG, String.format("errorCode:%s,Msg:%s", errorCode, msg));
                    }

                    @Override
                    public void onMySuccess(List<BannerBean> articleDataBean) {
                        LogTools.i(TAG, articleDataBean.toString());
                        mBannerBean.setValue(articleDataBean);
                    }
                });
    }

    public MutableLiveData<ArticleDataBean> getmArticleDataBean() {
        return mArticleDataBean;
    }

    public MutableLiveData<List<BannerBean>> getmBannerBean() {
        return mBannerBean;
    }
}