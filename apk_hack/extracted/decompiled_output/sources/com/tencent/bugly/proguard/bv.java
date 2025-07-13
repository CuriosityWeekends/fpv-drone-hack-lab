package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bv extends m implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    static ArrayList<bu> f1472f;

    /* renamed from: g  reason: collision with root package name */
    static Map<String, String> f1473g;

    /* renamed from: a  reason: collision with root package name */
    public byte f1474a = 0;
    public String b = "";
    public String c = "";
    public ArrayList<bu> d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f1475e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1474a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f1475e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1474a = kVar.a(this.f1474a, 0, true);
        this.b = kVar.b(1, false);
        this.c = kVar.b(2, false);
        if (f1472f == null) {
            f1472f = new ArrayList<>();
            f1472f.add(new bu());
        }
        this.d = (ArrayList) kVar.a((k) f1472f, 3, false);
        if (f1473g == null) {
            HashMap hashMap = new HashMap();
            f1473g = hashMap;
            hashMap.put("", "");
        }
        this.f1475e = (Map) kVar.a((k) f1473g, 4, false);
    }
}
