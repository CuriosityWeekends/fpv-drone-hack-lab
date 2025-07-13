package s2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.activity.MainActivityDecode;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyApplication f3515a;

    public c(MyApplication myApplication) {
        this.f3515a = myApplication;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        MyApplication myApplication = this.f3515a;
        myApplication.f546f++;
        if (myApplication.f547g) {
            myApplication.f547g = false;
            Log.d("MyApplication", "回到前台");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        MyApplication myApplication = this.f3515a;
        int i3 = myApplication.f546f - 1;
        myApplication.f546f = i3;
        if (i3 == 0) {
            myApplication.f547g = true;
            Log.d("MyApplication", "压入后台");
            if (activity instanceof MainActivityDecode) {
                ((MainActivityDecode) activity).m();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
