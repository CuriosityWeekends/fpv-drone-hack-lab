package f;

import a1.i;
import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {
    public ByteBuffer b;
    public b c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f1782a = new byte[256];
    public int d = 0;

    public final boolean a() {
        if (this.c.b != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r6v29, types: [f.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v37, types: [f.a, java.lang.Object] */
    public final b b() {
        boolean z3;
        boolean z5;
        boolean z6;
        byte[] bArr;
        boolean z7;
        if (this.b != null) {
            if (a()) {
                return this.c;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 6; i3++) {
                sb.append((char) c());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.c.b = 1;
            } else {
                this.c.f1776f = this.b.getShort();
                this.c.f1777g = this.b.getShort();
                int c = c();
                b bVar = this.c;
                if ((c & 128) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bVar.f1778h = z3;
                bVar.f1779i = (int) Math.pow(2.0d, (c & 7) + 1);
                this.c.f1780j = c();
                b bVar2 = this.c;
                c();
                bVar2.getClass();
                if (this.c.f1778h && !a()) {
                    b bVar3 = this.c;
                    bVar3.f1774a = e(bVar3.f1779i);
                    b bVar4 = this.c;
                    bVar4.f1781k = bVar4.f1774a[bVar4.f1780j];
                }
            }
            if (!a()) {
                boolean z8 = false;
                while (!z8 && !a() && this.c.c <= Integer.MAX_VALUE) {
                    int c5 = c();
                    if (c5 != 33) {
                        if (c5 != 44) {
                            if (c5 != 59) {
                                this.c.b = 1;
                            } else {
                                z8 = true;
                            }
                        } else {
                            b bVar5 = this.c;
                            if (bVar5.d == null) {
                                bVar5.d = new Object();
                            }
                            bVar5.d.f1766a = this.b.getShort();
                            this.c.d.b = this.b.getShort();
                            this.c.d.c = this.b.getShort();
                            this.c.d.d = this.b.getShort();
                            int c6 = c();
                            if ((c6 & 128) != 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            int pow = (int) Math.pow(2.0d, (c6 & 7) + 1);
                            a aVar = this.c.d;
                            if ((c6 & 64) != 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            aVar.f1767e = z6;
                            if (z5) {
                                aVar.f1773k = e(pow);
                            } else {
                                aVar.f1773k = null;
                            }
                            this.c.d.f1772j = this.b.position();
                            c();
                            f();
                            if (!a()) {
                                b bVar6 = this.c;
                                bVar6.c++;
                                bVar6.f1775e.add(bVar6.d);
                            }
                        }
                    } else {
                        int c7 = c();
                        if (c7 != 1) {
                            if (c7 != 249) {
                                if (c7 != 254) {
                                    if (c7 != 255) {
                                        f();
                                    } else {
                                        d();
                                        StringBuilder sb2 = new StringBuilder();
                                        int i5 = 0;
                                        while (true) {
                                            bArr = this.f1782a;
                                            if (i5 >= 11) {
                                                break;
                                            }
                                            sb2.append((char) bArr[i5]);
                                            i5++;
                                        }
                                        if (sb2.toString().equals("NETSCAPE2.0")) {
                                            do {
                                                d();
                                                if (bArr[0] == 1) {
                                                    byte b = bArr[1];
                                                    byte b5 = bArr[2];
                                                    this.c.getClass();
                                                }
                                                if (this.d > 0) {
                                                }
                                            } while (!a());
                                        } else {
                                            f();
                                        }
                                    }
                                } else {
                                    f();
                                }
                            } else {
                                this.c.d = new Object();
                                c();
                                int c8 = c();
                                a aVar2 = this.c.d;
                                int i6 = (c8 & 28) >> 2;
                                aVar2.f1769g = i6;
                                if (i6 == 0) {
                                    aVar2.f1769g = 1;
                                }
                                if ((c8 & 1) != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                aVar2.f1768f = z7;
                                short s = this.b.getShort();
                                if (s < 2) {
                                    s = 10;
                                }
                                a aVar3 = this.c.d;
                                aVar3.f1771i = s * 10;
                                aVar3.f1770h = c();
                                c();
                            }
                        } else {
                            f();
                        }
                    }
                }
                b bVar7 = this.c;
                if (bVar7.c < 0) {
                    bVar7.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int c() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void d() {
        int c = c();
        this.d = c;
        if (c > 0) {
            int i3 = 0;
            int i5 = 0;
            while (true) {
                try {
                    i5 = this.d;
                    if (i3 < i5) {
                        i5 -= i3;
                        this.b.get(this.f1782a, i3, i5);
                        i3 += i5;
                    } else {
                        return;
                    }
                } catch (Exception e5) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder n5 = i.n("Error Reading Block n: ", i3, " count: ", i5, " blockSize: ");
                        n5.append(this.d);
                        Log.d("GifHeaderParser", n5.toString(), e5);
                    }
                    this.c.b = 1;
                    return;
                }
            }
        }
    }

    public final int[] e(int i3) {
        byte[] bArr = new byte[i3 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3) {
                int i7 = i6 + 2;
                i6 += 3;
                int i8 = i5 + 1;
                iArr[i5] = ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i7] & 255);
                i5 = i8;
            }
        } catch (BufferUnderflowException e5) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e5);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    public final void f() {
        int c;
        do {
            c = c();
            this.b.position(Math.min(this.b.position() + c, this.b.limit()));
        } while (c > 0);
    }
}
