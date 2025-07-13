package d2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1600a = new float[16];
    public final float[] b = new float[16];
    public final float[] c = new float[16];
    public final float[] d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public final Display f1601e;

    /* renamed from: f  reason: collision with root package name */
    public final a[] f1602f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1603g;

    public b(Display display, a... aVarArr) {
        this.f1601e = display;
        this.f1602f = aVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i3;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f1600a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f1601e.getRotation();
        float[] fArr3 = this.b;
        if (rotation != 0) {
            int i5 = 129;
            if (rotation != 1) {
                i3 = 130;
                if (rotation != 2) {
                    if (rotation == 3) {
                        i5 = 130;
                        i3 = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } else {
                i5 = 2;
                i3 = 129;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i5, i3, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f4 = fArr4[2];
        Matrix.rotateM(this.f1600a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z3 = this.f1603g;
        float[] fArr5 = this.f1600a;
        if (!z3) {
            e.c.b(this.c, fArr5);
            this.f1603g = true;
        }
        System.arraycopy(fArr5, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr5, 0, this.b, 0, this.c, 0);
        for (a aVar : this.f1602f) {
            aVar.a(fArr2, f4);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
