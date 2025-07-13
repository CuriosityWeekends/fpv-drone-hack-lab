package e2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s extends e implements y {

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f1738o = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicReference f1739p = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1740a;
    public final int b;
    public final int c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public final x f1741e;

    /* renamed from: f  reason: collision with root package name */
    public final x f1742f;

    /* renamed from: g  reason: collision with root package name */
    public HttpURLConnection f1743g;

    /* renamed from: h  reason: collision with root package name */
    public InputStream f1744h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1745i;

    /* renamed from: j  reason: collision with root package name */
    public int f1746j;

    /* renamed from: k  reason: collision with root package name */
    public long f1747k;

    /* renamed from: l  reason: collision with root package name */
    public long f1748l;

    /* renamed from: m  reason: collision with root package name */
    public long f1749m;

    /* renamed from: n  reason: collision with root package name */
    public long f1750n;

    public s(String str, int i3, int i5, boolean z3, x xVar) {
        super(true);
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            this.f1742f = new x();
            this.b = i3;
            this.c = i5;
            this.f1740a = z3;
            this.f1741e = xVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static URL handleRedirect(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException(a1.i.w("Unsupported protocol redirect: ", protocol));
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    public static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j2) {
        int i3 = g2.w.f1960a;
        if (i3 != 19 && i3 != 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j2 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j2 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // e2.i
    public final void close() {
        try {
            if (this.f1744h != null) {
                HttpURLConnection httpURLConnection = this.f1743g;
                long j2 = this.f1748l;
                if (j2 != -1) {
                    j2 -= this.f1750n;
                }
                maybeTerminateInputStream(httpURLConnection, j2);
                try {
                    this.f1744h.close();
                } catch (IOException e5) {
                    throw new IOException(e5);
                }
            }
        } finally {
            this.f1744h = null;
            closeConnectionQuietly();
            if (this.f1745i) {
                this.f1745i = false;
                transferEnded();
            }
        }
    }

    public final void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.f1743g;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e5) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e5);
            }
            this.f1743g = null;
        }
    }

    @Override // e2.e, e2.i
    public final Map getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f1743g;
        if (httpURLConnection == null) {
            return Collections.emptyMap();
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // e2.i
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.f1743g;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.net.HttpURLConnection makeConnection(e2.l r25) {
        /*
            r24 = this;
            r0 = r25
            java.net.URL r1 = new java.net.URL
            android.net.Uri r2 = r0.f1694a
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            int r2 = r0.f1699i
            r3 = 1
            r2 = r2 & r3
            r4 = 0
            if (r2 != r3) goto L19
            r16 = 1
        L16:
            r15 = r24
            goto L1c
        L19:
            r16 = 0
            goto L16
        L1c:
            boolean r2 = r15.f1740a
            int r5 = r0.b
            byte[] r6 = r0.c
            long r13 = r0.f1696f
            long r11 = r0.f1697g
            if (r2 != 0) goto L38
            r9 = 1
            java.util.Map r10 = r0.d
            r0 = r24
            r2 = r5
            r3 = r6
            r4 = r13
            r6 = r11
            r8 = r16
            java.net.HttpURLConnection r0 = r0.makeConnection(r1, r2, r3, r4, r6, r8, r9, r10)
            return r0
        L38:
            r2 = r5
            r17 = r6
        L3b:
            int r9 = r4 + 1
            r5 = 20
            if (r4 > r5) goto Lac
            r4 = 0
            java.util.Map r10 = r0.d
            r5 = r24
            r6 = r1
            r7 = r2
            r8 = r17
            r18 = r9
            r19 = r10
            r9 = r13
            r20 = r11
            r22 = r13
            r13 = r16
            r14 = r4
            r15 = r19
            java.net.HttpURLConnection r4 = r5.makeConnection(r6, r7, r8, r9, r11, r13, r14, r15)
            int r5 = r4.getResponseCode()
            java.lang.String r6 = "Location"
            java.lang.String r6 = r4.getHeaderField(r6)
            r7 = 303(0x12f, float:4.25E-43)
            r8 = 302(0x12e, float:4.23E-43)
            r9 = 301(0x12d, float:4.22E-43)
            r10 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L73
            r11 = 3
            if (r2 != r11) goto L84
        L73:
            if (r5 == r10) goto L9c
            if (r5 == r9) goto L9c
            if (r5 == r8) goto L9c
            if (r5 == r7) goto L9c
            r11 = 307(0x133, float:4.3E-43)
            if (r5 == r11) goto L9c
            r11 = 308(0x134, float:4.32E-43)
            if (r5 != r11) goto L84
            goto L9c
        L84:
            r11 = 2
            if (r2 != r11) goto L9b
            if (r5 == r10) goto L8f
            if (r5 == r9) goto L8f
            if (r5 == r8) goto L8f
            if (r5 != r7) goto L9b
        L8f:
            r4.disconnect()
            java.net.URL r1 = handleRedirect(r1, r6)
            r2 = 0
            r17 = r2
            r2 = 1
            goto La3
        L9b:
            return r4
        L9c:
            r4.disconnect()
            java.net.URL r1 = handleRedirect(r1, r6)
        La3:
            r15 = r24
            r4 = r18
            r11 = r20
            r13 = r22
            goto L3b
        Lac:
            r18 = r9
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException
            java.lang.String r1 = "Too many redirects: "
            r4 = r18
            java.lang.String r1 = a1.i.e(r4, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.s.makeConnection(e2.l):java.net.HttpURLConnection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r6 != 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0102  */
    @Override // e2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long open(e2.l r20) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.s.open(e2.l):long");
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        try {
            skipInternal();
            if (i5 == 0) {
                return 0;
            }
            long j2 = this.f1748l;
            if (j2 != -1) {
                long j5 = j2 - this.f1750n;
                if (j5 != 0) {
                    i5 = (int) Math.min(i5, j5);
                }
                return -1;
            }
            int read = this.f1744h.read(bArr, i3, i5);
            if (read == -1) {
                if (this.f1748l == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.f1750n += read;
            bytesTransferred(read);
            return read;
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    public final void skipInternal() {
        if (this.f1749m == this.f1747k) {
            return;
        }
        AtomicReference atomicReference = f1739p;
        byte[] bArr = (byte[]) atomicReference.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j2 = this.f1749m;
            long j5 = this.f1747k;
            if (j2 != j5) {
                int read = this.f1744h.read(bArr, 0, (int) Math.min(j5 - j2, bArr.length));
                if (!Thread.currentThread().isInterrupted()) {
                    if (read != -1) {
                        this.f1749m += read;
                        bytesTransferred(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                atomicReference.set(bArr);
                return;
            }
        }
    }

    public final HttpURLConnection makeConnection(URL url, int i3, byte[] bArr, long j2, long j5, boolean z3, boolean z5, Map map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        HashMap hashMap = new HashMap();
        x xVar = this.f1741e;
        if (xVar != null) {
            hashMap.putAll(xVar.a());
        }
        hashMap.putAll(this.f1742f.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j2 != 0 || j5 != -1) {
            String str = "bytes=" + j2 + "-";
            if (j5 != -1) {
                StringBuilder l5 = a1.i.l(str);
                l5.append((j2 + j5) - 1);
                str = l5.toString();
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.d);
        httpURLConnection.setRequestProperty("Accept-Encoding", z3 ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z5);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(l.a(i3));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }
}
