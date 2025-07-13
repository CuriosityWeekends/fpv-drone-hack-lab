package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1486a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b5 = bArr[i3];
                int i5 = i3 * 2;
                char[] cArr2 = b;
                cArr[i5 + 1] = cArr2[b5 & 15];
                cArr[i5] = cArr2[((byte) (b5 >>> 4)) & 15];
            }
            return new String(cArr);
        }
        return null;
    }
}
