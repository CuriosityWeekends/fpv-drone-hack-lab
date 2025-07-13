package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags = new BoundFlags();
    final Callback mCallback;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        public void addFlags(int i3) {
            this.mBoundFlags = i3 | this.mBoundFlags;
        }

        public boolean boundsMatch() {
            int i3 = this.mBoundFlags;
            if ((i3 & 7) != 0 && (i3 & compare(this.mChildStart, this.mRvStart)) == 0) {
                return false;
            }
            int i5 = this.mBoundFlags;
            if ((i5 & 112) != 0 && (i5 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            int i6 = this.mBoundFlags;
            if ((i6 & 1792) != 0 && (i6 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            int i7 = this.mBoundFlags;
            if ((i7 & 28672) != 0 && (i7 & (compare(this.mChildEnd, this.mRvEnd) << 12)) == 0) {
                return false;
            }
            return true;
        }

        public int compare(int i3, int i5) {
            if (i3 > i5) {
                return 1;
            }
            return i3 == i5 ? 2 : 4;
        }

        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        public void setBounds(int i3, int i5, int i6, int i7) {
            this.mRvStart = i3;
            this.mRvEnd = i5;
            this.mChildStart = i6;
            this.mChildEnd = i7;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Callback {
        View getChildAt(int i3);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    public View findOneViewWithinBoundFlags(int i3, int i5, int i6, int i7) {
        int i8;
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        if (i5 > i3) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        View view = null;
        while (i3 != i5) {
            View childAt = this.mCallback.getChildAt(i3);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i6 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i6);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i7 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i7);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i3 += i8;
        }
        return view;
    }

    public boolean isViewWithinBoundFlags(View view, int i3) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i3 != 0) {
            this.mBoundFlags.resetFlags();
            this.mBoundFlags.addFlags(i3);
            return this.mBoundFlags.boundsMatch();
        }
        return false;
    }
}
