package com.paulniu.panllibrary.utils;

import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;

import java.io.File;

/**
 * Desc: 语音缓冲初始化工具类
 */
public class UtilityRecordCache {

    private static UtilityRecordCache instance = null;

    private Context context;

    private UtilityRecordCache(Context context) {
        this.context = context;
    }

    public static UtilityRecordCache getInstance(Context context) {
        if (instance == null) {
            instance = new UtilityRecordCache(context);
        }
        return instance;
    }

    private static HttpProxyCacheServer proxy;

    /**
     * 初始化语音缓存
     */
    public HttpProxyCacheServer getProxy() {
        return proxy == null ? (proxy = newProxy()) : proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer.Builder(context)
                .cacheDirectory(new File(context.getExternalCacheDir(), "audio_cache"))
                .maxCacheFilesCount(100)
                .maxCacheSize(1024 * 1024 * 10)// 最多存储10M的内容
                .build();
    }

}
