package androidx.collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    private ContainerHelpers() {
    }

    public static int binarySearch(int[] iArr, int i3, int i5) {
        int i6 = i3 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i5) {
                i7 = i8 + 1;
            } else if (i9 <= i5) {
                return i8;
            } else {
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int idealByteArraySize(int i3) {
        for (int i5 = 4; i5 < 32; i5++) {
            int i6 = (1 << i5) - 12;
            if (i3 <= i6) {
                return i6;
            }
        }
        return i3;
    }

    public static int idealIntArraySize(int i3) {
        return idealByteArraySize(i3 * 4) / 4;
    }

    public static int idealLongArraySize(int i3) {
        return idealByteArraySize(i3 * 8) / 8;
    }

    public static int binarySearch(long[] jArr, int i3, long j2) {
        int i5 = i3 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            int i8 = (jArr[i7] > j2 ? 1 : (jArr[i7] == j2 ? 0 : -1));
            if (i8 < 0) {
                i6 = i7 + 1;
            } else if (i8 <= 0) {
                return i7;
            } else {
                i5 = i7 - 1;
            }
        }
        return ~i6;
    }
}
