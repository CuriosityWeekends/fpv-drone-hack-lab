package o1;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import g2.u;
import java.io.EOFException;
import java.util.Collections;
import java.util.List;
import y0.a0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements h {
    public static g a(p0.j jVar) {
        boolean z3;
        boolean z5 = true;
        if (!(jVar instanceof y0.d) && !(jVar instanceof y0.a) && !(jVar instanceof y0.c) && !(jVar instanceof u0.c)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!(jVar instanceof a0) && !(jVar instanceof v0.k)) {
            z5 = false;
        }
        return new g(jVar, z3, z5);
    }

    public static v0.k b(Format format, u uVar, List list) {
        boolean z3;
        int i3;
        Metadata metadata = format.f309g;
        if (metadata != null) {
            int i5 = 0;
            while (true) {
                Metadata.Entry[] entryArr = metadata.f330a;
                if (i5 >= entryArr.length) {
                    break;
                }
                Metadata.Entry entry = entryArr[i5];
                if (entry instanceof HlsTrackMetadataEntry) {
                    z3 = !((HlsTrackMetadataEntry) entry).c.isEmpty();
                    break;
                }
                i5++;
            }
        }
        z3 = false;
        if (z3) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return new v0.k(i3, uVar, null, list, null);
    }

    public static a0 c(Format format, u uVar, List list) {
        int i3;
        if (list != null) {
            i3 = 48;
        } else {
            list = Collections.singletonList(Format.q(null, "application/cea-608", 0, null, -1, null, Long.MAX_VALUE, Collections.emptyList()));
            i3 = 16;
        }
        String str = format.f308f;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(g2.k.a(str))) {
                i3 |= 2;
            }
            if (!"video/avc".equals(g2.k.f(str))) {
                i3 |= 4;
            }
        }
        return new a0(2, uVar, new h2.c(i3, list));
    }

    public static boolean d(p0.j jVar, p0.g gVar) {
        try {
            return jVar.f(gVar);
        } catch (EOFException unused) {
            return false;
        } finally {
            gVar.f3111f = 0;
        }
    }
}
