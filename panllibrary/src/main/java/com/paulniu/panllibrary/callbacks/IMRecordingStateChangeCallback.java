package com.paulniu.panllibrary.callbacks;


import com.paulniu.panllibrary.events.OnSendVoiceEvent;

/**
 * Desc:改变语音播放状态回调
 */
public interface IMRecordingStateChangeCallback {

    /**
     * 改变录音状态
     * @param event 当前需要修改的参数
     */
    void changeRecorderState(OnSendVoiceEvent event);

}
