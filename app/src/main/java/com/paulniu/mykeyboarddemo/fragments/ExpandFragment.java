package com.paulniu.mykeyboarddemo.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.paulniu.mykeyboarddemo.R;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 16:43
 * Desc: 更多页面
 * Version:
 */
public class ExpandFragment extends Fragment implements View.OnClickListener {

    public static ExpandFragment getInstance() {
        ExpandFragment fragment = new ExpandFragment();
        return fragment;
    }

    private View root;

    private ImageView ivFeAlbum;
    private ImageView ivFePhoto;
    private ImageView ivFePosition;
    private ImageView ivFeRecorder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_expand, container, false);
        initLayoutById(root);
        initViewListener();
        return root;
    }

    private void initLayoutById(View root) {
        if (root != null) {
            ivFeAlbum = root.findViewById(R.id.ivFeAlbum);
            ivFePhoto = root.findViewById(R.id.ivFePhoto);
            ivFePosition = root.findViewById(R.id.ivFePosition);
            ivFeRecorder = root.findViewById(R.id.ivFeRecorder);
        }
    }

    private void initViewListener() {
        if (ivFeAlbum != null) {
            ivFeAlbum.setOnClickListener(this);
        }
        if (ivFePhoto != null) {
            ivFePhoto.setOnClickListener(this);
        }
        if (ivFePosition != null) {
            ivFePosition.setOnClickListener(this);
        }
        if (ivFeRecorder != null) {
            ivFeRecorder.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivFeAlbum:

                break;
            case R.id.ivFePhoto:

                break;
            case R.id.ivFePosition:

                break;
            case R.id.ivFeRecorder:

                break;
        }
    }
}
