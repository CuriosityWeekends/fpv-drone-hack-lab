package l2;

import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public j f2696a;
    public j b;
    public j c;
    public j d;

    /* renamed from: e  reason: collision with root package name */
    public j f2697e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f2698f;

    /* renamed from: g  reason: collision with root package name */
    public Object f2699g;

    /* renamed from: h  reason: collision with root package name */
    public int f2700h;

    public j() {
        this.f2698f = null;
        this.f2697e = this;
        this.d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f2698f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f2699g;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2698f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2699g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i3 = 0;
        Object obj = this.f2698f;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f2699g;
        if (obj2 != null) {
            i3 = obj2.hashCode();
        }
        return i3 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f2699g;
        this.f2699g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f2698f + "=" + this.f2699g;
    }

    public j(j jVar, Object obj, j jVar2, j jVar3) {
        this.f2696a = jVar;
        this.f2698f = obj;
        this.f2700h = 1;
        this.d = jVar2;
        this.f2697e = jVar3;
        jVar3.d = this;
        jVar2.f2697e = this;
    }
}
