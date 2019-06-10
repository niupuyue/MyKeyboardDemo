package com.paulniu.mykeyboarddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.paulniu.panllibrary.IMChatPanelView;
import com.paulniu.panllibrary.IMRecordingStateView;
import com.paulniu.panllibrary.callbacks.IMChatSendMessageCallback;
import com.paulniu.panllibrary.callbacks.IMRecordingStateChangeCallback;
import com.paulniu.panllibrary.events.OnSendVoiceEvent;

import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 15:45
 * Desc:
 * Version:
 */
public class IMChatKeyBoardPanelActivity extends AppCompatActivity {

    IMChatPanelView chatpanel;
    ScrollView scroll;
    IMRecordingStateView recordingstate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_keyboard_panel);
        chatpanel = findViewById(R.id.chatpanel);
        scroll = findViewById(R.id.scroll);
        recordingstate = findViewById(R.id.recordingstate);
        chatpanel.outterKeyboardSetData(this, new IMChatSendMessageCallback() {
            @Override
            public void sendTextMessage(String textContent) {

            }

            @Override
            public void sendImageMessage(List<String> imageContents) {

            }

            @Override
            public void sendLocationMessage(Object locationContent) {

            }

            @Override
            public void sendVoiceMessage(String voiceModel) {

            }
        }, recordingstate, new IMChatPanelView.OnChatPanelStateChangeCallback() {
            @Override
            public void softKeyboardState(boolean isShow) {

            }
        }, scroll, "", "");
    }
}
