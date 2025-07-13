package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.al;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements TraceFileHelper.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TraceFileHelper.a f1221a;
    public final /* synthetic */ boolean b;

    public b(TraceFileHelper.a aVar, boolean z3) {
        this.f1221a = aVar;
        this.b = z3;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public final boolean a(String str, int i3, String str2, String str3) {
        al.c("new thread %s", str);
        TraceFileHelper.a aVar = this.f1221a;
        if (aVar.d == null) {
            aVar.d = new HashMap();
        }
        aVar.d.put(str, new String[]{str2, str3, String.valueOf(i3)});
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public final boolean a(long j2, long j5, String str) {
        al.c("new process %s", str);
        TraceFileHelper.a aVar = this.f1221a;
        aVar.f1219a = j2;
        aVar.b = str;
        aVar.c = j5;
        return this.b;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public final boolean a(long j2) {
        al.c("process end %d", Long.valueOf(j2));
        return false;
    }
}
