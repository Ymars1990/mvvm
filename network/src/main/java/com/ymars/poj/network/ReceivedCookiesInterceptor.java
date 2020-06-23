package com.ymars.poj.network;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            ArrayList<String> cookies = new ArrayList<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
          /*  String cookieStr = JSONObject.toJSONString(cookies);
            SPUtil.putData(Constant.SP.SP, Constant.SP.SESSION_ID, cookieStr);*/
        }

        return originalResponse;
    }
}