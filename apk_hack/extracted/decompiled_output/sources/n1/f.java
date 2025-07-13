package n1;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f2928a;
    public final long[] b;
    public final String c;
    public final String d;

    public f(String str, String str2, long[] jArr, EventMessage[] eventMessageArr) {
        this.c = str;
        this.d = str2;
        this.b = jArr;
        this.f2928a = eventMessageArr;
    }

    public final String a() {
        return this.c + "/" + this.d;
    }
}
