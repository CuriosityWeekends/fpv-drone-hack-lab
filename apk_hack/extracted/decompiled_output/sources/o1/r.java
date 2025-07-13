package o1;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import g2.u;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements p0.j {

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f3045g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f3046h = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public final String f3047a;
    public final u b;
    public p0.k d;

    /* renamed from: f  reason: collision with root package name */
    public int f3049f;
    public final c0.b c = new c0.b();

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3048e = new byte[1024];

    public r(String str, u uVar) {
        this.f3047a = str;
        this.b = uVar;
    }

    public final p0.u a(long j2) {
        p0.u g5 = this.d.g(0, 3);
        g5.d(Format.q(null, "text/vtt", 0, this.f3047a, -1, null, j2, Collections.emptyList()));
        this.d.c();
        return g5;
    }

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.d = kVar;
        kVar.a(new p0.n(-9223372036854775807L));
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        throw new IllegalStateException();
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        gVar.d(this.f3048e, 0, 6, false);
        byte[] bArr = this.f3048e;
        c0.b bVar = this.c;
        bVar.w(bArr, 6);
        if (a2.k.a(bVar)) {
            return true;
        }
        gVar.d(this.f3048e, 6, 3, false);
        bVar.w(this.f3048e, 9);
        return a2.k.a(bVar);
    }

    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        Matcher matcher;
        String d;
        int length;
        this.d.getClass();
        int i3 = (int) gVar.c;
        int i5 = this.f3049f;
        byte[] bArr = this.f3048e;
        if (i5 == bArr.length) {
            if (i3 != -1) {
                length = i3;
            } else {
                length = bArr.length;
            }
            this.f3048e = Arrays.copyOf(bArr, (length * 3) / 2);
        }
        byte[] bArr2 = this.f3048e;
        int i6 = this.f3049f;
        int e5 = gVar.e(bArr2, i6, bArr2.length - i6);
        if (e5 != -1) {
            int i7 = this.f3049f + e5;
            this.f3049f = i7;
            if (i3 == -1 || i7 != i3) {
                return 0;
            }
        }
        c0.b bVar = new c0.b(this.f3048e);
        a2.k.d(bVar);
        long j2 = 0;
        long j5 = 0;
        for (String d5 = bVar.d(); !TextUtils.isEmpty(d5); d5 = bVar.d()) {
            if (d5.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher2 = f3045g.matcher(d5);
                if (matcher2.find()) {
                    Matcher matcher3 = f3046h.matcher(d5);
                    if (matcher3.find()) {
                        j5 = a2.k.c(matcher2.group(1));
                        j2 = (Long.parseLong(matcher3.group(1)) * 1000000) / 90000;
                    } else {
                        throw new IOException("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(d5));
                    }
                } else {
                    throw new IOException("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(d5));
                }
            }
        }
        while (true) {
            String d6 = bVar.d();
            if (d6 != null) {
                if (a2.k.f80a.matcher(d6).matches()) {
                    do {
                        d = bVar.d();
                        if (d != null) {
                        }
                    } while (!d.isEmpty());
                } else {
                    matcher = a2.i.b.matcher(d6);
                    if (matcher.matches()) {
                        break;
                    }
                }
            } else {
                matcher = null;
                break;
            }
        }
        if (matcher == null) {
            a(0L);
        } else {
            long c = a2.k.c(matcher.group(1));
            long b = this.b.b((((j2 + c) - j5) * 90000) / 1000000);
            p0.u a5 = a(b - c);
            byte[] bArr3 = this.f3048e;
            int i8 = this.f3049f;
            c0.b bVar2 = this.c;
            bVar2.w(bArr3, i8);
            a5.b(this.f3049f, bVar2);
            a5.c(b, 1, this.f3049f, 0, null);
        }
        return -1;
    }
}
