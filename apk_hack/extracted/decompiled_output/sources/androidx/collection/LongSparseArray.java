package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i3 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            Object obj = objArr[i6];
            if (obj != DELETED) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.mGarbage = false;
        this.mSize = i5;
    }

    public void append(long j2, E e5) {
        int i3 = this.mSize;
        if (i3 != 0 && j2 <= this.mKeys[i3 - 1]) {
            put(j2, e5);
            return;
        }
        if (this.mGarbage && i3 >= this.mKeys.length) {
            gc();
        }
        int i5 = this.mSize;
        if (i5 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i5 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i5] = j2;
        this.mValues[i5] = e5;
        this.mSize = i5 + 1;
    }

    public void clear() {
        int i3 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i5 = 0; i5 < i3; i5++) {
            objArr[i5] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j2) {
        if (indexOfKey(j2) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e5) {
        if (indexOfValue(e5) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void delete(long j2) {
        remove(j2);
    }

    @Nullable
    public E get(long j2) {
        return get(j2, null);
    }

    public int indexOfKey(long j2) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
    }

    public int indexOfValue(E e5) {
        if (this.mGarbage) {
            gc();
        }
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (this.mValues[i3] == e5) {
                return i3;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public long keyAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i3];
    }

    public void put(long j2, E e5) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e5;
            return;
        }
        int i3 = ~binarySearch;
        int i5 = this.mSize;
        if (i3 < i5) {
            Object[] objArr = this.mValues;
            if (objArr[i3] == DELETED) {
                this.mKeys[i3] = j2;
                objArr[i3] = e5;
                return;
            }
        }
        if (this.mGarbage && i5 >= this.mKeys.length) {
            gc();
            i3 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        }
        int i6 = this.mSize;
        if (i6 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i6 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i7 = this.mSize;
        if (i7 - i3 != 0) {
            long[] jArr3 = this.mKeys;
            int i8 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i8, i7 - i3);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i3, objArr4, i8, this.mSize - i3);
        }
        this.mKeys[i3] = j2;
        this.mValues[i3] = e5;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            put(longSparseArray.keyAt(i3), longSparseArray.valueAt(i3));
        }
    }

    @Nullable
    public E putIfAbsent(long j2, E e5) {
        E e6 = get(j2);
        if (e6 == null) {
            put(j2, e5);
        }
        return e6;
    }

    public void remove(long j2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAt(int i3) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i3];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j2, E e5) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey >= 0) {
            Object[] objArr = this.mValues;
            E e6 = (E) objArr[indexOfKey];
            objArr[indexOfKey] = e5;
            return e6;
        }
        return null;
    }

    public void setValueAt(int i3, E e5) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i3] = e5;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i3));
            sb.append('=');
            E valueAt = valueAt(i3);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i3];
    }

    public LongSparseArray(int i3) {
        this.mGarbage = false;
        if (i3 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
    }

    /* renamed from: clone */
    public LongSparseArray<E> m0clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public E get(long j2, E e5) {
        E e6;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        return (binarySearch < 0 || (e6 = (E) this.mValues[binarySearch]) == DELETED) ? e5 : e6;
    }

    public boolean replace(long j2, E e5, E e6) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey >= 0) {
            Object obj = this.mValues[indexOfKey];
            if (obj == e5 || (e5 != null && e5.equals(obj))) {
                this.mValues[indexOfKey] = e6;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean remove(long j2, Object obj) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey >= 0) {
            E valueAt = valueAt(indexOfKey);
            if (obj == valueAt || (obj != null && obj.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }
}
