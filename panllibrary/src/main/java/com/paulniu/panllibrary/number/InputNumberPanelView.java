package com.paulniu.panllibrary.number;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paulniu.panllibrary.R;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 19:28
 * Desc: 数字键盘
 * Version:
 */
public class InputNumberPanelView extends LinearLayout implements
        View.OnTouchListener {

    private Context mContext;

    private View mRoot;
    private EditText inputnumber_key_note;
    private TextView inputnumber_key_number;
    private InputNumberView inputNumberView;

    public InputNumberPanelView(Context context) {
        super(context);
        init(context);
    }

    public InputNumberPanelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InputNumberPanelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        mRoot = LayoutInflater.from(mContext).inflate(R.layout.view_input_number_panel, this);
        initViewfindViewById(mRoot);
        initViewListener();
    }

    private void initViewfindViewById(View root) {
        if (root == null) return;
        inputNumberView = root.findViewById(R.id.inputNumberView);
        inputnumber_key_note = root.findViewById(R.id.inputnumber_key_note);
        inputnumber_key_number = root.findViewById(R.id.inputnumber_key_number);
    }

    private void initViewListener() {
        if (inputnumber_key_note == null) return;
        inputnumber_key_note.setOnTouchListener(this);
        if (inputnumber_key_number == null) return;
        inputnumber_key_number.setOnTouchListener(this);
    }

    private void showNumberPanel() {
        // 保持系统软键盘关闭状态
        // 需要先判断当前数字键盘是否显示
    }

    private void showSysKeyboardPanel() {
        // 显示系统软键盘
        // 将数字键盘关闭
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == null) {
            return false;
        }
        if (v.getId() == R.id.inputnumber_key_number) {
            // 触摸数字之后显示自定义数字键盘
            showNumberPanel();
        } else if (v.getId() == R.id.inputnumber_key_note) {
            // 触摸输入框之后显示系统软件盘
            showSysKeyboardPanel();
        }
        return false;
    }
}
