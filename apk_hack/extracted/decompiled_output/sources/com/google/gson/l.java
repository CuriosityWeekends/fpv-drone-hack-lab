package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class l {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            p2.b bVar = new p2.b(stringWriter);
            bVar.f3223e = true;
            m2.j jVar = m2.l.f2851a;
            m2.e.c(bVar, this);
            return stringWriter.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
