package com.paulniu.mykeyboarddemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Coder: niupuyue
 * Date: 2019/5/17
 * Time: 18:25
 * Desc:
 * Version:
 */
public class MyChatKeyboardView extends LinearLayout implements CloseChatKeyboardListener {

    private Context mContext;

    private CloseChatKeyboardListener mCloseChatKeyboardListener;

    public MyChatKeyboardView(Context context) {
        super(context);
    }

    public MyChatKeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyChatKeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 关闭键盘扩展内容
     */
    @Override
    public void closeKeyboard() {

    }


}
