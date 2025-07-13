package g2;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f1924a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1925e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1926f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1927g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1928h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1929i;

    /* renamed from: j  reason: collision with root package name */
    public final long f1930j;

    /* renamed from: k  reason: collision with root package name */
    public final c1.b f1931k;

    /* renamed from: l  reason: collision with root package name */
    public final Metadata f1932l;

    public i(byte[] bArr, int i3) {
        n nVar = new n(bArr, bArr.length);
        nVar.l(i3 * 8);
        this.f1924a = nVar.g(16);
        this.b = nVar.g(16);
        this.c = nVar.g(24);
        this.d = nVar.g(24);
        int g5 = nVar.g(20);
        this.f1925e = g5;
        this.f1926f = e(g5);
        this.f1927g = nVar.g(3) + 1;
        int g6 = nVar.g(5) + 1;
        this.f1928h = g6;
        this.f1929i = b(g6);
        int g7 = nVar.g(4);
        int g8 = nVar.g(32);
        int i5 = w.f1960a;
        this.f1930j = ((g7 & 4294967295L) << 32) | (g8 & 4294967295L);
        this.f1931k = null;
        this.f1932l = null;
    }

    public static Metadata a(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = (String) list.get(i3);
            int i5 = w.f1960a;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                Log.w("FlacStreamMetadata", "Failed to parse Vorbis comment: ".concat(str));
            } else {
                arrayList.add(new VorbisComment(split[0], split[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static int b(int i3) {
        if (i3 != 8) {
            if (i3 != 12) {
                if (i3 != 16) {
                    if (i3 != 20) {
                        if (i3 != 24) {
                            return -1;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static int e(int i3) {
        switch (i3) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long c() {
        long j2 = this.f1930j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / this.f1925e;
    }

    public final Format d(byte[] bArr, Metadata metadata) {
        int i3;
        Metadata metadata2;
        bArr[4] = Byte.MIN_VALUE;
        int i5 = this.d;
        if (i5 > 0) {
            i3 = i5;
        } else {
            i3 = -1;
        }
        Metadata metadata3 = this.f1932l;
        if (metadata3 == null) {
            metadata2 = metadata;
        } else {
            if (metadata != null) {
                Metadata.Entry[] entryArr = metadata.f330a;
                if (entryArr.length != 0) {
                    int i6 = w.f1960a;
                    Metadata.Entry[] entryArr2 = metadata3.f330a;
                    Object[] copyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
                    System.arraycopy(entryArr, 0, copyOf, entryArr2.length, entryArr.length);
                    metadata3 = new Metadata((Metadata.Entry[]) copyOf);
                }
            }
            metadata2 = metadata3;
        }
        int i7 = this.f1928h;
        int i8 = this.f1925e;
        int i9 = this.f1927g;
        return Format.j(null, "audio/flac", i7 * i8 * i9, i3, i9, i8, -1, 0, 0, Collections.singletonList(bArr), null, 0, null, metadata2);
    }

    public i(int i3, int i5, int i6, int i7, int i8, int i9, int i10, long j2, c1.b bVar, Metadata metadata) {
        this.f1924a = i3;
        this.b = i5;
        this.c = i6;
        this.d = i7;
        this.f1925e = i8;
        this.f1926f = e(i8);
        this.f1927g = i9;
        this.f1928h = i10;
        this.f1929i = b(i10);
        this.f1930j = j2;
        this.f1931k = bVar;
        this.f1932l = metadata;
    }
}
