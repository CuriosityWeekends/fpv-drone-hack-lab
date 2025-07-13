package androidx.collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i3 = this.mHead;
        int i5 = length - i3;
        int i6 = length << 1;
        if (i6 >= 0) {
            E[] eArr2 = (E[]) new Object[i6];
            System.arraycopy(eArr, i3, eArr2, 0, i5);
            System.arraycopy(this.mElements, 0, eArr2, i5, this.mHead);
            this.mElements = eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i6 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e5) {
        int i3 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i3;
        this.mElements[i3] = e5;
        if (i3 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e5) {
        E[] eArr = this.mElements;
        int i3 = this.mTail;
        eArr[i3] = e5;
        int i5 = this.mCapacityBitmask & (i3 + 1);
        this.mTail = i5;
        if (i5 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i3)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            return this.mElements[i3];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
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

    public E popFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            E[] eArr = this.mElements;
            E e5 = eArr[i3];
            eArr[i3] = null;
            this.mHead = (i3 + 1) & this.mCapacityBitmask;
            return e5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i3 = this.mHead;
        int i5 = this.mTail;
        if (i3 != i5) {
            int i6 = this.mCapacityBitmask & (i5 - 1);
            E[] eArr = this.mElements;
            E e5 = eArr[i6];
            eArr[i6] = null;
            this.mTail = i6;
            return e5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i3) {
        int i5;
        int i6;
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            int i7 = this.mTail;
            if (i3 < i7) {
                i5 = i7 - i3;
            } else {
                i5 = 0;
            }
            int i8 = i5;
            while (true) {
                i6 = this.mTail;
                if (i8 >= i6) {
                    break;
                }
                this.mElements[i8] = null;
                i8++;
            }
            int i9 = i6 - i5;
            int i10 = i3 - i9;
            this.mTail = i6 - i9;
            if (i10 > 0) {
                int length = this.mElements.length;
                this.mTail = length;
                int i11 = length - i10;
                for (int i12 = i11; i12 < this.mTail; i12++) {
                    this.mElements[i12] = null;
                }
                this.mTail = i11;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            int length = this.mElements.length;
            int i5 = this.mHead;
            if (i3 < length - i5) {
                length = i5 + i3;
            }
            while (i5 < length) {
                this.mElements[i5] = null;
                i5++;
            }
            int i6 = this.mHead;
            int i7 = length - i6;
            int i8 = i3 - i7;
            this.mHead = this.mCapacityBitmask & (i6 + i7);
            if (i8 > 0) {
                for (int i9 = 0; i9 < i8; i9++) {
                    this.mElements[i9] = null;
                }
                this.mHead = i8;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i3 <= 1073741824) {
            i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
            this.mCapacityBitmask = i3 - 1;
            this.mElements = (E[]) new Object[i3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
