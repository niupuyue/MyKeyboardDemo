package com.paulniu.mykeyboarddemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Coder: niupuyue
 * Date: 2019/5/17
 * Time: 18:25
 * Desc:
 * Version:
 */
public class MyChatKeyboardView extends LinearLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnTouchListener {

    private static final String TAG = MyChatKeyboardView.class.getSimpleName();
    private static final String KEYBOARDHEIGHT = "keyboard_height";
    private static final String MYCHATKEYBOARDVIEWSHARED = "mychat_keyboard_shared";

    private Context mContext;
    private View root;
    private AppCompatActivity mActivity;
    private Fragment mCurrentFragment;
    private Handler mHandler;
    private SharedPreferences sharedPreferences;
    private InputMethodManager inputManager;
    private int mSofiKeyboardHeight = 654;// 本地键盘高度
    private MyChatKeyboardClickListener mListener;
    private View mContentView;

    // Fragment容器
    private RelativeLayout rlVckExpandContainer;

    // 常用语
    private TextView tvVckbPhrase;
    // 输入框
    private EditText cbetCsebInput;
    // 表情按钮
    private CheckBox cbCsebSmily;
    // 扩展按钮
    private CheckBox cbCsebMore;
    // 发送按钮
    private Button btnCsebSendBtn;

    private Fragment mSmilyFragment;
    private Fragment mExpandFragment;
    private Fragment mOtherFragment;


    public MyChatKeyboardView(Context context) {
        super(context);
        initView(context);
    }

    public MyChatKeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyChatKeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        root = LayoutInflater.from(mContext).inflate(R.layout.view_chat_keyboard, this);
        initLayoutByViewId(root);
        initViewForListener();
    }

    private void initLayoutByViewId(View root) {
        if (root != null) {
            rlVckExpandContainer = root.findViewById(R.id.rlVckExpandContainer);
            tvVckbPhrase = root.findViewById(R.id.tvVckbPhrase);
            cbetCsebInput = root.findViewById(R.id.cbetCsebInput);
            cbCsebSmily = root.findViewById(R.id.cbCsebSmily);
            cbCsebMore = root.findViewById(R.id.cbCsebMore);
            btnCsebSendBtn = root.findViewById(R.id.btnCsebSendBtn);
        }
    }

    private void initViewForListener() {
        if (tvVckbPhrase != null) {
            tvVckbPhrase.setOnClickListener(this);
        }
        if (btnCsebSendBtn != null) {
            btnCsebSendBtn.setOnClickListener(this);
        }
        if (cbCsebSmily != null) {
            cbCsebSmily.setOnCheckedChangeListener(this);
        }
        if (cbCsebMore != null) {
            cbCsebMore.setOnCheckedChangeListener(this);
        }
        if (cbetCsebInput != null) {
            cbetCsebInput.setOnTouchListener(this);
        }
    }

    private void initKeyboardHeight() {
        if (sharedPreferences == null) {
            return;
        }
        // 判断之前是否获取过键盘高度
        if (!sharedPreferences.contains(KEYBOARDHEIGHT)) {
            if (mHandler != null) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showSoftKeyboard(true);
                    }
                }, 200);
            }
        } else {

        }
    }

    private void showSoftKeyboard(boolean saveSoftKeyboardHeight) {
        if (cbetCsebInput != null && inputManager != null) {
            cbetCsebInput.requestFocus();
            inputManager.showSoftInput(cbetCsebInput, 0);
            if (saveSoftKeyboardHeight) {
                this.mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getSoftKeyboardHeight();
                    }
                }, 200);
            }
        }
    }

    /**
     * 获取键盘高度
     */
    private int getSoftKeyboardHeight() {
        Rect rect = new Rect();
        if (mActivity != null) {
            this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            // 只获取屏幕的可见高度，不包括状态栏
            int displayHeight = rect.bottom - rect.top;
            // 获取屏幕可用高度
            DisplayMetrics displayMetrics = new DisplayMetrics();
            mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int avaliableHeight = displayMetrics.heightPixels;
            // 状态栏高度
            int resourceId = this.mActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            int statusHeight = this.mActivity.getResources().getDimensionPixelSize(resourceId);
            // 键盘高度计算
            int softInputHeight = avaliableHeight - displayHeight - statusHeight;
            if (softInputHeight != 0) {
                // 将数据保存在本地
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(KEYBOARDHEIGHT, softInputHeight).apply();
                    mSofiKeyboardHeight = softInputHeight;
                }
            }
            return softInputHeight;
        }
        return 0;
    }

    /**
     * 获取本地键盘的高度
     *
     * @return
     */
    private int getSoftkeyboardHeightLocal() {
        if (sharedPreferences != null) {
            mSofiKeyboardHeight = sharedPreferences.getInt(KEYBOARDHEIGHT, mSofiKeyboardHeight);
        }
        return mSofiKeyboardHeight;
    }

    /**
     * 判断键盘是否已经显示
     */
    protected boolean isSoftKeyboardShown() {
        return getSoftKeyboardHeight() != 0;
    }

    /**
     * 锁定内容View以防止跳闪
     */
    private void lockContentViewHeight() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.height = this.mContentView.getHeight();
        layoutParams.weight = 0;
    }

    /**
     * 释放锁定的内容View
     */
    private void unlockContentViewHeight() {
        if (mHandler != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((LayoutParams) mContentView.getLayoutParams()).weight = 1;
                }
            }, 200);
        }
    }

    /**
     * 设置软键盘隐藏
     */
    private void hideSoftKeyboard() {
        if (inputManager != null && cbetCsebInput != null) {
            inputManager.hideSoftInputFromWindow(cbetCsebInput.getWindowToken(), 0);
        }
    }

    /**
     * //////////////////////////// 必须要执行的方法 //////////////////////////////////
     */

    /**
     * 设置Activity对象，为了获取当前的FragmentManager
     *
     * @param activity
     */
    public void setData(AppCompatActivity activity, MyChatKeyboardClickListener listener, View contentView) {
        if (activity != null) {
            this.mActivity = activity;
            this.mListener = listener;
            this.mContentView = contentView;
            if (mContentView != null) {
                mContentView.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            if (mHandler != null) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        cbCsebMore.setChecked(false);
                                        cbCsebSmily.setChecked(false);
                                        setFragmentContainerVisiable(false);
                                        hideSoftKeyboard();
                                    }
                                }, 200);
                            }
                        }
                        return false;
                    }
                });
            }
            sharedPreferences = mActivity.getSharedPreferences(MYCHATKEYBOARDVIEWSHARED, Context.MODE_PRIVATE);
            mHandler = new Handler();
            inputManager = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            this.mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            initKeyboardHeight();
        }
    }

    /**
     * 设置表情Fragment
     */
    public void setSmilyFragment(Fragment smilyFragment) {
        if (smilyFragment != null) {
            this.mSmilyFragment = smilyFragment;
        }
    }

    /**
     * 设置更多Fragment
     */
    public void setExpandFragment(Fragment expandFragment) {
        if (expandFragment != null) {
            this.mExpandFragment = expandFragment;
        }
    }


    /**
     * //////////////////////////// 必须要执行的方法  //////////////////////////////////
     */

    /**
     * 显示fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment != null && this.mActivity != null) {
            FragmentManager fm = mActivity.getSupportFragmentManager();
            if (fm != null && !fm.isDestroyed()) {
                FragmentTransaction ft = fm.beginTransaction();
                if (ft != null) {
                    // 设置fragment容器的高度
                    if (rlVckExpandContainer != null) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rlVckExpandContainer.getLayoutParams();
                        layoutParams.height = getSoftkeyboardHeightLocal();
                        setFragmentContainerVisiable(true);
                    }
                    if (this.mCurrentFragment != null) {
                        ft.hide(this.mCurrentFragment);
                    }
                    if (fragment.isAdded()) {
                        ft.show(fragment).commitAllowingStateLoss();
                    } else {
                        ft.replace(R.id.rlVckExpandContainer, fragment, TAG).commitAllowingStateLoss();
                    }
                    this.mCurrentFragment = fragment;
                }
            }
        }
    }

    /**
     * 隐藏fragment
     */
    private void hideFragment() {

    }

    /**
     * 设置fragment容器是否可见
     */
    private void setFragmentContainerVisiable(boolean isVisiable) {
        if (rlVckExpandContainer == null) {
            return;
        }
        rlVckExpandContainer.setVisibility(isVisiable ? VISIBLE : GONE);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.cbCsebSmily:
                if (isChecked) {
                    // 显示表情fragment
                    if (mSmilyFragment != null) {
                        if (isSoftKeyboardShown()) {
                            lockContentViewHeight();
                            hideSoftKeyboard();
                            showFragment(mSmilyFragment);
                            unlockContentViewHeight();
                        } else {
                            showFragment(mSmilyFragment);
                        }
                        if (cbCsebMore.isChecked()) {
                            cbCsebMore.setChecked(false);
                        }
                    }
                } else {
                    if (!cbCsebMore.isChecked()) {
                        showSoftKeyboard(false);
                        setFragmentContainerVisiable(false);
                    }
                }
                break;
            case R.id.cbCsebMore:
                if (isChecked) {
                    if (mExpandFragment != null) {
                        if (isSoftKeyboardShown()) {
                            lockContentViewHeight();
                            hideSoftKeyboard();
                            showFragment(mExpandFragment);
                            unlockContentViewHeight();
                        } else {
                            showFragment(mExpandFragment);
                        }
                        if (cbCsebSmily.isChecked()) {
                            cbCsebSmily.setChecked(false);
                        }
                    }
                } else {
                    if (!cbCsebSmily.isChecked()) {
                        showSoftKeyboard(false);
                        setFragmentContainerVisiable(false);
                    }
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.cbetCsebInput) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP && rlVckExpandContainer.getVisibility() == VISIBLE) {
                setFragmentContainerVisiable(false);
            }
        }
        return false;
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvVckbPhrase:
                if (this.mListener != null) {
                    this.mListener.choosePhrase();
                }
                break;
            case R.id.btnCsebSendBtn:
                if (this.mListener != null) {
                    this.mListener.sendMessage();
                }
                break;
        }
    }


}
