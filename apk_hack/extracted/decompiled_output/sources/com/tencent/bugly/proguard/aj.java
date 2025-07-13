package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int f1281a;
    protected long b;
    protected long c;
    private int d;

    /* renamed from: e  reason: collision with root package name */
    private int f1282e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1283f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1284g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f1285h;

    /* renamed from: i  reason: collision with root package name */
    private final aa f1286i;

    /* renamed from: j  reason: collision with root package name */
    private final ac f1287j;

    /* renamed from: k  reason: collision with root package name */
    private final af f1288k;

    /* renamed from: l  reason: collision with root package name */
    private final ai f1289l;

    /* renamed from: m  reason: collision with root package name */
    private final int f1290m;

    /* renamed from: n  reason: collision with root package name */
    private final ah f1291n;

    /* renamed from: o  reason: collision with root package name */
    private final ah f1292o;

    /* renamed from: p  reason: collision with root package name */
    private String f1293p;
    private final String q;

    /* renamed from: r  reason: collision with root package name */
    private final Map<String, String> f1294r;
    private boolean s;

    public aj(Context context, int i3, int i5, byte[] bArr, String str, String str2, ah ahVar, boolean z3) {
        this(context, i3, i5, bArr, str, str2, ahVar, 2, 30000, z3);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j2) {
        this.c += j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ac acVar;
        int length;
        Pair pair;
        boolean z3;
        try {
            this.f1281a = 0;
            this.b = 0L;
            this.c = 0L;
            if (ab.c(this.f1283f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f1285h;
                if (bArr != null && bArr.length != 0) {
                    if (this.f1283f != null && this.f1286i != null && (acVar = this.f1287j) != null && this.f1288k != null) {
                        if (acVar.c() == null) {
                            str = "illegal local strategy";
                        } else {
                            str = null;
                        }
                    }
                    str = "illegal access error";
                }
                str = "request package is empty!";
            }
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] a5 = ap.a(this.f1285h);
            if (a5 == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap hashMap = new HashMap(10);
            hashMap.put("tls", "1");
            hashMap.put("prodId", this.f1286i.e());
            hashMap.put("bundleId", this.f1286i.c);
            hashMap.put("appVer", this.f1286i.f1247o);
            Map<String, String> map = this.f1294r;
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("cmd", Integer.toString(this.f1284g));
            hashMap.put("platformId", Byte.toString((byte) 1));
            hashMap.put("sdkVer", this.f1286i.f1240h);
            hashMap.put("strategylastUpdateTime", Long.toString(this.f1287j.c().f1193o));
            this.f1289l.a(this.f1290m, System.currentTimeMillis());
            String str2 = this.f1293p;
            this.f1287j.c();
            int i3 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i3 + 1;
                if (i3 < this.d) {
                    if (i6 > 1) {
                        al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                        ap.b(this.f1282e);
                        if (i6 == this.d) {
                            al.d("[Upload] Use the back-up url at the last time: %s", this.q);
                            str2 = this.q;
                        }
                    }
                    al.c("[Upload] Send %d bytes", Integer.valueOf(a5.length));
                    str2 = b(str2);
                    al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str2, Integer.valueOf(this.f1284g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a6 = this.f1288k.a(str2, a5, this, hashMap);
                    Map<String, String> map2 = this.f1288k.c;
                    Pair<Boolean, Boolean> a7 = a(a6, map2);
                    if (!((Boolean) a7.first).booleanValue()) {
                        z3 = ((Boolean) a7.second).booleanValue();
                    } else {
                        Pair<Boolean, Boolean> a8 = a(map2);
                        if (!((Boolean) a8.first).booleanValue()) {
                            z3 = ((Boolean) a8.second).booleanValue();
                        } else {
                            byte[] b = ap.b(a6);
                            if (b != null) {
                                a6 = b;
                            }
                            br a9 = ae.a(a6);
                            if (a9 == null) {
                                a(false, 1, "failed to decode response package");
                                Boolean bool = Boolean.FALSE;
                                pair = new Pair(bool, bool);
                            } else {
                                Integer valueOf = Integer.valueOf(a9.b);
                                byte[] bArr2 = a9.c;
                                if (bArr2 == null) {
                                    length = 0;
                                } else {
                                    length = bArr2.length;
                                }
                                al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", valueOf, Integer.valueOf(length));
                                if (!a(a9, this.f1286i, this.f1287j)) {
                                    a(false, 2, "failed to process response package");
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                } else {
                                    a(true, 2, "successfully uploaded");
                                    Boolean bool3 = Boolean.TRUE;
                                    pair = new Pair(bool3, bool3);
                                }
                            }
                            if (!((Boolean) pair.first).booleanValue()) {
                                z3 = ((Boolean) pair.second).booleanValue();
                            } else {
                                z3 = false;
                            }
                        }
                    }
                    if (z3) {
                        i3 = i6;
                        i5 = 1;
                    } else {
                        return;
                    }
                } else {
                    a(false, i5, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public aj(Context context, int i3, int i5, byte[] bArr, String str, String str2, ah ahVar, int i6, int i7, boolean z3) {
        this.d = 2;
        this.f1282e = 30000;
        this.f1293p = null;
        this.f1281a = 0;
        this.b = 0L;
        this.c = 0L;
        this.s = false;
        this.f1283f = context;
        this.f1286i = aa.a(context);
        this.f1285h = bArr;
        this.f1287j = ac.a();
        if (af.f1264a == null) {
            af.f1264a = new af(context);
        }
        this.f1288k = af.f1264a;
        ai a5 = ai.a();
        this.f1289l = a5;
        this.f1290m = i3;
        this.f1293p = str;
        this.q = str2;
        this.f1291n = ahVar;
        this.f1292o = a5.f1272a;
        this.f1284g = i5;
        if (i6 > 0) {
            this.d = i6;
        }
        if (i7 > 0) {
            this.f1282e = i7;
        }
        this.s = z3;
        this.f1294r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            int r2 = r4.f1284g
            r3 = 630(0x276, float:8.83E-43)
            if (r2 == r3) goto L1c
            r3 = 640(0x280, float:8.97E-43)
            if (r2 == r3) goto L19
            r3 = 830(0x33e, float:1.163E-42)
            if (r2 == r3) goto L1c
            r3 = 840(0x348, float:1.177E-42)
            if (r2 == r3) goto L19
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L1e
        L19:
            java.lang.String r2 = "userinfo"
            goto L1e
        L1c:
            java.lang.String r2 = "crash"
        L1e:
            if (r5 == 0) goto L2a
            java.lang.String r6 = "[Upload] Success: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            com.tencent.bugly.proguard.al.a(r6, r1)
            goto L3d
        L2a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r6
            r3[r1] = r2
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.al.e(r6, r3)
        L3d:
            long r0 = r4.b
            long r2 = r4.c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5d
            com.tencent.bugly.proguard.ai r6 = r4.f1289l
            boolean r0 = r4.s
            long r0 = r6.a(r0)
            long r2 = r4.b
            long r0 = r0 + r2
            long r2 = r4.c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.f1289l
            boolean r2 = r4.s
            r6.a(r0, r2)
        L5d:
            com.tencent.bugly.proguard.ah r6 = r4.f1291n
            if (r6 == 0) goto L64
            r6.a(r5, r7)
        L64:
            com.tencent.bugly.proguard.ah r6 = r4.f1292o
            if (r6 == 0) goto L6b
            r6.a(r5, r7)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            String uuid = UUID.randomUUID().toString();
            return str + "?aid=" + uuid;
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b = brVar.f1448a;
        if (b != 0) {
            al.e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!ap.b(brVar.f1451g) && !aa.b().i().equals(brVar.f1451g)) {
                w.a().a(ac.f1257a, "device", brVar.f1451g.getBytes("UTF-8"), true);
                aaVar.d(brVar.f1451g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.f1245m = brVar.f1449e;
        int i3 = brVar.b;
        if (i3 == 510) {
            byte[] bArr = brVar.c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i3));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j2) {
        this.f1281a++;
        this.b += j2;
    }

    private Pair<Boolean, Boolean> a(Map<String, String> map) {
        int i3;
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                al.d("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
            } else if (map.containsKey("Bugly-Version")) {
                String str = map.get("Bugly-Version");
                if (!str.contains("bugly")) {
                    al.d("[Upload] Bugly version is not valid: %s", str);
                } else {
                    al.c("[Upload] Bugly version from headers is: %s", str);
                    try {
                        i3 = Integer.parseInt(map.get(NotificationCompat.CATEGORY_STATUS));
                    } catch (Throwable unused) {
                        i3 = -1;
                    }
                    try {
                        al.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (i3 != 0) {
                            a(false, 1, "status of server is ".concat(String.valueOf(i3)));
                            Boolean bool = Boolean.FALSE;
                            return new Pair<>(bool, bool);
                        }
                        Boolean bool2 = Boolean.TRUE;
                        return new Pair<>(bool2, bool2);
                    } catch (Throwable unused2) {
                        a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i3));
                        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                    }
                }
            } else {
                al.d("[Upload] Headers does not contain %s", "Bugly-Version");
            }
        } else {
            al.d("[Upload] Headers is empty.", new Object[0]);
        }
        al.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        a("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                al.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
            }
        }
        al.c("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }
}
