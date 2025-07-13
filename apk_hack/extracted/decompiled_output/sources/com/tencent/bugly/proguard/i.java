package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f1499a;
    private int b;

    public i(StringBuilder sb, int i3) {
        this.f1499a = sb;
        this.b = i3;
    }

    private void a(String str) {
        for (int i3 = 0; i3 < this.b; i3++) {
            this.f1499a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f1499a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final i a(boolean z3, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(z3 ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final i a(byte b, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    private i a(char c, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(c);
        sb.append('\n');
        return this;
    }

    public final i a(short s, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final i a(int i3, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(i3);
        sb.append('\n');
        return this;
    }

    public final i a(long j2, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(j2);
        sb.append('\n');
        return this;
    }

    private i a(float f4, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(f4);
        sb.append('\n');
        return this;
    }

    private i a(double d, String str) {
        a(str);
        StringBuilder sb = this.f1499a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f1499a.append("null\n");
        } else {
            StringBuilder sb = this.f1499a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (byte b : bArr) {
                iVar.a(b, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(sArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (short s : sArr) {
                iVar.a(s, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(iArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (int i3 : iArr) {
                iVar.a(i3, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(jArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (long j2 : jArr) {
                iVar.a(j2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(fArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (float f4 : fArr) {
                iVar.a(f4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(dArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (double d : dArr) {
                iVar.a(d, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f1499a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(map.size());
            sb2.append(", {\n");
            i iVar = new i(this.f1499a, this.b + 1);
            i iVar2 = new i(this.f1499a, this.b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                iVar.a('(', (String) null);
                iVar2.a((i) entry.getKey(), (String) null);
                iVar2.a((i) entry.getValue(), (String) null);
                iVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f1499a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f1499a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f1499a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f1499a, this.b + 1);
            for (T t4 : tArr) {
                iVar.a((i) t4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f1499a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t4, String str) {
        if (t4 == null) {
            this.f1499a.append("null\n");
        } else if (t4 instanceof Byte) {
            a(((Byte) t4).byteValue(), str);
        } else if (t4 instanceof Boolean) {
            a(((Boolean) t4).booleanValue(), str);
        } else if (t4 instanceof Short) {
            a(((Short) t4).shortValue(), str);
        } else if (t4 instanceof Integer) {
            a(((Integer) t4).intValue(), str);
        } else if (t4 instanceof Long) {
            a(((Long) t4).longValue(), str);
        } else if (t4 instanceof Float) {
            a(((Float) t4).floatValue(), str);
        } else if (t4 instanceof Double) {
            a(((Double) t4).doubleValue(), str);
        } else if (t4 instanceof String) {
            a((String) t4, str);
        } else if (t4 instanceof Map) {
            a((Map) t4, str);
        } else if (t4 instanceof List) {
            a((Collection) ((List) t4), str);
        } else if (t4 instanceof m) {
            a((m) t4, str);
        } else if (t4 instanceof byte[]) {
            a((byte[]) t4, str);
        } else if (t4 instanceof boolean[]) {
            a((i) ((boolean[]) t4), str);
        } else if (t4 instanceof short[]) {
            a((short[]) t4, str);
        } else if (t4 instanceof int[]) {
            a((int[]) t4, str);
        } else if (t4 instanceof long[]) {
            a((long[]) t4, str);
        } else if (t4 instanceof float[]) {
            a((float[]) t4, str);
        } else if (t4 instanceof double[]) {
            a((double[]) t4, str);
        } else if (t4.getClass().isArray()) {
            a((Object[]) t4, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f1499a;
            sb.append('\t');
            sb.append("null");
        } else {
            mVar.a(this.f1499a, this.b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
