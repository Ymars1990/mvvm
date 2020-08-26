package com.ymars.poj.component.interf;

import android.view.View;

public interface RvItemOnclicker<T> {
    void onRvItemClick(T  data, View v,int pos);
}
