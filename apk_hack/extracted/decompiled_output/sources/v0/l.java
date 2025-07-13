package v0;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3831a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    public static CommentFrame a(int i3, c0.b bVar) {
        int c = bVar.c();
        if (bVar.c() == 1684108385) {
            bVar.z(8);
            String j2 = bVar.j(c - 16);
            return new CommentFrame("und", j2, j2);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + c.a(i3));
        return null;
    }

    public static ApicFrame b(c0.b bVar) {
        String str;
        int c = bVar.c();
        if (bVar.c() == 1684108385) {
            int c5 = bVar.c() & ViewCompat.MEASURED_SIZE_MASK;
            if (c5 == 13) {
                str = "image/jpeg";
            } else if (c5 == 14) {
                str = "image/png";
            } else {
                str = null;
            }
            if (str == null) {
                a1.i.r("Unrecognized cover art flags: ", c5, "MetadataUtil");
                return null;
            }
            bVar.z(4);
            int i3 = c - 16;
            byte[] bArr = new byte[i3];
            bVar.b(bArr, 0, i3);
            return new ApicFrame(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    public static TextInformationFrame c(int i3, c0.b bVar, String str) {
        int c = bVar.c();
        if (bVar.c() == 1684108385 && c >= 22) {
            bVar.z(10);
            int s = bVar.s();
            if (s > 0) {
                String e5 = a1.i.e(s, "");
                int s5 = bVar.s();
                if (s5 > 0) {
                    e5 = e5 + "/" + s5;
                }
                return new TextInformationFrame(str, null, e5);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + c.a(i3));
        return null;
    }

    public static TextInformationFrame d(int i3, c0.b bVar, String str) {
        int c = bVar.c();
        if (bVar.c() == 1684108385) {
            bVar.z(8);
            return new TextInformationFrame(str, null, bVar.j(c - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + c.a(i3));
        return null;
    }

    public static Id3Frame e(int i3, String str, c0.b bVar, boolean z3, boolean z5) {
        int f4 = f(bVar);
        if (z5) {
            f4 = Math.min(1, f4);
        }
        if (f4 >= 0) {
            if (z3) {
                return new TextInformationFrame(str, null, Integer.toString(f4));
            }
            return new CommentFrame("und", str, Integer.toString(f4));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + c.a(i3));
        return null;
    }

    public static int f(c0.b bVar) {
        bVar.z(4);
        if (bVar.c() == 1684108385) {
            bVar.z(8);
            return bVar.n();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
