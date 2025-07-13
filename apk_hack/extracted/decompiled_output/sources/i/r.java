package i;

import android.content.Context;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final b3.e f2122a;
    public volatile k.a b;

    public r(b3.e eVar) {
        this.f2122a = eVar;
    }

    public final k.a a() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        c1.b bVar = (c1.b) this.f2122a.b;
                        File cacheDir = ((Context) bVar.b).getCacheDir();
                        k.d dVar = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else {
                            String str = (String) bVar.c;
                            if (str != null) {
                                cacheDir = new File(cacheDir, str);
                            }
                        }
                        if (cacheDir != null && (cacheDir.isDirectory() || cacheDir.mkdirs())) {
                            dVar = new k.d(cacheDir);
                        }
                        this.b = dVar;
                    }
                    if (this.b == null) {
                        this.b = new j3.b(9);
                    }
                } finally {
                }
            }
        }
        return this.b;
    }
}
