package h2;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y0.d0;
import y0.x;
import y0.y;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f1990a;
    public final List b;

    public c(List list, int i3) {
        this.b = list;
        this.f1990a = i3;
    }

    public static c d(c0.b bVar) {
        List singletonList;
        try {
            bVar.z(21);
            int n5 = bVar.n() & 3;
            int n6 = bVar.n();
            int i3 = bVar.b;
            int i5 = 0;
            for (int i6 = 0; i6 < n6; i6++) {
                bVar.z(1);
                int s = bVar.s();
                for (int i7 = 0; i7 < s; i7++) {
                    int s5 = bVar.s();
                    i5 += s5 + 4;
                    bVar.z(s5);
                }
            }
            bVar.y(i3);
            byte[] bArr = new byte[i5];
            int i8 = 0;
            for (int i9 = 0; i9 < n6; i9++) {
                bVar.z(1);
                int s6 = bVar.s();
                for (int i10 = 0; i10 < s6; i10++) {
                    int s7 = bVar.s();
                    System.arraycopy(g2.b.d, 0, bArr, i8, 4);
                    int i11 = i8 + 4;
                    System.arraycopy(bVar.f187a, bVar.b, bArr, i11, s7);
                    i8 = i11 + s7;
                    bVar.z(s7);
                }
            }
            if (i5 == 0) {
                singletonList = null;
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new c(singletonList, n5 + 1);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new IOException("Error parsing HEVC config", e5);
        }
    }

    public d0 a(int i3, i.b bVar) {
        if (i3 != 2) {
            String str = (String) bVar.b;
            if (i3 != 3 && i3 != 4) {
                if (i3 != 15) {
                    if (i3 != 17) {
                        if (i3 != 21) {
                            if (i3 != 27) {
                                if (i3 != 36) {
                                    if (i3 != 89) {
                                        if (i3 != 138) {
                                            if (i3 != 172) {
                                                if (i3 != 129) {
                                                    if (i3 != 130) {
                                                        if (i3 != 134) {
                                                            if (i3 != 135) {
                                                                return null;
                                                            }
                                                        } else if (c(16)) {
                                                            return null;
                                                        } else {
                                                            return new x(new j0.b(4));
                                                        }
                                                    } else if (!c(64)) {
                                                        return null;
                                                    }
                                                }
                                                return new y0.s(new y0.b(str, 0));
                                            }
                                            return new y0.s(new y0.b(str, 1));
                                        }
                                        return new y0.s(new y0.f(str));
                                    }
                                    return new y0.s(new y0.g((List) bVar.c));
                                }
                                return new y0.s(new y0.o(new y(b(bVar), 0)));
                            } else if (c(4)) {
                                return null;
                            } else {
                                return new y0.s(new y0.m(new y(b(bVar), 0), c(1), c(8)));
                            }
                        }
                        return new y0.s(new y0.g());
                    } else if (c(2)) {
                        return null;
                    } else {
                        return new y0.s(new y0.p(str));
                    }
                } else if (c(2)) {
                    return null;
                } else {
                    return new y0.s(new y0.e(str, false));
                }
            }
            return new y0.s(new y0.q(str));
        }
        return new y0.s(new y0.j(new y(b(bVar), 1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    public List b(i.b bVar) {
        boolean z3;
        String str;
        int i3;
        List list;
        int i5;
        boolean c = c(32);
        List list2 = this.b;
        if (c) {
            return list2;
        }
        c0.b bVar2 = new c0.b((byte[]) bVar.d);
        ArrayList arrayList = list2;
        while (bVar2.a() > 0) {
            int n5 = bVar2.n();
            int n6 = bVar2.b + bVar2.n();
            if (n5 == 134) {
                arrayList = new ArrayList();
                int n7 = bVar2.n() & 31;
                for (int i6 = 0; i6 < n7; i6++) {
                    String k5 = bVar2.k(3);
                    int n8 = bVar2.n();
                    if ((n8 & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        str = "application/cea-708";
                        i3 = n8 & 63;
                    } else {
                        str = "application/cea-608";
                        i3 = 1;
                    }
                    byte n9 = (byte) bVar2.n();
                    bVar2.z(1);
                    if (z3) {
                        if ((n9 & 64) != 0) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                        list = Collections.singletonList(new byte[]{(byte) i5});
                    } else {
                        list = null;
                    }
                    arrayList.add(Format.q(null, str, 0, k5, i3, null, Long.MAX_VALUE, list));
                }
            }
            bVar2.y(n6);
            arrayList = arrayList;
        }
        return arrayList;
    }

    public boolean c(int i3) {
        if ((i3 & this.f1990a) != 0) {
            return true;
        }
        return false;
    }

    public c(int i3, List list) {
        this.f1990a = i3;
        this.b = list;
    }
}
