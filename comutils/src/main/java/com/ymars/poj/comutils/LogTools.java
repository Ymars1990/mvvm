package com.ymars.poj.comutils;

import android.util.Log;

/**
 * 日志打印类
 */
public class LogTools {

    public static void e(String tag, String content) {
        if (StringTools.strIsNotNull(tag) && StringTools.strIsNotNull(content)) {
            Log.e(tag, content);
        } else if (!StringTools.strIsNotNull(tag)) {
            Log.e("Tag is null", content);
        } else {
            Log.e(tag, "content is null");
        }
    }

    public static void d(String tag, String content) {
        if (StringTools.strIsNotNull(tag) && StringTools.strIsNotNull(content)) {
            Log.d(tag, content);
        } else if (!StringTools.strIsNotNull(tag)) {
            Log.d("Tag is null", content);
        } else {
            Log.d(tag, "content is null");
        }
    }

    public static void i(String tag, String content) {
        if (StringTools.strIsNotNull(tag) && StringTools.strIsNotNull(content)) {
            Log.i(tag, content);
        } else if (!StringTools.strIsNotNull(tag)) {
            Log.i("Tag is null", content);
        } else {
            Log.i(tag, "content is null");
        }
    }

    public static void w(String tag, String content) {
        if (StringTools.strIsNotNull(tag) && StringTools.strIsNotNull(content)) {
            Log.w(tag, content);
        } else if (!StringTools.strIsNotNull(tag)) {
            Log.w("Tag is null", content);
        } else {
            Log.w(tag, "content is null");
        }
    }

    public static void v(String tag, String content) {
        if (StringTools.strIsNotNull(tag) && StringTools.strIsNotNull(content)) {
            Log.v(tag, content);
        } else if (!StringTools.strIsNotNull(tag)) {
            Log.v("Tag is null", content);
        } else {
            Log.v(tag, "content is null");
        }
    }
}
