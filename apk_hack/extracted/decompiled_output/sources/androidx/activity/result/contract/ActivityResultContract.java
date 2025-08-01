package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class SynchronousResult<T> {
        @SuppressLint({"UnknownNullness"})
        private final T mValue;

        public SynchronousResult(@SuppressLint({"UnknownNullness"}) T t4) {
            this.mValue = t4;
        }

        @SuppressLint({"UnknownNullness"})
        public T getValue() {
            return this.mValue;
        }
    }

    @NonNull
    public abstract Intent createIntent(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i3);

    @Nullable
    public SynchronousResult<O> getSynchronousResult(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i3) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O parseResult(int i3, @Nullable Intent intent);
}
