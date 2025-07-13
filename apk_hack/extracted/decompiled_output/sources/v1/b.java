package v1;

import android.graphics.Bitmap;
import g2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import s1.c;
import s1.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends c {

    /* renamed from: n  reason: collision with root package name */
    public final c0.b f3884n = new c0.b();

    /* renamed from: o  reason: collision with root package name */
    public final c0.b f3885o = new c0.b();

    /* renamed from: p  reason: collision with root package name */
    public final a f3886p = new a();
    public Inflater q;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // s1.c
    public final e e(byte[] bArr, int i3, boolean z3) {
        s1.b bVar;
        s1.b bVar2;
        c0.b bVar3;
        int i5;
        int i6;
        int n5;
        int i7;
        c0.b bVar4;
        boolean z5;
        int p5;
        c0.b bVar5 = this.f3884n;
        bVar5.w(bArr, i3);
        if (bVar5.a() > 0 && (bVar5.f187a[bVar5.b] & 255) == 120) {
            if (this.q == null) {
                this.q = new Inflater();
            }
            Inflater inflater = this.q;
            c0.b bVar6 = this.f3885o;
            if (w.t(bVar5, bVar6, inflater)) {
                bVar5.w(bVar6.f187a, bVar6.c);
            }
        }
        a aVar = this.f3886p;
        int i8 = 0;
        aVar.d = 0;
        aVar.f3879e = 0;
        aVar.f3880f = 0;
        aVar.f3881g = 0;
        aVar.f3882h = 0;
        aVar.f3883i = 0;
        c0.b bVar7 = aVar.f3878a;
        bVar7.v(0);
        aVar.c = false;
        ArrayList arrayList = new ArrayList();
        while (bVar5.a() >= 3) {
            int i9 = bVar5.c;
            int n6 = bVar5.n();
            int s = bVar5.s();
            int i10 = bVar5.b + s;
            if (i10 > i9) {
                bVar5.y(i9);
                bVar3 = bVar5;
                bVar2 = null;
            } else {
                int[] iArr = aVar.b;
                if (n6 != 128) {
                    switch (n6) {
                        case 20:
                            if (s % 5 == 2) {
                                bVar5.z(2);
                                Arrays.fill(iArr, i8);
                                int i11 = s / 5;
                                int i12 = 0;
                                while (i12 < i11) {
                                    int n7 = bVar5.n();
                                    int n8 = bVar5.n();
                                    double d = n8;
                                    double n9 = bVar5.n() - 128;
                                    double n10 = bVar5.n() - 128;
                                    iArr[n7] = (w.h((int) ((1.402d * n9) + d), 0, 255) << 16) | (bVar5.n() << 24) | (w.h((int) ((d - (0.34414d * n10)) - (n9 * 0.71414d)), 0, 255) << 8) | w.h((int) ((n10 * 1.772d) + d), 0, 255);
                                    i12++;
                                    bVar5 = bVar5;
                                }
                                bVar4 = bVar5;
                                aVar.c = true;
                                break;
                            }
                            bVar4 = bVar5;
                            break;
                        case 21:
                            if (s >= 4) {
                                bVar5.z(3);
                                if ((128 & bVar5.n()) != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                int i13 = s - 4;
                                if (z5) {
                                    if (i13 >= 7 && (p5 = bVar5.p()) >= 4) {
                                        aVar.f3882h = bVar5.s();
                                        aVar.f3883i = bVar5.s();
                                        bVar7.v(p5 - 4);
                                        i13 = s - 11;
                                    }
                                }
                                int i14 = bVar7.b;
                                int i15 = bVar7.c;
                                if (i14 < i15 && i13 > 0) {
                                    int min = Math.min(i13, i15 - i14);
                                    bVar5.b(bVar7.f187a, i14, min);
                                    bVar7.y(i14 + min);
                                }
                            }
                            bVar4 = bVar5;
                            break;
                        case 22:
                            if (s >= 19) {
                                aVar.d = bVar5.s();
                                aVar.f3879e = bVar5.s();
                                bVar5.z(11);
                                aVar.f3880f = bVar5.s();
                                aVar.f3881g = bVar5.s();
                            }
                            bVar4 = bVar5;
                            break;
                        default:
                            bVar4 = bVar5;
                            break;
                    }
                    bVar3 = bVar4;
                    bVar2 = null;
                } else {
                    c0.b bVar8 = bVar5;
                    if (aVar.d != 0 && aVar.f3879e != 0 && aVar.f3882h != 0 && aVar.f3883i != 0 && (i5 = bVar7.c) != 0 && bVar7.b == i5 && aVar.c) {
                        bVar7.y(0);
                        int i16 = aVar.f3882h * aVar.f3883i;
                        int[] iArr2 = new int[i16];
                        int i17 = 0;
                        while (i17 < i16) {
                            int n11 = bVar7.n();
                            if (n11 != 0) {
                                i6 = i17 + 1;
                                iArr2[i17] = iArr[n11];
                            } else {
                                int n12 = bVar7.n();
                                if (n12 != 0) {
                                    if ((n12 & 64) == 0) {
                                        n5 = n12 & 63;
                                    } else {
                                        n5 = ((n12 & 63) << 8) | bVar7.n();
                                    }
                                    if ((n12 & 128) == 0) {
                                        i7 = 0;
                                    } else {
                                        i7 = iArr[bVar7.n()];
                                    }
                                    i6 = n5 + i17;
                                    Arrays.fill(iArr2, i17, i6, i7);
                                }
                            }
                            i17 = i6;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(iArr2, aVar.f3882h, aVar.f3883i, Bitmap.Config.ARGB_8888);
                        float f4 = aVar.d;
                        float f5 = aVar.f3879e;
                        bVar = new s1.b(createBitmap, aVar.f3880f / f4, aVar.f3881g / f5, 0, aVar.f3882h / f4, aVar.f3883i / f5);
                    } else {
                        bVar = null;
                    }
                    aVar.d = 0;
                    aVar.f3879e = 0;
                    aVar.f3880f = 0;
                    aVar.f3881g = 0;
                    aVar.f3882h = 0;
                    aVar.f3883i = 0;
                    bVar7.v(0);
                    aVar.c = false;
                    bVar2 = bVar;
                    bVar3 = bVar8;
                }
                bVar3.y(i10);
            }
            if (bVar2 != null) {
                arrayList.add(bVar2);
            }
            bVar5 = bVar3;
            i8 = 0;
        }
        return new a2.c(Collections.unmodifiableList(arrayList), 3);
    }
}
