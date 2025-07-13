package v;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3781a;
    public final c1.b b;
    public boolean c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final t2.k f3782e = new t2.k(5, this);

    public b(Context context, c1.b bVar) {
        this.f3781a = context.getApplicationContext();
        this.b = bVar;
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        c0.g.c(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (RuntimeException e5) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e5);
            }
            return true;
        }
    }

    @Override // v.f
    public final void onStart() {
        if (!this.d) {
            Context context = this.f3781a;
            this.c = j(context);
            try {
                context.registerReceiver(this.f3782e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.d = true;
            } catch (SecurityException e5) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e5);
                }
            }
        }
    }

    @Override // v.f
    public final void onStop() {
        if (this.d) {
            this.f3781a.unregisterReceiver(this.f3782e);
            this.d = false;
        }
    }

    @Override // v.f
    public final void i() {
    }
}
