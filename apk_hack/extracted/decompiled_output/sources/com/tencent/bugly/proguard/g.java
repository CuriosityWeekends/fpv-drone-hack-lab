package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends m {

    /* renamed from: k  reason: collision with root package name */
    static byte[] f1488k = null;

    /* renamed from: l  reason: collision with root package name */
    static Map<String, String> f1489l = null;

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ boolean f1490m = true;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f1494g;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f1496i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f1497j;

    /* renamed from: a  reason: collision with root package name */
    public short f1491a = 0;
    public byte b = 0;
    public int c = 0;
    public int d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f1492e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f1493f = null;

    /* renamed from: h  reason: collision with root package name */
    public int f1495h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1491a, 1);
        lVar.a(this.b, 2);
        lVar.a(this.c, 3);
        lVar.a(this.d, 4);
        lVar.a(this.f1492e, 5);
        lVar.a(this.f1493f, 6);
        lVar.a(this.f1494g, 7);
        lVar.a(this.f1495h, 8);
        lVar.a((Map) this.f1496i, 9);
        lVar.a((Map) this.f1497j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1490m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        if (n.a(1, (int) gVar.f1491a) && n.a(1, (int) gVar.b) && n.a(1, gVar.c) && n.a(1, gVar.d) && n.a((Object) 1, (Object) gVar.f1492e) && n.a((Object) 1, (Object) gVar.f1493f) && n.a((Object) 1, (Object) gVar.f1494g) && n.a(1, gVar.f1495h) && n.a((Object) 1, (Object) gVar.f1496i) && n.a((Object) 1, (Object) gVar.f1497j)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        try {
            this.f1491a = kVar.a(this.f1491a, 1, true);
            this.b = kVar.a(this.b, 2, true);
            this.c = kVar.a(this.c, 3, true);
            this.d = kVar.a(this.d, 4, true);
            this.f1492e = kVar.b(5, true);
            this.f1493f = kVar.b(6, true);
            if (f1488k == null) {
                f1488k = new byte[]{0};
            }
            this.f1494g = kVar.c(7, true);
            this.f1495h = kVar.a(this.f1495h, 8, true);
            if (f1489l == null) {
                HashMap hashMap = new HashMap();
                f1489l = hashMap;
                hashMap.put("", "");
            }
            this.f1496i = (Map) kVar.a((k) f1489l, 9, true);
            if (f1489l == null) {
                HashMap hashMap2 = new HashMap();
                f1489l = hashMap2;
                hashMap2.put("", "");
            }
            this.f1497j = (Map) kVar.a((k) f1489l, 10, true);
        } catch (Exception e5) {
            e5.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + f.a(this.f1494g));
            throw new RuntimeException(e5);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i3) {
        i iVar = new i(sb, i3);
        iVar.a(this.f1491a, "iVersion");
        iVar.a(this.b, "cPacketType");
        iVar.a(this.c, "iMessageType");
        iVar.a(this.d, "iRequestId");
        iVar.a(this.f1492e, "sServantName");
        iVar.a(this.f1493f, "sFuncName");
        iVar.a(this.f1494g, "sBuffer");
        iVar.a(this.f1495h, "iTimeout");
        iVar.a((Map) this.f1496i, "context");
        iVar.a((Map) this.f1497j, NotificationCompat.CATEGORY_STATUS);
    }
}
