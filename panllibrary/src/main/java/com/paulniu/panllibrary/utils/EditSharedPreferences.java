package com.paulniu.panllibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 15:09
 * Desc:
 * Version:
 */
public class EditSharedPreferences {

    // 记录键盘高度
    public static final String int_local_keyboard_height = "int_local_keyboard_height";

    private static SharedPreferences mySharedPreferences = null;

    public static SharedPreferences getSharedPreferencesInstance(Context context) {
        if (mySharedPreferences == null && null != context) {
            mySharedPreferences = context.getSharedPreferences("app_info", Activity.MODE_PRIVATE);
        }

        return mySharedPreferences;
    }

    /**
     * 获取键盘高度
     *
     * @return 键盘高度
     */
    public static int getKeyboardHeight(Context context) {
        int keyboardHeight = 0;
        try {
            SharedPreferences shared = getSharedPreferencesInstance(context);
            keyboardHeight = shared.getInt(int_local_keyboard_height, 0);
        } catch (Exception ex) {
        }
        return keyboardHeight;
    }

    /**
     * 设置键盘高度
     *
     * @param height 计算之后键盘高度
     */
    public static void setKeyboardHeight(Context context, int height) {
        try {
            SharedPreferences.Editor editor = getSharedPreferencesInstance(context).edit();
            editor.putInt(int_local_keyboard_height, height);
            editor.apply();
        } catch (Exception ex) {
        }
    }

}
