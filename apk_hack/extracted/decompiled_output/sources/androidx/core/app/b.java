package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.Context;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ Notification.Builder h(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static /* bridge */ /* synthetic */ NotificationChannel i(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel j(String str, CharSequence charSequence, int i3) {
        return new NotificationChannel(str, charSequence, i3);
    }

    public static /* synthetic */ NotificationChannelGroup k(String str, CharSequence charSequence) {
        return new NotificationChannelGroup(str, charSequence);
    }

    public static /* synthetic */ void q() {
    }
}
