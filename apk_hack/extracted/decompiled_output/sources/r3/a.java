package r3;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import b3.d;
import com.shuyu.gsyvideoplayer.utils.Debuger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3438a;
    public t3.a b;
    public GLSurfaceView c;
    public float[] d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f3439e;

    /* renamed from: f  reason: collision with root package name */
    public int f3440f;

    /* renamed from: g  reason: collision with root package name */
    public int f3441g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3442h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3443i;

    /* renamed from: j  reason: collision with root package name */
    public t3.b f3444j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f3445k;

    public static int c(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Debuger.printfError("Could not compile shader " + i3 + ":");
                Debuger.printfError(GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    public final void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Debuger.printfError(str + ": glError " + glGetError);
            this.f3445k.post(new d(this, str, glGetError));
        }
    }

    public final int b() {
        int c;
        int c5 = c(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
        if (c5 == 0 || (c = c(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n")) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, c5);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, c);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Debuger.printfError("Could not link program: ");
                Debuger.printfError(GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }
}
