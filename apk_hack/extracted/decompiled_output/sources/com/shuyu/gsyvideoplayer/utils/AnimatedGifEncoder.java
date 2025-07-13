package com.shuyu.gsyvideoplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class AnimatedGifEncoder {
    protected int colorDepth;
    protected byte[] colorTab;
    protected int height;
    protected Bitmap image;
    protected byte[] indexedPixels;
    protected OutputStream out;
    protected byte[] pixels;
    protected int transIndex;
    protected int width;

    /* renamed from: x  reason: collision with root package name */
    protected int f1143x = 0;

    /* renamed from: y  reason: collision with root package name */
    protected int f1144y = 0;
    protected int transparent = -1;
    protected int repeat = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] usedEntry = new boolean[256];
    protected int palSize = 7;
    protected int dispose = -1;
    protected boolean closeStream = false;
    protected boolean firstFrame = true;
    protected boolean sizeSet = false;
    protected int sample = 10;

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public boolean addFrame(android.graphics.Bitmap r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L43
            boolean r1 = r3.started
            if (r1 != 0) goto L8
            goto L43
        L8:
            boolean r1 = r3.sizeSet     // Catch: java.io.IOException -> L43
            if (r1 != 0) goto L17
            int r1 = r4.getWidth()     // Catch: java.io.IOException -> L43
            int r2 = r4.getHeight()     // Catch: java.io.IOException -> L43
            r3.setSize(r1, r2)     // Catch: java.io.IOException -> L43
        L17:
            r3.image = r4     // Catch: java.io.IOException -> L43
            r3.getImagePixels()     // Catch: java.io.IOException -> L43
            r3.analyzePixels()     // Catch: java.io.IOException -> L43
            boolean r4 = r3.firstFrame     // Catch: java.io.IOException -> L43
            if (r4 == 0) goto L30
            r3.writeLSD()     // Catch: java.io.IOException -> L43
            r3.writePalette()     // Catch: java.io.IOException -> L43
            int r4 = r3.repeat     // Catch: java.io.IOException -> L43
            if (r4 < 0) goto L30
            r3.writeNetscapeExt()     // Catch: java.io.IOException -> L43
        L30:
            r3.writeGraphicCtrlExt()     // Catch: java.io.IOException -> L43
            r3.writeImageDesc()     // Catch: java.io.IOException -> L43
            boolean r4 = r3.firstFrame     // Catch: java.io.IOException -> L43
            if (r4 != 0) goto L3d
            r3.writePalette()     // Catch: java.io.IOException -> L43
        L3d:
            r3.writePixels()     // Catch: java.io.IOException -> L43
            r3.firstFrame = r0     // Catch: java.io.IOException -> L43
            r0 = 1
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.utils.AnimatedGifEncoder.addFrame(android.graphics.Bitmap):boolean");
    }

    public void analyzePixels() {
        byte[] bArr = this.pixels;
        int length = bArr.length;
        int i3 = length / 3;
        this.indexedPixels = new byte[i3];
        NeuQuant neuQuant = new NeuQuant(bArr, length, this.sample);
        this.colorTab = neuQuant.process();
        int i5 = 0;
        while (true) {
            byte[] bArr2 = this.colorTab;
            if (i5 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i5];
            int i6 = i5 + 2;
            bArr2[i5] = bArr2[i6];
            bArr2[i6] = b;
            this.usedEntry[i5 / 3] = false;
            i5 += 3;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            byte[] bArr3 = this.pixels;
            int i9 = i7 + 2;
            i7 += 3;
            int map = neuQuant.map(bArr3[i7] & 255, bArr3[i7 + 1] & 255, bArr3[i9] & 255);
            this.usedEntry[map] = true;
            this.indexedPixels[i8] = (byte) map;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        int i10 = this.transparent;
        if (i10 != -1) {
            this.transIndex = findClosest(i10);
        }
    }

    public int findClosest(int i3) {
        byte[] bArr = this.colorTab;
        if (bArr == null) {
            return -1;
        }
        int i5 = (i3 >> 16) & 255;
        int i6 = (i3 >> 8) & 255;
        int i7 = i3 & 255;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 16777216;
        for (int i10 = 0; i10 < length; i10 += 3) {
            byte[] bArr2 = this.colorTab;
            int i11 = i5 - (bArr2[i10] & 255);
            int i12 = i10 + 2;
            int i13 = i6 - (bArr2[i10 + 1] & 255);
            int i14 = i7 - (bArr2[i12] & 255);
            int i15 = i14 * i14;
            int i16 = i15 + (i13 * i13) + (i11 * i11);
            int i17 = i12 / 3;
            if (this.usedEntry[i17] && i16 < i9) {
                i9 = i16;
                i8 = i17;
            }
        }
        return i8;
    }

    public boolean finish() {
        boolean z3;
        if (!this.started) {
            return false;
        }
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.closeStream) {
                this.out.close();
            }
            z3 = true;
        } catch (IOException unused) {
            z3 = false;
        }
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return z3;
    }

    public int[] getImageData(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    public void getImagePixels() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int i3 = this.width;
        if (width != i3 || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(i3, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] imageData = getImageData(this.image);
        this.pixels = new byte[imageData.length * 3];
        for (int i5 = 0; i5 < imageData.length; i5++) {
            int i6 = imageData[i5];
            int i7 = i5 * 3;
            byte[] bArr = this.pixels;
            bArr[i7] = (byte) (i6 & 255);
            bArr[i7 + 1] = (byte) ((i6 >> 8) & 255);
            bArr[i7 + 2] = (byte) ((i6 >> 16) & 255);
        }
    }

    public void setDelay(int i3) {
        this.delay = i3 / 10;
    }

    public void setDispose(int i3) {
        if (i3 >= 0) {
            this.dispose = i3;
        }
    }

    public void setFrameRate(float f4) {
        if (f4 != 0.0f) {
            this.delay = (int) (100.0f / f4);
        }
    }

    public void setPosition(int i3, int i5) {
        this.f1143x = i3;
        this.f1144y = i5;
    }

    public void setQuality(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        this.sample = i3;
    }

    public void setRepeat(int i3) {
        if (i3 >= 0) {
            this.repeat = i3;
        }
    }

    public void setSize(int i3, int i5) {
        this.width = i3;
        this.height = i5;
        if (i3 < 1) {
            this.width = 320;
        }
        if (i5 < 1) {
            this.height = 240;
        }
        this.sizeSet = true;
    }

    public void setTransparent(int i3) {
        this.transparent = i3;
    }

    public boolean start(OutputStream outputStream) {
        boolean z3 = false;
        if (outputStream == null) {
            return false;
        }
        this.closeStream = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
            z3 = true;
        } catch (IOException unused) {
        }
        this.started = z3;
        return z3;
    }

    public void writeGraphicCtrlExt() {
        int i3;
        int i5;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == -1) {
            i3 = 0;
            i5 = 0;
        } else {
            i3 = 1;
            i5 = 2;
        }
        int i6 = this.dispose;
        if (i6 >= 0) {
            i5 = i6 & 7;
        }
        this.out.write(i3 | (i5 << 2));
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    public void writeImageDesc() {
        this.out.write(44);
        writeShort(this.f1143x);
        writeShort(this.f1144y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        } else {
            this.out.write(this.palSize | 128);
        }
    }

    public void writeLSD() {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | 240);
        this.out.write(0);
        this.out.write(0);
    }

    public void writeNetscapeExt() {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    public void writePalette() {
        OutputStream outputStream = this.out;
        byte[] bArr = this.colorTab;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.colorTab.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.out.write(0);
        }
    }

    public void writePixels() {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    public void writeShort(int i3) {
        this.out.write(i3 & 255);
        this.out.write((i3 >> 8) & 255);
    }

    public void writeString(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            this.out.write((byte) str.charAt(i3));
        }
    }
}
