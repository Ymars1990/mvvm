package com.ymars.poj.home.ui.network;

import androidx.lifecycle.MutableLiveData;

import com.ymars.mvvm.poj.businesscom.bean.ArticleDataBean;
import com.ymars.poj.base.repository.BaseRepository;
import com.ymars.poj.comutils.LogTools;
import com.ymars.poj.network.BaseObserver;
import com.ymars.poj.network.BaseResponesBean;
import com.ymars.poj.network.MyRetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeRepository extends BaseRepository<HomeApiService> {
    private final String TAG = HomeRepository.class.getSimpleName();

    public HomeRepository() {
        apiService = MyRetrofitManager.getInstance(HomeApiService.class);
    }

    private MutableLiveData<ArticleDataBean> mArticleDataBean = new MutableLiveData<>();

    public MutableLiveData<ArticleDataBean> getArticleDataBean(int page) {
        LogTools.e(TAG, "getArticleDataBean");
        apiService.getArticleDataBean(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ArticleDataBean>() {
                    @Override
                    public void onMyError(int errorCode, String msg) {

                    }

                    @Override
                    public void onMySuccess(ArticleDataBean articleDataBean) {
                        LogTools.i(TAG,articleDataBean.toString());
                        mArticleDataBean.setValue(articleDataBean);
                    }
                });
        return mArticleDataBean;
    }
}