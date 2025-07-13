package com.lg.picturesubmitt.activity;

import a1.i;
import android.os.Bundle;
import android.util.Log;
import b3.k;
import com.bumptech.glide.d;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import h3.b;
import java.io.File;
import l3.e;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SimplePlayerActivity extends BaseActivity {
    public StandardGSYVideoPlayer c;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        this.c.setVideoAllCallBack(null);
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427382);
        b.f().e(this);
        this.c = (StandardGSYVideoPlayer) findViewById(2131231524);
        d.f240a = Exo2PlayerManager.class;
        String stringExtra = getIntent().getStringExtra("NAME");
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.c);
        String k5 = i.k(sb, File.separator, stringExtra);
        Log.d("SimplePlayerActivity", "path=" + k5);
        this.c.setUp(k5, true, stringExtra);
        this.c.getTitleTextView().setVisibility(0);
        this.c.getBackButton().setVisibility(0);
        this.c.setIsTouchWiget(true);
        this.c.getBackButton().setOnClickListener(new k(8, this));
        this.c.startPlayLogic();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (e.c().listener() != null) {
            e.c().listener().onCompletion();
        }
        e.c().releaseMediaPlayer();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.c.onVideoPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.c.onVideoResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().d(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
