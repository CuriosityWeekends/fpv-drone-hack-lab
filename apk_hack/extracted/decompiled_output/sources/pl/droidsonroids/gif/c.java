package pl.droidsonroids.gif;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f3282a;
    public volatile boolean b;
    public long c;
    public final Rect d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f3283e;

    /* renamed from: f  reason: collision with root package name */
    public final Bitmap f3284f;

    /* renamed from: g  reason: collision with root package name */
    public final GifInfoHandle f3285g;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentLinkedQueue f3286h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f3287i;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuffColorFilter f3288j;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f3289k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3290l;

    /* renamed from: m  reason: collision with root package name */
    public final j0.s f3291m;

    /* renamed from: n  reason: collision with root package name */
    public final r f3292n;

    /* renamed from: o  reason: collision with root package name */
    public final Rect f3293o;

    /* renamed from: p  reason: collision with root package name */
    public ScheduledFuture f3294p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final int f3295r;

    public c(Resources resources, int i3) {
        this(new GifInfoHandle(resources.openRawResourceFd(i3)));
        List list = m.f3307a;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i3, typedValue, true);
        int i5 = typedValue.density;
        if (i5 == 0) {
            i5 = 160;
        } else if (i5 == 65535) {
            i5 = 0;
        }
        int i6 = resources.getDisplayMetrics().densityDpi;
        float f4 = (i5 <= 0 || i6 <= 0) ? 1.0f : i6 / i5;
        this.f3295r = (int) (this.f3285g.f() * f4);
        this.q = (int) (this.f3285g.k() * f4);
    }

    public final void a(long j2) {
        j0.s sVar = this.f3291m;
        if (this.f3290l) {
            this.c = 0L;
            sVar.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        ScheduledFuture scheduledFuture = this.f3294p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        sVar.removeMessages(-1);
        this.f3294p = this.f3282a.schedule(this.f3292n, Math.max(j2, 0L), TimeUnit.MILLISECONDS);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        if (this.f3285g.i() > 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        if (this.f3285g.i() > 1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z3;
        PorterDuffColorFilter porterDuffColorFilter = this.f3288j;
        Paint paint = this.f3283e;
        if (porterDuffColorFilter != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f3288j);
            z3 = true;
        } else {
            z3 = false;
        }
        canvas.drawBitmap(this.f3284f, this.f3293o, this.d, paint);
        if (z3) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f3283e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f3283e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.f3285g.d();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.f3285g.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f3295r;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f3285g.l() && this.f3283e.getAlpha() >= 255) {
            return -1;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.f3290l && this.b) {
            long j2 = this.c;
            if (j2 != Long.MIN_VALUE) {
                long max = Math.max(0L, j2 - SystemClock.uptimeMillis());
                this.c = Long.MIN_VALUE;
                this.f3282a.remove(this.f3292n);
                this.f3294p = this.f3282a.schedule(this.f3292n, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (!super.isStateful() && ((colorStateList = this.f3287i) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3287i;
        if (colorStateList != null && (mode = this.f3289k) != null) {
            this.f3288j = b(colorStateList, mode);
            return true;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i3) {
        if (i3 >= 0) {
            this.f3282a.execute(new b(this, this, i3));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f3283e.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3283e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z3) {
        this.f3283e.setDither(z3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z3) {
        this.f3283e.setFilterBitmap(z3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f3287i = colorStateList;
        this.f3288j = b(colorStateList, this.f3289k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f3289k = mode;
        this.f3288j = b(this.f3287i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z3, boolean z5) {
        boolean visible = super.setVisible(z3, z5);
        if (!this.f3290l) {
            if (z3) {
                if (z5) {
                    this.f3282a.execute(new a(this, this));
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                a(this.f3285g.r());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        synchronized (this) {
            try {
                if (!this.b) {
                    return;
                }
                this.b = false;
                ScheduledFuture scheduledFuture = this.f3294p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f3291m.removeMessages(-1);
                this.f3285g.t();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        GifInfoHandle gifInfoHandle = this.f3285g;
        int k5 = gifInfoHandle.k();
        int f4 = gifInfoHandle.f();
        int i3 = gifInfoHandle.i();
        int h5 = gifInfoHandle.h();
        StringBuilder n5 = a1.i.n("GIF: size: ", k5, "x", f4, ", frames: ");
        n5.append(i3);
        n5.append(", error: ");
        n5.append(h5);
        return n5.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r3v5, types: [pl.droidsonroids.gif.GifInfoHandle, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r2 = this;
            int r0 = pl.droidsonroids.gif.GifInfoHandle.b
            java.lang.String r0 = r4.getScheme()
            java.lang.String r1 = "file"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1e
            pl.droidsonroids.gif.GifInfoHandle r3 = new pl.droidsonroids.gif.GifInfoHandle
            java.lang.String r4 = r4.getPath()
            r3.<init>()
            long r0 = pl.droidsonroids.gif.GifInfoHandle.openFile(r4)
            r3.f3275a = r0
            goto L2c
        L1e:
            java.lang.String r0 = "r"
            android.content.res.AssetFileDescriptor r3 = r3.openAssetFileDescriptor(r4, r0)
            if (r3 == 0) goto L30
            pl.droidsonroids.gif.GifInfoHandle r4 = new pl.droidsonroids.gif.GifInfoHandle
            r4.<init>(r3)
            r3 = r4
        L2c:
            r2.<init>(r3)
            return
        L30:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not open AssetFileDescriptor for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.c.<init>(android.content.ContentResolver, android.net.Uri):void");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [pl.droidsonroids.gif.r, pl.droidsonroids.gif.s] */
    public c(GifInfoHandle gifInfoHandle) {
        this.b = true;
        this.c = Long.MIN_VALUE;
        this.d = new Rect();
        this.f3283e = new Paint(6);
        this.f3286h = new ConcurrentLinkedQueue();
        ?? sVar = new s(this);
        this.f3292n = sVar;
        this.f3290l = true;
        int i3 = f.f3300a;
        this.f3282a = e.f3299a;
        this.f3285g = gifInfoHandle;
        Bitmap createBitmap = Bitmap.createBitmap(gifInfoHandle.k(), gifInfoHandle.f(), Bitmap.Config.ARGB_8888);
        this.f3284f = createBitmap;
        createBitmap.setHasAlpha(true ^ gifInfoHandle.l());
        this.f3293o = new Rect(0, 0, gifInfoHandle.k(), gifInfoHandle.f());
        this.f3291m = new j0.s(this);
        sVar.a();
        this.q = gifInfoHandle.k();
        this.f3295r = gifInfoHandle.f();
    }
}
