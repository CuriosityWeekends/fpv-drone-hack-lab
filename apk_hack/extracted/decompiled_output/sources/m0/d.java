package m0;

import j1.a0;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f2762a = new a0();
    public ByteBuffer b;
    public long c;
    public ByteBuffer d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2763e;

    public d(int i3) {
        this.f2763e = i3;
    }

    public final ByteBuffer a(int i3) {
        int capacity;
        int i5 = this.f2763e;
        if (i5 == 1) {
            return ByteBuffer.allocate(i3);
        }
        if (i5 == 2) {
            return ByteBuffer.allocateDirect(i3);
        }
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            capacity = 0;
        } else {
            capacity = byteBuffer.capacity();
        }
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i3 + ")");
    }

    public final void c(int i3) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            this.b = a(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.b.position();
        int i5 = i3 + position;
        if (capacity >= i5) {
            return;
        }
        ByteBuffer a5 = a(i5);
        if (position > 0) {
            this.b.flip();
            a5.put(this.b);
        }
        this.b = a5;
    }

    @Override // m0.a
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.d;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
    }

    public final void d() {
        this.b.flip();
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
    }
}
