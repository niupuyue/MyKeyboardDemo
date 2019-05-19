package com.paulniu.mykeyboarddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements MyChatKeyboardClickListener {

    private MyChatKeyboardView chatkeyboard;
    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroll = findViewById(R.id.scroll);
        chatkeyboard = findViewById(R.id.chatkeyboard);
        chatkeyboard.setData(this, this,scroll);
        chatkeyboard.setSmilyFragment(SmilyFragment.getInstance());
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
