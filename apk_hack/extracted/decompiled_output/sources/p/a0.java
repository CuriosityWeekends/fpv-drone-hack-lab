package p;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import i.g0;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements g.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3057a;

    public /* synthetic */ a0(int i3) {
        this.f3057a = i3;
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        switch (this.f3057a) {
            case 0:
                return new z((Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new r.a(drawable, 0);
                }
                return null;
            default:
                return new z((File) obj);
        }
    }

    @Override // g.j
    public final /* bridge */ /* synthetic */ boolean b(Object obj, g.h hVar) {
        switch (this.f3057a) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                return true;
            case 1:
                Drawable drawable = (Drawable) obj;
                return true;
            default:
                File file = (File) obj;
                return true;
        }
    }
}
