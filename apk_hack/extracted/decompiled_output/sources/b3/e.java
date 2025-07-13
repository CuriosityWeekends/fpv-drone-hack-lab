package b3;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.metadata.Metadata;
import com.lxj.xpopup.core.ImageViewerPopupView;
import e2.h0;
import j1.l0;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import m.b0;
import m.y;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p0.t;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements l0, l2.l, m.r, g.b, m1.i, p.k, h0, x2.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f171a;
    public final Object b;

    public /* synthetic */ e(int i3, Object obj) {
        this.f171a = i3;
        this.b = obj;
    }

    @Override // j1.l0
    public void A(long j2) {
        for (l0 l0Var : (l0[]) this.b) {
            l0Var.A(j2);
        }
    }

    public void B(int i3, int i5, p0.g gVar) {
        long j2;
        int i6;
        int i7;
        int i8;
        byte[] bArr;
        boolean z3;
        int i9;
        int i10;
        t0.e eVar = (t0.e) this.b;
        SparseArray sparseArray = eVar.c;
        int i11 = 4;
        int i12 = 1;
        int i13 = 0;
        if (i3 != 161 && i3 != 163) {
            if (i3 != 165) {
                if (i3 != 16981) {
                    if (i3 != 18402) {
                        if (i3 != 21419) {
                            if (i3 != 25506) {
                                if (i3 == 30322) {
                                    t0.c cVar = eVar.f3621u;
                                    byte[] bArr2 = new byte[i5];
                                    cVar.f3592u = bArr2;
                                    gVar.g(bArr2, 0, i5, false);
                                    return;
                                }
                                throw new IOException(a1.i.e(i3, "Unexpected id: "));
                            }
                            t0.c cVar2 = eVar.f3621u;
                            byte[] bArr3 = new byte[i5];
                            cVar2.f3583j = bArr3;
                            gVar.g(bArr3, 0, i5, false);
                            return;
                        }
                        c0.b bVar = eVar.f3611i;
                        Arrays.fill(bVar.f187a, (byte) 0);
                        gVar.g(bVar.f187a, 4 - i5, i5, false);
                        bVar.y(0);
                        eVar.w = (int) bVar.o();
                        return;
                    }
                    byte[] bArr4 = new byte[i5];
                    gVar.g(bArr4, 0, i5, false);
                    eVar.f3621u.f3582i = new t(1, 0, bArr4, 0);
                    return;
                }
                t0.c cVar3 = eVar.f3621u;
                byte[] bArr5 = new byte[i5];
                cVar3.f3581h = bArr5;
                gVar.g(bArr5, 0, i5, false);
                return;
            } else if (eVar.G == 2) {
                t0.c cVar4 = (t0.c) sparseArray.get(eVar.M);
                if (eVar.P == 4 && "V_VP9".equals(cVar4.b)) {
                    c0.b bVar2 = eVar.f3616n;
                    bVar2.v(i5);
                    gVar.g(bVar2.f187a, 0, i5, false);
                    return;
                }
                gVar.h(i5);
                return;
            } else {
                return;
            }
        }
        int i14 = eVar.G;
        c0.b bVar3 = eVar.f3609g;
        if (i14 == 0) {
            t0.f fVar = eVar.b;
            eVar.M = (int) fVar.c(gVar, false, true, 8);
            eVar.N = fVar.c;
            eVar.I = -9223372036854775807L;
            eVar.G = 1;
            bVar3.u();
        }
        t0.c cVar5 = (t0.c) sparseArray.get(eVar.M);
        if (cVar5 == null) {
            gVar.h(i5 - eVar.N);
            eVar.G = 0;
            return;
        }
        if (eVar.G == 1) {
            eVar.e(gVar, 3);
            int i15 = (bVar3.f187a[2] & 6) >> 1;
            if (i15 == 0) {
                eVar.K = 1;
                int[] iArr = eVar.L;
                if (iArr == null) {
                    iArr = new int[1];
                } else if (iArr.length < 1) {
                    iArr = new int[Math.max(iArr.length * 2, 1)];
                }
                eVar.L = iArr;
                iArr[0] = (i5 - eVar.N) - 3;
            } else {
                eVar.e(gVar, 4);
                int i16 = (bVar3.f187a[3] & 255) + 1;
                eVar.K = i16;
                int[] iArr2 = eVar.L;
                if (iArr2 == null) {
                    iArr2 = new int[i16];
                } else if (iArr2.length < i16) {
                    iArr2 = new int[Math.max(iArr2.length * 2, i16)];
                }
                eVar.L = iArr2;
                if (i15 == 2) {
                    int i17 = eVar.K;
                    Arrays.fill(iArr2, 0, i17, ((i5 - eVar.N) - 4) / i17);
                } else if (i15 == 1) {
                    int i18 = 0;
                    int i19 = 0;
                    while (true) {
                        i6 = eVar.K - 1;
                        if (i18 >= i6) {
                            break;
                        }
                        eVar.L[i18] = 0;
                        while (true) {
                            i7 = i11 + 1;
                            eVar.e(gVar, i7);
                            int i20 = bVar3.f187a[i11] & 255;
                            int[] iArr3 = eVar.L;
                            i8 = iArr3[i18] + i20;
                            iArr3[i18] = i8;
                            if (i20 != 255) {
                                break;
                            }
                            i11 = i7;
                        }
                        i19 += i8;
                        i18++;
                        i11 = i7;
                    }
                    eVar.L[i6] = ((i5 - eVar.N) - i11) - i19;
                } else if (i15 == 3) {
                    int i21 = 0;
                    int i22 = 0;
                    while (true) {
                        int i23 = eVar.K - i12;
                        if (i21 < i23) {
                            eVar.L[i21] = i13;
                            int i24 = i11 + 1;
                            eVar.e(gVar, i24);
                            if (bVar3.f187a[i11] != 0) {
                                int i25 = 0;
                                int i26 = 8;
                                while (true) {
                                    if (i25 < i26) {
                                        int i27 = i12 << (7 - i25);
                                        if ((bVar3.f187a[i11] & i27) != 0) {
                                            int i28 = i24 + i25;
                                            eVar.e(gVar, i28);
                                            int i29 = i24;
                                            j2 = bVar3.f187a[i11] & 255 & (~i27);
                                            while (true) {
                                                int i30 = i29;
                                                if (i30 >= i28) {
                                                    break;
                                                }
                                                i29 = i30 + 1;
                                                j2 = (j2 << 8) | (bVar3.f187a[i30] & 255);
                                            }
                                            if (i21 > 0) {
                                                j2 -= (1 << ((i25 * 7) + 6)) - 1;
                                            }
                                            i11 = i28;
                                        } else {
                                            i25++;
                                            i26 = 8;
                                            i12 = 1;
                                        }
                                    } else {
                                        j2 = 0;
                                        i11 = i24;
                                        break;
                                    }
                                }
                                long j5 = j2;
                                if (j5 < -2147483648L || j5 > 2147483647L) {
                                    break;
                                }
                                int i31 = (int) j5;
                                int[] iArr4 = eVar.L;
                                if (i21 != 0) {
                                    i31 += iArr4[i21 - 1];
                                }
                                iArr4[i21] = i31;
                                i22 += i31;
                                i21++;
                                i12 = 1;
                                i13 = 0;
                            } else {
                                throw new IOException("No valid varint length mask found");
                            }
                        } else {
                            eVar.L[i23] = ((i5 - eVar.N) - i11) - i22;
                            break;
                        }
                    }
                    throw new IOException("EBML lacing sample size out of range.");
                } else {
                    throw new IOException(a1.i.e(i15, "Unexpected lacing value: "));
                }
            }
            int i32 = bVar3.f187a[1] & 255;
            eVar.H = eVar.i(i32 | (bArr[0] << 8)) + eVar.B;
            byte b = bVar3.f187a[2];
            if ((b & 8) == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (cVar5.d != 2 && (i3 != 163 || (b & 128) != 128)) {
                i9 = 0;
            } else {
                i9 = 1;
            }
            if (z3) {
                i10 = Integer.MIN_VALUE;
            } else {
                i10 = 0;
            }
            eVar.O = i9 | i10;
            eVar.G = 2;
            eVar.J = 0;
        }
        if (i3 == 163) {
            while (true) {
                int i33 = eVar.J;
                if (i33 < eVar.K) {
                    eVar.a(cVar5, eVar.H + ((eVar.J * cVar5.f3578e) / 1000), eVar.O, eVar.j(gVar, cVar5, eVar.L[i33]), 0);
                    eVar.J++;
                } else {
                    eVar.G = 0;
                    return;
                }
            }
        } else {
            while (true) {
                int i34 = eVar.J;
                if (i34 < eVar.K) {
                    int[] iArr5 = eVar.L;
                    iArr5[i34] = eVar.j(gVar, cVar5, iArr5[i34]);
                    eVar.J++;
                } else {
                    return;
                }
            }
        }
    }

    public void C(int i3, long j2) {
        t0.e eVar = (t0.e) this.b;
        eVar.getClass();
        if (i3 != 20529) {
            if (i3 != 20530) {
                boolean z3 = true;
                switch (i3) {
                    case 131:
                        eVar.f3621u.d = (int) j2;
                        return;
                    case 136:
                        t0.c cVar = eVar.f3621u;
                        if (j2 != 1) {
                            z3 = false;
                        }
                        cVar.T = z3;
                        return;
                    case 155:
                        eVar.I = eVar.i(j2);
                        return;
                    case 159:
                        eVar.f3621u.M = (int) j2;
                        return;
                    case 176:
                        eVar.f3621u.f3585l = (int) j2;
                        return;
                    case 179:
                        a1.m mVar = eVar.C;
                        long i5 = eVar.i(j2);
                        int i6 = mVar.f39a;
                        long[] jArr = (long[]) mVar.b;
                        if (i6 == jArr.length) {
                            mVar.b = Arrays.copyOf(jArr, i6 * 2);
                        }
                        int i7 = mVar.f39a;
                        mVar.f39a = i7 + 1;
                        ((long[]) mVar.b)[i7] = i5;
                        return;
                    case 186:
                        eVar.f3621u.f3586m = (int) j2;
                        return;
                    case 215:
                        eVar.f3621u.c = (int) j2;
                        return;
                    case 231:
                        eVar.B = eVar.i(j2);
                        return;
                    case 238:
                        eVar.P = (int) j2;
                        return;
                    case 241:
                        if (!eVar.E) {
                            a1.m mVar2 = eVar.D;
                            int i8 = mVar2.f39a;
                            long[] jArr2 = (long[]) mVar2.b;
                            if (i8 == jArr2.length) {
                                mVar2.b = Arrays.copyOf(jArr2, i8 * 2);
                            }
                            int i9 = mVar2.f39a;
                            mVar2.f39a = i9 + 1;
                            ((long[]) mVar2.b)[i9] = j2;
                            eVar.E = true;
                            return;
                        }
                        return;
                    case 251:
                        eVar.Q = true;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw new IOException("ContentCompAlgo " + j2 + " not supported");
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw new IOException("DocTypeReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw new IOException("EBMLReadVersion " + j2 + " not supported");
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw new IOException("ContentEncAlgo " + j2 + " not supported");
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw new IOException("AESSettingsCipherMode " + j2 + " not supported");
                        }
                        return;
                    case 21420:
                        eVar.f3623x = j2 + eVar.q;
                        return;
                    case 21432:
                        int i10 = (int) j2;
                        if (i10 != 0) {
                            if (i10 != 1) {
                                if (i10 != 3) {
                                    if (i10 == 15) {
                                        eVar.f3621u.f3593v = 3;
                                        return;
                                    }
                                    return;
                                }
                                eVar.f3621u.f3593v = 1;
                                return;
                            }
                            eVar.f3621u.f3593v = 2;
                            return;
                        }
                        eVar.f3621u.f3593v = 0;
                        return;
                    case 21680:
                        eVar.f3621u.f3587n = (int) j2;
                        return;
                    case 21682:
                        eVar.f3621u.f3589p = (int) j2;
                        return;
                    case 21690:
                        eVar.f3621u.f3588o = (int) j2;
                        return;
                    case 21930:
                        t0.c cVar2 = eVar.f3621u;
                        if (j2 != 1) {
                            z3 = false;
                        }
                        cVar2.S = z3;
                        return;
                    case 21998:
                        eVar.f3621u.f3579f = (int) j2;
                        return;
                    case 22186:
                        eVar.f3621u.P = j2;
                        return;
                    case 22203:
                        eVar.f3621u.Q = j2;
                        return;
                    case 25188:
                        eVar.f3621u.N = (int) j2;
                        return;
                    case 30321:
                        int i11 = (int) j2;
                        if (i11 != 0) {
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    if (i11 == 3) {
                                        eVar.f3621u.q = 3;
                                        return;
                                    }
                                    return;
                                }
                                eVar.f3621u.q = 2;
                                return;
                            }
                            eVar.f3621u.q = 1;
                            return;
                        }
                        eVar.f3621u.q = 0;
                        return;
                    case 2352003:
                        eVar.f3621u.f3578e = (int) j2;
                        return;
                    case 2807729:
                        eVar.f3619r = j2;
                        return;
                    default:
                        switch (i3) {
                            case 21945:
                                int i12 = (int) j2;
                                if (i12 != 1) {
                                    if (i12 == 2) {
                                        eVar.f3621u.f3596z = 1;
                                        return;
                                    }
                                    return;
                                }
                                eVar.f3621u.f3596z = 2;
                                return;
                            case 21946:
                                int i13 = (int) j2;
                                if (i13 != 1) {
                                    if (i13 != 16) {
                                        if (i13 != 18) {
                                            if (i13 != 6 && i13 != 7) {
                                                return;
                                            }
                                        } else {
                                            eVar.f3621u.f3595y = 7;
                                            return;
                                        }
                                    } else {
                                        eVar.f3621u.f3595y = 6;
                                        return;
                                    }
                                }
                                eVar.f3621u.f3595y = 3;
                                return;
                            case 21947:
                                t0.c cVar3 = eVar.f3621u;
                                cVar3.w = true;
                                int i14 = (int) j2;
                                if (i14 != 1) {
                                    if (i14 != 9) {
                                        if (i14 == 4 || i14 == 5 || i14 == 6 || i14 == 7) {
                                            cVar3.f3594x = 2;
                                            return;
                                        }
                                        return;
                                    }
                                    cVar3.f3594x = 6;
                                    return;
                                }
                                cVar3.f3594x = 1;
                                return;
                            case 21948:
                                eVar.f3621u.A = (int) j2;
                                return;
                            case 21949:
                                eVar.f3621u.B = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw new IOException("ContentEncodingScope " + j2 + " not supported");
            }
        } else if (j2 == 0) {
        } else {
            throw new IOException("ContentEncodingOrder " + j2 + " not supported");
        }
    }

    public void D() {
        ImageViewerPopupView imageViewerPopupView = (ImageViewerPopupView) this.b;
        Executors.newSingleThreadExecutor().execute(new d(imageViewerPopupView.getContext(), imageViewerPopupView.w.get(imageViewerPopupView.getRealPosition())));
    }

    public void E(float f4, float f5, float f6) {
        switch (this.f171a) {
            case 4:
                f3.o oVar = (f3.o) this.b;
                if (oVar.d() < oVar.f1875e || f4 < 1.0f) {
                    oVar.getClass();
                    oVar.f1883m.postScale(f4, f4, f5, f6);
                    oVar.a();
                    return;
                }
                return;
            default:
                i0.i iVar = (i0.i) this.b;
                if (iVar.d() < iVar.f2159e || f4 < 1.0f) {
                    iVar.getClass();
                    iVar.f2167m.postScale(f4, f4, f5, f6);
                    iVar.a();
                    return;
                }
                return;
        }
    }

    public Metadata F(p0.g gVar, a1.f fVar) {
        c0.b bVar = (c0.b) this.b;
        Metadata metadata = null;
        int i3 = 0;
        while (true) {
            try {
                gVar.d(bVar.f187a, 0, 10, false);
                bVar.y(0);
                if (bVar.p() != 4801587) {
                    break;
                }
                bVar.z(3);
                int m5 = bVar.m();
                int i5 = m5 + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i5];
                    System.arraycopy(bVar.f187a, 0, bArr, 0, 10);
                    gVar.d(bArr, 10, m5, false);
                    metadata = new f1.b(fVar).b(bArr, i5);
                } else {
                    gVar.a(m5, false);
                }
                i3 += i5;
            } catch (EOFException unused) {
            }
        }
        gVar.f3111f = 0;
        gVar.a(i3, false);
        return metadata;
    }

    public int G(byte[] bArr, int i3) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3 && (i6 = ((InputStream) this.b).read(bArr, i5, i3 - i5)) != -1) {
            i5 += i6;
        }
        if (i5 == 0 && i6 == -1) {
            throw new p.j();
        }
        return i5;
    }

    public void H(int i3) {
        ((Handler) this.b).sendEmptyMessage(i3);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [t0.c, java.lang.Object] */
    public void I(int i3, long j2, long j5) {
        t0.e eVar = (t0.e) this.b;
        eVar.getClass();
        if (i3 != 160) {
            if (i3 != 174) {
                if (i3 != 187) {
                    if (i3 != 19899) {
                        if (i3 != 20533) {
                            if (i3 != 21968) {
                                if (i3 != 408125543) {
                                    if (i3 != 475249515) {
                                        if (i3 == 524531317 && !eVar.f3622v) {
                                            if (eVar.d && eVar.f3625z != -1) {
                                                eVar.f3624y = true;
                                                return;
                                            }
                                            eVar.f3606a0.a(new p0.n(eVar.f3620t));
                                            eVar.f3622v = true;
                                            return;
                                        }
                                        return;
                                    }
                                    eVar.C = new a1.m(2);
                                    eVar.D = new a1.m(2);
                                    return;
                                }
                                long j6 = eVar.q;
                                if (j6 != -1 && j6 != j2) {
                                    throw new IOException("Multiple Segment elements not supported");
                                }
                                eVar.q = j2;
                                eVar.f3618p = j5;
                                return;
                            }
                            eVar.f3621u.w = true;
                            return;
                        }
                        eVar.f3621u.f3580g = true;
                        return;
                    }
                    eVar.w = -1;
                    eVar.f3623x = -1L;
                    return;
                }
                eVar.E = false;
                return;
            }
            ?? obj = new Object();
            obj.f3585l = -1;
            obj.f3586m = -1;
            obj.f3587n = -1;
            obj.f3588o = -1;
            obj.f3589p = 0;
            obj.q = -1;
            obj.f3590r = 0.0f;
            obj.s = 0.0f;
            obj.f3591t = 0.0f;
            obj.f3592u = null;
            obj.f3593v = -1;
            obj.w = false;
            obj.f3594x = -1;
            obj.f3595y = -1;
            obj.f3596z = -1;
            obj.A = 1000;
            obj.B = 200;
            obj.C = -1.0f;
            obj.D = -1.0f;
            obj.E = -1.0f;
            obj.F = -1.0f;
            obj.G = -1.0f;
            obj.H = -1.0f;
            obj.I = -1.0f;
            obj.J = -1.0f;
            obj.K = -1.0f;
            obj.L = -1.0f;
            obj.M = 1;
            obj.N = -1;
            obj.O = 8000;
            obj.P = 0L;
            obj.Q = 0L;
            obj.T = true;
            obj.U = "eng";
            eVar.f3621u = obj;
            return;
        }
        eVar.Q = false;
    }

    @Override // m1.i
    public long a(long j2) {
        return 0L;
    }

    @Override // m1.i
    public long c(long j2, long j5) {
        return 0L;
    }

    @Override // j1.l0
    public boolean d() {
        for (l0 l0Var : (l0[]) this.b) {
            if (l0Var.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // e2.h0
    public Object f(Uri uri, e2.k kVar) {
        try {
            XmlPullParser newPullParser = ((XmlPullParserFactory) this.b).newPullParser();
            newPullParser.setInput(kVar, null);
            return (r1.c) new r1.g(uri.toString()).e(newPullParser);
        } catch (XmlPullParserException e5) {
            throw new IOException(e5);
        }
    }

    @Override // p.k
    public short g() {
        int read = ((InputStream) this.b).read();
        if (read != -1) {
            return (short) read;
        }
        throw new p.j();
    }

    @Override // j1.l0
    public long i() {
        long j2 = Long.MAX_VALUE;
        for (l0 l0Var : (l0[]) this.b) {
            long i3 = l0Var.i();
            if (i3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, i3);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // g.b
    public boolean k(Object obj, File file, g.h hVar) {
        InputStream inputStream = (InputStream) obj;
        j.g gVar = (j.g) this.b;
        byte[] bArr = (byte[]) gVar.d(byte[].class, 65536);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (IOException e5) {
                        e = e5;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        gVar.h(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        gVar.h(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                gVar.h(bArr);
                return true;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // m1.i
    public n1.i l(long j2) {
        return (n1.i) this.b;
    }

    @Override // p.k
    public int m() {
        return (g() << 8) | g();
    }

    @Override // m.r
    public m.q n(y yVar) {
        switch (this.f171a) {
            case 17:
                return new m.c(1, (b0) this.b);
            default:
                return new n.a((e) this.b);
        }
    }

    @Override // m1.i
    public boolean p() {
        return true;
    }

    @Override // m1.i
    public long r() {
        return 0L;
    }

    @Override // j1.l0
    public long s() {
        long j2 = Long.MAX_VALUE;
        for (l0 l0Var : (l0[]) this.b) {
            long s = l0Var.s();
            if (s != Long.MIN_VALUE) {
                j2 = Math.min(j2, s);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // p.k
    public long skip(long j2) {
        if (j2 < 0) {
            return 0L;
        }
        long j5 = j2;
        while (j5 > 0) {
            InputStream inputStream = (InputStream) this.b;
            long skip = inputStream.skip(j5);
            if (skip > 0) {
                j5 -= skip;
            } else if (inputStream.read() == -1) {
                break;
            } else {
                j5--;
            }
        }
        return j2 - j5;
    }

    @Override // m1.i
    public int v(long j2) {
        return 1;
    }

    @Override // l2.l
    public Object x() {
        switch (this.f171a) {
            case 15:
                Constructor constructor = (Constructor) this.b;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e5) {
                    throw new AssertionError(e5);
                } catch (InstantiationException e6) {
                    throw new RuntimeException("Failed to invoke " + constructor + " with no args", e6);
                } catch (InvocationTargetException e7) {
                    throw new RuntimeException("Failed to invoke " + constructor + " with no args", e7.getTargetException());
                }
            default:
                Type type = (Type) this.b;
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return EnumSet.noneOf((Class) type2);
                    }
                    throw new RuntimeException("Invalid EnumSet type: " + type.toString());
                }
                throw new RuntimeException("Invalid EnumSet type: " + type.toString());
        }
    }

    @Override // j1.l0
    public boolean y(long j2) {
        l0[] l0VarArr;
        boolean z3;
        boolean z5;
        boolean z6 = false;
        do {
            long i3 = i();
            if (i3 == Long.MIN_VALUE) {
                break;
            }
            z3 = false;
            for (l0 l0Var : (l0[]) this.b) {
                long i5 = l0Var.i();
                if (i5 != Long.MIN_VALUE && i5 <= j2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i5 == i3 || z5) {
                    z3 |= l0Var.y(j2);
                }
            }
            z6 |= z3;
        } while (z3);
        return z6;
    }

    public e(Context context) {
        this.f171a = 11;
        this.b = new c1.b(context, 12);
    }

    public e(int i3) {
        this.f171a = i3;
        switch (i3) {
            case 17:
                this.b = new b0(7);
                return;
            case 18:
                this.b = new c0.j(500L);
                return;
            case 19:
            case 21:
            case 22:
            case 24:
            case 26:
            default:
                this.b = new CopyOnWriteArrayList();
                return;
            case 20:
                this.b = new e(18);
                return;
            case 23:
                this.b = new o1.c(5);
                return;
            case 25:
                this.b = new c0.b(10);
                return;
            case 27:
                try {
                    this.b = XmlPullParserFactory.newInstance();
                    return;
                } catch (XmlPullParserException e5) {
                    throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
                }
        }
    }

    @Override // m1.i
    public long e(long j2, long j5) {
        return j5;
    }
}
