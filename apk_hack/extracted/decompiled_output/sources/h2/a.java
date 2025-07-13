package h2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List f1986a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final float f1987e;

    public a(ArrayList arrayList, int i3, int i5, int i6, float f4) {
        this.f1986a = arrayList;
        this.b = i3;
        this.c = i5;
        this.d = i6;
        this.f1987e = f4;
    }

    public static a a(c0.b bVar) {
        byte[] bArr;
        int i3;
        int i5;
        float f4;
        try {
            bVar.z(4);
            int n5 = (bVar.n() & 3) + 1;
            if (n5 != 3) {
                ArrayList arrayList = new ArrayList();
                int n6 = bVar.n() & 31;
                int i6 = 0;
                while (true) {
                    bArr = g2.b.f1913a;
                    if (i6 >= n6) {
                        break;
                    }
                    int s = bVar.s();
                    int i7 = bVar.b;
                    bVar.z(s);
                    byte[] bArr2 = bVar.f187a;
                    byte[] bArr3 = new byte[s + 4];
                    System.arraycopy(bArr, 0, bArr3, 0, 4);
                    System.arraycopy(bArr2, i7, bArr3, 4, s);
                    arrayList.add(bArr3);
                    i6++;
                }
                int n7 = bVar.n();
                for (int i8 = 0; i8 < n7; i8++) {
                    int s5 = bVar.s();
                    int i9 = bVar.b;
                    bVar.z(s5);
                    byte[] bArr4 = bVar.f187a;
                    byte[] bArr5 = new byte[s5 + 4];
                    System.arraycopy(bArr, 0, bArr5, 0, 4);
                    System.arraycopy(bArr4, i9, bArr5, 4, s5);
                    arrayList.add(bArr5);
                }
                if (n6 > 0) {
                    g2.m v5 = g2.b.v((byte[]) arrayList.get(0), n5, ((byte[]) arrayList.get(0)).length);
                    int i10 = v5.f1936e;
                    int i11 = v5.f1937f;
                    f4 = v5.f1938g;
                    i3 = i10;
                    i5 = i11;
                } else {
                    i3 = -1;
                    i5 = -1;
                    f4 = 1.0f;
                }
                return new a(arrayList, n5, i3, i5, f4);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new IOException("Error parsing AVC config", e5);
        }
    }
}
