package com.example.healthydemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class AboutAdapter extends PagerAdapter {
    List<View> mViewList;

    public AboutAdapter(List<View> viewList) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
//        能够滑动的次数,
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = mViewList.get(position%mViewList.size());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = mViewList.get(position%mViewList.size());
        container.removeView(view);
    }
}
