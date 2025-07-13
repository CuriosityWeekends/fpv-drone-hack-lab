package a1;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.ColorInfo;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f1a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5h;

    public a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z3, boolean z5, boolean z6) {
        boolean z7;
        str.getClass();
        this.f1a = str;
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.f4g = z3;
        boolean z8 = false;
        if (!z5 && codecCapabilities != null && w.f1960a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f2e = z7;
        if (codecCapabilities != null && w.f1960a >= 21) {
            codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        if (z6 || (codecCapabilities != null && w.f1960a >= 21 && codecCapabilities.isFeatureSupported("secure-playback"))) {
            z8 = true;
        }
        this.f3f = z8;
        this.f5h = g2.k.h(str2);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i5, double d) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(w.e(i3, widthAlignment) * widthAlignment, w.e(i5, heightAlignment) * heightAlignment);
        int i6 = point.x;
        int i7 = point.y;
        if (d != -1.0d && d > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i6, i7, Math.floor(d));
        }
        return videoCapabilities.isSizeSupported(i6, i7);
    }

    public final boolean b(Format format) {
        int i3;
        int i5;
        String b;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        String str = format.f308f;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        boolean z3 = false;
        boolean z5 = this.f5h;
        String str2 = this.b;
        if (str != null && str2 != null && (b = g2.k.b(str)) != null) {
            boolean equals = str2.equals(b);
            String str3 = format.f308f;
            if (!equals) {
                f("codec.mime " + str3 + ", " + b);
            } else {
                Pair c = o.c(format);
                if (c != null) {
                    int intValue = ((Integer) c.first).intValue();
                    int intValue2 = ((Integer) c.second).intValue();
                    if (z5 || intValue == 42) {
                        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                            codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                        }
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                            if (codecProfileLevel.profile != intValue || codecProfileLevel.level < intValue2) {
                            }
                        }
                        f("codec.profileLevel, " + str3 + ", " + b);
                    }
                }
            }
            return false;
        }
        if (z5) {
            int i6 = format.f316n;
            if (i6 <= 0 || (i5 = format.f317o) <= 0) {
                return true;
            }
            if (w.f1960a >= 21) {
                return e(i6, i5, format.f318p);
            }
            if (i6 * i5 <= o.g()) {
                z3 = true;
            }
            if (!z3) {
                f("legacyFrameSize, " + i6 + "x" + i5);
            }
            return z3;
        }
        int i7 = w.f1960a;
        if (i7 >= 21) {
            int i8 = format.w;
            if (i8 != -1) {
                if (codecCapabilities == null) {
                    f("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    f("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i8)) {
                    f("sampleRate.support, " + i8);
                    return false;
                }
            }
            int i9 = format.f322v;
            if (i9 != -1) {
                if (codecCapabilities == null) {
                    f("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    f("channelCount.aCaps");
                    return false;
                }
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && ((i7 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                    if ("audio/ac3".equals(str2)) {
                        i3 = 6;
                    } else if ("audio/eac3".equals(str2)) {
                        i3 = 16;
                    } else {
                        i3 = 30;
                    }
                    Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f1a + ", [" + maxInputChannelCount + " to " + i3 + "]");
                    maxInputChannelCount = i3;
                }
                if (maxInputChannelCount < i9) {
                    f("channelCount.support, " + i9);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean c(Format format) {
        if (this.f5h) {
            return this.f2e;
        }
        Pair c = o.c(format);
        if (c != null && ((Integer) c.first).intValue() == 42) {
            return true;
        }
        return false;
    }

    public final boolean d(Format format, Format format2, boolean z3) {
        if (this.f5h) {
            if (format.f311i.equals(format2.f311i) && format.q == format2.q && (this.f2e || (format.f316n == format2.f316n && format.f317o == format2.f317o))) {
                ColorInfo colorInfo = format2.f321u;
                if ((!z3 && colorInfo == null) || w.a(format.f321u, colorInfo)) {
                    return true;
                }
            }
            return false;
        }
        if ("audio/mp4a-latm".equals(this.b) && format.f311i.equals(format2.f311i) && format.f322v == format2.f322v && format.w == format2.w) {
            Pair c = o.c(format);
            Pair c5 = o.c(format2);
            if (c != null && c5 != null) {
                int intValue = ((Integer) c.first).intValue();
                int intValue2 = ((Integer) c5.first).intValue();
                if (intValue == 42 && intValue2 == 42) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final boolean e(int i3, int i5, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            f("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            f("sizeAndRate.vCaps");
            return false;
        } else if (!a(videoCapabilities, i3, i5, d)) {
            if (i3 < i5) {
                String str = this.f1a;
                if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(w.b)) && a(videoCapabilities, i5, i3, d)) {
                    StringBuilder n5 = i.n("sizeAndRate.rotated, ", i3, "x", i5, "x");
                    n5.append(d);
                    String sb = n5.toString();
                    Log.d("MediaCodecInfo", "AssumedSupport [" + sb + "] [" + str + ", " + this.b + "] [" + w.f1961e + "]");
                    return true;
                }
            }
            StringBuilder n6 = i.n("sizeAndRate.support, ", i3, "x", i5, "x");
            n6.append(d);
            f(n6.toString());
            return false;
        } else {
            return true;
        }
    }

    public final void f(String str) {
        StringBuilder p5 = i.p("NoSupport [", str, "] [");
        p5.append(this.f1a);
        p5.append(", ");
        p5.append(this.b);
        p5.append("] [");
        p5.append(w.f1961e);
        p5.append("]");
        Log.d("MediaCodecInfo", p5.toString());
    }

    public final String toString() {
        return this.f1a;
    }
}
