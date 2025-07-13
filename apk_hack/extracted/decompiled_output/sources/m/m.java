package m;

import android.content.Context;
import android.net.Uri;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2746a;
    public final Context b;

    public m(Context context, int i3) {
        this.f2746a = i3;
        switch (i3) {
            case 1:
                this.b = context.getApplicationContext();
                return;
            case 2:
                this.b = context.getApplicationContext();
                return;
            default:
                this.b = context;
                return;
        }
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        Long l5;
        switch (this.f2746a) {
            case 0:
                Uri uri = (Uri) obj;
                return new p(new b0.b(uri), new l(0, this.b, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i3 != Integer.MIN_VALUE && i5 != Integer.MIN_VALUE && i3 <= 512 && i5 <= 384) {
                    b0.b bVar = new b0.b(uri2);
                    Context context = this.b;
                    return new p(bVar, new h.b(0, uri2, new h.d(com.bumptech.glide.b.b(context).d.f(), new h.a(context.getContentResolver(), 0), com.bumptech.glide.b.b(context).f235e, context.getContentResolver())));
                }
                return null;
            default:
                Uri uri3 = (Uri) obj;
                if (i3 != Integer.MIN_VALUE && i5 != Integer.MIN_VALUE && i3 <= 512 && i5 <= 384 && (l5 = (Long) hVar.c(p.f0.d)) != null && l5.longValue() == -1) {
                    b0.b bVar2 = new b0.b(uri3);
                    Context context2 = this.b;
                    return new p(bVar2, new h.b(0, uri3, new h.d(com.bumptech.glide.b.b(context2).d.f(), new h.a(context2.getContentResolver(), 1), com.bumptech.glide.b.b(context2).f235e, context2.getContentResolver())));
                }
                return null;
        }
    }

    @Override // m.q
    public final boolean b(Object obj) {
        switch (this.f2746a) {
            case 0:
                return com.bumptech.glide.d.g((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                if (com.bumptech.glide.d.g(uri) && !uri.getPathSegments().contains("video")) {
                    return true;
                }
                return false;
            default:
                Uri uri2 = (Uri) obj;
                if (com.bumptech.glide.d.g(uri2) && uri2.getPathSegments().contains("video")) {
                    return true;
                }
                return false;
        }
    }
}
