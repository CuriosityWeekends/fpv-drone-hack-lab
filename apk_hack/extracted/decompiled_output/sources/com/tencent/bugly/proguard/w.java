package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1542a = false;
    private static w b;
    private static x c;

    private w(Context context, List<o> list) {
        c = new x(context, list);
    }

    private synchronized boolean b(y yVar) {
        ContentValues d;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null && (d = d(yVar)) != null) {
            long replace = writableDatabase.replace("t_pf", "_id", d);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_pf");
                yVar.f1544a = replace;
                if (f1542a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f1542a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f1542a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = yVar.f1544a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.c);
            contentValues.put("_th", yVar.d);
            contentValues.put("_tm", Long.valueOf(yVar.f1545e));
            byte[] bArr = yVar.f1547g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.b(yVar.f1546f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j2 = yVar.f1544a;
                if (j2 > 0) {
                    contentValues.put("_id", Long.valueOf(j2));
                }
                contentValues.put("_tp", yVar.f1546f);
                contentValues.put("_tm", Long.valueOf(yVar.f1545e));
                byte[] bArr = yVar.f1547g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w(context, list);
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = b;
        }
        return wVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ae, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
        if (r2 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    public final synchronized long a(String str, ContentValues contentValues, v vVar) {
        long j2;
        j2 = -1;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, "_id", contentValues);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", str);
            } else {
                al.d("[Database] replace %s error.", str);
            }
            j2 = replace;
        }
        if (f1542a && writableDatabase != null) {
            writableDatabase.close();
        }
        return j2;
    }

    public final synchronized void b(int i3) {
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null) {
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", i3 >= 0 ? "_tp = ".concat(String.valueOf(i3)) : null, null)));
            if (f1542a) {
                writableDatabase.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z3, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z3, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, v vVar) {
        int delete;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        delete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        if (f1542a && writableDatabase != null) {
            writableDatabase.close();
        }
        return delete;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f1544a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f1545e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f1546f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.f1547g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i3, String str, byte[] bArr, boolean z3) {
        if (!z3) {
            v0 v0Var = new v0(this);
            v0Var.b = i3;
            v0Var.c = str;
            v0Var.d = bArr;
            ak.a().a(v0Var);
            return true;
        }
        return a(i3, str, bArr, (v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i3, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.f1544a = i3;
            yVar.f1546f = str;
            yVar.f1545e = System.currentTimeMillis();
            yVar.f1547g = bArr;
            return b(yVar);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final Map<String, byte[]> a(int i3, v vVar) {
        HashMap hashMap = null;
        try {
            List<y> c5 = c(i3);
            if (c5 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (y yVar : c5) {
                        byte[] bArr = yVar.f1547g;
                        if (bArr != null) {
                            hashMap2.put(yVar.f1546f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (al.a(th)) {
                        return hashMap;
                    }
                    th.printStackTrace();
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(y yVar) {
        ContentValues c5;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null && (c5 = c(yVar)) != null) {
            long replace = writableDatabase.replace("t_lr", "_id", c5);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_lr");
                yVar.f1544a = replace;
                if (f1542a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f1542a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f1542a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2 A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #4 {all -> 0x0032, blocks: (B:4:0x0002, B:15:0x002e, B:18:0x0035, B:20:0x0039, B:38:0x00a0, B:40:0x00a7, B:50:0x00ba, B:51:0x00bd, B:53:0x00c1, B:43:0x00ac, B:45:0x00b2), top: B:68:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #4 {all -> 0x0032, blocks: (B:4:0x0002, B:15:0x002e, B:18:0x0035, B:20:0x0039, B:38:0x00a0, B:40:0x00a7, B:50:0x00ba, B:51:0x00bd, B:53:0x00c1, B:43:0x00ac, B:45:0x00b2), top: B:68:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1 A[Catch: all -> 0x0032, TryCatch #4 {all -> 0x0032, blocks: (B:4:0x0002, B:15:0x002e, B:18:0x0035, B:20:0x0039, B:38:0x00a0, B:40:0x00a7, B:50:0x00ba, B:51:0x00bd, B:53:0x00c1, B:43:0x00ac, B:45:0x00b2), top: B:68:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r13) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    public final synchronized void a(List<y> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = c.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        for (y yVar : list) {
                            sb.append(" or _id = ");
                            sb.append(yVar.f1544a);
                        }
                        String sb2 = sb.toString();
                        if (sb2.length() > 0) {
                            sb2 = sb2.substring(4);
                        }
                        sb.setLength(0);
                        al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                        if (f1542a) {
                            writableDatabase.close();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f1544a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.f1545e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f1547g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i3, String str, v vVar) {
        String str2;
        boolean z3 = false;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = c.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        if (ap.b(str)) {
                            str2 = "_id = ".concat(String.valueOf(i3));
                        } else {
                            str2 = "_id = " + i3 + " and _tp = \"" + str + "\"";
                        }
                        int delete = writableDatabase.delete("t_pf", str2, null);
                        al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                        z3 = delete > 0;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = writableDatabase;
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (f1542a && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return z3;
                    }
                }
                if (f1542a && writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z3;
    }
}
