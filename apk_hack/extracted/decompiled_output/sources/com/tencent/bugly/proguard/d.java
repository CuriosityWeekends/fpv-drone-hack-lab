package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class d extends p0 {

    /* renamed from: e  reason: collision with root package name */
    protected HashMap<String, byte[]> f1477e = null;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, Object> f1479g = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    k f1478f = new k();

    private void c(String str, Object obj) {
        this.f1479g.put(str, obj);
    }

    public final void a(String str) {
        this.c = str;
    }

    public void b() {
        this.f1477e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.p0
    public <T> void a(String str, T t4) {
        if (this.f1477e == null) {
            super.a(str, t4);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t4 != null) {
                if (!(t4 instanceof Set)) {
                    l lVar = new l();
                    lVar.a(this.c);
                    lVar.a(t4, 0);
                    this.f1477e.put(str, n.a(lVar.f1505a));
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
    }

    public final <T> T b(String str, T t4) {
        HashMap<String, byte[]> hashMap = this.f1477e;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f1479g.containsKey(str)) {
                    return (T) this.f1479g.get(str);
                }
                try {
                    this.f1478f.a(this.f1477e.get(str));
                    this.f1478f.a(this.c);
                    T t5 = (T) this.f1478f.a((k) t4, 0, true);
                    if (t5 != null) {
                        c(str, t5);
                    }
                    return t5;
                } catch (Exception e5) {
                    throw new b(e5);
                }
            }
            return null;
        } else if (this.f1515a.containsKey(str)) {
            if (this.f1479g.containsKey(str)) {
                return (T) this.f1479g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f1515a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f1478f.a(bArr);
                this.f1478f.a(this.c);
                T t6 = (T) this.f1478f.a((k) t4, 0, true);
                c(str, t6);
                return t6;
            } catch (Exception e6) {
                throw new b(e6);
            }
        } else {
            return null;
        }
    }

    public byte[] a() {
        if (this.f1477e != null) {
            l lVar = new l(0);
            lVar.a(this.c);
            lVar.a((Map) this.f1477e, 0);
            return n.a(lVar.f1505a);
        }
        l lVar2 = new l(0);
        lVar2.a(this.c);
        lVar2.a((Map) this.f1515a, 0);
        return n.a(lVar2.f1505a);
    }

    @Override // com.tencent.bugly.proguard.p0
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f1478f.a(bArr);
            this.f1478f.a(this.c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f1477e = this.f1478f.a((Map) hashMap, 0, false);
        }
    }
}
