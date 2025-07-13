package androidx.appcompat.app;

import android.app.job.JobWorkItem;
import android.content.Intent;
import android.view.textclassifier.TextClassificationManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ JobWorkItem e(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* bridge */ /* synthetic */ TextClassificationManager j(Object obj) {
        return (TextClassificationManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class n() {
        return TextClassificationManager.class;
    }
}
