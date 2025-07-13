package e2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final i f1693a;
    public long b;
    public Uri c;

    public k0(i iVar) {
        iVar.getClass();
        this.f1693a = iVar;
        this.c = Uri.EMPTY;
        Collections.emptyMap();
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        this.f1693a.addTransferListener(m0Var);
    }

    @Override // e2.i
    public final void close() {
        this.f1693a.close();
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        return this.f1693a.getResponseHeaders();
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.f1693a.getUri();
    }

    @Override // e2.i
    public final long open(l lVar) {
        this.c = lVar.f1694a;
        Collections.emptyMap();
        i iVar = this.f1693a;
        long open = iVar.open(lVar);
        Uri uri = iVar.getUri();
        uri.getClass();
        this.c = uri;
        iVar.getResponseHeaders();
        return open;
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        int read = this.f1693a.read(bArr, i3, i5);
        if (read != -1) {
            this.b += read;
        }
        return read;
    }
}
