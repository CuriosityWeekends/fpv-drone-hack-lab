package v;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import c0.n;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.bumptech.glide.p;
import java.util.HashMap;
import p.u;
import t2.d0;
import t2.p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements Handler.Callback {

    /* renamed from: g  reason: collision with root package name */
    public static final d0 f3786g = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile p f3787a;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final Handler d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f3788e;

    /* renamed from: f  reason: collision with root package name */
    public final d f3789f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [v.d] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public i(com.bumptech.glide.h hVar) {
        ?? r32;
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.f3788e = f3786g;
        this.d = new Handler(Looper.getMainLooper(), this);
        if (u.f3084h && u.f3083g) {
            if (hVar.b.containsKey(com.bumptech.glide.e.class)) {
                r32 = new Object();
            } else {
                r32 = new Object();
            }
        } else {
            r32 = new Object();
        }
        this.f3789f = r32;
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, v.e] */
    /* JADX WARN: Type inference failed for: r3v0, types: [v.j, java.lang.Object] */
    public final p b(Context context) {
        boolean z3;
        if (context != null) {
            char[] cArr = n.f199a;
            if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return c((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    boolean z5 = false;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        return b(activity.getApplicationContext());
                    }
                    if (activity instanceof FragmentActivity) {
                        return c((FragmentActivity) activity);
                    }
                    if (!activity.isDestroyed()) {
                        this.f3789f.getClass();
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        Activity a5 = a(activity);
                        z5 = (a5 == null || !a5.isFinishing()) ? true : true;
                        h d = d(fragmentManager);
                        p pVar = d.d;
                        if (pVar == null) {
                            com.bumptech.glide.b b = com.bumptech.glide.b.b(activity);
                            p0 p0Var = d.b;
                            this.f3788e.getClass();
                            p pVar2 = new p(b, d.f3783a, p0Var, activity);
                            if (z5) {
                                pVar2.onStart();
                            }
                            d.d = pVar2;
                            return pVar2;
                        }
                        return pVar;
                    }
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return b(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.f3787a == null) {
                synchronized (this) {
                    try {
                        if (this.f3787a == null) {
                            com.bumptech.glide.b b5 = com.bumptech.glide.b.b(context.getApplicationContext());
                            d0 d0Var = this.f3788e;
                            ?? obj = new Object();
                            ?? obj2 = new Object();
                            Context applicationContext = context.getApplicationContext();
                            d0Var.getClass();
                            this.f3787a = new p(b5, obj, obj2, applicationContext);
                        }
                    } finally {
                    }
                }
            }
            return this.f3787a;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final p c(FragmentActivity fragmentActivity) {
        boolean z3;
        char[] cArr = n.f199a;
        boolean z5 = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return b(fragmentActivity.getApplicationContext());
        }
        if (!fragmentActivity.isDestroyed()) {
            this.f3789f.getClass();
            androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Activity a5 = a(fragmentActivity);
            z5 = (a5 == null || !a5.isFinishing()) ? true : true;
            SupportRequestManagerFragment e5 = e(supportFragmentManager);
            p pVar = e5.f283e;
            if (pVar == null) {
                com.bumptech.glide.b b = com.bumptech.glide.b.b(fragmentActivity);
                this.f3788e.getClass();
                p pVar2 = new p(b, e5.f282a, e5.b, fragmentActivity);
                if (z5) {
                    pVar2.onStart();
                }
                e5.f283e = pVar2;
                return pVar2;
            }
            return pVar;
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public final h d(FragmentManager fragmentManager) {
        h hVar = (h) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (hVar == null) {
            HashMap hashMap = this.b;
            h hVar2 = (h) hashMap.get(fragmentManager);
            if (hVar2 == null) {
                hVar2 = new h();
                hVar2.f3785f = null;
                hashMap.put(fragmentManager, hVar2);
                fragmentManager.beginTransaction().add(hVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.d.obtainMessage(1, fragmentManager).sendToTarget();
            }
            return hVar2;
        }
        return hVar;
    }

    public final SupportRequestManagerFragment e(androidx.fragment.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            HashMap hashMap = this.c;
            SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) hashMap.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                supportRequestManagerFragment2 = new SupportRequestManagerFragment();
                supportRequestManagerFragment2.f284f = null;
                hashMap.put(fragmentManager, supportRequestManagerFragment2);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.d.obtainMessage(2, fragmentManager).sendToTarget();
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        Object obj3;
        int i3 = message.what;
        boolean z3 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                obj3 = null;
                z3 = false;
                obj2 = null;
                if (z3 && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z3;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.c.remove(obj);
        } else {
            obj = (FragmentManager) message.obj;
            remove = this.b.remove(obj);
        }
        Object obj4 = remove;
        obj2 = obj;
        obj3 = obj4;
        if (z3) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z3;
    }
}
