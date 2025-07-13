package e;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f1666a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, int i3) {
        super(i3);
        this.f1666a = gVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 > 0 && ((ByteArrayOutputStream) this).buf[i3 - 1] == 13) {
            i3--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i3, this.f1666a.b.name());
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }
}
