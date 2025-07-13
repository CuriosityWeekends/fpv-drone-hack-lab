package t2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.lg.picturesubmitt.MyApplication;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d0 implements g3.a, v.j, w0.g {
    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static c1.b e(Context context, String[] strArr, String str, i.b bVar) {
        String[] strArr2;
        int i3;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        if (strArr3 != null && strArr3.length != 0) {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        } else {
            strArr2 = new String[]{applicationInfo.sourceDir};
        }
        ZipFile zipFile = null;
        for (String str2 : strArr2) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                i3 = 5;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i5 = i6;
                }
            }
            if (zipFile != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < i3) {
                        int length = strArr.length;
                        int i9 = 0;
                        while (i9 < length) {
                            String str3 = strArr[i9];
                            StringBuilder sb = new StringBuilder("lib");
                            char c = File.separatorChar;
                            sb.append(c);
                            sb.append(str3);
                            sb.append(c);
                            sb.append(str);
                            String sb2 = sb.toString();
                            bVar.getClass();
                            i.b.l("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                c1.b bVar2 = new c1.b(27, false);
                                bVar2.b = zipFile;
                                bVar2.c = entry;
                                return bVar2;
                            }
                            i9++;
                            i3 = 5;
                        }
                        i7 = i8;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // w0.g
    public long a(p0.g gVar) {
        return -1L;
    }

    @Override // w0.g
    public p0.r b() {
        return new p0.n(-9223372036854775807L);
    }

    @Override // g3.a
    public void i() {
        MyApplication.f541h = true;
    }

    @Override // w0.g
    public void c(long j2) {
    }
}
