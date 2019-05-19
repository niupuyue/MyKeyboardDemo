package com.paulniu.mykeyboarddemo;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 18:18
 * Desc:
 * Version:
 */
public interface OnEmojiClickListener {
    /**
     * 表情点击事件
     *
     * @param emojiType
     * @param emojiName
     */
    void onEmojiClick(int emojiType, String emojiName);
}
