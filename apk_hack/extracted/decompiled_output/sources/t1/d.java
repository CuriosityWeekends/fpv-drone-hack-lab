package t1;

import android.text.Layout;
import android.text.SpannableStringBuilder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends s1.b implements Comparable {

    /* renamed from: p  reason: collision with root package name */
    public final int f3650p;

    public d(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f4, int i3, float f5, int i5, boolean z3, int i6, int i7) {
        super(spannableStringBuilder, alignment, f4, 0, i3, f5, i5, -3.4028235E38f, z3, i6);
        this.f3650p = i7;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i3 = ((d) obj).f3650p;
        int i5 = this.f3650p;
        if (i3 < i5) {
            return -1;
        }
        if (i3 > i5) {
            return 1;
        }
        return 0;
    }
}
