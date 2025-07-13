package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.e;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.util.b;
import e3.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PartShadowContainer extends FrameLayout {
    private a listener;
    public ArrayList<Rect> notDismissArea;
    public BasePopupView popupView;

    /* renamed from: x  reason: collision with root package name */
    private float f1127x;

    /* renamed from: y  reason: collision with root package name */
    private float f1128y;

    public PartShadowContainer(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        int i3 = iArr[0];
        if (!b.l(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(i3, iArr[1], childAt.getMeasuredWidth() + i3, childAt.getMeasuredHeight() + iArr[1]))) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 2 || action == 3) {
                    float x3 = motionEvent.getX() - this.f1127x;
                    float y3 = motionEvent.getY() - this.f1128y;
                    if (((float) Math.sqrt(Math.pow(y3, 2.0d) + Math.pow(x3, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                        ArrayList<Rect> arrayList = this.notDismissArea;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator<Rect> it = this.notDismissArea.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (b.l(motionEvent.getRawX(), motionEvent.getRawY(), it.next())) {
                                        break;
                                    }
                                } else {
                                    a aVar = this.listener;
                                    if (aVar != null) {
                                        ((e) aVar).getClass();
                                        throw null;
                                    }
                                }
                            }
                        } else {
                            a aVar2 = this.listener;
                            if (aVar2 != null) {
                                ((e) aVar2).getClass();
                                throw null;
                            }
                        }
                    }
                    this.f1127x = 0.0f;
                    this.f1128y = 0.0f;
                }
            } else {
                this.f1127x = motionEvent.getX();
                this.f1128y = motionEvent.getY();
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(a aVar) {
        this.listener = aVar;
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
