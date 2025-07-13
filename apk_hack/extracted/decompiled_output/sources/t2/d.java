package t2;

import android.content.Intent;
import android.view.View;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.ImageListActivity;
import com.lg.picturesubmitt.activity.VideoListActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3688a;
    public final /* synthetic */ FileDirActivity b;

    public /* synthetic */ d(FileDirActivity fileDirActivity, int i3) {
        this.f3688a = i3;
        this.b = fileDirActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3688a) {
            case 0:
                this.b.finish();
                return;
            case 1:
                FileDirActivity fileDirActivity = this.b;
                fileDirActivity.startActivity(new Intent(fileDirActivity, ImageListActivity.class));
                return;
            default:
                FileDirActivity fileDirActivity2 = this.b;
                fileDirActivity2.startActivity(new Intent(fileDirActivity2, VideoListActivity.class));
                return;
        }
    }
}
