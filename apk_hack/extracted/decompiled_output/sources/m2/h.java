package m2;

import com.google.gson.s;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends s {
    public static final a c = new a(3);
    public static final a d = new a(4);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2847a;
    public final SimpleDateFormat b;

    public h(int i3) {
        this.f2847a = i3;
        switch (i3) {
            case 1:
                this.b = new SimpleDateFormat("hh:mm:ss a");
                return;
            default:
                this.b = new SimpleDateFormat("MMM d, yyyy");
                return;
        }
    }

    private final Object b(p2.a aVar) {
        synchronized (this) {
            if (aVar.u() == 9) {
                aVar.q();
                return null;
            }
            try {
                return new Date(this.b.parse(aVar.s()).getTime());
            } catch (ParseException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        switch (this.f2847a) {
            case 0:
                return b(aVar);
            default:
                synchronized (this) {
                    if (aVar.u() == 9) {
                        aVar.q();
                        return null;
                    }
                    try {
                        return new Time(this.b.parse(aVar.s()).getTime());
                    } catch (ParseException e5) {
                        throw new RuntimeException(e5);
                    }
                }
        }
    }
}
