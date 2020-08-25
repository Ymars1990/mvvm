package com.ymars.poj.mvvm.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ymars.poj.base.adapter.MyFragmentAdapter;
import com.ymars.poj.base.ui.BaseActivity;
import com.ymars.poj.base.ui.BaseFragment;
import com.ymars.poj.home.ui.HomeFragment;
import com.ymars.poj.message.ui.MessageFragment;
import com.ymars.poj.mine.ui.MineFragment;
import com.ymars.poj.mvvm.R;
import com.ymars.poj.mvvm.databinding.ActivityMainBinding;
import com.ymars.poj.project.ui.ProjectFragment;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private ViewPager tabVp;
    private BottomNavigationView tabBnv;

    private HomeFragment home;
    private MessageFragment message;
    private ProjectFragment project;
    private MineFragment mine;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected int setLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initData();
        tabVp = viewBinding.tabVp;
        tabBnv = viewBinding.tabBnv;
        tabVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments));
        tabVp.setCurrentItem(0);
        tabVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabBnv.setOnNavigationItemSelectedListener(item -> {
            String title = item.getTitle().toString();
            switch (item.getItemId()) {
                case R.id.mainBnvItem01:
                    resetFragment(0);
                    break;
                case R.id.mainBnvItem02:
                    resetFragment(1);
                    break;
                case R.id.mainBnvItem03:
                    resetFragment(2);
                    break;
                case R.id.mainBnvItem04:
                    resetFragment(3);
                    break;
                default:
                    break;
            }
            return true;
        });


    }

    private void initData() {
        fragments = new ArrayList<>();
        home = new HomeFragment();
        fragments.add(home);
        message = new MessageFragment();
        fragments.add(message);
        project = new ProjectFragment();
        fragments.add(project);
        mine = new MineFragment();
        fragments.add(mine);
    }


    private void resetTab(int tabIndex) {
        switch (tabIndex) {
            case 0:
                tabBnv.setSelectedItemId(R.id.mainBnvItem01);
                break;
            case 1:
                tabBnv.setSelectedItemId(R.id.mainBnvItem02);
                break;
            case 2:
                tabBnv.setSelectedItemId(R.id.mainBnvItem03);
                break;
            case 3:
                tabBnv.setSelectedItemId(R.id.mainBnvItem04);
                break;
            default:
                break;
        }
    }

    private void resetFragment(int tabIndex) {
        tabVp.setCurrentItem(tabIndex);
    }
}