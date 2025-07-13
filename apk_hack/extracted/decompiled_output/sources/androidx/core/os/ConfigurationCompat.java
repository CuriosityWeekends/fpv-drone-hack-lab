package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            return LocaleListCompat.wrap(locales);
        }
        return LocaleListCompat.create(configuration.locale);
    }
}
