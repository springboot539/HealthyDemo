package com.example.healthydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthydemo.Utils.FoodUtils;
import com.example.healthydemo.adapter.FoodGridAdapter;
import com.example.healthydemo.domain.FoodBean;

import java.util.List;

public class FoodGridActivity extends AppCompatActivity {

    GridView mGridView;
    private List<FoodBean> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);
        mGridView = findViewById(R.id.food_grid_gv);
        mDatas = FoodUtils.getAllFoodList();
        FoodGridAdapter adapter = new FoodGridAdapter(this, mDatas);
        mGridView.setAdapter(adapter);
        initListener();
    }

    private void initListener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean = mDatas.get(position);
                Intent intent = new Intent(FoodGridActivity.this, FoodDescActivity.class);
                intent.putExtra("food", foodBean);
                startActivity(intent);
            }
        });
    }

    public void back1(View view) {
        finish();
    }
}
