package com.paulniu.mykeyboarddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;

import com.paulniu.mykeyboarddemo.callbacks.MyChatKeyboardClickListener;
import com.paulniu.mykeyboarddemo.fragments.ExpandFragment;
import com.paulniu.mykeyboarddemo.fragments.SmilyFragment;
import com.paulniu.mykeyboarddemo.utils.EmojiUtil;

public class MainActivity extends AppCompatActivity implements MyChatKeyboardClickListener {

    private MyChatKeyboardView chatkeyboard;
    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroll = findViewById(R.id.scroll);
        chatkeyboard = findViewById(R.id.chatkeyboard);
        chatkeyboard.setData(this, this, scroll);
        chatkeyboard.setSmilyFragment(SmilyFragment.getInstance(EmojiUtil.EMOJI_TYPE_CLASSICS));
        chatkeyboard.setExpandFragment(ExpandFragment.getInstance());
    }

    @Override
    public void sendMessage() {
        Log.e("NPL", "点击了发送按钮");
    }

    @Override
    public void choosePhrase() {
        Log.e("NPL", "点击了常用语按钮");
    }
}
