package v3;

import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions3.RxPermissionsFragment;
import java.util.ArrayList;
import p4.g;
import p4.m;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements k4.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f3898a;
    public final /* synthetic */ c b;

    public /* synthetic */ b(c cVar, String[] strArr) {
        this.b = cVar;
        this.f3898a = strArr;
    }

    @Override // k4.b
    public Object apply(Object obj) {
        int checkSelfPermission;
        boolean isPermissionRevokedByPolicy;
        c cVar = this.b;
        cVar.getClass();
        String[] strArr = this.f3898a;
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            i.b bVar = cVar.f3899a;
            if (i3 < length) {
                String str = strArr[i3];
                bVar.e().getClass();
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 23) {
                    FragmentActivity activity = bVar.e().getActivity();
                    if (activity != null) {
                        checkSelfPermission = activity.checkSelfPermission(str);
                        if (checkSelfPermission != 0) {
                            if (i5 >= 23) {
                                RxPermissionsFragment e5 = bVar.e();
                                FragmentActivity activity2 = e5.getActivity();
                                if (activity2 != null) {
                                    isPermissionRevokedByPolicy = activity2.getPackageManager().isPermissionRevokedByPolicy(str, e5.getActivity().getPackageName());
                                    if (isPermissionRevokedByPolicy) {
                                        arrayList.add(h4.b.f(new a(str, false, false)));
                                        i3++;
                                    }
                                } else {
                                    throw new IllegalStateException("This fragment must be attached to an activity.");
                                }
                            }
                            u4.b bVar2 = (u4.b) bVar.e().f1145a.get(str);
                            if (bVar2 == null) {
                                arrayList2.add(str);
                                bVar2 = new u4.b();
                                bVar.e().f1145a.put(str, bVar2);
                            }
                            arrayList.add(bVar2);
                            i3++;
                        }
                    } else {
                        throw new IllegalStateException("This fragment must be attached to an activity.");
                    }
                }
                arrayList.add(h4.b.f(new a(str, true, false)));
                i3++;
            } else {
                if (!arrayList2.isEmpty()) {
                    String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    RxPermissionsFragment e6 = bVar.e();
                    TextUtils.join(", ", strArr2);
                    e6.getClass();
                    bVar.e().requestPermissions(strArr2, 42);
                }
                m mVar = new m(1, arrayList);
                int i6 = h4.a.f2039a;
                m4.a.a(i6, "bufferSize");
                return new g(mVar, i6);
            }
        }
    }
}
