package r;

import android.content.Context;
import android.net.Uri;
import f.d;
import g.h;
import g.j;
import i.g0;
import p.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3368a = 0;
    public final Object b;

    public b(j.b bVar) {
        this.b = bVar;
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, h hVar) {
        switch (this.f3368a) {
            case 0:
                return c((Uri) obj);
            default:
                return c.b(((d) obj).b(), (j.b) this.b);
        }
    }

    @Override // g.j
    public final boolean b(Object obj, h hVar) {
        switch (this.f3368a) {
            case 0:
                return ((Uri) obj).getScheme().equals("android.resource");
            default:
                d dVar = (d) obj;
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i.g0 c(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getAuthority()
            java.lang.Object r1 = r7.b
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r2 = r1.getPackageName()
            boolean r2 = r0.equals(r2)
            r3 = 0
            if (r2 == 0) goto L15
        L13:
            r0 = r1
            goto L26
        L15:
            android.content.Context r0 = r1.createPackageContext(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1a
            goto L26
        L1a:
            r2 = move-exception
            java.lang.String r4 = r1.getPackageName()
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto Lba
            goto L13
        L26:
            java.util.List r2 = r8.getPathSegments()
            int r4 = r2.size()
            r5 = 2
            r6 = 1
            if (r4 != r5) goto L71
            java.util.List r2 = r8.getPathSegments()
            java.lang.String r4 = r8.getAuthority()
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            android.content.res.Resources r5 = r0.getResources()
            int r4 = r5.getIdentifier(r2, r3, r4)
            if (r4 != 0) goto L5a
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            java.lang.String r5 = "android"
            int r4 = r4.getIdentifier(r2, r3, r5)
        L5a:
            if (r4 == 0) goto L5d
            goto L87
        L5d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find resource id for: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L71:
            int r2 = r2.size()
            java.lang.String r4 = "Unrecognized Uri format: "
            if (r2 != r6) goto La8
            java.util.List r2 = r8.getPathSegments()
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.NumberFormatException -> L95
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.NumberFormatException -> L95
            int r4 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L95
        L87:
            r8 = 0
            android.graphics.drawable.Drawable r0 = com.bumptech.glide.e.b(r1, r0, r4, r8)
            if (r0 == 0) goto L94
            r.a r8 = new r.a
            r1 = 0
            r8.<init>(r0, r1)
        L94:
            return r8
        L95:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8, r0)
            throw r1
        La8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        Lba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to obtain context or unrecognized Uri format for: "
            r1.<init>(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r.b.c(android.net.Uri):i.g0");
    }

    public b(Context context) {
        this.b = context.getApplicationContext();
    }
}
