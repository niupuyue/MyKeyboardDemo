package com.paulniu.mykeyboarddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 16:43
 * Desc:
 * Version:
 */
public class ExpandFragment extends Fragment {

    public static ExpandFragment getInstance() {
        ExpandFragment fragment = new ExpandFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expand, container, false);
        return root;
    }
}
