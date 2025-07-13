package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import java.security.Signature;
import javax.crypto.Cipher;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ FingerprintManager.CryptoObject f(Signature signature) {
        return new FingerprintManager.CryptoObject(signature);
    }

    public static /* synthetic */ FingerprintManager.CryptoObject g(Cipher cipher) {
        return new FingerprintManager.CryptoObject(cipher);
    }

    public static /* bridge */ /* synthetic */ FingerprintManager h(Object obj) {
        return (FingerprintManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class l() {
        return FingerprintManager.class;
    }
}
