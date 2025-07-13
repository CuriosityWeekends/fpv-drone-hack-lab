package com.shuyu.gsyvideoplayer;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import l3.e;
import n3.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYBaseActivityDetail<T extends GSYBaseVideoPlayer> extends AppCompatActivity implements g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1134a;
    public boolean b;

    public void c(String str, Object... objArr) {
        throw new NullPointerException("initVideo() or initVideoBuilderMode() first");
    }

    public abstract GSYBaseVideoPlayer l();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (e.b(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1134a && !this.b) {
            l().onConfigurationChanged(this, configuration, null, true, true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1134a) {
            l().getCurrentPlayer().release();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        l().getCurrentPlayer().onVideoPause();
        this.b = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l().getCurrentPlayer().onVideoResume();
        this.b = false;
    }

    public void i(Object... objArr) {
    }
}
