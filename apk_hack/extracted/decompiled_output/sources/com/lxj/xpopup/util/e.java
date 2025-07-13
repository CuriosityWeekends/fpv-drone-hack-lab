package com.lxj.xpopup.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: h  reason: collision with root package name */
    public static List f1116h;

    /* renamed from: i  reason: collision with root package name */
    public static e f1117i;

    /* renamed from: j  reason: collision with root package name */
    public static b3.e f1118j;

    /* renamed from: k  reason: collision with root package name */
    public static b3.e f1119k;

    /* renamed from: a  reason: collision with root package name */
    public Object f1120a;
    public Object b;
    public Object c;
    public Object d;

    /* renamed from: e  reason: collision with root package name */
    public Object f1121e;

    /* renamed from: f  reason: collision with root package name */
    public Cloneable f1122f;

    /* renamed from: g  reason: collision with root package name */
    public Object f1123g;

    public boolean a(Intent intent) {
        if (((Context) this.f1120a).getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            return true;
        }
        return false;
    }

    public void b() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + ((Context) this.f1120a).getPackageName()));
        if (!a(intent)) {
            return;
        }
        ((Context) this.f1120a).startActivity(intent.addFlags(268435456));
    }

    public void c(String... strArr) {
        List emptyList;
        String[] strArr2;
        this.c = new LinkedHashSet();
        try {
            String[] strArr3 = ((Context) this.f1120a).getPackageManager().getPackageInfo(((Context) this.f1120a).getPackageName(), 4096).requestedPermissions;
            if (strArr3 == null) {
                emptyList = Collections.emptyList();
            } else {
                emptyList = Arrays.asList(strArr3);
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            emptyList = Collections.emptyList();
        }
        f1116h = emptyList;
        for (String str : strArr) {
            if (str == null) {
                strArr2 = new String[0];
            } else if (!str.equals("STORAGE")) {
                strArr2 = new String[]{str};
            } else {
                strArr2 = b.f1112v;
            }
            for (String str2 : strArr2) {
                if (f1116h.contains(str2)) {
                    ((LinkedHashSet) this.c).add(str2);
                }
            }
        }
    }

    public void d() {
        if (((b3.e) this.b) != null) {
            if (((ArrayList) this.d).size() != 0 && ((LinkedHashSet) this.c).size() != ((ArrayList) this.f1121e).size()) {
                if (!((ArrayList) this.f1122f).isEmpty()) {
                    ((b3.e) this.b).getClass();
                }
            } else {
                ((b3.e) this.b).D();
            }
            this.b = null;
        }
    }
}
