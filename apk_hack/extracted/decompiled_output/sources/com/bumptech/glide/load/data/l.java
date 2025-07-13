package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements e {

    /* renamed from: a  reason: collision with root package name */
    public final m.f f263a;
    public final int b;
    public HttpURLConnection c;
    public InputStream d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f264e;

    public l(m.f fVar, int i3) {
        this.f263a = fVar;
        this.b = i3;
    }

    public static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e5) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e5);
                return -1;
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.c = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.j jVar, d dVar) {
        StringBuilder sb;
        m.f fVar = this.f263a;
        int i3 = c0.h.b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                dVar.f(e(fVar.d(), 0, null, fVar.b.a()));
            } catch (IOException e5) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e5);
                }
                dVar.d(e5);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder("Finished http url fetcher fetch in ");
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                sb.append(c0.h.a(elapsedRealtimeNanos));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + c0.h.a(elapsedRealtimeNanos));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f264e = true;
    }

    public final InputStream e(URL url, int i3, URL url2, Map map) {
        if (i3 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new g.c("In re-direct loop", -1, null);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                int i5 = this.b;
                httpURLConnection.setConnectTimeout(i5);
                httpURLConnection.setReadTimeout(i5);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.c = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.d = this.c.getInputStream();
                    if (this.f264e) {
                        return null;
                    }
                    int d = d(this.c);
                    int i6 = d / 100;
                    if (i6 == 2) {
                        HttpURLConnection httpURLConnection2 = this.c;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                this.d = new c0.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                                }
                                this.d = httpURLConnection2.getInputStream();
                            }
                            return this.d;
                        } catch (IOException e5) {
                            throw new g.c("Failed to obtain InputStream", d(httpURLConnection2), e5);
                        }
                    } else if (i6 == 3) {
                        String headerField = this.c.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField)) {
                            try {
                                URL url3 = new URL(url, headerField);
                                b();
                                return e(url3, i3 + 1, url, map);
                            } catch (MalformedURLException e6) {
                                throw new g.c(a1.i.w("Bad redirect url: ", headerField), d, e6);
                            }
                        }
                        throw new g.c("Received empty or null redirect url", d, null);
                    } else if (d == -1) {
                        throw new g.c("Http request failed", d, null);
                    } else {
                        try {
                            throw new g.c(this.c.getResponseMessage(), d, null);
                        } catch (IOException e7) {
                            throw new g.c("Failed to get a response message", d, e7);
                        }
                    }
                } catch (IOException e8) {
                    throw new g.c("Failed to connect or obtain data", d(this.c), e8);
                }
            } catch (IOException e9) {
                throw new g.c("URL.openConnection threw", 0, e9);
            }
        }
        throw new g.c("Too many (> 5) redirects!", -1, null);
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return 2;
    }
}
