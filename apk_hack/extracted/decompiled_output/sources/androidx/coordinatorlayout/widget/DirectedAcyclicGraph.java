package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t4, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t4)) {
            return;
        }
        if (!hashSet.contains(t4)) {
            hashSet.add(t4);
            ArrayList<T> arrayList2 = this.mGraph.get(t4);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    dfs(arrayList2.get(i3), arrayList, hashSet);
                }
            }
            hashSet.remove(t4);
            arrayList.add(t4);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t4, @NonNull T t5) {
        if (this.mGraph.containsKey(t4) && this.mGraph.containsKey(t5)) {
            ArrayList<T> arrayList = this.mGraph.get(t4);
            if (arrayList == null) {
                arrayList = getEmptyList();
                this.mGraph.put(t4, arrayList);
            }
            arrayList.add(t5);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(@NonNull T t4) {
        if (!this.mGraph.containsKey(t4)) {
            this.mGraph.put(t4, null);
        }
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i3);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t4) {
        return this.mGraph.containsKey(t4);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t4) {
        return this.mGraph.get(t4);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t4) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i3);
            if (valueAt != null && valueAt.contains(t4)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i3));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i3 = 0; i3 < size; i3++) {
            dfs(this.mGraph.keyAt(i3), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t4) {
        int size = this.mGraph.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i3);
            if (valueAt != null && valueAt.contains(t4)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
