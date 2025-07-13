package androidx.dynamicanimation.animation;

import a.a;
import androidx.annotation.RequiresApi;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    /* renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class AnonymousClass1 extends FloatPropertyCompat<T> {
        final /* synthetic */ a val$property;

        public AnonymousClass1(String str, a aVar) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(T t4) {
            throw null;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(T t4, float f4) {
            throw null;
        }
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(a aVar) {
        throw null;
    }

    public abstract float getValue(T t4);

    public abstract void setValue(T t4, float f4);
}
