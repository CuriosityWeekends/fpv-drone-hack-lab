package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i3 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            Object obj = objArr[i6];
            if (obj != DELETED) {
                if (i6 != i5) {
                    iArr[i5] = iArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.mGarbage = false;
        this.mSize = i5;
    }

    public void append(int i3, E e5) {
        int i5 = this.mSize;
        if (i5 != 0 && i3 <= this.mKeys[i5 - 1]) {
            put(i3, e5);
            return;
        }
        if (this.mGarbage && i5 >= this.mKeys.length) {
            gc();
        }
        int i6 = this.mSize;
        if (i6 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i6 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i6] = i3;
        this.mValues[i6] = e5;
        this.mSize = i6 + 1;
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

    public boolean containsKey(int i3) {
        if (indexOfKey(i3) >= 0) {
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
    public void delete(int i3) {
        remove(i3);
    }

    @Nullable
    public E get(int i3) {
        return get(i3, null);
    }

    public int indexOfKey(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
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

    public int keyAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i3];
    }

    public void put(int i3, E e5) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e5;
            return;
        }
        int i5 = ~binarySearch;
        int i6 = this.mSize;
        if (i5 < i6) {
            Object[] objArr = this.mValues;
            if (objArr[i5] == DELETED) {
                this.mKeys[i5] = i3;
                objArr[i5] = e5;
                return;
            }
        }
        if (this.mGarbage && i6 >= this.mKeys.length) {
            gc();
            i5 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
        }
        int i7 = this.mSize;
        if (i7 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i7 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i8 = this.mSize;
        if (i8 - i5 != 0) {
            int[] iArr3 = this.mKeys;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i5, objArr4, i9, this.mSize - i5);
        }
        this.mKeys[i5] = i3;
        this.mValues[i5] = e5;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i3 = 0; i3 < size; i3++) {
            put(sparseArrayCompat.keyAt(i3), sparseArrayCompat.valueAt(i3));
        }
    }

    @Nullable
    public E putIfAbsent(int i3, E e5) {
        E e6 = get(i3);
        if (e6 == null) {
            put(i3, e5);
        }
        return e6;
    }

    public void remove(int i3) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
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

    public void removeAtRange(int i3, int i5) {
        int min = Math.min(this.mSize, i5 + i3);
        while (i3 < min) {
            removeAt(i3);
            i3++;
        }
    }

    @Nullable
    public E replace(int i3, E e5) {
        int indexOfKey = indexOfKey(i3);
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

    public SparseArrayCompat(int i3) {
        this.mGarbage = false;
        if (i3 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m1clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public E get(int i3, E e5) {
        E e6;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
        return (binarySearch < 0 || (e6 = (E) this.mValues[binarySearch]) == DELETED) ? e5 : e6;
    }

    public boolean replace(int i3, E e5, E e6) {
        int indexOfKey = indexOfKey(i3);
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

    public boolean remove(int i3, Object obj) {
        int indexOfKey = indexOfKey(i3);
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
