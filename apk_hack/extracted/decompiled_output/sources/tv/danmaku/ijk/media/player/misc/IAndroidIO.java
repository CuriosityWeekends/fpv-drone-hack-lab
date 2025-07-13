package tv.danmaku.ijk.media.player.misc;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface IAndroidIO {
    int close();

    int open(String str);

    int read(byte[] bArr, int i3);

    long seek(long j2, int i3);
}
