package tv.danmaku.ijk.media.exo2.source;

import a1.i;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e2.e;
import e2.j;
import e2.l;
import e2.x;
import e2.y;
import g2.o;
import g2.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYDefaultHttpDataSource extends e implements y {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    @Nullable
    private HttpURLConnection connection;
    @Nullable
    private o contentTypePredicate;
    @Nullable
    private l dataSpec;
    @Nullable
    private final x defaultRequestProperties;
    @Nullable
    private InputStream inputStream;
    private boolean opened;
    private final int readTimeoutMillis;
    private final x requestProperties;
    private int responseCode;
    private final String userAgent;
    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference<>();

    public GSYDefaultHttpDataSource(String str) {
        this(str, 8000, 8000);
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e5) {
                Log.e(TAG, "Unexpected error while disconnecting", e5);
            }
            this.connection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long getContentLength(java.net.HttpURLConnection r11) {
        /*
            java.lang.String r0 = "Inconsistent headers ["
            java.lang.String r1 = "Content-Length"
            java.lang.String r1 = r11.getHeaderField(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "]"
            java.lang.String r4 = "DefaultHttpDataSource"
            if (r2 != 0) goto L2b
            long r5 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> L17
            goto L2d
        L17:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Unexpected Content-Length ["
            r2.<init>(r5)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r4, r2)
        L2b:
            r5 = -1
        L2d:
            java.lang.String r2 = "Content-Range"
            java.lang.String r11 = r11.getHeaderField(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 != 0) goto L9a
            java.util.regex.Pattern r2 = tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.CONTENT_RANGE_HEADER
            java.util.regex.Matcher r2 = r2.matcher(r11)
            boolean r7 = r2.find()
            if (r7 == 0) goto L9a
            r7 = 2
            java.lang.String r7 = r2.group(r7)     // Catch: java.lang.NumberFormatException -> L86
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.NumberFormatException -> L86
            r9 = 1
            java.lang.String r2 = r2.group(r9)     // Catch: java.lang.NumberFormatException -> L86
            long r9 = java.lang.Long.parseLong(r2)     // Catch: java.lang.NumberFormatException -> L86
            long r7 = r7 - r9
            r9 = 1
            long r7 = r7 + r9
            r9 = 0
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 >= 0) goto L63
            r5 = r7
            goto L9a
        L63:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L9a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L86
            r2.<init>(r0)     // Catch: java.lang.NumberFormatException -> L86
            r2.append(r1)     // Catch: java.lang.NumberFormatException -> L86
            java.lang.String r0 = "] ["
            r2.append(r0)     // Catch: java.lang.NumberFormatException -> L86
            r2.append(r11)     // Catch: java.lang.NumberFormatException -> L86
            r2.append(r3)     // Catch: java.lang.NumberFormatException -> L86
            java.lang.String r0 = r2.toString()     // Catch: java.lang.NumberFormatException -> L86
            android.util.Log.w(r4, r0)     // Catch: java.lang.NumberFormatException -> L86
            long r5 = java.lang.Math.max(r5, r7)     // Catch: java.lang.NumberFormatException -> L86
            goto L9a
        L86:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected Content-Range ["
            r0.<init>(r1)
            r0.append(r11)
            r0.append(r3)
            java.lang.String r11 = r0.toString()
            android.util.Log.e(r4, r11)
        L9a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.getContentLength(java.net.HttpURLConnection):long");
    }

    private static URL handleRedirect(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException(i.w("Unsupported protocol redirect: ", protocol));
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.HttpURLConnection makeConnection(e2.l r25) {
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
            boolean r2 = r15.allowCrossProtocolRedirects
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
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.makeConnection(e2.l):java.net.HttpURLConnection");
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j2) {
        int i3 = w.f1960a;
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

    private int readInternal(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.bytesToRead;
        if (j2 != -1) {
            long j5 = j2 - this.bytesRead;
            if (j5 == 0) {
                return -1;
            }
            i5 = (int) Math.min(i5, j5);
        }
        int read = this.inputStream.read(bArr, i3, i5);
        if (read == -1) {
            if (this.bytesToRead == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.bytesRead += read;
        bytesTransferred(read);
        return read;
    }

    private void skipInternal() {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        byte[] andSet = skipBufferReference.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.bytesSkipped;
            long j5 = this.bytesToSkip;
            if (j2 != j5) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(j5 - j2, andSet.length));
                if (!Thread.currentThread().isInterrupted()) {
                    if (read != -1) {
                        this.bytesSkipped += read;
                        bytesTransferred(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                skipBufferReference.set(andSet);
                return;
            }
        }
    }

    public final long bytesRead() {
        return this.bytesRead;
    }

    public final long bytesRemaining() {
        long j2 = this.bytesToRead;
        if (j2 != -1) {
            return j2 - this.bytesRead;
        }
        return j2;
    }

    public final long bytesSkipped() {
        return this.bytesSkipped;
    }

    public void clearAllRequestProperties() {
        x xVar = this.requestProperties;
        synchronized (xVar) {
            xVar.b = null;
            xVar.f1755a.clear();
        }
    }

    public void clearRequestProperty(String str) {
        str.getClass();
        x xVar = this.requestProperties;
        synchronized (xVar) {
            xVar.b = null;
            xVar.f1755a.remove(str);
        }
    }

    @Override // e2.i
    public void close() {
        try {
            if (this.inputStream != null) {
                maybeTerminateInputStream(this.connection, bytesRemaining());
                try {
                    this.inputStream.close();
                } catch (IOException e5) {
                    throw new IOException(e5);
                }
            }
        } finally {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }

    @Nullable
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getResponseCode() {
        int i3;
        if (this.connection == null || (i3 = this.responseCode) <= 0) {
            return -1;
        }
        return i3;
    }

    @Override // e2.e, e2.i
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return Collections.emptyMap();
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // e2.i
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // e2.i
    public long open(l lVar) {
        this.dataSpec = lVar;
        long j2 = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        transferInitializing(lVar);
        try {
            HttpURLConnection makeConnection = makeConnection(lVar);
            this.connection = makeConnection;
            try {
                this.responseCode = makeConnection.getResponseCode();
                this.connection.getResponseMessage();
                int i3 = this.responseCode;
                if (i3 >= 200 && i3 <= 299) {
                    this.connection.getContentType();
                    if (this.responseCode == 200) {
                        long j5 = lVar.f1696f;
                        if (j5 != 0) {
                            j2 = j5;
                        }
                    }
                    this.bytesToSkip = j2;
                    boolean isCompressed = isCompressed(this.connection);
                    if (!isCompressed) {
                        long j6 = lVar.f1697g;
                        long j7 = -1;
                        if (j6 != -1) {
                            this.bytesToRead = j6;
                        } else {
                            long contentLength = getContentLength(this.connection);
                            if (contentLength != -1) {
                                j7 = contentLength - this.bytesToSkip;
                            }
                            this.bytesToRead = j7;
                        }
                    } else {
                        this.bytesToRead = lVar.f1697g;
                    }
                    try {
                        this.inputStream = this.connection.getInputStream();
                        if (isCompressed) {
                            this.inputStream = new GZIPInputStream(this.inputStream);
                        }
                        this.opened = true;
                        transferStarted(lVar);
                        return this.bytesToRead;
                    } catch (IOException e5) {
                        closeConnectionQuietly();
                        throw new IOException(e5);
                    }
                }
                this.connection.getHeaderFields();
                closeConnectionQuietly();
                e2.w wVar = new e2.w(this.responseCode);
                if (this.responseCode == 416) {
                    wVar.initCause(new j());
                }
                throw wVar;
            } catch (IOException e6) {
                closeConnectionQuietly();
                throw new IOException("Unable to connect to " + lVar.f1694a.toString(), e6);
            }
        } catch (IOException e7) {
            throw new IOException("Unable to connect to " + lVar.f1694a.toString(), e7);
        }
    }

    @VisibleForTesting
    public HttpURLConnection openConnection(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // e2.i
    public int read(byte[] bArr, int i3, int i5) {
        try {
            skipInternal();
            return readInternal(bArr, i3, i5);
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    public void setRequestProperty(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.requestProperties.b(str, str2);
    }

    public GSYDefaultHttpDataSource(String str, int i3, int i5) {
        this(str, i3, i5, false, null);
    }

    public GSYDefaultHttpDataSource(String str, int i3, int i5, boolean z3, @Nullable x xVar) {
        super(true);
        if (!TextUtils.isEmpty(str)) {
            this.userAgent = str;
            this.requestProperties = new x();
            this.connectTimeoutMillis = i3;
            this.readTimeoutMillis = i5;
            this.allowCrossProtocolRedirects = z3;
            this.defaultRequestProperties = xVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public GSYDefaultHttpDataSource(String str, @Nullable o oVar) {
        this(str, oVar, 8000, 8000);
    }

    @Deprecated
    public GSYDefaultHttpDataSource(String str, @Nullable o oVar, int i3, int i5) {
        this(str, oVar, i3, i5, false, null);
    }

    @Deprecated
    public GSYDefaultHttpDataSource(String str, @Nullable o oVar, int i3, int i5, boolean z3, @Nullable x xVar) {
        super(true);
        if (!TextUtils.isEmpty(str)) {
            this.userAgent = str;
            this.requestProperties = new x();
            this.connectTimeoutMillis = i3;
            this.readTimeoutMillis = i5;
            this.allowCrossProtocolRedirects = z3;
            this.defaultRequestProperties = xVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    private HttpURLConnection makeConnection(URL url, int i3, byte[] bArr, long j2, long j5, boolean z3, boolean z5, Map<String, String> map) {
        HttpsURLConnection httpsURLConnection;
        if (url.getProtocol().endsWith("https")) {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.2
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            try {
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                sSLContext.init(null, trustManagerArr, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: tv.danmaku.ijk.media.exo2.source.GSYDefaultHttpDataSource.3
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
                httpsURLConnection = httpsURLConnection2;
            } catch (KeyManagementException e5) {
                e5.printStackTrace();
                httpsURLConnection = httpsURLConnection2;
            } catch (NoSuchAlgorithmException e6) {
                e6.printStackTrace();
                httpsURLConnection = httpsURLConnection2;
            }
        } else {
            httpsURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpsURLConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpsURLConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap hashMap = new HashMap();
        x xVar = this.defaultRequestProperties;
        if (xVar != null) {
            hashMap.putAll(xVar.a());
        }
        hashMap.putAll(this.requestProperties.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j2 != 0 || j5 != -1) {
            String str = "bytes=" + j2 + "-";
            if (j5 != -1) {
                StringBuilder l5 = i.l(str);
                l5.append((j2 + j5) - 1);
                str = l5.toString();
            }
            httpsURLConnection.setRequestProperty("Range", str);
        }
        httpsURLConnection.setRequestProperty("User-Agent", this.userAgent);
        httpsURLConnection.setRequestProperty("Accept-Encoding", z3 ? "gzip" : "identity");
        httpsURLConnection.setInstanceFollowRedirects(z5);
        httpsURLConnection.setDoOutput(bArr != null);
        httpsURLConnection.setRequestMethod(l.a(i3));
        if (bArr != null) {
            httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpsURLConnection.connect();
        }
        return httpsURLConnection;
    }

    public void setContentTypePredicate(@Nullable o oVar) {
    }
}
