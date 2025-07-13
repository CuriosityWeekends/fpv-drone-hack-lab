package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class ViewModel {
    @Nullable
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                try {
                    for (Object obj : this.mBagOfTags.values()) {
                        closeWithRuntimeException(obj);
                    }
                } finally {
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t4;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t4 = (T) this.mBagOfTags.get(str);
        }
        return t4;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String str, T t4) {
        Object obj;
        synchronized (this.mBagOfTags) {
            try {
                obj = this.mBagOfTags.get(str);
                if (obj == null) {
                    this.mBagOfTags.put(str, t4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            t4 = obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t4);
        }
        return t4;
    }
}
