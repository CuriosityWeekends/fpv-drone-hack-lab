package com.lg.picturesubmitt;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrinityProtocolUtil {
    private static final TrinityProtocolUtil mInstance;
    private final String TAG = "ProtocolAnalysisUtil";

    static {
        System.loadLibrary("trinityprotocolparse");
        mInstance = new TrinityProtocolUtil();
    }

    private TrinityProtocolUtil() {
    }

    public static TrinityProtocolUtil getInstance() {
        return mInstance;
    }

    public native int closeUDPSocket();

    public native void initUDPSocket(String str);

    public native String parseData(byte[] bArr, int i3);

    public native void sendControlDataXL(byte[] bArr);

    public native void sendOpticalFlowDataCMD(boolean z3, byte[] bArr);

    public native void sendPIDData(byte[] bArr);
}
