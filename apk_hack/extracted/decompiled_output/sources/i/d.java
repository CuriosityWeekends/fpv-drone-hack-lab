package i;

import java.io.File;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements g, com.bumptech.glide.load.data.d {

    /* renamed from: a  reason: collision with root package name */
    public final List f2050a;
    public final h b;
    public final f c;
    public int d = -1;

    /* renamed from: e  reason: collision with root package name */
    public g.e f2051e;

    /* renamed from: f  reason: collision with root package name */
    public List f2052f;

    /* renamed from: g  reason: collision with root package name */
    public int f2053g;

    /* renamed from: h  reason: collision with root package name */
    public volatile m.p f2054h;

    /* renamed from: i  reason: collision with root package name */
    public File f2055i;

    public d(List list, h hVar, f fVar) {
        this.f2050a = list;
        this.b = hVar;
        this.c = fVar;
    }

    @Override // i.g
    public final boolean c() {
        while (true) {
            List list = this.f2052f;
            boolean z3 = false;
            if (list != null && this.f2053g < list.size()) {
                this.f2054h = null;
                while (!z3 && this.f2053g < this.f2052f.size()) {
                    List list2 = this.f2052f;
                    int i3 = this.f2053g;
                    this.f2053g = i3 + 1;
                    File file = this.f2055i;
                    h hVar = this.b;
                    this.f2054h = ((m.q) list2.get(i3)).a(file, hVar.f2060e, hVar.f2061f, hVar.f2064i);
                    if (this.f2054h != null && this.b.c(this.f2054h.c.a()) != null) {
                        this.f2054h.c.c(this.b.f2070o, this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.d + 1;
            this.d = i5;
            if (i5 >= this.f2050a.size()) {
                return false;
            }
            g.e eVar = (g.e) this.f2050a.get(this.d);
            h hVar2 = this.b;
            File d = hVar2.f2063h.a().d(new e(eVar, hVar2.f2069n));
            this.f2055i = d;
            if (d != null) {
                this.f2051e = eVar;
                this.f2052f = this.b.c.b.g(d);
                this.f2053g = 0;
            }
        }
    }

    @Override // i.g
    public final void cancel() {
        m.p pVar = this.f2054h;
        if (pVar != null) {
            pVar.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Exception exc) {
        this.c.d(this.f2051e, exc, this.f2054h.c, 3);
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object obj) {
        this.c.b(this.f2051e, obj, this.f2054h.c, 3, this.f2051e);
    }
}
