package com.tencent.bugly.crashreport;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements CrashReport.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebView f1166a;

    public a(WebView webView) {
        this.f1166a = webView;
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.a
    public final String a() {
        return this.f1166a.getUrl();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.a
    public final void b() {
        WebSettings settings = this.f1166a.getSettings();
        if (!settings.getJavaScriptEnabled()) {
            settings.setJavaScriptEnabled(true);
        }
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.a
    public final CharSequence c() {
        return this.f1166a.getContentDescription();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.a
    public final void a(String str) {
        this.f1166a.loadUrl(str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.a
    public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
        this.f1166a.addJavascriptInterface(h5JavaScriptInterface, str);
    }
}
