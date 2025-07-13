package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bu extends m {

    /* renamed from: i  reason: collision with root package name */
    static Map<String, String> f1466i;

    /* renamed from: a  reason: collision with root package name */
    public long f1467a = 0;
    public byte b = 0;
    public String c = "";
    public String d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f1468e = "";

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1469f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f1470g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f1471h = true;

    static {
        HashMap hashMap = new HashMap();
        f1466i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1467a, 0);
        lVar.a(this.b, 1);
        String str = this.c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f1468e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f1469f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f1470g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f1471h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1467a = kVar.a(this.f1467a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.b(2, false);
        this.d = kVar.b(3, false);
        this.f1468e = kVar.b(4, false);
        this.f1469f = (Map) kVar.a((k) f1466i, 5, false);
        this.f1470g = kVar.b(6, false);
        this.f1471h = kVar.a(7, false);
    }
}
