package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int i3) {
        this.max = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i5, Spanned spanned, int i6, int i7) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i6, i7, charSequence.subSequence(i3, i5).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i3) {
        this.max = i3;
    }
}
