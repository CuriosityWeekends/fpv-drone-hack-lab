package l2;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends AbstractMap implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final b2.c f2701h = new b2.c(2);

    /* renamed from: a  reason: collision with root package name */
    public final Comparator f2702a;
    public j b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public final j f2703e;

    /* renamed from: f  reason: collision with root package name */
    public i f2704f;

    /* renamed from: g  reason: collision with root package name */
    public i f2705g;

    public k() {
        b2.c cVar = f2701h;
        this.c = 0;
        this.d = 0;
        this.f2703e = new j();
        this.f2702a = cVar;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final j a(Object obj, boolean z3) {
        int i3;
        j jVar;
        Comparable comparable;
        j jVar2;
        j jVar3 = this.b;
        b2.c cVar = f2701h;
        Comparator comparator = this.f2702a;
        if (jVar3 != null) {
            if (comparator == cVar) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                Object obj2 = jVar3.f2698f;
                if (comparable != null) {
                    i3 = comparable.compareTo(obj2);
                } else {
                    i3 = comparator.compare(obj, obj2);
                }
                if (i3 == 0) {
                    return jVar3;
                }
                if (i3 < 0) {
                    jVar2 = jVar3.b;
                } else {
                    jVar2 = jVar3.c;
                }
                if (jVar2 == null) {
                    break;
                }
                jVar3 = jVar2;
            }
        } else {
            i3 = 0;
        }
        if (!z3) {
            return null;
        }
        j jVar4 = this.f2703e;
        if (jVar3 == null) {
            if (comparator == cVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            jVar = new j(jVar3, obj, jVar4, jVar4.f2697e);
            this.b = jVar;
        } else {
            jVar = new j(jVar3, obj, jVar4, jVar4.f2697e);
            if (i3 < 0) {
                jVar3.b = jVar;
            } else {
                jVar3.c = jVar;
            }
            b(jVar3, true);
        }
        this.c++;
        this.d++;
        return jVar;
    }

    public final void b(j jVar, boolean z3) {
        int i3;
        int i5;
        int i6;
        int i7;
        while (jVar != null) {
            j jVar2 = jVar.b;
            j jVar3 = jVar.c;
            int i8 = 0;
            if (jVar2 != null) {
                i3 = jVar2.f2700h;
            } else {
                i3 = 0;
            }
            if (jVar3 != null) {
                i5 = jVar3.f2700h;
            } else {
                i5 = 0;
            }
            int i9 = i3 - i5;
            if (i9 == -2) {
                j jVar4 = jVar3.b;
                j jVar5 = jVar3.c;
                if (jVar5 != null) {
                    i7 = jVar5.f2700h;
                } else {
                    i7 = 0;
                }
                if (jVar4 != null) {
                    i8 = jVar4.f2700h;
                }
                int i10 = i8 - i7;
                if (i10 != -1 && (i10 != 0 || z3)) {
                    f(jVar3);
                    e(jVar);
                } else {
                    e(jVar);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 2) {
                j jVar6 = jVar2.b;
                j jVar7 = jVar2.c;
                if (jVar7 != null) {
                    i6 = jVar7.f2700h;
                } else {
                    i6 = 0;
                }
                if (jVar6 != null) {
                    i8 = jVar6.f2700h;
                }
                int i11 = i8 - i6;
                if (i11 != 1 && (i11 != 0 || z3)) {
                    e(jVar2);
                    f(jVar);
                } else {
                    f(jVar);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 0) {
                jVar.f2700h = i3 + 1;
                if (z3) {
                    return;
                }
            } else {
                jVar.f2700h = Math.max(i3, i5) + 1;
                if (!z3) {
                    return;
                }
            }
            jVar = jVar.f2696a;
        }
    }

    public final void c(j jVar, boolean z3) {
        j jVar2;
        j jVar3;
        int i3;
        if (z3) {
            j jVar4 = jVar.f2697e;
            jVar4.d = jVar.d;
            jVar.d.f2697e = jVar4;
        }
        j jVar5 = jVar.b;
        j jVar6 = jVar.c;
        j jVar7 = jVar.f2696a;
        int i5 = 0;
        if (jVar5 != null && jVar6 != null) {
            if (jVar5.f2700h > jVar6.f2700h) {
                j jVar8 = jVar5.c;
                while (true) {
                    j jVar9 = jVar8;
                    jVar3 = jVar5;
                    jVar5 = jVar9;
                    if (jVar5 == null) {
                        break;
                    }
                    jVar8 = jVar5.c;
                }
            } else {
                j jVar10 = jVar6.b;
                while (true) {
                    jVar2 = jVar6;
                    jVar6 = jVar10;
                    if (jVar6 == null) {
                        break;
                    }
                    jVar10 = jVar6.b;
                }
                jVar3 = jVar2;
            }
            c(jVar3, false);
            j jVar11 = jVar.b;
            if (jVar11 != null) {
                i3 = jVar11.f2700h;
                jVar3.b = jVar11;
                jVar11.f2696a = jVar3;
                jVar.b = null;
            } else {
                i3 = 0;
            }
            j jVar12 = jVar.c;
            if (jVar12 != null) {
                i5 = jVar12.f2700h;
                jVar3.c = jVar12;
                jVar12.f2696a = jVar3;
                jVar.c = null;
            }
            jVar3.f2700h = Math.max(i3, i5) + 1;
            d(jVar, jVar3);
            return;
        }
        if (jVar5 != null) {
            d(jVar, jVar5);
            jVar.b = null;
        } else if (jVar6 != null) {
            d(jVar, jVar6);
            jVar.c = null;
        } else {
            d(jVar, null);
        }
        b(jVar7, false);
        this.c--;
        this.d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        j jVar = this.f2703e;
        jVar.f2697e = jVar;
        jVar.d = jVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        j jVar = null;
        if (obj != null) {
            try {
                jVar = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (jVar == null) {
            return false;
        }
        return true;
    }

    public final void d(j jVar, j jVar2) {
        j jVar3 = jVar.f2696a;
        jVar.f2696a = null;
        if (jVar2 != null) {
            jVar2.f2696a = jVar3;
        }
        if (jVar3 != null) {
            if (jVar3.b == jVar) {
                jVar3.b = jVar2;
                return;
            } else {
                jVar3.c = jVar2;
                return;
            }
        }
        this.b = jVar2;
    }

    public final void e(j jVar) {
        int i3;
        int i5;
        j jVar2 = jVar.b;
        j jVar3 = jVar.c;
        j jVar4 = jVar3.b;
        j jVar5 = jVar3.c;
        jVar.c = jVar4;
        if (jVar4 != null) {
            jVar4.f2696a = jVar;
        }
        d(jVar, jVar3);
        jVar3.b = jVar;
        jVar.f2696a = jVar3;
        int i6 = 0;
        if (jVar2 != null) {
            i3 = jVar2.f2700h;
        } else {
            i3 = 0;
        }
        if (jVar4 != null) {
            i5 = jVar4.f2700h;
        } else {
            i5 = 0;
        }
        int max = Math.max(i3, i5) + 1;
        jVar.f2700h = max;
        if (jVar5 != null) {
            i6 = jVar5.f2700h;
        }
        jVar3.f2700h = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        i iVar = this.f2704f;
        if (iVar == null) {
            i iVar2 = new i(this, 0);
            this.f2704f = iVar2;
            return iVar2;
        }
        return iVar;
    }

    public final void f(j jVar) {
        int i3;
        int i5;
        j jVar2 = jVar.b;
        j jVar3 = jVar.c;
        j jVar4 = jVar2.b;
        j jVar5 = jVar2.c;
        jVar.b = jVar5;
        if (jVar5 != null) {
            jVar5.f2696a = jVar;
        }
        d(jVar, jVar2);
        jVar2.c = jVar;
        jVar.f2696a = jVar2;
        int i6 = 0;
        if (jVar3 != null) {
            i3 = jVar3.f2700h;
        } else {
            i3 = 0;
        }
        if (jVar5 != null) {
            i5 = jVar5.f2700h;
        } else {
            i5 = 0;
        }
        int max = Math.max(i3, i5) + 1;
        jVar.f2700h = max;
        if (jVar4 != null) {
            i6 = jVar4.f2700h;
        }
        jVar2.f2700h = Math.max(max, i6) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            l2.j r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto Lf
            java.lang.Object r0 = r3.f2699g
        Lf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.k.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        i iVar = this.f2705g;
        if (iVar == null) {
            i iVar2 = new i(this, 1);
            this.f2705g = iVar2;
            return iVar2;
        }
        return iVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj != null) {
            j a5 = a(obj, true);
            Object obj3 = a5.f2699g;
            a5.f2699g = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            l2.j r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto L11
            r1 = 1
            r2.c(r3, r1)
        L11:
            if (r3 == 0) goto L15
            java.lang.Object r0 = r3.f2699g
        L15:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.k.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c;
    }
}
