package m;

import android.content.ContentResolver;
import android.net.Uri;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d0 implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2734a;
    public final ContentResolver b;

    public /* synthetic */ d0(ContentResolver contentResolver, int i3) {
        this.f2734a = i3;
        this.b = contentResolver;
    }

    public final com.bumptech.glide.load.data.e a(Uri uri) {
        switch (this.f2734a) {
            case 0:
                return new com.bumptech.glide.load.data.a(this.b, uri, 0);
            case 1:
                return new com.bumptech.glide.load.data.a(this.b, uri, 1);
            default:
                return new com.bumptech.glide.load.data.b(1, uri, this.b);
        }
    }

    @Override // m.r
    public final q n(y yVar) {
        switch (this.f2734a) {
            case 0:
                return new e0(this);
            case 1:
                return new e0(this);
            default:
                return new e0(this);
        }
    }
}
