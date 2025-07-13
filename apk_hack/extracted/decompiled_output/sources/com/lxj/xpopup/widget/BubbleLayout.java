package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.lxj.xpopup.util.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BubbleLayout extends FrameLayout {
    public int arrowOffset;
    boolean isLookPositionCenter;
    private int mArrowDownLeftRadius;
    private int mArrowDownRightRadius;
    private int mArrowTopLeftRadius;
    private int mArrowTopRightRadius;
    private int mBottom;
    private int mBubbleBgRes;
    private int mBubbleBorderColor;
    private Paint mBubbleBorderPaint;
    private int mBubbleBorderSize;
    private int mBubbleColor;
    private Bitmap mBubbleImageBg;
    private Paint mBubbleImageBgBeforePaint;
    private RectF mBubbleImageBgDstRectF;
    private Paint mBubbleImageBgPaint;
    private Rect mBubbleImageBgSrcRect;
    private int mBubblePadding;
    private int mBubbleRadius;
    private int mHeight;
    private int mLDR;
    private int mLTR;
    private int mLeft;
    private Look mLook;
    public int mLookLength;
    public int mLookPosition;
    public int mLookWidth;
    private Paint mPaint;
    private Path mPath;
    private int mRDR;
    private int mRTR;
    private int mRight;
    private int mShadowColor;
    private int mShadowRadius;
    private int mShadowX;
    private int mShadowY;
    private int mTop;
    private int mWidth;

    /* renamed from: com.lxj.xpopup.widget.BubbleLayout$1  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look;

        static {
            int[] iArr = new int[Look.values().length];
            $SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look = iArr;
            try {
                iArr[Look.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look[Look.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look[Look.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look[Look.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public enum Look {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        int value;

        Look(int i3) {
            this.value = i3;
        }

        public static Look getType(int i3) {
            Look look = BOTTOM;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return RIGHT;
                    }
                    return look;
                }
                return TOP;
            }
            return LEFT;
        }
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    private void initAttr() {
        this.mLook = Look.BOTTOM;
        this.mLookPosition = 0;
        this.mLookWidth = b.d(getContext(), 10.0f);
        this.mLookLength = b.d(getContext(), 9.0f);
        this.mShadowX = 0;
        this.mShadowY = 0;
        this.mBubbleRadius = b.d(getContext(), 8.0f);
        this.mLTR = -1;
        this.mRTR = -1;
        this.mRDR = -1;
        this.mLDR = -1;
        this.mArrowTopLeftRadius = b.d(getContext(), 1.0f);
        this.mArrowTopRightRadius = b.d(getContext(), 1.0f);
        this.mArrowDownLeftRadius = b.d(getContext(), 1.0f);
        this.mArrowDownRightRadius = b.d(getContext(), 1.0f);
        this.mBubblePadding = b.d(getContext(), 0.0f);
        this.mShadowColor = -12303292;
        this.mBubbleColor = Color.parseColor("#3b3c3d");
        this.mBubbleBorderColor = 0;
        this.mBubbleBorderSize = 0;
    }

    private void initData() {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        initPadding();
        if (this.isLookPositionCenter) {
            Look look = this.mLook;
            if (look != Look.LEFT && look != Look.RIGHT) {
                i35 = this.mWidth / 2;
                i36 = this.mLookWidth;
            } else {
                i35 = this.mHeight / 2;
                i36 = this.mLookLength;
            }
            this.mLookPosition = i35 - (i36 / 2);
        }
        this.mLookPosition += this.arrowOffset;
        this.mPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
        this.mBubbleBorderPaint.setColor(this.mBubbleBorderColor);
        this.mBubbleBorderPaint.setStrokeWidth(this.mBubbleBorderSize);
        this.mBubbleBorderPaint.setStyle(Paint.Style.STROKE);
        int i37 = this.mShadowRadius;
        int i38 = this.mShadowX;
        int i39 = 0;
        if (i38 < 0) {
            i3 = -i38;
        } else {
            i3 = 0;
        }
        int i40 = i3 + i37;
        Look look2 = this.mLook;
        if (look2 == Look.LEFT) {
            i5 = this.mLookLength;
        } else {
            i5 = 0;
        }
        this.mLeft = i40 + i5;
        int i41 = this.mShadowY;
        if (i41 < 0) {
            i6 = -i41;
        } else {
            i6 = 0;
        }
        int i42 = i6 + i37;
        if (look2 == Look.TOP) {
            i7 = this.mLookLength;
        } else {
            i7 = 0;
        }
        this.mTop = i42 + i7;
        int i43 = this.mWidth - i37;
        if (i38 > 0) {
            i8 = -i38;
        } else {
            i8 = 0;
        }
        int i44 = i43 + i8;
        if (look2 == Look.RIGHT) {
            i9 = this.mLookLength;
        } else {
            i9 = 0;
        }
        this.mRight = i44 - i9;
        int i45 = this.mHeight - i37;
        if (i41 > 0) {
            i10 = -i41;
        } else {
            i10 = 0;
        }
        int i46 = i45 + i10;
        if (look2 == Look.BOTTOM) {
            i39 = this.mLookLength;
        }
        this.mBottom = i46 - i39;
        this.mPaint.setColor(this.mBubbleColor);
        this.mPath.reset();
        int i47 = this.mLookPosition;
        int i48 = this.mLookLength + i47;
        int i49 = this.mBottom;
        if (i48 > i49) {
            i47 = i49 - this.mLookWidth;
        }
        int max = Math.max(i47, this.mShadowRadius);
        int i50 = this.mLookPosition;
        int i51 = this.mLookLength + i50;
        int i52 = this.mRight;
        if (i51 > i52) {
            i50 = i52 - this.mLookWidth;
        }
        int max2 = Math.max(i50, this.mShadowRadius);
        int i53 = AnonymousClass1.$SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look[this.mLook.ordinal()];
        if (i53 != 1) {
            if (i53 != 2) {
                if (i53 != 3) {
                    if (i53 == 4) {
                        if (max >= getRTR() + this.mArrowDownLeftRadius) {
                            this.mPath.moveTo(this.mRight, max - i29);
                            Path path = this.mPath;
                            int i54 = this.mArrowDownLeftRadius;
                            int i55 = this.mLookLength;
                            int i56 = this.mLookWidth;
                            path.rCubicTo(0.0f, i54, i55, ((i56 / 2.0f) - this.mArrowTopLeftRadius) + i54, i55, (i56 / 2.0f) + i54);
                        } else {
                            this.mPath.moveTo(this.mRight + this.mLookLength, (this.mLookWidth / 2.0f) + max);
                        }
                        int i57 = this.mLookWidth + max;
                        int rdr = this.mBottom - getRDR();
                        int i58 = this.mArrowDownRightRadius;
                        if (i57 < rdr - i58) {
                            Path path2 = this.mPath;
                            float f4 = this.mArrowTopRightRadius;
                            int i59 = this.mLookLength;
                            int i60 = this.mLookWidth;
                            path2.rCubicTo(0.0f, f4, -i59, i60 / 2.0f, -i59, (i60 / 2.0f) + i58);
                            this.mPath.lineTo(this.mRight, this.mBottom - getRDR());
                        }
                        this.mPath.quadTo(this.mRight, this.mBottom, i30 - getRDR(), this.mBottom);
                        this.mPath.lineTo(getLDR() + this.mLeft, this.mBottom);
                        Path path3 = this.mPath;
                        int i61 = this.mLeft;
                        path3.quadTo(i61, this.mBottom, i61, i31 - getLDR());
                        this.mPath.lineTo(this.mLeft, getLTR() + this.mTop);
                        this.mPath.quadTo(this.mLeft, this.mTop, getLTR() + i32, this.mTop);
                        this.mPath.lineTo(this.mRight - getRTR(), this.mTop);
                        if (max >= getRTR() + this.mArrowDownLeftRadius) {
                            Path path4 = this.mPath;
                            int i62 = this.mRight;
                            path4.quadTo(i62, this.mTop, i62, getRTR() + i34);
                        } else {
                            this.mPath.quadTo(this.mRight, this.mTop, i33 + this.mLookLength, (this.mLookWidth / 2.0f) + max);
                        }
                    }
                } else {
                    if (max >= getLTR() + this.mArrowDownRightRadius) {
                        this.mPath.moveTo(this.mLeft, max - i23);
                        Path path5 = this.mPath;
                        int i63 = this.mArrowDownRightRadius;
                        int i64 = this.mLookLength;
                        int i65 = this.mLookWidth;
                        path5.rCubicTo(0.0f, i63, -i64, ((i65 / 2.0f) - this.mArrowTopRightRadius) + i63, -i64, (i65 / 2.0f) + i63);
                    } else {
                        this.mPath.moveTo(this.mLeft - this.mLookLength, (this.mLookWidth / 2.0f) + max);
                    }
                    int i66 = this.mLookWidth + max;
                    int ldr = this.mBottom - getLDR();
                    int i67 = this.mArrowDownLeftRadius;
                    if (i66 < ldr - i67) {
                        Path path6 = this.mPath;
                        float f5 = this.mArrowTopLeftRadius;
                        int i68 = this.mLookLength;
                        int i69 = this.mLookWidth;
                        path6.rCubicTo(0.0f, f5, i68, i69 / 2.0f, i68, (i69 / 2.0f) + i67);
                        this.mPath.lineTo(this.mLeft, this.mBottom - getLDR());
                    }
                    this.mPath.quadTo(this.mLeft, this.mBottom, getLDR() + i24, this.mBottom);
                    this.mPath.lineTo(this.mRight - getRDR(), this.mBottom);
                    Path path7 = this.mPath;
                    int i70 = this.mRight;
                    path7.quadTo(i70, this.mBottom, i70, i25 - getRDR());
                    this.mPath.lineTo(this.mRight, getRTR() + this.mTop);
                    this.mPath.quadTo(this.mRight, this.mTop, i26 - getRTR(), this.mTop);
                    this.mPath.lineTo(getLTR() + this.mLeft, this.mTop);
                    if (max >= getLTR() + this.mArrowDownRightRadius) {
                        Path path8 = this.mPath;
                        int i71 = this.mLeft;
                        path8.quadTo(i71, this.mTop, i71, getLTR() + i28);
                    } else {
                        this.mPath.quadTo(this.mLeft, this.mTop, i27 - this.mLookLength, (this.mLookWidth / 2.0f) + max);
                    }
                }
            } else {
                if (max2 >= getLTR() + this.mArrowDownLeftRadius) {
                    this.mPath.moveTo(max2 - i17, this.mTop);
                    Path path9 = this.mPath;
                    int i72 = this.mArrowDownLeftRadius;
                    int i73 = this.mLookWidth;
                    int i74 = this.mLookLength;
                    path9.rCubicTo(i72, 0.0f, ((i73 / 2.0f) - this.mArrowTopLeftRadius) + i72, -i74, (i73 / 2.0f) + i72, -i74);
                } else {
                    this.mPath.moveTo((this.mLookWidth / 2.0f) + max2, this.mTop - this.mLookLength);
                }
                int i75 = this.mLookWidth + max2;
                int rtr = this.mRight - getRTR();
                int i76 = this.mArrowDownRightRadius;
                if (i75 < rtr - i76) {
                    Path path10 = this.mPath;
                    float f6 = this.mArrowTopRightRadius;
                    int i77 = this.mLookWidth;
                    int i78 = this.mLookLength;
                    path10.rCubicTo(f6, 0.0f, i77 / 2.0f, i78, (i77 / 2.0f) + i76, i78);
                    this.mPath.lineTo(this.mRight - getRTR(), this.mTop);
                }
                Path path11 = this.mPath;
                int i79 = this.mRight;
                path11.quadTo(i79, this.mTop, i79, getRTR() + i18);
                this.mPath.lineTo(this.mRight, this.mBottom - getRDR());
                this.mPath.quadTo(this.mRight, this.mBottom, i19 - getRDR(), this.mBottom);
                this.mPath.lineTo(getLDR() + this.mLeft, this.mBottom);
                Path path12 = this.mPath;
                int i80 = this.mLeft;
                path12.quadTo(i80, this.mBottom, i80, i20 - getLDR());
                this.mPath.lineTo(this.mLeft, getLTR() + this.mTop);
                if (max2 >= getLTR() + this.mArrowDownLeftRadius) {
                    this.mPath.quadTo(this.mLeft, this.mTop, getLTR() + i22, this.mTop);
                } else {
                    this.mPath.quadTo(this.mLeft, this.mTop, (this.mLookWidth / 2.0f) + max2, i21 - this.mLookLength);
                }
            }
        } else {
            if (max2 >= getLDR() + this.mArrowDownRightRadius) {
                this.mPath.moveTo(max2 - i11, this.mBottom);
                Path path13 = this.mPath;
                int i81 = this.mArrowDownRightRadius;
                int i82 = this.mLookWidth;
                int i83 = this.mLookLength;
                path13.rCubicTo(i81, 0.0f, ((i82 / 2.0f) - this.mArrowTopRightRadius) + i81, i83, (i82 / 2.0f) + i81, i83);
            } else {
                this.mPath.moveTo((this.mLookWidth / 2.0f) + max2, this.mBottom + this.mLookLength);
            }
            int i84 = this.mLookWidth + max2;
            int rdr2 = this.mRight - getRDR();
            int i85 = this.mArrowDownLeftRadius;
            if (i84 < rdr2 - i85) {
                Path path14 = this.mPath;
                float f7 = this.mArrowTopLeftRadius;
                int i86 = this.mLookWidth;
                int i87 = this.mLookLength;
                path14.rCubicTo(f7, 0.0f, i86 / 2.0f, -i87, (i86 / 2.0f) + i85, -i87);
                this.mPath.lineTo(this.mRight - getRDR(), this.mBottom);
            }
            Path path15 = this.mPath;
            int i88 = this.mRight;
            path15.quadTo(i88, this.mBottom, i88, i12 - getRDR());
            this.mPath.lineTo(this.mRight, getRTR() + this.mTop);
            this.mPath.quadTo(this.mRight, this.mTop, i13 - getRTR(), this.mTop);
            this.mPath.lineTo(getLTR() + this.mLeft, this.mTop);
            Path path16 = this.mPath;
            int i89 = this.mLeft;
            path16.quadTo(i89, this.mTop, i89, getLTR() + i14);
            this.mPath.lineTo(this.mLeft, this.mBottom - getLDR());
            if (max2 >= getLDR() + this.mArrowDownRightRadius) {
                this.mPath.quadTo(this.mLeft, this.mBottom, getLDR() + i16, this.mBottom);
            } else {
                this.mPath.quadTo(this.mLeft, this.mBottom, (this.mLookWidth / 2.0f) + max2, i15 + this.mLookLength);
            }
        }
        this.mPath.close();
    }

    public int getArrowDownLeftRadius() {
        return this.mArrowDownLeftRadius;
    }

    public int getArrowDownRightRadius() {
        return this.mArrowDownRightRadius;
    }

    public int getArrowTopLeftRadius() {
        return this.mArrowTopLeftRadius;
    }

    public int getArrowTopRightRadius() {
        return this.mArrowTopRightRadius;
    }

    public int getBubbleColor() {
        return this.mBubbleColor;
    }

    public int getBubbleRadius() {
        return this.mBubbleRadius;
    }

    public int getLDR() {
        int i3 = this.mLDR;
        if (i3 == -1) {
            return this.mBubbleRadius;
        }
        return i3;
    }

    public int getLTR() {
        int i3 = this.mLTR;
        if (i3 == -1) {
            return this.mBubbleRadius;
        }
        return i3;
    }

    public Look getLook() {
        return this.mLook;
    }

    public int getLookLength() {
        return this.mLookLength;
    }

    public int getLookPosition() {
        return this.mLookPosition;
    }

    public int getLookWidth() {
        return this.mLookWidth;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public Path getPath() {
        return this.mPath;
    }

    public int getRDR() {
        int i3 = this.mRDR;
        if (i3 == -1) {
            return this.mBubbleRadius;
        }
        return i3;
    }

    public int getRTR() {
        int i3 = this.mRTR;
        if (i3 == -1) {
            return this.mBubbleRadius;
        }
        return i3;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public int getShadowRadius() {
        return this.mShadowRadius;
    }

    public int getShadowX() {
        return this.mShadowX;
    }

    public int getShadowY() {
        return this.mShadowY;
    }

    public void initPadding() {
        int i3 = this.mBubblePadding + this.mShadowRadius;
        int i5 = AnonymousClass1.$SwitchMap$com$lxj$xpopup$widget$BubbleLayout$Look[this.mLook.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        setPadding(i3, i3, this.mLookLength + i3 + this.mShadowX, this.mShadowY + i3);
                        return;
                    }
                    return;
                }
                setPadding(this.mLookLength + i3, i3, this.mShadowX + i3, this.mShadowY + i3);
                return;
            }
            setPadding(i3, this.mLookLength + i3, this.mShadowX + i3, this.mShadowY + i3);
            return;
        }
        setPadding(i3, i3, this.mShadowX + i3, this.mLookLength + i3 + this.mShadowY);
    }

    @Override // android.view.View
    public void invalidate() {
        initData();
        super.invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBubbleImageBg != null) {
            this.mPath.computeBounds(this.mBubbleImageBgDstRectF, true);
            int saveLayer = canvas.saveLayer(this.mBubbleImageBgDstRectF, null, 31);
            canvas.drawPath(this.mPath, this.mBubbleImageBgBeforePaint);
            float width = this.mBubbleImageBgDstRectF.width() / this.mBubbleImageBgDstRectF.height();
            if (width > (this.mBubbleImageBg.getWidth() * 1.0f) / this.mBubbleImageBg.getHeight()) {
                int height = (int) ((this.mBubbleImageBg.getHeight() - (this.mBubbleImageBg.getWidth() / width)) / 2.0f);
                this.mBubbleImageBgSrcRect.set(0, height, this.mBubbleImageBg.getWidth(), ((int) (this.mBubbleImageBg.getWidth() / width)) + height);
            } else {
                int width2 = (int) ((this.mBubbleImageBg.getWidth() - (this.mBubbleImageBg.getHeight() * width)) / 2.0f);
                this.mBubbleImageBgSrcRect.set(width2, 0, ((int) (this.mBubbleImageBg.getHeight() * width)) + width2, this.mBubbleImageBg.getHeight());
            }
            canvas.drawBitmap(this.mBubbleImageBg, this.mBubbleImageBgSrcRect, this.mBubbleImageBgDstRectF, this.mBubbleImageBgPaint);
            canvas.restoreToCount(saveLayer);
        }
        if (this.mBubbleBorderSize != 0) {
            canvas.drawPath(this.mPath, this.mBubbleBorderPaint);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mLookPosition = bundle.getInt("mLookPosition");
            this.mLookWidth = bundle.getInt("mLookWidth");
            this.mLookLength = bundle.getInt("mLookLength");
            this.mShadowColor = bundle.getInt("mShadowColor");
            this.mShadowRadius = bundle.getInt("mShadowRadius");
            this.mShadowX = bundle.getInt("mShadowX");
            this.mShadowY = bundle.getInt("mShadowY");
            this.mBubbleRadius = bundle.getInt("mBubbleRadius");
            this.mLTR = bundle.getInt("mLTR");
            this.mRTR = bundle.getInt("mRTR");
            this.mRDR = bundle.getInt("mRDR");
            this.mLDR = bundle.getInt("mLDR");
            this.mBubblePadding = bundle.getInt("mBubblePadding");
            this.mArrowTopLeftRadius = bundle.getInt("mArrowTopLeftRadius");
            this.mArrowTopRightRadius = bundle.getInt("mArrowTopRightRadius");
            this.mArrowDownLeftRadius = bundle.getInt("mArrowDownLeftRadius");
            this.mArrowDownRightRadius = bundle.getInt("mArrowDownRightRadius");
            this.mWidth = bundle.getInt("mWidth");
            this.mHeight = bundle.getInt("mHeight");
            this.mLeft = bundle.getInt("mLeft");
            this.mTop = bundle.getInt("mTop");
            this.mRight = bundle.getInt("mRight");
            this.mBottom = bundle.getInt("mBottom");
            int i3 = bundle.getInt("mBubbleBgRes");
            this.mBubbleBgRes = i3;
            if (i3 != -1) {
                this.mBubbleImageBg = BitmapFactory.decodeResource(getResources(), this.mBubbleBgRes);
            }
            this.mBubbleBorderSize = bundle.getInt("mBubbleBorderSize");
            this.mBubbleBorderColor = bundle.getInt("mBubbleBorderColor");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.mLookPosition);
        bundle.putInt("mLookWidth", this.mLookWidth);
        bundle.putInt("mLookLength", this.mLookLength);
        bundle.putInt("mShadowColor", this.mShadowColor);
        bundle.putInt("mShadowRadius", this.mShadowRadius);
        bundle.putInt("mShadowX", this.mShadowX);
        bundle.putInt("mShadowY", this.mShadowY);
        bundle.putInt("mBubbleRadius", this.mBubbleRadius);
        bundle.putInt("mLTR", this.mLTR);
        bundle.putInt("mRTR", this.mRTR);
        bundle.putInt("mRDR", this.mRDR);
        bundle.putInt("mLDR", this.mLDR);
        bundle.putInt("mBubblePadding", this.mBubblePadding);
        bundle.putInt("mArrowTopLeftRadius", this.mArrowTopLeftRadius);
        bundle.putInt("mArrowTopRightRadius", this.mArrowTopRightRadius);
        bundle.putInt("mArrowDownLeftRadius", this.mArrowDownLeftRadius);
        bundle.putInt("mArrowDownRightRadius", this.mArrowDownRightRadius);
        bundle.putInt("mWidth", this.mWidth);
        bundle.putInt("mHeight", this.mHeight);
        bundle.putInt("mLeft", this.mLeft);
        bundle.putInt("mTop", this.mTop);
        bundle.putInt("mRight", this.mRight);
        bundle.putInt("mBottom", this.mBottom);
        bundle.putInt("mBubbleBgRes", this.mBubbleBgRes);
        bundle.putInt("mBubbleBorderColor", this.mBubbleBorderColor);
        bundle.putInt("mBubbleBorderSize", this.mBubbleBorderSize);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        this.mWidth = i3;
        this.mHeight = i5;
        initData();
    }

    @Override // android.view.View
    public void postInvalidate() {
        initData();
        super.postInvalidate();
    }

    public void setArrowDownLeftRadius(int i3) {
        this.mArrowDownLeftRadius = i3;
    }

    public void setArrowDownRightRadius(int i3) {
        this.mArrowDownRightRadius = i3;
    }

    public void setArrowRadius(int i3) {
        setArrowDownLeftRadius(i3);
        setArrowDownRightRadius(i3);
        setArrowTopLeftRadius(i3);
        setArrowTopRightRadius(i3);
    }

    public void setArrowTopLeftRadius(int i3) {
        this.mArrowTopLeftRadius = i3;
    }

    public void setArrowTopRightRadius(int i3) {
        this.mArrowTopRightRadius = i3;
    }

    public void setBubbleBorderColor(int i3) {
        this.mBubbleBorderColor = i3;
    }

    public void setBubbleBorderSize(int i3) {
        this.mBubbleBorderSize = i3;
    }

    public void setBubbleColor(int i3) {
        this.mBubbleColor = i3;
    }

    public void setBubbleImageBg(Bitmap bitmap) {
        this.mBubbleImageBg = bitmap;
    }

    public void setBubbleImageBgRes(int i3) {
        this.mBubbleImageBg = BitmapFactory.decodeResource(getResources(), i3);
    }

    public void setBubblePadding(int i3) {
        this.mBubblePadding = i3;
    }

    public void setBubbleRadius(int i3) {
        this.mBubbleRadius = i3;
    }

    public void setLDR(int i3) {
        this.mLDR = i3;
    }

    public void setLTR(int i3) {
        this.mLTR = i3;
    }

    public void setLook(Look look) {
        this.mLook = look;
        initPadding();
    }

    public void setLookLength(int i3) {
        this.mLookLength = i3;
        initPadding();
    }

    public void setLookPosition(int i3) {
        this.mLookPosition = i3;
    }

    public void setLookPositionCenter(boolean z3) {
        this.isLookPositionCenter = z3;
    }

    public void setLookWidth(int i3) {
        this.mLookWidth = i3;
    }

    public void setRDR(int i3) {
        this.mRDR = i3;
    }

    public void setRTR(int i3) {
        this.mRTR = i3;
    }

    public void setShadowColor(int i3) {
        this.mShadowColor = i3;
    }

    public void setShadowRadius(int i3) {
        this.mShadowRadius = i3;
    }

    public void setShadowX(int i3) {
        this.mShadowX = i3;
    }

    public void setShadowY(int i3) {
        this.mShadowY = i3;
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mLDR = -1;
        this.mBubbleBgRes = -1;
        this.mBubbleImageBg = null;
        this.mBubbleImageBgDstRectF = new RectF();
        this.mBubbleImageBgSrcRect = new Rect();
        this.mBubbleImageBgPaint = new Paint(5);
        this.mBubbleImageBgBeforePaint = new Paint(5);
        this.mBubbleBorderColor = ViewCompat.MEASURED_STATE_MASK;
        this.mBubbleBorderSize = 0;
        this.mBubbleBorderPaint = new Paint(5);
        this.arrowOffset = 0;
        setLayerType(1, null);
        setWillNotDraw(false);
        initAttr();
        Paint paint = new Paint(5);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
        this.mBubbleImageBgPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }
}
