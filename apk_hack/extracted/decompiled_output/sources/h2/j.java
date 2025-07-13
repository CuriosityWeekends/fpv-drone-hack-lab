package h2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements GLSurfaceView.Renderer, i {

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f2008j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final float[] f2009k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f2010l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f2011m = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: n  reason: collision with root package name */
    public static final FloatBuffer f2012n = g2.b.l(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    public int d;

    /* renamed from: f  reason: collision with root package name */
    public int f2015f;

    /* renamed from: i  reason: collision with root package name */
    public VideoDecoderOutputBuffer f2018i;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2013a = new int[3];
    public final AtomicReference b = new AtomicReference();
    public final FloatBuffer[] c = new FloatBuffer[3];

    /* renamed from: e  reason: collision with root package name */
    public final int[] f2014e = new int[3];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f2016g = new int[3];

    /* renamed from: h  reason: collision with root package name */
    public final int[] f2017h = new int[3];

    public j() {
        for (int i3 = 0; i3 < 3; i3++) {
            int[] iArr = this.f2016g;
            this.f2017h[i3] = -1;
            iArr[i3] = -1;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        boolean z3;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.b.getAndSet(null);
        if (videoDecoderOutputBuffer == null && this.f2018i == null) {
            return;
        }
        if (videoDecoderOutputBuffer != null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f2018i;
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.f2018i = videoDecoderOutputBuffer;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = this.f2018i;
        float[] fArr = f2009k;
        int i3 = videoDecoderOutputBuffer3.colorspace;
        if (i3 != 1) {
            if (i3 == 3) {
                fArr = f2010l;
            }
        } else {
            fArr = f2008j;
        }
        GLES20.glUniformMatrix3fv(this.f2015f, 1, false, fArr, 0);
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = videoDecoderOutputBuffer3.height;
            if (i5 != 0) {
                i6 = (i6 + 1) / 2;
            }
            int i7 = i6;
            GLES20.glActiveTexture(33984 + i5);
            GLES20.glBindTexture(3553, this.f2013a[i5]);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexImage2D(3553, 0, 6409, videoDecoderOutputBuffer3.yuvStrides[i5], i7, 0, 6409, 5121, videoDecoderOutputBuffer3.yuvPlanes[i5]);
        }
        int i8 = videoDecoderOutputBuffer3.width;
        int i9 = (i8 + 1) / 2;
        int[] iArr = {i8, i9, i9};
        for (int i10 = 0; i10 < 3; i10++) {
            int[] iArr2 = this.f2016g;
            int i11 = iArr2[i10];
            int i12 = iArr[i10];
            int[] iArr3 = this.f2017h;
            if (i11 != i12 || iArr3[i10] != videoDecoderOutputBuffer3.yuvStrides[i10]) {
                if (videoDecoderOutputBuffer3.yuvStrides[i10] != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.h(z3);
                float f4 = iArr[i10] / videoDecoderOutputBuffer3.yuvStrides[i10];
                FloatBuffer l5 = g2.b.l(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f4, 0.0f, f4, 1.0f});
                FloatBuffer[] floatBufferArr = this.c;
                floatBufferArr[i10] = l5;
                GLES20.glVertexAttribPointer(this.f2014e[i10], 2, 5126, false, 0, (Buffer) floatBufferArr[i10]);
                iArr2[i10] = iArr[i10];
                iArr3[i10] = videoDecoderOutputBuffer3.yuvStrides[i10];
            }
        }
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        g2.b.f();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i5) {
        GLES20.glViewport(0, 0, i3, i5);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int k5 = g2.b.k("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.d = k5;
        GLES20.glUseProgram(k5);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.d, "in_pos");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) f2012n);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.d, "in_tc_y");
        int[] iArr = this.f2014e;
        iArr[0] = glGetAttribLocation2;
        GLES20.glEnableVertexAttribArray(iArr[0]);
        iArr[1] = GLES20.glGetAttribLocation(this.d, "in_tc_u");
        GLES20.glEnableVertexAttribArray(iArr[1]);
        iArr[2] = GLES20.glGetAttribLocation(this.d, "in_tc_v");
        GLES20.glEnableVertexAttribArray(iArr[2]);
        g2.b.f();
        this.f2015f = GLES20.glGetUniformLocation(this.d, "mColorConversion");
        g2.b.f();
        int[] iArr2 = this.f2013a;
        GLES20.glGenTextures(3, iArr2, 0);
        for (int i3 = 0; i3 < 3; i3++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.d, f2011m[i3]), i3);
            GLES20.glActiveTexture(33984 + i3);
            GLES20.glBindTexture(3553, iArr2[i3]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        g2.b.f();
        g2.b.f();
    }
}
