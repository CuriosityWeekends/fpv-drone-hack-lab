package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.hardware.fingerprint.FingerprintManager;
import javax.crypto.Mac;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean B(Object obj) {
        return obj instanceof Icon;
    }

    public static /* synthetic */ Notification.Action.Builder e(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    public static /* bridge */ /* synthetic */ Icon l(Object obj) {
        return (Icon) obj;
    }

    public static /* synthetic */ FingerprintManager.CryptoObject o(Mac mac) {
        return new FingerprintManager.CryptoObject(mac);
    }

    public static /* synthetic */ void s() {
    }
}
