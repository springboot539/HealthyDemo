package com.example.healthydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthydemo.domain.FoodBean;

public class FoodDescActivity extends AppCompatActivity {
    TextView titleTv1, titleTv2, descTv, notTv;
    ImageView backIv, bigPicIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        initView();
        Intent intent = getIntent();
        FoodBean food = (FoodBean) intent.getSerializableExtra("food");
        titleTv1.setText(food.getTitle());
        titleTv2.setText(food.getTitle());
        descTv.setText(food.getDesc());
        notTv.setText(food.getDesc());
        bigPicIv.setImageResource(food.getPicId());

    }

    private void initView() {
        titleTv1 = findViewById(R.id.fooddesc_tv_title1);
        titleTv2 = findViewById(R.id.fooddesc_tv_title2);
        descTv = findViewById(R.id.fooddesc_tv_desc);
        notTv = findViewById(R.id.fooddesc_tv_not);
        backIv = findViewById(R.id.fooddesc_iv_back);
        bigPicIv = findViewById(R.id.fooddesc_iv_bigpic);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
