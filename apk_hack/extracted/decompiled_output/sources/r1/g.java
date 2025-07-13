package r1;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import g2.w;
import j1.o0;
import java.io.IOException;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends d {

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList f3395e;

    /* renamed from: f  reason: collision with root package name */
    public int f3396f;

    /* renamed from: g  reason: collision with root package name */
    public int f3397g;

    /* renamed from: h  reason: collision with root package name */
    public long f3398h;

    /* renamed from: i  reason: collision with root package name */
    public long f3399i;

    /* renamed from: j  reason: collision with root package name */
    public long f3400j;

    /* renamed from: k  reason: collision with root package name */
    public int f3401k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3402l;

    /* renamed from: m  reason: collision with root package name */
    public a f3403m;

    public g(String str) {
        super(null, str, "SmoothStreamingMedia");
        this.f3401k = -1;
        this.f3403m = null;
        this.f3395e = new LinkedList();
    }

    @Override // r1.d
    public final void a(Object obj) {
        boolean z3;
        if (obj instanceof b) {
            this.f3395e.add((b) obj);
        } else if (obj instanceof a) {
            if (this.f3403m == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.b.h(z3);
            this.f3403m = (a) obj;
        }
    }

    @Override // r1.d
    public final Object b() {
        boolean z3;
        a aVar;
        long B;
        long B2;
        LinkedList linkedList = this.f3395e;
        int size = linkedList.size();
        b[] bVarArr = new b[size];
        linkedList.toArray(bVarArr);
        a aVar2 = this.f3403m;
        if (aVar2 != null) {
            DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(aVar2.f3381a, null, "video/mp4", aVar2.b));
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = bVarArr[i3];
                int i5 = bVar.f3382a;
                if (i5 == 2 || i5 == 1) {
                    int i6 = 0;
                    while (true) {
                        Format[] formatArr = bVar.c;
                        if (i6 < formatArr.length) {
                            Format format = formatArr[i6];
                            formatArr[i6] = format.c(drmInitData, format.f309g);
                            i6++;
                        }
                    }
                }
            }
        }
        int i7 = this.f3396f;
        int i8 = this.f3397g;
        long j2 = this.f3398h;
        long j5 = this.f3399i;
        long j6 = this.f3400j;
        int i9 = this.f3401k;
        boolean z5 = this.f3402l;
        a aVar3 = this.f3403m;
        if (j5 == 0) {
            z3 = z5;
            aVar = aVar3;
            B = -9223372036854775807L;
        } else {
            z3 = z5;
            aVar = aVar3;
            B = w.B(j5, 1000000L, j2);
        }
        if (j6 == 0) {
            B2 = -9223372036854775807L;
        } else {
            B2 = w.B(j6, 1000000L, j2);
        }
        return new c(i7, i8, B, B2, i9, z3, aVar, bVarArr);
    }

    @Override // r1.d
    public final void j(XmlPullParser xmlPullParser) {
        boolean z3;
        this.f3396f = d.i(xmlPullParser, "MajorVersion");
        this.f3397g = d.i(xmlPullParser, "MinorVersion");
        this.f3398h = d.h(xmlPullParser, "TimeScale", 10000000L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "Duration");
        if (attributeValue != null) {
            try {
                this.f3399i = Long.parseLong(attributeValue);
                this.f3400j = d.h(xmlPullParser, "DVRWindowLength", 0L);
                this.f3401k = d.g(xmlPullParser, "LookaheadCount");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "IsLive");
                if (attributeValue2 != null) {
                    z3 = Boolean.parseBoolean(attributeValue2);
                } else {
                    z3 = false;
                }
                this.f3402l = z3;
                this.d.add(Pair.create("TimeScale", Long.valueOf(this.f3398h)));
                return;
            } catch (NumberFormatException e5) {
                throw new IOException(e5);
            }
        }
        throw new o0("Duration");
    }
}
