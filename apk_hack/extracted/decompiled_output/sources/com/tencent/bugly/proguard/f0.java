package com.tencent.bugly.proguard;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1487a;
    public final /* synthetic */ String b;

    public f0(String str, String str2) {
        this.f1487a = str;
        this.b = str2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        if (str == null || !str.startsWith(this.f1487a) || !str.endsWith(this.b)) {
            return false;
        }
        return true;
    }
}
