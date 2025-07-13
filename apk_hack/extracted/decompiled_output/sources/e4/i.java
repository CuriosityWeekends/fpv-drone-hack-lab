package e4;

import edu.cmu.pocketsphinx.Config;
import edu.cmu.pocketsphinx.PocketSphinxJNI;
import edu.cmu.pocketsphinx.SphinxBaseJNI;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final Config f1762a;

    static {
        System.loadLibrary("pocketsphinx_jni");
    }

    public i(Config config) {
        this.f1762a = config;
    }

    public static i a() {
        Config config;
        long Decoder_defaultConfig = PocketSphinxJNI.Decoder_defaultConfig();
        if (Decoder_defaultConfig == 0) {
            config = null;
        } else {
            config = new Config(Decoder_defaultConfig);
        }
        return new i(config);
    }

    public final void b(String str, String str2) {
        Config config = this.f1762a;
        SphinxBaseJNI.Config_setString(config.f1763a, config, str, str2);
    }
}
