package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1510a;
    private static final byte[] b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = bArr[i3 >>> 4];
            bArr3[i3] = bArr[i3 & 15];
        }
        f1510a = bArr2;
        b = bArr3;
    }

    public static boolean a(int i3, int i5) {
        return i3 == i5;
    }

    public static boolean a(long j2, long j5) {
        return j2 == j5;
    }

    public static boolean a(boolean z3, boolean z5) {
        return z3 == z5;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
