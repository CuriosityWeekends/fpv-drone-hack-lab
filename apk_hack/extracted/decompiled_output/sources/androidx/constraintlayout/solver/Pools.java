package androidx.constraintlayout.solver;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T t4);

        void releaseAll(T[] tArr, int i3);
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

        private boolean isInPool(T t4) {
            for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                if (this.mPool[i3] == t4) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t4) {
            int i3 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i3 < objArr.length) {
                objArr[i3] = t4;
                this.mPoolSize = i3 + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i3) {
            if (i3 > tArr.length) {
                i3 = tArr.length;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                T t4 = tArr[i5];
                int i6 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i6 < objArr.length) {
                    objArr[i6] = t4;
                    this.mPoolSize = i6 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
