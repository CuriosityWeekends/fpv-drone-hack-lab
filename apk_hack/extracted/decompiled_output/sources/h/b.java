package h;

import android.util.Log;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import m.b0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1982a;
    public final Comparable b;
    public final Object c;
    public Object d;

    public /* synthetic */ b(int i3, Comparable comparable, Object obj) {
        this.f1982a = i3;
        this.b = comparable;
        this.c = obj;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f1982a) {
            case 0:
                return InputStream.class;
            case 1:
                ((b0) this.c).getClass();
                return InputStream.class;
            default:
                return ((b0) this.c).d();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f1982a) {
            case 0:
                InputStream inputStream = (InputStream) this.d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                return;
            case 1:
                try {
                    ((b0) this.c).getClass();
                    ((ByteArrayInputStream) this.d).close();
                    return;
                } catch (IOException unused2) {
                    return;
                }
            default:
                Object obj = this.d;
                if (obj != null) {
                    try {
                        ((b0) this.c).a(obj);
                        return;
                    } catch (IOException unused3) {
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(j jVar, com.bumptech.glide.load.data.d dVar) {
        switch (this.f1982a) {
            case 0:
                try {
                    InputStream g5 = g();
                    this.d = g5;
                    dVar.f(g5);
                    return;
                } catch (FileNotFoundException e5) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e5);
                    }
                    dVar.d(e5);
                    return;
                }
            case 1:
                try {
                    ((b0) this.c).getClass();
                    ByteArrayInputStream c = b0.c((String) this.b);
                    this.d = c;
                    dVar.f(c);
                    return;
                } catch (IllegalArgumentException e6) {
                    dVar.d(e6);
                    return;
                }
            default:
                try {
                    Object e7 = ((b0) this.c).e((File) this.b);
                    this.d = e7;
                    dVar.f(e7);
                    return;
                } catch (FileNotFoundException e8) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e8);
                    }
                    dVar.d(e8);
                    return;
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f1982a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r6 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r6 != null) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0029: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:10:0x0029 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream g() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.b.g():java.io.InputStream");
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f1982a) {
            case 0:
                return 1;
            case 1:
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
}
