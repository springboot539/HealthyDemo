package com.example.healthydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthydemo.grid.FoodGridActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.home_btn1:
                intent.setClass(this, InfoListActivity.class);
                break;
            case R.id.home_btn2:
                intent.setClass(this, FoodGridActivity.class);
                break;
            case R.id.home_btn3:
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
