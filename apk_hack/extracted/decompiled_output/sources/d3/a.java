package d3;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.impl.BottomListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.widget.CheckView;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends EasyAdapter {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1639g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BasePopupView f1640h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(BasePopupView basePopupView, List list, int i3, int i5) {
        super(list, i3);
        this.f1639g = i5;
        this.f1640h = basePopupView;
    }

    @Override // com.lxj.easyadapter.EasyAdapter
    public final void c(ViewHolder viewHolder, Object obj, int i3) {
        int color;
        int i5;
        int color2;
        int i6;
        switch (this.f1639g) {
            case 0:
                String str = (String) obj;
                int i7 = z2.b.tv_text;
                viewHolder.getClass();
                j4.b.c(str, "text");
                ((TextView) viewHolder.a(i7)).setText(str);
                AttachListPopupView attachListPopupView = (AttachListPopupView) this.f1640h;
                attachListPopupView.getClass();
                com.lxj.xpopup.util.b.o((ImageView) viewHolder.b(z2.b.iv_image), false);
                attachListPopupView.f1034a.getClass();
                ((TextView) viewHolder.a(i7)).setTextColor(attachListPopupView.getResources().getColor(z2.a._xpopup_dark_color));
                ((LinearLayout) viewHolder.a(z2.b._ll_temp)).setGravity(0);
                return;
            case 1:
                String str2 = (String) obj;
                int i8 = z2.b.tv_text;
                viewHolder.getClass();
                j4.b.c(str2, "text");
                ((TextView) viewHolder.a(i8)).setText(str2);
                ImageView imageView = (ImageView) viewHolder.b(z2.b.iv_image);
                BottomListPopupView bottomListPopupView = (BottomListPopupView) this.f1640h;
                bottomListPopupView.getClass();
                int i9 = 8;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                bottomListPopupView.f1034a.getClass();
                ((TextView) viewHolder.a(i8)).setTextColor(bottomListPopupView.getResources().getColor(z2.a._xpopup_dark_color));
                if (bottomListPopupView.f1077v != -1) {
                    int i10 = z2.b.check_view;
                    if (viewHolder.b(i10) != null) {
                        View a5 = viewHolder.a(i10);
                        if (i3 == bottomListPopupView.f1077v) {
                            i9 = 0;
                        }
                        a5.setVisibility(i9);
                        ((CheckView) viewHolder.a(i10)).setColor(z2.e.f4295a);
                    }
                    TextView textView = (TextView) viewHolder.a(i8);
                    if (i3 == bottomListPopupView.f1077v) {
                        color = z2.e.f4295a;
                    } else {
                        color = bottomListPopupView.getResources().getColor(z2.a._xpopup_title_color);
                    }
                    textView.setTextColor(color);
                    TextView textView2 = (TextView) viewHolder.a(i8);
                    if (com.lxj.xpopup.util.b.m(bottomListPopupView.getContext())) {
                        i5 = GravityCompat.END;
                    } else {
                        i5 = GravityCompat.START;
                    }
                    textView2.setGravity(i5);
                    return;
                }
                int i11 = z2.b.check_view;
                if (viewHolder.b(i11) != null) {
                    viewHolder.a(i11).setVisibility(8);
                }
                ((TextView) viewHolder.a(i8)).setGravity(17);
                return;
            default:
                String str3 = (String) obj;
                int i12 = z2.b.tv_text;
                viewHolder.getClass();
                j4.b.c(str3, "text");
                ((TextView) viewHolder.a(i12)).setText(str3);
                ImageView imageView2 = (ImageView) viewHolder.b(z2.b.iv_image);
                CenterListPopupView centerListPopupView = (CenterListPopupView) this.f1640h;
                centerListPopupView.getClass();
                int i13 = 8;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                centerListPopupView.f1034a.getClass();
                ((TextView) viewHolder.a(i12)).setTextColor(centerListPopupView.getResources().getColor(z2.a._xpopup_dark_color));
                if (centerListPopupView.f1080u != -1) {
                    int i14 = z2.b.check_view;
                    if (viewHolder.b(i14) != null) {
                        View a6 = viewHolder.a(i14);
                        if (i3 == centerListPopupView.f1080u) {
                            i13 = 0;
                        }
                        a6.setVisibility(i13);
                        ((CheckView) viewHolder.a(i14)).setColor(z2.e.f4295a);
                    }
                    TextView textView3 = (TextView) viewHolder.a(i12);
                    if (i3 == centerListPopupView.f1080u) {
                        color2 = z2.e.f4295a;
                    } else {
                        color2 = centerListPopupView.getResources().getColor(z2.a._xpopup_title_color);
                    }
                    textView3.setTextColor(color2);
                    TextView textView4 = (TextView) viewHolder.a(i12);
                    if (com.lxj.xpopup.util.b.m(centerListPopupView.getContext())) {
                        i6 = GravityCompat.END;
                    } else {
                        i6 = GravityCompat.START;
                    }
                    textView4.setGravity(i6);
                    return;
                }
                int i15 = z2.b.check_view;
                if (viewHolder.b(i15) != null) {
                    viewHolder.a(i15).setVisibility(8);
                }
                ((TextView) viewHolder.a(i12)).setGravity(17);
                return;
        }
    }
}
