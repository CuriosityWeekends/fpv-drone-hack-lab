package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j2, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j2, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i3, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setAndAllowWhileIdle(i3, j2, pendingIntent);
        } else {
            alarmManager.set(i3, j2, pendingIntent);
        }
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i3, long j2, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i3, j2, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i3, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(i3, j2, pendingIntent);
        } else {
            setExact(alarmManager, i3, j2, pendingIntent);
        }
    }
}
