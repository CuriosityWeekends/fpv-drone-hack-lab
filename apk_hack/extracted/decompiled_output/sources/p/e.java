package p;

import android.os.ParcelFileDescriptor;
import i.g0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements g.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3061a;
    public final o b;

    public /* synthetic */ e(o oVar, int i3) {
        this.f3061a = i3;
        this.b = oVar;
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        switch (this.f3061a) {
            case 0:
                AtomicReference atomicReference = c0.c.f188a;
                c0.a aVar = new c0.a((ByteBuffer) obj);
                j3.b bVar = o.f3078k;
                o oVar = this.b;
                return oVar.a(new i.b(oVar.c, aVar, oVar.d), i3, i5, hVar, bVar);
            default:
                o oVar2 = this.b;
                return oVar2.a(new i.b((ParcelFileDescriptor) obj, (ArrayList) oVar2.d, oVar2.c), i3, i5, hVar, o.f3078k);
        }
    }

    @Override // g.j
    public final boolean b(Object obj, g.h hVar) {
        switch (this.f3061a) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                this.b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                this.b.getClass();
                return true;
        }
    }
}
