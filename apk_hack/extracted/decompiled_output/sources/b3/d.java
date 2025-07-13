package b3;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.transition.MaterialFade;
import com.lg.picturesubmitt.activity.ImageListActivity;
import com.lg.picturesubmitt.activity.MainActivity;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.VideoListActivity;
import com.lg.picturesubmitt.model.EntityVideo;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.model.PhotoInfo;
import com.lg.picturesubmitt.widget.HTrimView;
import com.lg.picturesubmitt.widget.VTrimView;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BubbleAttachPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.au;
import e2.d0;
import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import t2.n0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f170a;
    public final Object b;

    public /* synthetic */ d(int i3, Object obj) {
        this.f170a = i3;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i5;
        char c;
        switch (this.f170a) {
            case 0:
                BasePopupView basePopupView = (BasePopupView) ((e) this.b).b;
                if (!(basePopupView instanceof PositionPopupView) && !(basePopupView instanceof AttachPopupView) && !(basePopupView instanceof BubbleAttachPopupView)) {
                    if (!(basePopupView instanceof FullScreenPopupView) || !basePopupView.getPopupContentView().hasTransientState()) {
                        basePopupView.getPopupContentView().animate().translationY(0.0f).setInterpolator(new LinearInterpolator()).setDuration(100L).start();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                com.bumptech.glide.p pVar = (com.bumptech.glide.p) this.b;
                pVar.c.a(pVar);
                return;
            case 2:
                throw null;
            case 3:
                ag.c((List) this.b);
                return;
            case 4:
                au.a((au) this.b);
                return;
            case 5:
                LoadingPopupView loadingPopupView = (LoadingPopupView) this.b;
                if (!loadingPopupView.f1090v) {
                    TransitionManager.beginDelayedTransition(loadingPopupView.f1056p, new TransitionSet().setDuration(loadingPopupView.getAnimationDuration()).addTransition(new MaterialFade()).addTransition(new ChangeBounds()));
                }
                loadingPopupView.getClass();
                com.lxj.xpopup.util.b.o(loadingPopupView.s, false);
                loadingPopupView.getClass();
                com.lxj.xpopup.util.b.o(loadingPopupView.f1088t, true);
                com.lxj.xpopup.util.b.o(loadingPopupView.f1089u, false);
                return;
            case 6:
                ((d0) this.b).e();
                return;
            case 7:
                View view = (View) this.b;
                if (view != null) {
                    view.setPressed(false);
                    return;
                }
                return;
            case 8:
                Process.setThreadPriority(10);
                ((Runnable) this.b).run();
                return;
            case 9:
                i.b bVar = (i.b) this.b;
                bVar.getClass();
                while (true) {
                    try {
                        bVar.c((i.a) ((ReferenceQueue) bVar.c).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            case 10:
                r3.a aVar = (r3.a) this.b;
                t3.b bVar2 = aVar.f3444j;
                if (bVar2 != null) {
                    boolean z3 = aVar.f3443i;
                    s3.a aVar2 = (s3.a) bVar2;
                    aVar2.getClass();
                    if (z3) {
                        GSYVideoGLView.e(aVar2.f3542a, aVar2.b, aVar2.c, aVar2.d, aVar2.f3543e, ((r3.b) aVar).w, aVar.d, aVar, aVar2.f3544f);
                    }
                }
                aVar.f3443i = false;
                return;
            case 11:
                File file = new File((String) this.b);
                Log.d("ImageListActivity", "删除图库filename" + file.getName());
                if (file.exists() && file.isFile()) {
                    file.delete();
                    return;
                }
                return;
            case 12:
                ImageListActivity imageListActivity = (ImageListActivity) this.b;
                imageListActivity.f563h.clear();
                String[] list = new File(imageListActivity.b.b).list();
                if (list == null) {
                    imageListActivity.f565j.sendEmptyMessage(0);
                    return;
                }
                a1.i.u(new StringBuilder("图片张数"), list.length, "ImageListActivity");
                for (int length = list.length - 1; length >= 0; length--) {
                    String str = list[length];
                    if (str.endsWith("jpg")) {
                        String replace = str.replace(".jpg", "");
                        if (!TextUtils.isEmpty(replace)) {
                            if (!Pattern.compile("[0-9]*").matcher(replace).matches()) {
                                StringBuilder sb = new StringBuilder("删除文件");
                                sb.append(imageListActivity.b.b);
                                String str2 = File.separator;
                                sb.append(str2);
                                sb.append(str);
                                Log.d("ImageListActivity", sb.toString());
                                j4.b.u(imageListActivity.b.b + str2 + str);
                            } else {
                                String l5 = com.bumptech.glide.d.l(replace);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(imageListActivity.b.b);
                                imageListActivity.f563h.add(new PhotoInfo(a1.i.k(sb2, File.separator, str), l5, Long.parseLong(replace)));
                            }
                        }
                    }
                }
                Collections.sort(imageListActivity.f563h, new b2.c(3));
                imageListActivity.f565j.sendEmptyMessage(0);
                return;
            case 13:
                MainActivity mainActivity = (MainActivity) this.b;
                int i6 = mainActivity.f600u0 + 1;
                mainActivity.f600u0 = i6;
                int i7 = i6 / 2;
                if (i6 % 2 == 0) {
                    mainActivity.F.setText(String.format("%02d:%02d", Integer.valueOf(i7 / 60), Integer.valueOf(i7 % 60)));
                    mainActivity.f589o.setVisibility(0);
                } else {
                    mainActivity.f589o.setVisibility(4);
                }
                mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                return;
            case 14:
                MainActivityRTSP mainActivityRTSP = (MainActivityRTSP) this.b;
                int i8 = mainActivityRTSP.C0 + 1;
                mainActivityRTSP.C0 = i8;
                int i9 = i8 / 2;
                if (i8 % 2 == 0) {
                    mainActivityRTSP.L.setText(String.format("%02d:%02d", Integer.valueOf(i9 / 60), Integer.valueOf(i9 % 60)));
                    mainActivityRTSP.q.setVisibility(0);
                } else {
                    mainActivityRTSP.q.setVisibility(4);
                }
                MusicInfo musicInfo = mainActivityRTSP.O0;
                if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path) && i9 == mainActivityRTSP.O0.value) {
                    mainActivityRTSP.D.performClick();
                    return;
                } else {
                    mainActivityRTSP.f761g1.postDelayed(mainActivityRTSP.f758f1, 500L);
                    return;
                }
            case 15:
                MusicActivity musicActivity = (MusicActivity) this.b;
                String[] list2 = new File(musicActivity.b.f545e).list();
                if (list2 == null) {
                    musicActivity.f808j.sendEmptyMessage(0);
                    return;
                }
                for (int length2 = list2.length - 1; length2 >= 0; length2 += -1) {
                    String str3 = list2[length2];
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(musicActivity.b.f545e);
                    String k5 = a1.i.k(sb3, File.separator, str3);
                    if (k5 != null && !k5.isEmpty()) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(k5);
                            mediaPlayer.prepare();
                            i5 = mediaPlayer.getDuration();
                        } catch (IOException unused2) {
                            i5 = 0;
                        }
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        i3 = i5 / 1000;
                    } else {
                        i3 = 0;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(musicActivity.b.f545e);
                    MusicInfo musicInfo2 = new MusicInfo(a1.i.k(sb4, File.separator, str3), str3, i3);
                    Log.d("MusicActivity", "音乐" + musicInfo2.toString());
                    musicActivity.f807i.add(musicInfo2);
                }
                musicActivity.f808j.sendEmptyMessage(0);
                return;
            case 16:
                n0 n0Var = (n0) this.b;
                int i10 = n0Var.b[7];
                if (i10 < 0) {
                    i10 += 256;
                }
                Toast.makeText(n0Var.d, "x的方向=" + ((int) n0Var.b[5]) + " y的方向=" + ((int) n0Var.b[6]) + " 灵敏度=" + i10, 0).show();
                byte b = n0Var.b[5];
                if (b == -1) {
                    n0Var.d.Z0.check(2131231274);
                } else if (b == 1) {
                    n0Var.d.Z0.check(2131231275);
                }
                byte b5 = n0Var.b[6];
                if (b5 == -1) {
                    n0Var.d.f817a1.check(2131231276);
                    c = 1;
                } else {
                    c = 1;
                    if (b5 == 1) {
                        n0Var.d.f817a1.check(2131231277);
                    }
                }
                if (i10 >= c && i10 <= 255) {
                    n0Var.d.f819b1.setProgress(i10);
                    return;
                }
                return;
            case 17:
                VideoListActivity videoListActivity = (VideoListActivity) this.b;
                videoListActivity.f881e.clear();
                String[] list3 = new File(videoListActivity.b.c).list();
                if (list3 == null) {
                    videoListActivity.f887k.sendEmptyMessage(0);
                    return;
                }
                a1.i.u(new StringBuilder("处理前视频数"), list3.length, "VideoListActivity");
                for (int length3 = list3.length - 1; length3 >= 0; length3--) {
                    String str4 = list3[length3];
                    StringBuilder o5 = a1.i.o(str4, "大小=");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(videoListActivity.b.c);
                    String str5 = File.separator;
                    sb5.append(str5);
                    sb5.append(str4);
                    o5.append(j4.b.m(sb5.toString()));
                    Log.d("VideoListActivity", o5.toString());
                    if (j4.b.m(videoListActivity.b.c + str5 + str4) <= 500.0f) {
                        Log.d("VideoListActivity", "删除文件" + videoListActivity.b.c + str5 + str4);
                        j4.b.u(videoListActivity.b.c + str5 + str4);
                    } else if (!str4.contains("temp") && str4.endsWith("mp4")) {
                        String replace2 = str4.replace(".mp4", "");
                        if (!TextUtils.isEmpty(replace2)) {
                            if (!Pattern.compile("[0-9]*").matcher(replace2).matches()) {
                                Log.d("VideoListActivity", "删除文件" + videoListActivity.b.c + str5 + str4);
                                j4.b.u(videoListActivity.b.c + str5 + str4);
                            } else {
                                videoListActivity.f881e.add(new EntityVideo(Long.parseLong(replace2), com.bumptech.glide.d.l(replace2), videoListActivity.b.d + str5 + str4.replace(".mp4", ".jpg")));
                                Collections.sort(videoListActivity.f881e, new b2.c(4));
                                if (length3 > 8 && length3 % 4 == 0) {
                                    videoListActivity.f887k.sendEmptyMessage(1);
                                }
                            }
                        }
                    }
                }
                Log.d("VideoListActivity", "处理后视频数" + videoListActivity.f881e.size());
                videoListActivity.f887k.sendEmptyMessage(0);
                return;
            case 18:
                HTrimView hTrimView = (HTrimView) this.b;
                if (hTrimView.d) {
                    hTrimView.a(false);
                } else if (hTrimView.f918k) {
                    hTrimView.a(true);
                }
                hTrimView.c.postDelayed(this, 100L);
                return;
            case 19:
                t2.c cVar = (t2.c) this.b;
                PopupWindow popupWindow = (PopupWindow) ((com.lxj.xpopup.util.e) ((com.tencent.bugly.proguard.d0) cVar.b).c).f1120a;
                if (popupWindow != null && popupWindow.isShowing()) {
                    ((PopupWindow) ((com.lxj.xpopup.util.e) ((com.tencent.bugly.proguard.d0) cVar.b).c).f1120a).dismiss();
                    return;
                }
                return;
            default:
                VTrimView vTrimView = (VTrimView) this.b;
                if (vTrimView.d) {
                    int i11 = vTrimView.f995j;
                    VTrimView vTrimView2 = (VTrimView) this.b;
                    if (i11 > vTrimView2.f993h) {
                        vTrimView2.a(false);
                    }
                } else if (vTrimView.f996k) {
                    int i12 = vTrimView.f995j;
                    VTrimView vTrimView3 = (VTrimView) this.b;
                    if (i12 < vTrimView3.f992g) {
                        vTrimView3.a(true);
                    }
                }
                ((VTrimView) this.b).c.postDelayed(this, 100L);
                return;
        }
    }

    public d(r3.a aVar, String str, int i3) {
        this.f170a = 10;
        this.b = aVar;
    }

    public d(Context context, Object obj) {
        this.f170a = 2;
        this.b = obj;
    }
}
