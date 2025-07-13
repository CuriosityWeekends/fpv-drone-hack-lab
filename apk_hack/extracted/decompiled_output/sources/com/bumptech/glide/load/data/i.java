package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import p.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements g {
    public static final h c = new h(0);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f260a;
    public final Object b;

    public i() {
        this.f260a = 0;
        this.b = new HashMap();
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        switch (this.f260a) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.b).rewind();
            case 2:
                return this.b;
            default:
                w wVar = (w) this.b;
                wVar.reset();
                return wVar;
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
        switch (this.f260a) {
            case 1:
            case 2:
                return;
            default:
                ((w) this.b).b();
                return;
        }
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.b).rewind();
    }

    public i(InputStream inputStream, j.g gVar) {
        this.f260a = 3;
        w wVar = new w(inputStream, gVar);
        this.b = wVar;
        wVar.mark(5242880);
    }

    public i(ParcelFileDescriptor parcelFileDescriptor) {
        this.f260a = 1;
        this.b = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public i(Object obj) {
        this.f260a = 2;
        this.b = obj;
    }

    private final void c() {
    }

    private final void d() {
    }
}
