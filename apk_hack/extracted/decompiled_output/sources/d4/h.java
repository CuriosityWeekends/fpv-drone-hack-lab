package d4;

import android.content.res.Resources;
import android.os.Environment;
import android.util.TypedValue;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class h {
    static {
        new File(Environment.getRootDirectory(), "build.prop");
    }

    public static int a(int i3) {
        return (int) TypedValue.applyDimension(1, i3, Resources.getSystem().getDisplayMetrics());
    }
}
