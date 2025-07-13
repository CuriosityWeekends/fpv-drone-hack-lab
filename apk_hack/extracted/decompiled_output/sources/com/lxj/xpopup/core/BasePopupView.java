package com.lxj.xpopup.core;

import a1.m;
import a3.b;
import a3.i;
import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import b3.c;
import b3.f;
import b3.g;
import b3.h;
import b3.o;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.lxj.xpopup.util.d;
import java.util.List;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BasePopupView extends FrameLayout implements LifecycleObserver, LifecycleOwner, ViewCompat.OnUnhandledKeyEventListenerCompat {

    /* renamed from: a  reason: collision with root package name */
    public m f1034a;
    public b b;
    public i c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public int f1035e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1036f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1037g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1038h;

    /* renamed from: i  reason: collision with root package name */
    public final LifecycleRegistry f1039i;

    /* renamed from: j  reason: collision with root package name */
    public o f1040j;

    /* renamed from: k  reason: collision with root package name */
    public final f f1041k;

    /* renamed from: l  reason: collision with root package name */
    public final g f1042l;

    /* renamed from: m  reason: collision with root package name */
    public final h f1043m;

    /* renamed from: n  reason: collision with root package name */
    public float f1044n;

    /* renamed from: o  reason: collision with root package name */
    public float f1045o;

    public BasePopupView(@NonNull Context context) {
        super(context);
        this.f1035e = 3;
        this.f1036f = false;
        this.f1037g = false;
        this.f1038h = new Handler(Looper.getMainLooper());
        this.f1041k = new f(this);
        this.f1042l = new g(this);
        this.f1043m = new h(this);
        if (!(context instanceof Application)) {
            this.f1039i = new LifecycleRegistry(this);
            this.d = ViewConfiguration.get(context).getScaledTouchSlop();
            setId(View.generateViewId());
            View inflate = LayoutInflater.from(context).inflate(getInnerLayoutId(), (ViewGroup) this, false);
            inflate.setAlpha(0.0f);
            addView(inflate);
            return;
        }
        throw new IllegalArgumentException("XPopup的Context必须是Activity类型！");
    }

    public void a() {
        View view;
        ViewCompat.removeOnUnhandledKeyEventListener(this, this);
        boolean z3 = this.f1036f;
        LifecycleRegistry lifecycleRegistry = this.f1039i;
        if (z3) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        lifecycleRegistry.removeObserver(this);
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
            this.f1034a.getClass();
            this.f1034a.getClass();
            this.f1034a = null;
        }
        o oVar = this.f1040j;
        if (oVar != null) {
            if (oVar.isShowing()) {
                this.f1040j.dismiss();
            }
            this.f1040j.f181a = null;
            this.f1040j = null;
        }
        i iVar = this.c;
        if (iVar != null && (view = iVar.c) != null) {
            view.animate().cancel();
        }
    }

    public void b() {
        this.f1038h.removeCallbacks(this.f1041k);
        int i3 = this.f1035e;
        if (i3 != 4 && i3 != 3) {
            this.f1035e = 4;
            clearFocus();
            this.f1039i.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            e();
            c();
        }
    }

    public void c() {
        Handler handler = this.f1038h;
        h hVar = this.f1043m;
        handler.removeCallbacks(hVar);
        handler.postDelayed(hVar, getAnimationDuration());
    }

    public final void d() {
        Handler handler = this.f1038h;
        g gVar = this.f1042l;
        handler.removeCallbacks(gVar);
        handler.postDelayed(gVar, getAnimationDuration());
    }

    public void e() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        this.f1034a.getClass();
        i iVar = this.c;
        if (iVar != null) {
            iVar.a();
        } else {
            this.f1034a.getClass();
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void f() {
        if (getActivity() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        View activityContentView = getActivityContentView();
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(activityContentView.getWidth(), activityContentView.getHeight());
        } else {
            marginLayoutParams.width = activityContentView.getWidth();
            marginLayoutParams.height = activityContentView.getHeight();
        }
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.topMargin = activityContentView.getTop();
        setLayoutParams(marginLayoutParams);
    }

    public void g() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        this.f1034a.getClass();
        i iVar = this.c;
        if (iVar != null) {
            iVar.b();
        } else {
            this.f1034a.getClass();
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public int getActivityContentLeft() {
        return 0;
    }

    public View getActivityContentView() {
        return ((ViewGroup) getActivity().getWindow().getDecorView()).getChildAt(0);
    }

    public int getAnimationDuration() {
        if (this.f1034a == null) {
            return 0;
        }
        return e.b + 1;
    }

    public Window getHostWindow() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        o oVar = this.f1040j;
        if (oVar == null) {
            return null;
        }
        return oVar.getWindow();
    }

    public int getImplLayoutId() {
        return -1;
    }

    public abstract int getInnerLayoutId();

    public List<String> getInternalFragmentNames() {
        return null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f1039i;
    }

    public int getMaxHeight() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
            return 0;
        }
        return 0;
    }

    public int getMaxWidth() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
            return 0;
        }
        return 0;
    }

    public int getNavBarHeight() {
        return com.lxj.xpopup.util.b.i(getHostWindow());
    }

    public b getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    public int getPopupHeight() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
            return 0;
        }
        return 0;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    public int getPopupWidth() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return 0;
        }
        return mVar.f39a;
    }

    public int getShadowBgColor() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        return e.d;
    }

    public int getStatusBarBgColor() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        return e.c;
    }

    public int getStatusBarHeight() {
        getHostWindow();
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public View getWindowDecorView() {
        if (getHostWindow() == null) {
            return null;
        }
        return (ViewGroup) getHostWindow().getDecorView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
        if (r6.get(r5) != null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r8 = this;
            r0 = 1
            a1.m r1 = r8.f1034a
            if (r1 == 0) goto Lb1
            r8.setFocusableInTouchMode(r0)
            r8.setFocusable(r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L18
            androidx.core.view.ViewCompat.removeOnUnhandledKeyEventListener(r8, r8)
            androidx.core.view.ViewCompat.addOnUnhandledKeyEventListener(r8, r8)
            goto L20
        L18:
            b3.i r1 = new b3.i
            r1.<init>(r8)
            r8.setOnKeyListener(r1)
        L20:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.view.View r3 = r8.getPopupContentView()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            com.lxj.xpopup.util.b.e(r1, r3)
            int r3 = r1.size()
            if (r3 <= 0) goto Lac
            android.view.Window r3 = r8.getHostWindow()
            android.view.WindowManager$LayoutParams r3 = r3.getAttributes()
            int r3 = r3.softInputMode
            a1.m r3 = r8.f1034a
            r3.getClass()
            r3 = 0
        L44:
            int r4 = r1.size()
            if (r3 >= r4) goto Lb1
            java.lang.Object r4 = r1.get(r3)
            android.widget.EditText r4 = (android.widget.EditText) r4
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L5b
            androidx.core.view.ViewCompat.removeOnUnhandledKeyEventListener(r4, r8)
            androidx.core.view.ViewCompat.addOnUnhandledKeyEventListener(r4, r8)
            goto L95
        L5b:
            java.lang.Class<android.view.View> r5 = android.view.View.class
            java.lang.String r6 = "getListenerInfo"
            r7 = 0
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> L8d
            boolean r6 = r5.isAccessible()     // Catch: java.lang.Exception -> L8d
            if (r6 != 0) goto L6d
            r5.setAccessible(r0)     // Catch: java.lang.Exception -> L8d
        L6d:
            java.lang.Object r5 = r5.invoke(r4, r7)     // Catch: java.lang.Exception -> L8d
            java.lang.String r6 = "android.view.View$ListenerInfo"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Exception -> L8d
            java.lang.String r7 = "mOnKeyListener"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch: java.lang.Exception -> L8d
            boolean r7 = r6.isAccessible()     // Catch: java.lang.Exception -> L8d
            if (r7 != 0) goto L86
            r6.setAccessible(r0)     // Catch: java.lang.Exception -> L8d
        L86:
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Exception -> L8d
            if (r5 == 0) goto L8d
            goto L95
        L8d:
            b3.i r5 = new b3.i
            r5.<init>(r8)
            r4.setOnKeyListener(r5)
        L95:
            if (r3 != 0) goto Laa
            a1.m r5 = r8.f1034a
            r5.getClass()
            r4.setFocusable(r0)
            r4.setFocusableInTouchMode(r0)
            r4.requestFocus()
            a1.m r4 = r8.f1034a
            r4.getClass()
        Laa:
            int r3 = r3 + r0
            goto L44
        Lac:
            a1.m r0 = r8.f1034a
            r0.getClass()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.core.BasePopupView.h():void");
    }

    public final void i() {
        getPopupContentView().setAlpha(1.0f);
        this.b = null;
        this.b = getPopupAnimator();
        if (this.f1034a != null) {
            this.c.c();
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public final boolean n(int i3, KeyEvent keyEvent) {
        m mVar;
        if (i3 != 4 || keyEvent.getAction() != 1 || (mVar = this.f1034a) == null) {
            return false;
        }
        mVar.getClass();
        if (com.lxj.xpopup.util.b.h(getHostWindow()) == 0) {
            b();
        } else {
            SparseArray sparseArray = d.f1115a;
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        }
        return true;
    }

    public final void o() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (this.f1034a != null) {
                int i3 = this.f1035e;
                if (i3 != 2 && i3 != 4) {
                    this.f1035e = 2;
                    o oVar = this.f1040j;
                    if (oVar != null && oVar.isShowing()) {
                        return;
                    }
                    activity.getWindow().getDecorView().findViewById(16908290).post(new c((ConfirmPopupView) this, 0));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("popupInfo is null, if your popup object is reused, do not set isDestroyOnDismiss(true) !");
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        getActivityContentView().post(new c(this, 1));
        return super.onApplyWindowInsets(windowInsets);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [a3.i, a3.b] */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c == null) {
            int animationDuration = getAnimationDuration();
            int shadowBgColor = getShadowBgColor();
            ?? bVar = new b(this, animationDuration, 0);
            bVar.f92f = new ArgbEvaluator();
            bVar.f93g = shadowBgColor;
            this.c = bVar;
        }
        this.f1034a.getClass();
        if (!(this instanceof AttachPopupView) && !(this instanceof BubbleAttachPopupView) && !(this instanceof PartShadowPopupView) && !(this instanceof PositionPopupView)) {
            if (!this.f1036f) {
                j();
            }
        } else {
            j();
        }
        if (!this.f1036f) {
            this.f1036f = true;
            k();
            this.f1039i.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.f1034a.getClass();
        }
        this.f1038h.post(this.f1041k);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getActivityContentView().post(new c(this, 2));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        onDetachedFromWindow();
        o oVar = this.f1040j;
        if (oVar != null) {
            oVar.dismiss();
        }
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getWindowDecorView() != null) {
            Window hostWindow = getHostWindow();
            SparseArray sparseArray = d.f1115a;
            View findViewById = hostWindow.findViewById(16908290);
            if (findViewById != null) {
                SparseArray sparseArray2 = d.f1115a;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) sparseArray2.get(getId());
                if (onGlobalLayoutListener != null) {
                    findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                    sparseArray2.remove(getId());
                }
            }
        }
        this.f1038h.removeCallbacksAndMessages(null);
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        if (getContext() != null && (getContext() instanceof FragmentActivity)) {
            ((FragmentActivity) getContext()).getLifecycle().removeObserver(this);
        }
        this.f1035e = 3;
        this.f1037g = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.View r1 = r8.getPopupImplView()
            r1.getGlobalVisibleRect(r0)
            float r1 = r9.getX()
            float r2 = r9.getY()
            boolean r0 = com.lxj.xpopup.util.b.l(r1, r2, r0)
            r1 = 1
            if (r0 != 0) goto L7d
            int r0 = r9.getAction()
            if (r0 == 0) goto L71
            if (r0 == r1) goto L3a
            r2 = 2
            if (r0 == r2) goto L2a
            r2 = 3
            if (r0 == r2) goto L3a
            goto L7d
        L2a:
            a1.m r9 = r8.f1034a
            if (r9 == 0) goto L7d
            r9.getClass()
            r8.b()
            a1.m r9 = r8.f1034a
            r9.getClass()
            goto L7d
        L3a:
            float r0 = r9.getX()
            float r2 = r8.f1044n
            float r0 = r0 - r2
            float r9 = r9.getY()
            float r2 = r8.f1045o
            float r9 = r9 - r2
            double r2 = (double) r0
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r2, r4)
            double r6 = (double) r9
            double r4 = java.lang.Math.pow(r6, r4)
            double r4 = r4 + r2
            double r2 = java.lang.Math.sqrt(r4)
            float r9 = (float) r2
            a1.m r0 = r8.f1034a
            int r2 = r8.d
            float r2 = (float) r2
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 >= 0) goto L6b
            if (r0 == 0) goto L6b
            r0.getClass()
            r8.b()
        L6b:
            r9 = 0
            r8.f1044n = r9
            r8.f1045o = r9
            goto L7d
        L71:
            float r0 = r9.getX()
            r8.f1044n = r0
            float r9 = r9.getY()
            r8.f1045o = r9
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.core.BasePopupView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat
    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return n(keyEvent.getKeyCode(), keyEvent);
    }
}
