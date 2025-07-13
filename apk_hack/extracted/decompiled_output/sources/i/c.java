package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public c(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
