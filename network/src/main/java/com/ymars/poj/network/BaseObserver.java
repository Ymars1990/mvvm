package com.ymars.poj.network;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public  abstract class BaseObserver<B> implements Observer<BaseResponesBean<B>> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponesBean<B> baseResponesBean) {
        if(baseResponesBean.getErrorCode()==0) {
            onMySuccess(baseResponesBean.getData());
        }else if(baseResponesBean.getErrorCode()==-1001 ){
            onMyError(baseResponesBean.getErrorCode(),"登录失效");
        }else {
            onMyError(baseResponesBean.getErrorCode(),baseResponesBean.getErrorMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        onMyError(-0x01,e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onMyError(int errorCode,String msg);
    public abstract void onMySuccess(B data);
}