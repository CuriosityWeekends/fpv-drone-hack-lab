package tv.danmaku.ijk.media.exo2.demo;

import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import b1.e;
import b2.d;
import b2.k;
import b2.l;
import b2.n;
import b2.o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import h2.s;
import j0.h0;
import j0.j0;
import j0.s0;
import j0.t0;
import j0.u0;
import j1.v;
import j1.w;
import j1.x;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import l0.i;
import m0.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class EventLogger implements j0, e, i, s, x {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private final l trackSelector;
    private final t0 window = new t0();
    private final s0 period = new s0();
    private final long startTimeMs = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(l lVar) {
        this.trackSelector = lVar;
    }

    private static String getAdaptiveSupportString(int i3, int i5) {
        if (i3 < 2) {
            return "N/A";
        }
        if (i5 != 0) {
            if (i5 != 8) {
                if (i5 != 16) {
                    return "?";
                }
                return "YES";
            }
            return "YES_NOT_SEAMLESS";
        }
        return "NO";
    }

    private static String getDiscontinuityReasonString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        return "?";
                    }
                    return "INTERNAL";
                }
                return "SEEK_ADJUSTMENT";
            }
            return "SEEK";
        }
        return "PERIOD_TRANSITION";
    }

    private static String getFormatSupportString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "?";
                        }
                        return "YES";
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    private static String getRepeatModeString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "?";
                }
                return "ALL";
            }
            return "ONE";
        }
        return "OFF";
    }

    private String getSessionTimeString() {
        return getTimeString(SystemClock.elapsedRealtime() - this.startTimeMs);
    }

    private static String getStateString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "?";
                    }
                    return ExifInterface.LONGITUDE_EAST;
                }
                return "R";
            }
            return "B";
        }
        return "I";
    }

    private static String getTimeString(long j2) {
        if (j2 == -9223372036854775807L) {
            return "?";
        }
        return TIME_FORMAT.format(((float) j2) / 1000.0f);
    }

    private static String getTrackStatusString(n nVar, TrackGroup trackGroup, int i3) {
        boolean z3;
        if (nVar != null) {
            d dVar = (d) nVar;
            if (dVar.f139a == trackGroup && dVar.i(i3) != -1) {
                z3 = true;
                return getTrackStatusString(z3);
            }
        }
        z3 = false;
        return getTrackStatusString(z3);
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        int i3 = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f330a;
            if (i3 < entryArr.length) {
                Metadata.Entry entry = entryArr[i3];
                if (entry instanceof TextInformationFrame) {
                    TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                    StringBuilder l5 = a1.i.l(str);
                    StringBuilder o5 = a1.i.o(textInformationFrame.f362a, ": value=");
                    o5.append(textInformationFrame.c);
                    l5.append(o5.toString());
                    Log.d(TAG, l5.toString());
                } else if (entry instanceof UrlLinkFrame) {
                    UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                    StringBuilder l6 = a1.i.l(str);
                    StringBuilder o6 = a1.i.o(urlLinkFrame.f362a, ": url=");
                    o6.append(urlLinkFrame.c);
                    l6.append(o6.toString());
                    Log.d(TAG, l6.toString());
                } else if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    StringBuilder l7 = a1.i.l(str);
                    StringBuilder o7 = a1.i.o(privFrame.f362a, ": owner=");
                    o7.append(privFrame.b);
                    l7.append(o7.toString());
                    Log.d(TAG, l7.toString());
                } else if (entry instanceof GeobFrame) {
                    GeobFrame geobFrame = (GeobFrame) entry;
                    StringBuilder l8 = a1.i.l(str);
                    StringBuilder o8 = a1.i.o(geobFrame.f362a, ": mimeType=");
                    o8.append(geobFrame.b);
                    o8.append(", filename=");
                    o8.append(geobFrame.c);
                    o8.append(", description=");
                    o8.append(geobFrame.d);
                    l8.append(o8.toString());
                    Log.d(TAG, l8.toString());
                } else if (entry instanceof ApicFrame) {
                    ApicFrame apicFrame = (ApicFrame) entry;
                    StringBuilder l9 = a1.i.l(str);
                    StringBuilder o9 = a1.i.o(apicFrame.f362a, ": mimeType=");
                    o9.append(apicFrame.b);
                    o9.append(", description=");
                    o9.append(apicFrame.c);
                    l9.append(o9.toString());
                    Log.d(TAG, l9.toString());
                } else if (entry instanceof CommentFrame) {
                    CommentFrame commentFrame = (CommentFrame) entry;
                    StringBuilder l10 = a1.i.l(str);
                    StringBuilder o10 = a1.i.o(commentFrame.f362a, ": language=");
                    o10.append(commentFrame.b);
                    o10.append(", description=");
                    o10.append(commentFrame.c);
                    l10.append(o10.toString());
                    Log.d(TAG, l10.toString());
                } else if (entry instanceof Id3Frame) {
                    StringBuilder l11 = a1.i.l(str);
                    String str2 = ((Id3Frame) entry).f362a;
                    l11.append(str2);
                    Log.d(TAG, l11.toString());
                } else if (entry instanceof EventMessage) {
                    EventMessage eventMessage = (EventMessage) entry;
                    StringBuilder l12 = a1.i.l(str);
                    l12.append(String.format("EMSG: scheme=%s, id=%d, value=%s", eventMessage.f342a, Long.valueOf(eventMessage.d), eventMessage.b));
                    Log.d(TAG, l12.toString());
                }
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // l0.i
    public void onAudioDecoderInitialized(String str, long j2, long j5) {
        Log.d(TAG, "audioDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    @Override // l0.i
    public void onAudioDisabled(c cVar) {
        Log.d(TAG, "audioDisabled [" + getSessionTimeString() + "]");
    }

    @Override // l0.i
    public void onAudioEnabled(c cVar) {
        Log.d(TAG, "audioEnabled [" + getSessionTimeString() + "]");
    }

    @Override // l0.i
    public void onAudioInputFormatChanged(Format format) {
        Log.d(TAG, "audioFormatChanged [" + getSessionTimeString() + ", " + Format.u(format) + "]");
    }

    @Override // l0.i
    public void onAudioSessionId(int i3) {
        Log.d(TAG, "audioSessionId [" + i3 + "]");
    }

    @Override // l0.i
    public void onAudioSinkUnderrun(int i3, long j2, long j5) {
        printInternalError("audioTrackUnderrun [" + i3 + ", " + j2 + ", " + j5 + "]", null);
    }

    public void onDrmKeysLoaded() {
        Log.d(TAG, "drmKeysLoaded [" + getSessionTimeString() + "]");
    }

    public void onDrmKeysRemoved() {
        Log.d(TAG, "drmKeysRemoved [" + getSessionTimeString() + "]");
    }

    public void onDrmKeysRestored() {
        Log.d(TAG, "drmKeysRestored [" + getSessionTimeString() + "]");
    }

    public /* bridge */ /* synthetic */ void onDrmSessionAcquired() {
    }

    public void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    public /* bridge */ /* synthetic */ void onDrmSessionReleased() {
    }

    @Override // h2.s
    public void onDroppedFrames(int i3, long j2) {
        Log.d(TAG, "droppedFrames [" + getSessionTimeString() + ", " + i3 + "]");
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onIsPlayingChanged(boolean z3) {
    }

    @Override // j1.x
    public void onLoadError(int i3, @Nullable j1.n nVar, v vVar, w wVar, IOException iOException, boolean z3) {
        printInternalError("loadError", iOException);
    }

    @Override // j0.j0
    public void onLoadingChanged(boolean z3) {
        Log.d(TAG, "loading [" + z3 + "]");
    }

    @Override // b1.e
    public void onMetadata(Metadata metadata) {
        Log.d(TAG, "onMetadata [");
        printMetadata(metadata, "  ");
        Log.d(TAG, "]");
    }

    @Override // j0.j0
    public void onPlaybackParametersChanged(h0 h0Var) {
        Log.d(TAG, "playbackParameters ".concat(String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(h0Var.f2255a), Float.valueOf(h0Var.b))));
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i3) {
    }

    @Override // j0.j0
    public void onPlayerError(j0.n nVar) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", nVar);
    }

    @Override // j0.j0
    public void onPlayerStateChanged(boolean z3, int i3) {
        Log.d(TAG, "state [" + getSessionTimeString() + ", " + z3 + ", " + getStateString(i3) + "]");
    }

    @Override // j0.j0
    public void onPositionDiscontinuity(int i3) {
        Log.d(TAG, "positionDiscontinuity [" + getDiscontinuityReasonString(i3) + "]");
    }

    @Override // h2.s
    public void onRenderedFirstFrame(Surface surface) {
        Log.d(TAG, "renderedFirstFrame [" + surface + "]");
    }

    @Override // j0.j0
    public void onRepeatModeChanged(int i3) {
        Log.d(TAG, "repeatMode [" + getRepeatModeString(i3) + "]");
    }

    @Override // j0.j0
    public void onSeekProcessed() {
        Log.d(TAG, "seekProcessed");
    }

    @Override // j0.j0
    public void onShuffleModeEnabledChanged(boolean z3) {
        Log.d(TAG, "shuffleModeEnabled [" + z3 + "]");
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onTimelineChanged(u0 u0Var, int i3) {
        a1.i.a(this, u0Var, i3);
    }

    @Override // j0.j0
    public void onTracksChanged(TrackGroupArray trackGroupArray, o oVar) {
        EventLogger eventLogger;
        String str;
        int[][][] iArr;
        EventLogger eventLogger2 = this;
        k kVar = eventLogger2.trackSelector.b;
        if (kVar == null) {
            Log.d(TAG, "Tracks []");
            return;
        }
        Log.d(TAG, "Tracks [");
        int i3 = 0;
        while (true) {
            String str2 = ", supported=";
            String str3 = ", ";
            String str4 = " Track:";
            String str5 = "    ]";
            String str6 = "      ";
            if (i3 >= kVar.f160a) {
                break;
            }
            TrackGroupArray[] trackGroupArrayArr = kVar.d;
            TrackGroupArray trackGroupArray2 = trackGroupArrayArr[i3];
            n nVar = oVar.b[i3];
            if (trackGroupArray2.f385a > 0) {
                Log.d(TAG, "  Renderer:" + i3 + " [");
                int i5 = 0;
                while (i5 < trackGroupArray2.f385a) {
                    TrackGroup trackGroup = trackGroupArray2.b[i5];
                    TrackGroupArray trackGroupArray3 = trackGroupArray2;
                    int i6 = trackGroup.f384a;
                    int i7 = trackGroupArrayArr[i3].b[i5].f384a;
                    String str7 = str5;
                    int[] iArr2 = new int[i7];
                    String str8 = str2;
                    String str9 = str3;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        str = str4;
                        iArr = kVar.f162f;
                        if (i8 >= i7) {
                            break;
                        }
                        int i10 = i7;
                        if ((iArr[i3][i5][i8] & 7) == 4) {
                            iArr2[i9] = i8;
                            i9++;
                        }
                        i8++;
                        str4 = str;
                        i7 = i10;
                    }
                    int[] copyOf = Arrays.copyOf(iArr2, i9);
                    int i11 = 16;
                    String str10 = null;
                    String str11 = str6;
                    int i12 = 0;
                    boolean z3 = false;
                    int i13 = 0;
                    while (i12 < copyOf.length) {
                        int[] iArr3 = copyOf;
                        String str12 = trackGroupArrayArr[i3].b[i5].b[copyOf[i12]].f311i;
                        int i14 = i13 + 1;
                        if (i13 == 0) {
                            str10 = str12;
                        } else {
                            z3 |= !g2.w.a(str10, str12);
                        }
                        i11 = Math.min(i11, iArr[i3][i5][i12] & 24);
                        i12++;
                        i13 = i14;
                        copyOf = iArr3;
                    }
                    if (z3) {
                        i11 = Math.min(i11, kVar.f161e[i3]);
                    }
                    String adaptiveSupportString = getAdaptiveSupportString(i6, i11);
                    Log.d(TAG, "    Group:" + i5 + ", adaptive_supported=" + adaptiveSupportString + " [");
                    int i15 = 0;
                    while (i15 < trackGroup.f384a) {
                        String trackStatusString = getTrackStatusString(nVar, trackGroup, i15);
                        String formatSupportString = getFormatSupportString(iArr[i3][i5][i15] & 7);
                        String str13 = str11;
                        StringBuilder sb = new StringBuilder(str13);
                        sb.append(trackStatusString);
                        String str14 = str;
                        sb.append(str14);
                        sb.append(i15);
                        String str15 = str9;
                        sb.append(str15);
                        sb.append(Format.u(trackGroup.b[i15]));
                        sb.append(str8);
                        sb.append(formatSupportString);
                        Log.d(TAG, sb.toString());
                        i15++;
                        str = str14;
                        str11 = str13;
                        trackGroupArrayArr = trackGroupArrayArr;
                        str9 = str15;
                    }
                    str6 = str11;
                    Log.d(TAG, str7);
                    i5++;
                    str5 = str7;
                    str4 = str;
                    str3 = str9;
                    trackGroupArray2 = trackGroupArray3;
                    str2 = str8;
                    trackGroupArrayArr = trackGroupArrayArr;
                }
                String str16 = str5;
                if (nVar != null) {
                    int i16 = 0;
                    while (true) {
                        d dVar = (d) nVar;
                        if (i16 >= dVar.c.length) {
                            break;
                        }
                        Metadata metadata = dVar.d[i16].f309g;
                        if (metadata != null) {
                            Log.d(TAG, "    Metadata [");
                            eventLogger = this;
                            eventLogger.printMetadata(metadata, str6);
                            Log.d(TAG, str16);
                            break;
                        }
                        i16++;
                    }
                    Log.d(TAG, "  ]");
                }
                eventLogger = this;
                Log.d(TAG, "  ]");
            } else {
                eventLogger = eventLogger2;
            }
            i3++;
            eventLogger2 = eventLogger;
        }
        TrackGroupArray trackGroupArray4 = kVar.f163g;
        if (trackGroupArray4.f385a > 0) {
            Log.d(TAG, "  Renderer:None [");
            for (int i17 = 0; i17 < trackGroupArray4.f385a; i17++) {
                Log.d(TAG, "    Group:" + i17 + " [");
                TrackGroup trackGroup2 = trackGroupArray4.b[i17];
                int i18 = 0;
                while (i18 < trackGroup2.f384a) {
                    String trackStatusString2 = getTrackStatusString(false);
                    TrackGroupArray trackGroupArray5 = trackGroupArray4;
                    String formatSupportString2 = getFormatSupportString(0);
                    Log.d(TAG, "      " + trackStatusString2 + " Track:" + i18 + ", " + Format.u(trackGroup2.b[i18]) + ", supported=" + formatSupportString2);
                    i18++;
                    trackGroupArray4 = trackGroupArray5;
                }
                Log.d(TAG, "    ]");
            }
            Log.d(TAG, "  ]");
        }
        Log.d(TAG, "]");
    }

    @Override // h2.s
    public void onVideoDecoderInitialized(String str, long j2, long j5) {
        Log.d(TAG, "videoDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    @Override // h2.s
    public void onVideoDisabled(c cVar) {
        Log.d(TAG, "videoDisabled [" + getSessionTimeString() + "]");
    }

    @Override // h2.s
    public void onVideoEnabled(c cVar) {
        Log.d(TAG, "videoEnabled [" + getSessionTimeString() + "]");
    }

    @Override // h2.s
    public void onVideoInputFormatChanged(Format format) {
        Log.d(TAG, "videoFormatChanged [" + getSessionTimeString() + ", " + Format.u(format) + "]");
    }

    @Override // h2.s
    public void onVideoSizeChanged(int i3, int i5, int i6, float f4) {
        Log.d(TAG, "videoSizeChanged [" + i3 + ", " + i5 + "]");
    }

    @Override // j0.j0
    public void onTimelineChanged(u0 u0Var, Object obj, int i3) {
        int h5 = u0Var.h();
        int n5 = u0Var.n();
        a1.i.s("sourceInfo [periodCount=", h5, ", windowCount=", n5, TAG);
        for (int i5 = 0; i5 < Math.min(h5, 3); i5++) {
            u0Var.f(i5, this.period, false);
            Log.d(TAG, "  period [" + getTimeString(j0.i.b(this.period.d)) + "]");
        }
        if (h5 > 3) {
            Log.d(TAG, "  ...");
        }
        for (int i6 = 0; i6 < Math.min(n5, 3); i6++) {
            u0Var.m(i6, this.window, 0L);
            Log.d(TAG, "  window [" + getTimeString(j0.i.b(this.window.f2325i)) + ", " + this.window.d + ", " + this.window.f2321e + "]");
        }
        if (n5 > 3) {
            Log.d(TAG, "  ...");
        }
        Log.d(TAG, "]");
    }

    private static String getTrackStatusString(boolean z3) {
        return z3 ? "[X]" : "[ ]";
    }

    @Override // j1.x
    public void onMediaPeriodCreated(int i3, j1.n nVar) {
    }

    @Override // j1.x
    public void onMediaPeriodReleased(int i3, j1.n nVar) {
    }

    @Override // j1.x
    public void onReadingStarted(int i3, j1.n nVar) {
    }

    @Override // j1.x
    public void onDownstreamFormatChanged(int i3, @Nullable j1.n nVar, w wVar) {
    }

    @Override // j1.x
    public void onUpstreamDiscarded(int i3, j1.n nVar, w wVar) {
    }

    @Override // j1.x
    public void onLoadCanceled(int i3, @Nullable j1.n nVar, v vVar, w wVar) {
    }

    @Override // j1.x
    public void onLoadCompleted(int i3, @Nullable j1.n nVar, v vVar, w wVar) {
    }

    @Override // j1.x
    public void onLoadStarted(int i3, @Nullable j1.n nVar, v vVar, w wVar) {
    }
}
