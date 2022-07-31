package com.example.healthydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.healthydemo.adapter.AboutAdapter;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager mViewPager;
    TextView shareTv;
    private LinearLayout pointLayout;
    List<View> mViewList;
    int[] picIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private AboutAdapter mAdapter;
    List<ImageView> pointList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mViewPager = findViewById(R.id.about_vp);
        shareTv = findViewById(R.id.about_tv_share);
        pointLayout = findViewById(R.id.about_layout_point);
        shareTv.setOnClickListener(this);
        mViewList = new ArrayList<>();
        pointList = new ArrayList<>();
        for (int i = 0; i < picIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_aboutvp, null);
            ImageView iv = view.findViewById(R.id.item_about_iv);
            iv.setImageResource(picIds[i]);
            mViewList.add(view);
            ImageView pointIv = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 20, 0);
            pointIv.setLayoutParams(layoutParams);
            pointIv.setImageResource(R.drawable.next);
            pointList.add(pointIv);
            pointLayout.addView(pointIv);
        }

        pointList.get(0).setImageResource(R.drawable.flush);
        mAdapter = new AboutAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);
        mHandler.sendEmptyMessageDelayed(1, 5000);
        setVPListener();
    }

    private void setVPListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < pointList.size(); i++) {
                    pointList.get(i).setImageResource(R.drawable.next);
                }
                pointList.get(position% pointList.size()).setImageResource(R.drawable.flush);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg = "您的随手转发将会对我们产生巨大的影响,感谢您的分享!";
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, "123123123123123"));
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
//                进行页面的自动滑动
                int currentItem = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(currentItem + 1);
                mHandler.sendEmptyMessageDelayed(1, 5000);
            }
        }
    };
}
