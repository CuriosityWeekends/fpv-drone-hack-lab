package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import b3.k;
import c2.l;
import c2.m;
import c2.q;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final CheckedTextView f485a;
    public final CheckedTextView b;
    public final SparseArray c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f486e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f487f;

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public final void a() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 3) {
                removeViewAt(childCount);
            } else {
                this.f485a.setEnabled(false);
                this.b.setEnabled(false);
                return;
            }
        }
    }

    public boolean getIsDisabled() {
        return this.f487f;
    }

    public List<DefaultTrackSelector$SelectionOverride> getOverrides() {
        SparseArray sparseArray = this.c;
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(sparseArray.valueAt(i3));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z3) {
        if (this.d != z3) {
            this.d = z3;
            a();
        }
    }

    public void setAllowMultipleOverrides(boolean z3) {
        if (this.f486e != z3) {
            this.f486e = z3;
            if (!z3) {
                SparseArray sparseArray = this.c;
                if (sparseArray.size() > 1) {
                    for (int size = sparseArray.size() - 1; size > 0; size--) {
                        sparseArray.remove(size);
                    }
                }
            }
            a();
        }
    }

    public void setShowDisableOption(boolean z3) {
        int i3;
        if (z3) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.f485a.setVisibility(i3);
    }

    public void setTrackNameProvider(q qVar) {
        qVar.getClass();
        a();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        setOrientation(1);
        this.c = new SparseArray();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        k kVar = new k(2, this);
        getResources().getClass();
        TrackGroupArray trackGroupArray = TrackGroupArray.d;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f485a = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(m.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(kVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(l.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.b = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(m.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(kVar);
        addView(checkedTextView2);
    }
}
