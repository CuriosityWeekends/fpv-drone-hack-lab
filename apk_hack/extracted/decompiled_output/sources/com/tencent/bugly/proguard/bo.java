package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bo extends m {
    static ArrayList<bn> A;
    static Map<String, String> B;
    static Map<String, String> C;

    /* renamed from: v  reason: collision with root package name */
    static Map<String, String> f1405v;
    static bm w;

    /* renamed from: x  reason: collision with root package name */
    static bl f1406x;

    /* renamed from: y  reason: collision with root package name */
    static ArrayList<bl> f1407y;

    /* renamed from: z  reason: collision with root package name */
    static ArrayList<bl> f1408z;

    /* renamed from: a  reason: collision with root package name */
    public String f1409a = "";
    public long b = 0;
    public String c = "";
    public String d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f1410e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f1411f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f1412g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f1413h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f1414i = "";

    /* renamed from: j  reason: collision with root package name */
    public bm f1415j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f1416k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f1417l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f1418m = "";

    /* renamed from: n  reason: collision with root package name */
    public bl f1419n = null;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<bl> f1420o = null;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<bl> f1421p = null;
    public ArrayList<bn> q = null;

    /* renamed from: r  reason: collision with root package name */
    public Map<String, String> f1422r = null;
    public Map<String, String> s = null;

    /* renamed from: t  reason: collision with root package name */
    public String f1423t = "";

    /* renamed from: u  reason: collision with root package name */
    public boolean f1424u = true;

    static {
        HashMap hashMap = new HashMap();
        f1405v = hashMap;
        hashMap.put("", "");
        w = new bm();
        f1406x = new bl();
        f1407y = new ArrayList<>();
        f1407y.add(new bl());
        f1408z = new ArrayList<>();
        f1408z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1409a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        String str = this.d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f1410e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f1411f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f1412g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f1413h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f1414i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.f1415j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.f1416k, 10);
        String str6 = this.f1417l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f1418m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.f1419n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.f1420o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f1421p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f1422r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f1423t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f1424u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1409a = kVar.b(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.b(2, true);
        this.d = kVar.b(3, false);
        this.f1410e = kVar.b(4, false);
        this.f1411f = kVar.b(5, false);
        this.f1412g = kVar.b(6, false);
        this.f1413h = (Map) kVar.a((k) f1405v, 7, false);
        this.f1414i = kVar.b(8, false);
        this.f1415j = (bm) kVar.a((m) w, 9, false);
        this.f1416k = kVar.a(this.f1416k, 10, false);
        this.f1417l = kVar.b(11, false);
        this.f1418m = kVar.b(12, false);
        this.f1419n = (bl) kVar.a((m) f1406x, 13, false);
        this.f1420o = (ArrayList) kVar.a((k) f1407y, 14, false);
        this.f1421p = (ArrayList) kVar.a((k) f1408z, 15, false);
        this.q = (ArrayList) kVar.a((k) A, 16, false);
        this.f1422r = (Map) kVar.a((k) B, 17, false);
        this.s = (Map) kVar.a((k) C, 18, false);
        this.f1423t = kVar.b(19, false);
        this.f1424u = kVar.a(20, false);
    }
}
