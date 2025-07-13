package m;

import android.content.res.AssetManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2727a;
    public final AssetManager b;

    public /* synthetic */ a(AssetManager assetManager, int i3) {
        this.f2727a = i3;
        this.b = assetManager;
    }

    public final com.bumptech.glide.load.data.e a(AssetManager assetManager, String str) {
        switch (this.f2727a) {
            case 0:
                return new com.bumptech.glide.load.data.k(assetManager, str, 0);
            default:
                return new com.bumptech.glide.load.data.k(assetManager, str, 1);
        }
    }

    @Override // m.r
    public final q n(y yVar) {
        switch (this.f2727a) {
            case 0:
                return new b(this.b, this);
            default:
                return new b(this.b, this);
        }
    }
}
