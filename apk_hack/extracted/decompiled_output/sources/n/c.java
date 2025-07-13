package n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.e;
import g.h;
import java.io.File;
import java.io.FileNotFoundException;
import m.p;
import m.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements e {

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f2903k = {"_data"};

    /* renamed from: a  reason: collision with root package name */
    public final Context f2904a;
    public final q b;
    public final q c;
    public final Uri d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2905e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2906f;

    /* renamed from: g  reason: collision with root package name */
    public final h f2907g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f2908h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f2909i;

    /* renamed from: j  reason: collision with root package name */
    public volatile e f2910j;

    public c(Context context, q qVar, q qVar2, Uri uri, int i3, int i5, h hVar, Class cls) {
        this.f2904a = context.getApplicationContext();
        this.b = qVar;
        this.c = qVar2;
        this.d = uri;
        this.f2905e = i3;
        this.f2906f = i5;
        this.f2907g = hVar;
        this.f2908h = cls;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return this.f2908h;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        e eVar = this.f2910j;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(j jVar, com.bumptech.glide.load.data.d dVar) {
        try {
            e d = d();
            if (d == null) {
                dVar.d(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                return;
            }
            this.f2910j = d;
            if (this.f2909i) {
                cancel();
            } else {
                d.c(jVar, dVar);
            }
        } catch (FileNotFoundException e5) {
            dVar.d(e5);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f2909i = true;
        e eVar = this.f2910j;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public final e d() {
        boolean isExternalStorageLegacy;
        int checkSelfPermission;
        p a5;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        h hVar = this.f2907g;
        int i3 = this.f2906f;
        int i5 = this.f2905e;
        Context context = this.f2904a;
        if (!isExternalStorageLegacy) {
            checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            Uri uri = this.d;
            if (checkSelfPermission == 0) {
                uri = MediaStore.setRequireOriginal(uri);
            }
            a5 = this.c.a(uri, i5, i3, hVar);
        } else {
            Uri uri2 = this.d;
            try {
                Cursor query = context.getContentResolver().query(uri2, f2903k, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (!TextUtils.isEmpty(string)) {
                                File file = new File(string);
                                query.close();
                                a5 = this.b.a(file, i5, i3, hVar);
                            } else {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri2);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri2);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (a5 == null) {
            return null;
        }
        return a5.c;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return 1;
    }
}
