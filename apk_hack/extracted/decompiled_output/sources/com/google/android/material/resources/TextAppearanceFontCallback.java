package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class TextAppearanceFontCallback {
    public abstract void onFontRetrievalFailed(int i3);

    public abstract void onFontRetrieved(Typeface typeface, boolean z3);
}
