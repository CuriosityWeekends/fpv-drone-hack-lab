package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1378a;

    public /* synthetic */ b0(int i3) {
        this.f1378a = i3;
    }

    public final String a() {
        switch (this.f1378a) {
            case 0:
                String a5 = ap.a("ro.gn.gnromvernumber");
                if (!ap.b(a5) && !a5.equals("fail")) {
                    StringBuilder p5 = a1.i.p("amigo/", a5, "/");
                    p5.append(ap.a("ro.build.display.id"));
                    return p5.toString();
                }
                return null;
            case 1:
                return ap.a("ro.build.fingerprint") + "/" + ap.a("ro.build.rom.id");
            case 2:
                String a6 = ap.a("ro.build.tyd.kbstyle_version");
                if (!ap.b(a6) && !a6.equals("fail")) {
                    return "dido/".concat(a6);
                }
                return null;
            case 3:
                String a7 = ap.a("ro.aa.romver");
                if (!ap.b(a7) && !a7.equals("fail")) {
                    StringBuilder p6 = a1.i.p("htc/", a7, "/");
                    p6.append(ap.a("ro.build.description"));
                    return p6.toString();
                }
                return null;
            case 4:
                String a8 = ap.a("ro.build.version.emui");
                if (!ap.b(a8) && !a8.equals("fail")) {
                    return "HuaWei/EMOTION/".concat(a8);
                }
                return null;
            case 5:
                String a9 = ap.a("ro.lenovo.series");
                if (!ap.b(a9) && !a9.equals("fail")) {
                    return "Lenovo/VIBE/".concat(String.valueOf(ap.a("ro.build.version.incremental")));
                }
                return null;
            case 6:
                String a10 = ap.a("ro.meizu.product.model");
                if (!ap.b(a10) && !a10.equals("fail")) {
                    return "Meizu/FLYME/" + ap.a("ro.build.display.id");
                }
                return null;
            case 7:
                String a11 = ap.a("ro.build.version.opporom");
                if (!ap.b(a11) && !a11.equals("fail")) {
                    return "Oppo/COLOROS/".concat(a11);
                }
                return null;
            case 8:
                String a12 = ap.a("ro.lewa.version");
                if (!ap.b(a12) && !a12.equals("fail")) {
                    StringBuilder p7 = a1.i.p("tcl/", a12, "/");
                    p7.append(ap.a("ro.build.display.id"));
                    return p7.toString();
                }
                return null;
            case 9:
                String a13 = ap.a("ro.vivo.os.build.display.id");
                if (!ap.b(a13) && !a13.equals("fail")) {
                    return "vivo/FUNTOUCH/".concat(a13);
                }
                return null;
            case 10:
                String a14 = ap.a("ro.miui.ui.version.name");
                if (!ap.b(a14) && !a14.equals("fail")) {
                    return "XiaoMi/MIUI/".concat(a14);
                }
                return null;
            default:
                String a15 = ap.a("ro.build.nubia.rom.name");
                if (!ap.b(a15) && !a15.equals("fail")) {
                    StringBuilder p8 = a1.i.p("Zte/NUBIA/", a15, "_");
                    p8.append(ap.a("ro.build.nubia.rom.code"));
                    return p8.toString();
                }
                return null;
        }
    }
}
