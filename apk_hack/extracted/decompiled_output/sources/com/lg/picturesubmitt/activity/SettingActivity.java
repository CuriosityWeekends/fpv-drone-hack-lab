package com.lg.picturesubmitt.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import b3.k;
import c1.b;
import t2.r;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SettingActivity extends BaseActivity {
    public b c;
    public CheckBox d;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427381);
        h3.b.f().c(this);
        b bVar = new b(this, 22);
        this.c = bVar;
        boolean t4 = bVar.t("isRightMode");
        CheckBox checkBox = (CheckBox) findViewById(2131230911);
        this.d = checkBox;
        checkBox.setChecked(t4);
        this.d.setOnCheckedChangeListener(new r(3, this));
        findViewById(2131230837).setOnClickListener(new k(7, this));
    }
}
