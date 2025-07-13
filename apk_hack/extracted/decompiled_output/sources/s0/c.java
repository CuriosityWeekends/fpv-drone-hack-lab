package s0;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends j.a {
    public long b;

    public static Serializable E(int i3, c0.b bVar) {
        if (i3 != 0) {
            boolean z3 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 8) {
                            if (i3 != 10) {
                                if (i3 != 11) {
                                    return null;
                                }
                                Date date = new Date((long) Double.longBitsToDouble(bVar.h()));
                                bVar.z(2);
                                return date;
                            }
                            int q = bVar.q();
                            ArrayList arrayList = new ArrayList(q);
                            for (int i5 = 0; i5 < q; i5++) {
                                Serializable E = E(bVar.n(), bVar);
                                if (E != null) {
                                    arrayList.add(E);
                                }
                            }
                            return arrayList;
                        }
                        return F(bVar);
                    }
                    HashMap hashMap = new HashMap();
                    while (true) {
                        String G = G(bVar);
                        int n5 = bVar.n();
                        if (n5 == 9) {
                            return hashMap;
                        }
                        Serializable E2 = E(n5, bVar);
                        if (E2 != null) {
                            hashMap.put(G, E2);
                        }
                    }
                } else {
                    return G(bVar);
                }
            } else {
                if (bVar.n() != 1) {
                    z3 = false;
                }
                return Boolean.valueOf(z3);
            }
        } else {
            return Double.valueOf(Double.longBitsToDouble(bVar.h()));
        }
    }

    public static HashMap F(c0.b bVar) {
        int q = bVar.q();
        HashMap hashMap = new HashMap(q);
        for (int i3 = 0; i3 < q; i3++) {
            String G = G(bVar);
            Serializable E = E(bVar.n(), bVar);
            if (E != null) {
                hashMap.put(G, E);
            }
        }
        return hashMap;
    }

    public static String G(c0.b bVar) {
        int s = bVar.s();
        int i3 = bVar.b;
        bVar.z(s);
        return new String(bVar.f187a, i3, s);
    }

    public final boolean D(c0.b bVar, long j2) {
        if (bVar.n() == 2) {
            if (!"onMetaData".equals(G(bVar)) || bVar.n() != 8) {
                return false;
            }
            HashMap F = F(bVar);
            if (F.containsKey("duration")) {
                double doubleValue = ((Double) F.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.b = (long) (doubleValue * 1000000.0d);
                }
            }
            return false;
        }
        throw new IOException();
    }
}
