package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class VolumeProviderCompatApi21 {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Delegate {
        void onAdjustVolume(int i3);

        void onSetVolumeTo(int i3);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i3, int i5, int i6, final Delegate delegate) {
        return new VolumeProvider(i3, i5, i6) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i7) {
                delegate.onAdjustVolume(i7);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i7) {
                delegate.onSetVolumeTo(i7);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i3) {
        ((VolumeProvider) obj).setCurrentVolume(i3);
    }
}
