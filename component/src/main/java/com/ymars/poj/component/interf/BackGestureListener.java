package com.ymars.poj.component.interf;

import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author imgod
 *         自定义一个类来实现OnGestureListener 手势监听
 */
public class BackGestureListener implements GestureDetector.OnGestureListener {
    private AppCompatActivity mc;

    public BackGestureListener(AppCompatActivity context) {
        // TODO Auto-generated constructor stub
        mc = context;
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
                           float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        // 已经往右滑动超过100px并且上下滑动不超过60px
        if ((arg1.getX() - arg0.getX()) > 100 && (Math.abs(arg0.getY() - arg1.getY()) < 60)) {
            mc.onBackPressed();
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {


    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {

        return false;
    }

}
