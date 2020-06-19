package com.ymars.poj.base.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ymars.poj.base.ui.BaseFragment;

import java.util.ArrayList;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> fragments = new ArrayList();

    public MyFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public MyFragmentAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<BaseFragment> fragments) {
        super(fm, behavior);
        this.fragments.clear();
        this.fragments.addAll(fragments);
    }

    @NonNull
    @Override
    public BaseFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}