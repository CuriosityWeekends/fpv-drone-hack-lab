package r1;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f3382a;
    public final long b;
    public final Format[] c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3383e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3384f;

    /* renamed from: g  reason: collision with root package name */
    public final List f3385g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f3386h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3387i;

    public b(String str, String str2, int i3, String str3, long j2, String str4, int i5, int i6, int i7, int i8, String str5, Format[] formatArr, List list, long[] jArr, long j5) {
        this.f3383e = str;
        this.f3384f = str2;
        this.f3382a = i3;
        this.b = j2;
        this.c = formatArr;
        this.f3385g = list;
        this.f3386h = jArr;
        this.f3387i = j5;
        this.d = list.size();
    }

    public final long a(int i3) {
        if (i3 == this.d - 1) {
            return this.f3387i;
        }
        long[] jArr = this.f3386h;
        return jArr[i3 + 1] - jArr[i3];
    }
}
