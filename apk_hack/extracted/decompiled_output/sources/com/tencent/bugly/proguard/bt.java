package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bt extends m implements Cloneable {

    /* renamed from: m  reason: collision with root package name */
    static bs f1454m = new bs();

    /* renamed from: n  reason: collision with root package name */
    static Map<String, String> f1455n = null;

    /* renamed from: o  reason: collision with root package name */
    static final /* synthetic */ boolean f1456o = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1457a = true;
    public boolean b = true;
    public boolean c = true;
    public String d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f1458e = "";

    /* renamed from: f  reason: collision with root package name */
    public bs f1459f = null;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f1460g = null;

    /* renamed from: h  reason: collision with root package name */
    public long f1461h = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f1462i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f1463j = "";

    /* renamed from: k  reason: collision with root package name */
    public int f1464k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1465l = 0;

    static {
        HashMap hashMap = new HashMap();
        f1455n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1457a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        String str = this.d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f1458e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bs bsVar = this.f1459f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.f1460g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f1461h, 7);
        String str3 = this.f1462i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f1463j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f1464k, 10);
        lVar.a(this.f1465l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1456o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        if (!n.a(this.f1457a, btVar.f1457a) || !n.a(this.b, btVar.b) || !n.a(this.c, btVar.c) || !n.a(this.d, btVar.d) || !n.a(this.f1458e, btVar.f1458e) || !n.a(this.f1459f, btVar.f1459f) || !n.a(this.f1460g, btVar.f1460g) || !n.a(this.f1461h, btVar.f1461h) || !n.a(this.f1462i, btVar.f1462i) || !n.a(this.f1463j, btVar.f1463j) || !n.a(this.f1464k, btVar.f1464k) || !n.a(this.f1465l, btVar.f1465l)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1457a = kVar.a(0, true);
        this.b = kVar.a(1, true);
        this.c = kVar.a(2, true);
        this.d = kVar.b(3, false);
        this.f1458e = kVar.b(4, false);
        this.f1459f = (bs) kVar.a((m) f1454m, 5, false);
        this.f1460g = (Map) kVar.a((k) f1455n, 6, false);
        this.f1461h = kVar.a(this.f1461h, 7, false);
        this.f1462i = kVar.b(8, false);
        this.f1463j = kVar.b(9, false);
        this.f1464k = kVar.a(this.f1464k, 10, false);
        this.f1465l = kVar.a(this.f1465l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i3) {
        i iVar = new i(sb, i3);
        iVar.a(this.f1457a, "enable");
        iVar.a(this.b, "enableUserInfo");
        iVar.a(this.c, "enableQuery");
        iVar.a(this.d, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        iVar.a(this.f1458e, "expUrl");
        iVar.a((m) this.f1459f, "security");
        iVar.a((Map) this.f1460g, "valueMap");
        iVar.a(this.f1461h, "strategylastUpdateTime");
        iVar.a(this.f1462i, "httpsUrl");
        iVar.a(this.f1463j, "httpsExpUrl");
        iVar.a(this.f1464k, "eventRecordCount");
        iVar.a(this.f1465l, "eventTimeInterval");
    }
}
