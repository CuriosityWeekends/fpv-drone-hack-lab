package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i3) {
            if (i3 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i3 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i3);
        }

        public int countOnesBefore(int i3) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i3 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i3) - 1));
            } else if (i3 < 64) {
                return Long.bitCount(this.mData & ((1 << i3) - 1));
            } else {
                return Long.bitCount(this.mData) + bucket.countOnesBefore(i3 - 64);
            }
        }

        public boolean get(int i3) {
            if (i3 >= 64) {
                ensureNext();
                return this.mNext.get(i3 - 64);
            } else if ((this.mData & (1 << i3)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public void insert(int i3, boolean z3) {
            boolean z5;
            if (i3 >= 64) {
                ensureNext();
                this.mNext.insert(i3 - 64, z3);
                return;
            }
            long j2 = this.mData;
            if ((LAST_BIT & j2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            long j5 = (1 << i3) - 1;
            this.mData = ((j2 & (~j5)) << 1) | (j2 & j5);
            if (z3) {
                set(i3);
            } else {
                clear(i3);
            }
            if (z5 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z5);
            }
        }

        public boolean remove(int i3) {
            boolean z3;
            if (i3 >= 64) {
                ensureNext();
                return this.mNext.remove(i3 - 64);
            }
            long j2 = 1 << i3;
            long j5 = this.mData;
            if ((j5 & j2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            long j6 = j5 & (~j2);
            this.mData = j6;
            long j7 = j2 - 1;
            this.mData = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z3;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i3) {
            if (i3 >= 64) {
                ensureNext();
                this.mNext.set(i3 - 64);
                return;
            }
            this.mData |= 1 << i3;
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Callback {
        void addView(View view, int i3);

        void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i3);

        View getChildAt(int i3);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i3);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i5 = i3;
        while (i5 < childCount) {
            int countOnesBefore = i3 - (i5 - this.mBucket.countOnesBefore(i5));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (this.mHiddenViews.remove(view)) {
            this.mCallback.onLeftHiddenState(view);
            return true;
        }
        return false;
    }

    public void addView(View view, boolean z3) {
        addView(view, -1, z3);
    }

    public void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        int offset;
        if (i3 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i3);
        }
        this.mBucket.insert(offset, z3);
        if (z3) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, offset, layoutParams);
    }

    public void detachViewFromParent(int i3) {
        int offset = getOffset(i3);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i3) {
        int size = this.mHiddenViews.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mHiddenViews.get(i5);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i3 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i3) {
        return this.mCallback.getChildAt(getOffset(i3));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i3) {
        return this.mCallback.getChildAt(i3);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i3) {
        int offset = getOffset(i3);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        } else if (this.mBucket.get(indexOfChild)) {
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.get(indexOfChild)) {
                this.mBucket.clear(indexOfChild);
                unhideViewInternal(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public void addView(View view, int i3, boolean z3) {
        int offset;
        if (i3 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i3);
        }
        this.mBucket.insert(offset, z3);
        if (z3) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, offset);
    }
}
