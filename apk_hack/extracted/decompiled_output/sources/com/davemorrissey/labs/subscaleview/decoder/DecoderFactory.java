package com.davemorrissey.labs.subscaleview.decoder;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface DecoderFactory<T> {
    @NonNull
    T make();
}
