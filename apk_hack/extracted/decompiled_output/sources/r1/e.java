package r1;

import android.util.Base64;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import v0.o;
import v0.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends d {

    /* renamed from: e  reason: collision with root package name */
    public boolean f3391e;

    /* renamed from: f  reason: collision with root package name */
    public UUID f3392f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3393g;

    @Override // r1.d
    public final Object b() {
        UUID uuid = this.f3392f;
        byte[] a5 = o.a(uuid, null, this.f3393g);
        byte[] bArr = this.f3393g;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < bArr.length; i3 += 2) {
            sb.append((char) bArr[i3]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        byte b = decode[0];
        decode[0] = decode[3];
        decode[3] = b;
        byte b5 = decode[1];
        decode[1] = decode[2];
        decode[2] = b5;
        byte b6 = decode[4];
        decode[4] = decode[5];
        decode[5] = b6;
        byte b7 = decode[6];
        decode[6] = decode[7];
        decode[7] = b7;
        return new a(uuid, a5, new q[]{new q(true, null, 8, decode, 0, 0, null)});
    }

    @Override // r1.d
    public final boolean d(String str) {
        return "ProtectionHeader".equals(str);
    }

    @Override // r1.d
    public final void f(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f3391e = false;
        }
    }

    @Override // r1.d
    public final void j(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f3391e = true;
            String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
            if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
            }
            this.f3392f = UUID.fromString(attributeValue);
        }
    }

    @Override // r1.d
    public final void k(XmlPullParser xmlPullParser) {
        if (this.f3391e) {
            this.f3393g = Base64.decode(xmlPullParser.getText(), 0);
        }
    }
}
