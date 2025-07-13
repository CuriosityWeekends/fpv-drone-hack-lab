package j0;

import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2206a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(Object obj, int i3, int i5) {
        this.f2206a = i5;
        this.c = obj;
        this.b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f4;
        int i3 = this.b;
        Object obj = this.c;
        switch (this.f2206a) {
            case 0:
                e eVar = ((d) obj).b;
                if (i3 != -3) {
                    if (i3 != -2) {
                        if (i3 != -1) {
                            if (i3 != 1) {
                                eVar.getClass();
                                Log.w("AudioFocusManager", "Unknown focus change type: " + i3);
                                return;
                            }
                            eVar.d = 1;
                        } else {
                            eVar.d = -1;
                        }
                    } else {
                        eVar.d = 2;
                    }
                } else {
                    eVar.d = 3;
                }
                int i5 = eVar.d;
                p0 p0Var = eVar.c;
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    throw new IllegalStateException("Unknown audio focus state: " + eVar.d);
                                }
                            } else {
                                q0 q0Var = p0Var.f2282a;
                                q0Var.O(0, q0Var.j());
                            }
                        } else {
                            q0 q0Var2 = p0Var.f2282a;
                            q0Var2.O(1, q0Var2.j());
                        }
                    }
                } else {
                    q0 q0Var3 = p0Var.f2282a;
                    q0Var3.O(-1, q0Var3.j());
                    eVar.a();
                }
                if (eVar.d == 3) {
                    f4 = 0.2f;
                } else {
                    f4 = 1.0f;
                }
                if (eVar.f2224e != f4) {
                    eVar.f2224e = f4;
                    p0Var.f2282a.G();
                    return;
                }
                return;
            default:
                c1.b bVar = (c1.b) obj;
                bVar.getClass();
                int i6 = g2.w.f1960a;
                ((l0.i) bVar.c).onAudioSessionId(i3);
                return;
        }
    }
}
