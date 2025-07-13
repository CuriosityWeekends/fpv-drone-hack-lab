package w1;

import a1.i;
import android.graphics.PointF;
import android.text.Layout;
import android.util.Log;
import g2.w;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s1.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends s1.c {
    public static final Pattern s = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: n  reason: collision with root package name */
    public final boolean f3936n;

    /* renamed from: o  reason: collision with root package name */
    public final b f3937o;

    /* renamed from: p  reason: collision with root package name */
    public LinkedHashMap f3938p;
    public float q = -3.4028235E38f;

    /* renamed from: r  reason: collision with root package name */
    public float f3939r = -3.4028235E38f;

    public a(List list) {
        if (list != null && !list.isEmpty()) {
            this.f3936n = true;
            int i3 = w.f1960a;
            String str = new String((byte[]) list.get(0), Charset.forName("UTF-8"));
            g2.b.e(str.startsWith("Format:"));
            b a5 = b.a(str);
            a5.getClass();
            this.f3937o = a5;
            j(new c0.b((byte[]) list.get(1)));
            return;
        }
        this.f3936n = false;
        this.f3937o = null;
    }

    public static int i(long j2, ArrayList arrayList, ArrayList arrayList2) {
        int i3;
        ArrayList arrayList3;
        int size = arrayList.size() - 1;
        while (true) {
            if (size >= 0) {
                if (((Long) arrayList.get(size)).longValue() == j2) {
                    return size;
                }
                if (((Long) arrayList.get(size)).longValue() < j2) {
                    i3 = size + 1;
                    break;
                }
                size--;
            } else {
                i3 = 0;
                break;
            }
        }
        arrayList.add(i3, Long.valueOf(j2));
        if (i3 == 0) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = new ArrayList((Collection) arrayList2.get(i3 - 1));
        }
        arrayList2.add(i3, arrayList3);
        return i3;
    }

    public static long k(String str) {
        Matcher matcher = s.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i3 = w.f1960a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(group) * 3600000000L);
    }

    @Override // s1.c
    public final e e(byte[] bArr, int i3, boolean z3) {
        b bVar;
        c0.b bVar2;
        d dVar;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        float f5;
        float f6;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i9;
        int i10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c0.b bVar3 = new c0.b(bArr, i3);
        boolean z5 = this.f3936n;
        if (!z5) {
            j(bVar3);
        }
        if (z5) {
            bVar = this.f3937o;
        } else {
            bVar = null;
        }
        while (true) {
            String d = bVar3.d();
            if (d != null) {
                if (d.startsWith("Format:")) {
                    bVar = b.a(d);
                } else {
                    if (d.startsWith("Dialogue:")) {
                        if (bVar == null) {
                            Log.w("SsaDecoder", "Skipping dialogue line before complete format: ".concat(d));
                        } else {
                            g2.b.e(d.startsWith("Dialogue:"));
                            String substring = d.substring(9);
                            int i11 = bVar.f3941e;
                            String[] split = substring.split(",", i11);
                            if (split.length != i11) {
                                Log.w("SsaDecoder", "Skipping dialogue line with fewer columns than format: ".concat(d));
                            } else {
                                long k5 = k(split[bVar.f3940a]);
                                if (k5 == -9223372036854775807L) {
                                    Log.w("SsaDecoder", "Skipping invalid timing: ".concat(d));
                                } else {
                                    long k6 = k(split[bVar.b]);
                                    if (k6 == -9223372036854775807L) {
                                        Log.w("SsaDecoder", "Skipping invalid timing: ".concat(d));
                                    } else {
                                        LinkedHashMap linkedHashMap = this.f3938p;
                                        if (linkedHashMap != null && (i10 = bVar.c) != -1) {
                                            dVar = (d) linkedHashMap.get(split[i10].trim());
                                        } else {
                                            dVar = null;
                                        }
                                        String str = split[bVar.d];
                                        Matcher matcher = c.f3942a.matcher(str);
                                        PointF pointF = null;
                                        int i12 = -1;
                                        while (matcher.find()) {
                                            c0.b bVar4 = bVar3;
                                            String group = matcher.group(1);
                                            try {
                                                PointF a5 = c.a(group);
                                                if (a5 != null) {
                                                    pointF = a5;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            try {
                                                Matcher matcher2 = c.d.matcher(group);
                                                if (matcher2.find()) {
                                                    i9 = d.a(matcher2.group(1));
                                                } else {
                                                    i9 = -1;
                                                }
                                                if (i9 != -1) {
                                                    i12 = i9;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            bVar3 = bVar4;
                                        }
                                        bVar2 = bVar3;
                                        String replaceAll = c.f3942a.matcher(str).replaceAll("").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n");
                                        float f7 = this.q;
                                        float f8 = this.f3939r;
                                        int i13 = -1;
                                        if (i12 != -1) {
                                            i13 = i12;
                                        } else if (dVar != null) {
                                            i13 = dVar.b;
                                        }
                                        switch (i13) {
                                            case 0:
                                            default:
                                                i.r("Unknown alignment: ", i13, "SsaDecoder");
                                            case -1:
                                                i5 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                i5 = 0;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                i5 = 1;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                i5 = 2;
                                                break;
                                        }
                                        switch (i13) {
                                            case 0:
                                            default:
                                                i.r("Unknown alignment: ", i13, "SsaDecoder");
                                            case -1:
                                                i6 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 2:
                                            case 3:
                                                i6 = 2;
                                                break;
                                            case 4:
                                            case 5:
                                            case 6:
                                                i6 = 1;
                                                break;
                                            case 7:
                                            case 8:
                                            case 9:
                                                i6 = 0;
                                                break;
                                        }
                                        float f9 = -3.4028235E38f;
                                        if (pointF != null && f8 != -3.4028235E38f && f7 != -3.4028235E38f) {
                                            float f10 = pointF.x / f7;
                                            f5 = pointF.y / f8;
                                            f6 = f10;
                                            i8 = i6;
                                        } else {
                                            if (i5 != 0) {
                                                i7 = 1;
                                                if (i5 != 1) {
                                                    if (i5 != 2) {
                                                        i8 = i6;
                                                        f4 = -3.4028235E38f;
                                                    } else {
                                                        i8 = i6;
                                                        f4 = 0.95f;
                                                    }
                                                } else {
                                                    i8 = i6;
                                                    f4 = 0.5f;
                                                }
                                            } else {
                                                i7 = 1;
                                                i8 = i6;
                                                f4 = 0.05f;
                                            }
                                            if (i8 != 0) {
                                                if (i8 != i7) {
                                                    if (i8 == 2) {
                                                        f9 = 0.95f;
                                                    }
                                                } else {
                                                    f9 = 0.5f;
                                                }
                                            } else {
                                                f9 = 0.05f;
                                            }
                                            f5 = f9;
                                            f6 = f4;
                                        }
                                        switch (i13) {
                                            case 0:
                                            default:
                                                i.r("Unknown alignment: ", i13, "SsaDecoder");
                                            case -1:
                                                alignment2 = null;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                alignment = Layout.Alignment.ALIGN_NORMAL;
                                                alignment2 = alignment;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                alignment = Layout.Alignment.ALIGN_CENTER;
                                                alignment2 = alignment;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                alignment2 = alignment;
                                                break;
                                        }
                                        s1.b bVar5 = new s1.b(replaceAll, alignment2, f5, 0, i8, f6, i5, -3.4028235E38f);
                                        int i14 = i(k6, arrayList2, arrayList);
                                        for (int i15 = i(k5, arrayList2, arrayList); i15 < i14; i15++) {
                                            ((List) arrayList.get(i15)).add(bVar5);
                                        }
                                        bVar3 = bVar2;
                                    }
                                }
                            }
                        }
                    }
                    bVar2 = bVar3;
                    bVar3 = bVar2;
                }
            } else {
                return new c1.b(21, arrayList, arrayList2, false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        if ("[V4+ Styles]".equalsIgnoreCase(r0) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        r4 = new java.util.LinkedHashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0169, code lost:
        if ("[V4 Styles]".equalsIgnoreCase(r0) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016b, code lost:
        android.util.Log.i("SsaDecoder", "[V4 Styles] are not supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0178, code lost:
        if ("[Events]".equalsIgnoreCase(r0) == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(c0.b r17) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.a.j(c0.b):void");
    }
}
