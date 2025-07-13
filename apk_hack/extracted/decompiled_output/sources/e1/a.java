package e1;

import b1.b;
import b1.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import g2.w;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements b {
    public static final Pattern c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a  reason: collision with root package name */
    public final CharsetDecoder f1670a = Charset.forName("UTF-8").newDecoder();
    public final CharsetDecoder b = Charset.forName("ISO-8859-1").newDecoder();

    @Override // b1.b
    public final Metadata a(d dVar) {
        String str;
        ByteBuffer byteBuffer = dVar.b;
        byteBuffer.getClass();
        CharsetDecoder charsetDecoder = this.b;
        CharsetDecoder charsetDecoder2 = this.f1670a;
        String str2 = null;
        try {
            str = charsetDecoder2.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = charsetDecoder.decode(byteBuffer).toString();
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = charBuffer;
            } catch (CharacterCodingException unused2) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = null;
            } catch (Throwable th) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            charsetDecoder2.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = c.matcher(str);
        String str3 = null;
        for (int i3 = 0; matcher.find(i3); i3 = matcher.end()) {
            String E = w.E(matcher.group(1));
            String group = matcher.group(2);
            E.getClass();
            if (!E.equals("streamurl")) {
                if (E.equals("streamtitle")) {
                    str2 = group;
                }
            } else {
                str3 = group;
            }
        }
        return new Metadata(new IcyInfo(bArr, str2, str3));
    }
}
