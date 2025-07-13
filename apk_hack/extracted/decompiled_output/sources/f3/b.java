package f3;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1857a = 0;
    public int b = -1;
    public int c = 0;
    public final ScaleGestureDetector d;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f1858e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1859f;

    /* renamed from: g  reason: collision with root package name */
    public float f1860g;

    /* renamed from: h  reason: collision with root package name */
    public float f1861h;

    /* renamed from: i  reason: collision with root package name */
    public final float f1862i;

    /* renamed from: j  reason: collision with root package name */
    public final float f1863j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f1864k;

    public b(Context context, b3.e eVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1863j = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1862i = viewConfiguration.getScaledTouchSlop();
        this.f1864k = eVar;
        this.d = new ScaleGestureDetector(context, new a(0, this));
    }

    public final void a(MotionEvent motionEvent) {
        float x3;
        float y3;
        float x5;
        float y4;
        Drawable drawable;
        RectF rectF;
        int i3;
        int i5;
        int i6;
        int i7;
        float x6;
        float y5;
        boolean z3;
        boolean z5;
        boolean z6;
        float x7;
        float y6;
        float x8;
        float y7;
        Drawable drawable2;
        RectF rectF2;
        int i8;
        int i9;
        int i10;
        int i11;
        float x9;
        float y8;
        int i12;
        boolean z7;
        switch (this.f1857a) {
            case 0:
                int action = motionEvent.getAction() & 255;
                int i13 = 0;
                if (action != 0) {
                    b3.e eVar = (b3.e) this.f1864k;
                    int i14 = 1;
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                if (action == 6) {
                                    int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                                    if (motionEvent.getPointerId(action2) == this.b) {
                                        if (action2 != 0) {
                                            i14 = 0;
                                        }
                                        this.b = motionEvent.getPointerId(i14);
                                        this.f1860g = motionEvent.getX(i14);
                                        this.f1861h = motionEvent.getY(i14);
                                    }
                                }
                            } else {
                                this.b = -1;
                                VelocityTracker velocityTracker = this.f1858e;
                                if (velocityTracker != null) {
                                    velocityTracker.recycle();
                                    this.f1858e = null;
                                }
                            }
                        } else {
                            try {
                                x6 = motionEvent.getX(this.c);
                            } catch (Exception unused) {
                                x6 = motionEvent.getX();
                            }
                            try {
                                y5 = motionEvent.getY(this.c);
                            } catch (Exception unused2) {
                                y5 = motionEvent.getY();
                            }
                            float f4 = x6 - this.f1860g;
                            float f5 = y5 - this.f1861h;
                            if (!this.f1859f) {
                                if (Math.sqrt((f5 * f5) + (f4 * f4)) >= this.f1862i) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                this.f1859f = z6;
                            }
                            if (this.f1859f) {
                                o oVar = (o) eVar.b;
                                if (!oVar.f1880j.d.isInProgress()) {
                                    oVar.f1883m.postTranslate(f4, f5);
                                    oVar.a();
                                    if (oVar.f1888t == 0 && oVar.d() != 1.0f) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    oVar.f1889u = z3;
                                    if (oVar.f1888t == 1 && oVar.d() != 1.0f) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    oVar.f1890v = z5;
                                    if (oVar.s == 0) {
                                        int i15 = (oVar.d() > 1.0f ? 1 : (oVar.d() == 1.0f ? 0 : -1));
                                    }
                                    if (oVar.s == 1) {
                                        int i16 = (oVar.d() > 1.0f ? 1 : (oVar.d() == 1.0f ? 0 : -1));
                                    }
                                    ViewParent parent = oVar.f1878h.getParent();
                                    if (parent != null) {
                                        if (oVar.f1876f && !oVar.f1880j.d.isInProgress() && !oVar.f1877g) {
                                            int i17 = oVar.s;
                                            if ((i17 == 2 && !oVar.f1893z) || ((i17 == 0 && f4 >= 0.0f && oVar.f1891x) || (i17 == 1 && f4 <= -0.0f && oVar.f1891x))) {
                                                parent.requestDisallowInterceptTouchEvent(false);
                                            } else {
                                                int i18 = oVar.f1888t;
                                                if ((i18 == 2 && oVar.w) || ((oVar.f1889u && f5 > 0.0f && oVar.w) || (oVar.f1890v && f5 < 0.0f && oVar.w))) {
                                                    parent.requestDisallowInterceptTouchEvent(false);
                                                } else if (oVar.f1893z && ((i18 == 0 && f5 > 0.0f && oVar.w) || (i18 == 1 && f5 < 0.0f && oVar.w))) {
                                                    parent.requestDisallowInterceptTouchEvent(false);
                                                }
                                            }
                                        } else {
                                            int i19 = oVar.s;
                                            if (i19 == 2 && oVar.f1893z && oVar.f1891x) {
                                                parent.requestDisallowInterceptTouchEvent(false);
                                            } else if ((i19 == 1 || i19 == 0) && !oVar.f1893z && !oVar.f1891x) {
                                                parent.requestDisallowInterceptTouchEvent(false);
                                            } else {
                                                parent.requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    }
                                }
                                this.f1860g = x6;
                                this.f1861h = y5;
                                VelocityTracker velocityTracker2 = this.f1858e;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.addMovement(motionEvent);
                                }
                            }
                        }
                    } else {
                        this.b = -1;
                        if (this.f1859f && this.f1858e != null) {
                            try {
                                x5 = motionEvent.getX(this.c);
                            } catch (Exception unused3) {
                                x5 = motionEvent.getX();
                            }
                            this.f1860g = x5;
                            try {
                                y4 = motionEvent.getY(this.c);
                            } catch (Exception unused4) {
                                y4 = motionEvent.getY();
                            }
                            this.f1861h = y4;
                            this.f1858e.addMovement(motionEvent);
                            this.f1858e.computeCurrentVelocity(1000);
                            float xVelocity = this.f1858e.getXVelocity();
                            float yVelocity = this.f1858e.getYVelocity();
                            if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f1863j) {
                                o oVar2 = (o) eVar.b;
                                n nVar = new n(oVar2, oVar2.f1878h.getContext());
                                oVar2.f1887r = nVar;
                                ImageView imageView = oVar2.f1878h;
                                int width = (imageView.getWidth() - imageView.getPaddingStart()) - imageView.getPaddingEnd();
                                int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
                                int i20 = (int) (-xVelocity);
                                int i21 = (int) (-yVelocity);
                                oVar2.b();
                                Matrix c = oVar2.c();
                                if (oVar2.f1878h.getDrawable() != null) {
                                    rectF = oVar2.f1884n;
                                    rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                    c.mapRect(rectF);
                                } else {
                                    rectF = null;
                                }
                                if (rectF != null) {
                                    int round = Math.round(-rectF.left);
                                    float f6 = width;
                                    if (f6 < rectF.width()) {
                                        i3 = Math.round(rectF.width() - f6);
                                        i5 = 0;
                                    } else {
                                        i3 = round;
                                        i5 = i3;
                                    }
                                    int round2 = Math.round(-rectF.top);
                                    float f7 = height;
                                    if (f7 < rectF.height()) {
                                        i6 = Math.round(rectF.height() - f7);
                                        i7 = 0;
                                    } else {
                                        i6 = round2;
                                        i7 = i6;
                                    }
                                    nVar.c = round;
                                    nVar.d = round2;
                                    if (round != i3 || round2 != i6) {
                                        nVar.b.fling(round, round2, i20, i21, i5, i3, i7, i6, 0, 0);
                                    }
                                }
                                imageView.post(oVar2.f1887r);
                            }
                        }
                        VelocityTracker velocityTracker3 = this.f1858e;
                        if (velocityTracker3 != null) {
                            velocityTracker3.recycle();
                            this.f1858e = null;
                        }
                    }
                } else {
                    this.b = motionEvent.getPointerId(0);
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.f1858e = obtain;
                    if (obtain != null) {
                        obtain.addMovement(motionEvent);
                    }
                    try {
                        x3 = motionEvent.getX(this.c);
                    } catch (Exception unused5) {
                        x3 = motionEvent.getX();
                    }
                    this.f1860g = x3;
                    try {
                        y3 = motionEvent.getY(this.c);
                    } catch (Exception unused6) {
                        y3 = motionEvent.getY();
                    }
                    this.f1861h = y3;
                    this.f1859f = false;
                }
                int i22 = this.b;
                if (i22 != -1) {
                    i13 = i22;
                }
                this.c = motionEvent.findPointerIndex(i13);
                return;
            default:
                int action3 = motionEvent.getAction() & 255;
                int i23 = 0;
                if (action3 != 0) {
                    b3.e eVar2 = (b3.e) this.f1864k;
                    int i24 = 1;
                    if (action3 != 1) {
                        if (action3 != 2) {
                            if (action3 != 3) {
                                if (action3 == 6) {
                                    int action4 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                                    if (motionEvent.getPointerId(action4) == this.b) {
                                        if (action4 != 0) {
                                            i24 = 0;
                                        }
                                        this.b = motionEvent.getPointerId(i24);
                                        this.f1860g = motionEvent.getX(i24);
                                        this.f1861h = motionEvent.getY(i24);
                                    }
                                }
                            } else {
                                this.b = -1;
                                VelocityTracker velocityTracker4 = this.f1858e;
                                if (velocityTracker4 != null) {
                                    velocityTracker4.recycle();
                                    this.f1858e = null;
                                }
                            }
                        } else {
                            try {
                                x9 = motionEvent.getX(this.c);
                            } catch (Exception unused7) {
                                x9 = motionEvent.getX();
                            }
                            try {
                                y8 = motionEvent.getY(this.c);
                            } catch (Exception unused8) {
                                y8 = motionEvent.getY();
                            }
                            float f8 = x9 - this.f1860g;
                            float f9 = y8 - this.f1861h;
                            if (!this.f1859f) {
                                if (Math.sqrt((f9 * f9) + (f8 * f8)) >= this.f1862i) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                this.f1859f = z7;
                            }
                            if (this.f1859f) {
                                i0.i iVar = (i0.i) eVar2.b;
                                if (!iVar.f2164j.d.isInProgress()) {
                                    iVar.f2167m.postTranslate(f8, f9);
                                    iVar.a();
                                    ViewParent parent2 = iVar.f2162h.getParent();
                                    if (iVar.f2160f && !iVar.f2164j.d.isInProgress() && !iVar.f2161g) {
                                        int i25 = iVar.s;
                                        if ((i25 == 2 || ((i25 == 0 && f8 >= 1.0f) || ((i25 == 1 && f8 <= -1.0f) || (((i12 = iVar.f2172t) == 0 && f9 >= 1.0f) || (i12 == 1 && f9 <= -1.0f))))) && parent2 != null) {
                                            parent2.requestDisallowInterceptTouchEvent(false);
                                        }
                                    } else if (parent2 != null) {
                                        parent2.requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                                this.f1860g = x9;
                                this.f1861h = y8;
                                VelocityTracker velocityTracker5 = this.f1858e;
                                if (velocityTracker5 != null) {
                                    velocityTracker5.addMovement(motionEvent);
                                }
                            }
                        }
                    } else {
                        this.b = -1;
                        if (this.f1859f && this.f1858e != null) {
                            try {
                                x8 = motionEvent.getX(this.c);
                            } catch (Exception unused9) {
                                x8 = motionEvent.getX();
                            }
                            this.f1860g = x8;
                            try {
                                y7 = motionEvent.getY(this.c);
                            } catch (Exception unused10) {
                                y7 = motionEvent.getY();
                            }
                            this.f1861h = y7;
                            this.f1858e.addMovement(motionEvent);
                            this.f1858e.computeCurrentVelocity(1000);
                            float xVelocity2 = this.f1858e.getXVelocity();
                            float yVelocity2 = this.f1858e.getYVelocity();
                            if (Math.max(Math.abs(xVelocity2), Math.abs(yVelocity2)) >= this.f1863j) {
                                i0.i iVar2 = (i0.i) eVar2.b;
                                n nVar2 = new n(iVar2, iVar2.f2162h.getContext());
                                iVar2.f2171r = nVar2;
                                ImageView imageView2 = iVar2.f2162h;
                                int width2 = (imageView2.getWidth() - imageView2.getPaddingLeft()) - imageView2.getPaddingRight();
                                int height2 = (imageView2.getHeight() - imageView2.getPaddingTop()) - imageView2.getPaddingBottom();
                                int i26 = (int) (-xVelocity2);
                                int i27 = (int) (-yVelocity2);
                                iVar2.b();
                                Matrix c5 = iVar2.c();
                                if (iVar2.f2162h.getDrawable() != null) {
                                    rectF2 = iVar2.f2168n;
                                    rectF2.set(0.0f, 0.0f, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                    c5.mapRect(rectF2);
                                } else {
                                    rectF2 = null;
                                }
                                if (rectF2 != null) {
                                    int round3 = Math.round(-rectF2.left);
                                    float f10 = width2;
                                    if (f10 < rectF2.width()) {
                                        i8 = Math.round(rectF2.width() - f10);
                                        i9 = 0;
                                    } else {
                                        i8 = round3;
                                        i9 = i8;
                                    }
                                    int round4 = Math.round(-rectF2.top);
                                    float f11 = height2;
                                    if (f11 < rectF2.height()) {
                                        i10 = Math.round(rectF2.height() - f11);
                                        i11 = 0;
                                    } else {
                                        i10 = round4;
                                        i11 = i10;
                                    }
                                    nVar2.c = round3;
                                    nVar2.d = round4;
                                    if (round3 != i8 || round4 != i10) {
                                        nVar2.b.fling(round3, round4, i26, i27, i9, i8, i11, i10, 0, 0);
                                    }
                                }
                                imageView2.post(iVar2.f2171r);
                            }
                        }
                        VelocityTracker velocityTracker6 = this.f1858e;
                        if (velocityTracker6 != null) {
                            velocityTracker6.recycle();
                            this.f1858e = null;
                        }
                    }
                } else {
                    this.b = motionEvent.getPointerId(0);
                    VelocityTracker obtain2 = VelocityTracker.obtain();
                    this.f1858e = obtain2;
                    if (obtain2 != null) {
                        obtain2.addMovement(motionEvent);
                    }
                    try {
                        x7 = motionEvent.getX(this.c);
                    } catch (Exception unused11) {
                        x7 = motionEvent.getX();
                    }
                    this.f1860g = x7;
                    try {
                        y6 = motionEvent.getY(this.c);
                    } catch (Exception unused12) {
                        y6 = motionEvent.getY();
                    }
                    this.f1861h = y6;
                    this.f1859f = false;
                }
                int i28 = this.b;
                if (i28 != -1) {
                    i23 = i28;
                }
                this.c = motionEvent.findPointerIndex(i23);
                return;
        }
    }

    public b(Context context, b3.e eVar, byte b) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1863j = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1862i = viewConfiguration.getScaledTouchSlop();
        this.f1864k = eVar;
        this.d = new ScaleGestureDetector(context, new a(1, this));
    }
}
