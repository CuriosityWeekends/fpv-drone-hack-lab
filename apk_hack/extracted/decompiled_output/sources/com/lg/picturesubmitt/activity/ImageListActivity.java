package com.lg.picturesubmitt.activity;

import a1.g;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.d;
import h3.b;
import j0.s;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import t2.a;
import t2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ImageListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f559k = 0;
    public TextView c;
    public TextView d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f560e;

    /* renamed from: f  reason: collision with root package name */
    public e f561f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f562g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f563h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public ExecutorService f564i;

    /* renamed from: j  reason: collision with root package name */
    public final s f565j;

    public ImageListActivity() {
        new ArrayList();
        this.f565j = new s(this, 4);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427377);
        b.f().c(this);
        this.f564i = Executors.newFixedThreadPool(10);
        this.c = (TextView) findViewById(2131231473);
        this.d = (TextView) findViewById(2131231442);
        this.f560e = (RecyclerView) findViewById(2131231317);
        findViewById(2131231440).setOnClickListener(new a(this, 2));
        findViewById(2131231441).setOnClickListener(new a(this, 2));
        ProgressBar progressBar = (ProgressBar) findViewById(2131231253);
        this.f562g = progressBar;
        progressBar.setVisibility(0);
        this.d.setText(getString(2131755311));
        this.f560e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        e eVar = new e(this, this.f563h);
        this.f561f = eVar;
        eVar.d = new g(2, this);
        this.f560e.setAdapter(eVar);
        new Thread(new d(12, this)).start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f564i.shutdown();
    }

    public void onViewClicked(View view) {
        if (view.getId() == 2131231440) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().c(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
