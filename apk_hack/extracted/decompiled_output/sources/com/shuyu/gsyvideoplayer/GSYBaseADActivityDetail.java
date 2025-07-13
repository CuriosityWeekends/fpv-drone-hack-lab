package com.shuyu.gsyvideoplayer;

import android.content.res.Configuration;
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import l3.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYBaseADActivityDetail<T extends GSYBaseVideoPlayer, R extends GSYADVideoPlayer> extends GSYBaseActivityDetail<T> {
    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, n3.g
    public final void c(String str, Object... objArr) {
        super.c(str, objArr);
        throw null;
    }

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, n3.g
    public final void i(Object... objArr) {
        ((GSYVideoPlayer) objArr[1]).getBackButton().setVisibility(8);
    }

    public abstract GSYADVideoPlayer m();

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (a.b(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        boolean z3 = this.f1134a;
        if (!this.b && m().getVisibility() == 0 && m().getCurrentPlayer().getCurrentState() >= 0 && m().getCurrentPlayer().getCurrentState() != 0 && m().getCurrentPlayer().getCurrentState() != 6) {
            this.f1134a = false;
            m().getCurrentPlayer().onConfigurationChanged(this, configuration, null, true, true);
        }
        super.onConfigurationChanged(configuration);
        this.f1134a = z3;
    }

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (a.c().listener() != null) {
            a.c().listener().onCompletion();
        }
        a.c().releaseMediaPlayer();
    }

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (a.c().listener() != null) {
            a.c().listener().onVideoPause();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.GSYBaseActivityDetail, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (a.c().listener() != null) {
            a.c().listener().onVideoResume();
        }
    }
}
