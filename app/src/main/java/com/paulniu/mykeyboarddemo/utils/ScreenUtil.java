package com.paulniu.mykeyboarddemo.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Coder: niupuyue
 * Date: 2019/5/20
 * Time: 10:14
 * Desc:
 * Version:
 */
public class ScreenUtil {

    /**
     * 将dp值转换为px值
     */
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 返回屏幕的宽度
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }


}
