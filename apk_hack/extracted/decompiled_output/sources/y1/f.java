package y1;

import android.text.Layout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f4248a;
    public int b;
    public boolean c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4249e;

    /* renamed from: f  reason: collision with root package name */
    public int f4250f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f4251g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f4252h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f4253i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f4254j = -1;

    /* renamed from: k  reason: collision with root package name */
    public float f4255k;

    /* renamed from: l  reason: collision with root package name */
    public String f4256l;

    /* renamed from: m  reason: collision with root package name */
    public Layout.Alignment f4257m;

    public final void a(f fVar) {
        if (fVar != null) {
            if (!this.c && fVar.c) {
                this.b = fVar.b;
                this.c = true;
            }
            if (this.f4252h == -1) {
                this.f4252h = fVar.f4252h;
            }
            if (this.f4253i == -1) {
                this.f4253i = fVar.f4253i;
            }
            if (this.f4248a == null) {
                this.f4248a = fVar.f4248a;
            }
            if (this.f4250f == -1) {
                this.f4250f = fVar.f4250f;
            }
            if (this.f4251g == -1) {
                this.f4251g = fVar.f4251g;
            }
            if (this.f4257m == null) {
                this.f4257m = fVar.f4257m;
            }
            if (this.f4254j == -1) {
                this.f4254j = fVar.f4254j;
                this.f4255k = fVar.f4255k;
            }
            if (!this.f4249e && fVar.f4249e) {
                this.d = fVar.d;
                this.f4249e = true;
            }
        }
    }
}
