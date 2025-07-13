package androidx.recyclerview.widget;

import a1.i;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i3, int i5) {
            this.mBatchingListUpdateCallback.onChanged(i3, i5, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i3, int i5) {
            this.mBatchingListUpdateCallback.onInserted(i3, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i3, int i5) {
            this.mBatchingListUpdateCallback.onMoved(i3, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i3, int i5) {
            this.mBatchingListUpdateCallback.onRemoved(i3, i5);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i3, int i5, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i3, i5, obj);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i3, int i5);

        public void onChanged(int i3, int i5, Object obj) {
            onChanged(i3, i5);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = sortAndDedup;
            this.mCallback.onInserted(0, sortAndDedup);
            return;
        }
        merge(tArr, sortAndDedup);
    }

    private void addToData(int i3, T t4) {
        int i5 = this.mSize;
        if (i3 <= i5) {
            T[] tArr = this.mData;
            if (i5 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                System.arraycopy(this.mData, 0, tArr2, 0, i3);
                tArr2[i3] = t4;
                System.arraycopy(this.mData, i3, tArr2, i3 + 1, this.mSize - i3);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i3, tArr, i3 + 1, i5 - i3);
                this.mData[i3] = t4;
            }
            this.mSize++;
            return;
        }
        StringBuilder m5 = i.m("cannot add item to ", i3, " because size is ");
        m5.append(this.mSize);
        throw new IndexOutOfBoundsException(m5.toString());
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t4, T[] tArr, int i3, int i5, int i6) {
        while (i3 < i5) {
            int i7 = (i3 + i5) / 2;
            T t5 = tArr[i7];
            int compare = this.mCallback.compare(t5, t4);
            if (compare < 0) {
                i3 = i7 + 1;
            } else if (compare == 0) {
                if (this.mCallback.areItemsTheSame(t5, t4)) {
                    return i7;
                }
                int linearEqualitySearch = linearEqualitySearch(t4, i7, i3, i5);
                if (i6 == 1) {
                    if (linearEqualitySearch != -1) {
                        return linearEqualitySearch;
                    }
                    return i7;
                }
                return linearEqualitySearch;
            } else {
                i5 = i7;
            }
        }
        if (i6 != 1) {
            return -1;
        }
        return i3;
    }

    private int findSameItem(T t4, T[] tArr, int i3, int i5) {
        while (i3 < i5) {
            if (this.mCallback.areItemsTheSame(tArr[i3], t4)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t4, int i3, int i5, int i6) {
        T t5;
        for (int i7 = i3 - 1; i7 >= i5; i7--) {
            T t6 = this.mData[i7];
            if (this.mCallback.compare(t6, t4) != 0) {
                break;
            } else if (this.mCallback.areItemsTheSame(t6, t4)) {
                return i7;
            }
        }
        do {
            i3++;
            if (i3 < i6) {
                t5 = this.mData[i3];
                if (this.mCallback.compare(t5, t4) != 0) {
                    return -1;
                }
            } else {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t5, t4));
        return i3;
    }

    private void merge(T[] tArr, int i3) {
        boolean z3 = !(this.mCallback instanceof BatchedCallback);
        if (z3) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i5 = 0;
        this.mOldDataStart = 0;
        int i6 = this.mSize;
        this.mOldDataSize = i6;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i6 + i3 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i7 = this.mOldDataStart;
            int i8 = this.mOldDataSize;
            if (i7 >= i8 && i5 >= i3) {
                break;
            } else if (i7 == i8) {
                int i9 = i3 - i5;
                System.arraycopy(tArr, i5, this.mData, this.mNewDataStart, i9);
                int i10 = this.mNewDataStart + i9;
                this.mNewDataStart = i10;
                this.mSize += i9;
                this.mCallback.onInserted(i10 - i9, i9);
                break;
            } else if (i5 == i3) {
                int i11 = i8 - i7;
                System.arraycopy(this.mOldData, i7, this.mData, this.mNewDataStart, i11);
                this.mNewDataStart += i11;
                break;
            } else {
                T t4 = this.mOldData[i7];
                T t5 = tArr[i5];
                int compare = this.mCallback.compare(t4, t5);
                if (compare > 0) {
                    T[] tArr2 = this.mData;
                    int i12 = this.mNewDataStart;
                    this.mNewDataStart = i12 + 1;
                    tArr2[i12] = t5;
                    this.mSize++;
                    i5++;
                    this.mCallback.onInserted(i12, 1);
                } else if (compare == 0 && this.mCallback.areItemsTheSame(t4, t5)) {
                    T[] tArr3 = this.mData;
                    int i13 = this.mNewDataStart;
                    this.mNewDataStart = i13 + 1;
                    tArr3[i13] = t5;
                    i5++;
                    this.mOldDataStart++;
                    if (!this.mCallback.areContentsTheSame(t4, t5)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                    }
                } else {
                    T[] tArr4 = this.mData;
                    int i14 = this.mNewDataStart;
                    this.mNewDataStart = i14 + 1;
                    tArr4[i14] = t4;
                    this.mOldDataStart++;
                }
            }
        }
        this.mOldData = null;
        if (z3) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i3, boolean z3) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i3 + 1, tArr, i3, (this.mSize - i3) - 1);
        int i5 = this.mSize - 1;
        this.mSize = i5;
        this.mData[i5] = null;
        if (z3) {
            this.mCallback.onRemoved(i3, 1);
        }
    }

    private void replaceAllInsert(T t4) {
        T[] tArr = this.mData;
        int i3 = this.mNewDataStart;
        tArr[i3] = t4;
        this.mNewDataStart = i3 + 1;
        this.mSize++;
        this.mCallback.onInserted(i3, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z3 = !(this.mCallback instanceof BatchedCallback);
        if (z3) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
        while (true) {
            int i3 = this.mNewDataStart;
            if (i3 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 >= i6) {
                int i7 = sortAndDedup - i3;
                System.arraycopy(tArr, i3, this.mData, i3, i7);
                this.mNewDataStart += i7;
                this.mSize += i7;
                this.mCallback.onInserted(i3, i7);
                break;
            } else if (i3 >= sortAndDedup) {
                int i8 = i6 - i5;
                this.mSize -= i8;
                this.mCallback.onRemoved(i3, i8);
                break;
            } else {
                T t4 = this.mOldData[i5];
                T t5 = tArr[i3];
                int compare = this.mCallback.compare(t4, t5);
                if (compare < 0) {
                    replaceAllRemove();
                } else if (compare > 0) {
                    replaceAllInsert(t5);
                } else if (!this.mCallback.areItemsTheSame(t4, t5)) {
                    replaceAllRemove();
                    replaceAllInsert(t5);
                } else {
                    T[] tArr2 = this.mData;
                    int i9 = this.mNewDataStart;
                    tArr2[i9] = t5;
                    this.mOldDataStart++;
                    this.mNewDataStart = i9 + 1;
                    if (!this.mCallback.areContentsTheSame(t4, t5)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                    }
                }
            }
        }
        this.mOldData = null;
        if (z3) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i3 = 1;
        int i5 = 0;
        for (int i6 = 1; i6 < tArr.length; i6++) {
            T t4 = tArr[i6];
            if (this.mCallback.compare(tArr[i5], t4) == 0) {
                int findSameItem = findSameItem(t4, tArr, i5, i3);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t4;
                } else {
                    if (i3 != i6) {
                        tArr[i3] = t4;
                    }
                    i3++;
                }
            } else {
                if (i3 != i6) {
                    tArr[i3] = t4;
                }
                i5 = i3;
                i3++;
            }
        }
        return i3;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
            return;
        }
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T t4) {
        throwIfInMutationOperation();
        return add(t4, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z3) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z3) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i3 = this.mSize;
        if (i3 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i3, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i3);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i3) {
        int i5;
        if (i3 < this.mSize && i3 >= 0) {
            T[] tArr = this.mOldData;
            if (tArr != null && i3 >= (i5 = this.mNewDataStart)) {
                return tArr[(i3 - i5) + this.mOldDataStart];
            }
            return this.mData[i3];
        }
        StringBuilder m5 = i.m("Asked to get item at ", i3, " but size is ");
        m5.append(this.mSize);
        throw new IndexOutOfBoundsException(m5.toString());
    }

    public int indexOf(T t4) {
        if (this.mOldData != null) {
            int findIndexOf = findIndexOf(t4, this.mData, 0, this.mNewDataStart, 4);
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t4, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 == -1) {
                return -1;
            }
            return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return findIndexOf(t4, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i3) {
        throwIfInMutationOperation();
        T t4 = get(i3);
        removeItemAtIndex(i3, false);
        int add = add(t4, false);
        if (i3 != add) {
            this.mCallback.onMoved(i3, add);
        }
    }

    public boolean remove(T t4) {
        throwIfInMutationOperation();
        return remove(t4, true);
    }

    public T removeItemAt(int i3) {
        throwIfInMutationOperation();
        T t4 = get(i3);
        removeItemAtIndex(i3, true);
        return t4;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z3) {
        throwIfInMutationOperation();
        if (z3) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i3, T t4) {
        boolean z3;
        throwIfInMutationOperation();
        T t5 = get(i3);
        if (t5 != t4 && this.mCallback.areContentsTheSame(t5, t4)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (t5 != t4 && this.mCallback.compare(t5, t4) == 0) {
            this.mData[i3] = t4;
            if (z3) {
                Callback callback = this.mCallback;
                callback.onChanged(i3, 1, callback.getChangePayload(t5, t4));
                return;
            }
            return;
        }
        if (z3) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i3, 1, callback2.getChangePayload(t5, t4));
        }
        removeItemAtIndex(i3, false);
        int add = add(t4, false);
        if (i3 != add) {
            this.mCallback.onMoved(i3, add);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i3) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i3));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t4, boolean z3) {
        int findIndexOf = findIndexOf(t4, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t5 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t5, t4)) {
                if (this.mCallback.areContentsTheSame(t5, t4)) {
                    this.mData[findIndexOf] = t4;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t4;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t5, t4));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t4);
        if (z3) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t4, boolean z3) {
        int findIndexOf = findIndexOf(t4, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z3);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
