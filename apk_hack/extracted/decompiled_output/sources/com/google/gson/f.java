package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f503a;
    public static final /* synthetic */ f[] b;

    static {
        a aVar = new a();
        f503a = aVar;
        b = new f[]{aVar, new f() { // from class: com.google.gson.b
            @Override // com.google.gson.f
            public final String b(Field field) {
                return f.c(field.getName());
            }
        }, new f() { // from class: com.google.gson.c
            @Override // com.google.gson.f
            public final String b(Field field) {
                return f.c(f.a(field.getName(), " "));
            }
        }, new f() { // from class: com.google.gson.d
            @Override // com.google.gson.f
            public final String b(Field field) {
                return f.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        }, new f() { // from class: com.google.gson.e
            @Override // com.google.gson.f
            public final String b(Field field) {
                return f.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        int i3;
        String valueOf;
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i5 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i5++;
            charAt = str.charAt(i5);
        }
        if (!Character.isUpperCase(charAt)) {
            char upperCase = Character.toUpperCase(charAt);
            if (i5 + 1 < str.length()) {
                valueOf = upperCase + str.substring(i3);
            } else {
                valueOf = String.valueOf(upperCase);
            }
            sb.append(valueOf);
            return sb.toString();
        }
        return str;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) b.clone();
    }

    public abstract String b(Field field);
}
