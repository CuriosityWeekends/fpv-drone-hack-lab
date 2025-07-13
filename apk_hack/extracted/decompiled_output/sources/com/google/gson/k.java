package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends l implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f509a = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof k) || !((k) obj).f509a.equals(this.f509a))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f509a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f509a.iterator();
    }
}
