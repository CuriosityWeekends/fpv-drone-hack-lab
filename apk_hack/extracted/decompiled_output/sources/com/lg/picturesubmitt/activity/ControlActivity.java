package com.lg.picturesubmitt.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.github.chrisbanes.photoview.PhotoView;
import h3.b;
import t2.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ControlActivity extends BaseActivity {
    public static final /* synthetic */ int d = 0;
    public PhotoView c;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Drawable drawable;
        super.onCreate(bundle);
        setContentView(2131427374);
        b.f().e(this);
        findViewById(2131230842).setOnClickListener(new a(this, 0));
        this.c = (PhotoView) findViewById(2131231127);
        getResources().getDrawable(2131558448);
        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            drawable = getResources().getDrawable(2131558448);
        } else {
            drawable = getResources().getDrawable(2131558449);
        }
        this.c.setImageDrawable(drawable);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().d(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
