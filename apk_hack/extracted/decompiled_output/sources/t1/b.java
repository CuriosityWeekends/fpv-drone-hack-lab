package t1;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3628a;
    public final ArrayList b;
    public final StringBuilder c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3629e;

    /* renamed from: f  reason: collision with root package name */
    public int f3630f;

    /* renamed from: g  reason: collision with root package name */
    public int f3631g;

    /* renamed from: h  reason: collision with root package name */
    public int f3632h;

    public b(int i3, int i5) {
        ArrayList arrayList = new ArrayList();
        this.f3628a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        StringBuilder sb = new StringBuilder();
        this.c = sb;
        this.f3631g = i3;
        arrayList.clear();
        arrayList2.clear();
        sb.setLength(0);
        this.d = 15;
        this.f3629e = 0;
        this.f3630f = 0;
        this.f3632h = i5;
    }

    public final void a() {
        StringBuilder sb = this.c;
        int length = sb.length();
        if (length > 0) {
            sb.delete(length - 1, length);
            ArrayList arrayList = this.f3628a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                a aVar = (a) arrayList.get(size);
                int i3 = aVar.c;
                if (i3 == length) {
                    aVar.c = i3 - 1;
                } else {
                    return;
                }
            }
        }
    }

    public final s1.b b(int i3) {
        float f4;
        int i5;
        int i6;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i7 = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i7 >= arrayList.size()) {
                break;
            }
            spannableStringBuilder.append((CharSequence) arrayList.get(i7));
            spannableStringBuilder.append('\n');
            i7++;
        }
        spannableStringBuilder.append((CharSequence) c());
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        int i8 = this.f3629e + this.f3630f;
        int length = (32 - i8) - spannableStringBuilder.length();
        int i9 = i8 - length;
        if (i3 == Integer.MIN_VALUE) {
            if (this.f3631g == 2 && (Math.abs(i9) < 3 || length < 0)) {
                i3 = 1;
            } else if (this.f3631g == 2 && i9 > 0) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                i8 = 32 - length;
            }
            f4 = ((i8 / 32.0f) * 0.8f) + 0.1f;
        } else {
            f4 = 0.5f;
        }
        if (this.f3631g != 1 && (i5 = this.d) <= 7) {
            i6 = 0;
        } else {
            i5 = this.d - 17;
            i6 = 2;
        }
        return new s1.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i5, 1, i6, f4, i3, -3.4028235E38f);
    }

    public final SpannableString c() {
        int i3;
        boolean z3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
        int length = spannableStringBuilder.length();
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = this.f3628a;
            if (i5 >= arrayList.size()) {
                break;
            }
            a aVar = (a) arrayList.get(i5);
            boolean z6 = aVar.b;
            int i11 = aVar.f3627a;
            if (i11 != 8) {
                if (i11 == 7) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i11 != 7) {
                    i10 = c.f3634y[i11];
                }
                z5 = z3;
            }
            int i12 = aVar.c;
            i5++;
            if (i5 < arrayList.size()) {
                i3 = ((a) arrayList.get(i5)).c;
            } else {
                i3 = length;
            }
            if (i12 != i3) {
                if (i6 != -1 && !z6) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i12, 33);
                    i6 = -1;
                } else if (i6 == -1 && z6) {
                    i6 = i12;
                }
                if (i7 != -1 && !z5) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i7, i12, 33);
                    i7 = -1;
                } else if (i7 == -1 && z5) {
                    i7 = i12;
                }
                if (i10 != i9) {
                    if (i9 != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i9), i8, i12, 33);
                    }
                    i9 = i10;
                    i8 = i12;
                }
            }
        }
        if (i6 != -1 && i6 != length) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i6, length, 33);
        }
        if (i7 != -1 && i7 != length) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i7, length, 33);
        }
        if (i8 != length && i9 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i9), i8, length, 33);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final boolean d() {
        if (this.f3628a.isEmpty() && this.b.isEmpty() && this.c.length() == 0) {
            return true;
        }
        return false;
    }
}
