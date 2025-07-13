package t2;

import android.graphics.Bitmap;
import android.util.Log;
import com.lg.picturesubmitt.YuvUtil;
import com.lg.picturesubmitt.activity.MainActivityNew;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3719a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ MainActivityNew c;

    public /* synthetic */ w(MainActivityNew mainActivityNew, Bitmap bitmap, int i3) {
        this.f3719a = i3;
        this.c = mainActivityNew;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3719a) {
            case 0:
                MainActivityNew mainActivityNew = this.c;
                try {
                    String str = System.currentTimeMillis() + ".jpg";
                    String str2 = mainActivityNew.b.b + File.separator + str;
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Log.d("MainActivityNew", "拍照成功");
                    j4.b.w(mainActivityNew, false, str2, str);
                    return;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return;
                }
            case 1:
                MainActivityNew mainActivityNew2 = this.c;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(mainActivityNew2.f699j0);
                        this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        Log.d("MainActivityNew", "视频缩略图");
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return;
                } finally {
                    mainActivityNew2.f699j0 = null;
                }
            default:
                MainActivityNew mainActivityNew3 = this.c;
                Bitmap bitmap = this.b;
                if (mainActivityNew3.f712n1) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, mainActivityNew3.f686e1, mainActivityNew3.f689f1, false);
                }
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(allocate);
                byte[] array = allocate.array();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                byte[] bArr = new byte[((width * height) * 3) / 2];
                mainActivityNew3.B1 = bArr;
                YuvUtil.argbToI420(array, width, height, bArr);
                if (mainActivityNew3.f691g0) {
                    mainActivityNew3.d.a(mainActivityNew3.B1);
                    return;
                }
                return;
        }
    }
}
