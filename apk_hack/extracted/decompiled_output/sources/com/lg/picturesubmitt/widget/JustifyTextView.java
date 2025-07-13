package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class JustifyTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public int f923a;
    public int b;

    public JustifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int i3;
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.b = getMeasuredWidth();
        String charSequence = getText().toString();
        int i5 = 0;
        this.f923a = 0;
        this.f923a = (int) (getTextSize() + 0);
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int spacingAdd = (int) (layout.getSpacingAdd() + (layout.getSpacingMultiplier() * ((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent))));
        int i6 = 0;
        while (i6 < layout.getLineCount()) {
            int lineStart = layout.getLineStart(i6);
            int lineEnd = layout.getLineEnd(i6);
            float desiredWidth = Layout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
            String substring = charSequence.substring(lineStart, lineEnd);
            float f4 = 0.0f;
            if (i6 < layout.getLineCount() - 1) {
                if (substring != null && substring.length() != 0 && substring.charAt(substring.length() - 1) != '\n') {
                    if (substring.length() > 3 && substring.charAt(i5) == ' ' && substring.charAt(1) == ' ') {
                        canvas.drawText("  ", 0.0f, this.f923a, getPaint());
                        f4 = 0.0f + Layout.getDesiredWidth("  ", getPaint());
                        substring = substring.substring(3);
                    }
                    int length = substring.length();
                    if (substring.length() > 2 && substring.charAt(i5) == 12288 && substring.charAt(1) == 12288) {
                        String substring2 = substring.substring(i5, 2);
                        float desiredWidth2 = Layout.getDesiredWidth(substring2, getPaint());
                        canvas.drawText(substring2, f4, this.f923a, getPaint());
                        f4 += desiredWidth2;
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    float f5 = (this.b - desiredWidth) / (length - 1);
                    while (i3 < substring.length()) {
                        String valueOf = String.valueOf(substring.charAt(i3));
                        float desiredWidth3 = Layout.getDesiredWidth(valueOf, getPaint());
                        canvas.drawText(valueOf, f4, this.f923a, getPaint());
                        f4 += desiredWidth3 + f5;
                        i3++;
                    }
                } else {
                    canvas.drawText(substring, 0.0f, this.f923a, paint);
                }
            } else {
                canvas.drawText(substring, 0.0f, this.f923a, paint);
            }
            this.f923a += spacingAdd;
            i6++;
            i5 = 0;
        }
    }
}
