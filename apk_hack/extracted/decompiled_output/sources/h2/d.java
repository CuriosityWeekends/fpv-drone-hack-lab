package h2;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f1991a;
    public final int b;
    public final int c;

    public /* synthetic */ d(int i3, int i5, int i6) {
        this.f1991a = i3;
        this.b = i5;
        this.c = i6;
    }

    public d(k.g gVar) {
        Context context = gVar.f2490a;
        ActivityManager activityManager = gVar.b;
        int i3 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        this.c = i3;
        int round = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) gVar.c.b;
        float f4 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        float f5 = gVar.d;
        int round2 = Math.round(f4 * f5);
        int round3 = Math.round(f4 * 2.0f);
        int i5 = round - i3;
        int i6 = round3 + round2;
        if (i6 <= i5) {
            this.b = round3;
            this.f1991a = round2;
        } else {
            float f6 = i5 / (f5 + 2.0f);
            this.b = Math.round(2.0f * f6);
            this.f1991a = Math.round(f6 * f5);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(Formatter.formatFileSize(context, this.b));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(context, this.f1991a));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(context, i3));
            sb.append(", memory class limited? ");
            sb.append(i6 > round);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(context, round));
            sb.append(", memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(activityManager.isLowRamDevice());
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }
}
