package f0;

import a1.g;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lg.picturesubmitt.activity.VideoListActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f1800a;
    public final /* synthetic */ BaseQuickAdapter b;

    public c(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.b = baseQuickAdapter;
        this.f1800a = baseViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        BaseQuickAdapter baseQuickAdapter = this.b;
        g gVar = baseQuickAdapter.c;
        this.f1800a.getLayoutPosition();
        baseQuickAdapter.getClass();
        VideoListActivity videoListActivity = (VideoListActivity) gVar.b;
        boolean z3 = !videoListActivity.f885i;
        videoListActivity.f885i = z3;
        if (z3) {
            videoListActivity.f882f.setVisibility(0);
            videoListActivity.f882f.setText(videoListActivity.getString(2131755090));
        } else {
            videoListActivity.f882f.setVisibility(8);
        }
        videoListActivity.f883g.notifyDataSetChanged();
        return true;
    }
}
