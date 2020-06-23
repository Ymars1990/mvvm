package com.ymars.poj.network;

import com.ymars.poj.comutils.JsonFormater;
import com.ymars.poj.comutils.LogTools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * @author Mars
 * 请求参数及返回数据
 */
public class RequstInterceptor implements Interceptor {
    private final String TAG = "RequstInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LogTools.i(TAG, String.format("Headers:%s \n apiUrl:%s", request.headers().toString(), request.url()));
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            String request_body = buffer.readString(charset);
            LogTools.i(TAG, String.format("request:%s", request_body));
        }
        Response response = chain.proceed(request);
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        LogTools.i(TAG, String.format("mediaType：%s", mediaType.toString()));
        LogTools.i(TAG, String.format("response:%s", JsonFormater.format(content)));

        return response.newBuilder()
                .build();
    }
}