package h;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements c {
    public static final String[] c = {"_data"};
    public static final String[] d = {"_data"};

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1981a;
    public final ContentResolver b;

    public /* synthetic */ a(ContentResolver contentResolver, int i3) {
        this.f1981a = i3;
        this.b = contentResolver;
    }

    @Override // h.c
    public final Cursor a(Uri uri) {
        switch (this.f1981a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
