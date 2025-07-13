package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import s2.d;
import t2.p0;
import w2.a;
import x2.h;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyRockerView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f939a;
    public RectF b;
    public float c;
    public float d;

    /* renamed from: e  reason: collision with root package name */
    public float f940e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f941f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f942g;

    /* renamed from: h  reason: collision with root package name */
    public float f943h;

    /* renamed from: i  reason: collision with root package name */
    public float f944i;

    /* renamed from: j  reason: collision with root package name */
    public float f945j;

    /* renamed from: k  reason: collision with root package name */
    public float f946k;

    /* renamed from: l  reason: collision with root package name */
    public h f947l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f948m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f949n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f950o;

    /* renamed from: p  reason: collision with root package name */
    public int f951p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f952r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public a f953t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f954u;

    public MyRockerView(Context context) {
        super(context);
        this.f939a = true;
        this.f943h = 0.0f;
        this.f944i = 0.0f;
        this.f945j = 0.0f;
        this.f946k = 0.0f;
        this.f949n = false;
        this.f950o = false;
        this.f954u = false;
        a(null, 0);
    }

    public final void a(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.MyRockerView, i3, 0);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(0);
        this.f941f = bitmapDrawable.getBitmap();
        this.d = bitmapDrawable.getIntrinsicWidth() / 2;
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) obtainStyledAttributes.getDrawable(1);
        this.f940e = bitmapDrawable2.getIntrinsicWidth() / 2;
        this.f942g = bitmapDrawable2.getBitmap();
        this.c = this.d - this.f940e;
        this.s = obtainStyledAttributes.getBoolean(2, false);
        this.f949n = obtainStyledAttributes.getBoolean(4, false);
        this.f948m = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        if (this.f948m) {
            float f4 = this.f951p / 2;
            this.f945j = f4;
            this.f943h = f4;
            float f5 = this.q / 2;
            this.f946k = f5;
            this.f944i = f5;
        } else if (this.f952r) {
            float f6 = this.f951p / 2;
            this.f945j = f6;
            this.f943h = f6;
            float f7 = this.q / 2;
            this.f946k = f7;
            this.f944i = f7;
        } else {
            float f8 = this.f951p / 2;
            this.f945j = f8;
            this.f943h = f8;
            float f9 = this.q / 2;
            this.f944i = f9;
            this.f946k = (this.d - this.f940e) + f9;
        }
        float f10 = this.f943h;
        float f11 = this.c;
        float f12 = this.f944i;
        this.b = new RectF(f10 - f11, f12 - f11, f10 + f11, f12 + f11);
    }

    public final void c() {
        a aVar = this.f953t;
        if (aVar != null) {
            SensorManager sensorManager = aVar.f3944a;
            sensorManager.registerListener(aVar, aVar.b, 1);
            sensorManager.registerListener(aVar, aVar.c, 1);
        }
    }

    public final void d() {
        float f4 = this.c;
        int i3 = (int) ((((this.f945j - this.f943h) * 128.0f) / f4) + 0.5d);
        int i5 = (int) ((((this.f944i - this.f946k) * 128.0f) / f4) + 0.5d);
        h hVar = this.f947l;
        if (hVar != null) {
            hVar.b(i3, i5);
        }
    }

    public final void e() {
        a aVar = this.f953t;
        if (aVar != null) {
            aVar.f3944a.unregisterListener(aVar);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f949n) {
            Log.d("MyRockerView", "onDraw");
            Bitmap bitmap = this.f941f;
            float f4 = this.f943h;
            float f5 = this.d;
            float f6 = this.f944i;
            canvas.drawBitmap(bitmap, (Rect) null, new RectF(f4 - f5, f6 - f5, f4 + f5, f5 + f6), (Paint) null);
            Bitmap bitmap2 = this.f942g;
            float f7 = this.f945j;
            float f8 = this.f940e;
            float f9 = this.f946k;
            canvas.drawBitmap(bitmap2, (Rect) null, new RectF(f7 - f8, f9 - f8, f7 + f8, f9 + f8), (Paint) null);
        } else if (this.f950o) {
            Bitmap bitmap3 = this.f941f;
            float f10 = this.f943h;
            float f11 = this.d;
            float f12 = this.f944i;
            canvas.drawBitmap(bitmap3, (Rect) null, new RectF(f10 - f11, f12 - f11, f10 + f11, f11 + f12), (Paint) null);
            Bitmap bitmap4 = this.f942g;
            float f13 = this.f945j;
            float f14 = this.f940e;
            float f15 = this.f946k;
            canvas.drawBitmap(bitmap4, (Rect) null, new RectF(f13 - f14, f15 - f14, f13 + f14, f15 + f14), (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        this.f951p = View.MeasureSpec.getSize(i3);
        this.q = View.MeasureSpec.getSize(i5);
        if (this.f949n) {
            b();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.s) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f954u) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        boolean z3 = this.f939a;
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && z3) {
                    Log.d("MyRockerView", "ACTION_MOVE");
                    this.f945j = motionEvent.getX();
                    float y3 = motionEvent.getY();
                    this.f946k = y3;
                    if (!this.b.contains(this.f945j, y3)) {
                        float f4 = this.f945j - this.f943h;
                        float f5 = this.f946k - this.f944i;
                        double d = f4;
                        double sqrt = Math.sqrt(Math.pow(f5, 2.0d) + Math.pow(d, 2.0d));
                        if (f5 < 0.0f) {
                            if (f4 < 0.0f) {
                                double acos = Math.acos((-f4) / sqrt);
                                this.f945j = (float) (this.f943h - (Math.cos(acos) * this.c));
                                this.f946k = (float) (this.f944i - (Math.sin(acos) * this.c));
                            } else {
                                double acos2 = Math.acos(d / sqrt);
                                this.f945j = (float) ((Math.cos(acos2) * this.c) + this.f943h);
                                this.f946k = (float) (this.f944i - (Math.sin(acos2) * this.c));
                            }
                        } else if (f4 < 0.0f) {
                            double acos3 = Math.acos((-f4) / sqrt);
                            this.f945j = (float) (this.f943h - (Math.cos(acos3) * this.c));
                            this.f946k = (float) ((Math.sin(acos3) * this.c) + this.f944i);
                        } else {
                            double acos4 = Math.acos(d / sqrt);
                            this.f945j = (float) ((Math.cos(acos4) * this.c) + this.f943h);
                            this.f946k = (float) ((Math.sin(acos4) * this.c) + this.f944i);
                        }
                    }
                    d();
                }
            } else if (z3) {
                Log.d("MyRockerView", "ACTION_UP");
                if (!this.f949n) {
                    this.f950o = false;
                }
                this.f945j = this.f943h;
                if (this.f948m) {
                    this.f946k = this.f944i;
                } else if (this.f952r) {
                    this.f946k = this.f944i;
                } else {
                    float f6 = this.f946k;
                    float f7 = this.f944i;
                    float f8 = this.d - this.f940e;
                    float f9 = f8 + f7;
                    if (f6 > f9) {
                        this.f946k = f9;
                    } else {
                        float f10 = f7 - f8;
                        if (f6 < f10) {
                            this.f946k = f10;
                        }
                    }
                }
                d();
            }
        } else {
            Log.d("MyRockerView", "ACTION_DOWN");
            if (this.f949n) {
                this.f945j = motionEvent.getX();
                this.f946k = motionEvent.getY();
                d();
            } else {
                this.f950o = true;
                if (this.f948m) {
                    float x3 = motionEvent.getX();
                    this.f945j = x3;
                    this.f943h = x3;
                    float y4 = motionEvent.getY();
                    this.f946k = y4;
                    this.f944i = y4;
                } else if (this.f952r) {
                    float x5 = motionEvent.getX();
                    this.f945j = x5;
                    this.f943h = x5;
                    float y5 = motionEvent.getY();
                    this.f946k = y5;
                    this.f944i = y5;
                } else {
                    float x6 = motionEvent.getX();
                    this.f945j = x6;
                    this.f943h = x6;
                    float y6 = motionEvent.getY();
                    this.f946k = y6;
                    this.f944i = y6 - (this.d - this.f940e);
                }
                float f11 = this.f943h;
                float f12 = this.c;
                float f13 = this.f944i;
                this.b = new RectF(f11 - f12, f13 - f12, f11 + f12, f13 + f12);
            }
        }
        if (z3) {
            postInvalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDG(boolean z3) {
        if (this.f952r) {
            if (!z3) {
                this.f952r = z3;
            }
        } else if (z3) {
            this.f952r = z3;
            this.f946k = this.f944i;
            postInvalidate();
            d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [w2.a, java.lang.Object, android.hardware.SensorEventListener] */
    public void setGravity(boolean z3) {
        if (this.s) {
            if (!z3) {
                this.s = z3;
                a aVar = this.f953t;
                if (aVar != null) {
                    aVar.f3944a.unregisterListener(aVar);
                    this.f953t = null;
                }
                float f4 = this.f951p / 2;
                this.f945j = f4;
                this.f943h = f4;
                float f5 = this.q / 2;
                this.f946k = f5;
                this.f944i = f5;
                d();
                postInvalidate();
            }
        } else if (z3) {
            this.s = z3;
            setShow(true);
            Context context = getContext();
            p0 p0Var = new p0(4, this);
            ?? obj = new Object();
            obj.f3946f = new float[3];
            obj.f3947g = new float[3];
            obj.f3948h = p0Var;
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            obj.f3944a = sensorManager;
            obj.b = sensorManager.getDefaultSensor(1);
            obj.c = sensorManager.getDefaultSensor(2);
            this.f953t = obj;
            SensorManager sensorManager2 = obj.f3944a;
            sensorManager2.registerListener((SensorEventListener) obj, obj.b, 1);
            sensorManager2.registerListener((SensorEventListener) obj, obj.c, 1);
        }
    }

    public void setOnLocaListener(h hVar) {
        this.f947l = hVar;
    }

    public void setShow(boolean z3) {
        if (this.f949n) {
            if (!z3) {
                this.f949n = z3;
                this.f950o = false;
                postInvalidate();
            }
        } else if (z3) {
            this.f949n = z3;
            b();
            postInvalidate();
        }
    }

    public void setStopUI(boolean z3) {
        this.f954u = z3;
    }

    public MyRockerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f939a = true;
        this.f943h = 0.0f;
        this.f944i = 0.0f;
        this.f945j = 0.0f;
        this.f946k = 0.0f;
        this.f949n = false;
        this.f950o = false;
        this.f954u = false;
        a(attributeSet, 0);
    }

    public MyRockerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f939a = true;
        this.f943h = 0.0f;
        this.f944i = 0.0f;
        this.f945j = 0.0f;
        this.f946k = 0.0f;
        this.f949n = false;
        this.f950o = false;
        this.f954u = false;
        a(attributeSet, i3);
    }
}
