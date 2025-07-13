package b2;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import g2.w;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f143a;
    public final String b;
    public final DefaultTrackSelector$Parameters c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final int f144e;

    /* renamed from: f  reason: collision with root package name */
    public final int f145f;

    /* renamed from: g  reason: collision with root package name */
    public final int f146g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f147h;

    /* renamed from: i  reason: collision with root package name */
    public final int f148i;

    /* renamed from: j  reason: collision with root package name */
    public final int f149j;

    /* renamed from: k  reason: collision with root package name */
    public final int f150k;

    public f(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i3) {
        boolean z3;
        boolean z5;
        String locale;
        String[] strArr;
        LocaleList locales;
        String languageTags;
        this.c = defaultTrackSelector$Parameters;
        this.b = i.h(format.A);
        int i5 = 0;
        this.d = i.e(i3, false);
        this.f144e = i.c(format, defaultTrackSelector$Parameters.f415a, false);
        if ((format.c & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f147h = z3;
        int i6 = format.f322v;
        this.f148i = i6;
        this.f149j = format.w;
        int i7 = format.f307e;
        this.f150k = i7;
        if ((i7 != -1 && i7 > defaultTrackSelector$Parameters.q) || (i6 != -1 && i6 > defaultTrackSelector$Parameters.f406p)) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.f143a = z5;
        int i8 = w.f1960a;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i9 = w.f1960a;
        if (i9 >= 24) {
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            strArr = languageTags.split(",", -1);
        } else {
            Locale locale2 = configuration.locale;
            if (i9 >= 21) {
                locale = locale2.toLanguageTag();
            } else {
                locale = locale2.toString();
            }
            strArr = new String[]{locale};
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr[i10] = w.w(strArr[i10]);
        }
        int i11 = 0;
        while (true) {
            if (i11 < strArr.length) {
                int c = i.c(format, strArr[i11], false);
                if (c > 0) {
                    i5 = c;
                    break;
                }
                i11++;
            } else {
                i11 = Integer.MAX_VALUE;
                break;
            }
        }
        this.f145f = i11;
        this.f146g = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(f fVar) {
        int b;
        boolean z3 = fVar.d;
        int i3 = -1;
        boolean z5 = this.d;
        if (z5 != z3) {
            if (!z5) {
                return -1;
            }
            return 1;
        }
        int i5 = this.f144e;
        int i6 = fVar.f144e;
        if (i5 != i6) {
            return i.a(i5, i6);
        }
        boolean z6 = fVar.f143a;
        boolean z7 = this.f143a;
        if (z7 != z6) {
            if (!z7) {
                return -1;
            }
            return 1;
        }
        boolean z8 = this.c.f410v;
        int i7 = this.f150k;
        int i8 = fVar.f150k;
        if (z8 && (b = i.b(i7, i8)) != 0) {
            if (b > 0) {
                return -1;
            }
            return 1;
        }
        boolean z9 = fVar.f147h;
        boolean z10 = this.f147h;
        if (z10 != z9) {
            if (!z10) {
                return -1;
            }
            return 1;
        }
        int i9 = this.f145f;
        int i10 = fVar.f145f;
        if (i9 != i10) {
            return -i.a(i9, i10);
        }
        int i11 = this.f146g;
        int i12 = fVar.f146g;
        if (i11 != i12) {
            return i.a(i11, i12);
        }
        if (z7 && z5) {
            i3 = 1;
        }
        int i13 = this.f148i;
        int i14 = fVar.f148i;
        if (i13 != i14) {
            return i.a(i13, i14) * i3;
        }
        int i15 = this.f149j;
        int i16 = fVar.f149j;
        if (i15 != i16) {
            return i.a(i15, i16) * i3;
        }
        if (w.a(this.b, fVar.b)) {
            return i.a(i7, i8) * i3;
        }
        return 0;
    }
}
