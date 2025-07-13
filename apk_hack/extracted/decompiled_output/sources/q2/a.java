package q2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import g4.e;
import h4.c;
import h4.d;
import j4.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements View.OnClickListener, i4.a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f3356a;
    public final View b;
    public final c c;

    public a(View view, c cVar) {
        b.d(view, "view");
        b.d(cVar, "observer");
        this.f3356a = new AtomicBoolean();
        this.b = view;
        this.c = cVar;
    }

    @Override // i4.a
    public final void dispose() {
        if (this.f3356a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.b.setOnClickListener(null);
                return;
            }
            d dVar = g4.c.f1978a;
            if (dVar != null) {
                c2.b bVar = new c2.b(4, this);
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                e eVar = (e) dVar;
                if (timeUnit != null) {
                    Handler handler = eVar.f1980a;
                    Message obtain = Message.obtain(handler, new g4.d(handler, bVar));
                    obtain.setAsynchronous(true);
                    handler.sendMessageDelayed(obtain, timeUnit.toMillis(0L));
                    return;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("scheduler == null");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b.d(view, "v");
        if (!this.f3356a.get()) {
            this.c.c(v4.a.f3900a);
        }
    }
}
