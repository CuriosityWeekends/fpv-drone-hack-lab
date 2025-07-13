package m;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2729a = 0;
    public final Object b;
    public final Object c;

    public b(Resources resources, q qVar) {
        this.c = resources;
        this.b = qVar;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        Uri uri;
        switch (this.f2729a) {
            case 0:
                Uri uri2 = (Uri) obj;
                return new p(new b0.b(uri2), ((a) this.c).a((AssetManager) this.b, uri2.toString().substring(22)));
            default:
                Integer num = (Integer) obj;
                Resources resources = (Resources) this.c;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
                } catch (Resources.NotFoundException e5) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num, e5);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((q) this.b).a(uri, i3, i5, hVar);
        }
    }

    @Override // m.q
    public final boolean b(Object obj) {
        switch (this.f2729a) {
            case 0:
                Uri uri = (Uri) obj;
                if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
                    return false;
                }
                return true;
            default:
                Integer num = (Integer) obj;
                return true;
        }
    }

    public b(AssetManager assetManager, a aVar) {
        this.b = assetManager;
        this.c = aVar;
    }
}
