package t2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;
import com.lg.picturesubmitt.activity.MainActivity;
import com.lg.picturesubmitt.widget.battery.BatteryView;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3697a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ MainActivity c;

    public /* synthetic */ i(MainActivity mainActivity, byte[] bArr, int i3) {
        this.f3697a = i3;
        this.c = mainActivity;
        this.b = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolder surfaceHolder;
        String str;
        ?? bufferedOutputStream;
        switch (this.f3697a) {
            case 0:
                byte[] bArr = this.b;
                byte b = bArr[2];
                byte b5 = bArr[1];
                byte b6 = bArr[0];
                int m5 = this.c.m(Arrays.copyOfRange(bArr, 4, 6));
                if (b == 1) {
                    MainActivity mainActivity = this.c;
                    mainActivity.F0 = false;
                    int m6 = mainActivity.m(Arrays.copyOfRange(this.b, 6, 8));
                    try {
                        this.c.f567c0.write(this.b, 8, m5);
                    } catch (IndexOutOfBoundsException e5) {
                        this.c.m(Arrays.copyOfRange(this.b, 4, 6));
                        e5.printStackTrace();
                        StringBuilder sb = new StringBuilder("IndexOutOfBoundsException-->");
                        sb.append((int) Arrays.copyOfRange(this.b, 4, 6)[0]);
                        sb.append("-->");
                        a1.i.u(sb, Arrays.copyOfRange(this.b, 4, 6)[1], "MainActivity");
                    }
                    MainActivity mainActivity2 = this.c;
                    byte[] byteArray = mainActivity2.f567c0.toByteArray();
                    mainActivity2.getClass();
                    if (byteArray.length > 0 && m6 != 0) {
                        byte b7 = byteArray[0];
                        byte b8 = byteArray[1];
                        byte b9 = byteArray[byteArray.length - 2];
                        byte b10 = byteArray[byteArray.length - 1];
                        if (m6 == byteArray.length) {
                            byte[] bArr2 = mainActivity2.P;
                            if (b7 == bArr2[0] && b8 == bArr2[1]) {
                                byte[] bArr3 = mainActivity2.Q;
                                if (b9 == bArr3[0] && b10 == bArr3[1]) {
                                    if (mainActivity2.Z && mainActivity2.f566b0 != null) {
                                        mainActivity2.Z = false;
                                        mainActivity2.f570e0.execute(new i(mainActivity2, byteArray, 2));
                                    }
                                    if (mainActivity2.X && mainActivity2.f566b0 != null) {
                                        mainActivity2.f572f0.execute(new i(mainActivity2, byteArray, 3));
                                    }
                                    if (mainActivity2.V) {
                                        mainActivity2.V = false;
                                        mainActivity2.f570e0.execute(new i(mainActivity2, byteArray, 4));
                                    }
                                    mainActivity2.J = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArray));
                                    if (mainActivity2.S) {
                                        Matrix matrix = new Matrix();
                                        matrix.postRotate(180.0f, mainActivity2.J.getWidth(), mainActivity2.J.getHeight());
                                        Bitmap bitmap = mainActivity2.J;
                                        mainActivity2.J = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), mainActivity2.J.getHeight(), matrix, true);
                                    }
                                    Bitmap bitmap2 = mainActivity2.J;
                                    if (bitmap2 != null) {
                                        bitmap2.getWidth();
                                        mainActivity2.J.getHeight();
                                        if (mainActivity2.T && mainActivity2.J != null && (surfaceHolder = mainActivity2.R) != null) {
                                            try {
                                                mainActivity2.D0 = surfaceHolder.lockCanvas();
                                                synchronized (mainActivity2.R) {
                                                    if (mainActivity2.Y) {
                                                        mainActivity2.D0.drawBitmap(mainActivity2.J, (Rect) null, new Rect(0, 0, mainActivity2.N / 2, mainActivity2.O), mainActivity2.E0);
                                                        Canvas canvas = mainActivity2.D0;
                                                        Bitmap bitmap3 = mainActivity2.J;
                                                        int i3 = mainActivity2.N;
                                                        canvas.drawBitmap(bitmap3, (Rect) null, new Rect(i3 / 2, 0, i3, mainActivity2.O), mainActivity2.E0);
                                                    } else {
                                                        mainActivity2.D0.drawBitmap(mainActivity2.J, (Rect) null, new Rect(0, 0, mainActivity2.N, mainActivity2.O), mainActivity2.E0);
                                                    }
                                                }
                                            } finally {
                                                Canvas canvas2 = mainActivity2.D0;
                                                if (canvas2 != null) {
                                                    mainActivity2.R.unlockCanvasAndPost(canvas2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.c.f567c0 = new ByteArrayOutputStream();
                    return;
                } else if (b == 2) {
                    MainActivity mainActivity3 = this.c;
                    mainActivity3.F0 = true;
                    mainActivity3.f567c0 = new ByteArrayOutputStream();
                    this.c.f567c0.write(this.b, 8, m5);
                    return;
                } else {
                    MainActivity mainActivity4 = this.c;
                    if (mainActivity4.F0) {
                        mainActivity4.f567c0.write(this.b, 8, m5);
                        return;
                    }
                    return;
                }
            case 1:
                StringBuilder sb2 = new StringBuilder("电量");
                byte[] bArr4 = this.b;
                a1.i.u(sb2, bArr4[1], "MainActivity");
                byte b11 = bArr4[1];
                MainActivity mainActivity5 = this.c;
                mainActivity5.I0 = b11;
                mainActivity5.A0.setLevelHeight(b11);
                if (mainActivity5.I0 == 100) {
                    mainActivity5.I0 = 0;
                }
                int i5 = mainActivity5.I0;
                if (i5 < 10) {
                    BatteryView batteryView = mainActivity5.A0;
                    batteryView.f1010l.setColor(batteryView.q);
                    batteryView.f1013o.setColor(batteryView.q);
                    batteryView.postInvalidate();
                } else if (i5 < 50) {
                    BatteryView batteryView2 = mainActivity5.A0;
                    batteryView2.f1010l.setColor(batteryView2.s);
                    batteryView2.f1013o.setColor(batteryView2.s);
                    batteryView2.postInvalidate();
                } else {
                    BatteryView batteryView3 = mainActivity5.A0;
                    batteryView3.f1010l.setColor(batteryView3.f1015r);
                    batteryView3.f1013o.setColor(batteryView3.f1015r);
                    batteryView3.postInvalidate();
                }
                mainActivity5.A0.setVisibility(0);
                byte b12 = bArr4[3];
                if ((b12 & 1) == 1 && !mainActivity5.f607y0) {
                    Log.d("MainActivity", "触发拍照");
                    mainActivity5.f597t.performClick();
                    mainActivity5.f607y0 = true;
                } else if ((b12 & 1) == 0 && mainActivity5.f607y0) {
                    mainActivity5.f607y0 = false;
                }
                byte b13 = bArr4[3];
                if ((b13 & 2) == 2 && !mainActivity5.f609z0) {
                    Log.d("MainActivity", "触发录像");
                    mainActivity5.A.performClick();
                    mainActivity5.f609z0 = true;
                } else if ((b13 & 2) == 0 && mainActivity5.f609z0) {
                    mainActivity5.f609z0 = false;
                }
                if ((bArr4[3] & 8) == 8) {
                    mainActivity5.f591p.setVisibility(0);
                } else {
                    mainActivity5.f591p.setVisibility(8);
                }
                if ((bArr4[4] & 32) == 32) {
                    mainActivity5.q.setVisibility(0);
                } else {
                    mainActivity5.q.setVisibility(8);
                }
                if ((bArr4[4] & 64) == 64) {
                    mainActivity5.f594r.setVisibility(0);
                    return;
                } else {
                    mainActivity5.f594r.setVisibility(8);
                    return;
                }
            case 2:
                MainActivity mainActivity6 = this.c;
                PrintStream printStream = null;
                try {
                    try {
                        try {
                            str = mainActivity6.b.d + File.separator + mainActivity6.f566b0.replace(".mp4", ".jpg");
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e6) {
                        e = e6;
                    }
                    try {
                        bufferedOutputStream.write(this.b);
                        printStream = System.out;
                        printStream.println("缩列图成功" + str);
                        bufferedOutputStream.close();
                    } catch (IOException e7) {
                        e = e7;
                        printStream = bufferedOutputStream;
                        e.printStackTrace();
                        if (printStream != null) {
                            printStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        printStream = bufferedOutputStream;
                        if (printStream != null) {
                            try {
                                printStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    return;
                } catch (IOException e9) {
                    e9.printStackTrace();
                    return;
                }
            case 3:
                PrintStream printStream2 = System.out;
                StringBuilder sb3 = new StringBuilder("RecorderCashDir");
                MainActivity mainActivity7 = this.c;
                sb3.append(mainActivity7.b.c);
                sb3.append("--RecordingName");
                sb3.append(mainActivity7.f566b0);
                printStream2.println(sb3.toString());
                File file = new File(mainActivity7.b.c, mainActivity7.f566b0);
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(file.length());
                    randomAccessFile.write(this.b);
                    randomAccessFile.close();
                    printStream2.println("录像成功");
                    return;
                } catch (FileNotFoundException e10) {
                    e10.printStackTrace();
                    return;
                } catch (IOException e11) {
                    e11.printStackTrace();
                    return;
                }
            default:
                MainActivity mainActivity8 = this.c;
                try {
                    mainActivity8.K = MainActivity.l(mainActivity8, BitmapFactory.decodeStream(new ByteArrayInputStream(this.b)));
                    String str2 = mainActivity8.b.b + File.separator + (System.currentTimeMillis() + ".jpg");
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    mainActivity8.K.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    System.out.println("拍照成功");
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(str2)));
                    mainActivity8.sendBroadcast(intent);
                    return;
                } catch (IOException e12) {
                    e12.printStackTrace();
                    return;
                }
        }
    }
}
