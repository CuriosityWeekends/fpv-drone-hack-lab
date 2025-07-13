package g;

import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends IOException {
    private static final long serialVersionUID = 1;

    public c(String str, int i3, IOException iOException) {
        super(str + ", status code: " + i3, iOException);
    }
}
