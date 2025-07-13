package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1476a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c0(int i3, Object obj, Object obj2) {
        this.f1476a = i3;
        this.c = obj;
        this.b = obj2;
    }

    private final void a() {
        try {
            al.a(aq.b().getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (((aq) this.b)) {
                aq.b((aq) this.c).registerReceiver(aq.b(), aq.a((aq) this.c), "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a6, code lost:
        if (r6.c != (-1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x03c7, code lost:
        if (r7 == 3) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0287, code lost:
        if (r6.c == (-1)) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0289, code lost:
        r6.f3535e = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x028d, code lost:
        r6.f3535e = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.c0.run():void");
    }

    public /* synthetic */ c0(int i3, Object obj, Object obj2, boolean z3) {
        this.f1476a = i3;
        this.b = obj;
        this.c = obj2;
    }
}
