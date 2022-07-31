package com.example.healthydemo.grid;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthydemo.R;
import com.example.healthydemo.Utils.FoodUtils;
import com.example.healthydemo.adapter.FoodGridAdapter;
import com.example.healthydemo.domain.FoodBean;

import java.util.List;

public class FoodGridActivity extends AppCompatActivity {

    GridView mGridView;
    private List<FoodBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);
        mGridView = findViewById(R.id.food_grid_gv);
        mData = FoodUtils.getAllFoodList();
        FoodGridAdapter adapter = new FoodGridAdapter(this, mData);
        mGridView.setAdapter(adapter);
    }
}
