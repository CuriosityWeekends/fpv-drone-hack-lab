package edu.cmu.pocketsphinx;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class PocketSphinxJNI {
    public static final native long Decoder_defaultConfig();

    public static final native void Decoder_endUtt(long j2, Decoder decoder);

    public static final native long Decoder_getConfig(long j2, Decoder decoder);

    public static final native boolean Decoder_getInSpeech(long j2, Decoder decoder);

    public static final native String Decoder_getSearch(long j2, Decoder decoder);

    public static final native long Decoder_hyp(long j2, Decoder decoder);

    public static final native int Decoder_processRaw(long j2, Decoder decoder, short[] sArr, long j5, boolean z3, boolean z5);

    public static final native void Decoder_setJsgfFile(long j2, Decoder decoder, String str, String str2);

    public static final native void Decoder_setSearch(long j2, Decoder decoder, String str);

    public static final native void Decoder_startUtt(long j2, Decoder decoder);

    public static final native String Hypothesis_hypstr_get(long j2, Hypothesis hypothesis);

    public static final native void delete_Decoder(long j2);

    public static final native void delete_Hypothesis(long j2);

    public static final native long new_Decoder__SWIG_1(long j2, Config config);
}
