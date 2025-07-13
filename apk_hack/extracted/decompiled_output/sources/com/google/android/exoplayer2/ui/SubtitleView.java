package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c2.o;
import g2.w;
import java.util.ArrayList;
import java.util.List;
import s1.a;
import s1.b;
import s1.j;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class SubtitleView extends View implements j {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f480a;
    public List b;
    public int c;
    public float d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f481e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f482f;

    /* renamed from: g  reason: collision with root package name */
    public a f483g;

    /* renamed from: h  reason: collision with root package name */
    public float f484h;

    public SubtitleView(Context context) {
        this(context, null);
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private a getUserCaptionStyleV19() {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        CaptioningManager.CaptionStyle userStyle = ((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle();
        if (w.f1960a >= 21) {
            if (userStyle.hasForegroundColor()) {
                i3 = userStyle.foregroundColor;
            } else {
                i3 = -1;
            }
            if (userStyle.hasBackgroundColor()) {
                i5 = userStyle.backgroundColor;
            } else {
                i5 = ViewCompat.MEASURED_STATE_MASK;
            }
            if (userStyle.hasWindowColor()) {
                i6 = userStyle.windowColor;
            } else {
                i6 = 0;
            }
            if (userStyle.hasEdgeType()) {
                i7 = userStyle.edgeType;
            } else {
                i7 = 0;
            }
            if (userStyle.hasEdgeColor()) {
                i8 = userStyle.edgeColor;
            } else {
                i8 = -1;
            }
            return new a(i3, i5, i6, i7, i8, userStyle.getTypeface());
        }
        return new a(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    public final void a() {
        a aVar;
        if (w.f1960a >= 19 && ((CaptioningManager) getContext().getSystemService("captioning")).isEnabled() && !isInEditMode()) {
            aVar = getUserCaptionStyleV19();
        } else {
            aVar = a.f3476g;
        }
        setStyle(aVar);
    }

    public final void b() {
        float f4;
        if (w.f1960a >= 19 && !isInEditMode()) {
            f4 = getUserCaptionFontScaleV19();
        } else {
            f4 = 1.0f;
        }
        setFractionalTextSize(f4 * 0.0533f);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r39) {
        /*
            Method dump skipped, instructions count: 1263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitleView.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // s1.j
    public final void onCues(List list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z3) {
        if (this.f482f == z3) {
            return;
        }
        this.f482f = z3;
        invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z3) {
        if (this.f481e == z3 && this.f482f == z3) {
            return;
        }
        this.f481e = z3;
        this.f482f = z3;
        invalidate();
    }

    public void setBottomPaddingFraction(float f4) {
        if (this.f484h == f4) {
            return;
        }
        this.f484h = f4;
        invalidate();
    }

    public void setCues(@Nullable List<b> list) {
        int size;
        if (this.b == list) {
            return;
        }
        this.b = list;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        while (true) {
            ArrayList arrayList = this.f480a;
            if (arrayList.size() < size) {
                arrayList.add(new o(getContext()));
            } else {
                invalidate();
                return;
            }
        }
    }

    public void setFractionalTextSize(float f4) {
        if (this.c != 0 || this.d != f4) {
            this.c = 0;
            this.d = f4;
            invalidate();
        }
    }

    public void setStyle(a aVar) {
        if (this.f483g == aVar) {
            return;
        }
        this.f483g = aVar;
        invalidate();
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f480a = new ArrayList();
        this.c = 0;
        this.d = 0.0533f;
        this.f481e = true;
        this.f482f = true;
        this.f483g = a.f3476g;
        this.f484h = 0.08f;
    }
}
