package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v0 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final int f1540a = 4;
    public int b;
    public String c;
    public byte[] d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f1541e;

    public v0(w wVar) {
        this.f1541e = wVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Cursor a5;
        int i3 = this.f1540a;
        w wVar = this.f1541e;
        switch (i3) {
            case 1:
                wVar.a((String) null, (ContentValues) null, (v) null);
                return;
            case 2:
                wVar.a((String) null, (String) null, (String[]) null, (v) null);
                return;
            case 3:
                a5 = this.f1541e.a(false, null, null, null, null, null, null, null, null, null);
                if (a5 != null) {
                    a5.close();
                    return;
                }
                return;
            case 4:
                wVar.a(this.b, this.c, this.d, (v) null);
                return;
            case 5:
                wVar.a(this.b, (v) null);
                return;
            case 6:
                wVar.a(this.b, this.c, (v) null);
                return;
            default:
                return;
        }
    }
}
