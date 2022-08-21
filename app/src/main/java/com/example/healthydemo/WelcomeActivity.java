package com.example.healthydemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthy.R;

public class WelcomeActivity extends AppCompatActivity {

    private TextView mTv;
    int time = 5;
    private SharedPreferences mSharedPreferences;//存储键值对信息
    private SharedPreferences.Editor mEdit;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                time--;
                if (time == 0) {
                    Intent intent = new Intent();
                    boolean isFirst = mSharedPreferences.getBoolean("isFirst", true);
                    if (isFirst) {
                        intent.setClass(WelcomeActivity.this, GuideActivity.class);
                        mEdit.putBoolean("isFirst",false);
                        mEdit.commit();
                    } else {
                        intent.setClass(WelcomeActivity.this, MainActivity.class);
                    }
//                    跳转页面
                    startActivity(intent);
                    finish();
                } else {
//                    继续进行
                    mTv.setText(time + "");
                    mHandler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTv = findViewById(R.id.welcome_tv);
        mHandler.sendEmptyMessageDelayed(1, 1000);
        mSharedPreferences = getSharedPreferences("health_pref", MODE_PRIVATE);
//        写入数据
        mEdit = mSharedPreferences.edit();
    }
}
