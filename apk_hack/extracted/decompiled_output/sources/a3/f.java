package a3;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import com.jaygoo.widget.RangeSeekBar;
import com.lg.picturesubmitt.widget.TrackControlPaintView;
import com.lg.picturesubmitt.widget.TrackControlPaintViewJY;
import com.zhouyou.view.seekbar.SignSeekBar;
import x2.k;
import x2.m;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f87a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(int i3, Object obj) {
        this.f87a = i3;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f4;
        float f5;
        switch (this.f87a) {
            case 0:
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e eVar = (e) this.b;
                eVar.b.c.setAlpha(animatedFraction);
                g gVar = eVar.b;
                View view = gVar.c;
                int intValue = gVar.f88f.evaluate(animatedFraction, Integer.valueOf(gVar.f89g), (Integer) 0).intValue();
                g gVar2 = eVar.b;
                view.scrollTo(intValue, gVar2.f88f.evaluate(animatedFraction, Integer.valueOf(gVar2.f90h), (Integer) 0).intValue());
                g.d(eVar.b, animatedFraction);
                return;
            case 1:
                float animatedFraction2 = valueAnimator.getAnimatedFraction();
                g gVar3 = (g) this.b;
                float f6 = 1.0f - animatedFraction2;
                gVar3.c.setAlpha(f6);
                gVar3.c.scrollTo(gVar3.f88f.evaluate(animatedFraction2, (Integer) 0, Integer.valueOf(gVar3.f89g)).intValue(), gVar3.f88f.evaluate(animatedFraction2, (Integer) 0, Integer.valueOf(gVar3.f90h)).intValue());
                g.d(gVar3, f6);
                return;
            case 2:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SignSeekBar signSeekBar = (SignSeekBar) this.b;
                signSeekBar.I = floatValue;
                signSeekBar.c = (((floatValue - signSeekBar.P) * signSeekBar.G) / signSeekBar.J) + signSeekBar.f1554a;
                signSeekBar.invalidate();
                if (signSeekBar.O != null) {
                    signSeekBar.getProgress();
                    signSeekBar.getProgressFloat();
                    return;
                }
                return;
            case 3:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                r2.e eVar2 = (r2.e) this.b;
                eVar2.f3435y = floatValue2;
                RangeSeekBar rangeSeekBar = eVar2.I;
                if (rangeSeekBar != null) {
                    rangeSeekBar.invalidate();
                    return;
                }
                return;
            case 4:
                float[] fArr = new float[2];
                TrackControlPaintView trackControlPaintView = (TrackControlPaintView) this.b;
                trackControlPaintView.f960i.getPosTan(trackControlPaintView.s * trackControlPaintView.q, new float[2], fArr);
                int i3 = (fArr[0] > 0.0f ? 1 : (fArr[0] == 0.0f ? 0 : -1));
                if (i3 == 0 && fArr[1] == 0.0f) {
                    trackControlPaintView.f969t = 0.0f;
                    trackControlPaintView.f970u = 0.0f;
                } else if (i3 == 0 && fArr[1] != 0.0f) {
                    trackControlPaintView.f969t = 0.0f;
                    trackControlPaintView.f970u = 76.200005f;
                } else if (i3 != 0 && fArr[1] == 0.0f) {
                    trackControlPaintView.f969t = 76.200005f;
                    trackControlPaintView.f970u = 0.0f;
                } else {
                    float sqrt = (float) Math.sqrt(Math.pow(76.200005f, 2.0d) / ((Math.pow(fArr[1], 2.0d) / Math.pow(fArr[0], 2.0d)) + 1.0d));
                    trackControlPaintView.f969t = sqrt;
                    trackControlPaintView.f970u = Math.abs((sqrt * fArr[1]) / fArr[0]);
                }
                float f7 = trackControlPaintView.f969t;
                float f8 = 1.0f;
                if (fArr[0] < 0.0f) {
                    f4 = -1.0f;
                } else {
                    f4 = 1.0f;
                }
                float f9 = f7 * f4;
                trackControlPaintView.f969t = f9;
                float f10 = trackControlPaintView.f970u;
                if (fArr[1] < 0.0f) {
                    f8 = -1.0f;
                }
                float f11 = f10 * f8;
                trackControlPaintView.f970u = f11;
                float f12 = (float) (f9 * 1.5d);
                float f13 = (float) ((-f11) * 1.5d);
                k kVar = trackControlPaintView.f966o;
                if (kVar != null) {
                    kVar.a(f12, f13);
                }
                Log.e("", "轨迹坐标 " + trackControlPaintView.f969t + "   " + trackControlPaintView.f970u);
                return;
            default:
                float[] fArr2 = new float[2];
                TrackControlPaintViewJY trackControlPaintViewJY = (TrackControlPaintViewJY) this.b;
                trackControlPaintViewJY.f977i.getPosTan(trackControlPaintViewJY.s * trackControlPaintViewJY.q, new float[2], fArr2);
                int i5 = (fArr2[0] > 0.0f ? 1 : (fArr2[0] == 0.0f ? 0 : -1));
                if (i5 == 0 && fArr2[1] == 0.0f) {
                    trackControlPaintViewJY.f986t = 0.0f;
                    trackControlPaintViewJY.f987u = 0.0f;
                } else if (i5 == 0 && fArr2[1] != 0.0f) {
                    trackControlPaintViewJY.f986t = 0.0f;
                    trackControlPaintViewJY.f987u = 76.200005f;
                } else if (i5 != 0 && fArr2[1] == 0.0f) {
                    trackControlPaintViewJY.f986t = 76.200005f;
                    trackControlPaintViewJY.f987u = 0.0f;
                } else {
                    float sqrt2 = (float) Math.sqrt(Math.pow(76.200005f, 2.0d) / ((Math.pow(fArr2[1], 2.0d) / Math.pow(fArr2[0], 2.0d)) + 1.0d));
                    trackControlPaintViewJY.f986t = sqrt2;
                    trackControlPaintViewJY.f987u = Math.abs((sqrt2 * fArr2[1]) / fArr2[0]);
                }
                float f14 = trackControlPaintViewJY.f986t;
                float f15 = 1.0f;
                if (fArr2[0] < 0.0f) {
                    f5 = -1.0f;
                } else {
                    f5 = 1.0f;
                }
                float f16 = f14 * f5;
                trackControlPaintViewJY.f986t = f16;
                float f17 = trackControlPaintViewJY.f987u;
                if (fArr2[1] < 0.0f) {
                    f15 = -1.0f;
                }
                float f18 = f17 * f15;
                trackControlPaintViewJY.f987u = f18;
                float f19 = -f18;
                m mVar = trackControlPaintViewJY.f983o;
                if (mVar != null) {
                    mVar.a(f16, f19);
                }
                Log.e("", "轨迹坐标 " + trackControlPaintViewJY.f986t + "   " + trackControlPaintViewJY.f987u);
                return;
        }
    }
}
