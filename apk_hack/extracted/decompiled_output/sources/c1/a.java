package c1;

import b1.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements b1.b {
    public static EventMessage b(c0.b bVar) {
        String i3 = bVar.i();
        i3.getClass();
        String i5 = bVar.i();
        i5.getClass();
        return new EventMessage(i3, i5, bVar.o(), bVar.o(), Arrays.copyOfRange(bVar.f187a, bVar.b, bVar.c));
    }

    @Override // b1.b
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        byteBuffer.getClass();
        return new Metadata(b(new c0.b(byteBuffer.array(), byteBuffer.limit())));
    }
}
