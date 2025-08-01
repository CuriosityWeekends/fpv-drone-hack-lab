package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class PathUtils {
    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f4) {
        float[] approximate;
        approximate = path.approximate(f4);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 1; i3 < length; i3++) {
            int i5 = i3 * 3;
            int i6 = (i3 - 1) * 3;
            float f5 = approximate[i5];
            float f6 = approximate[i5 + 1];
            float f7 = approximate[i5 + 2];
            float f8 = approximate[i6];
            float f9 = approximate[i6 + 1];
            float f10 = approximate[i6 + 2];
            if (f5 != f8 && (f6 != f9 || f7 != f10)) {
                arrayList.add(new PathSegment(new PointF(f9, f10), f8, new PointF(f6, f7), f5));
            }
        }
        return arrayList;
    }
}
