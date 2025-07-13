package m0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a {
    private int flags;

    public final void addFlag(int i3) {
        this.flags = i3 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i3) {
        this.flags = (~i3) & this.flags;
    }

    public final boolean getFlag(int i3) {
        if ((this.flags & i3) == i3) {
            return true;
        }
        return false;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i3) {
        this.flags = i3;
    }
}
