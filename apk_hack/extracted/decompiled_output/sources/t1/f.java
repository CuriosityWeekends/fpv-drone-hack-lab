package t1;

import a1.i;
import android.text.SpannableStringBuilder;
import android.util.Log;
import g2.n;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends h {

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3671g = new c0.b();

    /* renamed from: h  reason: collision with root package name */
    public final n f3672h = new n();

    /* renamed from: i  reason: collision with root package name */
    public final int f3673i;

    /* renamed from: j  reason: collision with root package name */
    public final e[] f3674j;

    /* renamed from: k  reason: collision with root package name */
    public e f3675k;

    /* renamed from: l  reason: collision with root package name */
    public List f3676l;

    /* renamed from: m  reason: collision with root package name */
    public List f3677m;

    /* renamed from: n  reason: collision with root package name */
    public n f3678n;

    /* renamed from: o  reason: collision with root package name */
    public int f3679o;

    public f(int i3) {
        this.f3673i = i3 == -1 ? 1 : i3;
        this.f3674j = new e[8];
        for (int i5 = 0; i5 < 8; i5++) {
            this.f3674j[i5] = new e();
        }
        this.f3675k = this.f3674j[0];
        j();
    }

    @Override // t1.h
    public final a2.c e() {
        List list = this.f3676l;
        this.f3677m = list;
        return new a2.c(list, 1);
    }

    @Override // t1.h
    public final void f(g gVar) {
        boolean z3;
        byte[] array = gVar.b.array();
        int limit = gVar.b.limit();
        c0.b bVar = this.f3671g;
        bVar.w(array, limit);
        while (bVar.a() >= 3) {
            int n5 = bVar.n();
            int i3 = n5 & 3;
            boolean z5 = false;
            if ((n5 & 4) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            byte n6 = (byte) bVar.n();
            byte n7 = (byte) bVar.n();
            if (i3 == 2 || i3 == 3) {
                if (z3) {
                    if (i3 == 3) {
                        h();
                        int i5 = (n6 & 192) >> 6;
                        int i6 = n6 & 63;
                        if (i6 == 0) {
                            i6 = 64;
                        }
                        n nVar = new n(i5, i6);
                        this.f3678n = nVar;
                        nVar.f1946e = 1;
                        nVar.b[0] = n7;
                    } else {
                        if (i3 == 2) {
                            z5 = true;
                        }
                        g2.b.e(z5);
                        n nVar2 = this.f3678n;
                        if (nVar2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            int i7 = nVar2.f1946e;
                            byte[] bArr = nVar2.b;
                            bArr[i7] = n6;
                            nVar2.f1946e = i7 + 2;
                            bArr[i7 + 1] = n7;
                        }
                    }
                    n nVar3 = this.f3678n;
                    if (nVar3.f1946e == (nVar3.d * 2) - 1) {
                        h();
                    }
                }
            }
        }
    }

    @Override // t1.h, m0.b
    public final void flush() {
        super.flush();
        this.f3676l = null;
        this.f3677m = null;
        this.f3679o = 0;
        this.f3675k = this.f3674j[0];
        j();
        this.f3678n = null;
    }

    @Override // t1.h
    public final boolean g() {
        if (this.f3676l != this.f3677m) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void h() {
        String str;
        String str2;
        e eVar;
        n nVar = this.f3678n;
        if (nVar == null) {
            return;
        }
        int i3 = nVar.f1946e;
        int i5 = 2;
        String str3 = "Cea708Decoder";
        if (i3 != (nVar.d * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f3678n.d * 2) - 1) + ", but current index is " + this.f3678n.f1946e + " (sequence number " + this.f3678n.c + "); ignoring packet");
        } else {
            byte[] bArr = nVar.b;
            n nVar2 = this.f3672h;
            nVar2.k(bArr, i3);
            int i6 = 3;
            int g5 = nVar2.g(3);
            int g6 = nVar2.g(5);
            int i7 = 7;
            if (g5 == 7) {
                nVar2.o(2);
                g5 = nVar2.g(6);
                if (g5 < 7) {
                    i.r("Invalid extended service number: ", g5, "Cea708Decoder");
                }
            }
            if (g6 == 0) {
                if (g5 != 0) {
                    Log.w("Cea708Decoder", "serviceNumber is non-zero (" + g5 + ") when blockSize is 0");
                }
            } else if (g5 == this.f3673i) {
                boolean z3 = false;
                while (nVar2.b() > 0) {
                    int g7 = nVar2.g(8);
                    if (g7 != 16) {
                        if (g7 <= 31) {
                            if (g7 != 0) {
                                if (g7 != i6) {
                                    if (g7 != 8) {
                                        switch (g7) {
                                            case 12:
                                                j();
                                                break;
                                            case 13:
                                                this.f3675k.a('\n');
                                                break;
                                            case 14:
                                                break;
                                            default:
                                                if (g7 >= 17 && g7 <= 23) {
                                                    Log.w(str3, "Currently unsupported COMMAND_EXT1 Command: " + g7);
                                                    nVar2.o(8);
                                                    break;
                                                } else if (g7 >= 24 && g7 <= 31) {
                                                    Log.w(str3, "Currently unsupported COMMAND_P16 Command: " + g7);
                                                    nVar2.o(16);
                                                    break;
                                                } else {
                                                    i.r("Invalid C0 command: ", g7, str3);
                                                    break;
                                                }
                                        }
                                    } else {
                                        SpannableStringBuilder spannableStringBuilder = this.f3675k.b;
                                        int length = spannableStringBuilder.length();
                                        if (length > 0) {
                                            spannableStringBuilder.delete(length - 1, length);
                                        }
                                    }
                                } else {
                                    this.f3676l = i();
                                }
                            }
                            str = str3;
                        } else if (g7 <= 127) {
                            if (g7 == 127) {
                                this.f3675k.a((char) 9835);
                            } else {
                                this.f3675k.a((char) (g7 & 255));
                            }
                            str = str3;
                            z3 = true;
                        } else {
                            if (g7 <= 159) {
                                e[] eVarArr = this.f3674j;
                                switch (g7) {
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                        str2 = str3;
                                        int i8 = g7 - 128;
                                        if (this.f3679o != i8) {
                                            this.f3679o = i8;
                                            this.f3675k = eVarArr[i8];
                                            break;
                                        }
                                        break;
                                    case 136:
                                        str2 = str3;
                                        for (int i9 = 1; i9 <= 8; i9++) {
                                            if (nVar2.f()) {
                                                e eVar2 = eVarArr[8 - i9];
                                                eVar2.f3654a.clear();
                                                eVar2.b.clear();
                                                eVar2.f3666p = -1;
                                                eVar2.q = -1;
                                                eVar2.f3667r = -1;
                                                eVar2.f3668t = -1;
                                                eVar2.f3670v = 0;
                                            }
                                        }
                                        break;
                                    case 137:
                                        str2 = str3;
                                        for (int i10 = 1; i10 <= 8; i10++) {
                                            if (nVar2.f()) {
                                                eVarArr[8 - i10].d = true;
                                            }
                                        }
                                        break;
                                    case 138:
                                        str2 = str3;
                                        for (int i11 = 1; i11 <= 8; i11++) {
                                            if (nVar2.f()) {
                                                eVarArr[8 - i11].d = false;
                                            }
                                        }
                                        break;
                                    case 139:
                                        str2 = str3;
                                        for (int i12 = 1; i12 <= 8; i12++) {
                                            if (nVar2.f()) {
                                                eVarArr[8 - i12].d = !eVar.d;
                                            }
                                        }
                                        break;
                                    case 140:
                                        str2 = str3;
                                        for (int i13 = 1; i13 <= 8; i13++) {
                                            if (nVar2.f()) {
                                                eVarArr[8 - i13].d();
                                            }
                                        }
                                        break;
                                    case 141:
                                        str2 = str3;
                                        nVar2.o(8);
                                        break;
                                    case 142:
                                        str2 = str3;
                                        break;
                                    case 143:
                                        str2 = str3;
                                        j();
                                        break;
                                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                                        str2 = str3;
                                        if (!this.f3675k.c) {
                                            nVar2.o(16);
                                            break;
                                        } else {
                                            nVar2.g(4);
                                            nVar2.g(2);
                                            nVar2.g(2);
                                            boolean f4 = nVar2.f();
                                            boolean f5 = nVar2.f();
                                            nVar2.g(3);
                                            nVar2.g(3);
                                            this.f3675k.e(f4, f5);
                                        }
                                    case 145:
                                        str2 = str3;
                                        if (!this.f3675k.c) {
                                            nVar2.o(24);
                                        } else {
                                            int c = e.c(nVar2.g(2), nVar2.g(2), nVar2.g(2), nVar2.g(2));
                                            int c5 = e.c(nVar2.g(2), nVar2.g(2), nVar2.g(2), nVar2.g(2));
                                            nVar2.o(2);
                                            e.c(nVar2.g(2), nVar2.g(2), nVar2.g(2), 0);
                                            this.f3675k.f(c, c5);
                                        }
                                        break;
                                    case 146:
                                        str2 = str3;
                                        if (!this.f3675k.c) {
                                            nVar2.o(16);
                                        } else {
                                            nVar2.o(4);
                                            int g8 = nVar2.g(4);
                                            nVar2.o(2);
                                            nVar2.g(6);
                                            e eVar3 = this.f3675k;
                                            if (eVar3.f3670v != g8) {
                                                eVar3.a('\n');
                                            }
                                            eVar3.f3670v = g8;
                                        }
                                        break;
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    default:
                                        i.r("Invalid C1 command: ", g7, str3);
                                        str2 = str3;
                                        break;
                                    case 151:
                                        str2 = str3;
                                        if (!this.f3675k.c) {
                                            nVar2.o(32);
                                        } else {
                                            int c6 = e.c(nVar2.g(2), nVar2.g(2), nVar2.g(2), nVar2.g(2));
                                            nVar2.g(2);
                                            e.c(nVar2.g(2), nVar2.g(2), nVar2.g(2), 0);
                                            nVar2.f();
                                            nVar2.f();
                                            nVar2.g(2);
                                            nVar2.g(2);
                                            int g9 = nVar2.g(2);
                                            nVar2.o(8);
                                            e eVar4 = this.f3675k;
                                            eVar4.f3665o = c6;
                                            eVar4.f3662l = g9;
                                        }
                                        break;
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                        int i14 = g7 - 152;
                                        e eVar5 = eVarArr[i14];
                                        nVar2.o(i5);
                                        boolean f6 = nVar2.f();
                                        boolean f7 = nVar2.f();
                                        nVar2.f();
                                        int g10 = nVar2.g(i6);
                                        boolean f8 = nVar2.f();
                                        int g11 = nVar2.g(i7);
                                        int g12 = nVar2.g(8);
                                        int g13 = nVar2.g(4);
                                        int g14 = nVar2.g(4);
                                        nVar2.o(i5);
                                        nVar2.g(6);
                                        nVar2.o(i5);
                                        int g15 = nVar2.g(3);
                                        str2 = str3;
                                        int g16 = nVar2.g(3);
                                        eVar5.c = true;
                                        eVar5.d = f6;
                                        eVar5.f3661k = f7;
                                        eVar5.f3655e = g10;
                                        eVar5.f3656f = f8;
                                        eVar5.f3657g = g11;
                                        eVar5.f3658h = g12;
                                        eVar5.f3659i = g13;
                                        int i15 = g14 + 1;
                                        if (eVar5.f3660j != i15) {
                                            eVar5.f3660j = i15;
                                            while (true) {
                                                ArrayList arrayList = eVar5.f3654a;
                                                if ((f7 && arrayList.size() >= eVar5.f3660j) || arrayList.size() >= 15) {
                                                    arrayList.remove(0);
                                                }
                                            }
                                        }
                                        if (g15 != 0 && eVar5.f3663m != g15) {
                                            eVar5.f3663m = g15;
                                            int i16 = g15 - 1;
                                            int i17 = e.C[i16];
                                            boolean z5 = e.B[i16];
                                            int i18 = e.f3653z[i16];
                                            int i19 = e.A[i16];
                                            int i20 = e.f3652y[i16];
                                            eVar5.f3665o = i17;
                                            eVar5.f3662l = i20;
                                        }
                                        if (g16 != 0 && eVar5.f3664n != g16) {
                                            eVar5.f3664n = g16;
                                            int i21 = g16 - 1;
                                            int i22 = e.E[i21];
                                            int i23 = e.D[i21];
                                            eVar5.e(false, false);
                                            eVar5.f(e.w, e.F[i21]);
                                        }
                                        if (this.f3679o != i14) {
                                            this.f3679o = i14;
                                            this.f3675k = eVarArr[i14];
                                        }
                                        break;
                                }
                            } else {
                                str2 = str3;
                                if (g7 <= 255) {
                                    this.f3675k.a((char) (g7 & 255));
                                } else {
                                    str = str2;
                                    i.r("Invalid base command: ", g7, str);
                                }
                            }
                            str = str2;
                            z3 = true;
                        }
                    } else {
                        str = str3;
                        int g17 = nVar2.g(8);
                        if (g17 <= 31) {
                            if (g17 > 7) {
                                if (g17 <= 15) {
                                    nVar2.o(8);
                                } else if (g17 <= 23) {
                                    nVar2.o(16);
                                } else if (g17 <= 31) {
                                    nVar2.o(24);
                                }
                            }
                        } else if (g17 <= 127) {
                            if (g17 != 32) {
                                if (g17 != 33) {
                                    if (g17 != 37) {
                                        if (g17 != 42) {
                                            if (g17 != 44) {
                                                if (g17 != 63) {
                                                    if (g17 != 57) {
                                                        if (g17 != 58) {
                                                            if (g17 != 60) {
                                                                if (g17 != 61) {
                                                                    switch (g17) {
                                                                        case 48:
                                                                            this.f3675k.a((char) 9608);
                                                                            break;
                                                                        case 49:
                                                                            this.f3675k.a((char) 8216);
                                                                            break;
                                                                        case 50:
                                                                            this.f3675k.a((char) 8217);
                                                                            break;
                                                                        case 51:
                                                                            this.f3675k.a((char) 8220);
                                                                            break;
                                                                        case 52:
                                                                            this.f3675k.a((char) 8221);
                                                                            break;
                                                                        case 53:
                                                                            this.f3675k.a((char) 8226);
                                                                            break;
                                                                        default:
                                                                            switch (g17) {
                                                                                case 118:
                                                                                    this.f3675k.a((char) 8539);
                                                                                    break;
                                                                                case 119:
                                                                                    this.f3675k.a((char) 8540);
                                                                                    break;
                                                                                case 120:
                                                                                    this.f3675k.a((char) 8541);
                                                                                    break;
                                                                                case 121:
                                                                                    this.f3675k.a((char) 8542);
                                                                                    break;
                                                                                case 122:
                                                                                    this.f3675k.a((char) 9474);
                                                                                    break;
                                                                                case 123:
                                                                                    this.f3675k.a((char) 9488);
                                                                                    break;
                                                                                case 124:
                                                                                    this.f3675k.a((char) 9492);
                                                                                    break;
                                                                                case 125:
                                                                                    this.f3675k.a((char) 9472);
                                                                                    break;
                                                                                case 126:
                                                                                    this.f3675k.a((char) 9496);
                                                                                    break;
                                                                                case 127:
                                                                                    this.f3675k.a((char) 9484);
                                                                                    break;
                                                                                default:
                                                                                    i.r("Invalid G2 character: ", g17, str);
                                                                                    break;
                                                                            }
                                                                    }
                                                                } else {
                                                                    this.f3675k.a((char) 8480);
                                                                }
                                                            } else {
                                                                this.f3675k.a((char) 339);
                                                            }
                                                        } else {
                                                            this.f3675k.a((char) 353);
                                                        }
                                                    } else {
                                                        this.f3675k.a((char) 8482);
                                                    }
                                                } else {
                                                    this.f3675k.a((char) 376);
                                                }
                                            } else {
                                                this.f3675k.a((char) 338);
                                            }
                                        } else {
                                            this.f3675k.a((char) 352);
                                        }
                                    } else {
                                        this.f3675k.a((char) 8230);
                                    }
                                } else {
                                    this.f3675k.a((char) 160);
                                }
                            } else {
                                this.f3675k.a(' ');
                            }
                            z3 = true;
                        } else {
                            if (g17 <= 159) {
                                if (g17 <= 135) {
                                    nVar2.o(32);
                                } else if (g17 <= 143) {
                                    nVar2.o(40);
                                } else if (g17 <= 159) {
                                    nVar2.o(2);
                                    nVar2.o(nVar2.g(6) * 8);
                                }
                            } else if (g17 <= 255) {
                                if (g17 == 160) {
                                    this.f3675k.a((char) 13252);
                                } else {
                                    i.r("Invalid G3 character: ", g17, str);
                                    this.f3675k.a('_');
                                }
                                z3 = true;
                            } else {
                                i.r("Invalid extended command: ", g17, str);
                            }
                            str3 = str;
                            i6 = 3;
                            i5 = 2;
                            i7 = 7;
                        }
                    }
                    str3 = str;
                    i6 = 3;
                    i5 = 2;
                    i7 = 7;
                }
                if (z3) {
                    this.f3676l = i();
                }
            }
        }
        this.f3678n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List i() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.f.i():java.util.List");
    }

    public final void j() {
        for (int i3 = 0; i3 < 8; i3++) {
            this.f3674j[i3].d();
        }
    }
}
