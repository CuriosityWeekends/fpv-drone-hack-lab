package com.lg.picturesubmitt.activity;

import a1.g;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.d;
import com.lg.picturesubmitt.activity.VideoListActivity;
import com.lg.picturesubmitt.model.EntityVideo;
import h3.b;
import j0.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import t2.e;
import t2.p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VideoListActivity extends BaseActivity {

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ int f880l = 0;
    public RecyclerView c;
    public TextView d;

    /* renamed from: f  reason: collision with root package name */
    public TextView f882f;

    /* renamed from: g  reason: collision with root package name */
    public e f883g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f884h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f885i;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f881e = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f886j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final s f887k = new s(this, 10);

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d("VideoListActivity", "生命周期onConfigurationChanged");
        int i3 = configuration.orientation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.recyclerview.widget.RecyclerView$ItemDecoration, com.lg.picturesubmitt.widget.GridSpacingItemDecoration] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("VideoListActivity", "生命周期onCreate");
        setContentView(2131427386);
        b.f().c(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 256);
        }
        findViewById(2131231440).setOnClickListener(new View.OnClickListener(this) { // from class: t2.o0
            public final /* synthetic */ VideoListActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoListActivity videoListActivity = this.b;
                switch (r2) {
                    case 0:
                        int i3 = VideoListActivity.f880l;
                        videoListActivity.finish();
                        return;
                    default:
                        ArrayList arrayList = videoListActivity.f886j;
                        if (arrayList.size() > 0) {
                            videoListActivity.f881e.removeAll(arrayList);
                            videoListActivity.f883g.notifyDataSetChanged();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                EntityVideo entityVideo = (EntityVideo) it.next();
                                j4.b.u(videoListActivity.b.c + File.separator + entityVideo.value + ".mp4");
                                j4.b.u(entityVideo.thumbPath);
                            }
                            arrayList.clear();
                            videoListActivity.f882f.setText(videoListActivity.getString(2131755090));
                            return;
                        }
                        Toast.makeText(videoListActivity, videoListActivity.getString(2131755378), 0).show();
                        return;
                }
            }
        });
        TextView textView = (TextView) findViewById(2131231466);
        this.f882f = textView;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: t2.o0
            public final /* synthetic */ VideoListActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoListActivity videoListActivity = this.b;
                switch (r2) {
                    case 0:
                        int i3 = VideoListActivity.f880l;
                        videoListActivity.finish();
                        return;
                    default:
                        ArrayList arrayList = videoListActivity.f886j;
                        if (arrayList.size() > 0) {
                            videoListActivity.f881e.removeAll(arrayList);
                            videoListActivity.f883g.notifyDataSetChanged();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                EntityVideo entityVideo = (EntityVideo) it.next();
                                j4.b.u(videoListActivity.b.c + File.separator + entityVideo.value + ".mp4");
                                j4.b.u(entityVideo.thumbPath);
                            }
                            arrayList.clear();
                            videoListActivity.f882f.setText(videoListActivity.getString(2131755090));
                            return;
                        }
                        Toast.makeText(videoListActivity, videoListActivity.getString(2131755378), 0).show();
                        return;
                }
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(2131231253);
        this.f884h = progressBar;
        progressBar.setVisibility(0);
        ((TextView) findViewById(2131231442)).setText(getString(2131755025));
        this.c = (RecyclerView) findViewById(2131231131);
        this.d = (TextView) findViewById(2131231473);
        this.c.setLayoutManager(new GridLayoutManager((Context) this, 4, 1, false));
        RecyclerView recyclerView = this.c;
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131099794);
        ?? itemDecoration = new RecyclerView.ItemDecoration();
        itemDecoration.f910a = 4;
        itemDecoration.b = dimensionPixelSize;
        itemDecoration.c = true;
        recyclerView.addItemDecoration(itemDecoration);
        e eVar = new e(this, this.f881e);
        this.f883g = eVar;
        eVar.b = new p0(0, this);
        this.c.setAdapter(eVar);
        new Thread(new d(17, this)).start();
        this.f883g.c = new g(4, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.d("VideoListActivity", "生命周期onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        Log.d("VideoListActivity", "生命周期onPause");
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        Log.d("VideoListActivity", "生命周期onRestart");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        Log.d("VideoListActivity", "生命周期onStart");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.d("VideoListActivity", "生命周期onStop");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().b(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
