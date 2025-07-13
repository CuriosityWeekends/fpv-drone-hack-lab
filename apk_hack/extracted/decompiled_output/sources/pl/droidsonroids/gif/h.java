package pl.droidsonroids.gif;

import android.widget.ImageView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifTextureView f3302a;
    public final /* synthetic */ i b;

    public h(i iVar, GifTextureView gifTextureView) {
        this.b = iVar;
        this.f3302a = gifTextureView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GifInfoHandle gifInfoHandle = this.b.b;
        ImageView.ScaleType[] scaleTypeArr = GifTextureView.f3277g;
        this.f3302a.d(gifInfoHandle);
    }
}
