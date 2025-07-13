package com.google.gson;

import java.lang.reflect.Field;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public enum a extends f {
    public a() {
        super("IDENTITY", 0);
    }

    @Override // com.google.gson.f
    public final String b(Field field) {
        return field.getName();
    }
}
