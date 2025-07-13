package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import c2.a;
import c2.f;
import c2.g;
import c2.h;
import c2.l;
import c2.m;
import c2.n;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import g2.b;
import g2.w;
import h2.i;
import j0.i0;
import j0.j;
import j0.k0;
import j0.l0;
import j0.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlayerView extends FrameLayout {

    /* renamed from: z  reason: collision with root package name */
    public static final /* synthetic */ int f460z = 0;

    /* renamed from: a  reason: collision with root package name */
    public final g f461a;
    public final AspectRatioFrameLayout b;
    public final View c;
    public final View d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f462e;

    /* renamed from: f  reason: collision with root package name */
    public final SubtitleView f463f;

    /* renamed from: g  reason: collision with root package name */
    public final View f464g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f465h;

    /* renamed from: i  reason: collision with root package name */
    public final PlayerControlView f466i;

    /* renamed from: j  reason: collision with root package name */
    public final FrameLayout f467j;

    /* renamed from: k  reason: collision with root package name */
    public final FrameLayout f468k;

    /* renamed from: l  reason: collision with root package name */
    public l0 f469l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f470m;

    /* renamed from: n  reason: collision with root package name */
    public f f471n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f472o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f473p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f474r;
    public CharSequence s;

    /* renamed from: t  reason: collision with root package name */
    public int f475t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f476u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f477v;
    public boolean w;

    /* renamed from: x  reason: collision with root package name */
    public int f478x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f479y;

    public PlayerView(Context context) {
        this(context, null);
    }

    public static void a(TextureView textureView, int i3) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i3 != 0) {
            float f4 = width / 2.0f;
            float f5 = height / 2.0f;
            matrix.postRotate(i3, f4, f5);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f4, f5);
        }
        textureView.setTransform(matrix);
    }

    public final boolean b() {
        l0 l0Var = this.f469l;
        if (l0Var != null && l0Var.e() && this.f469l.j()) {
            return true;
        }
        return false;
    }

    public final void c(boolean z3) {
        boolean z5;
        if ((!b() || !this.f477v) && l()) {
            PlayerControlView playerControlView = this.f466i;
            if (playerControlView.d() && playerControlView.getShowTimeoutMs() <= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean e5 = e();
            if (z3 || z5 || e5) {
                f(e5);
            }
        }
    }

    public final boolean d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f4 = intrinsicWidth / intrinsicHeight;
                AspectRatioFrameLayout aspectRatioFrameLayout = this.b;
                ImageView imageView = this.f462e;
                if (aspectRatioFrameLayout != null) {
                    if (imageView instanceof SphericalGLSurfaceView) {
                        f4 = 0.0f;
                    }
                    aspectRatioFrameLayout.setAspectRatio(f4);
                }
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z3;
        l0 l0Var = this.f469l;
        if (l0Var != null && l0Var.e()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19 && keyCode != 270 && keyCode != 22 && keyCode != 271 && keyCode != 20 && keyCode != 269 && keyCode != 21 && keyCode != 268 && keyCode != 23) {
            z3 = false;
        } else {
            z3 = true;
        }
        PlayerControlView playerControlView = this.f466i;
        if (z3 && l() && !playerControlView.d()) {
            c(true);
        } else if ((l() && playerControlView.a(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            c(true);
        } else if (!z3 || !l()) {
            return false;
        } else {
            c(true);
            return false;
        }
        return true;
    }

    public final boolean e() {
        l0 l0Var = this.f469l;
        if (l0Var == null) {
            return true;
        }
        int playbackState = l0Var.getPlaybackState();
        if (this.f476u && (playbackState == 1 || playbackState == 4 || !this.f469l.j())) {
            return true;
        }
        return false;
    }

    public final void f(boolean z3) {
        int i3;
        View view;
        View view2;
        if (!l()) {
            return;
        }
        if (z3) {
            i3 = 0;
        } else {
            i3 = this.f475t;
        }
        PlayerControlView playerControlView = this.f466i;
        playerControlView.setShowTimeoutMs(i3);
        if (!playerControlView.d()) {
            playerControlView.setVisibility(0);
            Iterator it = playerControlView.b.iterator();
            while (it.hasNext()) {
                playerControlView.getVisibility();
                g gVar = (g) ((f) it.next());
                gVar.getClass();
                gVar.f204a.i();
            }
            playerControlView.l();
            playerControlView.k();
            playerControlView.n();
            playerControlView.o();
            playerControlView.p();
            boolean j2 = playerControlView.j();
            if (!j2 && (view2 = playerControlView.f441e) != null) {
                view2.requestFocus();
            } else if (j2 && (view = playerControlView.f442f) != null) {
                view.requestFocus();
            }
        }
        playerControlView.c();
    }

    public final boolean g() {
        if (l() && this.f469l != null) {
            PlayerControlView playerControlView = this.f466i;
            if (!playerControlView.d()) {
                c(true);
            } else if (this.w) {
                playerControlView.b();
            }
            return true;
        }
        return false;
    }

    public View[] getAdOverlayViews() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f468k;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        PlayerControlView playerControlView = this.f466i;
        if (playerControlView != null) {
            arrayList.add(playerControlView);
        }
        return (View[]) arrayList.toArray(new View[0]);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f467j;
        if (frameLayout != null) {
            return frameLayout;
        }
        throw new IllegalStateException("exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f476u;
    }

    public boolean getControllerHideOnTouch() {
        return this.w;
    }

    public int getControllerShowTimeoutMs() {
        return this.f475t;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f473p;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f468k;
    }

    @Nullable
    public l0 getPlayer() {
        return this.f469l;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.b;
        b.i(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f463f;
    }

    public boolean getUseArtwork() {
        return this.f472o;
    }

    public boolean getUseController() {
        return this.f470m;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r5.f469l.j() == false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r5 = this;
            android.view.View r0 = r5.f464g
            if (r0 == 0) goto L29
            j0.l0 r1 = r5.f469l
            r2 = 0
            if (r1 == 0) goto L20
            int r1 = r1.getPlaybackState()
            r3 = 2
            if (r1 != r3) goto L20
            int r1 = r5.q
            r4 = 1
            if (r1 == r3) goto L21
            if (r1 != r4) goto L20
            j0.l0 r1 = r5.f469l
            boolean r1 = r1.j()
            if (r1 == 0) goto L20
            goto L21
        L20:
            r4 = 0
        L21:
            if (r4 == 0) goto L24
            goto L26
        L24:
            r2 = 8
        L26:
            r0.setVisibility(r2)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.h():void");
    }

    public final void i() {
        String str = null;
        PlayerControlView playerControlView = this.f466i;
        if (playerControlView != null && this.f470m) {
            if (playerControlView.getVisibility() == 0) {
                if (this.w) {
                    str = getResources().getString(m.exo_controls_hide);
                }
                setContentDescription(str);
                return;
            }
            setContentDescription(getResources().getString(m.exo_controls_show));
            return;
        }
        setContentDescription(null);
    }

    public final void j() {
        TextView textView = this.f465h;
        if (textView != null) {
            CharSequence charSequence = this.s;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            l0 l0Var = this.f469l;
            if (l0Var != null) {
                l0Var.l();
            }
            textView.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00bb, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(boolean r17) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.k(boolean):void");
    }

    public final boolean l() {
        if (this.f470m) {
            b.i(this.f466i);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!l() || this.f469l == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 || !this.f479y) {
                return false;
            }
            this.f479y = false;
            performClick();
            return true;
        }
        this.f479y = true;
        return true;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (l() && this.f469l != null) {
            c(true);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return g();
    }

    public void setAspectRatioListener(@Nullable a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.b;
        b.i(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControlDispatcher(@Nullable j jVar) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setControlDispatcher(jVar);
    }

    public void setControllerAutoShow(boolean z3) {
        this.f476u = z3;
    }

    public void setControllerHideDuringAds(boolean z3) {
        this.f477v = z3;
    }

    public void setControllerHideOnTouch(boolean z3) {
        b.i(this.f466i);
        this.w = z3;
        i();
    }

    public void setControllerShowTimeoutMs(int i3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        this.f475t = i3;
        if (playerControlView.d()) {
            f(e());
        }
    }

    public void setControllerVisibilityListener(@Nullable f fVar) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        f fVar2 = this.f471n;
        if (fVar2 == fVar) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = playerControlView.b;
        if (fVar2 != null) {
            copyOnWriteArrayList.remove(fVar2);
        }
        this.f471n = fVar;
        if (fVar != null) {
            copyOnWriteArrayList.add(fVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        boolean z3;
        if (this.f465h != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.h(z3);
        this.s = charSequence;
        j();
    }

    @Deprecated
    public void setDefaultArtwork(@Nullable Bitmap bitmap) {
        setDefaultArtwork(bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public void setErrorMessageProvider(@Nullable g2.g gVar) {
        if (gVar != null) {
            j();
        }
    }

    public void setFastForwardIncrementMs(int i3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setFastForwardIncrementMs(i3);
    }

    public void setKeepContentOnPlayerReset(boolean z3) {
        if (this.f474r != z3) {
            this.f474r = z3;
            k(false);
        }
    }

    public void setPlaybackPreparer(@Nullable i0 i0Var) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setPlaybackPreparer(i0Var);
    }

    public void setPlayer(@Nullable l0 l0Var) {
        boolean z3;
        boolean z5;
        SurfaceHolder holder;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.h(z3);
        if (l0Var != null && l0Var.s() != Looper.getMainLooper()) {
            z5 = false;
        } else {
            z5 = true;
        }
        b.e(z5);
        l0 l0Var2 = this.f469l;
        if (l0Var2 == l0Var) {
            return;
        }
        SurfaceHolder surfaceHolder = null;
        View view = this.d;
        g gVar = this.f461a;
        if (l0Var2 != null) {
            l0Var2.u(gVar);
            k0 d = l0Var2.d();
            if (d != null) {
                q0 q0Var = (q0) d;
                q0Var.f2285f.remove(gVar);
                if (view instanceof TextureView) {
                    TextureView textureView = (TextureView) view;
                    q0Var.P();
                    if (textureView != null && textureView == q0Var.f2297t) {
                        q0Var.M(null);
                    }
                } else if (view instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView) view).setVideoComponent(null);
                } else if (view instanceof VideoDecoderGLSurfaceView) {
                    q0Var.P();
                    q0Var.I(null);
                } else if (view instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) view;
                    if (surfaceView == null) {
                        holder = null;
                    } else {
                        holder = surfaceView.getHolder();
                    }
                    q0Var.P();
                    if (holder != null && holder == q0Var.s) {
                        q0Var.K(null);
                    }
                }
            }
            q0 z6 = l0Var2.z();
            if (z6 != null) {
                z6.f2287h.remove(gVar);
            }
        }
        this.f469l = l0Var;
        boolean l5 = l();
        PlayerControlView playerControlView = this.f466i;
        if (l5) {
            playerControlView.setPlayer(l0Var);
        }
        SubtitleView subtitleView = this.f463f;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        h();
        j();
        k(true);
        if (l0Var != null) {
            k0 d5 = l0Var.d();
            if (d5 != null) {
                if (view instanceof TextureView) {
                    ((q0) d5).M((TextureView) view);
                } else if (view instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView) view).setVideoComponent(d5);
                } else if (view instanceof VideoDecoderGLSurfaceView) {
                    i videoDecoderOutputBufferRenderer = ((VideoDecoderGLSurfaceView) view).getVideoDecoderOutputBufferRenderer();
                    q0 q0Var2 = (q0) d5;
                    q0Var2.P();
                    if (videoDecoderOutputBufferRenderer != null) {
                        q0Var2.P();
                        q0Var2.F();
                        q0Var2.L(null, false);
                        q0Var2.D(0, 0);
                    }
                    q0Var2.I(videoDecoderOutputBufferRenderer);
                } else if (view instanceof SurfaceView) {
                    SurfaceView surfaceView2 = (SurfaceView) view;
                    q0 q0Var3 = (q0) d5;
                    if (surfaceView2 != null) {
                        surfaceHolder = surfaceView2.getHolder();
                    }
                    q0Var3.K(surfaceHolder);
                }
                ((q0) d5).f2285f.add(gVar);
            }
            q0 z7 = l0Var.z();
            if (z7 != null) {
                if (!z7.f2302z.isEmpty()) {
                    gVar.onCues(z7.f2302z);
                }
                z7.f2287h.add(gVar);
            }
            l0Var.b(gVar);
            c(false);
        } else if (playerControlView != null) {
            playerControlView.b();
        }
    }

    public void setRepeatToggleModes(int i3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setRepeatToggleModes(i3);
    }

    public void setResizeMode(int i3) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.b;
        b.i(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i3);
    }

    public void setRewindIncrementMs(int i3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setRewindIncrementMs(i3);
    }

    @Deprecated
    public void setShowBuffering(boolean z3) {
        setShowBuffering(z3 ? 1 : 0);
    }

    public void setShowMultiWindowTimeBar(boolean z3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setShowMultiWindowTimeBar(z3);
    }

    public void setShowShuffleButton(boolean z3) {
        PlayerControlView playerControlView = this.f466i;
        b.i(playerControlView);
        playerControlView.setShowShuffleButton(z3);
    }

    public void setShutterBackgroundColor(int i3) {
        View view = this.c;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setUseArtwork(boolean z3) {
        boolean z5;
        if (z3 && this.f462e == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        b.h(z5);
        if (this.f472o != z3) {
            this.f472o = z3;
            k(false);
        }
    }

    public void setUseController(boolean z3) {
        boolean z5;
        PlayerControlView playerControlView = this.f466i;
        if (z3 && playerControlView == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        b.h(z5);
        if (this.f470m == z3) {
            return;
        }
        this.f470m = z3;
        if (l()) {
            playerControlView.setPlayer(this.f469l);
        } else if (playerControlView != null) {
            playerControlView.b();
            playerControlView.setPlayer(null);
        }
        i();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        View view = this.d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i3);
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setShowBuffering(int i3) {
        if (this.q != i3) {
            this.q = i3;
            h();
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i5;
        int i6;
        boolean z3;
        boolean z5;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        boolean z8;
        int i9;
        boolean z9;
        int i10;
        int color;
        g gVar = new g(this);
        this.f461a = gVar;
        if (isInEditMode()) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.f462e = null;
            this.f463f = null;
            this.f464g = null;
            this.f465h = null;
            this.f466i = null;
            this.f467j = null;
            this.f468k = null;
            ImageView imageView = new ImageView(context);
            if (w.f1960a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(c2.i.exo_edit_mode_logo, null));
                color = resources.getColor(h.exo_edit_mode_background_color, null);
                imageView.setBackgroundColor(color);
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(c2.i.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(h.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i11 = l.exo_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n.PlayerView, 0, 0);
            try {
                int i12 = n.PlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i12);
                int color2 = obtainStyledAttributes.getColor(i12, 0);
                int resourceId = obtainStyledAttributes.getResourceId(n.PlayerView_player_layout_id, i11);
                boolean z10 = obtainStyledAttributes.getBoolean(n.PlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(n.PlayerView_default_artwork, 0);
                boolean z11 = obtainStyledAttributes.getBoolean(n.PlayerView_use_controller, true);
                int i13 = obtainStyledAttributes.getInt(n.PlayerView_surface_type, 1);
                int i14 = obtainStyledAttributes.getInt(n.PlayerView_resize_mode, 0);
                int i15 = obtainStyledAttributes.getInt(n.PlayerView_show_timeout, 5000);
                boolean z12 = obtainStyledAttributes.getBoolean(n.PlayerView_hide_on_touch, true);
                boolean z13 = obtainStyledAttributes.getBoolean(n.PlayerView_auto_show, true);
                i6 = obtainStyledAttributes.getInteger(n.PlayerView_show_buffering, 0);
                this.f474r = obtainStyledAttributes.getBoolean(n.PlayerView_keep_content_on_player_reset, this.f474r);
                boolean z14 = obtainStyledAttributes.getBoolean(n.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                i5 = i13;
                i7 = i14;
                i9 = resourceId2;
                z7 = hasValue;
                z5 = z14;
                i11 = resourceId;
                z9 = z11;
                z8 = z10;
                i8 = color2;
                z6 = z12;
                z3 = z13;
                i10 = i15;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i5 = 1;
            i6 = 0;
            z3 = true;
            z5 = true;
            i7 = 0;
            z6 = true;
            i8 = 0;
            z7 = false;
            z8 = true;
            i9 = 0;
            z9 = true;
            i10 = 5000;
        }
        LayoutInflater.from(context).inflate(i11, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(c2.j.exo_content_frame);
        this.b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i7);
        }
        View findViewById = findViewById(c2.j.exo_shutter);
        this.c = findViewById;
        if (findViewById != null && z7) {
            findViewById.setBackgroundColor(i8);
        }
        if (aspectRatioFrameLayout != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                this.d = new TextureView(context);
            } else if (i5 == 3) {
                SphericalGLSurfaceView sphericalGLSurfaceView = new SphericalGLSurfaceView(context);
                sphericalGLSurfaceView.setSingleTapListener(gVar);
                this.d = sphericalGLSurfaceView;
            } else if (i5 != 4) {
                this.d = new SurfaceView(context);
            } else {
                this.d = new VideoDecoderGLSurfaceView(context);
            }
            this.d.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(this.d, 0);
        } else {
            this.d = null;
        }
        this.f467j = (FrameLayout) findViewById(c2.j.exo_ad_overlay);
        this.f468k = (FrameLayout) findViewById(c2.j.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(c2.j.exo_artwork);
        this.f462e = imageView2;
        this.f472o = z8 && imageView2 != null;
        if (i9 != 0) {
            this.f473p = ContextCompat.getDrawable(getContext(), i9);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(c2.j.exo_subtitles);
        this.f463f = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View findViewById2 = findViewById(c2.j.exo_buffering);
        this.f464g = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.q = i6;
        TextView textView = (TextView) findViewById(c2.j.exo_error_message);
        this.f465h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i16 = c2.j.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i16);
        View findViewById3 = findViewById(c2.j.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f466i = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f466i = playerControlView2;
            playerControlView2.setId(i16);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            this.f466i = null;
        }
        PlayerControlView playerControlView3 = this.f466i;
        this.f475t = playerControlView3 != null ? i10 : 0;
        this.w = z6;
        this.f476u = z3;
        this.f477v = z5;
        this.f470m = z9 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.b();
        }
        i();
        PlayerControlView playerControlView4 = this.f466i;
        if (playerControlView4 != null) {
            playerControlView4.b.add(gVar);
        }
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f473p != drawable) {
            this.f473p = drawable;
            k(false);
        }
    }
}
