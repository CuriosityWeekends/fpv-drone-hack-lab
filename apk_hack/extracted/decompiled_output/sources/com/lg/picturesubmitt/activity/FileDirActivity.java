package com.lg.picturesubmitt.activity;

import android.os.Bundle;
import h3.b;
import t2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FileDirActivity extends BaseActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427376);
        b.f().e(this);
        findViewById(2131230841).setOnClickListener(new d(this, 0));
        findViewById(2131230857).setOnClickListener(new d(this, 1));
        findViewById(2131230878).setOnClickListener(new d(this, 2));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().d(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
