package com.example.healthydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthydemo.R;
import com.example.healthydemo.domain.FoodBean;

import java.util.List;

public class FoodGridAdapter extends BaseAdapter {
    Context mContext;
    List<FoodBean> mData;

    public FoodGridAdapter(Context context, List<FoodBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_food_grid, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.iv.setImageResource(mData.get(position).getPicId());
        viewHolder.tv.setText(mData.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView tv;

        public ViewHolder(View view) {
            iv = view.findViewById(R.id.item_food_grid_iv);
            tv = view.findViewById(R.id.item_food_grid_tv);
        }
    }
}
