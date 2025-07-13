package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f257a;
    public Object b;
    public final Comparable c;
    public final Object d;

    public /* synthetic */ b(int i3, Comparable comparable, Object obj) {
        this.f257a = i3;
        this.d = obj;
        this.c = comparable;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f257a) {
            case 0:
                Object obj = this.b;
                if (obj != null) {
                    try {
                        f(obj);
                    } catch (IOException unused) {
                        return;
                    }
                }
                return;
            default:
                Object obj2 = this.b;
                if (obj2 != null) {
                    try {
                        f(obj2);
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.j jVar, d dVar) {
        switch (this.f257a) {
            case 0:
                try {
                    Object h5 = h((AssetManager) this.d, (String) this.c);
                    this.b = h5;
                    dVar.f(h5);
                    return;
                } catch (IOException e5) {
                    if (Log.isLoggable("AssetPathFetcher", 3)) {
                        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e5);
                    }
                    dVar.d(e5);
                    return;
                }
            default:
                try {
                    Object g5 = g((ContentResolver) this.d, (Uri) this.c);
                    this.b = g5;
                    dVar.f(g5);
                    return;
                } catch (FileNotFoundException e6) {
                    if (Log.isLoggable("LocalUriFetcher", 3)) {
                        Log.d("LocalUriFetcher", "Failed to open Uri", e6);
                    }
                    dVar.d(e6);
                    return;
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f257a;
    }

    public abstract void f(Object obj);

    public abstract Object g(ContentResolver contentResolver, Uri uri);

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f257a) {
            case 0:
                return 1;
            default:
                return 1;
        }
    }

    public abstract Object h(AssetManager assetManager, String str);

    private final void d() {
    }

    private final void e() {
    }
}
