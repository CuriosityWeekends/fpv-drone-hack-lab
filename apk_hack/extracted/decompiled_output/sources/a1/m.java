package a1;

import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import i.g0;
import java.io.ByteArrayOutputStream;
import p.z;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements l, u.a {

    /* renamed from: a  reason: collision with root package name */
    public int f39a;
    public Object b;

    public m(int i3) {
        switch (i3) {
            case 4:
                this.b = new c0.b(8);
                return;
            case 5:
                this.b = Bitmap.CompressFormat.JPEG;
                this.f39a = 100;
                return;
            default:
                this.b = new long[32];
                return;
        }
    }

    @Override // a1.l
    public MediaCodecInfo a(int i3) {
        if (((MediaCodecInfo[]) this.b) == null) {
            this.b = new MediaCodecList(this.f39a).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.b)[i3];
    }

    @Override // u.a
    public g0 b(g0 g0Var, g.h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) g0Var.get()).compress((Bitmap.CompressFormat) this.b, this.f39a, byteArrayOutputStream);
        g0Var.recycle();
        return new z(byteArrayOutputStream.toByteArray());
    }

    @Override // a1.l
    public boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // a1.l
    public int d() {
        if (((MediaCodecInfo[]) this.b) == null) {
            this.b = new MediaCodecList(this.f39a).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.b).length;
    }

    @Override // a1.l
    public boolean e(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // a1.l
    public boolean f() {
        return true;
    }

    public long g(int i3) {
        if (i3 >= 0 && i3 < this.f39a) {
            return ((long[]) this.b)[i3];
        }
        StringBuilder m5 = i.m("Invalid index ", i3, ", size is ");
        m5.append(this.f39a);
        throw new IndexOutOfBoundsException(m5.toString());
    }

    public long h(p0.g gVar) {
        c0.b bVar = (c0.b) this.b;
        int i3 = 0;
        gVar.d(bVar.f187a, 0, 1, false);
        int i5 = bVar.f187a[0] & 255;
        if (i5 == 0) {
            return Long.MIN_VALUE;
        }
        int i6 = 128;
        int i7 = 0;
        while ((i5 & i6) == 0) {
            i6 >>= 1;
            i7++;
        }
        int i8 = i5 & (~i6);
        gVar.d(bVar.f187a, 1, i7, false);
        while (i3 < i7) {
            i3++;
            i8 = (bVar.f187a[i3] & 255) + (i8 << 8);
        }
        this.f39a = i7 + 1 + this.f39a;
        return i8;
    }
}
