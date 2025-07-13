package m;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import i.g0;
import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class z implements r, u.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2760a;
    public final Resources b;

    public /* synthetic */ z(Resources resources, int i3) {
        this.f2760a = i3;
        this.b = resources;
    }

    @Override // u.a
    public g0 b(g0 g0Var, g.h hVar) {
        if (g0Var == null) {
            return null;
        }
        return new p.c(this.b, g0Var);
    }

    @Override // m.r
    public q n(y yVar) {
        switch (this.f2760a) {
            case 0:
                return new b(this.b, yVar.c(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new b(this.b, yVar.c(Uri.class, ParcelFileDescriptor.class));
            case 2:
                return new b(this.b, yVar.c(Uri.class, InputStream.class));
            default:
                return new b(this.b, c0.b);
        }
    }
}
