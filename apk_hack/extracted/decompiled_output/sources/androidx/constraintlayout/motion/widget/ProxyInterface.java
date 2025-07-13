package androidx.constraintlayout.motion.widget;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
interface ProxyInterface {
    int designAccess(int i3, String str, Object obj, float[] fArr, int i5, float[] fArr2, int i6);

    float getKeyFramePosition(Object obj, int i3, float f4, float f5);

    Object getKeyframeAtLocation(Object obj, float f4, float f5);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f4, float f5, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i3, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i3, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i3, int i5, float f4, float f5);

    void setToolPosition(float f4);
}
