package androidx.core.graphics;

import a1.i;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
            PathDataNode pathDataNode = pathDataNodeArr[i3];
            char c = pathDataNode.mType;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i3];
            if (c != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i3, int i5) {
        if (i3 <= i5) {
            int length = fArr.length;
            if (i3 >= 0 && i3 <= length) {
                int i6 = i5 - i3;
                int min = Math.min(i6, length - i3);
                float[] fArr2 = new float[i6];
                System.arraycopy(fArr, i3, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        int i5 = 0;
        while (i3 < str.length()) {
            int nextStart = nextStart(str, i3);
            String trim = str.substring(i5, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i5 = nextStart;
            i3 = nextStart + 1;
        }
        if (i3 - i5 == 1 && i5 < str.length()) {
            addNode(arrayList, str.charAt(i5), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e5) {
                throw new RuntimeException(i.w("Error in parsing ", str), e5);
            }
        }
        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
            pathDataNodeArr2[i3] = new PathDataNode(pathDataNodeArr[i3]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
            try {
                float[] fArr = new float[str.length()];
                ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                int length = str.length();
                int i3 = 1;
                int i5 = 0;
                while (i3 < length) {
                    extract(str, i3, extractFloatResult);
                    int i6 = extractFloatResult.mEndPosition;
                    if (i3 < i6) {
                        fArr[i5] = Float.parseFloat(str.substring(i3, i6));
                        i5++;
                    }
                    if (extractFloatResult.mEndWithNegOrDot) {
                        i3 = i6;
                    } else {
                        i3 = i6 + 1;
                    }
                }
                return copyOfRange(fArr, 0, i5);
            } catch (NumberFormatException e5) {
                throw new RuntimeException(i.i("error in parsing \"", str, "\""), e5);
            }
        }
        return new float[0];
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f4) {
        if (pathDataNodeArr != null && pathDataNodeArr2 != null && pathDataNodeArr3 != null) {
            if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
                if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                    return false;
                }
                for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                    pathDataNodeArr[i3].interpolatePathDataNode(pathDataNodeArr2[i3], pathDataNodeArr3[i3], f4);
                }
                return true;
            }
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
    }

    private static int nextStart(String str, int i3) {
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if ((charAt - 'Z') * (charAt - 'A') > 0) {
                if ((charAt - 'z') * (charAt - 'a') > 0) {
                    continue;
                    i3++;
                }
            }
            if (charAt != 'e' && charAt != 'E') {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i3 = 0; i3 < pathDataNodeArr2.length; i3++) {
            pathDataNodeArr[i3].mType = pathDataNodeArr2[i3].mType;
            int i5 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i3].mParams;
                if (i5 < fArr.length) {
                    pathDataNodeArr[i3].mParams[i5] = fArr[i5];
                    i5++;
                }
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c, char c5, float[] fArr2) {
            int i3;
            int i5;
            boolean z3;
            boolean z5;
            boolean z6;
            boolean z7;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            char c6 = c5;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i3 = 7;
                    break;
                case 'C':
                case 'c':
                    i3 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i3 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i3 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i3 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    i3 = 2;
                    break;
            }
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i6 = 0;
            char c7 = c;
            while (i6 < fArr2.length) {
                if (c6 != 'A') {
                    if (c6 != 'C') {
                        if (c6 != 'H') {
                            if (c6 != 'Q') {
                                if (c6 != 'V') {
                                    if (c6 != 'a') {
                                        if (c6 != 'c') {
                                            if (c6 != 'h') {
                                                if (c6 != 'q') {
                                                    if (c6 != 'v') {
                                                        if (c6 != 'L') {
                                                            if (c6 != 'M') {
                                                                if (c6 != 'S') {
                                                                    if (c6 != 'T') {
                                                                        if (c6 != 'l') {
                                                                            if (c6 != 'm') {
                                                                                if (c6 != 's') {
                                                                                    if (c6 == 't') {
                                                                                        if (c7 != 'q' && c7 != 't' && c7 != 'Q' && c7 != 'T') {
                                                                                            f11 = 0.0f;
                                                                                            f10 = 0.0f;
                                                                                        } else {
                                                                                            f10 = f18 - f14;
                                                                                            f11 = f19 - f15;
                                                                                        }
                                                                                        int i7 = i6 + 1;
                                                                                        path.rQuadTo(f10, f11, fArr2[i6], fArr2[i7]);
                                                                                        float f22 = f10 + f18;
                                                                                        float f23 = f11 + f19;
                                                                                        f18 += fArr2[i6];
                                                                                        f19 += fArr2[i7];
                                                                                        f15 = f23;
                                                                                        f14 = f22;
                                                                                    }
                                                                                } else {
                                                                                    if (c7 != 'c' && c7 != 's' && c7 != 'C' && c7 != 'S') {
                                                                                        f9 = 0.0f;
                                                                                        f8 = 0.0f;
                                                                                    } else {
                                                                                        float f24 = f18 - f14;
                                                                                        f8 = f19 - f15;
                                                                                        f9 = f24;
                                                                                    }
                                                                                    int i8 = i6 + 1;
                                                                                    int i9 = i6 + 2;
                                                                                    int i10 = i6 + 3;
                                                                                    path.rCubicTo(f9, f8, fArr2[i6], fArr2[i8], fArr2[i9], fArr2[i10]);
                                                                                    f4 = fArr2[i6] + f18;
                                                                                    f5 = fArr2[i8] + f19;
                                                                                    f18 += fArr2[i9];
                                                                                    f6 = fArr2[i10];
                                                                                }
                                                                            } else {
                                                                                float f25 = fArr2[i6];
                                                                                f18 += f25;
                                                                                float f26 = fArr2[i6 + 1];
                                                                                f19 += f26;
                                                                                if (i6 > 0) {
                                                                                    path.rLineTo(f25, f26);
                                                                                } else {
                                                                                    path.rMoveTo(f25, f26);
                                                                                    i5 = i6;
                                                                                    f21 = f19;
                                                                                    f20 = f18;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            int i11 = i6 + 1;
                                                                            path.rLineTo(fArr2[i6], fArr2[i11]);
                                                                            f18 += fArr2[i6];
                                                                            f7 = fArr2[i11];
                                                                        }
                                                                    } else {
                                                                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                                                            f18 = (f18 * 2.0f) - f14;
                                                                            f19 = (f19 * 2.0f) - f15;
                                                                        }
                                                                        int i12 = i6 + 1;
                                                                        path.quadTo(f18, f19, fArr2[i6], fArr2[i12]);
                                                                        i5 = i6;
                                                                        f15 = f19;
                                                                        f14 = f18;
                                                                        f18 = fArr2[i6];
                                                                        f19 = fArr2[i12];
                                                                    }
                                                                } else {
                                                                    if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                                                        f18 = (f18 * 2.0f) - f14;
                                                                        f19 = (f19 * 2.0f) - f15;
                                                                    }
                                                                    float f27 = f19;
                                                                    float f28 = f18;
                                                                    int i13 = i6 + 1;
                                                                    int i14 = i6 + 2;
                                                                    int i15 = i6 + 3;
                                                                    path.cubicTo(f28, f27, fArr2[i6], fArr2[i13], fArr2[i14], fArr2[i15]);
                                                                    f4 = fArr2[i6];
                                                                    f5 = fArr2[i13];
                                                                    f18 = fArr2[i14];
                                                                    f19 = fArr2[i15];
                                                                    f14 = f4;
                                                                    f15 = f5;
                                                                }
                                                            } else {
                                                                f18 = fArr2[i6];
                                                                f19 = fArr2[i6 + 1];
                                                                if (i6 > 0) {
                                                                    path.lineTo(f18, f19);
                                                                } else {
                                                                    path.moveTo(f18, f19);
                                                                    i5 = i6;
                                                                    f21 = f19;
                                                                    f20 = f18;
                                                                }
                                                            }
                                                        } else {
                                                            int i16 = i6 + 1;
                                                            path.lineTo(fArr2[i6], fArr2[i16]);
                                                            f18 = fArr2[i6];
                                                            f19 = fArr2[i16];
                                                        }
                                                    } else {
                                                        path.rLineTo(0.0f, fArr2[i6]);
                                                        f7 = fArr2[i6];
                                                    }
                                                    f19 += f7;
                                                } else {
                                                    int i17 = i6 + 1;
                                                    int i18 = i6 + 2;
                                                    int i19 = i6 + 3;
                                                    path.rQuadTo(fArr2[i6], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                    f4 = fArr2[i6] + f18;
                                                    f5 = fArr2[i17] + f19;
                                                    f18 += fArr2[i18];
                                                    f6 = fArr2[i19];
                                                }
                                            } else {
                                                path.rLineTo(fArr2[i6], 0.0f);
                                                f18 += fArr2[i6];
                                            }
                                            i5 = i6;
                                        } else {
                                            int i20 = i6 + 2;
                                            int i21 = i6 + 3;
                                            int i22 = i6 + 4;
                                            int i23 = i6 + 5;
                                            path.rCubicTo(fArr2[i6], fArr2[i6 + 1], fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                            f4 = fArr2[i20] + f18;
                                            f5 = fArr2[i21] + f19;
                                            f18 += fArr2[i22];
                                            f6 = fArr2[i23];
                                        }
                                        f19 += f6;
                                        f14 = f4;
                                        f15 = f5;
                                        i5 = i6;
                                    } else {
                                        int i24 = i6 + 5;
                                        float f29 = fArr2[i24] + f18;
                                        int i25 = i6 + 6;
                                        float f30 = fArr2[i25] + f19;
                                        float f31 = fArr2[i6];
                                        float f32 = fArr2[i6 + 1];
                                        float f33 = fArr2[i6 + 2];
                                        if (fArr2[i6 + 3] != 0.0f) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (fArr2[i6 + 4] != 0.0f) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        i5 = i6;
                                        drawArc(path, f18, f19, f29, f30, f31, f32, f33, z6, z7);
                                        f18 += fArr2[i24];
                                        f19 += fArr2[i25];
                                    }
                                } else {
                                    i5 = i6;
                                    path.lineTo(f18, fArr2[i5]);
                                    f19 = fArr2[i5];
                                }
                            } else {
                                i5 = i6;
                                int i26 = i5 + 1;
                                int i27 = i5 + 2;
                                int i28 = i5 + 3;
                                path.quadTo(fArr2[i5], fArr2[i26], fArr2[i27], fArr2[i28]);
                                float f34 = fArr2[i5];
                                float f35 = fArr2[i26];
                                f18 = fArr2[i27];
                                f19 = fArr2[i28];
                                f14 = f34;
                                f15 = f35;
                            }
                        } else {
                            i5 = i6;
                            path.lineTo(fArr2[i5], f19);
                            f18 = fArr2[i5];
                        }
                    } else {
                        i5 = i6;
                        int i29 = i5 + 2;
                        int i30 = i5 + 3;
                        int i31 = i5 + 4;
                        int i32 = i5 + 5;
                        path.cubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i29], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f18 = fArr2[i31];
                        float f36 = fArr2[i32];
                        float f37 = fArr2[i29];
                        float f38 = fArr2[i30];
                        f19 = f36;
                        f15 = f38;
                        f14 = f37;
                    }
                    i6 = i5 + i3;
                    c7 = c5;
                    c6 = c7;
                } else {
                    i5 = i6;
                    float f39 = f19;
                    float f40 = f18;
                    int i33 = i5 + 5;
                    float f41 = fArr2[i33];
                    int i34 = i5 + 6;
                    float f42 = fArr2[i34];
                    float f43 = fArr2[i5];
                    float f44 = fArr2[i5 + 1];
                    float f45 = fArr2[i5 + 2];
                    if (fArr2[i5 + 3] != 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (fArr2[i5 + 4] != 0.0f) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    drawArc(path, f40, f39, f41, f42, f43, f44, f45, z3, z5);
                    f18 = fArr2[i33];
                    f19 = fArr2[i34];
                }
                f15 = f19;
                f14 = f18;
                i6 = i5 + i3;
                c7 = c5;
                c6 = c7;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        private static void arcToBezier(Path path, double d, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
            double d13 = d6;
            int ceil = (int) Math.ceil(Math.abs((d12 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d10);
            double sin = Math.sin(d10);
            double cos2 = Math.cos(d11);
            double sin2 = Math.sin(d11);
            double d14 = -d13;
            double d15 = d14 * cos;
            double d16 = d7 * sin;
            double d17 = (d15 * sin2) - (d16 * cos2);
            double d18 = d14 * sin;
            double d19 = d7 * cos;
            double d20 = (cos2 * d19) + (sin2 * d18);
            double d21 = d12 / ceil;
            double d22 = d11;
            double d23 = d20;
            double d24 = d17;
            int i3 = 0;
            double d25 = d8;
            double d26 = d9;
            while (i3 < ceil) {
                double d27 = d22 + d21;
                double sin3 = Math.sin(d27);
                double cos3 = Math.cos(d27);
                double d28 = (((d13 * cos) * cos3) + d) - (d16 * sin3);
                double d29 = (d19 * sin3) + (d13 * sin * cos3) + d5;
                double d30 = (d15 * sin3) - (d16 * cos3);
                double d31 = (cos3 * d19) + (sin3 * d18);
                double d32 = d27 - d22;
                double tan = Math.tan(d32 / 2.0d);
                double sqrt = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d32)) / 3.0d;
                double d33 = cos;
                double d34 = sin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d24 * sqrt) + d25), (float) ((d23 * sqrt) + d26), (float) (d28 - (sqrt * d30)), (float) (d29 - (sqrt * d31)), (float) d28, (float) d29);
                i3++;
                d21 = d21;
                sin = d34;
                d25 = d28;
                d18 = d18;
                cos = d33;
                d22 = d27;
                d23 = d31;
                d24 = d30;
                ceil = ceil;
                d26 = d29;
                d13 = d6;
            }
        }

        private static void drawArc(Path path, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z3, boolean z5) {
            double d;
            double d5;
            boolean z6;
            double radians = Math.toRadians(f10);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d6 = f4;
            double d7 = d6 * cos;
            double d8 = f5;
            double d9 = f8;
            double d10 = ((d8 * sin) + d7) / d9;
            double d11 = f9;
            double d12 = ((d8 * cos) + ((-f4) * sin)) / d11;
            double d13 = f7;
            double d14 = ((d13 * sin) + (f6 * cos)) / d9;
            double d15 = ((d13 * cos) + ((-f6) * sin)) / d11;
            double d16 = d10 - d14;
            double d17 = d12 - d15;
            double d18 = (d10 + d14) / 2.0d;
            double d19 = (d12 + d15) / 2.0d;
            double d20 = (d17 * d17) + (d16 * d16);
            if (d20 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d21 = (1.0d / d20) - 0.25d;
            if (d21 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d20);
                float sqrt = (float) (Math.sqrt(d20) / 1.99999d);
                drawArc(path, f4, f5, f6, f7, f8 * sqrt, f9 * sqrt, f10, z3, z5);
                return;
            }
            double sqrt2 = Math.sqrt(d21);
            double d22 = d16 * sqrt2;
            double d23 = sqrt2 * d17;
            if (z3 == z5) {
                d = d18 - d23;
                d5 = d19 + d22;
            } else {
                d = d18 + d23;
                d5 = d19 - d22;
            }
            double atan2 = Math.atan2(d12 - d5, d10 - d);
            double atan22 = Math.atan2(d15 - d5, d14 - d) - atan2;
            int i3 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (i3 >= 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z5 != z6) {
                if (i3 > 0) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d24 = d * d9;
            double d25 = d5 * d11;
            arcToBezier(path, (d24 * cos) - (d25 * sin), (d25 * cos) + (d24 * sin), d9, d11, d6, d8, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                PathDataNode pathDataNode = pathDataNodeArr[i3];
                addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
                c = pathDataNodeArr[i3].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f4) {
            this.mType = pathDataNode.mType;
            int i3 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i3 < fArr.length) {
                    this.mParams[i3] = (pathDataNode2.mParams[i3] * f4) + ((1.0f - f4) * fArr[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
