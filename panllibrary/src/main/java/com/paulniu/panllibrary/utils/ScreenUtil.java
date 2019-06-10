package com.paulniu.panllibrary.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 自定义键盘Screen工具类
 */
public class ScreenUtil {

    // 初始键盘高度的误差偏移量
    private static int KEYBOARD_HEIGHT_OFFSET = 150;

    /**
     * 返回屏幕的宽度
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /**
     * 返回屏幕的宽度
     */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * 获取键盘初始高度
     */
    public static int getKeyboardInitHeight(Activity activity) {
        return getScreenHeight(activity) / 2 - KEYBOARD_HEIGHT_OFFSET;
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusHeight = activity.getResources().getDimensionPixelSize(resourceId);
        return statusHeight;
    }


}
