package com.ymars.poj.base;

import android.app.Application;

public abstract class BaseApplication extends Application {
    protected static BaseApplication app;

    public static BaseApplication getInstance() {
        return app;
    }

}