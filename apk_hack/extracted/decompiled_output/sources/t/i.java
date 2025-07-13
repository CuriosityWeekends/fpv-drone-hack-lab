package t;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import g.j;
import i.g0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements j {

    /* renamed from: a  reason: collision with root package name */
    public final List f3571a;
    public final j b;
    public final j.g c;

    public i(ArrayList arrayList, a aVar, j.g gVar) {
        this.f3571a = arrayList;
        this.b = aVar;
        this.c = gVar;
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e5);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(bArr), i3, i5, hVar);
    }

    @Override // g.j
    public final boolean b(Object obj, g.h hVar) {
        InputStream inputStream = (InputStream) obj;
        if (!((Boolean) hVar.c(h.b)).booleanValue()) {
            if (com.bumptech.glide.c.f(this.c, inputStream, this.f3571a) == ImageHeaderParser$ImageType.GIF) {
                return true;
            }
        }
        return false;
    }
}
