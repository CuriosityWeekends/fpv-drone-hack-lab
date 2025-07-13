package m1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g2.w;
import java.util.TreeMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final e2.m f2831a;
    public final e b;
    public final c1.a c;
    public final Handler d;

    /* renamed from: e  reason: collision with root package name */
    public final TreeMap f2832e = new TreeMap();

    /* renamed from: f  reason: collision with root package name */
    public n1.b f2833f;

    /* renamed from: g  reason: collision with root package name */
    public long f2834g;

    /* renamed from: h  reason: collision with root package name */
    public long f2835h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2836i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2837j;

    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, c1.a] */
    public r(n1.b bVar, e eVar, e2.m mVar) {
        this.f2833f = bVar;
        this.b = eVar;
        this.f2831a = mVar;
        int i3 = w.f1960a;
        Looper myLooper = Looper.myLooper();
        this.d = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper, this);
        this.c = new Object();
        this.f2834g = -9223372036854775807L;
        this.f2835h = -9223372036854775807L;
    }

    public final void a() {
        long j2 = this.f2835h;
        if (j2 != -9223372036854775807L && j2 == this.f2834g) {
            return;
        }
        this.f2836i = true;
        this.f2835h = this.f2834g;
        h hVar = this.b.b;
        hVar.B.removeCallbacks(hVar.f2804t);
        hVar.s();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (this.f2837j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        p pVar = (p) message.obj;
        long j2 = pVar.f2829a;
        TreeMap treeMap = this.f2832e;
        long j5 = pVar.b;
        Long l5 = (Long) treeMap.get(Long.valueOf(j5));
        if (l5 == null) {
            treeMap.put(Long.valueOf(j5), Long.valueOf(j2));
        } else if (l5.longValue() > j2) {
            treeMap.put(Long.valueOf(j5), Long.valueOf(j2));
        }
        return true;
    }
}
