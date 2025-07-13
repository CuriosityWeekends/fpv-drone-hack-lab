package androidx.appcompat.widget;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        if (this.mIsRtl) {
            return this.mLeft;
        }
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl) {
            return this.mRight;
        }
        return this.mLeft;
    }

    public void setAbsolute(int i3, int i5) {
        this.mIsRelative = false;
        if (i3 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i3;
            this.mLeft = i3;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mExplicitRight = i5;
            this.mRight = i5;
        }
    }

    public void setDirection(boolean z3) {
        if (z3 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z3;
        if (this.mIsRelative) {
            if (z3) {
                int i3 = this.mEnd;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.mExplicitLeft;
                }
                this.mLeft = i3;
                int i5 = this.mStart;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.mExplicitRight;
                }
                this.mRight = i5;
                return;
            }
            int i6 = this.mStart;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.mExplicitLeft;
            }
            this.mLeft = i6;
            int i7 = this.mEnd;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.mExplicitRight;
            }
            this.mRight = i7;
            return;
        }
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
    }

    public void setRelative(int i3, int i5) {
        this.mStart = i3;
        this.mEnd = i5;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i5 != Integer.MIN_VALUE) {
                this.mLeft = i5;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.mRight = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.mLeft = i3;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mRight = i5;
        }
    }
}
