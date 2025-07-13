package j1;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.jaygoo.widget.SavedState;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n0 implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2456a;

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View$BaseSavedState, java.lang.Object, com.jaygoo.widget.SavedState] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2456a) {
            case 0:
                return new TrackGroupArray(parcel);
            case 1:
                return new HlsTrackMetadataEntry(parcel);
            case 2:
                ?? baseSavedState = new View.BaseSavedState(parcel);
                baseSavedState.f533a = parcel.readFloat();
                baseSavedState.b = parcel.readFloat();
                baseSavedState.c = parcel.readFloat();
                baseSavedState.d = parcel.readInt();
                baseSavedState.f534e = parcel.readFloat();
                baseSavedState.f535f = parcel.readFloat();
                return baseSavedState;
            case 3:
                return new MdtaMetadataEntry(parcel);
            case 4:
                return new UserInfoBean(parcel);
            case 5:
                return new PlugInBean(parcel);
            case 6:
                return new StrategyBean(parcel);
            default:
                return new CrashDetailBean(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f2456a) {
            case 0:
                return new TrackGroupArray[i3];
            case 1:
                return new HlsTrackMetadataEntry[i3];
            case 2:
                return new SavedState[i3];
            case 3:
                return new MdtaMetadataEntry[i3];
            case 4:
                return new UserInfoBean[i3];
            case 5:
                return new PlugInBean[i3];
            case 6:
                return new StrategyBean[i3];
            default:
                return new CrashDetailBean[i3];
        }
    }
}
