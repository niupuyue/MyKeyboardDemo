package com.paulniu.panllibrary.utils;

import android.widget.ImageView;

import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 11:18
 * Desc:
 * Version:
 */
public class UtilitySecurity {

    public static boolean isEmpty(String res) {
        return res == null || res.length() == 0;
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty() || list.size() == 0;
    }

    public static void setImageResource(ImageView iv, int resourceId) {
        if (iv == null) return;
        try {
            iv.setImageResource(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
