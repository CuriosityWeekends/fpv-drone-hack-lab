package a3;

import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f83a = false;
    public boolean b = false;
    public View c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f84e;

    public b(View view, int i3, int i5) {
        this.c = view;
        this.d = i3;
        this.f84e = i5;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();
}
