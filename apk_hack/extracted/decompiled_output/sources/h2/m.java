package h2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f2022a;
    public final l b;
    public final k c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public long f2023e;

    /* renamed from: f  reason: collision with root package name */
    public long f2024f;

    /* renamed from: g  reason: collision with root package name */
    public long f2025g;

    /* renamed from: h  reason: collision with root package name */
    public long f2026h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2027i;

    /* renamed from: j  reason: collision with root package name */
    public long f2028j;

    /* renamed from: k  reason: collision with root package name */
    public long f2029k;

    /* renamed from: l  reason: collision with root package name */
    public long f2030l;

    public m(Context context) {
        DisplayManager displayManager;
        k kVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f2022a = (WindowManager) context.getSystemService("window");
        } else {
            this.f2022a = null;
        }
        if (this.f2022a != null) {
            if (w.f1960a >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                kVar = new k(this, displayManager);
            }
            this.c = kVar;
            this.b = l.f2020e;
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = -9223372036854775807L;
        this.f2023e = -9223372036854775807L;
    }

    public final void a() {
        Display defaultDisplay = this.f2022a.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.d = refreshRate;
            this.f2023e = (refreshRate * 80) / 100;
        }
    }
}
