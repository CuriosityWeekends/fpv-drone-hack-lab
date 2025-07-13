package z0;

import com.google.android.exoplayer2.Format;
import g2.w;
import java.io.IOException;
import p0.k;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements b {

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f4266m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f4267n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a  reason: collision with root package name */
    public final k f4268a;
    public final u b;
    public final e c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f4269e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f4270f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4271g;

    /* renamed from: h  reason: collision with root package name */
    public final Format f4272h;

    /* renamed from: i  reason: collision with root package name */
    public int f4273i;

    /* renamed from: j  reason: collision with root package name */
    public long f4274j;

    /* renamed from: k  reason: collision with root package name */
    public int f4275k;

    /* renamed from: l  reason: collision with root package name */
    public long f4276l;

    public a(k kVar, u uVar, e eVar) {
        this.f4268a = kVar;
        this.b = uVar;
        this.c = eVar;
        int max = Math.max(1, eVar.c / 10);
        this.f4271g = max;
        byte[] bArr = eVar.f4286f;
        int length = bArr.length;
        byte b = bArr[0];
        byte b5 = bArr[1];
        int i3 = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
        this.d = i3;
        int i5 = eVar.b;
        int i6 = eVar.d;
        int i7 = (((i6 - (i5 * 4)) * 8) / (eVar.f4285e * i5)) + 1;
        if (i3 == i7) {
            int e5 = w.e(max, i3);
            this.f4269e = new byte[e5 * i6];
            this.f4270f = new c0.b(i3 * 2 * i5 * e5);
            int i8 = eVar.c;
            this.f4272h = Format.k(null, "audio/raw", ((i6 * i8) * 8) / i3, max * 2 * i5, eVar.b, i8, 2, null, null, 0, null);
            return;
        }
        throw new IOException("Expected frames per block: " + i7 + "; got: " + i3);
    }

    @Override // z0.b
    public final void a(int i3, long j2) {
        this.f4268a.a(new f(this.c, this.d, i3, j2));
        this.b.d(this.f4272h);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0046 A[ADDED_TO_REGION, EDGE_INSN: B:44:0x0046->B:14:0x0046 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003d -> B:4:0x0021). Please submit an issue!!! */
    @Override // z0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(p0.g r26, long r27) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a.b(p0.g, long):boolean");
    }

    @Override // z0.b
    public final void c(long j2) {
        this.f4273i = 0;
        this.f4274j = j2;
        this.f4275k = 0;
        this.f4276l = 0L;
    }

    public final void d(int i3) {
        long j2 = this.f4274j;
        long j5 = this.f4276l;
        e eVar = this.c;
        long B = j2 + w.B(j5, 1000000L, eVar.c);
        int i5 = i3 * 2 * eVar.b;
        this.b.c(B, 1, i5, this.f4275k - i5, null);
        this.f4276l += i3;
        this.f4275k -= i5;
    }
}
