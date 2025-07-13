package com.lg.picturesubmitt;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PictureAndVideoUtil {
    private static final PictureAndVideoUtil mInstance;
    private final String TAG = "PictureAndVideoUtil";

    static {
        System.loadLibrary("mjpegdec");
        mInstance = new PictureAndVideoUtil();
    }

    private PictureAndVideoUtil() {
    }

    public static PictureAndVideoUtil getInstance() {
        return mInstance;
    }

    public native void addMusic(String str, String str2, String str3);

    public native void initFFmpeg();

    public native void recieveYUVData(byte[] bArr);

    public native boolean startRecode(String str, int i3, int i5, int i6);

    public native void stopRecode();

    public native boolean takeCapture(byte[] bArr, int i3, int i5, String str);
}
