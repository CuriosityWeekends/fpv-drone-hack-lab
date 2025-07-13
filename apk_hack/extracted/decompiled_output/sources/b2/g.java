package b2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.ColorInfo;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f151a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f151a) {
            case 0:
                return new DefaultTrackSelector$Parameters(parcel);
            case 1:
                return new DefaultTrackSelector$SelectionOverride(parcel);
            case 2:
                return new TrackSelectionParameters(parcel);
            case 3:
                return new EventMessage(parcel);
            case 4:
                return new PictureFrame(parcel);
            case 5:
                return new VorbisComment(parcel);
            case 6:
                return new IcyHeaders(parcel);
            case 7:
                return new IcyInfo(parcel);
            case 8:
                return new ApicFrame(parcel);
            case 9:
                return new BinaryFrame(parcel);
            case 10:
                return new ChapterFrame(parcel);
            case 11:
                return new ChapterTocFrame(parcel);
            case 12:
                return new CommentFrame(parcel);
            case 13:
                return new GeobFrame(parcel);
            case 14:
                return new InternalFrame(parcel);
            case 15:
                return new MlltFrame(parcel);
            case 16:
                return new PrivFrame(parcel);
            case 17:
                return new TextInformationFrame(parcel);
            case 18:
                return new UrlLinkFrame(parcel);
            case 19:
                return new PrivateCommand(parcel);
            case 20:
                return new SpliceInsertCommand(parcel);
            case 21:
                return new Object();
            case 22:
                return new SpliceScheduleCommand(parcel);
            case 23:
                return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
            case 24:
                return new DownloadRequest(parcel);
            case 25:
                return new StreamKey(parcel);
            case 26:
                return new ColorInfo(parcel);
            case 27:
                return new Requirements(parcel.readInt());
            case 28:
                return new Format(parcel);
            default:
                return new TrackGroup(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f151a) {
            case 0:
                return new DefaultTrackSelector$Parameters[i3];
            case 1:
                return new DefaultTrackSelector$SelectionOverride[i3];
            case 2:
                return new TrackSelectionParameters[i3];
            case 3:
                return new EventMessage[i3];
            case 4:
                return new PictureFrame[i3];
            case 5:
                return new VorbisComment[i3];
            case 6:
                return new IcyHeaders[i3];
            case 7:
                return new IcyInfo[i3];
            case 8:
                return new ApicFrame[i3];
            case 9:
                return new BinaryFrame[i3];
            case 10:
                return new ChapterFrame[i3];
            case 11:
                return new ChapterTocFrame[i3];
            case 12:
                return new CommentFrame[i3];
            case 13:
                return new GeobFrame[i3];
            case 14:
                return new InternalFrame[i3];
            case 15:
                return new MlltFrame[i3];
            case 16:
                return new PrivFrame[i3];
            case 17:
                return new TextInformationFrame[i3];
            case 18:
                return new UrlLinkFrame[i3];
            case 19:
                return new PrivateCommand[i3];
            case 20:
                return new SpliceInsertCommand[i3];
            case 21:
                return new SpliceNullCommand[i3];
            case 22:
                return new SpliceScheduleCommand[i3];
            case 23:
                return new TimeSignalCommand[i3];
            case 24:
                return new DownloadRequest[i3];
            case 25:
                return new StreamKey[i3];
            case 26:
                return new ColorInfo[i3];
            case 27:
                return new Requirements[i3];
            case 28:
                return new Format[i3];
            default:
                return new TrackGroup[i3];
        }
    }
}
