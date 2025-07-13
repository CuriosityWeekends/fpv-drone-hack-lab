package b2;

import com.google.android.exoplayer2.Format;
import com.lg.picturesubmitt.model.EntityVideo;
import com.lg.picturesubmitt.model.PhotoInfo;
import java.io.File;
import java.util.Comparator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f138a;

    public /* synthetic */ c(int i3) {
        this.f138a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f138a) {
            case 0:
                return ((Format) obj2).f307e - ((Format) obj).f307e;
            case 1:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 2:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 3:
                int i3 = ((((PhotoInfo) obj2).value - ((PhotoInfo) obj).value) > 0L ? 1 : ((((PhotoInfo) obj2).value - ((PhotoInfo) obj).value) == 0L ? 0 : -1));
                if (i3 > 0) {
                    return 1;
                }
                if (i3 < 0) {
                    return -1;
                }
                return 0;
            default:
                int i5 = ((((EntityVideo) obj2).value - ((EntityVideo) obj).value) > 0L ? 1 : ((((EntityVideo) obj2).value - ((EntityVideo) obj).value) == 0L ? 0 : -1));
                if (i5 > 0) {
                    return 1;
                }
                if (i5 < 0) {
                    return -1;
                }
                return 0;
        }
    }
}
