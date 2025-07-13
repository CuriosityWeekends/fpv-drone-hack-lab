package w0;

import com.google.android.exoplayer2.Format;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends i {

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f3920o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: n  reason: collision with root package name */
    public boolean f3921n;

    public static void e(ArrayList arrayList, int i3) {
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i3 * 1000000000) / 48000).array());
    }

    @Override // w0.i
    public final long b(c0.b bVar) {
        int i3;
        int i5;
        byte[] bArr = bVar.f187a;
        byte b = bArr[0];
        int i6 = b & 255;
        int i7 = b & 3;
        if (i7 != 0) {
            i3 = 2;
            if (i7 != 1 && i7 != 2) {
                i3 = bArr[1] & 63;
            }
        } else {
            i3 = 1;
        }
        int i8 = i6 >> 3;
        int i9 = i8 & 3;
        if (i8 >= 16) {
            i5 = 2500 << i9;
        } else if (i8 >= 12) {
            i5 = 10000 << (i8 & 1);
        } else if (i9 == 3) {
            i5 = 60000;
        } else {
            i5 = 10000 << i9;
        }
        return (this.f3927i * (i3 * i5)) / 1000000;
    }

    @Override // w0.i
    public final boolean c(c0.b bVar, long j2, c1.b bVar2) {
        boolean z3 = true;
        if (!this.f3921n) {
            byte[] copyOf = Arrays.copyOf(bVar.f187a, bVar.c);
            int i3 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            e(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            e(arrayList, 3840);
            bVar2.b = Format.k(null, "audio/opus", -1, -1, i3, 48000, -1, arrayList, null, 0, null);
            this.f3921n = true;
            return true;
        }
        if (bVar.c() != 1332770163) {
            z3 = false;
        }
        bVar.y(0);
        return z3;
    }

    @Override // w0.i
    public final void d(boolean z3) {
        super.d(z3);
        if (z3) {
            this.f3921n = false;
        }
    }
}
