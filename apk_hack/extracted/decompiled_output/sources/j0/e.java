package j0;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final AudioManager f2223a;
    public final d b;
    public final p0 c;

    /* renamed from: e  reason: collision with root package name */
    public float f2224e = 1.0f;
    public int d = 0;

    public e(Context context, Handler handler, p0 p0Var) {
        this.f2223a = (AudioManager) context.getApplicationContext().getSystemService("audio");
        this.c = p0Var;
        this.b = new d(this, handler);
    }

    public final void a() {
        if (this.d == 0) {
            return;
        }
        if (g2.w.f1960a < 26) {
            this.f2223a.abandonAudioFocus(this.b);
        }
        this.d = 0;
    }
}
