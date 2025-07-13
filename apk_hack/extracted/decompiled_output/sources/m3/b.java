package m3;

import android.content.Context;
import java.io.File;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface b {
    boolean cachePreview(Context context, File file, String str);

    void clearCache(Context context, File file, String str);

    void doCacheLogic(Context context, IMediaPlayer iMediaPlayer, String str, Map map, File file);

    boolean hadCached();

    void release();

    void setCacheAvailableListener(a aVar);
}
