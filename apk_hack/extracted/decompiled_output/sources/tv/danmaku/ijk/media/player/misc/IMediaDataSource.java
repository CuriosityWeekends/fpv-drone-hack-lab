package tv.danmaku.ijk.media.player.misc;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j2, byte[] bArr, int i3, int i5);
}
