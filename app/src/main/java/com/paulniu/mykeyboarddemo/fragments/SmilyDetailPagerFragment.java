package com.paulniu.mykeyboarddemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paulniu.mykeyboarddemo.callbacks.OnEmojiClickListener;
import com.paulniu.mykeyboarddemo.R;
import com.paulniu.mykeyboarddemo.adapter.EmojiAdapter;
import com.paulniu.mykeyboarddemo.adapter.EmojiViewHolder;
import com.paulniu.mykeyboarddemo.models.EmojiModel;
import com.paulniu.mykeyboarddemo.utils.EmojiUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/5/20
 * Time: 9:44
 * Desc: 表情详情页面
 * Version:
 */
public class SmilyDetailPagerFragment extends Fragment implements EmojiViewHolder.OnClickListener {

    private static final String TAG = SmilyDetailPagerFragment.class.getSimpleName();

    private View root;
    private RecyclerView rvSdpfSmilyContainer;
    private List<EmojiModel> emojiModels;
    private EmojiAdapter emojiAdapter;
    private OnEmojiClickListener emojiClickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_smily_detail_pager, container, false);
        initExtraData();
        initLayoutById(root);
        initViewListener();
        initDataAfterInitLayout();
        return root;
    }

    private void initExtraData() {
    }

    private void initLayoutById(View root) {
        if (root != null) {
            rvSdpfSmilyContainer = root.findViewById(R.id.rvSdpfSmilyContainer);
        }
    }

    private void initViewListener() {
    }

    private void initDataAfterInitLayout() {
        if (emojiModels != null && emojiModels.size() > 0) {
            if (emojiModels.size() != 27) {
                for (int i = 0; i < 27 - emojiModels.size(); i++) {
                    EmojiModel emojiModelEmpty = new EmojiModel("[emoji100]", R.drawable.aliwx_shanchu_nm);
                    emojiModels.add(emojiModelEmpty);
                }
            }
            // 需要创建删除表情按钮
            EmojiModel emojiModelDelete = new EmojiModel("[emoji99]", R.drawable.aliwx_shanchu_nm);
            emojiModels.add(emojiModelDelete);
            emojiAdapter = new EmojiAdapter(getContext(), emojiModels);
            emojiAdapter.setClickListener(this);
            rvSdpfSmilyContainer.setAdapter(emojiAdapter);
            rvSdpfSmilyContainer.setLayoutManager(new GridLayoutManager(getContext(), SmilyFragment.RECYCLER_VIEW_SPAN_COUNT));
        }
    }

    public void setData(List<EmojiModel> emojiModels, OnEmojiClickListener listener) {
        if (emojiModels != null && emojiModels.size() > 0) {
            this.emojiModels = emojiModels;
        } else {
            emojiModels = new ArrayList<>();
        }
        if (listener != null) {
            this.emojiClickListener = listener;
        }
    }

    /**
     * 表情点击事件
     *
     * @param position
     */
    @Override
    public void onClick(int position) {
        if (emojiClickListener != null) {
            emojiClickListener.onEmojiClick(EmojiUtil.EMOJI_TYPE_CLASSICS, emojiModels.get(position).getName());
        }
    }
}
