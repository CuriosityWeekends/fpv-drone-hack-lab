package o1;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import g2.w;
import java.io.EOFException;
import java.util.Arrays;
import p0.t;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n implements u {

    /* renamed from: g  reason: collision with root package name */
    public static final Format f3019g = Format.n(Long.MAX_VALUE, null, "application/id3");

    /* renamed from: h  reason: collision with root package name */
    public static final Format f3020h = Format.n(Long.MAX_VALUE, null, "application/x-emsg");

    /* renamed from: a  reason: collision with root package name */
    public final c1.a f3021a = new Object();
    public final u b;
    public final Format c;
    public Format d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3022e;

    /* renamed from: f  reason: collision with root package name */
    public int f3023f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, c1.a] */
    public n(u uVar, int i3) {
        this.b = uVar;
        if (i3 != 1) {
            if (i3 == 3) {
                this.c = f3020h;
            } else {
                throw new IllegalArgumentException(a1.i.e(i3, "Unknown metadataType: "));
            }
        } else {
            this.c = f3019g;
        }
        this.f3022e = new byte[0];
        this.f3023f = 0;
    }

    @Override // p0.u
    public final int a(p0.g gVar, int i3, boolean z3) {
        int i5 = this.f3023f + i3;
        byte[] bArr = this.f3022e;
        if (bArr.length < i5) {
            this.f3022e = Arrays.copyOf(bArr, (i5 / 2) + i5);
        }
        int e5 = gVar.e(this.f3022e, this.f3023f, i3);
        if (e5 == -1) {
            if (z3) {
                return -1;
            }
            throw new EOFException();
        }
        this.f3023f += e5;
        return e5;
    }

    @Override // p0.u
    public final void b(int i3, c0.b bVar) {
        int i5 = this.f3023f + i3;
        byte[] bArr = this.f3022e;
        if (bArr.length < i5) {
            this.f3022e = Arrays.copyOf(bArr, (i5 / 2) + i5);
        }
        bVar.b(this.f3022e, this.f3023f, i3);
        this.f3023f += i3;
    }

    @Override // p0.u
    public final void c(long j2, int i3, int i5, int i6, t tVar) {
        this.d.getClass();
        int i7 = this.f3023f - i6;
        c0.b bVar = new c0.b(Arrays.copyOfRange(this.f3022e, i7 - i5, i7));
        byte[] bArr = this.f3022e;
        System.arraycopy(bArr, i7, bArr, 0, i6);
        this.f3023f = i6;
        String str = this.d.f311i;
        Format format = this.c;
        if (!w.a(str, format.f311i)) {
            if ("application/x-emsg".equals(this.d.f311i)) {
                this.f3021a.getClass();
                EventMessage b = c1.a.b(bVar);
                Format a5 = b.a();
                String str2 = format.f311i;
                if (a5 != null && w.a(str2, a5.f311i)) {
                    byte[] b5 = b.b();
                    b5.getClass();
                    bVar = new c0.b(b5);
                } else {
                    Format a6 = b.a();
                    Log.w("EmsgUnwrappingTrackOutput", "Ignoring EMSG. Expected it to contain wrapped " + str2 + " but actual wrapped format: " + a6);
                    return;
                }
            } else {
                Log.w("EmsgUnwrappingTrackOutput", "Ignoring sample for unsupported format: " + this.d.f311i);
                return;
            }
        }
        int a7 = bVar.a();
        this.b.b(a7, bVar);
        this.b.c(j2, i3, a7, i6, tVar);
    }

    @Override // p0.u
    public final void d(Format format) {
        this.d = format;
        this.b.d(this.c);
    }
}
