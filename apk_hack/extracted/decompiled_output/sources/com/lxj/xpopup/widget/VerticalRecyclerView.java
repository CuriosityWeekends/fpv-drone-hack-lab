package com.lxj.xpopup.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.util.b;
import z2.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public void setupDivider(Boolean bool) {
        int i3;
        SmartDivider smartDivider = new SmartDivider(getContext(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        Resources resources = getResources();
        if (bool.booleanValue()) {
            i3 = a._xpopup_list_dark_divider;
        } else {
            i3 = a._xpopup_list_divider;
        }
        gradientDrawable.setColor(resources.getColor(i3));
        gradientDrawable.setSize(10, b.d(getContext(), 0.5f));
        smartDivider.setDrawable(gradientDrawable);
        addItemDecoration(smartDivider);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
