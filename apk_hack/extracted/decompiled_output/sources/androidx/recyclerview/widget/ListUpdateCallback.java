package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i3, int i5, @Nullable Object obj);

    void onInserted(int i3, int i5);

    void onMoved(int i3, int i5);

    void onRemoved(int i3, int i5);
}
