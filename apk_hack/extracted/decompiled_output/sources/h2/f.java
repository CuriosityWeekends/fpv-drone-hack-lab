package h2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements MediaCodec.OnFrameRenderedListener, Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1992a;
    public final /* synthetic */ g b;

    public f(g gVar, MediaCodec mediaCodec) {
        this.b = gVar;
        Handler handler = new Handler(this);
        this.f1992a = handler;
        mediaCodec.setOnFrameRenderedListener(this, handler);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i3 = message.arg1;
        int i5 = message.arg2;
        int i6 = w.f1960a;
        long j2 = ((i3 & 4294967295L) << 32) | (4294967295L & i5);
        g gVar = this.b;
        if (this == gVar.Y0) {
            if (j2 == Long.MAX_VALUE) {
                gVar.f23n0 = true;
            } else {
                Format format = (Format) gVar.s.e(j2);
                if (format != null) {
                    gVar.f31x = format;
                }
                if (format != null) {
                    gVar.h0(gVar.C, format.f316n, format.f317o);
                }
                gVar.f0();
                if (!gVar.E0) {
                    gVar.E0 = true;
                    Surface surface = gVar.B0;
                    c1.b bVar = gVar.f2000s0;
                    Handler handler = (Handler) bVar.b;
                    if (handler != null) {
                        handler.post(new d2.h(3, bVar, surface));
                    }
                }
                gVar.O(j2);
            }
        }
        return true;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j5) {
        if (w.f1960a < 30) {
            this.f1992a.sendMessageAtFrontOfQueue(Message.obtain(this.f1992a, 0, (int) (j2 >> 32), (int) j2));
            return;
        }
        g gVar = this.b;
        if (this == gVar.Y0) {
            if (j2 == Long.MAX_VALUE) {
                gVar.f23n0 = true;
                return;
            }
            Format format = (Format) gVar.s.e(j2);
            if (format != null) {
                gVar.f31x = format;
            }
            if (format != null) {
                gVar.h0(gVar.C, format.f316n, format.f317o);
            }
            gVar.f0();
            if (!gVar.E0) {
                gVar.E0 = true;
                Surface surface = gVar.B0;
                c1.b bVar = gVar.f2000s0;
                Handler handler = (Handler) bVar.b;
                if (handler != null) {
                    handler.post(new d2.h(3, bVar, surface));
                }
            }
            gVar.O(j2);
        }
    }
}
