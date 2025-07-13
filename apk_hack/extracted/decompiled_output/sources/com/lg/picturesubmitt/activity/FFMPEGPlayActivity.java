package com.lg.picturesubmitt.activity;

import a1.i;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.d;
import j0.s;
import java.io.File;
import java.util.Timer;
import t2.a;
import t2.a0;
import t2.b;
import t2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FFMPEGPlayActivity extends BaseActivity {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f549n = 0;
    public ImageButton c;
    public TextView d;

    /* renamed from: e  reason: collision with root package name */
    public b f550e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f551f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f552g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f553h;

    /* renamed from: i  reason: collision with root package name */
    public String f554i;

    /* renamed from: j  reason: collision with root package name */
    public String f555j;

    /* renamed from: k  reason: collision with root package name */
    public Timer f556k;

    /* renamed from: l  reason: collision with root package name */
    public int f557l;

    /* renamed from: m  reason: collision with root package name */
    public final s f558m = new s(this, 3);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427375);
        h3.b.f().e(this);
        this.f553h = (FrameLayout) findViewById(2131231126);
        this.f551f = (RelativeLayout) findViewById(2131231435);
        this.f552g = (RelativeLayout) findViewById(2131230829);
        this.d = (TextView) findViewById(2131231442);
        b bVar = new b(this, this);
        this.f550e = bVar;
        this.f553h.addView(bVar);
        this.f550e.setOnTouchListener(new a0(this, 2));
        findViewById(2131231440).setOnClickListener(new a(this, 1));
        ImageButton imageButton = (ImageButton) findViewById(2131230886);
        this.c = imageButton;
        imageButton.setOnClickListener(new a(this, 1));
        findViewById(2131230884).setOnClickListener(new a(this, 1));
        findViewById(2131230885).setOnClickListener(new a(this, 1));
        ((ImageButton) findViewById(2131230887)).setOnClickListener(new a(this, 1));
        String stringExtra = getIntent().getStringExtra("NAME");
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.c);
        String str = File.separator;
        this.f554i = i.k(sb, str, stringExtra);
        this.f555j = this.b.d + str + stringExtra.replace(".mp4", ".jpg");
        this.d.setText(d.l(stringExtra.replace(".mp4", "")));
        Timer timer = new Timer();
        this.f556k = timer;
        timer.schedule(new c(0, this), 100L, 1000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        this.f556k.cancel();
        super.onDestroy();
    }

    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != 2131231440) {
            switch (id) {
                case 2131230884:
                    this.f550e.b();
                    return;
                case 2131230885:
                    this.f550e.c();
                    return;
                case 2131230886:
                    i.u(new StringBuilder("isPlaying="), this.f557l, "FFMPEGPlayActivity");
                    int i3 = this.f557l;
                    s sVar = this.f558m;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    this.f550e.d(this.f554i);
                                    this.c.setImageDrawable(getResources().getDrawable(17301539));
                                    sVar.sendEmptyMessageDelayed(2, 2000L);
                                    return;
                                }
                                return;
                            }
                            this.f550e.d(this.f554i);
                            this.c.setImageDrawable(getResources().getDrawable(17301539));
                            sVar.sendEmptyMessageDelayed(2, 2000L);
                            return;
                        }
                        sVar.sendEmptyMessageDelayed(2, 2000L);
                        this.f550e.c();
                        this.c.setImageDrawable(getResources().getDrawable(17301539));
                        return;
                    }
                    sVar.sendEmptyMessage(3);
                    this.f550e.b();
                    this.c.setImageDrawable(getResources().getDrawable(17301540));
                    return;
                case 2131230887:
                    this.f550e.e();
                    this.c.setImageDrawable(getResources().getDrawable(17301540));
                    return;
                default:
                    return;
            }
        }
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            h3.b.f().d(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
