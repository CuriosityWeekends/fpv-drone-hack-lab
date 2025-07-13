package com.tencent.bugly;

import com.tencent.bugly.proguard.aa;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BuglyStrategy {
    private String c;
    private String d;

    /* renamed from: e  reason: collision with root package name */
    private String f1147e;

    /* renamed from: f  reason: collision with root package name */
    private long f1148f;

    /* renamed from: g  reason: collision with root package name */
    private String f1149g;

    /* renamed from: h  reason: collision with root package name */
    private String f1150h;

    /* renamed from: i  reason: collision with root package name */
    private String f1151i;

    /* renamed from: u  reason: collision with root package name */
    private a f1161u;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1152j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1153k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1154l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1155m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1156n = true;

    /* renamed from: o  reason: collision with root package name */
    private Class<?> f1157o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1158p = true;
    private boolean q = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1159r = true;
    private boolean s = true;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1160t = false;

    /* renamed from: a  reason: collision with root package name */
    protected int f1146a = 31;
    protected boolean b = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1162v = false;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i3, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i3, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.d;
        if (str == null) {
            return aa.b().s;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f1147e;
        if (str == null) {
            return aa.b().c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f1148f;
    }

    public synchronized String getAppVersion() {
        String str = this.c;
        if (str == null) {
            return aa.b().f1247o;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f1146a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f1161u;
    }

    public synchronized String getDeviceID() {
        return this.f1150h;
    }

    public synchronized String getDeviceModel() {
        return this.f1151i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f1149g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f1157o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f1158p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f1153k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f1154l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f1152j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f1155m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f1156n;
    }

    public boolean isMerged() {
        return this.f1162v;
    }

    public boolean isReplaceOldChannel() {
        return this.q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f1159r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f1160t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f1147e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f1148f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z3) {
        this.f1158p = z3;
        return this;
    }

    public synchronized void setCallBackType(int i3) {
        this.f1146a = i3;
    }

    public synchronized void setCloseErrorCallback(boolean z3) {
        this.b = z3;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f1161u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f1150h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f1151i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z3) {
        this.f1153k = z3;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z3) {
        this.f1154l = z3;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z3) {
        this.f1152j = z3;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z3) {
        this.f1155m = z3;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z3) {
        this.f1156n = z3;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f1149g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z3) {
        this.f1162v = z3;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z3) {
        this.f1160t = z3;
        return this;
    }

    public void setReplaceOldChannel(boolean z3) {
        this.q = z3;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z3) {
        this.f1159r = z3;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z3) {
        this.s = z3;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f1157o = cls;
        return this;
    }
}
