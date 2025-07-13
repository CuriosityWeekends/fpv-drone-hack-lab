package f2;

import android.util.SparseArray;
import g2.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1834a = false;
    public final Cipher b = null;
    public final SecretKeySpec c = null;
    public final Random d = null;

    /* renamed from: e  reason: collision with root package name */
    public final c1.b f1835e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1836f;

    /* renamed from: g  reason: collision with root package name */
    public g2.p f1837g;

    public j(File file) {
        this.f1835e = new c1.b(file);
    }

    public static int c(i iVar, int i3) {
        long j2;
        int hashCode = iVar.b.hashCode() + (iVar.f1832a * 31);
        if (i3 < 2) {
            Map map = iVar.d.b;
            if (map.containsKey("exo_len")) {
                j2 = ByteBuffer.wrap((byte[]) map.get("exo_len")).getLong();
            } else {
                j2 = -1;
            }
            return (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return (hashCode * 31) + iVar.d.hashCode();
    }

    public static i h(int i3, DataInputStream dataInputStream) {
        m mVar;
        int readInt = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if (i3 < 2) {
            long readLong = dataInputStream.readLong();
            l lVar = new l(0);
            lVar.a(Long.valueOf(readLong), "exo_len");
            mVar = m.c.a(lVar);
        } else {
            int readInt2 = dataInputStream.readInt();
            HashMap hashMap = new HashMap();
            for (int i5 = 0; i5 < readInt2; i5++) {
                String readUTF2 = dataInputStream.readUTF();
                int readInt3 = dataInputStream.readInt();
                if (readInt3 >= 0) {
                    int min = Math.min(readInt3, 10485760);
                    byte[] bArr = w.f1962f;
                    int i6 = 0;
                    while (i6 != readInt3) {
                        int i7 = i6 + min;
                        bArr = Arrays.copyOf(bArr, i7);
                        dataInputStream.readFully(bArr, i6, min);
                        min = Math.min(readInt3 - i7, 10485760);
                        i6 = i7;
                    }
                    hashMap.put(readUTF2, bArr);
                } else {
                    throw new IOException(a1.i.e(readInt3, "Invalid value size: "));
                }
            }
            mVar = new m(hashMap);
        }
        return new i(readInt, readUTF, mVar);
    }

    public final void a() {
        c1.b bVar = this.f1835e;
        ((File) bVar.b).delete();
        ((File) bVar.c).delete();
    }

    public final boolean b() {
        c1.b bVar = this.f1835e;
        if (!((File) bVar.b).exists() && !((File) bVar.c).exists()) {
            return false;
        }
        return true;
    }

    public final void e(HashMap hashMap, SparseArray sparseArray) {
        boolean z3 = true;
        g2.b.h(!this.f1836f);
        c1.b bVar = this.f1835e;
        File file = (File) bVar.b;
        boolean exists = ((File) bVar.b).exists();
        File file2 = (File) bVar.c;
        if (exists || file2.exists()) {
            DataInputStream dataInputStream = null;
            try {
                if (file2.exists()) {
                    file.delete();
                    file2.renameTo(file);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int readInt = dataInputStream2.readInt();
                    if (readInt >= 0 && readInt <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            Cipher cipher = this.b;
                            if (cipher != null) {
                                byte[] bArr = new byte[16];
                                dataInputStream2.readFully(bArr);
                                try {
                                    cipher.init(2, this.c, new IvParameterSpec(bArr));
                                    dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, cipher));
                                } catch (InvalidAlgorithmParameterException e5) {
                                    e = e5;
                                    throw new IllegalStateException(e);
                                } catch (InvalidKeyException e6) {
                                    e = e6;
                                    throw new IllegalStateException(e);
                                }
                            }
                        } else if (this.f1834a) {
                            this.f1836f = true;
                        }
                        int readInt2 = dataInputStream2.readInt();
                        int i3 = 0;
                        for (int i5 = 0; i5 < readInt2; i5++) {
                            i h5 = h(readInt, dataInputStream2);
                            String str = h5.b;
                            hashMap.put(str, h5);
                            sparseArray.put(h5.f1832a, str);
                            i3 += c(h5, readInt);
                        }
                        int readInt3 = dataInputStream2.readInt();
                        if (dataInputStream2.read() != -1) {
                            z3 = false;
                        }
                        if (readInt3 == i3 && z3) {
                            w.g(dataInputStream2);
                            return;
                        }
                    }
                    w.g(dataInputStream2);
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        w.g(dataInputStream);
                    }
                    hashMap.clear();
                    sparseArray.clear();
                    file.delete();
                    file2.delete();
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        w.g(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            hashMap.clear();
            sparseArray.clear();
            file.delete();
            file2.delete();
        }
    }

    public final void f(i iVar, boolean z3) {
        this.f1836f = true;
    }

    public final void g(i iVar) {
        this.f1836f = true;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [g2.p, java.io.BufferedOutputStream] */
    public final void i(HashMap hashMap) {
        Cipher cipher = this.b;
        c1.b bVar = this.f1835e;
        DataOutputStream dataOutputStream = null;
        try {
            g2.a z3 = bVar.z();
            g2.p pVar = this.f1837g;
            if (pVar == null) {
                this.f1837g = new BufferedOutputStream(z3);
            } else {
                pVar.a(z3);
            }
            DataOutputStream dataOutputStream2 = new DataOutputStream(this.f1837g);
            try {
                dataOutputStream2.writeInt(2);
                boolean z5 = this.f1834a;
                dataOutputStream2.writeInt(z5 ? 1 : 0);
                if (z5) {
                    byte[] bArr = new byte[16];
                    this.d.nextBytes(bArr);
                    dataOutputStream2.write(bArr);
                    try {
                        cipher.init(1, this.c, new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(this.f1837g, cipher));
                    } catch (InvalidAlgorithmParameterException e5) {
                        e = e5;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e6) {
                        e = e6;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream2.writeInt(hashMap.size());
                int i3 = 0;
                for (i iVar : hashMap.values()) {
                    dataOutputStream2.writeInt(iVar.f1832a);
                    dataOutputStream2.writeUTF(iVar.b);
                    k.a(iVar.d, dataOutputStream2);
                    i3 += c(iVar, 2);
                }
                dataOutputStream2.writeInt(i3);
                dataOutputStream2.close();
                ((File) bVar.c).delete();
                int i5 = w.f1960a;
                this.f1836f = false;
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                w.g(dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void j(HashMap hashMap) {
        if (!this.f1836f) {
            return;
        }
        i(hashMap);
    }

    public final void d(long j2) {
    }
}
