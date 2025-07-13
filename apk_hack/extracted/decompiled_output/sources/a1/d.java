package a1;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final d f34a = new Object();

    @Override // a1.l
    public MediaCodecInfo a(int i3) {
        return MediaCodecList.getCodecInfoAt(i3);
    }

    @Override // a1.l
    public boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // a1.l
    public int d() {
        return MediaCodecList.getCodecCount();
    }

    @Override // a1.l
    public boolean e(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if ("secure-playback".equals(str) && "video/avc".equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // a1.l
    public boolean f() {
        return false;
    }
}
