package tv.danmaku.ijk.media.player.misc;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface IMediaFormat {
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_MIME = "mime";
    public static final String KEY_WIDTH = "width";

    int getInteger(String str);

    String getString(String str);
}
