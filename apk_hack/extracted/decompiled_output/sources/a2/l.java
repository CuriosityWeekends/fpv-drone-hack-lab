package a2;

import android.text.SpannableStringBuilder;
import b2.n;
import b2.o;
import g2.w;
import j0.n0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements s1.e {

    /* renamed from: a  reason: collision with root package name */
    public final int f81a;
    public final Object b;
    public final Object c;
    public final Object d;

    public /* synthetic */ l(Object obj, Object obj2, Object[] objArr, int i3) {
        this.b = obj;
        this.c = obj2;
        this.d = objArr;
        this.f81a = i3;
    }

    public String a(String str, long j2, int i3, long j5) {
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (true) {
            String[] strArr = (String[]) this.b;
            int i6 = this.f81a;
            if (i5 < i6) {
                sb.append(strArr[i5]);
                int i7 = ((int[]) this.c)[i5];
                if (i7 == 1) {
                    sb.append(str);
                } else {
                    String[] strArr2 = (String[]) this.d;
                    if (i7 == 2) {
                        sb.append(String.format(Locale.US, strArr2[i5], Long.valueOf(j2)));
                    } else if (i7 == 3) {
                        sb.append(String.format(Locale.US, strArr2[i5], Integer.valueOf(i3)));
                    } else if (i7 == 4) {
                        sb.append(String.format(Locale.US, strArr2[i5], Long.valueOf(j5)));
                    }
                }
                i5++;
            } else {
                sb.append(strArr[i6]);
                return sb.toString();
            }
        }
    }

    @Override // s1.e
    public int b(long j2) {
        long[] jArr = (long[]) this.d;
        int b = w.b(jArr, j2, false, false);
        if (b >= jArr.length) {
            return -1;
        }
        return b;
    }

    public boolean c(l lVar, int i3) {
        if (lVar == null || !w.a(((n0[]) this.b)[i3], ((n0[]) lVar.b)[i3]) || !w.a(((o) this.c).b[i3], ((o) lVar.c).b[i3])) {
            return false;
        }
        return true;
    }

    public boolean d(int i3) {
        if (((n0[]) this.b)[i3] != null) {
            return true;
        }
        return false;
    }

    @Override // s1.e
    public long e(int i3) {
        boolean z3;
        boolean z5 = false;
        if (i3 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        long[] jArr = (long[]) this.d;
        if (i3 < jArr.length) {
            z5 = true;
        }
        g2.b.e(z5);
        return jArr[i3];
    }

    @Override // s1.e
    public List i(long j2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = null;
        f fVar = null;
        for (int i3 = 0; i3 < this.f81a; i3++) {
            int i5 = i3 * 2;
            long[] jArr = (long[]) this.c;
            if (jArr[i5] <= j2 && j2 < jArr[i5 + 1]) {
                f fVar2 = (f) ((List) this.b).get(i3);
                if (fVar2.d == -3.4028235E38f && fVar2.f3484g == 0.5f) {
                    if (fVar == null) {
                        fVar = fVar2;
                    } else {
                        CharSequence charSequence = fVar2.f3481a;
                        if (spannableStringBuilder == null) {
                            spannableStringBuilder = new SpannableStringBuilder();
                            CharSequence charSequence2 = fVar.f3481a;
                            charSequence2.getClass();
                            SpannableStringBuilder append = spannableStringBuilder.append(charSequence2).append((CharSequence) "\n");
                            charSequence.getClass();
                            append.append(charSequence);
                        } else {
                            SpannableStringBuilder append2 = spannableStringBuilder.append((CharSequence) "\n");
                            charSequence.getClass();
                            append2.append(charSequence);
                        }
                    }
                } else {
                    arrayList.add(fVar2);
                }
            }
        }
        if (spannableStringBuilder != null) {
            e eVar = new e();
            eVar.c = spannableStringBuilder;
            arrayList.add(eVar.a());
        } else if (fVar != null) {
            arrayList.add(fVar);
        }
        return arrayList;
    }

    @Override // s1.e
    public int n() {
        return ((long[]) this.d).length;
    }

    public l(ArrayList arrayList) {
        this.b = arrayList;
        int size = arrayList.size();
        this.f81a = size;
        this.c = new long[size * 2];
        for (int i3 = 0; i3 < this.f81a; i3++) {
            f fVar = (f) arrayList.get(i3);
            int i5 = i3 * 2;
            long[] jArr = (long[]) this.c;
            jArr[i5] = fVar.f71p;
            jArr[i5 + 1] = fVar.q;
        }
        long[] jArr2 = (long[]) this.c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.d = copyOf;
        Arrays.sort(copyOf);
    }

    public l(n0[] n0VarArr, n[] nVarArr, b2.k kVar) {
        this.b = n0VarArr;
        this.c = new o(nVarArr);
        this.d = kVar;
        this.f81a = n0VarArr.length;
    }
}
