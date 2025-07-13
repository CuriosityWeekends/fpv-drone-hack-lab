package e2;

import android.net.Uri;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface i {
    void addTransferListener(m0 m0Var);

    void close();

    Map getResponseHeaders();

    Uri getUri();

    long open(l lVar);

    int read(byte[] bArr, int i3, int i5);
}
