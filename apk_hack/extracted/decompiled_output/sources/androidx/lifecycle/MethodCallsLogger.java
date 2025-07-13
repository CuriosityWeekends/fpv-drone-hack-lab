package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i3) {
        int i5;
        Integer num = this.mCalledMethods.get(str);
        boolean z3 = false;
        if (num != null) {
            i5 = num.intValue();
        } else {
            i5 = 0;
        }
        if ((i5 & i3) != 0) {
            z3 = true;
        }
        this.mCalledMethods.put(str, Integer.valueOf(i3 | i5));
        return !z3;
    }
}
