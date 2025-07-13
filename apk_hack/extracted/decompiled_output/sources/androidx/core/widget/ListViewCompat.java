package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView listView, int i3) {
        return listView.canScrollList(i3);
    }

    public static void scrollListBy(@NonNull ListView listView, int i3) {
        listView.scrollListBy(i3);
    }
}
