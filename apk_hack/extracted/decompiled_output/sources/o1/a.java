package o1;

import android.net.Uri;
import e2.m0;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements e2.i {

    /* renamed from: a  reason: collision with root package name */
    public final e2.i f2955a;
    public final byte[] b;
    public final byte[] c;
    public CipherInputStream d;

    public a(e2.i iVar, byte[] bArr, byte[] bArr2) {
        this.f2955a = iVar;
        this.b = bArr;
        this.c = bArr2;
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        this.f2955a.addTransferListener(m0Var);
    }

    @Override // e2.i
    public final void close() {
        if (this.d != null) {
            this.d = null;
            this.f2955a.close();
        }
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        return this.f2955a.getResponseHeaders();
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.f2955a.getUri();
    }

    @Override // e2.i
    public final long open(e2.l lVar) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                e2.k kVar = new e2.k(this.f2955a, lVar);
                this.d = new CipherInputStream(kVar, cipher);
                kVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e5) {
                throw new RuntimeException(e5);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        this.d.getClass();
        int read = this.d.read(bArr, i3, i5);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
