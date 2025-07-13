package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends d {

    /* renamed from: h  reason: collision with root package name */
    static HashMap<String, byte[]> f1481h;

    /* renamed from: i  reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f1482i;

    /* renamed from: g  reason: collision with root package name */
    protected g f1483g;

    /* renamed from: j  reason: collision with root package name */
    private int f1484j;

    public e() {
        g gVar = new g();
        this.f1483g = gVar;
        this.f1484j = 0;
        gVar.f1491a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.p0
    public final <T> void a(String str, T t4) {
        if (!str.startsWith(".")) {
            super.a(str, t4);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.f1483g.f1491a = (short) 3;
    }

    public final void c(String str) {
        this.f1483g.f1493f = str;
    }

    public final void c() {
        this.f1483g.d = 1;
    }

    public final void b(String str) {
        this.f1483g.f1492e = str;
    }

    @Override // com.tencent.bugly.proguard.d
    public final byte[] a() {
        g gVar = this.f1483g;
        if (gVar.f1491a == 2) {
            if (!gVar.f1492e.equals("")) {
                if (this.f1483g.f1493f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f1492e == null) {
                gVar.f1492e = "";
            }
            if (gVar.f1493f == null) {
                gVar.f1493f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.c);
        if (this.f1483g.f1491a == 2) {
            lVar.a((Map) this.f1515a, 0);
        } else {
            lVar.a((Map) ((d) this).f1477e, 0);
        }
        this.f1483g.f1494g = n.a(lVar.f1505a);
        l lVar2 = new l(0);
        lVar2.a(this.c);
        this.f1483g.a(lVar2);
        byte[] a5 = n.a(lVar2.f1505a);
        int length = a5.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a5).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.p0
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.c);
                this.f1483g.a(kVar);
                g gVar = this.f1483g;
                if (gVar.f1491a == 3) {
                    k kVar2 = new k(gVar.f1494g);
                    kVar2.a(this.c);
                    if (f1481h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f1481h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((d) this).f1477e = kVar2.a((Map) f1481h, 0, false);
                    return;
                }
                k kVar3 = new k(gVar.f1494g);
                kVar3.a(this.c);
                if (f1482i == null) {
                    f1482i = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f1482i.put("", hashMap2);
                }
                this.f1515a = kVar3.a((Map) f1482i, 0, false);
                this.b = new HashMap<>();
                return;
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
