package com.rockcarry.fanplayer;

import a1.i;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MediaPlayer {
    public static final int AV_read_frame_ended = 1096172612;
    public static final int AV_read_frame_go_end = 1096172868;
    public static final int Interrupt_callback = 1111573323;
    public static final int MSG_OPEN_DONE = 1330660686;
    public static final int MSG_OPEN_FAILED = 1178683724;
    public static final int MSG_PLAY_COMPLETED = 1162757152;
    public static final int MSG_PLAY_PROGRESS = 1381322272;
    public static final int MSG_STREAM_CONNECTED = 1129202516;
    public static final int MSG_STREAM_DISCONNECT = 1145656131;
    public static final int MSG_STREAM_TRY_CONNECTED = 1414682912;
    public static final int MSG_TAKE_SNAPSHOT = 1397637456;
    public static final int MSG_VIDEO_RESIZED = 1397316165;
    public static final int PARAM_AUDIO_VOLUME = 4101;
    public static final int PARAM_AVSYNC_TIME_DIFF = 4104;
    public static final int PARAM_MEDIA_DURATION = 4096;
    public static final int PARAM_MEDIA_POSITION = 4097;
    public static final int PARAM_PLAY_SPEED = 4102;
    public static final int PARAM_VIDEO_HEIGHT = 4099;
    public static final int PARAM_VIDEO_WIDTH = 4098;
    public static final int Thread_end = 1414025797;
    public static final int av_demux_thread_ended = 1162102084;
    public static final int av_demux_thread_go_end = 1196705092;
    public static final int open_input_ended = 1229866052;
    public static final int open_input_go_end = 1229866308;
    public Callback Interface;
    private Handler mPlayerMsgHandler;
    private long m_hPlayer;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Callback {
        void onAudioData(byte[] bArr, int i3, int i5);

        void onAudioInit(int i3, int i5);

        void onDecMediacodec(byte[] bArr, int i3, long j2);

        void onMediacodecInit(int i3, int i5, int i6, byte[] bArr, byte[] bArr2);

        void onWxSdkStreamCbk(byte[] bArr, int i3, boolean z3, int i5, int i6);
    }

    static {
        System.loadLibrary("fanplayer_jni");
    }

    public MediaPlayer() {
        this.mPlayerMsgHandler = null;
        this.Interface = null;
        this.m_hPlayer = 0L;
    }

    private void dataAudioInitCallback(int i3, int i5) {
        this.Interface.onAudioInit(i3, i5);
    }

    private void dataDecMediacodecCallback(byte[] bArr, int i3, long j2) {
        this.Interface.onDecMediacodec(bArr, i3, j2);
    }

    private void dataEventCallback(byte[] bArr, int i3, boolean z3, int i5, int i6) {
        Log.d("dataEventCallback", bArr.length + "");
        this.Interface.onWxSdkStreamCbk(bArr, i3, z3, i5, i6);
    }

    private void dataMediacodecInitCallback(int i3, int i5, int i6, byte[] bArr, byte[] bArr2) {
        this.Interface.onMediacodecInit(i3, i5, i6, bArr, bArr2);
    }

    private void dataonAudioDataCallback(byte[] bArr, int i3, int i5) {
        this.Interface.onAudioData(bArr, i3, i5);
    }

    private void internalPlayerEventCallback(int i3, long j2) {
        if (this.mPlayerMsgHandler != null) {
            Message message = new Message();
            message.what = i3;
            message.obj = new Long(j2);
            this.mPlayerMsgHandler.sendMessage(message);
        }
    }

    private void internalStringPlayerEventCallback(int i3, String str) {
        if (this.mPlayerMsgHandler != null) {
            Message message = new Message();
            message.what = i3;
            message.obj = str;
            this.mPlayerMsgHandler.sendMessage(message);
        }
    }

    private native int nativeClose(long j2);

    private native long nativeOpen(String str, Object obj, int i3, int i5, String str2);

    private native void nativePause(long j2);

    private native void nativePlay(long j2);

    private native void nativeSetDisplaySurface(long j2, Object obj);

    public void close() {
        nativeClose(this.m_hPlayer);
        this.m_hPlayer = 0L;
    }

    public void finalize() {
        close();
    }

    public boolean open(String str, String str2) {
        int nativeClose = nativeClose(this.m_hPlayer);
        if (this.mPlayerMsgHandler != null) {
            Message message = new Message();
            message.what = 555;
            message.obj = i.e(nativeClose, "close result=");
            this.mPlayerMsgHandler.sendMessage(message);
        }
        long nativeOpen = nativeOpen(str, null, 0, 0, str2);
        this.m_hPlayer = nativeOpen;
        if (nativeOpen != 0) {
            return true;
        }
        return false;
    }

    public void pause() {
        nativePause(this.m_hPlayer);
    }

    public void play() {
        nativePlay(this.m_hPlayer);
    }

    public void setDisplaySurface(Surface surface) {
        nativeSetDisplaySurface(this.m_hPlayer, surface);
    }

    public void setDisplayTexture(SurfaceTexture surfaceTexture) {
        nativeSetDisplaySurface(this.m_hPlayer, new Surface(surfaceTexture));
    }

    public void setPlayerMsgHandler(Handler handler) {
        this.mPlayerMsgHandler = handler;
    }

    public MediaPlayer(String str, Handler handler, String str2, Callback callback) {
        this.m_hPlayer = 0L;
        this.Interface = callback;
        this.mPlayerMsgHandler = handler;
        open(str, str2);
    }
}
