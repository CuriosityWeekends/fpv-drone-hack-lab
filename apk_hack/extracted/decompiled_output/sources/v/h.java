package v;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import c0.n;
import com.bumptech.glide.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import t2.p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final o1.g f3783a;
    public final p0 b;
    public final HashSet c;
    public p d;

    /* renamed from: e  reason: collision with root package name */
    public h f3784e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f3785f;

    public h() {
        o1.g gVar = new o1.g();
        this.b = new p0(1, this);
        this.c = new HashSet();
        this.f3783a = gVar;
    }

    public final void a(Activity activity) {
        h hVar = this.f3784e;
        if (hVar != null) {
            hVar.c.remove(this);
            this.f3784e = null;
        }
        i iVar = com.bumptech.glide.b.b(activity).f236f;
        iVar.getClass();
        h d = iVar.d(activity.getFragmentManager());
        this.f3784e = d;
        if (!equals(d)) {
            this.f3784e.c.add(this);
        }
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e5) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e5);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        o1.g gVar = this.f3783a;
        gVar.b = true;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).i();
        }
        h hVar = this.f3784e;
        if (hVar != null) {
            hVar.c.remove(this);
            this.f3784e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        h hVar = this.f3784e;
        if (hVar != null) {
            hVar.c.remove(this);
            this.f3784e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        o1.g gVar = this.f3783a;
        gVar.f2975a = true;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        o1.g gVar = this.f3783a;
        gVar.f2975a = false;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).onStop();
        }
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f3785f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
