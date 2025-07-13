package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class am {
    public static boolean a(File file, String str, long j2, boolean z3) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z3));
            boolean a5 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j2);
            bufferedWriter.close();
            return a5;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static List<File> b(String str, String str2, String str3, long j2) {
        ArrayList arrayList = new ArrayList();
        if (str2 != null && str3 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles(new f0(str2, str3));
                    if (listFiles != null && listFiles.length != 0) {
                        return a(listFiles, str2, str3, currentTimeMillis - j2);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    al.a(th);
                    return arrayList;
                }
            }
            return arrayList;
        }
        al.d("prefix %s and/or postfix %s is null.", str2, str3);
        return arrayList;
    }

    private static boolean a(Writer writer, char[] cArr, int i3, long j2, long j5) {
        if (j2 >= j5) {
            return false;
        }
        try {
            if ((i3 * 2) + j2 <= j5) {
                writer.write(cArr, 0, i3);
            } else {
                writer.write(cArr, 0, (int) ((j5 - j2) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e5) {
            al.a(e5);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, long j2) {
        try {
            int i3 = 0;
            for (File file : b(str, str2, str3, j2)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i3++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i3)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a5 = a(file.getName(), str, str2);
            if (a5 >= 0 && 0 <= a5 && a5 <= j2) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1L;
    }

    public static boolean a(String str, String str2, int i3) {
        boolean z3 = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j2 = i3;
                if (file.length() >= j2) {
                    z3 = false;
                }
                return a(file, str2, j2, z3);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
