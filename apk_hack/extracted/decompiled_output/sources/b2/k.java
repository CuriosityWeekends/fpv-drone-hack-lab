package b2;

import com.google.android.exoplayer2.source.TrackGroupArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f160a;
    public final int b;
    public final int[] c;
    public final TrackGroupArray[] d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f161e;

    /* renamed from: f  reason: collision with root package name */
    public final int[][][] f162f;

    /* renamed from: g  reason: collision with root package name */
    public final TrackGroupArray f163g;

    public k(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
        this.c = iArr;
        this.d = trackGroupArrayArr;
        this.f162f = iArr3;
        this.f161e = iArr2;
        this.f163g = trackGroupArray;
        int length = iArr.length;
        this.b = length;
        this.f160a = length;
    }
}
