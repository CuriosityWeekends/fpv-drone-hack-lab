package androidx.collection;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class MapCollections<K, V> {
    @Nullable
    MapCollections<K, V>.EntrySet mEntrySet;
    @Nullable
    MapCollections<K, V>.KeySet mKeySet;
    @Nullable
    MapCollections<K, V>.ValuesCollection mValues;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class ArrayIterator<T> implements Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        public ArrayIterator(int i3) {
            this.mOffset = i3;
            this.mSize = MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex < this.mSize) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t4 = (T) MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
                this.mIndex++;
                this.mCanRemove = true;
                return t4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mCanRemove) {
                int i3 = this.mIndex - 1;
                this.mIndex = i3;
                this.mSize--;
                this.mCanRemove = false;
                MapCollections.this.colRemoveAt(i3);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class EntrySet implements Set<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            if (colGetSize != MapCollections.this.colGetSize()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int colIndexOfKey = MapCollections.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey < 0) {
                return false;
            }
            return ContainerHelpers.equal(MapCollections.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = 0;
            for (int colGetSize = MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(colGetSize, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = colGetEntry2.hashCode();
                }
                i3 += hashCode ^ hashCode2;
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class KeySet implements Set<K> {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfKey(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i3 = 0;
            for (int colGetSize = MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                i3 += hashCode;
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int colIndexOfKey = MapCollections.this.colIndexOfKey(obj);
            if (colIndexOfKey >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfKey);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex = -1;

        public MapIterator() {
            this.mEnd = MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.mEntryValid) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.equal(entry.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(entry.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid) {
                return (K) MapCollections.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex < this.mEnd) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.mEntryValid) {
                int i3 = 0;
                Object colGetEntry = MapCollections.this.colGetEntry(this.mIndex, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(this.mIndex, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 != null) {
                    i3 = colGetEntry2.hashCode();
                }
                return hashCode ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mEntryValid) {
                MapCollections.this.colRemoveAt(this.mIndex);
                this.mIndex--;
                this.mEnd--;
                this.mEntryValid = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            if (this.mEntryValid) {
                return (V) MapCollections.this.colSetValue(this.mIndex, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.mIndex++;
                this.mEntryValid = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class ValuesCollection implements Collection<V> {
        public ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int colIndexOfValue = MapCollections.this.colIndexOfValue(obj);
            if (colIndexOfValue >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfValue);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < colGetSize) {
                if (collection.contains(MapCollections.this.colGetEntry(i3, 1))) {
                    MapCollections.this.colRemoveAt(i3);
                    i3--;
                    colGetSize--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < colGetSize) {
                if (!collection.contains(MapCollections.this.colGetEntry(i3, 1))) {
                    MapCollections.this.colRemoveAt(i3);
                    i3--;
                    colGetSize--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void colClear();

    public abstract Object colGetEntry(int i3, int i5);

    public abstract Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object obj);

    public abstract int colIndexOfValue(Object obj);

    public abstract void colPut(K k5, V v5);

    public abstract void colRemoveAt(int i3);

    public abstract V colSetValue(int i3, V v5);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new EntrySet();
        }
        return this.mEntrySet;
    }

    public Set<K> getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new KeySet();
        }
        return this.mKeySet;
    }

    public Collection<V> getValues() {
        if (this.mValues == null) {
            this.mValues = new ValuesCollection();
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int i3) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i5 = 0; i5 < colGetSize; i5++) {
            objArr[i5] = colGetEntry(i5, i3);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] toArrayHelper(T[] tArr, int i3) {
        int colGetSize = colGetSize();
        if (tArr.length < colGetSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), colGetSize));
        }
        for (int i5 = 0; i5 < colGetSize; i5++) {
            tArr[i5] = colGetEntry(i5, i3);
        }
        if (tArr.length > colGetSize) {
            tArr[colGetSize] = null;
        }
        return tArr;
    }
}
