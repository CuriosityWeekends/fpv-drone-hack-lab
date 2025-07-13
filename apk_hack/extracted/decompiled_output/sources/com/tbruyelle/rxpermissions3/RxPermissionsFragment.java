package com.tbruyelle.rxpermissions3;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import u4.b;
import v3.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RxPermissionsFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1145a = new HashMap();

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        boolean z3;
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (i3 != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            zArr[i5] = shouldShowRequestPermissionRationale(strArr[i5]);
        }
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr[i6];
            HashMap hashMap = this.f1145a;
            b bVar = (b) hashMap.get(str);
            if (bVar == null) {
                Log.e("c", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            hashMap.remove(strArr[i6]);
            if (iArr[i6] == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            bVar.c(new a(strArr[i6], z3, zArr[i6]));
            bVar.onComplete();
        }
    }
}
