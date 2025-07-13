package com.netopsun.opencvapi;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class OpenCVAPI {
    static {
        System.loadLibrary("opencv_api");
    }

    public static native float[] caffeNetDetect(long j2, Bitmap bitmap, float f4);

    public static native long caffeNetInit(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);
}
