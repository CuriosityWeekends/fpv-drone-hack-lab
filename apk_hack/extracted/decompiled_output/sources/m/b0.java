package m;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 implements r, g.b {
    public static final b0 b = new b0(0);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2730a;

    public /* synthetic */ b0(int i3) {
        this.f2730a = i3;
    }

    public static ByteArrayInputStream c(String str) {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                if (str.substring(0, indexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
    }

    public void a(Object obj) {
        switch (this.f2730a) {
            case 8:
                ((ParcelFileDescriptor) obj).close();
                return;
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    public Object b(byte[] bArr) {
        switch (this.f2730a) {
            case 1:
                return ByteBuffer.wrap(bArr);
            default:
                return new ByteArrayInputStream(bArr);
        }
    }

    public Class d() {
        switch (this.f2730a) {
            case 1:
                return ByteBuffer.class;
            case 3:
                return InputStream.class;
            case 8:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    public Object e(File file) {
        switch (this.f2730a) {
            case 8:
                return ParcelFileDescriptor.open(file, 268435456);
            default:
                return new FileInputStream(file);
        }
    }

    @Override // g.b
    public boolean k(Object obj, File file, g.h hVar) {
        try {
            c0.c.b((ByteBuffer) obj, file);
            return true;
        } catch (IOException e5) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e5);
            }
            return false;
        }
    }

    @Override // m.r
    public q n(y yVar) {
        switch (this.f2730a) {
            case 0:
                return c0.b;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
            default:
                return new f0(yVar.c(f.class, InputStream.class));
            case 2:
                return new c(0, new b0(1));
            case 4:
                return new c(0, new b0(3));
            case 6:
                return new c0(1);
            case 10:
                return new a0(yVar.c(Uri.class, AssetFileDescriptor.class), 0);
            case 11:
                return new a0(yVar.c(Uri.class, ParcelFileDescriptor.class), 0);
            case 12:
                return new a0(yVar.c(Uri.class, InputStream.class), 0);
        }
    }
}
