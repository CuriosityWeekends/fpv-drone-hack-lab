package com.lxj.xpopup.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
@RequiresApi(api = 23)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class XPermission$PermissionActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f1094a = 0;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return true;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i5, Intent intent) {
        boolean z3;
        boolean canWrite;
        if (i3 == 2) {
            if (e.f1118j != null) {
                canWrite = Settings.System.canWrite((Context) e.f1117i.f1120a);
                if (canWrite) {
                    e.f1118j.D();
                } else {
                    e.f1118j.getClass();
                }
                e.f1118j = null;
            } else {
                return;
            }
        } else if (i3 == 3) {
            if (e.f1119k == null) {
                return;
            }
            e eVar = e.f1117i;
            if (Build.VERSION.SDK_INT >= 23) {
                z3 = Settings.canDrawOverlays((Context) eVar.f1120a);
            } else {
                eVar.getClass();
                z3 = true;
            }
            if (z3) {
                e.f1119k.D();
            } else {
                e.f1119k.getClass();
            }
            e.f1119k = null;
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        getWindow().addFlags(262672);
        getWindow().getAttributes().alpha = 0.0f;
        int intExtra = getIntent().getIntExtra("TYPE", 1);
        if (intExtra == 1) {
            if (e.f1117i == null) {
                super.onCreate(bundle);
                Log.e("XPermission", "request permissions failed");
                finish();
                return;
            }
            super.onCreate(bundle);
            e.f1117i.getClass();
            ArrayList arrayList = (ArrayList) e.f1117i.d;
            if (arrayList != null) {
                int size = arrayList.size();
                if (size > 0) {
                    requestPermissions((String[]) ((ArrayList) e.f1117i.d).toArray(new String[size]), 1);
                } else {
                    finish();
                }
            }
        } else if (intExtra == 2) {
            super.onCreate(bundle);
            e eVar = e.f1117i;
            eVar.getClass();
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + ((Context) eVar.f1120a).getPackageName()));
            if (!eVar.a(intent)) {
                eVar.b();
            } else {
                startActivityForResult(intent, 2);
            }
        } else if (intExtra == 3) {
            super.onCreate(bundle);
            e eVar2 = e.f1117i;
            eVar2.getClass();
            Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent2.setData(Uri.parse("package:" + ((Context) eVar2.f1120a).getPackageName()));
            if (!eVar2.a(intent2)) {
                eVar2.b();
            } else {
                startActivityForResult(intent2, 3);
            }
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        boolean shouldShowRequestPermissionRationale;
        e eVar = e.f1117i;
        Iterator it = ((ArrayList) eVar.d).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission((Context) eVar.f1120a, str) != 0) {
                ((ArrayList) eVar.f1122f).add(str);
                shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(str);
                if (!shouldShowRequestPermissionRationale) {
                    ((ArrayList) eVar.f1123g).add(str);
                }
            } else {
                ((ArrayList) eVar.f1121e).add(str);
            }
        }
        eVar.d();
        finish();
    }
}
