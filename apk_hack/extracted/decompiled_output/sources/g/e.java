package g;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface e {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1896a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
