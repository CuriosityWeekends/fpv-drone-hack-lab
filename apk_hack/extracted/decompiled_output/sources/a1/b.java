package a1;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final String f6a;
    public final boolean b;
    public final a c;
    public final String d;

    public b(Format format, k kVar, boolean z3, int i3) {
        this("Decoder init failed: [" + i3 + "], " + format, kVar, format.f311i, z3, null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i3 < 0 ? "neg_" : "") + Math.abs(i3));
    }

    public b(String str, Throwable th, String str2, boolean z3, a aVar, String str3) {
        super(str, th);
        this.f6a = str2;
        this.b = z3;
        this.c = aVar;
        this.d = str3;
    }
}
