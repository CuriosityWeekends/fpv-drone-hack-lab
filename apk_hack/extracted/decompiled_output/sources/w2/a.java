package w2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.lg.picturesubmitt.widget.MyRockerView;
import t2.p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f3944a;
    public Sensor b;
    public Sensor c;
    public float d;

    /* renamed from: e  reason: collision with root package name */
    public float f3945e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f3946f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f3947g;

    /* renamed from: h  reason: collision with root package name */
    public p0 f3948h;

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        double d;
        double d5;
        int type = sensorEvent.sensor.getType();
        float[] fArr = this.f3946f;
        if (type == 1) {
            for (int i3 = 0; i3 < 3; i3++) {
                fArr[i3] = sensorEvent.values[i3];
            }
        }
        int type2 = sensorEvent.sensor.getType();
        float[] fArr2 = this.f3947g;
        if (type2 == 2) {
            for (int i5 = 0; i5 < 3; i5++) {
                fArr2[i5] = sensorEvent.values[i5];
            }
        }
        float[] fArr3 = new float[3];
        float[] fArr4 = new float[9];
        SensorManager.getRotationMatrix(fArr4, null, fArr, fArr2);
        SensorManager.getOrientation(fArr4, fArr3);
        float f4 = (this.d * 0.9f) + (fArr3[1] * 0.1f);
        this.d = f4;
        float f5 = (this.f3945e * 0.9f) + (fArr3[2] * 0.1f);
        this.f3945e = f5;
        double d6 = -(f4 / 1.3962634015954636d);
        if (d6 > 0.0d) {
            double d7 = d6 - 1.0d;
            d = ((-d7) * d7) + 1.0d;
        } else {
            double d8 = d6 + 1.0d;
            d = (d8 * d8) - 1.0d;
        }
        float f6 = (float) d;
        double d9 = -(f5 / 1.7453292519943295d);
        if (d9 > 0.0d) {
            double d10 = d9 - 1.0d;
            d5 = ((-d10) * d10) + 1.0d;
        } else {
            double d11 = d9 + 1.0d;
            d5 = (d11 * d11) - 1.0d;
        }
        float f7 = (float) d5;
        p0 p0Var = this.f3948h;
        p0Var.getClass();
        Log.d("处理前sensor", f6 + "/" + f7);
        if (Math.abs(f6) > 0.9d) {
            f7 = 0.0f;
        }
        if (Math.abs(f7) <= 1.0f) {
            Log.d("处理后sensor", f6 + "/" + f7);
            MyRockerView myRockerView = (MyRockerView) p0Var.b;
            float f8 = myRockerView.c;
            myRockerView.f945j = (f6 * f8) + myRockerView.f943h;
            myRockerView.f946k = (f7 * f8) + myRockerView.f944i;
            if (!myRockerView.f954u) {
                myRockerView.postInvalidate();
            }
            myRockerView.d();
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
