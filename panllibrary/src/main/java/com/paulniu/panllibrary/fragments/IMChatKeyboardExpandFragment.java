package com.paulniu.panllibrary.fragments;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.paulniu.panllibrary.R;
import com.paulniu.panllibrary.callbacks.IMChatSendMessageCallback;
import com.paulniu.panllibrary.callbacks.IMShowRecordViewCallback;
import com.paulniu.panllibrary.utils.CheckRecordPermission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;


/**
 * Desc: 更多页面
 */
public class IMChatKeyboardExpandFragment extends BaseIMFragment implements
        View.OnClickListener {

    public static IMChatKeyboardExpandFragment getInstance() {
        IMChatKeyboardExpandFragment fragment = new IMChatKeyboardExpandFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    private View root;
    private IMShowRecordViewCallback mShowRecorderUIListener;
    private IMChatSendMessageCallback mSendMessageListener;
    private AppCompatActivity mActivity;

    private ImageView ivFeAlbum;
    private ImageView ivFePhoto;
    private ImageView ivFePosition;
    private ImageView ivFeRecorder;

    @Override
    public int getIMLayoutId() {
        return R.layout.fragment_expands;
    }

    @Override
    public void initViewFindViewById(View root) {
        if (root == null) return;
        try {
            ivFeAlbum = root.findViewById(R.id.ivAlbum);
            ivFePhoto = root.findViewById(R.id.ivPhoto);
            ivFePosition = root.findViewById(R.id.ivPosition);
            ivFeRecorder = root.findViewById(R.id.ivRecorder);
        } catch (Exception ex) {
        }
    }

    public void initViewListener() {
        ivFeAlbum.setOnClickListener(this);
        ivFePhoto.setOnClickListener(this);
        ivFePosition.setOnClickListener(this);
        ivFeRecorder.setOnClickListener(this);
    }

    /**
     * 发送定位
     *
     * @param activity 上下文对象
     */
    private void gotoSetLocation(Activity activity) {
        // 调用高德地图获取当前位置，发送消息
    }

    /**
     * 发送语音消息操作方法
     */
    private void recorderOperation() {
        // 执行语音操作之前先自己起一个recorder，判断是否有权限，有执行下一步操作，没有则不执行
        try {

            new RxPermissions(this)
                    .request(Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(new Consumer<Boolean>() {
                        @Override
                        public void accept(Boolean grant) throws Exception {
                            if (grant) {
                                replaceExpandContainer();
                            }
                        }
                    });
        } catch (Exception ex) {
        }
    }

    /**
     * 设置显示录音页面的UI接口  设置发送消息的接口
     *
     * @param listener
     */
    public void setShowRecorderUIListener(IMShowRecordViewCallback listener, AppCompatActivity activity, IMChatSendMessageCallback callback) {
        if (listener == null || activity == null || callback == null) return;
        try {
            this.mActivity = activity;
            this.mShowRecorderUIListener = listener;
            this.mSendMessageListener = callback;
        } catch (Exception ex) {
        }
    }

    /**
     * 替换之前rlFeExpandContainer中的内容
     */
    public void replaceExpandContainer() {
        if (!CheckRecordPermission.isHasPermission(getContext())) return;
        if (mShowRecorderUIListener == null) return;
        try {
            mShowRecorderUIListener.showRecorderView();
        } catch (Exception ex) {
        }
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ivAlbum) {// 相册

        } else if (i == R.id.ivPhoto) {// 拍照

        } else if (i == R.id.ivPosition) {// 点击之后跳转到定位页面
            gotoSetLocation(getActivity());
        } else if (i == R.id.ivRecorder) {// 语音消息
            recorderOperation();
        }
    }
}
