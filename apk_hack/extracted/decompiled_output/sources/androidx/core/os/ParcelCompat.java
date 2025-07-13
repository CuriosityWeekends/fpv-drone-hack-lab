package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z3) {
        parcel.writeInt(z3 ? 1 : 0);
    }
}
