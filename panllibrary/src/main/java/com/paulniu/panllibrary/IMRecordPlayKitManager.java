package com.paulniu.panllibrary;

import android.content.Context;

import com.paulniu.panllibrary.callbacks.IMRecordPlayerCallback;


/**
 * 语音播放管理类
 */
public class IMRecordPlayKitManager implements IMRecordPlayerCallback {

    private Context mContext;
    private RecorderPlayKit recorderPlayKit;
    private int position;

    public IMRecordPlayKitManager(Context context) {
        try {
            this.mContext = context;
            recorderPlayKit = RecorderPlayKit.getInstance(mContext);
            recorderPlayKit.setCallback(this);
        } catch (Exception ex) {
        }
    }

    public void play(int position, boolean isAutoPlay) {
        try {
            this.position = position;
            recorderPlayKit.play(null, position, isAutoPlay);
        } catch (Exception ex) {
        }
    }

    /**
     * 播放完成
     * 播放完成之后，播放下一条语音
     */
    @Override
    public void recorderPlayerComplete(int position, boolean isAutoPlay) {
        // 根据返回的path对象，找到对应的viewholder对象，然后再让各自去执行
//        info.callback.recordPlayerCompleteUI(position);
    }

    /**
     * 播放停止
     */
    @Override
    public void recorderPlayerStop(int position) {
//        info.callback.recordPlayerStopUI(position);
    }

    /**
     * 开始播放
     */
    @Override
    public void recorderPlayerStart(int position, boolean isCache) {
//        info.callback.recordPlayerStartUI(position);
    }

    /**
     * 缓存状态发生改变
     */
    @Override
    public void recorderPlayerCaching(int position, boolean isCache) {
//        info.callback.recordPlayerCachingUI(position, isCache);
    }
}
