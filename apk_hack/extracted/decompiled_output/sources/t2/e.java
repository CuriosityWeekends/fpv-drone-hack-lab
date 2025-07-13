package t2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lg.picturesubmitt.activity.BaseActivity;
import com.lg.picturesubmitt.activity.ImageListActivity;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.VideoListActivity;
import com.lg.picturesubmitt.model.EntityVideo;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.model.PhotoInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends BaseQuickAdapter {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3689i = 0;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BaseActivity f3690j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MusicActivity musicActivity, ArrayList arrayList) {
        super(arrayList, 2131427470);
        this.f3690j = musicActivity;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void a(BaseViewHolder baseViewHolder, Object obj) {
        String str;
        String valueOf;
        String valueOf2;
        BaseActivity baseActivity = this.f3690j;
        switch (this.f3689i) {
            case 0:
                PhotoInfo photoInfo = (PhotoInfo) obj;
                ((TextView) baseViewHolder.b(2131231472)).setText(photoInfo.name);
                double m5 = j4.b.m(photoInfo.path);
                int i3 = ImageListActivity.f559k;
                double d = m5 / 1024.0d;
                if (d < 1.0d) {
                    str = m5 + "Byte(s)";
                } else {
                    double d5 = d / 1024.0d;
                    if (d5 < 1.0d) {
                        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
                        str = bigDecimal.setScale(2, 4).toPlainString() + "KB";
                    } else {
                        double d6 = d5 / 1024.0d;
                        if (d6 < 1.0d) {
                            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d5));
                            str = bigDecimal2.setScale(2, 4).toPlainString() + "MB";
                        } else {
                            double d7 = d6 / 1024.0d;
                            if (d7 < 1.0d) {
                                BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d6));
                                str = bigDecimal3.setScale(2, 4).toPlainString() + "GB";
                            } else {
                                BigDecimal bigDecimal4 = new BigDecimal(d7);
                                str = bigDecimal4.setScale(2, 4).toPlainString() + "TB";
                            }
                        }
                    }
                }
                ((TextView) baseViewHolder.b(2131231480)).setText(str);
                baseViewHolder.a(2131231068);
                baseViewHolder.a(2131231063);
                ImageListActivity imageListActivity = (ImageListActivity) baseActivity;
                c0.g.c(imageListActivity, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                com.bumptech.glide.p c = com.bumptech.glide.b.b(imageListActivity).f236f.c(imageListActivity);
                String str2 = photoInfo.path;
                c.getClass();
                new com.bumptech.glide.o(c.f287a, c, Drawable.class, c.b).v(str2).t((ImageView) baseViewHolder.b(2131231127));
                return;
            case 1:
                MusicInfo musicInfo = (MusicInfo) obj;
                ((TextView) baseViewHolder.b(2131231472)).setText(musicInfo.name);
                int i5 = musicInfo.value;
                ((MusicActivity) baseActivity).getClass();
                int i6 = i5 % 60;
                int i7 = (i5 - i6) / 60;
                if (i6 < 10) {
                    valueOf = a1.i.e(i6, "0");
                } else {
                    valueOf = String.valueOf(i6);
                }
                if (i7 < 10) {
                    valueOf2 = a1.i.e(i7, "0");
                } else {
                    valueOf2 = String.valueOf(i7);
                }
                Log.d("MusicActivity", "mMin:mSec = " + valueOf2 + ":" + valueOf);
                ((TextView) baseViewHolder.b(2131231480)).setText(valueOf2 + ":" + valueOf);
                baseViewHolder.a(2131231068);
                baseViewHolder.a(2131230871);
                return;
            default:
                EntityVideo entityVideo = (EntityVideo) obj;
                CheckBox checkBox = (CheckBox) baseViewHolder.b(2131230935);
                VideoListActivity videoListActivity = (VideoListActivity) baseActivity;
                if (videoListActivity.f885i) {
                    checkBox.setVisibility(0);
                    if (videoListActivity.f886j.contains(entityVideo)) {
                        checkBox.setChecked(true);
                        checkBox.setButtonDrawable(2131558433);
                    } else {
                        checkBox.setChecked(false);
                        checkBox.setButtonDrawable(2131558434);
                    }
                } else {
                    checkBox.setVisibility(8);
                }
                ((TextView) baseViewHolder.b(2131231210)).setText(entityVideo.name);
                baseViewHolder.a(2131230963);
                Context context = this.f296e;
                c0.g.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                com.bumptech.glide.p b = com.bumptech.glide.b.b(context).f236f.b(context);
                String str3 = entityVideo.thumbPath;
                b.getClass();
                new com.bumptech.glide.o(b.f287a, b, Drawable.class, b.b).v(str3).t((ImageView) baseViewHolder.b(2131231127));
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(VideoListActivity videoListActivity, ArrayList arrayList) {
        super(arrayList, 2131427416);
        this.f3690j = videoListActivity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ImageListActivity imageListActivity, ArrayList arrayList) {
        super(arrayList, 2131427415);
        this.f3690j = imageListActivity;
    }
}
