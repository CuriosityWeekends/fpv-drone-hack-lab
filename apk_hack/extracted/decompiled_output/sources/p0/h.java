package p0;

import com.google.android.exoplayer2.Format;
import java.lang.reflect.Constructor;
import java.util.Collections;
import y0.a0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final Constructor f3113a;

    static {
        Constructor constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(j.class).getConstructor(null);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e5) {
            throw new RuntimeException("Error instantiating FLAC extension", e5);
        }
        f3113a = constructor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [z0.d, java.lang.Object] */
    @Override // p0.l
    public final synchronized j[] a() {
        j[] jVarArr;
        jVarArr = new j[14];
        jVarArr[0] = new t0.e(0);
        jVarArr[1] = new v0.k(0, null, null, Collections.emptyList(), null);
        jVarArr[2] = new v0.n();
        jVarArr[3] = new u0.c();
        jVarArr[4] = new y0.d();
        jVarArr[5] = new y0.a();
        jVarArr[6] = new a0(1, new g2.u(0L), new h2.c(0, Collections.singletonList(Format.q(null, "application/cea-608", 0, null, -1, null, Long.MAX_VALUE, Collections.emptyList()))));
        jVarArr[7] = new s0.b();
        jVarArr[8] = new Object();
        jVarArr[9] = new y0.v();
        ?? obj = new Object();
        obj.d = -1;
        obj.f4283e = -1L;
        jVarArr[10] = obj;
        jVarArr[11] = new q0.a();
        jVarArr[12] = new y0.c();
        Constructor constructor = f3113a;
        if (constructor != null) {
            try {
                jVarArr[13] = (j) constructor.newInstance(null);
            } catch (Exception e5) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e5);
            }
        } else {
            jVarArr[13] = new r0.c();
        }
        return jVarArr;
    }
}
