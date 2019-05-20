package com.paulniu.mykeyboarddemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.paulniu.mykeyboarddemo.models.EmojiModel;
import com.paulniu.mykeyboarddemo.R;
import com.paulniu.mykeyboarddemo.fragments.SmilyFragment;
import com.paulniu.mykeyboarddemo.utils.ScreenUtil;

import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/5/20
 * Time: 10:04
 * Desc:
 * Version:
 */
public class EmojiAdapter extends CommonEmojiAdapter<EmojiModel> {
    private Context context;

    public EmojiAdapter(Context context, List<EmojiModel> dataList) {
        super(context, dataList, R.layout.item_emoji);
        this.context = context;
    }

    @Override
    protected EmojiModel clone(EmojiModel data) {
        return new EmojiModel(data.getName(), data.getId());
    }

    @Override
    protected boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
    protected boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @NonNull
    @Override
    protected Bundle getChangePayload(int oldItemPosition, int newItemPosition) {
        return null;
    }

    @Override
    protected void partialBindData(EmojiViewHolder holder, @NonNull Bundle bundle) {

    }

    @Override
    protected void entirelyBindData(EmojiViewHolder holder, EmojiModel data, int position) {
        final int spanCount = SmilyFragment.RECYCLER_VIEW_SPAN_COUNT;
        int screenWidth = ScreenUtil.getScreenWidth((Activity) context);
        int spacing = ScreenUtil.dp2px(context, 4);
        int temp = spacing * (spanCount + 1);
        int emoticonSideLength = (screenWidth - temp) / spanCount;
        holder.setImageResource(R.id.iv_emoticon, data.getId())
                .setViewPadding(R.id.iv_emoticon, temp / spanCount, temp / spanCount, 0, 0)
                .setImageViewLayoutParams(R.id.iv_emoticon, emoticonSideLength, emoticonSideLength);
    }
}
