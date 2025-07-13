package androidx.core.view.accessibility;

import android.database.CursorWindow;
import android.graphics.ImageDecoder;
import android.media.session.MediaSessionManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ CursorWindow b(String str, long j2) {
        return new CursorWindow(str, j2);
    }

    public static /* bridge */ /* synthetic */ ImageDecoder.Source d(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* synthetic */ MediaSessionManager.RemoteUserInfo e(int i3, int i5, String str) {
        return new MediaSessionManager.RemoteUserInfo(str, i3, i5);
    }

    public static /* bridge */ /* synthetic */ void s(Object obj) {
        ImageDecoder.Source source = (ImageDecoder.Source) obj;
    }
}
