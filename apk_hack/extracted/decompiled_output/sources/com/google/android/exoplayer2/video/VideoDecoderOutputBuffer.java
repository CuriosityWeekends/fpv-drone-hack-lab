package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import h2.h;
import java.nio.ByteBuffer;
import m0.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VideoDecoderOutputBuffer extends e {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    @Nullable
    public ColorInfo colorInfo;
    public int colorspace;
    @Nullable
    public ByteBuffer data;
    public int decoderPrivate;
    public int height;
    public int mode;
    private final h owner;
    @Nullable
    public ByteBuffer supplementalData;
    public int width;
    @Nullable
    public ByteBuffer[] yuvPlanes;
    @Nullable
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(h hVar) {
    }

    private static boolean isSafeToMultiply(int i3, int i5) {
        if (i3 >= 0 && i5 >= 0 && (i5 <= 0 || i3 < Integer.MAX_VALUE / i5)) {
            return true;
        }
        return false;
    }

    public void init(long j2, int i3, @Nullable ByteBuffer byteBuffer) {
        this.timeUs = j2;
        this.mode = i3;
        if (byteBuffer != null && byteBuffer.hasRemaining()) {
            addFlag(268435456);
            int limit = byteBuffer.limit();
            ByteBuffer byteBuffer2 = this.supplementalData;
            if (byteBuffer2 != null && byteBuffer2.capacity() >= limit) {
                this.supplementalData.clear();
            } else {
                this.supplementalData = ByteBuffer.allocate(limit);
            }
            this.supplementalData.put(byteBuffer);
            this.supplementalData.flip();
            byteBuffer.position(0);
            return;
        }
        this.supplementalData = null;
    }

    public void initForPrivateFrame(int i3, int i5) {
        this.width = i3;
        this.height = i5;
    }

    public boolean initForYuvFrame(int i3, int i5, int i6, int i7, int i8) {
        this.width = i3;
        this.height = i5;
        this.colorspace = i8;
        int i9 = (int) ((i5 + 1) / 2);
        if (isSafeToMultiply(i6, i5) && isSafeToMultiply(i7, i9)) {
            int i10 = i5 * i6;
            int i11 = i9 * i7;
            int i12 = (i11 * 2) + i10;
            if (isSafeToMultiply(i11, 2) && i12 >= i10) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer != null && byteBuffer.capacity() >= i12) {
                    this.data.position(0);
                    this.data.limit(i12);
                } else {
                    this.data = ByteBuffer.allocateDirect(i12);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                ByteBuffer slice = byteBuffer2.slice();
                byteBufferArr[0] = slice;
                slice.limit(i10);
                byteBuffer2.position(i10);
                ByteBuffer slice2 = byteBuffer2.slice();
                byteBufferArr[1] = slice2;
                slice2.limit(i11);
                byteBuffer2.position(i10 + i11);
                ByteBuffer slice3 = byteBuffer2.slice();
                byteBufferArr[2] = slice3;
                slice3.limit(i11);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i6;
                iArr[1] = i7;
                iArr[2] = i7;
                return true;
            }
        }
        return false;
    }

    @Override // m0.e
    public void release() {
        throw null;
    }
}
