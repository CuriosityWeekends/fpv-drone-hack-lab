package androidx.core.telephony.mbms;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MbmsHelper {
    private MbmsHelper() {
    }

    @Nullable
    @SuppressLint({"BanTargetApiAnnotation"})
    @TargetApi(28)
    public static CharSequence getBestNameForService(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        LocaleList locales;
        Set namedContentLocales;
        Set<Locale> namedContentLocales2;
        Locale firstMatch;
        CharSequence nameForLocale;
        if (Build.VERSION.SDK_INT >= 28) {
            locales = context.getResources().getConfiguration().getLocales();
            namedContentLocales = serviceInfo.getNamedContentLocales();
            int size = namedContentLocales.size();
            if (size == 0) {
                return null;
            }
            String[] strArr = new String[size];
            namedContentLocales2 = serviceInfo.getNamedContentLocales();
            int i3 = 0;
            for (Locale locale : namedContentLocales2) {
                strArr[i3] = locale.toLanguageTag();
                i3++;
            }
            firstMatch = locales.getFirstMatch(strArr);
            if (firstMatch != null) {
                nameForLocale = serviceInfo.getNameForLocale(firstMatch);
                return nameForLocale;
            }
            return null;
        }
        return null;
    }
}
