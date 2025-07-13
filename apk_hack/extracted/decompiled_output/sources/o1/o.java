package o1;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import j1.i0;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends i0 {
    public final Map E;
    public DrmInitData F;

    public o(e2.m mVar, n0.b bVar, Map map) {
        super(mVar, bVar);
        this.E = map;
    }

    @Override // j1.i0
    public final Format n(Format format) {
        DrmInitData drmInitData;
        DrmInitData drmInitData2 = this.F;
        if (drmInitData2 == null) {
            drmInitData2 = format.f314l;
        }
        if (drmInitData2 != null && (drmInitData = (DrmInitData) this.E.get(drmInitData2.c)) != null) {
            drmInitData2 = drmInitData;
        }
        Metadata metadata = format.f309g;
        Metadata metadata2 = null;
        if (metadata != null) {
            Metadata.Entry[] entryArr = metadata.f330a;
            int length = entryArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    Metadata.Entry entry = entryArr[i3];
                    if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).b)) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                if (length != 1) {
                    Metadata.Entry[] entryArr2 = new Metadata.Entry[length - 1];
                    for (int i5 = 0; i5 < length; i5++) {
                        if (i5 != i3) {
                            entryArr2[i5 < i3 ? i5 : i5 - 1] = entryArr[i5];
                        }
                    }
                    metadata2 = new Metadata(entryArr2);
                }
            }
            return super.n(format.c(drmInitData2, metadata));
        }
        metadata = metadata2;
        return super.n(format.c(drmInitData2, metadata));
    }
}
