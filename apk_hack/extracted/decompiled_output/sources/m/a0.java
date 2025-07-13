package m;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2728a;
    public final q b;

    public /* synthetic */ a0(q qVar, int i3) {
        this.f2728a = i3;
        this.b = qVar;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        Uri uri;
        switch (this.f2728a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uri = null;
                } else if (str.charAt(0) == '/') {
                    uri = Uri.fromFile(new File(str));
                } else {
                    Uri parse = Uri.parse(str);
                    if (parse.getScheme() == null) {
                        uri = Uri.fromFile(new File(str));
                    } else {
                        uri = parse;
                    }
                }
                if (uri == null) {
                    return null;
                }
                q qVar = this.b;
                if (!qVar.b(uri)) {
                    return null;
                }
                return qVar.a(uri, i3, i5, hVar);
            default:
                return this.b.a(new f((URL) obj), i3, i5, hVar);
        }
    }

    @Override // m.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f2728a) {
            case 0:
                String str = (String) obj;
                return true;
            default:
                URL url = (URL) obj;
                return true;
        }
    }
}
