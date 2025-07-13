package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bm extends m implements Cloneable {
    static ArrayList<String> c;

    /* renamed from: a  reason: collision with root package name */
    public String f1403a = "";
    public ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1403a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1403a = kVar.b(0, true);
        if (c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) kVar.a((k) c, 1, false);
    }
}
