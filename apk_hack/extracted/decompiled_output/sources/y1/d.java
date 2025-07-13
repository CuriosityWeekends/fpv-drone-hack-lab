package y1;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f4233a;
    public final String b;
    public final boolean c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4234e;

    /* renamed from: f  reason: collision with root package name */
    public final f f4235f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f4236g;

    /* renamed from: h  reason: collision with root package name */
    public final String f4237h;

    /* renamed from: i  reason: collision with root package name */
    public final String f4238i;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap f4239j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap f4240k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f4241l;

    public d(String str, String str2, long j2, long j5, f fVar, String[] strArr, String str3, String str4) {
        boolean z3;
        this.f4233a = str;
        this.b = str2;
        this.f4238i = str4;
        this.f4235f = fVar;
        this.f4236g = strArr;
        if (str2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.c = z3;
        this.d = j2;
        this.f4234e = j5;
        str3.getClass();
        this.f4237h = str3;
        this.f4239j = new HashMap();
        this.f4240k = new HashMap();
    }

    public static d a(String str) {
        return new d(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null);
    }

    public static SpannableStringBuilder d(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            treeMap.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) treeMap.get(str);
    }

    public final d b(int i3) {
        ArrayList arrayList = this.f4241l;
        if (arrayList != null) {
            return (d) arrayList.get(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public final void c(TreeSet treeSet, boolean z3) {
        boolean z5;
        String str = this.f4233a;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z3 || equals || (equals2 && this.f4238i != null)) {
            long j2 = this.d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j5 = this.f4234e;
            if (j5 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j5));
            }
        }
        if (this.f4241l == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f4241l.size(); i3++) {
            d dVar = (d) this.f4241l.get(i3);
            if (!z3 && !equals) {
                z5 = false;
            } else {
                z5 = true;
            }
            dVar.c(treeSet, z5);
        }
    }

    public final boolean e(long j2) {
        long j5 = this.f4234e;
        long j6 = this.d;
        if ((j6 == -9223372036854775807L && j5 == -9223372036854775807L) || ((j6 <= j2 && j5 == -9223372036854775807L) || ((j6 == -9223372036854775807L && j2 < j5) || (j6 <= j2 && j2 < j5)))) {
            return true;
        }
        return false;
    }

    public final void f(long j2, String str, ArrayList arrayList) {
        int size;
        String str2;
        String str3 = this.f4237h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (e(j2) && "div".equals(this.f4233a) && (str2 = this.f4238i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        int i3 = 0;
        while (true) {
            ArrayList arrayList2 = this.f4241l;
            if (arrayList2 == null) {
                size = 0;
            } else {
                size = arrayList2.size();
            }
            if (i3 < size) {
                b(i3).f(j2, str, arrayList);
                i3++;
            } else {
                return;
            }
        }
    }

    public final void g(long j2, Map map, TreeMap treeMap) {
        int size;
        int i3;
        char c;
        char c5;
        int i5;
        int i6;
        if (!e(j2)) {
            return;
        }
        Iterator it = this.f4240k.entrySet().iterator();
        while (true) {
            int i7 = 0;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                HashMap hashMap = this.f4239j;
                if (hashMap.containsKey(str)) {
                    i3 = ((Integer) hashMap.get(str)).intValue();
                } else {
                    i3 = 0;
                }
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i3 != intValue) {
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) treeMap.get(str);
                    f fVar = this.f4235f;
                    String[] strArr = this.f4236g;
                    if (fVar == null && strArr == null) {
                        fVar = null;
                    } else if (fVar == null && strArr.length == 1) {
                        fVar = (f) map.get(strArr[0]);
                    } else if (fVar == null && strArr.length > 1) {
                        fVar = new f();
                        for (String str2 : strArr) {
                            fVar.a((f) map.get(str2));
                        }
                    } else if (fVar != null && strArr != null && strArr.length == 1) {
                        fVar.a((f) map.get(strArr[0]));
                    } else if (fVar != null && strArr != null && strArr.length > 1) {
                        for (String str3 : strArr) {
                            fVar.a((f) map.get(str3));
                        }
                    }
                    if (fVar != null) {
                        int i8 = fVar.f4252h;
                        int i9 = -1;
                        if (i8 == -1 && fVar.f4253i == -1) {
                            i5 = -1;
                        } else {
                            if (i8 == 1) {
                                c = 1;
                            } else {
                                c = 0;
                            }
                            if (fVar.f4253i == 1) {
                                c5 = 2;
                            } else {
                                c5 = 0;
                            }
                            i5 = c | c5;
                        }
                        if (i5 != -1) {
                            int i10 = fVar.f4252h;
                            if (i10 != -1 || fVar.f4253i != -1) {
                                if (i10 == 1) {
                                    i6 = 1;
                                } else {
                                    i6 = 0;
                                }
                                if (fVar.f4253i == 1) {
                                    i7 = 2;
                                }
                                i9 = i6 | i7;
                            }
                            spannableStringBuilder.setSpan(new StyleSpan(i9), i3, intValue, 33);
                        }
                        if (fVar.f4250f == 1) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), i3, intValue, 33);
                        }
                        if (fVar.f4251g == 1) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, intValue, 33);
                        }
                        if (fVar.c) {
                            if (fVar.c) {
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(fVar.b), i3, intValue, 33);
                            } else {
                                throw new IllegalStateException("Font color has not been defined.");
                            }
                        }
                        if (fVar.f4249e) {
                            if (fVar.f4249e) {
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(fVar.d), i3, intValue, 33);
                            } else {
                                throw new IllegalStateException("Background color has not been defined.");
                            }
                        }
                        if (fVar.f4248a != null) {
                            spannableStringBuilder.setSpan(new TypefaceSpan(fVar.f4248a), i3, intValue, 33);
                        }
                        if (fVar.f4257m != null) {
                            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(fVar.f4257m), i3, intValue, 33);
                        }
                        int i11 = fVar.f4254j;
                        if (i11 != 1) {
                            if (i11 != 2) {
                                if (i11 == 3) {
                                    spannableStringBuilder.setSpan(new RelativeSizeSpan(fVar.f4255k / 100.0f), i3, intValue, 33);
                                }
                            } else {
                                spannableStringBuilder.setSpan(new RelativeSizeSpan(fVar.f4255k), i3, intValue, 33);
                            }
                        } else {
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) fVar.f4255k, true), i3, intValue, 33);
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                int i12 = 0;
                while (true) {
                    ArrayList arrayList = this.f4241l;
                    if (arrayList == null) {
                        size = 0;
                    } else {
                        size = arrayList.size();
                    }
                    if (i12 < size) {
                        b(i12).g(j2, map, treeMap);
                        i12++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void h(long j2, boolean z3, String str, TreeMap treeMap) {
        String str2;
        int size;
        boolean z5;
        HashMap hashMap = this.f4239j;
        hashMap.clear();
        HashMap hashMap2 = this.f4240k;
        hashMap2.clear();
        String str3 = this.f4233a;
        if ("metadata".equals(str3)) {
            return;
        }
        String str4 = this.f4237h;
        if ("".equals(str4)) {
            str2 = str;
        } else {
            str2 = str4;
        }
        if (this.c && z3) {
            d(str2, treeMap).append((CharSequence) this.b);
        } else if ("br".equals(str3) && z3) {
            d(str2, treeMap).append('\n');
        } else if (e(j2)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                hashMap.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
            }
            boolean equals = "p".equals(str3);
            int i3 = 0;
            while (true) {
                ArrayList arrayList = this.f4241l;
                if (arrayList == null) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                if (i3 >= size) {
                    break;
                }
                d b = b(i3);
                if (!z3 && !equals) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                b.h(j2, z5, str2, treeMap);
                i3++;
            }
            if (equals) {
                SpannableStringBuilder d = d(str2, treeMap);
                int length = d.length() - 1;
                while (length >= 0 && d.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && d.charAt(length) != '\n') {
                    d.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                hashMap2.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
            }
        }
    }
}
