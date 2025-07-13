package s1;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class b {

    /* renamed from: o  reason: collision with root package name */
    public static final b f3480o = new b("");

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f3481a;
    public final Layout.Alignment b;
    public final Bitmap c;
    public final float d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3482e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3483f;

    /* renamed from: g  reason: collision with root package name */
    public final float f3484g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3485h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3486i;

    /* renamed from: j  reason: collision with root package name */
    public final float f3487j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3488k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3489l;

    /* renamed from: m  reason: collision with root package name */
    public final int f3490m;

    /* renamed from: n  reason: collision with root package name */
    public final float f3491n;

    public b(Bitmap bitmap, float f4, float f5, int i3, float f6, float f7) {
        this(null, null, bitmap, f5, 0, i3, f4, 0, Integer.MIN_VALUE, -3.4028235E38f, f6, f7, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public b(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f4, int i3, int i5, float f5, int i6, float f6) {
        this(charSequence, alignment, f4, i3, i5, f5, i6, f6, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f4, int i3, int i5, float f5, int i6, float f6, boolean z3, int i7) {
        this(charSequence, alignment, null, f4, i3, i5, f5, i6, Integer.MIN_VALUE, -3.4028235E38f, f6, -3.4028235E38f, z3, i7);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f4, int i3, int i5, float f5, int i6, int i7, float f6, float f7, float f8, boolean z3, int i8) {
        this.f3481a = charSequence;
        this.b = alignment;
        this.c = bitmap;
        this.d = f4;
        this.f3482e = i3;
        this.f3483f = i5;
        this.f3484g = f5;
        this.f3485h = i6;
        this.f3486i = f7;
        this.f3487j = f8;
        this.f3488k = z3;
        this.f3489l = i8;
        this.f3490m = i7;
        this.f3491n = f6;
    }
}
