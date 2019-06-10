package com.paulniu.panllibrary.number;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.paulniu.panllibrary.R;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 17:59
 * Desc: 自定义数字键盘
 * Version:
 */
public class InputNumberPanelView extends KeyboardView {

    private Context mContext;
    private Keyboard mKeyboard;

    private int keyboard_bg_color = R.color.red;

    public InputNumberPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InputNumberPanelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputNumberPanelView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取系统键盘对象
        mKeyboard = getKeyboard();
        List<Keyboard.Key> keys = null;
        // 获取所有按键对象
        if (mKeyboard == null) return;
        keys = mKeyboard.getKeys();
        if (UtilitySecurity.isEmpty(keys)) return;
        for (Keyboard.Key key : keys) {
            // 只处理数字键盘
            if (key.codes[0] == Keyboard.KEYCODE_DONE) {
                // 设置背景
                drawKeyboardBackground(keyboard_bg_color, canvas, key);
                // 设置数字键盘
                drawText(canvas, key);
            }
        }
    }

    private void drawKeyboardBackground(int drawableId, Canvas canvas, Keyboard.Key key) {
        Drawable drawable = mContext.getResources().getDrawable(drawableId);
        int[] drawableState = key.getCurrentDrawableState();
        if (key.codes[0] != 0) {
            drawable.setState(drawableState);
        }
        drawable.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        drawable.draw(canvas);
    }

    private void drawText(Canvas canvas, Keyboard.Key key) {
        Rect bounds = new Rect();
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(mContext.getResources().getColor(R.color.color_gray));

        if (key.label != null) {
            String label = key.label.toString();
            Field field;
            if (label.length() > 1 && key.codes.length < 2) {
                int labelTextSize = 0;
                try {
                    field = KeyboardView.class.getDeclaredField("mLabelTextSize");
                    field.setAccessible(true);
                    labelTextSize = (int) field.get(this);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                paint.setTextScaleX(labelTextSize);
                paint.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                int keyTextSize = 0;
                try {
                    field = KeyboardView.class.getDeclaredField("mLabelTextSize");
                    field.setAccessible(true);
                    keyTextSize = (int) field.get(this);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                paint.setTextSize(keyTextSize);
                paint.setTypeface(Typeface.DEFAULT);
            }

            paint.getTextBounds(key.label.toString(), 0, key.label.toString().length(), bounds);
            canvas.drawText(key.label.toString(), key.x + (key.width / 2), (key.y + key.height / 2) + bounds.height() / 2, paint);
        } else if (key.icon != null) {
            key.icon.setBounds(key.x + (key.width - key.icon.getIntrinsicWidth()) / 2,
                    key.y + (key.height - key.icon.getIntrinsicHeight()) / 2,
                    key.x + (key.width - key.icon.getIntrinsicWidth()) / 2 + key.icon.getIntrinsicWidth(),
                    key.y + (key.height - key.icon.getIntrinsicHeight()) / 2 + key.icon.getIntrinsicHeight());
            key.icon.draw(canvas);
        }
    }
}
