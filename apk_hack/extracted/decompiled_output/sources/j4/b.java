package j4;

import a1.i;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import e2.a0;
import g2.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import p0.g;
import p4.p;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {
    public static float c;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2483a;
    public final Object b;

    public /* synthetic */ b(int i3, Object obj) {
        this.f2483a = i3;
        this.b = obj;
    }

    public static void a(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        v(nullPointerException);
        throw nullPointerException;
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        v(nullPointerException);
        throw nullPointerException;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(h(str));
        v(nullPointerException);
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h(str));
        v(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void e(float f4, float f5, float f6) {
        if (f4 < f5) {
            if (f5 < f6) {
                return;
            }
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
        throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }

    public static void f(float f4, float f5, float f6) {
        if (f4 < f5) {
            if (f5 < f6) {
                return;
            }
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
        throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }

    public static int g(float f4, float f5) {
        int round = Math.round(f4 * 1000000.0f);
        int round2 = Math.round(f5 * 1000000.0f);
        if (round > round2) {
            return 1;
        }
        if (round < round2) {
            return -1;
        }
        return 0;
    }

    public static String h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static int i(Context context, float f4) {
        if (context != null && g(0.0f, f4) != 0) {
            return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static void j(Canvas canvas, Paint paint, Bitmap bitmap, Rect rect) {
        try {
            if (NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) {
                NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
                new NinePatch(bitmap, bitmap.getNinePatchChunk(), null).draw(canvas, rect);
                return;
            }
        } catch (Exception unused) {
        }
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public static Bitmap k(Context context, int i3, int i5, int i6) {
        if (context == null || i3 <= 0 || i5 <= 0 || i6 == 0) {
            return null;
        }
        return l(context.getResources().getDrawable(i6, null), i3, i5);
    }

    public static Bitmap l(Drawable drawable, int i3, int i5) {
        Bitmap bitmap;
        try {
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && bitmap.getHeight() > 0) {
                Matrix matrix = new Matrix();
                matrix.postScale((i3 * 1.0f) / bitmap.getWidth(), (i5 * 1.0f) / bitmap.getHeight());
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i5, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static float m(String str) {
        if (str != null && str.length() != 0) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    c = 0.0f;
                    return n(file);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return 0.0f;
    }

    public static float n(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    c += n(file2);
                }
                return c;
            }
            return (float) file.length();
        } catch (Exception e5) {
            e5.printStackTrace();
            return c;
        }
    }

    public static Rect o(String str, float f4) {
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize(f4);
        paint.getTextBounds(str, 0, str.length(), rect);
        paint.reset();
        return rect;
    }

    public static void p(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        try {
            try {
                Object newInstance = Class.forName(str).getDeclaredConstructor(null).newInstance(null);
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e5) {
                x(cls4, e5);
                throw null;
            } catch (InstantiationException e6) {
                x(cls3, e6);
                throw null;
            } catch (NoSuchMethodException e7) {
                x(cls2, e7);
                throw null;
            } catch (InvocationTargetException e8) {
                x(cls, e8);
                throw null;
            }
        } catch (ClassNotFoundException e9) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e9);
        }
    }

    public static z0.e q(g gVar) {
        long j2;
        boolean z3;
        byte[] bArr;
        c0.b bVar = new c0.b(16);
        if (a0.b(gVar, bVar).f1672a != 1380533830) {
            return null;
        }
        gVar.d(bVar.f187a, 0, 4, false);
        bVar.y(0);
        int c5 = bVar.c();
        if (c5 != 1463899717) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + c5);
            return null;
        }
        a0 b = a0.b(gVar, bVar);
        while (true) {
            int i3 = b.f1672a;
            j2 = b.b;
            if (i3 == 1718449184) {
                break;
            }
            gVar.a((int) j2, false);
            b = a0.b(gVar, bVar);
        }
        if (j2 >= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        gVar.d(bVar.f187a, 0, 16, false);
        bVar.y(0);
        int g5 = bVar.g();
        int g6 = bVar.g();
        int e5 = bVar.e();
        if (e5 >= 0) {
            int e6 = bVar.e();
            if (e6 >= 0) {
                int g7 = bVar.g();
                int g8 = bVar.g();
                int i5 = ((int) j2) - 16;
                if (i5 > 0) {
                    byte[] bArr2 = new byte[i5];
                    gVar.d(bArr2, 0, i5, false);
                    bArr = bArr2;
                } else {
                    bArr = w.f1962f;
                }
                return new z0.e(g5, g6, e5, g7, g8, bArr);
            }
            throw new IllegalStateException(i.e(e6, "Top bit not zero: "));
        }
        throw new IllegalStateException(i.e(e5, "Top bit not zero: "));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[LOOP:0: B:3:0x0001->B:14:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[EDGE_INSN: B:17:0x003a->B:15:0x003a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int r(p0.g r9, byte[] r10, int r11, int r12) {
        /*
            r0 = 0
        L1:
            if (r0 >= r12) goto L3a
            int r1 = r11 + r0
            int r6 = r12 - r0
            r9.b(r6)
            int r2 = r9.f3112g
            int r4 = r9.f3111f
            int r2 = r2 - r4
            r8 = -1
            if (r2 != 0) goto L25
            byte[] r3 = r9.f3110e
            r7 = 0
            r5 = 1
            r2 = r9
            int r2 = r2.f(r3, r4, r5, r6, r7)
            if (r2 != r8) goto L1f
            r2 = -1
            goto L35
        L1f:
            int r3 = r9.f3112g
            int r3 = r3 + r2
            r9.f3112g = r3
            goto L29
        L25:
            int r2 = java.lang.Math.min(r6, r2)
        L29:
            byte[] r3 = r9.f3110e
            int r4 = r9.f3111f
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)
            int r1 = r9.f3111f
            int r1 = r1 + r2
            r9.f3111f = r1
        L35:
            if (r2 != r8) goto L38
            goto L3a
        L38:
            int r0 = r0 + r2
            goto L1
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.b.r(p0.g, byte[], int, int):int");
    }

    public static void t(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    t(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static void u(String str) {
        if (str != null && str.length() != 0) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    t(file);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void v(RuntimeException runtimeException) {
        String name = b.class.getName();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            if (name.equals(stackTrace[i5].getClassName())) {
                i3 = i5;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
    }

    public static void w(Context context, boolean z3, String str, String str2) {
        File file;
        Uri insert;
        Uri contentUri;
        String str3 = Environment.DIRECTORY_DCIM + "/" + context.getString(2131755057);
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        int i3 = Build.VERSION.SDK_INT;
        String str4 = "image/jpeg";
        if (i3 >= 29) {
            contentValues.put("relative_path", str3);
            contentValues.put("title", str2);
            contentValues.put("_display_name", str2);
            if (z3) {
                str4 = "video/mp4";
            }
            contentValues.put("mime_type", str4);
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            if (z3) {
                contentUri = MediaStore.Video.Media.getContentUri("external_primary");
            } else {
                contentUri = MediaStore.Images.Media.getContentUri("external_primary");
            }
            insert = contentResolver.insert(contentUri, contentValues);
            file = null;
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File file2 = new File(externalStoragePublicDirectory.getAbsolutePath() + "/" + context.getString(2131755057));
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(file2, str2);
            contentValues.put("title", str2);
            contentValues.put("_display_name", str2);
            if (z3) {
                str4 = "video/mp4";
            }
            contentValues.put("mime_type", str4);
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("_data", file.getAbsolutePath());
            if (z3) {
                insert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            } else {
                insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
        }
        if (i3 >= 29) {
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("is_pending", (Integer) 1);
        }
        try {
            if (z3) {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(insert, "w");
                FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                FileInputStream fileInputStream = new FileInputStream(new File(str));
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                fileInputStream.close();
                openFileDescriptor.close();
            } else {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                Bitmap decodeFile = BitmapFactory.decodeFile(str, new BitmapFactory.Options());
                decodeFile.compress(Bitmap.CompressFormat.JPEG, 90, openOutputStream);
                decodeFile.recycle();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            context.getContentResolver().update(insert, contentValues, null, null);
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static void x(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static boolean y(h4.b bVar, h4.c cVar, k4.b bVar2) {
        if (bVar instanceof k4.c) {
            try {
                Object obj = ((k4.c) bVar).get();
                i4.a aVar = l4.b.f2726a;
                if (obj == null) {
                    cVar.a(aVar);
                    cVar.onComplete();
                    return true;
                }
                try {
                    Object apply = bVar2.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    h4.b bVar3 = (h4.b) apply;
                    if (bVar3 instanceof k4.c) {
                        try {
                            Object obj2 = ((k4.c) bVar3).get();
                            if (obj2 == null) {
                                cVar.a(aVar);
                                cVar.onComplete();
                                return true;
                            }
                            p pVar = new p(cVar, obj2);
                            cVar.a(pVar);
                            pVar.run();
                        } catch (Throwable th) {
                            com.bumptech.glide.c.l(th);
                            l4.b.c(th, cVar);
                            return true;
                        }
                    } else {
                        bVar3.g(cVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    com.bumptech.glide.c.l(th2);
                    l4.b.c(th2, cVar);
                    return true;
                }
            } catch (Throwable th3) {
                com.bumptech.glide.c.l(th3);
                l4.b.c(th3, cVar);
                return true;
            }
        }
        return false;
    }

    public final void s(String str) {
        switch (this.f2483a) {
            case 0:
                ((PrintStream) this.b).println((Object) str);
                return;
            default:
                ((PrintWriter) this.b).println((Object) str);
                return;
        }
    }
}
