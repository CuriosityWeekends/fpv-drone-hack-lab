package androidx.core.app;

import android.app.NotificationChannelGroup;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class e {
    public static /* bridge */ /* synthetic */ NotificationChannelGroup c(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* synthetic */ RemoteAction e(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
    }

    public static /* synthetic */ void l() {
    }
}
