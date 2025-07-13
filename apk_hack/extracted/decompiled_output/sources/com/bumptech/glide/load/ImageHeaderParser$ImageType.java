package com.bumptech.glide.load;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(0),
    JPEG(1),
    RAW(2),
    PNG_A(3),
    PNG(4),
    WEBP_A(5),
    WEBP(6),
    UNKNOWN(7);
    

    /* renamed from: a  reason: collision with root package name */
    public final boolean f254a;

    ImageHeaderParser$ImageType(int i3) {
        this.f254a = r2;
    }

    public boolean hasAlpha() {
        return this.f254a;
    }
}
