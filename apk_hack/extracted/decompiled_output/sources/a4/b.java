package a4;

import android.widget.EditText;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import com.transitionseverywhere.ChangeText;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends TransitionListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f101a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CharSequence f102e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f103f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f104g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChangeText f105h;

    public b(ChangeText changeText, TextView textView, CharSequence charSequence, int i3, int i5, CharSequence charSequence2, int i6, int i7) {
        this.f105h = changeText;
        this.f101a = textView;
        this.b = charSequence;
        this.c = i3;
        this.d = i5;
        this.f102e = charSequence2;
        this.f103f = i6;
        this.f104g = i7;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
        int i3;
        String[] strArr = ChangeText.f1549a;
        this.f105h.getClass();
        TextView textView = this.f101a;
        textView.setText(this.b);
        if (textView instanceof EditText) {
            EditText editText = (EditText) textView;
            int i5 = this.c;
            if (i5 >= 0 && (i3 = this.d) >= 0) {
                editText.setSelection(i5, i3);
            }
        }
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
        int i3;
        String[] strArr = ChangeText.f1549a;
        this.f105h.getClass();
        TextView textView = this.f101a;
        textView.setText(this.f102e);
        if (textView instanceof EditText) {
            EditText editText = (EditText) textView;
            int i5 = this.f103f;
            if (i5 >= 0 && (i3 = this.f104g) >= 0) {
                editText.setSelection(i5, i3);
            }
        }
    }
}
