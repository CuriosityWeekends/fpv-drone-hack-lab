package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import b3.e;
import com.lg.picturesubmitt.activity.ProtocolActivity;
import x2.a;
import x2.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BorderScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public b f892a;
    public View b;

    public BorderScrollView(Context context) {
        super(context);
    }

    public int getTotalVerticalScrollRange() {
        return computeVerticalScrollRange();
    }

    @Override // android.view.View
    public final void onScrollChanged(int i3, int i5, int i6, int i7) {
        super.onScrollChanged(i3, i5, i6, i7);
        if (this.b.getMeasuredHeight() <= getHeight() + getScrollY()) {
            e eVar = (e) this.f892a;
            eVar.getClass();
            int i8 = ProtocolActivity.f809f;
            Log.d("ProtocolActivity", "onBottom");
            synchronized (ProtocolActivity.class) {
                try {
                    ProtocolActivity protocolActivity = (ProtocolActivity) eVar.b;
                    if (!protocolActivity.f810e) {
                        protocolActivity.f810e = true;
                        ProtocolActivity protocolActivity2 = (ProtocolActivity) eVar.b;
                        new a(protocolActivity2, protocolActivity2.d).execute(new Object[0]);
                    }
                } finally {
                }
            }
        }
        if (i7 != 0 && i5 == 0) {
            ((e) this.f892a).getClass();
            int i9 = ProtocolActivity.f809f;
            Log.d("ProtocolActivity", "onTop");
        }
    }

    public void setOnBorderListener(b bVar) {
        this.f892a = bVar;
        if (bVar != null && this.b == null) {
            this.b = getChildAt(0);
        }
    }

    public BorderScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BorderScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
