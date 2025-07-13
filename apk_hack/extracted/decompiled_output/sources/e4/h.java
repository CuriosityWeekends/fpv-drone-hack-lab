package e4;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import edu.cmu.pocketsphinx.Config;
import edu.cmu.pocketsphinx.Decoder;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.PocketSphinxJNI;
import edu.cmu.pocketsphinx.SphinxBaseJNI;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f1758g = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Decoder f1759a;
    public final int b;
    public final AudioRecord c;
    public e d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f1760e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public final HashSet f1761f = new HashSet();

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, edu.cmu.pocketsphinx.Decoder] */
    public h(Config config) {
        long j2;
        Config config2;
        if (config == null) {
            j2 = 0;
        } else {
            j2 = config.f1763a;
        }
        long new_Decoder__SWIG_1 = PocketSphinxJNI.new_Decoder__SWIG_1(j2, config);
        ?? obj = new Object();
        obj.b = true;
        obj.f1764a = new_Decoder__SWIG_1;
        this.f1759a = obj;
        long Decoder_getConfig = PocketSphinxJNI.Decoder_getConfig(new_Decoder__SWIG_1, obj);
        if (Decoder_getConfig == 0) {
            config2 = null;
        } else {
            config2 = new Config(Decoder_getConfig);
        }
        int Config_getFloat = (int) SphinxBaseJNI.Config_getFloat(config2.f1763a, config2, "-samprate");
        int round = Math.round(Config_getFloat * 0.4f);
        this.b = round;
        AudioRecord audioRecord = new AudioRecord(6, Config_getFloat, 16, 2, round * 2);
        this.c = audioRecord;
        if (audioRecord.getState() != 0) {
            return;
        }
        audioRecord.release();
        throw new IOException("Failed to initialize recorder. Microphone might be already in use.");
    }

    public final void a(File file) {
        Log.i("h", String.format("Load JSGF %s", file));
        String path = file.getPath();
        Decoder decoder = this.f1759a;
        PocketSphinxJNI.Decoder_setJsgfFile(decoder.f1764a, decoder, "zh", path);
    }

    public final void b(a aVar) {
        synchronized (this.f1761f) {
            this.f1761f.add(aVar);
        }
    }

    public final void c() {
        if (this.d != null) {
            return;
        }
        Log.i("h", "Start recognition \"zh\"");
        Decoder decoder = this.f1759a;
        PocketSphinxJNI.Decoder_setSearch(decoder.f1764a, decoder, "zh");
        e eVar = new e(this);
        this.d = eVar;
        eVar.start();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, edu.cmu.pocketsphinx.Hypothesis] */
    public final void d() {
        Hypothesis hypothesis;
        if (e()) {
            Log.i("h", "Stop recognition");
            Decoder decoder = this.f1759a;
            long Decoder_hyp = PocketSphinxJNI.Decoder_hyp(decoder.f1764a, decoder);
            if (Decoder_hyp == 0) {
                hypothesis = null;
            } else {
                ?? obj = new Object();
                obj.b = true;
                obj.f1765a = Decoder_hyp;
                hypothesis = obj;
            }
            this.f1760e.post(new f(this, hypothesis, true));
        }
    }

    public final boolean e() {
        e eVar = this.d;
        if (eVar == null) {
            return false;
        }
        try {
            eVar.interrupt();
            this.d.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.d = null;
        return true;
    }
}
