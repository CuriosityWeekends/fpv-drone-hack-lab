package p;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements k, g.f, com.bumptech.glide.load.data.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3066a;
    public final ByteBuffer b;

    public i(int i3) {
        this.f3066a = i3;
        switch (i3) {
            case 3:
                this.b = ByteBuffer.allocate(4);
                return;
            default:
                this.b = ByteBuffer.allocate(8);
                return;
        }
    }

    private final void e(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l5 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.b) {
            this.b.position(0);
            messageDigest.update(this.b.putLong(l5.longValue()).array());
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // g.f
    public void c(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.f3066a) {
            case 2:
                e(bArr, obj, messageDigest);
                return;
            default:
                Integer num = (Integer) obj;
                if (num != null) {
                    messageDigest.update(bArr);
                    synchronized (this.b) {
                        this.b.position(0);
                        messageDigest.update(this.b.putInt(num.intValue()).array());
                    }
                    return;
                }
                return;
        }
    }

    public short d(int i3) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer.remaining() - i3 >= 2) {
            return byteBuffer.getShort(i3);
        }
        return (short) -1;
    }

    @Override // p.k
    public short g() {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new j();
    }

    @Override // p.k
    public int m() {
        return (g() << 8) | g();
    }

    @Override // p.k
    public long skip(long j2) {
        ByteBuffer byteBuffer = this.b;
        int min = (int) Math.min(byteBuffer.remaining(), j2);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    public i(byte[] bArr, int i3) {
        this.f3066a = 1;
        this.b = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i3);
    }

    public i(ByteBuffer byteBuffer, int i3) {
        this.f3066a = i3;
        switch (i3) {
            case 4:
                this.b = byteBuffer;
                return;
            default:
                this.b = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
    }
}
