package pl.droidsonroids.gif;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends Thread implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    public final d0.h f3303a;
    public GifInfoHandle b;
    public IOException c;
    public long[] d;

    /* renamed from: e  reason: collision with root package name */
    public final WeakReference f3304e;

    /* JADX WARN: Type inference failed for: r0v1, types: [d0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [pl.droidsonroids.gif.GifInfoHandle, java.lang.Object] */
    public i(GifTextureView gifTextureView) {
        super("GifRenderThread");
        this.f3303a = new Object();
        this.b = new Object();
        this.f3304e = new WeakReference(gifTextureView);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i5) {
        GifTextureView gifTextureView = (GifTextureView) this.f3304e.get();
        if (gifTextureView != null) {
            GifInfoHandle gifInfoHandle = this.b;
            ImageView.ScaleType[] scaleTypeArr = GifTextureView.f3277g;
            gifTextureView.d(gifInfoHandle);
        }
        this.f3303a.c();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f3303a.b();
        this.b.n();
        interrupt();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i5) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [pl.droidsonroids.gif.GifInfoHandle, java.lang.Object] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            GifTextureView gifTextureView = (GifTextureView) this.f3304e.get();
            if (gifTextureView == null) {
                return;
            }
            GifInfoHandle a5 = gifTextureView.c.a();
            this.b = a5;
            a5.w(gifTextureView.isOpaque());
            int i3 = gifTextureView.f3280f.b;
            if (i3 >= 0) {
                this.b.v(i3);
            }
            GifTextureView gifTextureView2 = (GifTextureView) this.f3304e.get();
            if (gifTextureView2 != null) {
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean isAvailable = gifTextureView2.isAvailable();
                d0.h hVar = this.f3303a;
                synchronized (hVar) {
                    try {
                        if (isAvailable) {
                            hVar.c();
                        } else {
                            hVar.b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (isAvailable) {
                    gifTextureView2.post(new h(this, gifTextureView2));
                }
                this.b.x(gifTextureView2.f3279e);
                while (!isInterrupted()) {
                    try {
                        this.f3303a.a();
                        GifTextureView gifTextureView3 = (GifTextureView) this.f3304e.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.b.a(surface, this.d);
                            } finally {
                                surface.release();
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.b.o();
                this.b = new Object();
                return;
            }
            this.b.o();
        } catch (IOException e5) {
            this.c = e5;
        }
    }
}
