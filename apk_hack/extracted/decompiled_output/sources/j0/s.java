package j0;

import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2304a;
    public final Object b;

    public /* synthetic */ s(KeyEvent.Callback callback, int i3) {
        this.f2304a = i3;
        this.b = callback;
    }

    /* JADX WARN: Removed duplicated region for block: B:253:0x06b0 A[Catch: Exception -> 0x0685, TryCatch #1 {Exception -> 0x0685, blocks: (B:233:0x0679, B:235:0x0681, B:238:0x0688, B:240:0x068c, B:242:0x0691, B:251:0x06a6, B:253:0x06b0, B:254:0x06b3, B:256:0x06b9, B:257:0x06be, B:259:0x06cf, B:260:0x06d2, B:248:0x069e, B:249:0x06a2), top: B:298:0x0679, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x06b9 A[Catch: Exception -> 0x0685, TryCatch #1 {Exception -> 0x0685, blocks: (B:233:0x0679, B:235:0x0681, B:238:0x0688, B:240:0x068c, B:242:0x0691, B:251:0x06a6, B:253:0x06b0, B:254:0x06b3, B:256:0x06b9, B:257:0x06be, B:259:0x06cf, B:260:0x06d2, B:248:0x069e, B:249:0x06a2), top: B:298:0x0679, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x06cf A[Catch: Exception -> 0x0685, TryCatch #1 {Exception -> 0x0685, blocks: (B:233:0x0679, B:235:0x0681, B:238:0x0688, B:240:0x068c, B:242:0x0691, B:251:0x06a6, B:253:0x06b0, B:254:0x06b3, B:256:0x06b9, B:257:0x06be, B:259:0x06cf, B:260:0x06d2, B:248:0x069e, B:249:0x06a2), top: B:298:0x0679, inners: #3 }] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 2068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.s.handleMessage(android.os.Message):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Object obj, Looper looper, int i3) {
        super(looper);
        this.f2304a = i3;
        this.b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(pl.droidsonroids.gif.c cVar) {
        super(Looper.getMainLooper());
        this.f2304a = 2;
        this.b = new WeakReference(cVar);
    }
}
