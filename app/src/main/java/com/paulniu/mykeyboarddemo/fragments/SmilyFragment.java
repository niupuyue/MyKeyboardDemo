package com.paulniu.mykeyboarddemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paulniu.mykeyboarddemo.adapter.SmilyViewPagerAdapter;
import com.paulniu.mykeyboarddemo.callbacks.OnEmojiClickListener;
import com.paulniu.mykeyboarddemo.R;
import com.paulniu.mykeyboarddemo.models.EmojiModel;
import com.paulniu.mykeyboarddemo.utils.EmojiUtil;

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
    private View view;
    private List<EmojiModel> emojiList;
    public static final int RECYCLER_VIEW_SPAN_COUNT = 7;
    private ViewPager vpfsEmojiContanier;
    private OnEmojiClickListener mEmojiClickListener;

    private SmilyDetailPagerFragment fragment1;
    private SmilyDetailPagerFragment fragment2;
    private SmilyDetailPagerFragment fragment3;
    private SmilyDetailPagerFragment fragment4;
    private List<Fragment> fragments = new ArrayList<>();

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
     * 获取所有的表情图像
     */
    private void initEmojiDataAfterInitView() {
        emojiList = new ArrayList<>();
        for (String emojiName : EmojiUtil.getEmojiMap(emoticonType).keySet()) {
            emojiList.add(new EmojiModel(emojiName, EmojiUtil.getEmojiId(emoticonType, emojiName)));
        }
        // 填充fragment
        if (fragment1 == null) {
            fragment1 = new SmilyDetailPagerFragment();
        }
        if (fragment2 == null) {
            fragment2 = new SmilyDetailPagerFragment();
        }
        if (fragment3 == null) {
            fragment3 = new SmilyDetailPagerFragment();
        }
        if (fragment4 == null) {
            fragment4 = new SmilyDetailPagerFragment();
        }
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        if (vpfsEmojiContanier != null) {
            vpfsEmojiContanier.setAdapter(new SmilyViewPagerAdapter(getChildFragmentManager(), fragments));
            vpfsEmojiContanier.setCurrentItem(0);
            vpfsEmojiContanier.setOnPageChangeListener(new MyPagerChangeListener());
        }
        List<EmojiModel> tempEmoji1 = new ArrayList<>();
        List<EmojiModel> tempEmoji2 = new ArrayList<>();
        List<EmojiModel> tempEmoji3 = new ArrayList<>();
        List<EmojiModel> tempEmoji4 = new ArrayList<>();
        for (int i = 0; i < emojiList.size(); i++) {
            if (i <= 26) {
                tempEmoji1.add(emojiList.get(i));
            } else if (i <= 53) {
                tempEmoji2.add(emojiList.get(i));
            } else if (i <= 80) {
                tempEmoji3.add(emojiList.get(i));
            } else if (i <= 98) {
                tempEmoji4.add(emojiList.get(i));
            }
        }
        if (mEmojiClickListener != null) {
            fragment1.setData(tempEmoji1, mEmojiClickListener);
            fragment2.setData(tempEmoji2, mEmojiClickListener);
            fragment3.setData(tempEmoji3, mEmojiClickListener);
            fragment4.setData(tempEmoji4, mEmojiClickListener);
        }
    }

    public void setOnEmojiClickListener(OnEmojiClickListener listener) {
        if (listener != null) {
            this.mEmojiClickListener = listener;
        }
    }

    /**
     * 设置一个ViewPager的侦听事件
     */
    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }
}
