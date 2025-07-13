package pl.droidsonroids.gif;

import android.content.res.AssetManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends p {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f3308a;
    public final String b;

    public n(AssetManager assetManager, String str) {
        this.f3308a = assetManager;
        this.b = str;
    }

    @Override // pl.droidsonroids.gif.p
    public final GifInfoHandle a() {
        return new GifInfoHandle(this.f3308a.openFd(this.b));
    }
}
