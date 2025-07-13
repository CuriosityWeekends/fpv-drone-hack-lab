package tv.danmaku.ijk.media.exo2;

import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.video.DummySurface;
import com.shuyu.gsyvideoplayer.player.a;
import j0.o0;
import java.util.List;
import java.util.Map;
import m3.b;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Exo2PlayerManager extends a {
    private Context context;
    private DummySurface dummySurface;
    private IjkExo2MediaPlayer mediaPlayer;
    private Surface surface;
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;

    @Override // com.shuyu.gsyvideoplayer.player.c
    public int getBufferedPercentage() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getBufferedPercentage();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public long getCurrentPosition() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public long getDuration() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public IMediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public long getNetSpeed() {
        if (this.mediaPlayer != null) {
            return getNetSpeed(this.context);
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public int getVideoHeight() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public int getVideoSarDen() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getVideoSarDen();
        }
        return 1;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public int getVideoSarNum() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getVideoSarNum();
        }
        return 1;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public int getVideoWidth() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void initVideoPlayer(Context context, Message message, List<Object> list, b bVar) {
        this.context = context.getApplicationContext();
        IjkExo2MediaPlayer ijkExo2MediaPlayer = new IjkExo2MediaPlayer(context);
        this.mediaPlayer = ijkExo2MediaPlayer;
        ijkExo2MediaPlayer.setAudioStreamType(3);
        boolean z3 = false;
        if (this.dummySurface == null) {
            this.dummySurface = DummySurface.e(context, false);
        }
        o3.a aVar = (o3.a) message.obj;
        try {
            this.mediaPlayer.setLooping(aVar.f3052e);
            IjkExo2MediaPlayer ijkExo2MediaPlayer2 = this.mediaPlayer;
            Map<String, String> map = aVar.c;
            if (map != null && map.size() > 0) {
                z3 = true;
            }
            ijkExo2MediaPlayer2.setPreview(z3);
            boolean z5 = aVar.f3053f;
            if (z5 && bVar != null) {
                bVar.doCacheLogic(context, this.mediaPlayer, aVar.f3051a, aVar.c, aVar.b);
            } else {
                this.mediaPlayer.setCache(z5);
                this.mediaPlayer.setCacheDir(aVar.b);
                this.mediaPlayer.setOverrideExtension(aVar.f3054g);
                this.mediaPlayer.setDataSource(context, Uri.parse(aVar.f3051a), map);
            }
            float f4 = aVar.d;
            if (f4 != 1.0f && f4 > 0.0f) {
                this.mediaPlayer.setSpeed(f4, 1.0f);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        initSuccess(aVar);
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public boolean isPlaying() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            return ijkExo2MediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public boolean isSurfaceSupportLockCanvas() {
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void pause() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.pause();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void release() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.setSurface(null);
            this.mediaPlayer.release();
        }
        DummySurface dummySurface = this.dummySurface;
        if (dummySurface != null) {
            dummySurface.release();
            this.dummySurface = null;
        }
        this.lastTotalRxBytes = 0L;
        this.lastTimeStamp = 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void releaseSurface() {
        if (this.surface != null) {
            this.surface = null;
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void seekTo(long j2) {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.seekTo(j2);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void setNeedMute(boolean z3) {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            if (z3) {
                ijkExo2MediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                ijkExo2MediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    public void setSeekParameter(@Nullable o0 o0Var) {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.setSeekParameter(o0Var);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void setSpeed(float f4, boolean z3) {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            try {
                ijkExo2MediaPlayer.setSpeed(f4, 1.0f);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void setSpeedPlaying(float f4, boolean z3) {
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void showDisplay(Message message) {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer == null) {
            return;
        }
        Object obj = message.obj;
        if (obj == null) {
            ijkExo2MediaPlayer.setSurface(this.dummySurface);
            return;
        }
        Surface surface = (Surface) obj;
        this.surface = surface;
        ijkExo2MediaPlayer.setSurface(surface);
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void start() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.start();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.player.c
    public void stop() {
        IjkExo2MediaPlayer ijkExo2MediaPlayer = this.mediaPlayer;
        if (ijkExo2MediaPlayer != null) {
            ijkExo2MediaPlayer.stop();
        }
    }

    private long getNetSpeed(Context context) {
        if (context == null) {
            return 0L;
        }
        long totalRxBytes = TrafficStats.getUidRxBytes(context.getApplicationInfo().uid) == -1 ? 0L : TrafficStats.getTotalRxBytes() / 1024;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.lastTimeStamp;
        if (j2 == 0) {
            return j2;
        }
        long j5 = ((totalRxBytes - this.lastTotalRxBytes) * 1000) / j2;
        this.lastTimeStamp = currentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        return j5;
    }
}
