package com.ymars.poj.network;

import com.ymars.poj.comutils.LogTools;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
     /*   String cookieStr = SPUtil.getData(Constant.SP.SP, Constant.SP.SESSION_ID, String.class, null);
        List<String> cookies = JSONObject.parseArray(cookieStr, String.class);
        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
            }
        }*/
        return chain.proceed(builder.build());
    }
}