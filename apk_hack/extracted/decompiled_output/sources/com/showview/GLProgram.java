package com.showview;

import a1.i;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GLProgram {
    private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_y;\nuniform sampler2D tex_u;\nuniform sampler2D tex_v;\nvarying vec2 tc;\nvoid main() {\nvec4 c = vec4((texture2D(tex_y, tc).r - 16./255.) * 1.164);\nvec4 U = vec4(texture2D(tex_u, tc).r - 128./255.);\nvec4 V = vec4(texture2D(tex_v, tc).r - 128./255.);\nc += V * vec4(1.596, -0.813, 0, 0);\nc += U * vec4(0, -0.392, 2.017, 0);\nc.a = 1.0;\ngl_FragColor = c;\n}\n";
    static final String TAG = "GLProgram";
    private static final String VERTEX_SHADER = "attribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 tc;\nvoid main() {\ngl_Position = vPosition;\ntc = a_texCoord;\n}\n";
    private ByteBuffer _coord_buffer;
    private int _program;
    private int _tIIIindex;
    private int _tIIindex;
    private int _tIindex;
    private int _textureI;
    private int _textureII;
    private int _textureIII;
    private ByteBuffer _vertice_buffer;
    private float[] _vertices;
    public final int mWinPosition;
    private static float[] squareVertices = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static float[] squareVertices1 = {-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f};
    private static float[] squareVertices2 = {0.0f, -1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static float[] squareVertices3 = {-1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f};
    private static float[] squareVertices4 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static float[] coordVertices = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int _positionHandle = -1;
    private int _coordHandle = -1;
    private int _yhandle = -1;
    private int _uhandle = -1;
    private int _vhandle = -1;
    private int _ytid = -1;
    private int _utid = -1;
    private int _vtid = -1;
    private int _video_width = -1;
    private int _video_height = -1;
    private boolean isProgBuilt = false;

    public GLProgram(int i3) {
        if (i3 >= 0 && i3 <= 4) {
            this.mWinPosition = i3;
            setup(i3);
            return;
        }
        throw new RuntimeException("Index can only be 0 to 4");
    }

    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e(TAG, "***** " + str + ": glError " + glGetError, null);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    private void createBuffers(float[] fArr, float[] fArr2) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        this._vertice_buffer = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
        this._vertice_buffer.asFloatBuffer().put(fArr);
        this._vertice_buffer.position(0);
        if (this._coord_buffer == null) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
            this._coord_buffer = allocateDirect2;
            allocateDirect2.order(ByteOrder.nativeOrder());
            this._coord_buffer.asFloatBuffer().put(fArr2);
            this._coord_buffer.position(0);
        }
    }

    private int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e(TAG, "Could not compile shader " + i3 + ":", null);
                Log.e(TAG, GLES20.glGetShaderInfoLog(glCreateShader), null);
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    public void buildProgram() {
        createBuffers(this._vertices, coordVertices);
        if (this._program <= 0) {
            this._program = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        }
        i.u(new StringBuilder("_program = "), this._program, TAG);
        this._positionHandle = GLES20.glGetAttribLocation(this._program, "vPosition");
        i.u(new StringBuilder("_positionHandle = "), this._positionHandle, TAG);
        checkGlError("glGetAttribLocation vPosition");
        if (this._positionHandle != -1) {
            this._coordHandle = GLES20.glGetAttribLocation(this._program, "a_texCoord");
            i.u(new StringBuilder("_coordHandle = "), this._coordHandle, TAG);
            checkGlError("glGetAttribLocation a_texCoord");
            if (this._coordHandle != -1) {
                this._yhandle = GLES20.glGetUniformLocation(this._program, "tex_y");
                i.u(new StringBuilder("_yhandle = "), this._yhandle, TAG);
                checkGlError("glGetUniformLocation tex_y");
                if (this._yhandle != -1) {
                    this._uhandle = GLES20.glGetUniformLocation(this._program, "tex_u");
                    i.u(new StringBuilder("_uhandle = "), this._uhandle, TAG);
                    checkGlError("glGetUniformLocation tex_u");
                    if (this._uhandle != -1) {
                        this._vhandle = GLES20.glGetUniformLocation(this._program, "tex_v");
                        i.u(new StringBuilder("_vhandle = "), this._vhandle, TAG);
                        checkGlError("glGetUniformLocation tex_v");
                        if (this._vhandle != -1) {
                            this.isProgBuilt = true;
                            return;
                        }
                        throw new RuntimeException("Could not get uniform location for tex_v");
                    }
                    throw new RuntimeException("Could not get uniform location for tex_u");
                }
                throw new RuntimeException("Could not get uniform location for tex_y");
            }
            throw new RuntimeException("Could not get attribute location for a_texCoord");
        }
        throw new RuntimeException("Could not get attribute location for vPosition");
    }

    public void buildTextures(Buffer buffer, Buffer buffer2, Buffer buffer3, int i3, int i5) {
        boolean z3;
        int i6;
        if (i3 == this._video_width && i5 == this._video_height) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            this._video_width = i3;
            this._video_height = i5;
            StringBuilder sb = new StringBuilder("buildTextures videoSizeChanged: w=");
            sb.append(this._video_width);
            sb.append(" h=");
            i.u(sb, this._video_height, TAG);
        }
        int i7 = this._ytid;
        if (i7 < 0 || z3) {
            if (i7 >= 0) {
                Log.d(TAG, "glDeleteTextures Y");
                GLES20.glDeleteTextures(1, new int[]{this._ytid}, 0);
                checkGlError("glDeleteTextures");
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            checkGlError("glGenTextures");
            this._ytid = iArr[0];
            i.u(new StringBuilder("glGenTextures Y = "), this._ytid, TAG);
        }
        GLES20.glBindTexture(3553, this._ytid);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6409, this._video_width, this._video_height, 0, 6409, 5121, buffer);
        checkGlError("glTexImage2D");
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i8 = this._utid;
        if (i8 < 0 || z3) {
            if (i8 >= 0) {
                Log.d(TAG, "glDeleteTextures U");
                GLES20.glDeleteTextures(1, new int[]{this._utid}, 0);
                checkGlError("glDeleteTextures");
            }
            int[] iArr2 = new int[1];
            GLES20.glGenTextures(1, iArr2, 0);
            checkGlError("glGenTextures");
            this._utid = iArr2[0];
            i.u(new StringBuilder("glGenTextures U = "), this._utid, TAG);
        }
        GLES20.glBindTexture(3553, this._utid);
        GLES20.glTexImage2D(3553, 0, 6409, this._video_width / 2, this._video_height / 2, 0, 6409, 5121, buffer2);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i9 = this._vtid;
        if (i9 < 0 || z3) {
            if (i9 >= 0) {
                Log.d(TAG, "glDeleteTextures V");
                i6 = 1;
                GLES20.glDeleteTextures(1, new int[]{this._vtid}, 0);
                checkGlError("glDeleteTextures");
            } else {
                i6 = 1;
            }
            int[] iArr3 = new int[i6];
            GLES20.glGenTextures(i6, iArr3, 0);
            checkGlError("glGenTextures");
            this._vtid = iArr3[0];
            i.u(new StringBuilder("glGenTextures V = "), this._vtid, TAG);
        }
        GLES20.glBindTexture(3553, this._vtid);
        GLES20.glTexImage2D(3553, 0, 6409, this._video_width / 2, this._video_height / 2, 0, 6409, 5121, buffer3);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    public int createProgram(String str, String str2) {
        int loadShader = loadShader(35633, str);
        int loadShader2 = loadShader(35632, str2);
        Log.d(TAG, "vertexShader = " + loadShader);
        Log.d(TAG, "pixelShader = " + loadShader2);
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(TAG, "Could not link program: ", null);
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram), null);
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            return glCreateProgram;
        }
        return glCreateProgram;
    }

    public void drawFrame() {
        GLES20.glUseProgram(this._program);
        checkGlError("glUseProgram");
        GLES20.glVertexAttribPointer(this._positionHandle, 2, 5126, false, 8, (Buffer) this._vertice_buffer);
        checkGlError("glVertexAttribPointer mPositionHandle");
        GLES20.glEnableVertexAttribArray(this._positionHandle);
        GLES20.glVertexAttribPointer(this._coordHandle, 2, 5126, false, 8, (Buffer) this._coord_buffer);
        checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this._coordHandle);
        GLES20.glActiveTexture(this._textureI);
        GLES20.glBindTexture(3553, this._ytid);
        GLES20.glUniform1i(this._yhandle, this._tIindex);
        GLES20.glActiveTexture(this._textureII);
        GLES20.glBindTexture(3553, this._utid);
        GLES20.glUniform1i(this._uhandle, this._tIIindex);
        GLES20.glActiveTexture(this._textureIII);
        GLES20.glBindTexture(3553, this._vtid);
        GLES20.glUniform1i(this._vhandle, this._tIIIindex);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
        GLES20.glDisableVertexAttribArray(this._positionHandle);
        GLES20.glDisableVertexAttribArray(this._coordHandle);
    }

    public boolean isProgramBuilt() {
        return this.isProgBuilt;
    }

    public void setup(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        this._vertices = squareVertices;
                        this._textureI = 33984;
                        this._textureII = 33985;
                        this._textureIII = 33986;
                        this._tIindex = 0;
                        this._tIIindex = 1;
                        this._tIIIindex = 2;
                        return;
                    }
                    this._vertices = squareVertices4;
                    this._textureI = 33993;
                    this._textureII = 33994;
                    this._textureIII = 33995;
                    this._tIindex = 9;
                    this._tIIindex = 10;
                    this._tIIIindex = 11;
                    return;
                }
                this._vertices = squareVertices3;
                this._textureI = 33990;
                this._textureII = 33991;
                this._textureIII = 33992;
                this._tIindex = 6;
                this._tIIindex = 7;
                this._tIIIindex = 8;
                return;
            }
            this._vertices = squareVertices2;
            this._textureI = 33987;
            this._textureII = 33988;
            this._textureIII = 33989;
            this._tIindex = 3;
            this._tIIindex = 4;
            this._tIIIindex = 5;
            return;
        }
        this._vertices = squareVertices;
        this._textureI = 33984;
        this._textureII = 33985;
        this._textureIII = 33986;
        this._tIindex = 0;
        this._tIIindex = 1;
        this._tIIIindex = 2;
    }
}
