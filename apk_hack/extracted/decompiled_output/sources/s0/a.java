package s0;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import g2.n;
import java.io.IOException;
import java.util.Collections;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends j.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f3459e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public final boolean D(c0.b bVar) {
        String str;
        if (!this.b) {
            int n5 = bVar.n();
            int i3 = (n5 >> 4) & 15;
            this.d = i3;
            u uVar = (u) this.f2183a;
            if (i3 == 2) {
                uVar.d(Format.k(null, "audio/mpeg", -1, -1, 1, f3459e[(n5 >> 2) & 3], -1, null, null, 0, null));
                this.c = true;
            } else if (i3 != 7 && i3 != 8) {
                if (i3 != 10) {
                    throw new IOException("Audio format not supported: " + this.d);
                }
            } else {
                if (i3 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                uVar.d(Format.k(null, str, -1, -1, 1, 8000, -1, null, null, 0, null));
                this.c = true;
            }
            this.b = true;
        } else {
            bVar.z(1);
        }
        return true;
    }

    public final boolean E(c0.b bVar, long j2) {
        int i3 = this.d;
        u uVar = (u) this.f2183a;
        if (i3 == 2) {
            int a5 = bVar.a();
            uVar.b(a5, bVar);
            ((u) this.f2183a).c(j2, 1, a5, 0, null);
            return true;
        }
        int n5 = bVar.n();
        if (n5 == 0 && !this.c) {
            int a6 = bVar.a();
            byte[] bArr = new byte[a6];
            bVar.b(bArr, 0, a6);
            Pair u5 = g2.b.u(new n(bArr, a6), false);
            uVar.d(Format.k(null, "audio/mp4a-latm", -1, -1, ((Integer) u5.second).intValue(), ((Integer) u5.first).intValue(), -1, Collections.singletonList(bArr), null, 0, null));
            this.c = true;
            return false;
        } else if (this.d == 10 && n5 != 1) {
            return false;
        } else {
            int a7 = bVar.a();
            uVar.b(a7, bVar);
            ((u) this.f2183a).c(j2, 1, a7, 0, null);
            return true;
        }
    }
}
