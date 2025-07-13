package com.lg.picturesubmitt.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.lg.picturesubmitt.MyApplication;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BaseActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f548a;
    public MyApplication b;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i3) {
        super.setContentView(2131427373);
        ((FrameLayout) findViewById(2131231220)).setTag("notch_container");
        this.f548a = (FrameLayout) findViewById(2131230948);
        LayoutInflater.from(this).inflate(i3, (ViewGroup) this.f548a, true);
        this.b = (MyApplication) getApplication();
    }
}
