package com.lg.picturesubmitt.activity;

import a1.g;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.d;
import h3.b;
import j0.s;
import java.util.ArrayList;
import t2.a;
import t2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MusicActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f802k = 0;
    public TextView c;
    public TextView d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f803e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f804f;

    /* renamed from: g  reason: collision with root package name */
    public e f805g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f806h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f807i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final s f808j = new s(this, 8);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427379);
        b.f().c(this);
        this.c = (TextView) findViewById(2131231473);
        this.d = (TextView) findViewById(2131231442);
        TextView textView = (TextView) findViewById(2131231466);
        this.f803e = textView;
        textView.setVisibility(0);
        this.f804f = (RecyclerView) findViewById(2131231317);
        findViewById(2131231440).setOnClickListener(new a(this, 3));
        findViewById(2131231466).setOnClickListener(new a(this, 3));
        ProgressBar progressBar = (ProgressBar) findViewById(2131231253);
        this.f806h = progressBar;
        progressBar.setVisibility(0);
        this.d.setText(2131755287);
        this.f803e.setText(2131755285);
        this.f804f.setLayoutManager(new LinearLayoutManager(this, 1, false));
        e eVar = new e(this, this.f807i);
        this.f805g = eVar;
        eVar.d = new g(3, this);
        this.f804f.setAdapter(eVar);
        new Thread(new d(15, this)).start();
    }

    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != 2131231440) {
            if (id == 2131231466) {
                Intent intent = new Intent();
                intent.putExtra("MusicPath", (Parcelable) null);
                intent.putExtra("MusicInfo", (Parcelable) null);
                setResult(2, intent);
                finish();
                return;
            }
            return;
        }
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().c(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
