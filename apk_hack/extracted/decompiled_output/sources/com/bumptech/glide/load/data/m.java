package com.bumptech.glide.load.data;

import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final j.g f265a;

    public m(j.g gVar) {
        this.f265a = gVar;
    }

    @Override // com.bumptech.glide.load.data.f
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.f
    public final g b(Object obj) {
        return new i((InputStream) obj, this.f265a);
    }
}
