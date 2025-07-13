package com.shuyu.gsyvideoplayer.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    private static File getCacheDirectory(Context context, boolean z3) {
        String str;
        File file;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        if (z3 && "mounted".equals(str)) {
            file = getExternalCacheDir(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            return new File("/data/data/" + context.getPackageName() + "/cache/");
        }
        return file;
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context, true), INDIVIDUAL_DIR_NAME);
    }
}
