package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c0.n;
import com.bumptech.glide.b;
import com.bumptech.glide.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import o1.g;
import t2.p0;
import v.f;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final g f282a;
    public final p0 b;
    public final HashSet c;
    public SupportRequestManagerFragment d;

    /* renamed from: e  reason: collision with root package name */
    public p f283e;

    /* renamed from: f  reason: collision with root package name */
    public Fragment f284f;

    public SupportRequestManagerFragment() {
        g gVar = new g();
        this.b = new p0(2, this);
        this.c = new HashSet();
        this.f282a = gVar;
    }

    public final void a(Context context, FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.c.remove(this);
            this.d = null;
        }
        SupportRequestManagerFragment e5 = b.b(context).f236f.e(fragmentManager);
        this.d = e5;
        if (!equals(e5)) {
            this.d.c.add(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            a(getContext(), fragmentManager);
        } catch (IllegalStateException e5) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e5);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        g gVar = this.f282a;
        gVar.b = true;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).i();
        }
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.c.remove(this);
            this.d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f284f = null;
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.c.remove(this);
            this.d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        g gVar = this.f282a;
        gVar.f2975a = true;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        g gVar = this.f282a;
        gVar.f2975a = false;
        Iterator it = n.d((Set) gVar.c).iterator();
        while (it.hasNext()) {
            ((f) it.next()).onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f284f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
