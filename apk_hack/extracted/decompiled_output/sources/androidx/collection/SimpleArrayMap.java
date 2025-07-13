package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i3) {
        if (i3 == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i3];
        this.mArray = new Object[i3 << 1];
    }

    private static int binarySearchHashes(int[] iArr, int i3, int i5) {
        try {
            return ContainerHelpers.binarySearch(iArr, i3, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i6 = (i3 << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    public void clear() {
        int i3 = this.mSize;
        if (i3 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i3);
        }
        if (this.mSize <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(@Nullable Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i3) {
        int i5 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i3) {
            Object[] objArr = this.mArray;
            allocArrays(i3);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i5);
                System.arraycopy(objArr, 0, this.mArray, 0, i5 << 1);
            }
            freeArrays(iArr, objArr, i5);
        }
        if (this.mSize == i5) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    K keyAt = keyAt(i3);
                    V valueAt = valueAt(i3);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.mSize; i5++) {
                try {
                    K keyAt2 = keyAt(i5);
                    V valueAt2 = valueAt(i5);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v5) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.mArray[(indexOfKey << 1) + 1];
        }
        return v5;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i3 = this.mSize;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i3) {
            Object obj = objArr[i5];
            int i8 = iArr[i6];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i7 += hashCode ^ i8;
            i6++;
            i5 += 2;
        }
        return i7;
    }

    public int indexOf(Object obj, int i3) {
        int i5 = this.mSize;
        if (i5 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i5, i3);
        if (binarySearchHashes < 0) {
            return binarySearchHashes;
        }
        if (obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i6 = binarySearchHashes + 1;
        while (i6 < i5 && this.mHashes[i6] == i3) {
            if (obj.equals(this.mArray[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = binarySearchHashes - 1; i7 >= 0 && this.mHashes[i7] == i3; i7--) {
            if (obj.equals(this.mArray[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public int indexOfKey(@Nullable Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj, obj.hashCode());
    }

    public int indexOfNull() {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i3, 0);
        if (binarySearchHashes < 0) {
            return binarySearchHashes;
        }
        if (this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i5 = binarySearchHashes + 1;
        while (i5 < i3 && this.mHashes[i5] == 0) {
            if (this.mArray[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = binarySearchHashes - 1; i6 >= 0 && this.mHashes[i6] == 0; i6--) {
            if (this.mArray[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public int indexOfValue(Object obj) {
        int i3 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i5 = 1; i5 < i3; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i3; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i3) {
        return (K) this.mArray[i3 << 1];
    }

    @Nullable
    public V put(K k5, V v5) {
        int i3;
        int indexOf;
        int i5 = this.mSize;
        if (k5 == null) {
            indexOf = indexOfNull();
            i3 = 0;
        } else {
            int hashCode = k5.hashCode();
            i3 = hashCode;
            indexOf = indexOf(k5, hashCode);
        }
        if (indexOf >= 0) {
            int i6 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v6 = (V) objArr[i6];
            objArr[i6] = v5;
            return v6;
        }
        int i7 = ~indexOf;
        int[] iArr = this.mHashes;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i8);
            if (i5 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                }
                freeArrays(iArr, objArr2, i5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr3 = this.mHashes;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.mSize - i7) << 1);
        }
        int i10 = this.mSize;
        if (i5 == i10) {
            int[] iArr4 = this.mHashes;
            if (i7 < iArr4.length) {
                iArr4[i7] = i3;
                Object[] objArr4 = this.mArray;
                int i11 = i7 << 1;
                objArr4[i11] = k5;
                objArr4[i11 + 1] = v5;
                this.mSize = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i3 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i3);
        if (this.mSize == 0) {
            if (i3 > 0) {
                System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i3);
                System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i3 << 1);
                this.mSize = i3;
                return;
            }
            return;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            put(simpleArrayMap.keyAt(i5), simpleArrayMap.valueAt(i5));
        }
    }

    @Nullable
    public V putIfAbsent(K k5, V v5) {
        V v6 = get(k5);
        if (v6 == null) {
            return put(k5, v5);
        }
        return v6;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i3) {
        Object[] objArr = this.mArray;
        int i5 = i3 << 1;
        V v5 = (V) objArr[i5 + 1];
        int i6 = this.mSize;
        int i7 = 0;
        if (i6 <= 1) {
            freeArrays(this.mHashes, objArr, i6);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.mHashes;
            int i9 = 8;
            if (iArr.length > 8 && i6 < iArr.length / 3) {
                if (i6 > 8) {
                    i9 = i6 + (i6 >> 1);
                }
                allocArrays(i9);
                if (i6 == this.mSize) {
                    if (i3 > 0) {
                        System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                        System.arraycopy(objArr, 0, this.mArray, 0, i5);
                    }
                    if (i3 < i8) {
                        int i10 = i3 + 1;
                        int i11 = i8 - i3;
                        System.arraycopy(iArr, i10, this.mHashes, i3, i11);
                        System.arraycopy(objArr, i10 << 1, this.mArray, i5, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i3 < i8) {
                    int i12 = i3 + 1;
                    int i13 = i8 - i3;
                    System.arraycopy(iArr, i12, iArr, i3, i13);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i12 << 1, objArr2, i5, i13 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i14 = i8 << 1;
                objArr3[i14] = null;
                objArr3[i14 + 1] = null;
            }
            i7 = i8;
        }
        if (i6 == this.mSize) {
            this.mSize = i7;
            return v5;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k5, V v5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v5);
        }
        return null;
    }

    public V setValueAt(int i3, V v5) {
        int i5 = (i3 << 1) + 1;
        Object[] objArr = this.mArray;
        V v6 = (V) objArr[i5];
        objArr[i5] = v5;
        return v6;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i3);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i3);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i3) {
        return (V) this.mArray[(i3 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (obj2 == valueAt || (obj2 != null && obj2.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(K k5, V v5, V v6) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (valueAt == v5 || (v5 != null && v5.equals(valueAt))) {
                setValueAt(indexOfKey, v6);
                return true;
            }
            return false;
        }
        return false;
    }

    public SimpleArrayMap(int i3) {
        if (i3 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i3);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }
}
