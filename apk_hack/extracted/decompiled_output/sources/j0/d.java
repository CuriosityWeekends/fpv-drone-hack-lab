package j0;

import android.media.AudioManager;
import android.os.Handler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f2218a;
    public final /* synthetic */ e b;

    public d(e eVar, Handler handler) {
        this.b = eVar;
        this.f2218a = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i3) {
        this.f2218a.post(new c(this, i3, 0));
    }
}
