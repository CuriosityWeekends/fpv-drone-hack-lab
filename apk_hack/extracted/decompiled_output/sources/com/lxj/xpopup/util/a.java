package com.lxj.xpopup.util;

import a1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1095a = 0;
    public String b;
    public String c;

    public /* synthetic */ a() {
    }

    public final String toString() {
        switch (this.f1095a) {
            case 0:
                StringBuilder sb = new StringBuilder("RomInfo{name=");
                sb.append(this.b);
                sb.append(", version=");
                return i.k(sb, this.c, "}");
            default:
                return this.b + ", " + this.c;
        }
    }

    public a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }
}
