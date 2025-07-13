package com.shuyu.gsyvideoplayer.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FileUtils {
    public static final String NAME = "GSYVideo";
    public static final String NAME_TEST = "GSYVideoTest";
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();

    public static void deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }

    public static String getAppPath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(SD_PATH);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String getPath() {
        String appPath = getAppPath(NAME);
        File file = new File(appPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return appPath;
    }

    public static String getTestPath() {
        String appPath = getAppPath(NAME_TEST);
        File file = new File(appPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return appPath;
    }

    public static void saveBitmap(Bitmap bitmap, File file) {
        if (bitmap != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
                bitmap.recycle();
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            }
        }
    }
}
