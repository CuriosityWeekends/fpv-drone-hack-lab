package androidx.transition;

import a1.i;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.view == transitionValues.view && this.values.equals(transitionValues.values)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder o5 = i.o("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        o5.append(this.view);
        o5.append("\n");
        String h5 = i.h(o5.toString(), "    values:");
        for (String str : this.values.keySet()) {
            h5 = h5 + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return h5;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
