package com.lg.picturesubmitt.rtsp;

import a1.i;
import android.util.Log;
import com.lg.picturesubmitt.MyApplication;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class JNICMD {
    private JNIHandleInterface activityJNIHandleInterface;
    private boolean isFinishThread;
    private SendUDPDataThread mSendUDPDataThread;
    private SendDataThread sendDataThread;
    private final String TAG = "JNICMD";
    private byte[] data = {102, 20, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -103};
    private boolean stopSendUdp = true;
    private JNIHandleInterface mJNIHandleInterface = new JNIHandleInterface() { // from class: com.lg.picturesubmitt.rtsp.JNICMD.1
        @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
        public void GetData(int i3, String str) {
            if (JNICMD.this.activityJNIHandleInterface != null) {
                JNICMD.this.activityJNIHandleInterface.GetData(i3, str);
            }
        }

        @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
        public void PicAndVideo(int i3, int i5, int i6) {
            if (JNICMD.this.activityJNIHandleInterface != null) {
                JNICMD.this.activityJNIHandleInterface.PicAndVideo(i3, i5, i6);
            }
        }

        @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
        public void errMsg(int i3, String str) {
            Log.d(JNICMD.this.TAG + "errMsg-type-->", i3 + "");
            if (JNICMD.this.activityJNIHandleInterface != null) {
                JNICMD.this.activityJNIHandleInterface.errMsg(i3, str);
            }
        }
    };
    private boolean sendD1 = false;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class SendDataThread extends Thread {
        public /* synthetic */ SendDataThread(JNICMD jnicmd, int i3) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d(JNICMD.this.TAG, "发送线程开启");
            while (!JNICMD.this.isFinishThread) {
                try {
                    if (!JNICMD.this.stopSendUdp) {
                        String str = JNICMD.this.TAG;
                        Log.d(str, "发送控制data.length=" + JNICMD.this.data.length);
                        JNICMD jnicmd = JNICMD.this;
                        jnicmd.sendControlData(jnicmd.data);
                        Thread.sleep((long) MyApplication.f543j);
                    }
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                    Log.d(JNICMD.this.TAG, "InterruptedException 导致退出发送线程");
                }
            }
            Log.d(JNICMD.this.TAG, "发送线程结束");
        }

        private SendDataThread() {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class SendUDPDataThread extends Thread {
        public /* synthetic */ SendUDPDataThread(JNICMD jnicmd, int i3) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!JNICMD.this.isFinishThread) {
                if (JNICMD.this.sendD1) {
                    JNICMD.this.SendD1();
                    Log.d(JNICMD.this.TAG + "UDP发送线程执行中", "UDP发送D1数据");
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
        }

        private SendUDPDataThread() {
        }
    }

    static {
        System.loadLibrary("native_socket");
    }

    public JNICMD() {
        SendDataThread sendDataThread = new SendDataThread(this, 0);
        this.sendDataThread = sendDataThread;
        sendDataThread.start();
        SendUDPDataThread sendUDPDataThread = new SendUDPDataThread(this, 0);
        this.mSendUDPDataThread = sendUDPDataThread;
        sendUDPDataThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void SendD1();

    private native void closeUDPSocket();

    private native void initUDPSocket(String str, JNIHandleInterface jNIHandleInterface);

    /* JADX INFO: Access modifiers changed from: private */
    public native void sendControlData(byte[] bArr);

    public void SetActivityJNIHandleInterface(JNIHandleInterface jNIHandleInterface) {
        this.activityJNIHandleInterface = jNIHandleInterface;
    }

    public void closeSocket() {
        this.stopSendUdp = true;
        this.isFinishThread = true;
        this.sendD1 = false;
        closeUDPSocket();
    }

    public void initUDP(String str) {
        this.sendD1 = true;
        initUDPSocket(str, this.mJNIHandleInterface);
    }

    public void setStopSendUdp(boolean z3) {
        String str = this.TAG;
        Log.d(str, "setStopSendUdp=" + z3);
        this.stopSendUdp = z3;
    }

    public void updataData(byte[] bArr) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("updataData---");
        sb.append(this.data.length);
        sb.append("---");
        i.u(sb, bArr.length, str);
        this.data = bArr;
    }
}
