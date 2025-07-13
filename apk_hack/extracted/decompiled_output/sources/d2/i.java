package d2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements GLSurfaceView.Renderer, a {

    /* renamed from: a  reason: collision with root package name */
    public final f f1627a;
    public final float[] d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f1628e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f1629f;

    /* renamed from: g  reason: collision with root package name */
    public float f1630g;

    /* renamed from: h  reason: collision with root package name */
    public float f1631h;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f1634k;
    public final float[] b = new float[16];
    public final float[] c = new float[16];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f1632i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    public final float[] f1633j = new float[16];

    public i(SphericalGLSurfaceView sphericalGLSurfaceView, f fVar) {
        this.f1634k = sphericalGLSurfaceView;
        float[] fArr = new float[16];
        this.d = fArr;
        float[] fArr2 = new float[16];
        this.f1628e = fArr2;
        float[] fArr3 = new float[16];
        this.f1629f = fArr3;
        this.f1627a = fVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f1631h = 3.1415927f;
    }

    @Override // d2.a
    public final synchronized void a(float[] fArr, float f4) {
        float[] fArr2 = this.d;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f5 = -f4;
        this.f1631h = f5;
        Matrix.setRotateM(this.f1628e, 0, -this.f1630g, (float) Math.cos(f5), (float) Math.sin(this.f1631h), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            Matrix.multiplyMM(this.f1633j, 0, this.d, 0, this.f1629f, 0);
            Matrix.multiplyMM(this.f1632i, 0, this.f1628e, 0, this.f1633j, 0);
        }
        Matrix.multiplyMM(this.c, 0, this.b, 0, this.f1632i, 0);
        this.f1627a.a(this.c);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i5) {
        float f4;
        GLES20.glViewport(0, 0, i3, i5);
        float f5 = i3 / i5;
        if (f5 > 1.0f) {
            f4 = (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f5)) * 2.0d);
        } else {
            f4 = 90.0f;
        }
        Matrix.perspectiveM(this.b, 0, f4, f5, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f1634k;
        sphericalGLSurfaceView.d.post(new h(0, sphericalGLSurfaceView, this.f1627a.b()));
    }
}
