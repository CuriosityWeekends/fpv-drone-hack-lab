package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bumptech.glide.e;
import g2.b;
import h1.a;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f381a = new HashMap();

    public abstract e a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        a aVar = (a) f381a.get(getClass());
        a();
        throw null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        boolean z3;
        Object obj = f381a.get(getClass());
        obj.getClass();
        a aVar = (a) obj;
        if (aVar.f1985a == this) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.h(z3);
        aVar.f1985a = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i5) {
        if (intent != null) {
            String action = intent.getAction();
            intent.getStringExtra("content_id");
            if (!intent.getBooleanExtra("foreground", false)) {
                "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
            }
        }
        throw null;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
    }
}
