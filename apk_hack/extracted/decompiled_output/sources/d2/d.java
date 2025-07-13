package d2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f1605i = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f1606j = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: k  reason: collision with root package name */
    public static final float[] f1607k = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f1608l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: m  reason: collision with root package name */
    public static final float[] f1609m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public int f1610a;
    public c b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f1611e;

    /* renamed from: f  reason: collision with root package name */
    public int f1612f;

    /* renamed from: g  reason: collision with root package name */
    public int f1613g;

    /* renamed from: h  reason: collision with root package name */
    public int f1614h;

    public static boolean a(i2.c cVar) {
        c[] cVarArr = cVar.f2182a.f2181a;
        if (cVarArr.length != 1 || cVarArr[0].f1604a != 0) {
            return false;
        }
        c[] cVarArr2 = cVar.b.f2181a;
        if (cVarArr2.length != 1 || cVarArr2[0].f1604a != 0) {
            return false;
        }
        return true;
    }
}
