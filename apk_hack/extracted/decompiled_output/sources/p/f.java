package p;

import android.graphics.ImageDecoder;
import i.g0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements g.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3062a;
    public final a b;

    public f(int i3) {
        this.f3062a = i3;
        switch (i3) {
            case 1:
                this.b = new a();
                return;
            default:
                this.b = new a();
                return;
        }
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        a aVar = this.b;
        switch (this.f3062a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return aVar.c(createSource, i3, i5, hVar);
            default:
                InputStream inputStream = (InputStream) obj;
                AtomicReference atomicReference = c0.c.f188a;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
                AtomicReference atomicReference2 = c0.c.f188a;
                byte[] bArr = (byte[]) atomicReference2.getAndSet(null);
                if (bArr == null) {
                    bArr = new byte[16384];
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        atomicReference2.set(bArr);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        createSource2 = ImageDecoder.createSource((ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0));
                        return aVar.c(createSource2, i3, i5, hVar);
                    }
                }
        }
    }

    @Override // g.j
    public final /* bridge */ /* synthetic */ boolean b(Object obj, g.h hVar) {
        switch (this.f3062a) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                return true;
            default:
                InputStream inputStream = (InputStream) obj;
                return true;
        }
    }
}
