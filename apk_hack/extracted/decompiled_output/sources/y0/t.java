package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4200a;
    public final g2.u b;
    public final c0.b c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4201e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4202f;

    /* renamed from: g  reason: collision with root package name */
    public long f4203g;

    /* renamed from: h  reason: collision with root package name */
    public long f4204h;

    /* renamed from: i  reason: collision with root package name */
    public long f4205i;

    public t(int i3) {
        this.f4200a = i3;
        switch (i3) {
            case 1:
                this.b = new g2.u(0L);
                this.f4203g = -9223372036854775807L;
                this.f4204h = -9223372036854775807L;
                this.f4205i = -9223372036854775807L;
                this.c = new c0.b();
                return;
            default:
                this.b = new g2.u(0L);
                this.f4203g = -9223372036854775807L;
                this.f4204h = -9223372036854775807L;
                this.f4205i = -9223372036854775807L;
                this.c = new c0.b();
                return;
        }
    }

    public static int b(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public static long c(c0.b bVar) {
        int i3 = bVar.b;
        if (bVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        bVar.b(bArr, 0, 9);
        bVar.y(i3);
        byte b = bArr[0];
        if ((b & 196) == 68) {
            byte b5 = bArr[2];
            if ((b5 & 4) == 4) {
                byte b6 = bArr[4];
                if ((b6 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j2 = b;
                    long j5 = b5;
                    return ((j5 & 3) << 13) | ((j2 & 3) << 28) | (((56 & j2) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j5 & 248) >> 3) << 15) | ((bArr[3] & 255) << 5) | ((b6 & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(p0.g gVar) {
        switch (this.f4200a) {
            case 0:
                byte[] bArr = g2.w.f1962f;
                c0.b bVar = this.c;
                bVar.getClass();
                bVar.w(bArr, bArr.length);
                this.d = true;
                gVar.f3111f = 0;
                return;
            default:
                byte[] bArr2 = g2.w.f1962f;
                c0.b bVar2 = this.c;
                bVar2.getClass();
                bVar2.w(bArr2, bArr2.length);
                this.d = true;
                gVar.f3111f = 0;
                return;
        }
    }
}
