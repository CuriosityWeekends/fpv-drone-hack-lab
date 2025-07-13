package androidx.recyclerview.widget;

import a1.i;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f123x - diagonal2.f123x;
        }
    };

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i3, int i5);

        public abstract boolean areItemsTheSame(int i3, int i5);

        @Nullable
        public Object getChangePayload(int i3, int i5) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i3) {
            int[] iArr = new int[i3];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i3) {
            Arrays.fill(this.mData, i3);
        }

        public int get(int i3) {
            return this.mData[i3 + this.mMid];
        }

        public void set(int i3, int i5) {
            this.mData[i3 + this.mMid] = i5;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Diagonal {
        public final int size;

        /* renamed from: x  reason: collision with root package name */
        public final int f123x;

        /* renamed from: y  reason: collision with root package name */
        public final int f124y;

        public Diagonal(int i3, int i5, int i6) {
            this.f123x = i3;
            this.f124y = i5;
            this.size = i6;
        }

        public int endX() {
            return this.f123x + this.size;
        }

        public int endY() {
            return this.f124y + this.size;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z3) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z3;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal;
            if (this.mDiagonals.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.mDiagonals.get(0);
            }
            if (diagonal == null || diagonal.f123x != 0 || diagonal.f124y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i3) {
            int i5;
            int size = this.mDiagonals.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Diagonal diagonal = this.mDiagonals.get(i7);
                while (i6 < diagonal.f124y) {
                    if (this.mNewItemStatuses[i6] == 0 && this.mCallback.areItemsTheSame(i3, i6)) {
                        if (this.mCallback.areContentsTheSame(i3, i6)) {
                            i5 = 8;
                        } else {
                            i5 = 4;
                        }
                        this.mOldItemStatuses[i3] = (i6 << 4) | i5;
                        this.mNewItemStatuses[i6] = (i3 << 4) | i5;
                        return;
                    }
                    i6++;
                }
                i6 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            int i3;
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i5 = 0; i5 < diagonal.size; i5++) {
                    int i6 = diagonal.f123x + i5;
                    int i7 = diagonal.f124y + i5;
                    if (this.mCallback.areContentsTheSame(i6, i7)) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    this.mOldItemStatuses[i6] = (i7 << 4) | i3;
                    this.mNewItemStatuses[i7] = (i6 << 4) | i3;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i3 = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (i3 < diagonal.f123x) {
                    if (this.mOldItemStatuses[i3] == 0) {
                        findMatchingAddition(i3);
                    }
                    i3++;
                }
                i3 = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i3, boolean z3) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    postponedUpdate = it.next();
                    if (postponedUpdate.posInOwnerList == i3 && postponedUpdate.removal == z3) {
                        it.remove();
                        break;
                    }
                } else {
                    postponedUpdate = null;
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z3) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i3) {
            if (i3 >= 0 && i3 < this.mNewListSize) {
                int i5 = this.mNewItemStatuses[i3];
                if ((i5 & 15) == 0) {
                    return -1;
                }
                return i5 >> 4;
            }
            StringBuilder m5 = i.m("Index out of bounds - passed position = ", i3, ", new list size = ");
            m5.append(this.mNewListSize);
            throw new IndexOutOfBoundsException(m5.toString());
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i3) {
            if (i3 >= 0 && i3 < this.mOldListSize) {
                int i5 = this.mOldItemStatuses[i3];
                if ((i5 & 15) == 0) {
                    return -1;
                }
                return i5 >> 4;
            }
            StringBuilder m5 = i.m("Index out of bounds - passed position = ", i3, ", old list size = ");
            m5.append(this.mOldListSize);
            throw new IndexOutOfBoundsException(m5.toString());
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i3;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i5 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i6 = this.mOldListSize;
            int i7 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i6 <= endX) {
                        break;
                    }
                    i6--;
                    int i8 = this.mOldItemStatuses[i6];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i9, false);
                        if (postponedUpdate != null) {
                            int i10 = (i5 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i6, i10);
                            if ((i8 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i6, i9));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i6, (i5 - i6) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i6, 1);
                        i5--;
                    }
                }
                while (i7 > endY) {
                    i7--;
                    int i11 = this.mNewItemStatuses[i7];
                    if ((i11 & 12) != 0) {
                        int i12 = i11 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i12, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i7, i5 - i6, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i5 - postponedUpdate2.currentPos) - 1, i6);
                            if ((i11 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i6, 1, this.mCallback.getChangePayload(i12, i7));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i6, 1);
                        i5++;
                    }
                }
                int i13 = diagonal.f123x;
                int i14 = diagonal.f124y;
                for (i3 = 0; i3 < diagonal.size; i3++) {
                    if ((this.mOldItemStatuses[i13] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i13, 1, this.mCallback.getChangePayload(i13, i14));
                    }
                    i13++;
                    i14++;
                }
                i6 = diagonal.f123x;
                i7 = diagonal.f124y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t4, @NonNull T t5);

        public abstract boolean areItemsTheSame(@NonNull T t4, @NonNull T t5);

        @Nullable
        public Object getChangePayload(@NonNull T t4, @NonNull T t5) {
            return null;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i3, int i5, boolean z3) {
            this.posInOwnerList = i3;
            this.currentPos = i5;
            this.removal = z3;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i3, int i5, int i6, int i7) {
            this.oldListStart = i3;
            this.oldListEnd = i5;
            this.newListStart = i6;
            this.newListEnd = i7;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            if (this.endY - this.startY != this.endX - this.startX) {
                return true;
            }
            return false;
        }

        public boolean isAddition() {
            if (this.endY - this.startY > this.endX - this.startX) {
                return true;
            }
            return false;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                if (this.reverse) {
                    return new Diagonal(this.startX, this.startY, diagonalSize());
                }
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i3 = this.startX;
            return new Diagonal(i3, this.startY, this.endX - i3);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i3) {
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        if ((range.oldSize() - range.newSize()) % 2 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i9 = -i3;
        for (int i10 = i9; i10 <= i3; i10 += 2) {
            if (i10 != i9 && (i10 == i3 || centeredArray2.get(i10 + 1) >= centeredArray2.get(i10 - 1))) {
                i5 = centeredArray2.get(i10 - 1);
                i6 = i5 - 1;
            } else {
                i5 = centeredArray2.get(i10 + 1);
                i6 = i5;
            }
            int i11 = range.newListEnd - ((range.oldListEnd - i6) - i10);
            if (i3 != 0 && i6 == i5) {
                i7 = i11 + 1;
            } else {
                i7 = i11;
            }
            while (i6 > range.oldListStart && i11 > range.newListStart && callback.areItemsTheSame(i6 - 1, i11 - 1)) {
                i6--;
                i11--;
            }
            centeredArray2.set(i10, i6);
            if (z3 && (i8 = oldSize - i10) >= i9 && i8 <= i3 && centeredArray.get(i8) >= i6) {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i11;
                snake.endX = i5;
                snake.endY = i7;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i3) {
        int i5;
        int i6;
        int i7;
        boolean z3 = true;
        if (Math.abs(range.oldSize() - range.newSize()) % 2 != 1) {
            z3 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i8 = -i3;
        for (int i9 = i8; i9 <= i3; i9 += 2) {
            if (i9 != i8 && (i9 == i3 || centeredArray.get(i9 + 1) <= centeredArray.get(i9 - 1))) {
                i5 = centeredArray.get(i9 - 1);
                i6 = i5 + 1;
            } else {
                i5 = centeredArray.get(i9 + 1);
                i6 = i5;
            }
            int i10 = ((i6 - range.oldListStart) + range.newListStart) - i9;
            int i11 = (i3 != 0 && i6 == i5) ? i10 - 1 : i10;
            while (i6 < range.oldListEnd && i10 < range.newListEnd && callback.areItemsTheSame(i6, i10)) {
                i6++;
                i10++;
            }
            centeredArray.set(i9, i6);
            if (z3 && (i7 = oldSize - i9) >= i8 + 1 && i7 <= i3 - 1 && centeredArray2.get(i7) <= i6) {
                Snake snake = new Snake();
                snake.startX = i5;
                snake.startY = i11;
                snake.endX = i6;
                snake.endY = i10;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i3 = 0; i3 < oldSize; i3++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i3);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i3);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z3) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i3 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i3);
        CenteredArray centeredArray2 = new CenteredArray(i3);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z3);
    }
}
