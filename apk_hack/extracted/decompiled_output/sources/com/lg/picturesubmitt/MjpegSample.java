package com.lg.picturesubmitt;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MjpegSample extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public MjpegView f539a;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        MjpegView mjpegView = new MjpegView(this);
        this.f539a = mjpegView;
        setContentView(mjpegView);
        this.f539a.setDisplayMode(4);
        this.f539a.getClass();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        MjpegView mjpegView = this.f539a;
        mjpegView.getClass();
        boolean z3 = true;
        while (z3) {
            try {
                mjpegView.f540a.join();
                z3 = false;
            } catch (InterruptedException unused) {
            }
        }
    }
}
