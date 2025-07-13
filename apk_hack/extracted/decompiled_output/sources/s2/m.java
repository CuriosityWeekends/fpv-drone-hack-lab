package s2;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.bugly.proguard.c0;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {
    public MediaMuxer b;
    public ExecutorService d;

    /* renamed from: f  reason: collision with root package name */
    public long f3536f;

    /* renamed from: h  reason: collision with root package name */
    public String f3538h;

    /* renamed from: i  reason: collision with root package name */
    public int f3539i;

    /* renamed from: j  reason: collision with root package name */
    public int f3540j;

    /* renamed from: k  reason: collision with root package name */
    public long f3541k;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodec f3534a = null;
    public int c = -1;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3535e = false;

    /* renamed from: g  reason: collision with root package name */
    public int f3537g = 1;

    public static String b(int i3) {
        MediaCodecInfo[] codecInfos;
        String[] supportedTypes;
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(-1).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    if (str.equals("video/avc")) {
                        Log.d("VideoEncodecThread", "编码器名称:" + mediaCodecInfo.getName() + "  " + str);
                        for (int i5 : mediaCodecInfo.getCapabilitiesForType("video/avc").colorFormats) {
                            if (i5 == i3) {
                                return mediaCodecInfo.getName();
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        return "";
    }

    public final void a(byte[] bArr) {
        ExecutorService executorService = this.d;
        if (executorService != null && !executorService.isShutdown()) {
            this.d.execute(new c0(8, this, bArr));
        }
    }

    public final void c(int i3, int i5, String str) {
        StringBuilder sb = new StringBuilder("startRecode outputMp4Path=");
        sb.append(str);
        sb.append(" mWidth=");
        sb.append(i3);
        sb.append(" mHeight=");
        a1.i.u(sb, i5, "VideoEncodecThread");
        ExecutorService executorService = this.d;
        if (executorService != null) {
            if (!executorService.isShutdown()) {
                this.d.shutdown();
            }
            this.d = null;
        }
        this.d = Executors.newSingleThreadExecutor();
        this.f3538h = str;
        this.f3539i = i3;
        this.f3540j = i5;
        this.f3537g = 1;
        this.f3536f = System.currentTimeMillis() * 1000;
        int i6 = this.f3539i;
        int i7 = this.f3540j;
        int i8 = 19;
        String b = b(19);
        if (TextUtils.isEmpty(b)) {
            Log.d("VideoEncodecThread", "codecName1:" + b);
            i8 = 21;
            b = b(21);
        }
        Log.d("VideoEncodecThread", "codecName2:" + b);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i6, i7);
        createVideoFormat.setInteger("color-format", i8);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 3670000);
        createVideoFormat.setInteger("frame-rate", 25);
        createVideoFormat.setInteger("i-frame-interval", 1);
        try {
            this.f3534a = MediaCodec.createByCodecName(b);
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        this.f3534a.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f3534a.start();
        try {
            this.b = new MediaMuxer(this.f3538h, 0);
            Log.d("VideoEncodecThread", "new MediaMuxer()");
        } catch (IOException e6) {
            e6.printStackTrace();
            Log.e("VideoEncodecThread", "mMediaMuxer = new MediaMuxer IOException");
        }
        this.f3535e = false;
        Log.d("VideoEncodecThread", "startRecode() isRecordingError=" + this.f3535e);
    }

    public final void d() {
        this.f3535e = true;
        try {
            MediaMuxer mediaMuxer = this.b;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.b.release();
                this.b = null;
            }
            MediaCodec mediaCodec = this.f3534a;
            if (mediaCodec != null) {
                mediaCodec.flush();
                this.f3534a.stop();
                this.f3534a.release();
                this.f3534a = null;
            }
            this.c = -1;
        } catch (IllegalStateException unused) {
            Log.e("VideoEncodecThread", "IllegalStateException--stopRecode()");
        }
        Log.d("VideoEncodecThread", "stopRecode() isRecordingError=" + this.f3535e);
        ExecutorService executorService = this.d;
        if (executorService != null && !executorService.isShutdown()) {
            this.d.shutdown();
            this.d = null;
        }
    }
}
