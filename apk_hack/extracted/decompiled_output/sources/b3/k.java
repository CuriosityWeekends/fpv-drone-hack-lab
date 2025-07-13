package b3;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckedTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.lg.picturesubmitt.activity.ProtocolActivity;
import com.lg.picturesubmitt.activity.SettingActivity;
import com.lg.picturesubmitt.activity.SimplePlayerActivity;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopup.impl.BottomListPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f177a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(int i3, Object obj) {
        this.f177a = i3;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3;
        switch (this.f177a) {
            case 0:
                BottomPopupView bottomPopupView = (BottomPopupView) this.b;
                a1.m mVar = bottomPopupView.f1034a;
                if (mVar != null) {
                    mVar.getClass();
                    bottomPopupView.f1034a.getClass();
                    bottomPopupView.b();
                    return;
                }
                return;
            case 1:
                DrawerPopupView drawerPopupView = (DrawerPopupView) this.b;
                a1.m mVar2 = drawerPopupView.f1034a;
                if (mVar2 != null) {
                    mVar2.getClass();
                    drawerPopupView.f1034a.getClass();
                    drawerPopupView.b();
                    return;
                }
                return;
            case 2:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.b;
                CheckedTextView checkedTextView = trackSelectionView.f485a;
                SparseArray sparseArray = trackSelectionView.c;
                boolean z3 = false;
                CheckedTextView checkedTextView2 = trackSelectionView.b;
                if (view == checkedTextView) {
                    trackSelectionView.f487f = true;
                    sparseArray.clear();
                } else if (view == checkedTextView2) {
                    trackSelectionView.f487f = false;
                    sparseArray.clear();
                } else {
                    trackSelectionView.f487f = false;
                    Pair pair = (Pair) view.getTag();
                    int intValue = ((Integer) pair.first).intValue();
                    ((Integer) pair.second).getClass();
                    DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride) sparseArray.get(intValue);
                    throw null;
                }
                trackSelectionView.f485a.setChecked(trackSelectionView.f487f);
                if (!trackSelectionView.f487f && sparseArray.size() == 0) {
                    z3 = true;
                }
                checkedTextView2.setChecked(z3);
                throw null;
            case 3:
                ((BottomListPopupView) this.b).b();
                return;
            case 4:
                BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter) this.b;
                h0.a aVar = baseQuickAdapter.f295a;
                int i5 = aVar.f1984a;
                if (i5 == 3 && i5 != 2) {
                    aVar.f1984a = 1;
                    baseQuickAdapter.notifyItemChanged(baseQuickAdapter.f299h.size());
                    return;
                }
                return;
            case 5:
                BaseViewHolder baseViewHolder = (BaseViewHolder) this.b;
                a1.g gVar = baseViewHolder.f301e.d;
                if (gVar != null) {
                    int layoutPosition = baseViewHolder.getLayoutPosition();
                    baseViewHolder.f301e.getClass();
                    if (layoutPosition >= 0) {
                        i3 = baseViewHolder.getLayoutPosition();
                        baseViewHolder.f301e.getClass();
                    } else {
                        i3 = 0;
                    }
                    gVar.a(view, i3);
                    return;
                }
                return;
            case 6:
                ((ProtocolActivity) this.b).finish();
                return;
            case 7:
                ((SettingActivity) this.b).finish();
                return;
            default:
                ((SimplePlayerActivity) this.b).onBackPressed();
                return;
        }
    }
}
