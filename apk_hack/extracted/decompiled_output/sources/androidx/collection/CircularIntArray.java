package androidx.collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i3 = this.mHead;
        int i5 = length - i3;
        int i6 = length << 1;
        if (i6 >= 0) {
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i3, iArr2, 0, i5);
            System.arraycopy(this.mElements, 0, iArr2, i5, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i6 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i3) {
        int i5 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i5;
        this.mElements[i5] = i3;
        if (i5 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i3) {
        int[] iArr = this.mElements;
        int i5 = this.mTail;
        iArr[i5] = i3;
        int i6 = this.mCapacityBitmask & (i5 + 1);
        this.mTail = i6;
        if (i6 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i3)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            return this.mElements[i3];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i3 = this.mHead;
        int i5 = this.mTail;
        if (i3 != i5) {
            return this.mElements[(i5 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.mHead == this.mTail) {
            return true;
        }
        return false;
    }

    public int popFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            int i5 = this.mElements[i3];
            this.mHead = (i3 + 1) & this.mCapacityBitmask;
            return i5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i3 = this.mHead;
        int i5 = this.mTail;
        if (i3 != i5) {
            int i6 = this.mCapacityBitmask & (i5 - 1);
            int i7 = this.mElements[i6];
            this.mTail = i6;
            return i7;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            this.mTail = this.mCapacityBitmask & (this.mTail - i3);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            this.mHead = this.mCapacityBitmask & (this.mHead + i3);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i3 <= 1073741824) {
            i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
            this.mCapacityBitmask = i3 - 1;
            this.mElements = new int[i3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
