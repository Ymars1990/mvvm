package com.ymars.poj.network;

import android.util.Log;

import com.ymars.poj.comutils.JsonFormater;
import com.ymars.poj.comutils.LogTools;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ymars.poj.network.NetworkConstant.SERVER_CONNECT_TIME_OUT;
import static com.ymars.poj.network.NetworkConstant.SERVER_READ_TIME_OUT;
import static com.ymars.poj.network.NetworkConstant.SERVER_WRITE_TIME_OUT;

/**
 * @author Mars
 * 请求Retrofit管理器
 */
public class MyRetrofitManager {
    private static final String TAG = "MyRetrofitManager";
    /**
     * 创建okhttp相关对象
     */
    private static OkHttpClient okHttpClient;
    /**
     * 创建Retrofit相关对象
     */
    private static Retrofit retrofit;

    public static <T> T getInstance(final Class<T> service) {
        if (okHttpClient == null) {
            synchronized (MyRetrofitManager.class) {
                if (okHttpClient == null) {
                    /**
                     * 创建okhttp相关对象
                     */
                    okHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(SERVER_CONNECT_TIME_OUT, TimeUnit.SECONDS)       //超时时间
                            .readTimeout(SERVER_READ_TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(SERVER_WRITE_TIME_OUT, TimeUnit.SECONDS)
                            .addInterceptor(new RequstInterceptor()) //
                            .addInterceptor(new AddCookiesInterceptor()) //
                            .addInterceptor(new ReceivedCookiesInterceptor())
                            .build();
                }
            }
        }

        if (retrofit == null) {
            synchronized (MyRetrofitManager.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(NetworkConstant.BASR_SERVER_URL)         //BaseUrl
                            .client(okHttpClient)                       //请求的网络框架
                            .addConverterFactory(GsonConverterFactory.create())     //解析数据格式
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 使用RxJava作为回调适配器
                            .build();
                }
            }
        }
        return retrofit.create(service);
    }
}