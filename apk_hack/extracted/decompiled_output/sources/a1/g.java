package a1;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.exoplayer2.Format;
import com.lg.picturesubmitt.activity.ImageListActivity;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.ViewPhotoDetailActivity;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.model.PhotoInfo;
import g2.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class g implements n, p0.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(int i3, Object obj) {
        this.f36a = i3;
        this.b = obj;
    }

    public void a(View view, int i3) {
        Object obj = this.b;
        switch (this.f36a) {
            case 2:
                int i5 = ImageListActivity.f559k;
                ImageListActivity imageListActivity = (ImageListActivity) obj;
                imageListActivity.getClass();
                int id = view.getId();
                ArrayList arrayList = imageListActivity.f563h;
                if (id != 2131231063) {
                    if (id == 2131231068) {
                        Intent intent = new Intent(imageListActivity, ViewPhotoDetailActivity.class);
                        intent.putExtra("Path", ((PhotoInfo) arrayList.get(i3)).path);
                        imageListActivity.startActivity(intent);
                        return;
                    }
                    return;
                } else if (i3 < arrayList.size()) {
                    String str = ((PhotoInfo) arrayList.get(i3)).path;
                    t2.e eVar = imageListActivity.f561f;
                    List list = eVar.f299h;
                    list.remove(i3);
                    eVar.notifyItemRemoved(i3);
                    if (list.size() == 0) {
                        eVar.notifyDataSetChanged();
                    }
                    eVar.notifyItemRangeChanged(i3, list.size() - i3);
                    Log.d("ImageListActivity", "删除filePath" + str);
                    if (!imageListActivity.f564i.isShutdown()) {
                        imageListActivity.f564i.execute(new b3.d(11, str));
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                int i6 = MusicActivity.f802k;
                MusicActivity musicActivity = (MusicActivity) obj;
                musicActivity.getClass();
                if (view.getId() == 2131230871) {
                    MusicInfo musicInfo = (MusicInfo) musicActivity.f807i.get(i3);
                    Intent intent2 = new Intent();
                    intent2.putExtra("MusicPath", musicInfo);
                    intent2.putExtra("MusicInfo", musicInfo);
                    musicActivity.setResult(2, intent2);
                    musicActivity.finish();
                    return;
                }
                return;
        }
    }

    @Override // a1.n
    public int b(Object obj) {
        try {
            return ((a) obj).b((Format) this.b) ? 1 : 0;
        } catch (k unused) {
            return -1;
        }
    }

    @Override // p0.c
    public long f(long j2) {
        g2.i iVar = (g2.i) this.b;
        return w.i((j2 * iVar.f1925e) / 1000000, 0L, iVar.f1930j - 1);
    }
}
