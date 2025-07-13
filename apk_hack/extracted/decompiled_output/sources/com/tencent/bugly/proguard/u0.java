package com.tencent.bugly.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1539a;
    public final /* synthetic */ int b;
    public final /* synthetic */ u c;

    public /* synthetic */ u0(u uVar, int i3, int i5) {
        this.f1539a = i5;
        this.c = uVar;
        this.b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar;
        switch (this.f1539a) {
            case 0:
                u uVar = this.c;
                try {
                    if (!TextUtils.isEmpty(u.a(uVar))) {
                        List<t> a5 = u.a(uVar, 1004);
                        if (a5 == null) {
                            a5 = new ArrayList();
                        }
                        if (u.b(uVar).get(1004) == null) {
                            u.b(uVar).put(1004, new HashMap());
                        }
                        Object obj = ((Map) u.b(uVar).get(1004)).get(u.a(uVar));
                        int i3 = this.b;
                        if (obj == null) {
                            tVar = new t();
                            tVar.f1532a = 1004;
                            tVar.f1535g = u.f1536a;
                            tVar.b = u.a(uVar);
                            tVar.f1534f = aa.b().f1247o;
                            tVar.f1533e = aa.b().f1240h;
                            tVar.c = System.currentTimeMillis();
                            tVar.d = i3;
                            ((Map) u.b(uVar).get(1004)).put(u.a(uVar), tVar);
                        } else {
                            tVar = (t) ((Map) u.b(uVar).get(1004)).get(u.a(uVar));
                            tVar.d = i3;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z3 = false;
                        for (t tVar2 : a5) {
                            if (u.a(tVar2, tVar)) {
                                tVar2.d = tVar.d;
                                z3 = true;
                            }
                            if (u.b(tVar2, tVar)) {
                                arrayList.add(tVar2);
                            }
                        }
                        a5.removeAll(arrayList);
                        if (!z3) {
                            a5.add(tVar);
                        }
                        u.a(uVar, 1004, a5);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    al.e("saveCrashRecord failed", new Object[0]);
                    return;
                }
            default:
                u uVar2 = this.c;
                int i5 = this.b;
                boolean b = u.b(uVar2, i5);
                SharedPreferences.Editor edit = u.c(uVar2).edit();
                edit.putBoolean(i5 + "_" + u.a(uVar2), !b).commit();
                return;
        }
    }
}
