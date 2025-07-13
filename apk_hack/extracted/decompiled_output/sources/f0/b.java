package f0;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lg.picturesubmitt.activity.SimplePlayerActivity;
import com.lg.picturesubmitt.activity.VideoListActivity;
import com.lg.picturesubmitt.model.EntityVideo;
import java.util.ArrayList;
import t2.p0;
import v2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1799a = 1;
    public final Object b;
    public Object c;

    public b(Context context) {
        View inflate = View.inflate(context, 2131427407, null);
        this.b = new d(context, inflate, -2, -2, 2131820545);
        inflate.findViewById(2131230882).setOnClickListener(this);
        ((ImageButton) inflate.findViewById(2131230888)).setOnClickListener(this);
    }

    public void a() {
        d dVar = (d) this.b;
        if (dVar != null) {
            dVar.b = new Dialog(dVar.f3894a, dVar.d);
            View view = dVar.f3895e;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            dVar.b.setContentView(view);
            WindowManager.LayoutParams attributes = dVar.b.getWindow().getAttributes();
            attributes.gravity = 17;
            attributes.width = dVar.f3896f;
            attributes.height = dVar.c;
            dVar.b.show();
            dVar.b.setCanceledOnTouchOutside(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        switch (this.f1799a) {
            case 0:
                p0 p0Var = ((BaseQuickAdapter) this.c).b;
                int layoutPosition = ((BaseViewHolder) this.b).getLayoutPosition();
                VideoListActivity videoListActivity = (VideoListActivity) p0Var.b;
                EntityVideo entityVideo = (EntityVideo) videoListActivity.f881e.get(layoutPosition);
                if (videoListActivity.f885i) {
                    CheckBox checkBox = (CheckBox) view.findViewById(2131230935);
                    ArrayList arrayList = videoListActivity.f886j;
                    if (arrayList.contains(entityVideo)) {
                        arrayList.remove(entityVideo);
                        checkBox.setChecked(false);
                        checkBox.setButtonDrawable(2131558434);
                    } else {
                        arrayList.add(entityVideo);
                        checkBox.setChecked(true);
                        checkBox.setButtonDrawable(2131558433);
                    }
                    TextView textView = videoListActivity.f882f;
                    textView.setText(videoListActivity.getString(2131755090) + "(" + arrayList.size() + ")");
                    return;
                }
                Intent intent = new Intent(videoListActivity, SimplePlayerActivity.class);
                intent.putExtra("NAME", ((EntityVideo) videoListActivity.f881e.get(layoutPosition)).value + ".mp4");
                videoListActivity.startActivity(intent);
                return;
            default:
                int id = view.getId();
                if (id != 2131230882) {
                    if (id == 2131230888) {
                        v2.c cVar = (v2.c) this.c;
                        if (cVar != null) {
                            cVar.h();
                        }
                        d dVar = (d) this.b;
                        if (dVar != null && (dialog2 = dVar.b) != null && dialog2.isShowing()) {
                            dVar.b.dismiss();
                            return;
                        }
                        return;
                    }
                    return;
                }
                d dVar2 = (d) this.b;
                if (dVar2 != null && (dialog = dVar2.b) != null && dialog.isShowing()) {
                    dVar2.b.dismiss();
                    return;
                }
                return;
        }
    }

    public b(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.c = baseQuickAdapter;
        this.b = baseViewHolder;
    }
}
