package m;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements com.bumptech.glide.load.data.e {
    public static final String[] d = {"_data"};

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2745a;
    public final Object b;
    public final Object c;

    public /* synthetic */ l(int i3, Object obj, Object obj2) {
        this.f2745a = i3;
        this.b = obj;
        this.c = obj2;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f2745a) {
            case 0:
                return File.class;
            default:
                return ((b0) this.c).d();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i3 = this.f2745a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.j jVar, com.bumptech.glide.load.data.d dVar) {
        switch (this.f2745a) {
            case 0:
                Cursor query = ((Context) this.b).getContentResolver().query((Uri) this.c, d, null, null, null);
                String str = null;
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndexOrThrow("_data"));
                        }
                    } finally {
                        query.close();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    dVar.d(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.c)));
                    return;
                }
                dVar.f(new File(str));
                return;
            default:
                dVar.f(((b0) this.c).b((byte[]) this.b));
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f2745a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f2745a) {
            case 0:
                return 1;
            default:
                return 1;
        }
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }
}
