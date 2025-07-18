package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int mTouchAnchorSide = 0;
    private int mTouchSide = 0;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private float mTouchAnchorY = 0.5f;
    private float mTouchAnchorX = 0.5f;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private boolean mDragStarted = false;
    private float[] mAnchorDpDt = new float[2];
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i5 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i5;
                float[] fArr = TOUCH_SIDES[i5];
                this.mTouchAnchorX = fArr[0];
                this.mTouchAnchorY = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i6 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i6;
                float[] fArr2 = TOUCH_DIRECTION[i6];
                this.mTouchDirectionX = fArr2[0];
                this.mTouchDirectionY = fArr2[1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public float dot(float f4, float f5) {
        return (f5 * this.mTouchDirectionY) + (f4 * this.mTouchDirectionX);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.mLimitBoundsTo;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public float getProgressDirection(float f4, float f5) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f6 = this.mTouchDirectionX;
        if (f6 != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f4 * f6) / fArr[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f5 * this.mTouchDirectionY) / fArr2[1];
    }

    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.mTouchRegionId;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i3, MotionScene motionScene) {
        float f4;
        float f5;
        int i5;
        float f6;
        float f7;
        float f8;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.mLastTouchY;
                    float rawX = motionEvent.getRawX() - this.mLastTouchX;
                    if (Math.abs((this.mTouchDirectionY * rawY) + (this.mTouchDirectionX * rawX)) > this.mDragThreshold || this.mDragStarted) {
                        float progress = this.mMotionLayout.getProgress();
                        if (!this.mDragStarted) {
                            this.mDragStarted = true;
                            this.mMotionLayout.setProgress(progress);
                        }
                        int i6 = this.mTouchAnchorId;
                        if (i6 != -1) {
                            this.mMotionLayout.getAnchorDpDt(i6, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                        } else {
                            float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                            float[] fArr = this.mAnchorDpDt;
                            fArr[1] = this.mTouchDirectionY * min;
                            fArr[0] = min * this.mTouchDirectionX;
                        }
                        float f9 = this.mTouchDirectionX;
                        float[] fArr2 = this.mAnchorDpDt;
                        if (Math.abs(((this.mTouchDirectionY * fArr2[1]) + (f9 * fArr2[0])) * this.mDragScale) < 0.01d) {
                            float[] fArr3 = this.mAnchorDpDt;
                            fArr3[0] = 0.01f;
                            fArr3[1] = 0.01f;
                        }
                        if (this.mTouchDirectionX != 0.0f) {
                            f7 = rawX / this.mAnchorDpDt[0];
                        } else {
                            f7 = rawY / this.mAnchorDpDt[1];
                        }
                        float max = Math.max(Math.min(progress + f7, 1.0f), 0.0f);
                        if (max != this.mMotionLayout.getProgress()) {
                            this.mMotionLayout.setProgress(max);
                            motionTracker.computeCurrentVelocity(1000);
                            float xVelocity = motionTracker.getXVelocity();
                            float yVelocity = motionTracker.getYVelocity();
                            if (this.mTouchDirectionX != 0.0f) {
                                f8 = xVelocity / this.mAnchorDpDt[0];
                            } else {
                                f8 = yVelocity / this.mAnchorDpDt[1];
                            }
                            this.mMotionLayout.mLastVelocity = f8;
                        } else {
                            this.mMotionLayout.mLastVelocity = 0.0f;
                        }
                        this.mLastTouchX = motionEvent.getRawX();
                        this.mLastTouchY = motionEvent.getRawY();
                        return;
                    }
                    return;
                }
                return;
            }
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity2 = motionTracker.getXVelocity();
            float yVelocity2 = motionTracker.getYVelocity();
            float progress2 = this.mMotionLayout.getProgress();
            int i7 = this.mTouchAnchorId;
            if (i7 != -1) {
                this.mMotionLayout.getAnchorDpDt(i7, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr4 = this.mAnchorDpDt;
                fArr4[1] = this.mTouchDirectionY * min2;
                fArr4[0] = min2 * this.mTouchDirectionX;
            }
            float f10 = this.mTouchDirectionX;
            float[] fArr5 = this.mAnchorDpDt;
            float f11 = fArr5[0];
            float f12 = fArr5[1];
            if (f10 != 0.0f) {
                f4 = xVelocity2 / f11;
            } else {
                f4 = yVelocity2 / f12;
            }
            if (!Float.isNaN(f4)) {
                f5 = (f4 / 3.0f) + progress2;
            } else {
                f5 = progress2;
            }
            if (f5 != 0.0f && f5 != 1.0f && (i5 = this.mOnTouchUp) != 3) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (f5 < 0.5d) {
                    f6 = 0.0f;
                } else {
                    f6 = 1.0f;
                }
                motionLayout.touchAnimateTo(i5, f6, f4);
                if (0.0f >= progress2 || 1.0f <= progress2) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            } else if (0.0f >= f5 || 1.0f <= f5) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                return;
            } else {
                return;
            }
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        this.mDragStarted = false;
    }

    public void scrollMove(float f4, float f5) {
        float f6;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f7 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((this.mTouchDirectionY * fArr[1]) + (f7 * fArr[0])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f8 = this.mTouchDirectionX;
        if (f8 != 0.0f) {
            f6 = (f4 * f8) / this.mAnchorDpDt[0];
        } else {
            f6 = (f5 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f6, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    public void scrollUp(float f4, float f5) {
        float f6;
        boolean z3;
        boolean z5 = false;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f7 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f8 = fArr[0];
        float f9 = this.mTouchDirectionY;
        float f10 = fArr[1];
        float f11 = 0.0f;
        if (f7 != 0.0f) {
            f6 = (f4 * f7) / f8;
        } else {
            f6 = (f5 * f9) / f10;
        }
        if (!Float.isNaN(f6)) {
            progress += f6 / 3.0f;
        }
        if (progress != 0.0f) {
            if (progress != 1.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i3 = this.mOnTouchUp;
            if (i3 != 3) {
                z5 = true;
            }
            if (z5 & z3) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (progress >= 0.5d) {
                    f11 = 1.0f;
                }
                motionLayout.touchAnimateTo(i3, f11, f6);
            }
        }
    }

    public void setAnchorId(int i3) {
        this.mTouchAnchorId = i3;
    }

    public void setDown(float f4, float f5) {
        this.mLastTouchX = f4;
        this.mLastTouchY = f5;
    }

    public void setMaxAcceleration(float f4) {
        this.mMaxAcceleration = f4;
    }

    public void setMaxVelocity(float f4) {
        this.mMaxVelocity = f4;
    }

    public void setRTL(boolean z3) {
        if (z3) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = fArr5[0];
        this.mTouchAnchorY = fArr5[1];
        float[] fArr6 = TOUCH_DIRECTION[this.mTouchSide];
        this.mTouchDirectionX = fArr6[0];
        this.mTouchDirectionY = fArr6[1];
    }

    public void setTouchAnchorLocation(float f4, float f5) {
        this.mTouchAnchorX = f4;
        this.mTouchAnchorY = f5;
    }

    public void setUpTouchEvent(float f4, float f5) {
        this.mLastTouchX = f4;
        this.mLastTouchY = f5;
        this.mDragStarted = false;
    }

    public void setupTouch() {
        View view;
        int i3 = this.mTouchAnchorId;
        if (i3 != -1) {
            view = this.mMotionLayout.findViewById(i3);
            if (view == null) {
                Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView2, int i5, int i6, int i7, int i8) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
