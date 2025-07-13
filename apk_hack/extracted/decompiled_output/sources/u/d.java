package u;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import g.h;
import i.g0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import p.z;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements a {
    public static final d b = new d(0);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3725a;

    public /* synthetic */ d(int i3) {
        this.f3725a = i3;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, c0.b] */
    @Override // u.a
    public final g0 b(g0 g0Var, h hVar) {
        c0.b bVar;
        byte[] bArr;
        switch (this.f3725a) {
            case 0:
                return g0Var;
            default:
                ByteBuffer asReadOnlyBuffer = ((GifDrawable) g0Var.get()).f267a.f3551a.f3557a.d.asReadOnlyBuffer();
                AtomicReference atomicReference = c0.c.f188a;
                if (!asReadOnlyBuffer.isReadOnly() && asReadOnlyBuffer.hasArray()) {
                    byte[] array = asReadOnlyBuffer.array();
                    int arrayOffset = asReadOnlyBuffer.arrayOffset();
                    int limit = asReadOnlyBuffer.limit();
                    ?? obj = new Object();
                    obj.f187a = array;
                    obj.b = arrayOffset;
                    obj.c = limit;
                    bVar = obj;
                } else {
                    bVar = null;
                }
                if (bVar != null && bVar.b == 0) {
                    if (bVar.c == bVar.f187a.length) {
                        bArr = asReadOnlyBuffer.array();
                        return new z(bArr);
                    }
                }
                ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
                byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
                asReadOnlyBuffer2.position(0);
                asReadOnlyBuffer2.get(bArr2);
                bArr = bArr2;
                return new z(bArr);
        }
    }
}
