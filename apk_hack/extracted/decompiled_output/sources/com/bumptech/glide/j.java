package com.bumptech.glide;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f252a;
    public static final j b;
    public static final j c;
    public static final j d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ j[] f253e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, com.bumptech.glide.j] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.bumptech.glide.j] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.bumptech.glide.j] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.bumptech.glide.j] */
    static {
        ?? r42 = new Enum("IMMEDIATE", 0);
        f252a = r42;
        ?? r5 = new Enum("HIGH", 1);
        b = r5;
        ?? r6 = new Enum("NORMAL", 2);
        c = r6;
        ?? r7 = new Enum("LOW", 3);
        d = r7;
        f253e = new j[]{r42, r5, r6, r7};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f253e.clone();
    }
}
