package a4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.transitionseverywhere.ChangeText;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CharSequence f98a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ CharSequence c;
    public final /* synthetic */ int d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f99e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ChangeText f100f;

    public a(ChangeText changeText, CharSequence charSequence, TextView textView, CharSequence charSequence2, int i3, int i5) {
        this.f100f = changeText;
        this.f98a = charSequence;
        this.b = textView;
        this.c = charSequence2;
        this.d = i3;
        this.f99e = i5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i3;
        TextView textView = this.b;
        if (this.f98a.equals(textView.getText())) {
            textView.setText(this.c);
            if (textView instanceof EditText) {
                EditText editText = (EditText) textView;
                String[] strArr = ChangeText.f1549a;
                this.f100f.getClass();
                int i5 = this.d;
                if (i5 >= 0 && (i3 = this.f99e) >= 0) {
                    editText.setSelection(i5, i3);
                }
            }
        }
    }
}
