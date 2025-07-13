package d2;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: i  reason: collision with root package name */
    public int f1621i;

    /* renamed from: j  reason: collision with root package name */
    public SurfaceTexture f1622j;

    /* renamed from: m  reason: collision with root package name */
    public byte[] f1625m;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f1616a = new AtomicBoolean();
    public final AtomicBoolean b = new AtomicBoolean(true);
    public final d c = new Object();
    public final e.c d = new e.c();

    /* renamed from: e  reason: collision with root package name */
    public final c f1617e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final c f1618f = new c();

    /* renamed from: g  reason: collision with root package name */
    public final float[] f1619g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    public final float[] f1620h = new float[16];

    /* renamed from: k  reason: collision with root package name */
    public volatile int f1623k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1624l = -1;

    public final void a(float[] fArr) {
        float[] fArr2;
        Object d;
        GLES20.glClear(16384);
        g2.b.f();
        if (this.f1616a.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.f1622j;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            g2.b.f();
            if (this.b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f1619g, 0);
            }
            long timestamp = this.f1622j.getTimestamp();
            c cVar = this.f1617e;
            synchronized (cVar) {
                d = cVar.d(timestamp, false);
            }
            Long l5 = (Long) d;
            if (l5 != null) {
                e.c cVar2 = this.d;
                float[] fArr3 = this.f1619g;
                float[] fArr4 = (float[]) ((c) cVar2.d).e(l5.longValue());
                if (fArr4 != null) {
                    float f4 = fArr4[0];
                    float f5 = -fArr4[1];
                    float f6 = -fArr4[2];
                    float length = Matrix.length(f4, f5, f6);
                    float[] fArr5 = (float[]) cVar2.c;
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr5, 0, (float) Math.toDegrees(length), f4 / length, f5 / length, f6 / length);
                    } else {
                        Matrix.setIdentityM(fArr5, 0);
                    }
                    if (!cVar2.f1650a) {
                        e.c.b((float[]) cVar2.b, (float[]) cVar2.c);
                        cVar2.f1650a = true;
                    }
                    Matrix.multiplyMM(fArr3, 0, (float[]) cVar2.b, 0, (float[]) cVar2.c, 0);
                }
            }
            i2.c cVar3 = (i2.c) this.f1618f.e(timestamp);
            if (cVar3 != null) {
                d dVar = this.c;
                dVar.getClass();
                if (d.a(cVar3)) {
                    dVar.f1610a = cVar3.c;
                    dVar.b = new c(cVar3.f2182a.f2181a[0]);
                    if (!cVar3.d) {
                        new c(cVar3.b.f2181a[0]);
                    }
                    dVar.getClass();
                }
            }
        }
        Matrix.multiplyMM(this.f1620h, 0, fArr, 0, this.f1619g, 0);
        d dVar2 = this.c;
        int i3 = this.f1621i;
        float[] fArr6 = this.f1620h;
        c cVar4 = dVar2.b;
        if (cVar4 != null) {
            GLES20.glUseProgram(dVar2.c);
            g2.b.f();
            GLES20.glEnableVertexAttribArray(dVar2.f1612f);
            GLES20.glEnableVertexAttribArray(dVar2.f1613g);
            g2.b.f();
            int i5 = dVar2.f1610a;
            if (i5 == 1) {
                fArr2 = d.f1608l;
            } else if (i5 == 2) {
                fArr2 = d.f1609m;
            } else {
                fArr2 = d.f1607k;
            }
            GLES20.glUniformMatrix3fv(dVar2.f1611e, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(dVar2.d, 1, false, fArr6, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i3);
            GLES20.glUniform1i(dVar2.f1614h, 0);
            g2.b.f();
            GLES20.glVertexAttribPointer(dVar2.f1612f, 3, 5126, false, 12, (Buffer) ((FloatBuffer) cVar4.c));
            g2.b.f();
            GLES20.glVertexAttribPointer(dVar2.f1613g, 2, 5126, false, 8, (Buffer) ((FloatBuffer) cVar4.d));
            g2.b.f();
            GLES20.glDrawArrays(cVar4.b, 0, cVar4.f1604a);
            g2.b.f();
            GLES20.glDisableVertexAttribArray(dVar2.f1612f);
            GLES20.glDisableVertexAttribArray(dVar2.f1613g);
        }
    }

    public final SurfaceTexture b() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        g2.b.f();
        d dVar = this.c;
        dVar.getClass();
        int k5 = g2.b.k(TextUtils.join("\n", d.f1605i), TextUtils.join("\n", d.f1606j));
        dVar.c = k5;
        dVar.d = GLES20.glGetUniformLocation(k5, "uMvpMatrix");
        dVar.f1611e = GLES20.glGetUniformLocation(dVar.c, "uTexMatrix");
        dVar.f1612f = GLES20.glGetAttribLocation(dVar.c, "aPosition");
        dVar.f1613g = GLES20.glGetAttribLocation(dVar.c, "aTexCoords");
        dVar.f1614h = GLES20.glGetUniformLocation(dVar.c, "uTexture");
        g2.b.f();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        g2.b.f();
        this.f1621i = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f1621i);
        this.f1622j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: d2.e
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                f.this.f1616a.set(true);
            }
        });
        return this.f1622j;
    }
}
