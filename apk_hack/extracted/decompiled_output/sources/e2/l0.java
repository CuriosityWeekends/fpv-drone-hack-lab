package e2;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final i f1700a;
    public final f2.d b;
    public boolean c;
    public long d;

    public l0(i iVar, f2.d dVar) {
        iVar.getClass();
        this.f1700a = iVar;
        dVar.getClass();
        this.b = dVar;
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        this.f1700a.addTransferListener(m0Var);
    }

    @Override // e2.i
    public final void close() {
        f2.d dVar = this.b;
        try {
            this.f1700a.close();
            if (this.c) {
                this.c = false;
                if (dVar.d != null) {
                    try {
                        dVar.a();
                    } catch (IOException e5) {
                        throw new IOException(e5);
                    }
                }
            }
        } catch (Throwable th) {
            if (this.c) {
                this.c = false;
                if (dVar.d != null) {
                    try {
                        dVar.a();
                    } catch (IOException e6) {
                        throw new IOException(e6);
                    }
                }
            }
            throw th;
        }
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        return this.f1700a.getResponseHeaders();
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.f1700a.getUri();
    }

    @Override // e2.i
    public final long open(l lVar) {
        long j2;
        long open = this.f1700a.open(lVar);
        this.d = open;
        if (open == 0) {
            return 0L;
        }
        if (lVar.f1697g == -1 && open != -1) {
            lVar = lVar.c(0L, open);
        }
        this.c = true;
        f2.d dVar = this.b;
        dVar.getClass();
        long j5 = lVar.f1697g;
        int i3 = lVar.f1699i;
        if (j5 == -1 && (i3 & 2) == 2) {
            dVar.d = null;
        } else {
            dVar.d = lVar;
            if ((i3 & 4) == 4) {
                j2 = dVar.b;
            } else {
                j2 = Long.MAX_VALUE;
            }
            dVar.f1804e = j2;
            dVar.f1808i = 0L;
            try {
                dVar.b();
            } catch (IOException e5) {
                throw new IOException(e5);
            }
        }
        return this.d;
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (this.d == 0) {
            return -1;
        }
        int read = this.f1700a.read(bArr, i3, i5);
        if (read > 0) {
            f2.d dVar = this.b;
            if (dVar.d != null) {
                int i6 = 0;
                while (i6 < read) {
                    try {
                        if (dVar.f1807h == dVar.f1804e) {
                            dVar.a();
                            dVar.b();
                        }
                        int min = (int) Math.min(read - i6, dVar.f1804e - dVar.f1807h);
                        dVar.f1806g.write(bArr, i3 + i6, min);
                        i6 += min;
                        long j2 = min;
                        dVar.f1807h += j2;
                        dVar.f1808i += j2;
                    } catch (IOException e5) {
                        throw new IOException(e5);
                    }
                }
            }
            long j5 = this.d;
            if (j5 != -1) {
                this.d = j5 - read;
            }
        }
        return read;
    }
}
