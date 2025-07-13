package e2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class v implements h {
    private final x defaultRequestProperties = new x();

    @Deprecated
    public final void clearAllDefaultRequestProperties() {
        x xVar = this.defaultRequestProperties;
        synchronized (xVar) {
            xVar.b = null;
            xVar.f1755a.clear();
        }
    }

    @Deprecated
    public final void clearDefaultRequestProperty(String str) {
        x xVar = this.defaultRequestProperties;
        synchronized (xVar) {
            xVar.b = null;
            xVar.f1755a.remove(str);
        }
    }

    public abstract y createDataSourceInternal(x xVar);

    public final x getDefaultRequestProperties() {
        return this.defaultRequestProperties;
    }

    @Deprecated
    public final void setDefaultRequestProperty(String str, String str2) {
        this.defaultRequestProperties.b(str, str2);
    }

    @Override // e2.h
    public final y createDataSource() {
        return createDataSourceInternal(this.defaultRequestProperties);
    }
}
