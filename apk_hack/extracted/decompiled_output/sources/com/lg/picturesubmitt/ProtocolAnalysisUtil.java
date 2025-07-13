package com.lg.picturesubmitt;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ProtocolAnalysisUtil {
    private static final ProtocolAnalysisUtil mInstance;
    private final String TAG = "ProtocolAnalysisUtil";

    static {
        System.loadLibrary("protocolparse");
        mInstance = new ProtocolAnalysisUtil();
    }

    private ProtocolAnalysisUtil() {
    }

    public static ProtocolAnalysisUtil getInstance() {
        return mInstance;
    }

    public native int closeUDPSocket();

    public native void initUDPSocket(String str);

    public native byte[] parseControlDataCMD(byte[] bArr);

    public native String parseData(byte[] bArr, int i3, int i5);

    public native void sendCircleData(int i3, int i5);

    public native void sendControlDataXL(byte[] bArr);

    public native void sendExchangeData(int i3, int i5);

    public native void sendFollowData(int i3, int i5);

    public native void sendOpticalFlowDataCMD(boolean z3, byte[] bArr);

    public native void sendPointDataNew(int i3, int i5, int i6, int i7);
}
