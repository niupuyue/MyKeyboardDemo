package com.paulniu.mykeyboarddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 16:41
 * Desc:
 * Version:
 */
public class SmilyFragment extends Fragment {

    private static final String EMOTICON_TYPE = "emoticonType";

    public static SmilyFragment getInstance(int emoticonType) {
        SmilyFragment fragment = new SmilyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EMOTICON_TYPE, emoticonType);
        fragment.setArguments(bundle);
        return fragment;
    }

    View root;
    private int emoticonType;
    private OnEmojiClickListener listener;
    private View view;
    private List<EmojiModel> emojiList;
    public static final int RECYCLER_VIEW_SPAN_COUNT = 7;
    private ViewPager vpfsEmojiContanier;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_smily, container, false);
        initExtraData();
        initLayoutById(root);
        initEmojiDataAfterInitView();
        return root;
    }

    private void initExtraData() {
        if (getArguments() != null) {
            emoticonType = getArguments().getInt(EMOTICON_TYPE);
        }
    }

    private void initLayoutById(View root) {
        if (root != null) {
            vpfsEmojiContanier = root.findViewById(R.id.vpfsEmojiContanier);
        }
    }

    /**
     * 设置表情点击事件
     */
    public void setOnEmojiClickListener(OnEmojiClickListener listener) {
        this.listener = listener;
    }

    /**
     * 获取所有的表情图像
     */
    private void initEmojiDataAfterInitView() {
        emojiList = new ArrayList<>();
        for (String emojiName : EmojiUtil.getEmojiMap(emoticonType).keySet()) {
            emojiList.add(new EmojiModel(emojiName, EmojiUtil.getEmojiId(emoticonType, emojiName)));
        }
    }
}
