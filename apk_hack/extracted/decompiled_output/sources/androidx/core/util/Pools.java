package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Pools {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t4);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i3) {
            if (i3 > 0) {
                this.mPool = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T t4) {
            for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                if (this.mPool[i3] == t4) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i3 = this.mPoolSize;
            if (i3 <= 0) {
                return null;
            }
            int i5 = i3 - 1;
            Object[] objArr = this.mPool;
            T t4 = (T) objArr[i5];
            objArr[i5] = null;
            this.mPoolSize = i3 - 1;
            return t4;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t4) {
            if (!isInPool(t4)) {
                int i3 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i3 < objArr.length) {
                    objArr[i3] = t4;
                    this.mPoolSize = i3 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i3) {
            super(i3);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t4;
            synchronized (this.mLock) {
                t4 = (T) super.acquire();
            }
            return t4;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t4) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t4);
            }
            return release;
        }
    }

    private Pools() {
    }
}
