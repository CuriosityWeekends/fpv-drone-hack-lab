package r1;

import a1.i;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import g2.w;
import j1.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends d {

    /* renamed from: e  reason: collision with root package name */
    public final String f3404e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList f3405f;

    /* renamed from: g  reason: collision with root package name */
    public int f3406g;

    /* renamed from: h  reason: collision with root package name */
    public String f3407h;

    /* renamed from: i  reason: collision with root package name */
    public long f3408i;

    /* renamed from: j  reason: collision with root package name */
    public String f3409j;

    /* renamed from: k  reason: collision with root package name */
    public String f3410k;

    /* renamed from: l  reason: collision with root package name */
    public int f3411l;

    /* renamed from: m  reason: collision with root package name */
    public int f3412m;

    /* renamed from: n  reason: collision with root package name */
    public int f3413n;

    /* renamed from: o  reason: collision with root package name */
    public int f3414o;

    /* renamed from: p  reason: collision with root package name */
    public String f3415p;
    public ArrayList q;

    /* renamed from: r  reason: collision with root package name */
    public long f3416r;

    public h(d dVar, String str) {
        super(dVar, str, "StreamIndex");
        this.f3404e = str;
        this.f3405f = new LinkedList();
    }

    @Override // r1.d
    public final void a(Object obj) {
        if (obj instanceof Format) {
            this.f3405f.add((Format) obj);
        }
    }

    @Override // r1.d
    public final Object b() {
        int i3;
        int i5;
        String str;
        LinkedList linkedList = this.f3405f;
        Format[] formatArr = new Format[linkedList.size()];
        linkedList.toArray(formatArr);
        String str2 = this.f3410k;
        int i6 = this.f3406g;
        String str3 = this.f3407h;
        long j2 = this.f3408i;
        String str4 = this.f3409j;
        int i7 = this.f3411l;
        int i8 = this.f3412m;
        int i9 = this.f3413n;
        int i10 = this.f3414o;
        String str5 = this.f3415p;
        ArrayList arrayList = this.q;
        long j5 = this.f3416r;
        int i11 = w.f1960a;
        int size = arrayList.size();
        long[] jArr = new long[size];
        int i12 = (j2 > 1000000L ? 1 : (j2 == 1000000L ? 0 : -1));
        if (i12 >= 0 && j2 % 1000000 == 0) {
            long j6 = j2 / 1000000;
            i3 = i9;
            for (int i13 = 0; i13 < size; i13++) {
                jArr[i13] = ((Long) arrayList.get(i13)).longValue() / j6;
            }
        } else {
            i3 = i9;
            if (i12 < 0 && 1000000 % j2 == 0) {
                long j7 = 1000000 / j2;
                for (int i14 = 0; i14 < size; i14++) {
                    jArr[i14] = ((Long) arrayList.get(i14)).longValue() * j7;
                }
            } else {
                i5 = i6;
                str = str3;
                double d = 1000000 / j2;
                int i15 = 0;
                while (i15 < size) {
                    jArr[i15] = (long) (((Long) arrayList.get(i15)).longValue() * d);
                    i15++;
                    arrayList = arrayList;
                }
                ArrayList arrayList2 = arrayList;
                long B = w.B(j5, 1000000L, j2);
                return new b(this.f3404e, str2, i5, str, j2, str4, i7, i8, i3, i10, str5, formatArr, arrayList2, jArr, B);
            }
        }
        i5 = i6;
        str = str3;
        ArrayList arrayList22 = arrayList;
        long B2 = w.B(j5, 1000000L, j2);
        return new b(this.f3404e, str2, i5, str, j2, str4, i7, i8, i3, i10, str5, formatArr, arrayList22, jArr, B2);
    }

    @Override // r1.d
    public final boolean d(String str) {
        return "c".equals(str);
    }

    @Override // r1.d
    public final void j(XmlPullParser xmlPullParser) {
        int i3 = 1;
        if ("c".equals(xmlPullParser.getName())) {
            int size = this.q.size();
            long h5 = d.h(xmlPullParser, "t", -9223372036854775807L);
            if (h5 == -9223372036854775807L) {
                if (size == 0) {
                    h5 = 0;
                } else if (this.f3416r != -1) {
                    h5 = this.f3416r + ((Long) this.q.get(size - 1)).longValue();
                } else {
                    throw new IOException("Unable to infer start time");
                }
            }
            this.q.add(Long.valueOf(h5));
            this.f3416r = d.h(xmlPullParser, "d", -9223372036854775807L);
            long h6 = d.h(xmlPullParser, "r", 1L);
            if (h6 > 1 && this.f3416r == -9223372036854775807L) {
                throw new IOException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j2 = i3;
                if (j2 < h6) {
                    this.q.add(Long.valueOf((this.f3416r * j2) + h5));
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if (!"audio".equalsIgnoreCase(attributeValue)) {
                    if ("video".equalsIgnoreCase(attributeValue)) {
                        i3 = 2;
                    } else if ("text".equalsIgnoreCase(attributeValue)) {
                        i3 = 3;
                    } else {
                        throw new IOException(i.i("Invalid key value[", attributeValue, "]"));
                    }
                }
                this.f3406g = i3;
                Integer valueOf = Integer.valueOf(i3);
                LinkedList linkedList = this.d;
                linkedList.add(Pair.create("Type", valueOf));
                if (this.f3406g == 3) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "Subtype");
                    if (attributeValue2 != null) {
                        this.f3407h = attributeValue2;
                    } else {
                        throw new o0("Subtype");
                    }
                } else {
                    this.f3407h = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                linkedList.add(Pair.create("Subtype", this.f3407h));
                this.f3409j = xmlPullParser.getAttributeValue(null, "Name");
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "Url");
                if (attributeValue3 != null) {
                    this.f3410k = attributeValue3;
                    this.f3411l = d.g(xmlPullParser, "MaxWidth");
                    this.f3412m = d.g(xmlPullParser, "MaxHeight");
                    this.f3413n = d.g(xmlPullParser, "DisplayWidth");
                    this.f3414o = d.g(xmlPullParser, "DisplayHeight");
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "Language");
                    this.f3415p = attributeValue4;
                    linkedList.add(Pair.create("Language", attributeValue4));
                    long g5 = d.g(xmlPullParser, "TimeScale");
                    this.f3408i = g5;
                    if (g5 == -1) {
                        this.f3408i = ((Long) c("TimeScale")).longValue();
                    }
                    this.q = new ArrayList();
                    return;
                }
                throw new o0("Url");
            }
            throw new o0("Type");
        }
    }
}
