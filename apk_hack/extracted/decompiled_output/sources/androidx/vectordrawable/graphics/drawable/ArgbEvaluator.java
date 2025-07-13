package androidx.vectordrawable.graphics.drawable;

import a1.i;
import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = new ArgbEvaluator();

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f4, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f5 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float b = i.b(((intValue2 >> 24) & 255) / 255.0f, f5, f4, f5);
        float b5 = i.b(pow4, pow, f4, pow);
        float b6 = i.b((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d), pow2, f4, pow2);
        float b7 = i.b((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d), pow3, f4, pow3);
        int round = Math.round(((float) Math.pow(b5, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow(b7, 0.45454545454545453d)) * 255.0f) | round | (Math.round(b * 255.0f) << 24) | (Math.round(((float) Math.pow(b6, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
