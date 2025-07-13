package u1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.ViewCompat;
import g2.n;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f3768h = {0, 7, 8, 15};

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f3769i = {0, 119, -120, -1};

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f3770j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f3771a;
    public final Paint b;
    public final Canvas c;
    public final c d;

    /* renamed from: e  reason: collision with root package name */
    public final b f3772e;

    /* renamed from: f  reason: collision with root package name */
    public final i f3773f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f3774g;

    public j(int i3, int i5) {
        Paint paint = new Paint();
        this.f3771a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.c = new Canvas();
        this.d = new c(719, 575, 0, 719, 0, 575);
        this.f3772e = new b(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, b(), c());
        this.f3773f = new i(i3, i5);
    }

    public static byte[] a(int i3, int i5, n nVar) {
        byte[] bArr = new byte[i3];
        for (int i6 = 0; i6 < i3; i6++) {
            bArr[i6] = (byte) nVar.g(i5);
        }
        return bArr;
    }

    public static int[] b() {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i9 = 1; i9 < 16; i9++) {
            if (i9 < 8) {
                if ((i9 & 1) != 0) {
                    i6 = 255;
                } else {
                    i6 = 0;
                }
                if ((i9 & 2) != 0) {
                    i7 = 255;
                } else {
                    i7 = 0;
                }
                if ((i9 & 4) != 0) {
                    i8 = 255;
                } else {
                    i8 = 0;
                }
                iArr[i9] = d(255, i6, i7, i8);
            } else {
                int i10 = 127;
                if ((i9 & 1) != 0) {
                    i3 = 127;
                } else {
                    i3 = 0;
                }
                if ((i9 & 2) != 0) {
                    i5 = 127;
                } else {
                    i5 = 0;
                }
                if ((i9 & 4) == 0) {
                    i10 = 0;
                }
                iArr[i9] = d(255, i3, i5, i10);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i22 = 0; i22 < 256; i22++) {
            int i23 = 255;
            if (i22 < 8) {
                if ((i22 & 1) != 0) {
                    i20 = 255;
                } else {
                    i20 = 0;
                }
                if ((i22 & 2) != 0) {
                    i21 = 255;
                } else {
                    i21 = 0;
                }
                if ((i22 & 4) == 0) {
                    i23 = 0;
                }
                iArr[i22] = d(63, i20, i21, i23);
            } else {
                int i24 = i22 & 136;
                int i25 = 170;
                int i26 = 85;
                if (i24 != 0) {
                    if (i24 != 8) {
                        int i27 = 43;
                        if (i24 != 128) {
                            if (i24 == 136) {
                                if ((i22 & 1) != 0) {
                                    i16 = 43;
                                } else {
                                    i16 = 0;
                                }
                                if ((i22 & 16) != 0) {
                                    i17 = 85;
                                } else {
                                    i17 = 0;
                                }
                                int i28 = i16 + i17;
                                if ((i22 & 2) != 0) {
                                    i18 = 43;
                                } else {
                                    i18 = 0;
                                }
                                if ((i22 & 32) != 0) {
                                    i19 = 85;
                                } else {
                                    i19 = 0;
                                }
                                int i29 = i18 + i19;
                                if ((i22 & 4) == 0) {
                                    i27 = 0;
                                }
                                if ((i22 & 64) == 0) {
                                    i26 = 0;
                                }
                                iArr[i22] = d(255, i28, i29, i27 + i26);
                            }
                        } else {
                            if ((i22 & 1) != 0) {
                                i12 = 43;
                            } else {
                                i12 = 0;
                            }
                            int i30 = i12 + 127;
                            if ((i22 & 16) != 0) {
                                i13 = 85;
                            } else {
                                i13 = 0;
                            }
                            int i31 = i30 + i13;
                            if ((i22 & 2) != 0) {
                                i14 = 43;
                            } else {
                                i14 = 0;
                            }
                            int i32 = i14 + 127;
                            if ((i22 & 32) != 0) {
                                i15 = 85;
                            } else {
                                i15 = 0;
                            }
                            int i33 = i32 + i15;
                            if ((i22 & 4) == 0) {
                                i27 = 0;
                            }
                            int i34 = i27 + 127;
                            if ((i22 & 64) == 0) {
                                i26 = 0;
                            }
                            iArr[i22] = d(255, i31, i33, i34 + i26);
                        }
                    } else {
                        if ((i22 & 1) != 0) {
                            i8 = 85;
                        } else {
                            i8 = 0;
                        }
                        if ((i22 & 16) != 0) {
                            i9 = 170;
                        } else {
                            i9 = 0;
                        }
                        int i35 = i8 + i9;
                        if ((i22 & 2) != 0) {
                            i10 = 85;
                        } else {
                            i10 = 0;
                        }
                        if ((i22 & 32) != 0) {
                            i11 = 170;
                        } else {
                            i11 = 0;
                        }
                        int i36 = i10 + i11;
                        if ((i22 & 4) == 0) {
                            i26 = 0;
                        }
                        if ((i22 & 64) == 0) {
                            i25 = 0;
                        }
                        iArr[i22] = d(127, i35, i36, i26 + i25);
                    }
                } else {
                    if ((i22 & 1) != 0) {
                        i3 = 85;
                    } else {
                        i3 = 0;
                    }
                    if ((i22 & 16) != 0) {
                        i5 = 170;
                    } else {
                        i5 = 0;
                    }
                    int i37 = i3 + i5;
                    if ((i22 & 2) != 0) {
                        i6 = 85;
                    } else {
                        i6 = 0;
                    }
                    if ((i22 & 32) != 0) {
                        i7 = 170;
                    } else {
                        i7 = 0;
                    }
                    int i38 = i6 + i7;
                    if ((i22 & 4) == 0) {
                        i26 = 0;
                    }
                    if ((i22 & 64) == 0) {
                        i25 = 0;
                    }
                    iArr[i22] = d(255, i37, i38, i26 + i25);
                }
            }
        }
        return iArr;
    }

    public static int d(int i3, int i5, int i6, int i7) {
        return (i3 << 24) | (i5 << 16) | (i6 << 8) | i7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021d A[LOOP:3: B:89:0x016c->B:119:0x021d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014a A[LOOP:2: B:41:0x00aa->B:76:0x014a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017b  */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(byte[] r23, int[] r24, int r25, int r26, int r27, android.graphics.Paint r28, android.graphics.Canvas r29) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.j.e(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static b f(n nVar, int i3) {
        int[] iArr;
        int g5;
        int i5;
        int g6;
        int g7;
        int i6;
        int i7 = 8;
        int g8 = nVar.g(8);
        nVar.o(8);
        int i8 = 2;
        int i9 = i3 - 2;
        int[] iArr2 = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] b = b();
        int[] c = c();
        while (i9 > 0) {
            int g9 = nVar.g(i7);
            int g10 = nVar.g(i7);
            if ((g10 & 128) != 0) {
                iArr = iArr2;
            } else if ((g10 & 64) != 0) {
                iArr = b;
            } else {
                iArr = c;
            }
            if ((g10 & 1) != 0) {
                g7 = nVar.g(i7);
                i6 = nVar.g(i7);
                g5 = nVar.g(i7);
                g6 = nVar.g(i7);
                i5 = i9 - 6;
            } else {
                int g11 = nVar.g(4) << 4;
                g5 = nVar.g(4) << 4;
                i5 = i9 - 4;
                g6 = nVar.g(i8) << 6;
                g7 = nVar.g(6) << i8;
                i6 = g11;
            }
            if (g7 == 0) {
                i6 = 0;
                g5 = 0;
                g6 = 255;
            }
            double d = g7;
            double d5 = i6 - 128;
            double d6 = g5 - 128;
            iArr[g9] = d((byte) (255 - (g6 & 255)), w.h((int) ((1.402d * d5) + d), 0, 255), w.h((int) ((d - (0.34414d * d6)) - (d5 * 0.71414d)), 0, 255), w.h((int) ((d6 * 1.772d) + d), 0, 255));
            i9 = i5;
            g8 = g8;
            c = c;
            i7 = 8;
            i8 = 2;
        }
        return new b(g8, iArr2, b, c);
    }

    public static d g(n nVar) {
        byte[] bArr;
        boolean z3;
        int g5 = nVar.g(16);
        nVar.o(4);
        int g6 = nVar.g(2);
        boolean f4 = nVar.f();
        boolean z5 = true;
        nVar.o(1);
        byte[] bArr2 = null;
        if (g6 == 1) {
            nVar.o(nVar.g(8) * 16);
        } else if (g6 == 0) {
            int g7 = nVar.g(16);
            int g8 = nVar.g(16);
            if (g7 > 0) {
                bArr2 = new byte[g7];
                if (nVar.d == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.h(z3);
                System.arraycopy(nVar.b, nVar.c, bArr2, 0, g7);
                nVar.c += g7;
                nVar.a();
            }
            if (g8 > 0) {
                bArr = new byte[g8];
                if (nVar.d != 0) {
                    z5 = false;
                }
                g2.b.h(z5);
                System.arraycopy(nVar.b, nVar.c, bArr, 0, g8);
                nVar.c += g8;
                nVar.a();
                return new d(g5, f4, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new d(g5, f4, bArr2, bArr);
    }
}
