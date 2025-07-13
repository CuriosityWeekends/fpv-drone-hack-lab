package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i3) {
        if (i3 == 8) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr = sTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        sTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        sTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr2 = sBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        sBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        sBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i3];
        this.mArray = new Object[i3];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i5 = i3 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        for (int i6 = i3 - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                public void colClear() {
                    ArraySet.this.clear();
                }

                @Override // androidx.collection.MapCollections
                public Object colGetEntry(int i3, int i5) {
                    return ArraySet.this.mArray[i3];
                }

                @Override // androidx.collection.MapCollections
                public Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                public int colGetSize() {
                    return ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                public int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                public int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                public void colPut(E e5, E e6) {
                    ArraySet.this.add(e5);
                }

                @Override // androidx.collection.MapCollections
                public void colRemoveAt(int i3) {
                    ArraySet.this.removeAt(i3);
                }

                @Override // androidx.collection.MapCollections
                public E colSetValue(int i3, E e5) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i3) {
        int i5 = this.mSize;
        if (i5 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i5, i3);
        if (binarySearch >= 0 && !obj.equals(this.mArray[binarySearch])) {
            int i6 = binarySearch + 1;
            while (i6 < i5 && this.mHashes[i6] == i3) {
                if (obj.equals(this.mArray[i6])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = binarySearch - 1; i7 >= 0 && this.mHashes[i7] == i3; i7--) {
                if (obj.equals(this.mArray[i7])) {
                    return i7;
                }
            }
            return ~i6;
        }
        return binarySearch;
    }

    private int indexOfNull() {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i3, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i5 = binarySearch + 1;
        while (i5 < i3 && this.mHashes[i5] == 0) {
            if (this.mArray[i5] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = binarySearch - 1; i6 >= 0 && this.mHashes[i6] == 0; i6--) {
            if (this.mArray[i6] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e5) {
        int i3;
        int indexOf;
        if (e5 == null) {
            indexOf = indexOfNull();
            i3 = 0;
        } else {
            int hashCode = e5.hashCode();
            i3 = hashCode;
            indexOf = indexOf(e5, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i5 = ~indexOf;
        int i6 = this.mSize;
        int[] iArr = this.mHashes;
        if (i6 >= iArr.length) {
            int i7 = 8;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i7);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i8 = this.mSize;
        if (i5 < i8) {
            int[] iArr3 = this.mHashes;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i5, objArr2, i9, this.mSize - i5);
        }
        this.mHashes[i5] = i3;
        this.mArray[i5] = e5;
        this.mSize++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i3 = arraySet.mSize;
        ensureCapacity(this.mSize + i3);
        if (this.mSize != 0) {
            for (int i5 = 0; i5 < i3; i5++) {
                add(arraySet.valueAt(i5));
            }
        } else if (i3 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i3);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i3);
            this.mSize = i3;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.mSize;
        if (i3 != 0) {
            freeArrays(this.mHashes, this.mArray, i3);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i3) {
        int[] iArr = this.mHashes;
        if (iArr.length < i3) {
            Object[] objArr = this.mArray;
            allocArrays(i3);
            int i5 = this.mSize;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i5);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    if (!set.contains(valueAt(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i3 = this.mSize;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i3 = arraySet.mSize;
        int i5 = this.mSize;
        for (int i6 = 0; i6 < i3; i6++) {
            remove(arraySet.valueAt(i6));
        }
        return i5 != this.mSize;
    }

    public E removeAt(int i3) {
        Object[] objArr = this.mArray;
        E e5 = (E) objArr[i3];
        int i5 = this.mSize;
        if (i5 <= 1) {
            freeArrays(this.mHashes, objArr, i5);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            int i6 = 8;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                if (i5 > 8) {
                    i6 = i5 + (i5 >> 1);
                }
                allocArrays(i6);
                this.mSize--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                    System.arraycopy(objArr, 0, this.mArray, 0, i3);
                }
                int i7 = this.mSize;
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    System.arraycopy(iArr, i8, this.mHashes, i3, i7 - i3);
                    System.arraycopy(objArr, i8, this.mArray, i3, this.mSize - i3);
                }
            } else {
                int i9 = i5 - 1;
                this.mSize = i9;
                if (i3 < i9) {
                    int i10 = i3 + 1;
                    System.arraycopy(iArr, i10, iArr, i3, i9 - i3);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i10, objArr2, i3, this.mSize - i3);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return e5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z3 = false;
        for (int i3 = this.mSize - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.mArray[i3])) {
                removeAt(i3);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i3 = this.mSize;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.mArray, 0, objArr, 0, i3);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i3);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Nullable
    public E valueAt(int i3) {
        return (E) this.mArray[i3];
    }

    public ArraySet(int i3) {
        if (i3 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i3);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i3 = this.mSize;
        if (length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= remove(it.next());
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(collection.size() + this.mSize);
        boolean z3 = false;
        for (E e5 : collection) {
            z3 |= add(e5);
        }
        return z3;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
