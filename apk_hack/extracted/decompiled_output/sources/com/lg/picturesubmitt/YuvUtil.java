package com.lg.picturesubmitt;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class YuvUtil {
    static {
        System.loadLibrary("yuvutil");
    }

    public static native void argbToI420(byte[] bArr, int i3, int i5, byte[] bArr2);

    public static native void yuvCompress(byte[] bArr, int i3, int i5, byte[] bArr2, int i6, int i7, int i8, int i9, boolean z3);

    public static native void yuvCropI420(byte[] bArr, int i3, int i5, byte[] bArr2, int i6, int i7, int i8, int i9);

    public static native void yuvI420ToNV21(byte[] bArr, int i3, int i5, byte[] bArr2);

    public static native void yuvMirrorI420(byte[] bArr, int i3, int i5, byte[] bArr2);

    public static native void yuvNV12ToI420(byte[] bArr, int i3, int i5, byte[] bArr2);

    public static native void yuvNV21ToI420(byte[] bArr, int i3, int i5, byte[] bArr2);

    public static native void yuvRotateI420(byte[] bArr, int i3, int i5, byte[] bArr2, int i6);

    public static native void yuvScaleI420(byte[] bArr, int i3, int i5, byte[] bArr2, int i6, int i7, int i8);
}
