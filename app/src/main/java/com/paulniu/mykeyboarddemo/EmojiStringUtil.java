package com.paulniu.mykeyboarddemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 23:40
 * Desc: 将Emoji转化成字符的工具类
 * Version:
 */
public class EmojiStringUtil {

    public static SpannableString getEmojiContent(Context context, TextView textView, int emoticonType, String source) {
        SpannableString spannableString = new SpannableString(source);
        Resources res = context.getResources();
        String regexEmotion = "\\[([\u4e00-\u9fa5\\w])+\\]";
        Pattern patternEmotion = Pattern.compile(regexEmotion);
        Matcher matcherEmotion = patternEmotion.matcher(spannableString);
        while (matcherEmotion.find()) {
            // 获取匹配到的具体字符
            String key = matcherEmotion.group();
            // 匹配字符串的开始位置
            int start = matcherEmotion.start();
            // 利用表情名字获取到对应的图片
            Integer imageId = EmojiUtil.getEmojiId(emoticonType, key);
            // 压缩表情图片
            int size = (int) textView.getTextSize() * 13 / 10;
            Bitmap bitmap = BitmapFactory.decodeResource(res, imageId);
            Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
            ImageSpan span = new ImageSpan(context, scaleBitmap);
            spannableString.setSpan(span, start, start + key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }

    public static SpannableString getEmojiContent(Context context, TextView textView, SpannableString source) {
        SpannableString spannableString = new SpannableString(source);
        Resources res = context.getResources();
        String regexEmotion = "\\[([\u4e00-\u9fa5\\w])+\\]";
        Pattern patternEmotion = Pattern.compile(regexEmotion);
        Matcher matcherEmotion = patternEmotion.matcher(spannableString);
        while (matcherEmotion.find()) {
            // 获取匹配到的具体字符
            String key = matcherEmotion.group();
            // 匹配字符串的开始位置
            int start = matcherEmotion.start();
            for (int emoticonType : EmojiUtil.emojiTypeList) {
                // 利用表情名字获取到对应的图片
                Integer imageId = EmojiUtil.getEmojiId(emoticonType, key);
                if (imageId == -1) {
                    continue;
                }
                // 压缩表情图片
                int size = (int) textView.getTextSize() * 13 / 10;
                Bitmap bitmap = BitmapFactory.decodeResource(res, imageId);
                Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
                ImageSpan span = new ImageSpan(context, scaleBitmap);
                spannableString.setSpan(span, start, start + key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                break;
            }
        }
        return spannableString;
    }

}
