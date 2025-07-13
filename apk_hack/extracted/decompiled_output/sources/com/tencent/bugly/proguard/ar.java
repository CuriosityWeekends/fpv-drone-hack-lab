package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ar implements Comparable<ar> {

    /* renamed from: a  reason: collision with root package name */
    public long f1316a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1317e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f1318f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        int i3;
        ar arVar2 = arVar;
        if (arVar2 != null && this.b - arVar2.b <= 0) {
            if (i3 < 0) {
                return -1;
            }
            return 0;
        }
        return 1;
    }
}
