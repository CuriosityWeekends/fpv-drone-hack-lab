package j1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements s1.e {

    /* renamed from: a  reason: collision with root package name */
    public Object f2371a;
    public Object b;
    public Object c;
    public final Object d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2372e;

    public a0(y1.d dVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f2371a = dVar;
        this.d = hashMap2;
        this.f2372e = hashMap3;
        this.c = Collections.unmodifiableMap(hashMap);
        dVar.getClass();
        TreeSet treeSet = new TreeSet();
        int i3 = 0;
        dVar.c(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i3] = ((Long) it.next()).longValue();
            i3++;
        }
        this.b = jArr;
    }

    @Override // s1.e
    public int b(long j2) {
        long[] jArr = (long[]) this.b;
        int b = g2.w.b(jArr, j2, false, false);
        if (b >= jArr.length) {
            return -1;
        }
        return b;
    }

    @Override // s1.e
    public long e(int i3) {
        return ((long[]) this.b)[i3];
    }

    @Override // s1.e
    public List i(long j2) {
        Map map;
        int i3;
        int i5;
        int i6;
        y1.d dVar = (y1.d) this.f2371a;
        dVar.getClass();
        ArrayList arrayList = new ArrayList();
        dVar.f(j2, dVar.f4237h, arrayList);
        TreeMap treeMap = new TreeMap();
        dVar.h(j2, false, dVar.f4237h, treeMap);
        dVar.g(j2, (Map) this.c, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            map = (Map) this.d;
            i3 = 0;
            if (!hasNext) {
                break;
            }
            Pair pair = (Pair) it.next();
            String str = (String) ((Map) this.f2372e).get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                y1.e eVar = (y1.e) map.get(pair.first);
                arrayList2.add(new s1.b(decodeByteArray, eVar.b, eVar.c, eVar.f4243e, eVar.f4244f, eVar.f4245g));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            y1.e eVar2 = (y1.e) map.get(entry.getKey());
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
            int length = spannableStringBuilder.length();
            for (int i7 = 0; i7 < length; i7++) {
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    int i8 = i7 + 1;
                    int i9 = i8;
                    while (i9 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i9) == ' ') {
                        i9++;
                    }
                    int i10 = i9 - i8;
                    if (i10 > 0) {
                        spannableStringBuilder.delete(i7, i7 + i10);
                        length -= i10;
                    }
                }
            }
            if (length > 0 && spannableStringBuilder.charAt(i3) == ' ') {
                spannableStringBuilder.delete(i3, 1);
                length--;
            }
            int i11 = 0;
            while (true) {
                i5 = length - 1;
                if (i11 >= i5) {
                    break;
                }
                if (spannableStringBuilder.charAt(i11) == '\n') {
                    int i12 = i11 + 1;
                    if (spannableStringBuilder.charAt(i12) == ' ') {
                        spannableStringBuilder.delete(i12, i11 + 2);
                        length--;
                    }
                }
                i11++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i5) == ' ') {
                spannableStringBuilder.delete(i5, length);
                length--;
            }
            int i13 = 0;
            while (true) {
                i6 = length - 1;
                if (i13 >= i6) {
                    break;
                }
                if (spannableStringBuilder.charAt(i13) == ' ') {
                    int i14 = i13 + 1;
                    if (spannableStringBuilder.charAt(i14) == '\n') {
                        spannableStringBuilder.delete(i13, i14);
                        length--;
                    }
                }
                i13++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i6) == '\n') {
                spannableStringBuilder.delete(i6, length);
            }
            arrayList2.add(new s1.b(spannableStringBuilder, null, null, eVar2.c, eVar2.d, eVar2.f4243e, eVar2.b, Integer.MIN_VALUE, eVar2.f4246h, eVar2.f4247i, eVar2.f4244f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK));
            i3 = 0;
        }
        return arrayList2;
    }

    @Override // s1.e
    public int n() {
        return ((long[]) this.b).length;
    }

    public a0() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.d = cryptoInfo;
        this.f2372e = g2.w.f1960a >= 24 ? new c1.b(cryptoInfo) : null;
    }

    public a0(p0.r rVar, TrackGroupArray trackGroupArray, boolean[] zArr) {
        this.f2371a = rVar;
        this.b = trackGroupArray;
        this.c = zArr;
        int i3 = trackGroupArray.f385a;
        this.d = new boolean[i3];
        this.f2372e = new boolean[i3];
    }
}
