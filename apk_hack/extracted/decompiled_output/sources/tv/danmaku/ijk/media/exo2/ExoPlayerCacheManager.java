package tv.danmaku.ijk.media.exo2;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.Map;
import m3.a;
import m3.b;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ExoPlayerCacheManager implements b {
    protected ExoSourceManager mExoSourceManager;

    @Override // m3.b
    public boolean cachePreview(Context context, File file, String str) {
        return ExoSourceManager.cachePreView(context, file, str);
    }

    @Override // m3.b
    public void clearCache(Context context, File file, String str) {
        ExoSourceManager.clearCache(context, file, str);
    }

    @Override // m3.b
    public void doCacheLogic(Context context, IMediaPlayer iMediaPlayer, String str, Map<String, String> map, File file) {
        if (iMediaPlayer instanceof IjkExo2MediaPlayer) {
            IjkExo2MediaPlayer ijkExo2MediaPlayer = (IjkExo2MediaPlayer) iMediaPlayer;
            this.mExoSourceManager = ijkExo2MediaPlayer.getExoHelper();
            ijkExo2MediaPlayer.setCache(true);
            ijkExo2MediaPlayer.setCacheDir(file);
            ijkExo2MediaPlayer.setDataSource(context, Uri.parse(str), map);
            return;
        }
        throw new UnsupportedOperationException("ExoPlayerCacheManager only support IjkExo2MediaPlayer");
    }

    @Override // m3.b
    public boolean hadCached() {
        ExoSourceManager exoSourceManager = this.mExoSourceManager;
        if (exoSourceManager != null && exoSourceManager.hadCached()) {
            return true;
        }
        return false;
    }

    @Override // m3.b
    public void release() {
        this.mExoSourceManager = null;
    }

    @Override // m3.b
    public void setCacheAvailableListener(a aVar) {
    }
}
