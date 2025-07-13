package y0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f4090e = {0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    public boolean f4091a;
    public int b;
    public int c;
    public byte[] d;

    public final void a(byte[] bArr, int i3, int i5) {
        if (!this.f4091a) {
            return;
        }
        int i6 = i5 - i3;
        byte[] bArr2 = this.d;
        int length = bArr2.length;
        int i7 = this.b;
        if (length < i7 + i6) {
            this.d = Arrays.copyOf(bArr2, (i7 + i6) * 2);
        }
        System.arraycopy(bArr, i3, this.d, this.b, i6);
        this.b += i6;
    }
}
