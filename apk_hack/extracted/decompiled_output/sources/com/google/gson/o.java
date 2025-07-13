package com.google.gson;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final l2.k f511a = new l2.k();

    public final boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof o) || !((o) obj).f511a.equals(this.f511a))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f511a.hashCode();
    }
}
