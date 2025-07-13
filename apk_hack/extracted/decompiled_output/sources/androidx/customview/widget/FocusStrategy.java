package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FocusStrategy {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t4, Rect rect);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface CollectionAdapter<T, V> {
        V get(T t4, int i3);

        int size(T t4);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z3, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z3;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t4, T t5) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t4, rect);
            this.mAdapter.obtainBounds(t5, rect2);
            int i3 = rect.top;
            int i5 = rect2.top;
            if (i3 < i5) {
                return -1;
            }
            if (i3 > i5) {
                return 1;
            }
            int i6 = rect.left;
            int i7 = rect2.left;
            if (i6 < i7) {
                if (!this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            } else if (i6 > i7) {
                if (this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            } else {
                int i8 = rect.bottom;
                int i9 = rect2.bottom;
                if (i8 < i9) {
                    return -1;
                }
                if (i8 > i9) {
                    return 1;
                }
                int i10 = rect.right;
                int i11 = rect2.right;
                if (i10 < i11) {
                    if (!this.mIsLayoutRtl) {
                        return -1;
                    }
                    return 1;
                } else if (i10 > i11) {
                    if (this.mIsLayoutRtl) {
                        return -1;
                    }
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i3, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i3, rect, rect2);
        if (beamsOverlap(i3, rect, rect3) || !beamsOverlap) {
            return false;
        }
        if (isToDirectionOf(i3, rect, rect3) && i3 != 17 && i3 != 66 && majorAxisDistance(i3, rect, rect2) >= majorAxisDistanceToFarEdge(i3, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean beamsOverlap(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l5, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t4, @NonNull Rect rect, int i3) {
        Rect rect2 = new Rect(rect);
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        rect2.offset(0, -(rect.height() + 1));
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        int size = collectionAdapter.size(l5);
        Rect rect3 = new Rect();
        T t5 = null;
        for (int i5 = 0; i5 < size; i5++) {
            T t6 = collectionAdapter.get(l5, i5);
            if (t6 != t4) {
                boundsAdapter.obtainBounds(t6, rect3);
                if (isBetterCandidate(i3, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t5 = t6;
                }
            }
        }
        return t5;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l5, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t4, int i3, boolean z3, boolean z5) {
        int size = collectionAdapter.size(l5);
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(collectionAdapter.get(l5, i5));
        }
        Collections.sort(arrayList, new SequentialComparator(z3, boundsAdapter));
        if (i3 != 1) {
            if (i3 == 2) {
                return (T) getNextFocusable(t4, arrayList, z5);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return (T) getPreviousFocusable(t4, arrayList, z5);
    }

    private static <T> T getNextFocusable(T t4, ArrayList<T> arrayList, boolean z3) {
        int lastIndexOf;
        int size = arrayList.size();
        if (t4 == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = arrayList.lastIndexOf(t4);
        }
        int i3 = lastIndexOf + 1;
        if (i3 < size) {
            return arrayList.get(i3);
        }
        if (z3 && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static <T> T getPreviousFocusable(T t4, ArrayList<T> arrayList, boolean z3) {
        int indexOf;
        int size = arrayList.size();
        if (t4 == null) {
            indexOf = size;
        } else {
            indexOf = arrayList.indexOf(t4);
        }
        int i3 = indexOf - 1;
        if (i3 >= 0) {
            return arrayList.get(i3);
        }
        if (z3 && size > 0) {
            return arrayList.get(size - 1);
        }
        return null;
    }

    private static int getWeightedDistanceFor(int i3, int i5) {
        return (i5 * i5) + (i3 * 13 * i3);
    }

    private static boolean isBetterCandidate(int i3, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i3)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i3) || beamBeats(i3, rect, rect2, rect3)) {
            return true;
        }
        if (beamBeats(i3, rect, rect3, rect2) || getWeightedDistanceFor(majorAxisDistance(i3, rect, rect2), minorAxisDistance(i3, rect, rect2)) >= getWeightedDistanceFor(majorAxisDistance(i3, rect, rect3), minorAxisDistance(i3, rect, rect3))) {
            return false;
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i3) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        int i5 = rect.top;
                        int i6 = rect2.top;
                        if ((i5 >= i6 && rect.bottom > i6) || rect.bottom >= rect2.bottom) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i7 = rect.left;
                int i8 = rect2.left;
                if ((i7 >= i8 && rect.right > i8) || rect.right >= rect2.right) {
                    return false;
                }
                return true;
            }
            int i9 = rect.bottom;
            int i10 = rect2.bottom;
            if ((i9 <= i10 && rect.top < i10) || rect.top <= rect2.top) {
                return false;
            }
            return true;
        }
        int i11 = rect.right;
        int i12 = rect2.right;
        if ((i11 <= i12 && rect.left < i12) || rect.left <= rect2.left) {
            return false;
        }
        return true;
    }

    private static boolean isToDirectionOf(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        if (rect.bottom > rect2.top) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                } else if (rect.right > rect2.left) {
                    return false;
                } else {
                    return true;
                }
            } else if (rect.top < rect2.bottom) {
                return false;
            } else {
                return true;
            }
        } else if (rect.left < rect2.right) {
            return false;
        } else {
            return true;
        }
    }

    private static int majorAxisDistance(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i3, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i5 = rect2.top;
                        i6 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i5 = rect2.left;
                    i6 = rect.right;
                }
            } else {
                i5 = rect.top;
                i6 = rect2.bottom;
            }
        } else {
            i5 = rect.left;
            i6 = rect2.right;
        }
        return i5 - i6;
    }

    private static int majorAxisDistanceToFarEdge(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i3, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i5 = rect2.bottom;
                        i6 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i5 = rect2.right;
                    i6 = rect.right;
                }
            } else {
                i5 = rect.top;
                i6 = rect2.top;
            }
        } else {
            i5 = rect.left;
            i6 = rect2.left;
        }
        return i5 - i6;
    }

    private static int minorAxisDistance(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
