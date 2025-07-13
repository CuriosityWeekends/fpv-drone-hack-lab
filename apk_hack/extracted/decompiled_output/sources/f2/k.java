package f2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.DataOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k {

    /* renamed from: e  reason: collision with root package name */
    public final j f1839e;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1838a = new HashMap();
    public final SparseArray b = new SparseArray();
    public final SparseBooleanArray c = new SparseBooleanArray();
    public final SparseBooleanArray d = new SparseBooleanArray();

    /* renamed from: f  reason: collision with root package name */
    public j f1840f = null;

    public k(File file) {
        this.f1839e = new j(new File(file, "cached_content_index.exi"));
    }

    public static void a(m mVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> entrySet = mVar.b.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry entry : entrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public final i b(String str) {
        return (i) this.f1838a.get(str);
    }

    public final i c(String str) {
        int keyAt;
        HashMap hashMap = this.f1838a;
        i iVar = (i) hashMap.get(str);
        if (iVar == null) {
            SparseArray sparseArray = this.b;
            int size = sparseArray.size();
            int i3 = 0;
            if (size == 0) {
                keyAt = 0;
            } else {
                keyAt = sparseArray.keyAt(size - 1) + 1;
            }
            if (keyAt < 0) {
                while (i3 < size && i3 == sparseArray.keyAt(i3)) {
                    i3++;
                }
                keyAt = i3;
            }
            i iVar2 = new i(keyAt, str, m.c);
            hashMap.put(str, iVar2);
            sparseArray.put(keyAt, str);
            this.d.put(keyAt, true);
            this.f1839e.g(iVar2);
            return iVar2;
        }
        return iVar;
    }

    public final void d(long j2) {
        j jVar;
        j jVar2 = this.f1839e;
        jVar2.d(j2);
        j jVar3 = this.f1840f;
        if (jVar3 != null) {
            jVar3.d(j2);
        }
        boolean b = jVar2.b();
        SparseArray sparseArray = this.b;
        HashMap hashMap = this.f1838a;
        if (!b && (jVar = this.f1840f) != null && jVar.b()) {
            this.f1840f.e(hashMap, sparseArray);
            jVar2.i(hashMap);
        } else {
            jVar2.e(hashMap, sparseArray);
        }
        j jVar4 = this.f1840f;
        if (jVar4 != null) {
            jVar4.a();
            this.f1840f = null;
        }
    }

    public final void e(String str) {
        HashMap hashMap = this.f1838a;
        i iVar = (i) hashMap.get(str);
        if (iVar != null && iVar.c.isEmpty() && !iVar.f1833e) {
            hashMap.remove(str);
            SparseBooleanArray sparseBooleanArray = this.d;
            int i3 = iVar.f1832a;
            boolean z3 = sparseBooleanArray.get(i3);
            this.f1839e.f(iVar, z3);
            SparseArray sparseArray = this.b;
            if (z3) {
                sparseArray.remove(i3);
                sparseBooleanArray.delete(i3);
                return;
            }
            sparseArray.put(i3, null);
            this.c.put(i3, true);
        }
    }

    public final void f() {
        this.f1839e.j(this.f1838a);
        SparseBooleanArray sparseBooleanArray = this.c;
        int size = sparseBooleanArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.b.remove(sparseBooleanArray.keyAt(i3));
        }
        sparseBooleanArray.clear();
        this.d.clear();
    }
}
