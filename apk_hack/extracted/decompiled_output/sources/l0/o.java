package l0;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final b3.e f2543a;
    public final long[] b;
    public AudioTrack c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f2544e;

    /* renamed from: f  reason: collision with root package name */
    public n f2545f;

    /* renamed from: g  reason: collision with root package name */
    public int f2546g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2547h;

    /* renamed from: i  reason: collision with root package name */
    public long f2548i;

    /* renamed from: j  reason: collision with root package name */
    public long f2549j;

    /* renamed from: k  reason: collision with root package name */
    public long f2550k;

    /* renamed from: l  reason: collision with root package name */
    public Method f2551l;

    /* renamed from: m  reason: collision with root package name */
    public long f2552m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2553n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2554o;

    /* renamed from: p  reason: collision with root package name */
    public long f2555p;
    public long q;

    /* renamed from: r  reason: collision with root package name */
    public long f2556r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public int f2557t;

    /* renamed from: u  reason: collision with root package name */
    public int f2558u;

    /* renamed from: v  reason: collision with root package name */
    public long f2559v;
    public long w;

    /* renamed from: x  reason: collision with root package name */
    public long f2560x;

    /* renamed from: y  reason: collision with root package name */
    public long f2561y;

    public o(b3.e eVar) {
        this.f2543a = eVar;
        if (g2.w.f1960a >= 18) {
            try {
                this.f2551l = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public final long a() {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        if (this.f2559v != -9223372036854775807L) {
            return Math.min(this.f2561y, this.f2560x + ((((SystemClock.elapsedRealtime() * 1000) - this.f2559v) * this.f2546g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f2547h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.s = this.q;
            }
            playbackHeadPosition += this.s;
        }
        if (g2.w.f1960a <= 29) {
            if (playbackHeadPosition == 0 && this.q > 0 && playState == 3) {
                if (this.w == -9223372036854775807L) {
                    this.w = SystemClock.elapsedRealtime();
                }
                return this.q;
            }
            this.w = -9223372036854775807L;
        }
        if (this.q > playbackHeadPosition) {
            this.f2556r++;
        }
        this.q = playbackHeadPosition;
        return playbackHeadPosition + (this.f2556r << 32);
    }

    public final boolean b(long j2) {
        if (j2 <= a()) {
            if (this.f2547h) {
                AudioTrack audioTrack = this.c;
                audioTrack.getClass();
                if (audioTrack.getPlayState() != 2 || a() != 0) {
                }
            }
            return false;
        }
        return true;
    }
}
