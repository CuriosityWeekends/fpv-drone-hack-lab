package m2;

import com.google.gson.s;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2848a = 0;
    public final s b;

    public i(com.google.gson.j jVar, s sVar, Type type) {
        this.b = sVar;
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        switch (this.f2848a) {
            case 0:
                return this.b.a(aVar);
            default:
                Date date = (Date) this.b.a(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
        }
    }

    public i(s sVar) {
        this.b = sVar;
    }
}
