package com.paulniu.mykeyboarddemo.adapter;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Coder: niupuyue
 * Date: 2019/5/20
 * Time: 10:05
 * Desc:
 * Version:
 */
public class EmojiViewHolder extends RecyclerView.ViewHolder {

    public interface OnClickListener {
        void onClick(int position);
    }

    public interface OnLongClickListener {
        void onLongClick(int position);
    }

    private OnClickListener clickListener;

    private OnLongClickListener longClickListener;

    //用来存放View以减少findViewById的次数
    private SparseArray<View> viewSparseArray;

    EmojiViewHolder(View view) {
        super(view);
        viewSparseArray = new SparseArray<>();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onClick(getAdapterPosition());
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    longClickListener.onLongClick(getAdapterPosition());
                }
                return true;
            }
        });
    }

    void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    void setLongClickListener(OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    /**
     * 根据 ID 来获取 View
     *
     * @param viewId viewID
     * @param <T>    泛型
     * @return 将结果强转为 View 或 View 的子类型
     */
    public <T extends View> T getView(@IdRes int viewId) {
        // 先从缓存中找，找到的话则直接返回
        // 如果找不到则findViewById，再把结果存入缓存中
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            if (view != null) {
                viewSparseArray.put(viewId, view);
            }
        }
        return (T) view;
    }

    public EmojiViewHolder setText(@IdRes int viewId, CharSequence text) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(text);
        }
        return this;
    }

    public EmojiViewHolder setImageResource(@IdRes int viewId, @DrawableRes int resourceId) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageResource(resourceId);
        }
        return this;
    }

    public EmojiViewHolder setImageResource(@IdRes int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public EmojiViewHolder setViewVisibility(@IdRes int viewId, int visibility) {
        View view = getView(viewId);
        if (view != null) {
            view.setVisibility(visibility);
        }
        return this;
    }


    public EmojiViewHolder setViewPadding(@IdRes int viewId, int left, int top, int right, int bottom) {
        View view = getView(viewId);
        if (view != null) {
            view.setPadding(left, top, right, bottom);
        }
        return this;
    }

    public EmojiViewHolder setImageViewLayoutParams(@IdRes int viewId, int width, int height) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(width, height);
            imageView.setLayoutParams(params);
        }
        return this;
    }

    public EmojiViewHolder setOnClickListener(@IdRes int viewId, View.OnClickListener clickListener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(clickListener);
        }
        return this;
    }

    public EmojiViewHolder setOnLongClickListener(@IdRes int viewId, View.OnLongClickListener clickListener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnLongClickListener(clickListener);
        }
        return this;
    }

}
