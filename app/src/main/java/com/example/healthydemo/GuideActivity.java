package com.example.healthydemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.healthy.R;
import com.example.healthydemo.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;
    TextView mTv1, mTv2, mTv3;
    Button mBtn;
    List<View> mViewList;
    List<TextView> mTextViews;

    int[] resId = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private GuideAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mViewPager = findViewById(R.id.guide_vp);
        mTv1 = findViewById(R.id.guide_tv1);
        mTv2 = findViewById(R.id.guide_tv2);
        mTv3 = findViewById(R.id.guide_tv3);
        mBtn = findViewById(R.id.guide_btn);
        mBtn.setOnClickListener(this);
        mViewList = new ArrayList<>();
        mTextViews = new ArrayList<>();
        for (int i = 0; i < resId.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_guide1, null);
            view.setBackgroundResource(resId[i]);
            mViewList.add(view);
        }
        mAdapter = new GuideAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);
        mTextViews.add(mTv1);
        mTextViews.add(mTv2);
        mTextViews.add(mTv3);
        mTv1.setTextColor(Color.RED);
        setVpListener();


    }

    private void setVpListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mTextViews.size(); i++) {
                    mTextViews.get(i).setTextColor(Color.WHITE);
                }
                mTextViews.get(position).setTextColor(Color.RED);
                if (position == 2) {
                    mBtn.setVisibility(View.VISIBLE);
                } else {
                    mBtn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guide_btn:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}
