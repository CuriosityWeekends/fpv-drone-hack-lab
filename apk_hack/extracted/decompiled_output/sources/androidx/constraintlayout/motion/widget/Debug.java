package androidx.constraintlayout.motion.widget;

import a1.i;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            PrintStream printStream = System.out;
            StringBuilder o5 = i.o(str2, "     ");
            o5.append(getName(childAt));
            printStream.println(o5.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + field.getName() + " " + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder o5 = i.o(str, "------------- ");
        o5.append(cls.getName());
        o5.append(" --------------------");
        printStream.println(o5.toString());
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(str + "    " + field.getName() + " " + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder o6 = i.o(str, "------------- ");
        o6.append(cls.getSimpleName());
        o6.append(" --------------------");
        printStream2.println(o6.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        Field[] fields;
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i3) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i3 + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i3) {
        if (i3 == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i3);
    }

    public static void logStack(String str, String str2, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i3, stackTrace.length - 1);
        String str3 = " ";
        for (int i5 = 1; i5 <= min; i5++) {
            StackTraceElement stackTraceElement = stackTrace[i5];
            str3 = i.h(str3, " ");
            Log.v(str, str2 + str3 + (".(" + stackTrace[i5].getFileName() + ":" + stackTrace[i5].getLineNumber() + ") " + stackTrace[i5].getMethodName()) + str3);
        }
    }

    public static void printStack(String str, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i3, stackTrace.length - 1);
        String str2 = " ";
        for (int i5 = 1; i5 <= min; i5++) {
            StackTraceElement stackTraceElement = stackTrace[i5];
            str2 = i.h(str2, " ");
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i5].getFileName() + ":" + stackTrace[i5].getLineNumber() + ") ") + str2);
        }
    }

    public static String getName(Context context, int i3) {
        if (i3 != -1) {
            try {
                return context.getResources().getResourceEntryName(i3);
            } catch (Exception unused) {
                return i.e(i3, "?");
            }
        }
        return "UNKNOWN";
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        try {
            String str2 = iArr.length + "[";
            int i3 = 0;
            while (i3 < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(i3 == 0 ? "" : " ");
                String sb2 = sb.toString();
                try {
                    str = context.getResources().getResourceEntryName(iArr[i3]);
                } catch (Resources.NotFoundException unused) {
                    str = "? " + iArr[i3] + " ";
                }
                str2 = sb2 + str;
                i3++;
            }
            return str2 + "]";
        } catch (Exception e5) {
            Log.v("DEBUG", e5.toString());
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        Field[] fields;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        PrintStream printStream = System.out;
        StringBuilder p5 = i.p(" >>>>>>>>>>>>>>>>>>. dump ", str2, "  ");
        p5.append(layoutParams.getClass().getName());
        printStream.println(p5.toString());
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(str2 + "       " + name + " " + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }
}
