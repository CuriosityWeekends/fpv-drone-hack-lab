package tv.danmaku.ijk.media.exo2;

import a1.i;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import b2.l;
import b2.o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import e2.q;
import g2.w;
import j0.b0;
import j0.g0;
import j0.h0;
import j0.j0;
import j0.k;
import j0.m;
import j0.n;
import j0.o0;
import j0.q0;
import j0.u0;
import j1.a;
import j1.p;
import j1.t;
import j1.u;
import j1.v;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k0.d;
import k0.e;
import l0.b;
import m0.c;
import tv.danmaku.ijk.media.exo2.demo.EventLogger;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class IjkExo2MediaPlayer extends AbstractMediaPlayer implements j0, e {
    public static int ON_POSITION_DISCOUNTINUITY = 2702;
    private static final String TAG = "IjkExo2MediaPlayer";
    protected boolean isLastReportedPlayWhenReady;
    protected Context mAppContext;
    protected File mCacheDir;
    protected String mDataSource;
    protected EventLogger mEventLogger;
    protected ExoSourceManager mExoHelper;
    protected q0 mInternalPlayer;
    protected b0 mLoadControl;
    protected p mMediaSource;
    private String mOverrideExtension;
    protected m mRendererFactory;
    protected h0 mSpeedPlaybackParameters;
    protected Surface mSurface;
    protected l mTrackSelector;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected Map<String, String> mHeaders = new HashMap();
    protected boolean isPreparing = true;
    protected boolean isBuffering = false;
    protected boolean isLooping = false;
    protected boolean isPreview = false;
    protected boolean isCache = false;
    protected int audioSessionId = 0;
    protected int lastReportedPlaybackState = 1;

    public IjkExo2MediaPlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mExoHelper = ExoSourceManager.newInstance(context, this.mHeaders);
    }

    private int getVideoRendererIndex() {
        if (this.mInternalPlayer != null) {
            int i3 = 0;
            while (true) {
                q0 q0Var = this.mInternalPlayer;
                q0Var.P();
                if (i3 >= q0Var.c.c.length) {
                    break;
                } else if (this.mInternalPlayer.y(i3) == 2) {
                    return i3;
                } else {
                    i3++;
                }
            }
        }
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public int getBufferedPercentage() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return 0;
        }
        return q0Var.A();
    }

    public File getCacheDir() {
        return this.mCacheDir;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return 0L;
        }
        return q0Var.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return 0L;
        }
        return q0Var.getDuration();
    }

    public ExoSourceManager getExoHelper() {
        return this.mExoHelper;
    }

    public b0 getLoadControl() {
        return this.mLoadControl;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return null;
    }

    public p getMediaSource() {
        return this.mMediaSource;
    }

    public String getOverrideExtension() {
        return this.mOverrideExtension;
    }

    public m getRendererFactory() {
        return this.mRendererFactory;
    }

    public float getSpeed() {
        return this.mInternalPlayer.a().f2255a;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public IjkTrackInfo[] getTrackInfo() {
        return null;
    }

    public l getTrackSelector() {
        return this.mTrackSelector;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isCache() {
        return this.isCache;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.isLooping;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return false;
        }
        int playbackState = q0Var.getPlaybackState();
        if (playbackState != 2 && playbackState != 3) {
            return false;
        }
        return this.mInternalPlayer.j();
    }

    public boolean isPreview() {
        return this.isPreview;
    }

    public /* bridge */ /* synthetic */ void onAudioAttributesChanged(d dVar, b bVar) {
    }

    @Override // k0.e
    public void onAudioSessionId(d dVar, int i3) {
        this.audioSessionId = i3;
    }

    @Override // k0.e
    public void onDecoderDisabled(d dVar, int i3, c cVar) {
        this.audioSessionId = 0;
    }

    public /* bridge */ /* synthetic */ void onDrmSessionAcquired(d dVar) {
    }

    public /* bridge */ /* synthetic */ void onDrmSessionReleased(d dVar) {
    }

    @Override // k0.e
    public /* bridge */ /* synthetic */ void onIsPlayingChanged(d dVar, boolean z3) {
    }

    @Override // j0.j0
    public void onLoadingChanged(boolean z3) {
    }

    @Override // j0.j0
    public void onPlaybackParametersChanged(h0 h0Var) {
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i3) {
    }

    @Override // j0.j0
    public void onPlayerError(n nVar) {
        notifyOnError(1, 1);
    }

    @Override // j0.j0
    public void onPlayerStateChanged(boolean z3, int i3) {
        if (this.isLastReportedPlayWhenReady != z3 || this.lastReportedPlaybackState != i3) {
            if (this.isBuffering && (i3 == 3 || i3 == 4)) {
                notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, this.mInternalPlayer.A());
                this.isBuffering = false;
            }
            if (this.isPreparing && i3 == 3) {
                notifyOnPrepared();
                this.isPreparing = false;
            }
            if (i3 == 2) {
                notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_START, this.mInternalPlayer.A());
                this.isBuffering = true;
            } else if (i3 == 4) {
                notifyOnCompletion();
            }
        }
        this.isLastReportedPlayWhenReady = z3;
        this.lastReportedPlaybackState = i3;
    }

    @Override // j0.j0
    public void onPositionDiscontinuity(int i3) {
    }

    @Override // j0.j0
    public void onRepeatModeChanged(int i3) {
    }

    @Override // j0.j0
    public void onSeekProcessed() {
        notifyOnSeekComplete();
    }

    @Override // j0.j0
    public void onShuffleModeEnabledChanged(boolean z3) {
    }

    @Override // k0.e
    public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(d dVar, int i3, int i5) {
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onTimelineChanged(u0 u0Var, int i3) {
        i.a(this, u0Var, i3);
    }

    @Override // j0.j0
    public void onTracksChanged(TrackGroupArray trackGroupArray, o oVar) {
    }

    @Override // k0.e
    public void onVideoSizeChanged(d dVar, int i3, int i5, int i6, float f4) {
        int i7 = (int) (i3 * f4);
        this.mVideoWidth = i7;
        this.mVideoHeight = i5;
        notifyOnVideoSizeChanged(i7, i5, 1, 1);
        if (i6 > 0) {
            notifyOnInfo(10001, i6);
        }
    }

    @Override // k0.e
    public /* bridge */ /* synthetic */ void onVolumeChanged(d dVar, float f4) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return;
        }
        q0Var.c(false);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() {
        if (this.mInternalPlayer == null) {
            prepareAsyncInternal();
            return;
        }
        throw new IllegalStateException("can't prepare a prepared player");
    }

    public void prepareAsyncInternal() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: tv.danmaku.ijk.media.exo2.IjkExo2MediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                q qVar;
                boolean z3;
                int i3;
                IjkExo2MediaPlayer ijkExo2MediaPlayer = IjkExo2MediaPlayer.this;
                if (ijkExo2MediaPlayer.mTrackSelector == null) {
                    ijkExo2MediaPlayer.mTrackSelector = new b2.i();
                }
                IjkExo2MediaPlayer.this.mEventLogger = new EventLogger(IjkExo2MediaPlayer.this.mTrackSelector);
                IjkExo2MediaPlayer ijkExo2MediaPlayer2 = IjkExo2MediaPlayer.this;
                if (ijkExo2MediaPlayer2.mRendererFactory == null) {
                    m mVar = new m(ijkExo2MediaPlayer2.mAppContext);
                    ijkExo2MediaPlayer2.mRendererFactory = mVar;
                    mVar.b = 2;
                }
                if (ijkExo2MediaPlayer2.mLoadControl == null) {
                    ijkExo2MediaPlayer2.mLoadControl = new k();
                }
                IjkExo2MediaPlayer ijkExo2MediaPlayer3 = IjkExo2MediaPlayer.this;
                Context context = ijkExo2MediaPlayer3.mAppContext;
                m mVar2 = ijkExo2MediaPlayer3.mRendererFactory;
                l lVar = ijkExo2MediaPlayer3.mTrackSelector;
                b0 b0Var = ijkExo2MediaPlayer3.mLoadControl;
                Looper mainLooper = Looper.getMainLooper();
                k0.c cVar = new k0.c();
                Map map = q.f1716n;
                synchronized (q.class) {
                    try {
                        if (q.s == null) {
                            q.s = new e2.o(context).a();
                        }
                        qVar = q.s;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ijkExo2MediaPlayer3.mInternalPlayer = new q0(context, mVar2, lVar, b0Var, qVar, cVar, mainLooper);
                IjkExo2MediaPlayer ijkExo2MediaPlayer4 = IjkExo2MediaPlayer.this;
                ijkExo2MediaPlayer4.mInternalPlayer.b(ijkExo2MediaPlayer4);
                IjkExo2MediaPlayer ijkExo2MediaPlayer5 = IjkExo2MediaPlayer.this;
                q0 q0Var = ijkExo2MediaPlayer5.mInternalPlayer;
                q0Var.P();
                q0Var.f2292m.f2499a.add(ijkExo2MediaPlayer5);
                IjkExo2MediaPlayer ijkExo2MediaPlayer6 = IjkExo2MediaPlayer.this;
                ijkExo2MediaPlayer6.mInternalPlayer.b(ijkExo2MediaPlayer6.mEventLogger);
                IjkExo2MediaPlayer ijkExo2MediaPlayer7 = IjkExo2MediaPlayer.this;
                h0 h0Var = ijkExo2MediaPlayer7.mSpeedPlaybackParameters;
                if (h0Var != null) {
                    ijkExo2MediaPlayer7.mInternalPlayer.H(h0Var);
                }
                IjkExo2MediaPlayer ijkExo2MediaPlayer8 = IjkExo2MediaPlayer.this;
                Surface surface = ijkExo2MediaPlayer8.mSurface;
                if (surface != null) {
                    ijkExo2MediaPlayer8.mInternalPlayer.J(surface);
                }
                IjkExo2MediaPlayer ijkExo2MediaPlayer9 = IjkExo2MediaPlayer.this;
                q0 q0Var2 = ijkExo2MediaPlayer9.mInternalPlayer;
                p pVar = ijkExo2MediaPlayer9.mMediaSource;
                q0Var2.P();
                p pVar2 = q0Var2.f2301y;
                k0.c cVar2 = q0Var2.f2292m;
                if (pVar2 != null) {
                    ((a) pVar2).q(cVar2);
                    cVar2.h();
                }
                q0Var2.f2301y = pVar;
                Handler handler = q0Var2.d;
                a aVar = (a) pVar;
                u uVar = aVar.c;
                uVar.getClass();
                if (handler != null && cVar2 != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.e(z3);
                uVar.c.add(new t(handler, cVar2));
                boolean j2 = q0Var2.j();
                j0.e eVar = q0Var2.f2294o;
                if (j2) {
                    if (eVar.d != 0) {
                        eVar.a();
                    }
                    i3 = 1;
                } else {
                    eVar.getClass();
                    i3 = -1;
                }
                q0Var2.O(i3, q0Var2.j());
                j0.u uVar2 = q0Var2.c;
                g0 E = uVar2.E(true, true, true, 2);
                uVar2.f2338p = true;
                uVar2.f2337o++;
                ((Handler) uVar2.f2328f.f2351g.b).obtainMessage(0, 1, 1, aVar).sendToTarget();
                uVar2.J(E, false, 4, 1, false);
                IjkExo2MediaPlayer.this.mInternalPlayer.c(false);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        if (this.mInternalPlayer != null) {
            reset();
            this.mEventLogger = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var != null) {
            q0Var.E();
            this.mInternalPlayer = null;
        }
        ExoSourceManager exoSourceManager = this.mExoHelper;
        if (exoSourceManager != null) {
            exoSourceManager.release();
        }
        this.mSurface = null;
        this.mDataSource = null;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j2) {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return;
        }
        q0Var.h(q0Var.w(), j2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
    }

    public void setCache(boolean z3) {
        this.isCache = z3;
    }

    public void setCacheDir(File file) {
        this.mCacheDir = file;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (map != null) {
            this.mHeaders.clear();
            this.mHeaders.putAll(map);
        }
        setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            setSurface(null);
        } else {
            setSurface(surfaceHolder.getSurface());
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z3) {
    }

    public void setLoadControl(b0 b0Var) {
        this.mLoadControl = b0Var;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z3) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z3) {
        this.isLooping = z3;
    }

    public void setMediaSource(p pVar) {
        this.mMediaSource = pVar;
    }

    public void setOverrideExtension(String str) {
        this.mOverrideExtension = str;
    }

    public void setPreview(boolean z3) {
        this.isPreview = z3;
    }

    public void setRendererFactory(m mVar) {
        this.mRendererFactory = mVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z3) {
    }

    public void setSeekParameter(@Nullable o0 o0Var) {
        q0 q0Var = this.mInternalPlayer;
        q0Var.P();
        j0.u uVar = q0Var.c;
        if (o0Var == null) {
            uVar.getClass();
            o0Var = o0.d;
        }
        if (!uVar.f2340t.equals(o0Var)) {
            uVar.f2340t = o0Var;
            ((Handler) uVar.f2328f.f2351g.b).obtainMessage(5, o0Var).sendToTarget();
        }
    }

    public void setSpeed(@Size(min = 0) float f4, @Size(min = 0) float f5) {
        h0 h0Var = new h0(f4, f5, false);
        this.mSpeedPlaybackParameters = h0Var;
        q0 q0Var = this.mInternalPlayer;
        if (q0Var != null) {
            q0Var.H(h0Var);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.mSurface = surface;
        if (this.mInternalPlayer != null) {
            if (surface != null && !surface.isValid()) {
                this.mSurface = null;
            }
            this.mInternalPlayer.J(surface);
        }
    }

    public void setTrackSelector(l lVar) {
        this.mTrackSelector = lVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f4, float f5) {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var != null) {
            q0Var.P();
            int i3 = w.f1960a;
            float max = Math.max(0.0f, Math.min((f4 + f5) / 2.0f, 1.0f));
            if (q0Var.f2300x != max) {
                q0Var.f2300x = max;
                q0Var.G();
                Iterator it = q0Var.f2286g.iterator();
                while (it.hasNext()) {
                    k0.c cVar = (k0.c) it.next();
                    d g5 = cVar.g();
                    Iterator it2 = cVar.f2499a.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).onVolumeChanged(g5, max);
                    }
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return;
        }
        q0Var.c(true);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() {
        q0 q0Var = this.mInternalPlayer;
        if (q0Var == null) {
            return;
        }
        q0Var.E();
    }

    public void stopPlayback() {
        this.mInternalPlayer.N();
    }

    @Override // j0.j0
    public /* bridge */ /* synthetic */ void onIsPlayingChanged(boolean z3) {
    }

    @Override // k0.e
    public void onLoadingChanged(d dVar, boolean z3) {
    }

    @Override // k0.e
    public void onPlaybackParametersChanged(d dVar, h0 h0Var) {
    }

    @Override // k0.e
    public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(d dVar, int i3) {
    }

    @Override // k0.e
    public void onPlayerError(d dVar, n nVar) {
    }

    @Override // k0.e
    public void onPositionDiscontinuity(d dVar, int i3) {
        notifyOnInfo(ON_POSITION_DISCOUNTINUITY, i3);
    }

    @Override // k0.e
    public void onRepeatModeChanged(d dVar, int i3) {
    }

    @Override // k0.e
    public void onSeekProcessed(d dVar) {
    }

    @Override // j0.j0
    public void onTimelineChanged(u0 u0Var, Object obj, int i3) {
    }

    @Override // k0.e
    public void onTracksChanged(d dVar, TrackGroupArray trackGroupArray, o oVar) {
    }

    @Override // k0.e
    public void onTimelineChanged(d dVar, int i3) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) {
        setDataSource(this.mAppContext, Uri.parse(str));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        String uri2 = uri.toString();
        this.mDataSource = uri2;
        this.mMediaSource = this.mExoHelper.getMediaSource(uri2, this.isPreview, this.isCache, this.isLooping, this.mCacheDir, this.mOverrideExtension);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnsupportedOperationException("no support");
    }

    @Override // k0.e
    public void onPlayerStateChanged(d dVar, boolean z3, int i3) {
    }

    public void onDrmKeysLoaded(d dVar) {
    }

    public void onDrmKeysRemoved(d dVar) {
    }

    public void onDrmKeysRestored(d dVar) {
    }

    @Override // k0.e
    public void onMediaPeriodCreated(d dVar) {
    }

    @Override // k0.e
    public void onMediaPeriodReleased(d dVar) {
    }

    @Override // k0.e
    public void onReadingStarted(d dVar) {
    }

    @Override // k0.e
    public void onSeekStarted(d dVar) {
    }

    @Override // k0.e
    public void onDownstreamFormatChanged(d dVar, j1.w wVar) {
    }

    public void onDrmSessionManagerError(d dVar, Exception exc) {
    }

    @Override // k0.e
    public void onMetadata(d dVar, Metadata metadata) {
    }

    @Override // k0.e
    public void onRenderedFirstFrame(d dVar, Surface surface) {
    }

    @Override // k0.e
    public void onShuffleModeChanged(d dVar, boolean z3) {
    }

    @Override // k0.e
    public void onUpstreamDiscarded(d dVar, j1.w wVar) {
    }

    @Override // k0.e
    public void onDecoderEnabled(d dVar, int i3, c cVar) {
    }

    @Override // k0.e
    public void onDecoderInputFormatChanged(d dVar, int i3, Format format) {
    }

    @Override // k0.e
    public void onDroppedVideoFrames(d dVar, int i3, long j2) {
    }

    @Override // k0.e
    public void onLoadCanceled(d dVar, v vVar, j1.w wVar) {
    }

    @Override // k0.e
    public void onLoadCompleted(d dVar, v vVar, j1.w wVar) {
    }

    @Override // k0.e
    public void onLoadStarted(d dVar, v vVar, j1.w wVar) {
    }

    @Override // k0.e
    public void onAudioUnderrun(d dVar, int i3, long j2, long j5) {
    }

    @Override // k0.e
    public void onBandwidthEstimate(d dVar, int i3, long j2, long j5) {
    }

    @Override // k0.e
    public void onDecoderInitialized(d dVar, int i3, String str, long j2) {
    }

    @Override // k0.e
    public void onLoadError(d dVar, v vVar, j1.w wVar, IOException iOException, boolean z3) {
    }
}
