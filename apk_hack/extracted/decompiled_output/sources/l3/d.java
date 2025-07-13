package l3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;
import com.tencent.bugly.proguard.d0;
import j0.s;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnInfoListener, m3.a, GSYVideoViewBridge {

    /* renamed from: a  reason: collision with root package name */
    public Context f2712a;
    public s b;
    public Handler c;
    public WeakReference d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference f2713e;

    /* renamed from: g  reason: collision with root package name */
    public com.shuyu.gsyvideoplayer.player.c f2715g;

    /* renamed from: h  reason: collision with root package name */
    public m3.b f2716h;

    /* renamed from: k  reason: collision with root package name */
    public int f2719k;

    /* renamed from: f  reason: collision with root package name */
    public String f2714f = "";

    /* renamed from: i  reason: collision with root package name */
    public int f2717i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f2718j = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f2720l = -22;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2721m = false;

    public d() {
        new b(this, 4);
    }

    public static m3.b a() {
        if (com.bumptech.glide.e.c == null) {
            com.bumptech.glide.e.c = m3.c.class;
        }
        try {
            return (m3.b) com.bumptech.glide.e.c.newInstance();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return null;
        } catch (InstantiationException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final boolean cachePreview(Context context, File file, String str) {
        if (a() != null) {
            return a().cachePreview(context, file, str);
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void clearCache(Context context, File file, String str) {
        m3.b bVar = this.f2716h;
        if (bVar != null) {
            bVar.clearCache(context, file, str);
        } else if (a() != null) {
            a().clearCache(context, file, str);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getBufferedPercentage() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getBufferedPercentage();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final long getCurrentPosition() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getCurrentVideoHeight() {
        return this.f2718j;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getCurrentVideoWidth() {
        return this.f2717i;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final long getDuration() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getLastState() {
        return this.f2719k;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final long getNetSpeed() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getNetSpeed();
        }
        return 0L;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getPlayPosition() {
        return this.f2720l;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final String getPlayTag() {
        return this.f2714f;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final com.shuyu.gsyvideoplayer.player.c getPlayer() {
        return this.f2715g;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getRotateInfoFlag() {
        return 10001;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getVideoHeight() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getVideoSarDen() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getVideoSarDen();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getVideoSarNum() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getVideoSarNum();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final int getVideoWidth() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final boolean isCacheFile() {
        m3.b bVar = this.f2716h;
        if (bVar != null && bVar.hadCached()) {
            return true;
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final boolean isPlaying() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final boolean isSurfaceSupportLockCanvas() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            return cVar.isSurfaceSupportLockCanvas();
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final n3.a lastListener() {
        WeakReference weakReference = this.f2713e;
        if (weakReference == null) {
            return null;
        }
        return (n3.a) weakReference.get();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final n3.a listener() {
        WeakReference weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return (n3.a) weakReference.get();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
        this.c.post(new d0(this, i3, 1));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public final void onCompletion(IMediaPlayer iMediaPlayer) {
        this.c.post(new b(this, 1));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public final boolean onError(IMediaPlayer iMediaPlayer, int i3, int i5) {
        this.c.post(new c(this, i3, i5, 0));
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public final boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i5) {
        this.c.post(new c(this, i3, i5, 1));
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public final void onPrepared(IMediaPlayer iMediaPlayer) {
        this.c.post(new b(this, 0));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
        this.c.post(new b(this, 2));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i5, int i6, int i7) {
        this.f2717i = iMediaPlayer.getVideoWidth();
        this.f2718j = iMediaPlayer.getVideoHeight();
        this.c.post(new b(this, 3));
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void pause() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void prepare(String str, Map map, boolean z3, float f4, boolean z5, File file) {
        prepare(str, map, z3, f4, z5, file, null);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void releaseMediaPlayer() {
        Message message = new Message();
        message.what = 2;
        this.b.sendMessage(message);
        this.f2714f = "";
        this.f2720l = -22;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void releaseSurface(Surface surface) {
        Message message = new Message();
        message.what = 3;
        message.obj = surface;
        this.b.sendMessage(message);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void seekTo(long j2) {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.seekTo(j2);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setCurrentVideoHeight(int i3) {
        this.f2718j = i3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setCurrentVideoWidth(int i3) {
        this.f2717i = i3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setDisplay(Surface surface) {
        Message message = new Message();
        message.what = 1;
        message.obj = surface;
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.showDisplay(message);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setLastListener(n3.a aVar) {
        if (aVar == null) {
            this.f2713e = null;
        } else {
            this.f2713e = new WeakReference(aVar);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setLastState(int i3) {
        this.f2719k = i3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setListener(n3.a aVar) {
        if (aVar == null) {
            this.d = null;
        } else {
            this.d = new WeakReference(aVar);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setPlayPosition(int i3) {
        this.f2720l = i3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setPlayTag(String str) {
        this.f2714f = str;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setSpeed(float f4, boolean z3) {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.setSpeed(f4, z3);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void setSpeedPlaying(float f4, boolean z3) {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.setSpeedPlaying(f4, z3);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void start() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.start();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void stop() {
        com.shuyu.gsyvideoplayer.player.c cVar = this.f2715g;
        if (cVar != null) {
            cVar.stop();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [o3.a, java.lang.Object] */
    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge
    public final void prepare(String str, Map map, boolean z3, float f4, boolean z5, File file, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        ?? obj = new Object();
        obj.f3051a = str;
        obj.c = map;
        obj.f3052e = z3;
        obj.d = f4;
        obj.f3053f = z5;
        obj.b = file;
        obj.f3054g = str2;
        message.obj = obj;
        this.b.sendMessage(message);
    }
}
