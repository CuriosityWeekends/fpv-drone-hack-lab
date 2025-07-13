package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    protected String f1502a = "GBK";
    private ByteBuffer b;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f1503a;
        public int b;
    }

    public k() {
    }

    private boolean b(int i3) {
        int i5;
        try {
            a aVar = new a();
            while (true) {
                int a5 = a(aVar, this.b.duplicate());
                i5 = aVar.b;
                if (i3 <= i5 || aVar.f1503a == 11) {
                    break;
                }
                a(a5);
                a(aVar.f1503a);
            }
        } catch (h | BufferUnderflowException unused) {
        }
        return i3 == i5;
    }

    private boolean[] d(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    boolean[] zArr = new boolean[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        zArr[i5] = a(0, true);
                    }
                    return zArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private short[] e(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    short[] sArr = new short[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        sArr[i5] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private int[] f(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    int[] iArr = new int[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        iArr[i5] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private long[] g(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    long[] jArr = new long[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        jArr[i5] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private float[] h(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    float[] fArr = new float[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        fArr[i5] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private double[] i(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 9) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    double[] dArr = new double[a5];
                    for (int i5 = 0; i5 < a5; i5++) {
                        dArr[i5] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a5)));
            }
            throw new h("type mismatch.");
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.b = ByteBuffer.wrap(bArr);
    }

    public final byte[] c(int i3, boolean z3) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            byte b = aVar.f1503a;
            if (b != 9) {
                if (b == 13) {
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.f1503a == 0) {
                        int a5 = a(0, 0, true);
                        if (a5 >= 0) {
                            byte[] bArr = new byte[a5];
                            this.b.get(bArr);
                            return bArr;
                        }
                        StringBuilder m5 = a1.i.m("invalid size, tag: ", i3, ", type: ");
                        m5.append((int) aVar.f1503a);
                        m5.append(", ");
                        m5.append((int) aVar2.f1503a);
                        m5.append(", size: ");
                        m5.append(a5);
                        throw new h(m5.toString());
                    }
                    StringBuilder m6 = a1.i.m("type mismatch, tag: ", i3, ", type: ");
                    m6.append((int) aVar.f1503a);
                    m6.append(", ");
                    m6.append((int) aVar2.f1503a);
                    throw new h(m6.toString());
                }
                throw new h("type mismatch.");
            }
            int a6 = a(0, 0, true);
            if (a6 >= 0) {
                byte[] bArr2 = new byte[a6];
                for (int i5 = 0; i5 < a6; i5++) {
                    bArr2[i5] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new h("size invalid: ".concat(String.valueOf(a6)));
        } else if (!z3) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public k(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f1503a = (byte) (b & 15);
        int i3 = (b & 240) >> 4;
        aVar.b = i3;
        if (i3 == 15) {
            aVar.b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    public k(byte[] bArr, byte b) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f1503a);
    }

    private void a(a aVar) {
        a(aVar, this.b);
    }

    private void a(int i3) {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(byteBuffer.position() + i3);
    }

    public final String b(int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b == 6) {
            int i5 = this.b.get();
            if (i5 < 0) {
                i5 += 256;
            }
            byte[] bArr = new byte[i5];
            this.b.get(bArr);
            try {
                return new String(bArr, this.f1502a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i6 = this.b.getInt();
            if (i6 <= 104857600 && i6 >= 0) {
                byte[] bArr2 = new byte[i6];
                this.b.get(bArr2);
                try {
                    return new String(bArr2, this.f1502a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: ".concat(String.valueOf(i6)));
        } else {
            throw new h("type mismatch.");
        }
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f1503a);
        } while (aVar.f1503a != 11);
    }

    private void a(byte b) {
        int i3 = 0;
        switch (b) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i5 = this.b.get();
                if (i5 < 0) {
                    i5 += 256;
                }
                a(i5);
                return;
            case 7:
                a(this.b.getInt());
                return;
            case 8:
                int a5 = a(0, 0, true);
                while (i3 < a5 * 2) {
                    b();
                    i3++;
                }
                return;
            case 9:
                int a6 = a(0, 0, true);
                while (i3 < a6) {
                    b();
                    i3++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f1503a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                StringBuilder m5 = a1.i.m("skipField with invalid type, type value: ", b, ", ");
                m5.append((int) aVar.f1503a);
                throw new h(m5.toString());
            default:
                throw new h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t4, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f1503a == 9) {
            int a5 = a(0, 0, true);
            if (a5 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t4.getClass(), a5));
                for (int i5 = 0; i5 < a5; i5++) {
                    tArr[i5] = a((k) t4, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a5)));
        }
        throw new h("type mismatch.");
    }

    public final boolean a(int i3, boolean z3) {
        return a((byte) 0, i3, z3) != 0;
    }

    public final byte a(byte b, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        a(aVar);
        byte b5 = aVar.f1503a;
        if (b5 != 0) {
            if (b5 == 12) {
                return (byte) 0;
            }
            throw new h("type mismatch.");
        }
        return this.b.get();
    }

    public final short a(short s, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new h("type mismatch.");
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public final int a(int i3, int i5, boolean z3) {
        if (!b(i5)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return i3;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new h("type mismatch.");
                }
                return this.b.getInt();
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public final long a(long j2, int i3, boolean z3) {
        int i5;
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return j2;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b == 0) {
            i5 = this.b.get();
        } else if (b == 1) {
            i5 = this.b.getShort();
        } else if (b != 2) {
            if (b != 3) {
                if (b == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            return this.b.getLong();
        } else {
            i5 = this.b.getInt();
        }
        return i5;
    }

    private float a(float f4, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return f4;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new h("type mismatch.");
        }
        return this.b.getFloat();
    }

    private double a(double d, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f1503a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return 0.0d;
                }
                throw new h("type mismatch.");
            }
            return this.b.getDouble();
        }
        return this.b.getFloat();
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i3, boolean z3) {
        return (HashMap) a(new HashMap(), map, i3, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i3, boolean z3) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (b(i3)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f1503a == 8) {
                    int a5 = a(0, 0, true);
                    if (a5 < 0) {
                        throw new h("size invalid: ".concat(String.valueOf(a5)));
                    }
                    for (int i5 = 0; i5 < a5; i5++) {
                        map.put(a((k) key, 0, true), a((k) value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z3) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i3, boolean z3) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i3, z3);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i3, boolean z3) {
        if (list != null && !list.isEmpty()) {
            Object[] b = b(list.get(0), i3, z3);
            if (b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final m a(m mVar, int i3, boolean z3) {
        if (!b(i3)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f1503a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e5) {
            throw new h(e5.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t4, int i3, boolean z3) {
        if (t4 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i3, z3));
        }
        if (t4 instanceof Boolean) {
            return Boolean.valueOf(a(i3, z3));
        }
        if (t4 instanceof Short) {
            return Short.valueOf(a((short) 0, i3, z3));
        }
        if (t4 instanceof Integer) {
            return Integer.valueOf(a(0, i3, z3));
        }
        if (t4 instanceof Long) {
            return Long.valueOf(a(0L, i3, z3));
        }
        if (t4 instanceof Float) {
            return Float.valueOf(a(0.0f, i3, z3));
        }
        if (t4 instanceof Double) {
            return Double.valueOf(a(0.0d, i3, z3));
        }
        if (t4 instanceof String) {
            return String.valueOf(b(i3, z3));
        }
        if (t4 instanceof Map) {
            return a((Map) t4, i3, z3);
        }
        if (t4 instanceof List) {
            return a((List) t4, i3, z3);
        }
        if (t4 instanceof m) {
            return a((m) t4, i3, z3);
        }
        if (t4.getClass().isArray()) {
            if (!(t4 instanceof byte[]) && !(t4 instanceof Byte[])) {
                if (t4 instanceof boolean[]) {
                    return d(i3, z3);
                }
                if (t4 instanceof short[]) {
                    return e(i3, z3);
                }
                if (t4 instanceof int[]) {
                    return f(i3, z3);
                }
                if (t4 instanceof long[]) {
                    return g(i3, z3);
                }
                if (t4 instanceof float[]) {
                    return h(i3, z3);
                }
                if (t4 instanceof double[]) {
                    return i(i3, z3);
                }
                return a((Object[]) t4, i3, z3);
            }
            return c(i3, z3);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f1502a = str;
        return 0;
    }
}
