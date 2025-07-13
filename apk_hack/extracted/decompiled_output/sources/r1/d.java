package r1;

import android.util.Pair;
import j1.o0;
import java.io.IOException;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f3390a;
    public final String b;
    public final d c;
    public final LinkedList d = new LinkedList();

    public d(d dVar, String str, String str2) {
        this.c = dVar;
        this.f3390a = str;
        this.b = str2;
    }

    public static int g(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e5) {
                throw new IOException(e5);
            }
        }
        return -1;
    }

    public static long h(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e5) {
                throw new IOException(e5);
            }
        }
        return j2;
    }

    public static int i(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e5) {
                throw new IOException(e5);
            }
        }
        throw new o0(str);
    }

    public abstract Object b();

    public final Object c(String str) {
        int i3 = 0;
        while (true) {
            LinkedList linkedList = this.d;
            if (i3 < linkedList.size()) {
                Pair pair = (Pair) linkedList.get(i3);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
                i3++;
            } else {
                d dVar = this.c;
                if (dVar == null) {
                    return null;
                }
                return dVar.c(str);
            }
        }
    }

    public boolean d(String str) {
        return false;
    }

    public final Object e(XmlPullParser xmlPullParser) {
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            d dVar = null;
            if (eventType == 1) {
                return null;
            }
            if (eventType != 2) {
                if (eventType != 3) {
                    if (eventType == 4 && z3 && i3 == 0) {
                        k(xmlPullParser);
                    }
                } else if (!z3) {
                    continue;
                } else if (i3 > 0) {
                    i3--;
                } else {
                    String name = xmlPullParser.getName();
                    f(xmlPullParser);
                    if (!d(name)) {
                        return b();
                    }
                }
            } else {
                String name2 = xmlPullParser.getName();
                if (this.b.equals(name2)) {
                    j(xmlPullParser);
                    z3 = true;
                } else if (z3) {
                    if (i3 > 0) {
                        i3++;
                    } else if (d(name2)) {
                        j(xmlPullParser);
                    } else {
                        boolean equals = "QualityLevel".equals(name2);
                        String str = this.f3390a;
                        if (equals) {
                            dVar = new d(this, str, "QualityLevel");
                        } else if ("Protection".equals(name2)) {
                            dVar = new d(this, str, "Protection");
                        } else if ("StreamIndex".equals(name2)) {
                            dVar = new h(this, str);
                        }
                        if (dVar == null) {
                            i3 = 1;
                        } else {
                            a(dVar.e(xmlPullParser));
                        }
                    }
                }
            }
            xmlPullParser.next();
        }
    }

    public abstract void j(XmlPullParser xmlPullParser);

    public void a(Object obj) {
    }

    public void f(XmlPullParser xmlPullParser) {
    }

    public void k(XmlPullParser xmlPullParser) {
    }
}
