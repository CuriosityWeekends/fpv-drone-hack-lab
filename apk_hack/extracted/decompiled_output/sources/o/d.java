package o;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import g.i;
import p.m;
import p.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2950a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ g.a d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f2951e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ i f2952f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p.a f2953g;

    public d(p.a aVar, int i3, int i5, boolean z3, g.a aVar2, m mVar, i iVar) {
        this.f2953g = aVar;
        this.f2950a = i3;
        this.b = i5;
        this.c = z3;
        this.d = aVar2;
        this.f2951e = mVar;
        this.f2952f = iVar;
    }

    /* JADX WARN: Type inference failed for: r9v6, types: [o.c, java.lang.Object] */
    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        if (((u) this.f2953g.b).b(this.f2950a, this.b, this.c, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == g.a.b) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new Object());
        size = imageInfo.getSize();
        int i3 = this.f2950a;
        if (i3 == Integer.MIN_VALUE) {
            i3 = size.getWidth();
        }
        int i5 = this.b;
        if (i5 == Integer.MIN_VALUE) {
            i5 = size.getHeight();
        }
        float b = this.f2951e.b(size.getWidth(), size.getHeight(), i3, i5);
        int round = Math.round(size.getWidth() * b);
        int round2 = Math.round(size.getHeight() * b);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b);
        }
        imageDecoder.setTargetSize(round, round2);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            if (this.f2952f == i.b) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named2 = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named2);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                    }
                }
            }
            named2 = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named2);
            imageDecoder.setTargetColorSpace(colorSpace2);
        } else if (i6 >= 26) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            imageDecoder.setTargetColorSpace(colorSpace);
        }
    }
}
