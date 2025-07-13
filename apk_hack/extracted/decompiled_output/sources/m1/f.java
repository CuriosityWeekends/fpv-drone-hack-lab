package m1;

import android.net.Uri;
import android.text.TextUtils;
import e2.h0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f2790a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

    @Override // e2.h0
    public final Object f(Uri uri, e2.k kVar) {
        long j2;
        long parseLong;
        String readLine = new BufferedReader(new InputStreamReader(kVar, Charset.forName("UTF-8"))).readLine();
        try {
            Matcher matcher = f2790a.matcher(readLine);
            if (matcher.matches()) {
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    if ("+".equals(matcher.group(4))) {
                        j2 = 1;
                    } else {
                        j2 = -1;
                    }
                    long parseLong2 = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    if (TextUtils.isEmpty(group2)) {
                        parseLong = 0;
                    } else {
                        parseLong = Long.parseLong(group2);
                    }
                    time -= (((parseLong2 * 60) + parseLong) * 60000) * j2;
                }
                return Long.valueOf(time);
            }
            throw new IOException("Couldn't parse timestamp: " + readLine);
        } catch (ParseException e5) {
            throw new IOException(e5);
        }
    }
}
