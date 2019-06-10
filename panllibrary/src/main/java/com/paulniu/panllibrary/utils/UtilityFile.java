package com.paulniu.panllibrary.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Coder: niupuyue
 * Date: 2019/6/10
 * Time: 11:22
 * Desc:
 * Version:
 */
public class UtilityFile {

    /**
     * 创建录音文件
     *
     * @param rootPath
     * @return
     */
    public static File createAudioFile(String rootPath) {
        try {
            File file = new File(rootPath);
            File audioFile = null;
            if (!file.exists()) {
                file.mkdirs();
            }
            audioFile = File.createTempFile("record_" + System.currentTimeMillis(), "", file);
            return audioFile;
        } catch (Exception ex) {
        }
        return null;

    }

    /**
     * 获取创建录音文件的路径
     */
    public static String getFilePath() {
        String filePath = "";
        try {
            filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "recorder/cache/file";
        } catch (Exception ex) {
        }
        return filePath;
    }
}
