package com.ymars.poj.comutils;

import android.content.Context;
import android.util.DisplayMetrics;

public class UnitTools {
    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context ctx) {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕宽度,设置比例
     */
    public static int getScreenWidth(Context ctx, float ratio) {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        return (int) (dm.widthPixels * ratio);
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHight(Context ctx) {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取屏幕高度,设置比例
     */
    public static int getScreenHight(Context ctx, float ratio) {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        return (int) (dm.heightPixels * ratio);
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     * DisplayMetrics类中属性density
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     * DisplayMetrics类中属性density
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     * DisplayMetrics类中属性scaledDensity
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * DisplayMetrics类中属性scaledDensity
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
