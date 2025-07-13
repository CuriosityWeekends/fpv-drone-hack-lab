package edu.cmu.pocketsphinx;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class SphinxBaseJNI {
    public static final native double Config_getFloat(long j2, Config config, String str);

    public static final native void Config_setBoolean(long j2, Config config, String str, boolean z3);

    public static final native void Config_setFloat(long j2, Config config, String str, double d);

    public static final native void Config_setString(long j2, Config config, String str, String str2);

    public static final native void delete_Config(long j2);
}
