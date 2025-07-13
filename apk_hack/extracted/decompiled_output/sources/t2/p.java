package t2;

import android.graphics.Bitmap;
import android.util.Log;
import com.lg.picturesubmitt.YuvUtil;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3711a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ MainActivityDecode c;

    public /* synthetic */ p(MainActivityDecode mainActivityDecode, Bitmap bitmap, int i3) {
        this.f3711a = i3;
        this.c = mainActivityDecode;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3711a) {
            case 0:
                MainActivityDecode mainActivityDecode = this.c;
                try {
                    String str = System.currentTimeMillis() + ".jpg";
                    String str2 = mainActivityDecode.b.b + File.separator + str;
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Log.d("MainActivityDecode", "拍照成功");
                    j4.b.w(mainActivityDecode, false, str2, str);
                    return;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return;
                }
            case 1:
                MainActivityDecode mainActivityDecode2 = this.c;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(mainActivityDecode2.f634k0);
                        this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        Log.d("MainActivityDecode", "视频缩略图");
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return;
                } finally {
                    mainActivityDecode2.f634k0 = null;
                }
            default:
                MainActivityDecode mainActivityDecode3 = this.c;
                Bitmap bitmap = this.b;
                if (mainActivityDecode3.f647o1) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, mainActivityDecode3.f621f1, mainActivityDecode3.f624g1, false);
                }
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(allocate);
                byte[] array = allocate.array();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                byte[] bArr = new byte[((width * height) * 3) / 2];
                mainActivityDecode3.C1 = bArr;
                YuvUtil.argbToI420(array, width, height, bArr);
                if (mainActivityDecode3.f626h0) {
                    mainActivityDecode3.d.a(mainActivityDecode3.C1);
                    return;
                }
                return;
        }
    }
}
