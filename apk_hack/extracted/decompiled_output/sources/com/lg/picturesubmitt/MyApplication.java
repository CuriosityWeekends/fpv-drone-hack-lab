package com.lg.picturesubmitt;

import a1.i;
import android.app.Application;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import s2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyApplication extends Application {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f541h = false;

    /* renamed from: i  reason: collision with root package name */
    public static String f542i = "192.168.28.1";

    /* renamed from: j  reason: collision with root package name */
    public static int f543j = 40;

    /* renamed from: a  reason: collision with root package name */
    public String f544a;
    public String b;
    public String c;
    public String d;

    /* renamed from: e  reason: collision with root package name */
    public String f545e;

    /* renamed from: f  reason: collision with root package name */
    public int f546f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f547g;

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "90adc4a8c8", true);
        registerActivityLifecycleCallbacks(new c(this));
        StringBuilder sb = new StringBuilder();
        sb.append(getExternalFilesDir(null));
        String str = File.separator;
        this.f544a = i.k(sb, str, "RCFPVPro");
        this.b = this.f544a + str + "Picture";
        this.c = this.f544a + str + "Video";
        this.d = this.f544a + str + "VideoThum";
        this.f545e = this.f544a + str + "MusicDir";
    }
}
