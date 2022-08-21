package com.example.healthydemo.Utils;


import com.example.healthy.R;
import com.example.healthydemo.domain.FoodBean;

import java.util.ArrayList;
import java.util.List;

public class FoodUtils {
    private static final String[] food = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
    };
    public static final String[] food1 = {
            "一是一NICE呀", "num2", "num3", "num4", "num5", "num6", "num7", "num8", "num9", "num10", "num11", "num12"
    };

    public static final int[] resId = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };
    public static final String[] foodContent = {
            "这个是简介", "num1111111112", "n11111111um3", "nu11111111m4", "num1111115", "num61111111",
            "nu111111m7", "num111111118", "nu1111111111m9", "num1111111110", "nu1111111m11", "nu111111m12"
    };


    public static List<FoodBean> getAllFoodList() {
        List<FoodBean> list = new ArrayList<>();
        for (int i = 0; i < food.length; i++) {
            FoodBean bean = new FoodBean(food[i], food1[1], foodContent[i], resId[i]);
            list.add(bean);
        }
        return list;
    }
}
