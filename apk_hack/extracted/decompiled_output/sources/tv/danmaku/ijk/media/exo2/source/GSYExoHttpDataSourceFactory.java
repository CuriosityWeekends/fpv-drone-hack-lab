package tv.danmaku.ijk.media.exo2.source;

import androidx.annotation.Nullable;
import e2.m0;
import e2.v;
import e2.x;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class GSYExoHttpDataSourceFactory extends v {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    @Nullable
    private final m0 listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public GSYExoHttpDataSourceFactory(String str) {
        this(str, null);
    }

    public GSYExoHttpDataSourceFactory(String str, @Nullable m0 m0Var) {
        this(str, m0Var, 8000, 8000, false);
    }

    @Override // e2.v
    public GSYDefaultHttpDataSource createDataSourceInternal(x xVar) {
        GSYDefaultHttpDataSource gSYDefaultHttpDataSource = new GSYDefaultHttpDataSource(this.userAgent, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, xVar);
        m0 m0Var = this.listener;
        if (m0Var != null) {
            gSYDefaultHttpDataSource.addTransferListener(m0Var);
        }
        return gSYDefaultHttpDataSource;
    }

    public GSYExoHttpDataSourceFactory(String str, int i3, int i5, boolean z3) {
        this(str, null, i3, i5, z3);
    }

    public GSYExoHttpDataSourceFactory(String str, @Nullable m0 m0Var, int i3, int i5, boolean z3) {
        this.userAgent = str;
        this.listener = m0Var;
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i5;
        this.allowCrossProtocolRedirects = z3;
    }
}
