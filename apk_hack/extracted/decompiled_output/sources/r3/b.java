package r3;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.Matrix;
import android.os.Handler;
import android.view.Surface;
import com.tencent.bugly.proguard.c0;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import n3.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends a {

    /* renamed from: l  reason: collision with root package name */
    public int f3446l;

    /* renamed from: m  reason: collision with root package name */
    public final int[] f3447m;

    /* renamed from: n  reason: collision with root package name */
    public int f3448n;

    /* renamed from: o  reason: collision with root package name */
    public int f3449o;

    /* renamed from: p  reason: collision with root package name */
    public int f3450p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3451r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public final FloatBuffer f3452t;

    /* renamed from: u  reason: collision with root package name */
    public SurfaceTexture f3453u;

    /* renamed from: v  reason: collision with root package name */
    public d f3454v;
    public s3.b w;

    public b() {
        this.f3438a = false;
        this.d = new float[16];
        float[] fArr = new float[16];
        this.f3439e = fArr;
        this.f3440f = 0;
        this.f3441g = 0;
        this.f3442h = false;
        this.f3443i = false;
        this.f3445k = new Handler();
        this.f3447m = new int[2];
        this.f3451r = false;
        this.s = false;
        this.w = new j3.b(23);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f3452t = asFloatBuffer;
        asFloatBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f}).position(0);
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(this.d, 0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        Bitmap bitmap;
        synchronized (this) {
            try {
                if (this.f3451r) {
                    this.f3453u.updateTexImage();
                    this.f3453u.getTransformMatrix(this.f3439e);
                    this.f3451r = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f3442h) {
            this.w.getClass();
            this.f3446l = b();
            this.f3442h = false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f3446l);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f3447m[0]);
        FloatBuffer floatBuffer = this.f3452t;
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f3450p, 3, 5126, false, 20, (Buffer) this.f3452t);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f3450p);
        a("glEnableVertexAttribArray maPositionHandle");
        floatBuffer.position(3);
        GLES20.glVertexAttribPointer(this.q, 3, 5126, false, 20, (Buffer) this.f3452t);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.q);
        a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f3448n, 1, false, this.d, 0);
        GLES20.glUniformMatrix4fv(this.f3449o, 1, false, this.f3439e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        if (this.s) {
            this.s = false;
            if (this.f3454v != null) {
                int width = this.c.getWidth();
                int height = this.c.getHeight();
                int i3 = width * height;
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                try {
                    gl10.glReadPixels(0, 0, width, height, 6408, 5121, wrap);
                    for (int i5 = 0; i5 < height; i5++) {
                        int i6 = i5 * width;
                        int i7 = ((height - i5) - 1) * width;
                        for (int i8 = 0; i8 < width; i8++) {
                            int i9 = iArr[i6 + i8];
                            iArr2[i7 + i8] = (i9 & (-16711936)) | ((i9 << 16) & 16711680) | ((i9 >> 16) & 255);
                        }
                    }
                    if (this.f3438a) {
                        bitmap = Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.ARGB_8888);
                    } else {
                        bitmap = Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.RGB_565);
                    }
                } catch (GLException unused) {
                    bitmap = null;
                }
                ((c1.b) this.f3454v).s(bitmap);
            }
        }
        GLES20.glFinish();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f3451r = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i5) {
        GLES20.glViewport(0, 0, i3, i5);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.w.getClass();
        int b = b();
        this.f3446l = b;
        if (b == 0) {
            return;
        }
        this.f3450p = GLES20.glGetAttribLocation(b, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f3450p != -1) {
            this.q = GLES20.glGetAttribLocation(this.f3446l, "aTextureCoord");
            a("glGetAttribLocation aTextureCoord");
            if (this.q != -1) {
                this.f3448n = GLES20.glGetUniformLocation(this.f3446l, "uMVPMatrix");
                a("glGetUniformLocation uMVPMatrix");
                if (this.f3448n != -1) {
                    this.f3449o = GLES20.glGetUniformLocation(this.f3446l, "uSTMatrix");
                    a("glGetUniformLocation uSTMatrix");
                    if (this.f3449o != -1) {
                        int[] iArr = this.f3447m;
                        GLES20.glGenTextures(2, iArr, 0);
                        GLES20.glBindTexture(36197, iArr[0]);
                        a("glBindTexture mTextureID");
                        GLES20.glTexParameteri(3553, 10241, 9729);
                        GLES20.glTexParameteri(3553, 10240, 9729);
                        GLES20.glTexParameteri(3553, 10242, 33071);
                        GLES20.glTexParameteri(3553, 10243, 33071);
                        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
                        this.f3453u = surfaceTexture;
                        surfaceTexture.setOnFrameAvailableListener(this);
                        this.f3445k.post(new c0(6, this, new Surface(this.f3453u)));
                        return;
                    }
                    throw new RuntimeException("Could not get attrib location for uSTMatrix");
                }
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }
}
