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

public class InfoListAdapter extends BaseAdapter {

    Context mContext;
    List<FoodBean> mDatas;

    public InfoListAdapter(Context context, List<FoodBean> datas) {
        mContext = context;
        mDatas = datas;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_infolist_lv, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        FoodBean foodBean = mDatas.get(i);
        viewHolder.titleTv.setText(foodBean.getTitle());
        viewHolder.notTv.setText(foodBean.getNotmatch());
        viewHolder.iv.setImageResource(foodBean.getPicId());
        return view;
    }


    class ViewHolder {
        ImageView iv;
        TextView titleTv, notTv;

        public ViewHolder(View view) {
            iv = view.findViewById(R.id.item_info_iv);
            titleTv = view.findViewById(R.id.item_info_tv_title);
            notTv = view.findViewById(R.id.item_info_tv_notmatch);
        }


    }
}
