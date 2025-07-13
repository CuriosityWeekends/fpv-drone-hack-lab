package l0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f2535a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    ByteBuffer a();

    void b();

    d c(d dVar);

    boolean d();

    void e(ByteBuffer byteBuffer);

    void flush();

    boolean isActive();

    void reset();
}
