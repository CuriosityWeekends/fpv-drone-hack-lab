package w2;

import android.media.SoundPool;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3949a;

    public b(int i3) {
        this.f3949a = i3;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i3, int i5) {
        soundPool.play(this.f3949a, 1.0f, 1.0f, 0, 0, 1.0f);
    }
}
