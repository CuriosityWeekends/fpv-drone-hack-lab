package j4;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a  reason: collision with root package name */
    public final List f2484a;
    public final String b;
    public Throwable c;

    public c(Throwable... thArr) {
        List<Throwable> asList = Arrays.asList(thArr);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (asList != null) {
            for (Throwable th : asList) {
                if (th instanceof c) {
                    linkedHashSet.addAll(((c) th).f2484a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.f2484a = unmodifiableList;
            this.b = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public static void a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public final void b(b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i3 = 1;
        for (Throwable th : this.f2484a) {
            sb.append("  ComposedException ");
            sb.append(i3);
            sb.append(" :\n");
            a(sb, th, "\t");
            i3++;
        }
        bVar.s(sb.toString());
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        int i3;
        String[] split;
        try {
            if (this.c == null) {
                String property = System.getProperty("line.separator");
                if (this.f2484a.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.f2484a.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable th : this.f2484a) {
                        int i5 = 0;
                        while (true) {
                            if (th != null) {
                                for (int i6 = 0; i6 < i5; i6++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append(th.getClass().getCanonicalName());
                                sb.append(": ");
                                String message = th.getMessage();
                                if (message != null && message.contains(property)) {
                                    sb.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i7 = 0; i7 < i5 + 2; i7++) {
                                            sb.append("  ");
                                        }
                                        sb.append(str);
                                        sb.append(property);
                                    }
                                } else {
                                    sb.append(message);
                                    sb.append(property);
                                }
                                int i8 = 0;
                                while (true) {
                                    i3 = i5 + 2;
                                    if (i8 >= i3) {
                                        break;
                                    }
                                    sb.append("  ");
                                    i8++;
                                }
                                StackTraceElement[] stackTrace = th.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb.append("at ");
                                    sb.append(stackTrace[0]);
                                    sb.append(property);
                                }
                                if (!identityHashMap.containsKey(th)) {
                                    identityHashMap.put(th, Boolean.TRUE);
                                    th = th.getCause();
                                    i5++;
                                } else {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        for (int i9 = 0; i9 < i3; i9++) {
                                            sb.append("  ");
                                        }
                                        sb.append("|-- ");
                                        sb.append("(cause not expanded again) ");
                                        sb.append(cause.getClass().getCanonicalName());
                                        sb.append(": ");
                                        sb.append(cause.getMessage());
                                        sb.append(property);
                                    }
                                }
                            }
                        }
                    }
                    this.c = new RuntimeException(sb.toString().trim());
                } else {
                    this.c = (Throwable) this.f2484a.get(0);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.c;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        b(new b(0, printStream));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        b(new b(1, printWriter));
    }
}
