package n1;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends l {

    /* renamed from: f  reason: collision with root package name */
    public final String f2934f;

    /* renamed from: g  reason: collision with root package name */
    public final i f2935g;

    /* renamed from: h  reason: collision with root package name */
    public final b3.e f2936h;

    public k(Format format, String str, q qVar, ArrayList arrayList) {
        super(format, str, qVar, arrayList);
        i iVar;
        Uri.parse(str);
        long j2 = qVar.f2946e;
        if (j2 <= 0) {
            iVar = null;
        } else {
            iVar = new i(qVar.d, j2, null);
        }
        this.f2935g = iVar;
        this.f2934f = null;
        this.f2936h = iVar == null ? new b3.e(22, new i(0L, -1L, null)) : null;
    }

    @Override // n1.l
    public final String b() {
        return this.f2934f;
    }

    @Override // n1.l
    public final m1.i d() {
        return this.f2936h;
    }

    @Override // n1.l
    public final i f() {
        return this.f2935g;
    }
}
