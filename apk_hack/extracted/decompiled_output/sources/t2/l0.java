package t2;

import android.graphics.Bitmap;
import android.util.Log;
import com.lg.picturesubmitt.YuvUtil;
import com.lg.picturesubmitt.activity.TrinityActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3704a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ TrinityActivity c;

    public /* synthetic */ l0(TrinityActivity trinityActivity, Bitmap bitmap, int i3) {
        this.f3704a = i3;
        this.c = trinityActivity;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3704a) {
            case 0:
                TrinityActivity trinityActivity = this.c;
                try {
                    String str = System.currentTimeMillis() + ".jpg";
                    String str2 = trinityActivity.b.b + File.separator + str;
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Log.d("TrinityActivity", "拍照成功");
                    j4.b.w(trinityActivity, false, str2, str);
                    return;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return;
                }
            case 1:
                TrinityActivity trinityActivity2 = this.c;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(trinityActivity2.f827f0);
                        this.b.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        Log.d("TrinityActivity", "视频缩略图");
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return;
                } finally {
                    trinityActivity2.f827f0 = null;
                }
            default:
                TrinityActivity trinityActivity3 = this.c;
                boolean z3 = trinityActivity3.U0;
                Bitmap bitmap = this.b;
                if (z3) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, trinityActivity3.R0, trinityActivity3.S0, false);
                }
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(allocate);
                byte[] array = allocate.array();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                byte[] bArr = new byte[((width * height) * 3) / 2];
                trinityActivity3.f845l1 = bArr;
                YuvUtil.argbToI420(array, width, height, bArr);
                trinityActivity3.c.recieveYUVData(trinityActivity3.f845l1);
                return;
        }
    }
}
