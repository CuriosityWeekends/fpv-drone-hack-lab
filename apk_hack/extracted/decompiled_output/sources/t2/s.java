package t2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3715a;
    public WeakReference b;

    public /* synthetic */ s(int i3) {
        this.f3715a = i3;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        switch (this.f3715a) {
            case 0:
                Void[] voidArr = (Void[]) objArr;
                try {
                    WeakReference weakReference = this.b;
                    MainActivityDecode.l((MainActivityDecode) weakReference.get(), new c1.b((Context) weakReference.get(), 3).A());
                    return null;
                } catch (IOException e5) {
                    return e5;
                }
            case 1:
                Void[] voidArr2 = (Void[]) objArr;
                try {
                    WeakReference weakReference2 = this.b;
                    MainActivityNew.l((MainActivityNew) weakReference2.get(), new c1.b((Context) weakReference2.get(), 3).A());
                    return null;
                } catch (IOException e6) {
                    return e6;
                }
            default:
                Void[] voidArr3 = (Void[]) objArr;
                try {
                    WeakReference weakReference3 = this.b;
                    MainActivityRTSP.n((MainActivityRTSP) weakReference3.get(), new c1.b((Context) weakReference3.get(), 3).A());
                    return null;
                } catch (IOException e7) {
                    return e7;
                }
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        switch (this.f3715a) {
            case 0:
                Exception exc = (Exception) obj;
                if (exc != null) {
                    Log.d("MainActivityDecode", "Failed to init recognizer" + exc);
                    return;
                }
                MainActivityDecode mainActivityDecode = (MainActivityDecode) this.b.get();
                mainActivityDecode.f666v1.d();
                Log.i("ZYCHENG", " switchSearch searchName=wakeup");
                mainActivityDecode.f666v1.c();
                return;
            case 1:
                Exception exc2 = (Exception) obj;
                if (exc2 != null) {
                    Log.d("MainActivityNew", "Failed to init recognizer" + exc2);
                    return;
                }
                MainActivityNew mainActivityNew = (MainActivityNew) this.b.get();
                mainActivityNew.f731u1.d();
                Log.i("ZYCHENG", " switchSearch searchName=wakeup");
                mainActivityNew.f731u1.c();
                return;
            default:
                Exception exc3 = (Exception) obj;
                if (exc3 != null) {
                    Log.d("MainActivityRTSP", "Failed to init recognizer" + exc3);
                    return;
                }
                MainActivityRTSP mainActivityRTSP = (MainActivityRTSP) this.b.get();
                mainActivityRTSP.f747a1.d();
                Log.i("ZYCHENG", " switchSearch searchName=wakeup");
                mainActivityRTSP.f747a1.c();
                return;
        }
    }
}
