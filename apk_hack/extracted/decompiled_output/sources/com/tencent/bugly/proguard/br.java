package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class br extends m {

    /* renamed from: i  reason: collision with root package name */
    static byte[] f1446i;

    /* renamed from: j  reason: collision with root package name */
    static Map<String, String> f1447j;

    /* renamed from: a  reason: collision with root package name */
    public byte f1448a = 0;
    public int b = 0;
    public byte[] c = null;
    public String d = "";

    /* renamed from: e  reason: collision with root package name */
    public long f1449e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f1450f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f1451g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f1452h = null;

    static {
        f1446i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f1447j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1448a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f1449e, 4);
        String str2 = this.f1450f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f1451g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f1452h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1448a = kVar.a(this.f1448a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.c(2, false);
        this.d = kVar.b(3, false);
        this.f1449e = kVar.a(this.f1449e, 4, false);
        this.f1450f = kVar.b(5, false);
        this.f1451g = kVar.b(6, false);
        this.f1452h = (Map) kVar.a((k) f1447j, 7, false);
    }
}
