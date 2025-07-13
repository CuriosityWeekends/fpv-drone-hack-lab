package i;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 extends Exception {

    /* renamed from: f  reason: collision with root package name */
    public static final StackTraceElement[] f2047f = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public final List f2048a;
    public g.e b;
    public int c;
    public Class d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2049e;

    public c0(String str) {
        this(str, Collections.emptyList());
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (th instanceof c0) {
            for (Throwable th2 : ((c0) th).f2048a) {
                a(th2, arrayList);
            }
            return;
        }
        arrayList.add(th);
    }

    public static void b(List list, b0 b0Var) {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            b0Var.append("Cause (");
            int i5 = i3 + 1;
            b0Var.append(String.valueOf(i5));
            b0Var.append(" of ");
            b0Var.append(String.valueOf(size));
            b0Var.append("): ");
            Throwable th = (Throwable) list.get(i3);
            if (th instanceof c0) {
                ((c0) th).e(b0Var);
            } else {
                c(th, b0Var);
            }
            i3 = i5;
        }
    }

    public static void c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i5 = i3 + 1;
            sb.append(i5);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i3));
            i3 = i5;
        }
    }

    public final void e(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.f2048a, new b0(appendable));
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f2049e);
        String str3 = "";
        if (this.d == null) {
            str = "";
        } else {
            str = ", " + this.d;
        }
        sb.append(str);
        int i3 = this.c;
        if (i3 == 0) {
            str2 = "";
        } else {
            str2 = ", ".concat(a1.i.z(i3));
        }
        sb.append(str2);
        if (this.b != null) {
            str3 = ", " + this.b;
        }
        sb.append(str3);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        e(System.err);
    }

    public c0(String str, List list) {
        this.f2049e = str;
        setStackTrace(f2047f);
        this.f2048a = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
