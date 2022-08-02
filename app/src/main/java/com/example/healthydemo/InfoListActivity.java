package com.example.healthydemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthydemo.Utils.FoodUtils;
import com.example.healthydemo.adapter.InfoListAdapter;
import com.example.healthydemo.domain.FoodBean;

import java.util.ArrayList;
import java.util.List;

public class InfoListActivity extends AppCompatActivity implements View.OnClickListener {

    EditText searchEt;
    ImageView searchIv, flushIv;
    ListView showLv;
    List<FoodBean> mDatas;
    List<FoodBean> allFoodList;
    private InfoListAdapter mInfoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
        initView();
        mDatas = new ArrayList<>();
        allFoodList = FoodUtils.getAllFoodList();
        mDatas.addAll(allFoodList);
        mInfoListAdapter = new InfoListAdapter(this, mDatas);
        showLv.setAdapter(mInfoListAdapter);
        initListener();
    }

    private void initListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean = mDatas.get(position);
                Intent intent =new Intent(InfoListActivity.this,FoodDescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.info_list_lv);
        searchIv.setOnClickListener(this);
        flushIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_iv_search:
                String msg = searchEt.getText().toString().trim();
                if (TextUtils.isEmpty(msg)) {
                    Toast.makeText(this, "输入内容不可以为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<FoodBean> list = new ArrayList<>();
//                注意包含关键字即可,所以使用contains判断,
                for (FoodBean foodBean : allFoodList) {
                    String title = foodBean.getTitle();
                    if (title.contains(msg)) {
                        list.add(foodBean);
                    }
                }
                mDatas.clear();
                mDatas.addAll(list);
                mInfoListAdapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_flush:
                searchEt.setText("");
                mDatas.clear();
                mDatas.addAll(allFoodList);
                mInfoListAdapter.notifyDataSetChanged();
                break;
        }
    }

    public void back(View view) {
        finish();
    }
}



