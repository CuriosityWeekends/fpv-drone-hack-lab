package pl.droidsonroids.gif;

import android.content.res.Resources;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends p {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f3309a;
    public final int b;

    public o(Resources resources, int i3) {
        this.f3309a = resources;
        this.b = i3;
    }

    @Override // pl.droidsonroids.gif.p
    public final GifInfoHandle a() {
        return new GifInfoHandle(this.f3309a.openRawResourceFd(this.b));
    }
}
