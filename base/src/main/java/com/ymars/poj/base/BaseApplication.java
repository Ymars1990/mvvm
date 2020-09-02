package com.ymars.poj.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ymars.poj.comutils.LogTools;

public abstract class BaseApplication extends Application {
    protected static BaseApplication app;

    public static BaseApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化路由框架
        ARouter.openLog();
        ARouter.openDebug();
        LogTools.e("baseApplication", "开启路由日志");
        ARouter.init(this);
    }
}