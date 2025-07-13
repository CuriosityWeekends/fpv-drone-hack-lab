package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class H5JavaScriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<Integer> f1222a = new HashSet<>();
    private String b = null;
    private Thread c = null;
    private String d = null;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f1223e = null;

    private H5JavaScriptInterface() {
    }

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string2 = jSONObject.getString("projectRoot");
                bbVar.f1381a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                bbVar.b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
                bbVar.c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                bbVar.d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                bbVar.f1382e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                bbVar.f1383f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f1385h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                bbVar.f1384g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    bbVar.f1384g = bbVar.f1384g.substring(indexOf2 + 1);
                }
                bbVar.f1386i = jSONObject.getString("file");
                if (bbVar.f1383f == null) {
                    return null;
                }
                long j2 = jSONObject.getLong("lineNumber");
                bbVar.f1387j = j2;
                if (j2 < 0) {
                    return null;
                }
                long j5 = jSONObject.getLong("columnNumber");
                bbVar.f1388k = j5;
                if (j5 < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.f1381a, new Object[0]);
                al.a("[context]: " + bbVar.b, new Object[0]);
                al.a("[url]: " + bbVar.c, new Object[0]);
                al.a("[userAgent]: " + bbVar.d, new Object[0]);
                al.a("[language]: " + bbVar.f1382e, new Object[0]);
                al.a("[name]: " + bbVar.f1383f, new Object[0]);
                al.a("[message]: " + bbVar.f1384g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f1385h, new Object[0]);
                al.a("[file]: " + bbVar.f1386i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f1387j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f1388k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String str = null;
        if (aVar == null || f1222a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f1222a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder("\n");
            for (int i3 = 2; i3 < currentThread.getStackTrace().length; i3++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i3];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) aVar.c());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f1223e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c = ap.c(str.getBytes());
        String str2 = this.b;
        if (str2 != null && str2.equals(c)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.b = c;
        al.d("Handling JS exception ...", new Object[0]);
        bb a5 = a(str);
        if (a5 == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a5.f1381a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a5.b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a5.c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a5.d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a5.f1386i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j2 = a5.f1387j;
        if (j2 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j2));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f1223e);
        linkedHashMap.put("Java Stack", this.d);
        InnerApi.postH5CrashAsync(this.c, a5.f1383f, a5.f1384g, a5.f1385h, linkedHashMap);
    }
}
