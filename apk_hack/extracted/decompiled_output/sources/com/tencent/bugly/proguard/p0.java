package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class p0 {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f1515a = new HashMap<>();
    protected HashMap<String, Object> b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f1516e = new HashMap<>();
    protected String c = "GBK";
    k d = new k();

    public void a(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (obj != null) {
            if (!(obj instanceof Set)) {
                l lVar = new l();
                lVar.a(this.c);
                lVar.a(obj, 0);
                byte[] a5 = n.a(lVar.f1505a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList arrayList = new ArrayList(1);
                while (true) {
                    if (obj.getClass().isArray()) {
                        if (obj.getClass().getComponentType().toString().equals("byte")) {
                            if (Array.getLength(obj) > 0) {
                                arrayList.add("java.util.List");
                                obj = Array.get(obj, 0);
                            } else {
                                arrayList.add("Array");
                                arrayList.add("?");
                                break;
                            }
                        } else {
                            throw new IllegalArgumentException("only byte[] is supported");
                        }
                    } else if (!(obj instanceof Array)) {
                        if (obj instanceof List) {
                            arrayList.add("java.util.List");
                            List list = (List) obj;
                            if (list.size() > 0) {
                                obj = list.get(0);
                            } else {
                                arrayList.add("?");
                                break;
                            }
                        } else if (obj instanceof Map) {
                            arrayList.add("java.util.Map");
                            Map map = (Map) obj;
                            if (map.size() > 0) {
                                Object next = map.keySet().iterator().next();
                                obj = map.get(next);
                                arrayList.add(next.getClass().getName());
                            } else {
                                arrayList.add("?");
                                arrayList.add("?");
                                break;
                            }
                        } else {
                            arrayList.add(obj.getClass().getName());
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException("can not support Array, please use List");
                    }
                }
                hashMap.put(a.a(arrayList), a5);
                this.f1516e.remove(str);
                this.f1515a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
        this.d.a(this.c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f1515a = this.d.a((Map) hashMap, 0, false);
    }
}
