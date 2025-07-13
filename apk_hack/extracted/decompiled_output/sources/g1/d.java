package g1;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f1904a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final long f1905e;

    /* renamed from: f  reason: collision with root package name */
    public final List f1906f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1907g;

    /* renamed from: h  reason: collision with root package name */
    public final long f1908h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1909i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1910j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1911k;

    public d(long j2, boolean z3, boolean z5, boolean z6, ArrayList arrayList, long j5, boolean z7, long j6, int i3, int i5, int i6) {
        this.f1904a = j2;
        this.b = z3;
        this.c = z5;
        this.d = z6;
        this.f1906f = Collections.unmodifiableList(arrayList);
        this.f1905e = j5;
        this.f1907g = z7;
        this.f1908h = j6;
        this.f1909i = i3;
        this.f1910j = i5;
        this.f1911k = i6;
    }

    public d(Parcel parcel) {
        this.f1904a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new c(parcel.readInt(), parcel.readLong()));
        }
        this.f1906f = Collections.unmodifiableList(arrayList);
        this.f1905e = parcel.readLong();
        this.f1907g = parcel.readByte() == 1;
        this.f1908h = parcel.readLong();
        this.f1909i = parcel.readInt();
        this.f1910j = parcel.readInt();
        this.f1911k = parcel.readInt();
    }
}
