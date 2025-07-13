package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f1505a;
    protected String b;

    public l(int i3) {
        this.b = "GBK";
        this.f1505a = ByteBuffer.allocate(i3);
    }

    private void a(int i3) {
        if (this.f1505a.remaining() < i3) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f1505a.capacity() + i3) * 2);
            allocate.put(this.f1505a.array(), 0, this.f1505a.position());
            this.f1505a = allocate;
        }
    }

    private void b(byte b, int i3) {
        if (i3 < 15) {
            this.f1505a.put((byte) (b | (i3 << 4)));
        } else if (i3 < 256) {
            this.f1505a.put((byte) (b | 240));
            this.f1505a.put((byte) i3);
        } else {
            throw new j("tag is too large: ".concat(String.valueOf(i3)));
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z3, int i3) {
        a(z3 ? (byte) 1 : (byte) 0, i3);
    }

    public final void a(byte b, int i3) {
        a(3);
        if (b == 0) {
            b((byte) 12, i3);
            return;
        }
        b((byte) 0, i3);
        this.f1505a.put(b);
    }

    public final void a(short s, int i3) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i3);
            return;
        }
        b((byte) 1, i3);
        this.f1505a.putShort(s);
    }

    public final void a(int i3, int i5) {
        a(6);
        if (i3 >= -32768 && i3 <= 32767) {
            a((short) i3, i5);
            return;
        }
        b((byte) 2, i5);
        this.f1505a.putInt(i3);
    }

    public final void a(long j2, int i3) {
        a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            a((int) j2, i3);
            return;
        }
        b((byte) 3, i3);
        this.f1505a.putLong(j2);
    }

    private void a(float f4, int i3) {
        a(6);
        b((byte) 4, i3);
        this.f1505a.putFloat(f4);
    }

    private void a(double d, int i3) {
        a(10);
        b((byte) 5, i3);
        this.f1505a.putDouble(d);
    }

    public final void a(String str, int i3) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i3);
            this.f1505a.putInt(bytes.length);
            this.f1505a.put(bytes);
            return;
        }
        b((byte) 6, i3);
        this.f1505a.put((byte) bytes.length);
        this.f1505a.put(bytes);
    }

    public final <K, V> void a(Map<K, V> map, int i3) {
        a(8);
        b((byte) 8, i3);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(zArr.length, 0);
        for (boolean z3 : zArr) {
            a(z3, 0);
        }
    }

    public final void a(byte[] bArr, int i3) {
        a(bArr.length + 8);
        b((byte) 13, i3);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f1505a.put(bArr);
    }

    private void a(short[] sArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(sArr.length, 0);
        for (short s : sArr) {
            a(s, 0);
        }
    }

    private void a(int[] iArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(iArr.length, 0);
        for (int i5 : iArr) {
            a(i5, 0);
        }
    }

    private void a(long[] jArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(jArr.length, 0);
        for (long j2 : jArr) {
            a(j2, 0);
        }
    }

    private void a(float[] fArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(fArr.length, 0);
        for (float f4 : fArr) {
            a(f4, 0);
        }
    }

    private void a(double[] dArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(dArr.length, 0);
        for (double d : dArr) {
            a(d, 0);
        }
    }

    private void a(Object[] objArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i3) {
        a(8);
        b((byte) 9, i3);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t4 : collection) {
                a(t4, 0);
            }
        }
    }

    public final void a(m mVar, int i3) {
        a(2);
        b((byte) 10, i3);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i3) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i3);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i3);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i3);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i3);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i3);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i3);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i3);
        } else if (obj instanceof String) {
            a((String) obj, i3);
        } else if (obj instanceof Map) {
            a((Map) obj, i3);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i3);
        } else if (obj instanceof m) {
            a((m) obj, i3);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i3);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i3);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i3);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i3);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i3);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i3);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i3);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i3);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i3);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
