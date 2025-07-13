package com.lxj.xpopup.core;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.util.XPermission$PermissionActivity;
import com.lxj.xpopup.util.b;
import com.lxj.xpopup.util.e;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import e3.c;
import java.util.ArrayList;
import java.util.LinkedHashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ImageViewerPopupView extends BasePopupView implements c, View.OnClickListener {
    public final View A;
    public final int B;

    /* renamed from: p  reason: collision with root package name */
    public final FrameLayout f1062p;
    public PhotoViewContainer q;

    /* renamed from: r  reason: collision with root package name */
    public BlankView f1063r;
    public TextView s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f1064t;

    /* renamed from: u  reason: collision with root package name */
    public HackyViewPager f1065u;

    /* renamed from: v  reason: collision with root package name */
    public final ArgbEvaluator f1066v;
    public final ArrayList w;

    /* renamed from: x  reason: collision with root package name */
    public int f1067x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f1068y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f1069z;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class PhotoViewAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
        public PhotoViewAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.getClass();
            return imageViewerPopupView.w.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup viewGroup, int i3) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.getClass();
            new FrameLayout(viewGroup.getContext()).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
            progressBar.setIndeterminate(true);
            int d = b.d(imageViewerPopupView.f1062p.getContext(), 40.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d, d);
            layoutParams.gravity = 17;
            progressBar.setLayoutParams(layoutParams);
            progressBar.setVisibility(8);
            imageViewerPopupView.w.get(i3);
            throw null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i3, float f4, int i5) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i3) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.f1067x = i3;
            imageViewerPopupView.p();
            imageViewerPopupView.getClass();
        }
    }

    public ImageViewerPopupView(@NonNull Context context) {
        super(context);
        this.f1066v = new ArgbEvaluator();
        this.w = new ArrayList();
        Color.parseColor("#f1f1f1");
        this.f1068y = true;
        this.f1069z = true;
        this.B = Color.rgb(32, 36, 46);
        FrameLayout frameLayout = (FrameLayout) findViewById(z2.b.container);
        this.f1062p = frameLayout;
        if (getImplLayoutId() > 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) frameLayout, false);
            this.A = inflate;
            inflate.setVisibility(4);
            inflate.setAlpha(0.0f);
            frameLayout.addView(inflate);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void a() {
        super.a();
        HackyViewPager hackyViewPager = this.f1065u;
        hackyViewPager.removeOnPageChangeListener((PhotoViewAdapter) hackyViewPager.getAdapter());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void b() {
        if (this.f1035e != 1) {
            return;
        }
        this.f1035e = 4;
        e();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void e() {
        this.q.setBackgroundColor(0);
        c();
        this.f1065u.setVisibility(4);
        this.f1063r.setVisibility(4);
        View view = this.A;
        if (view != null) {
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void g() {
        this.q.setBackgroundColor(this.B);
        this.f1065u.setVisibility(0);
        p();
        this.q.isReleasing = false;
        d();
        View view = this.A;
        if (view != null) {
            view.setAlpha(1.0f);
            view.setVisibility(0);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return z2.c._xpopup_image_viewer_popup_view;
    }

    public int getRealPosition() {
        return this.f1067x;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        this.s = (TextView) findViewById(z2.b.tv_pager_indicator);
        this.f1064t = (TextView) findViewById(z2.b.tv_save);
        this.f1063r = (BlankView) findViewById(z2.b.placeholderView);
        PhotoViewContainer photoViewContainer = (PhotoViewContainer) findViewById(z2.b.photoViewContainer);
        this.q = photoViewContainer;
        photoViewContainer.setOnDragChangeListener(this);
        this.f1065u = (HackyViewPager) findViewById(z2.b.pager);
        PhotoViewAdapter photoViewAdapter = new PhotoViewAdapter();
        this.f1065u.setAdapter(photoViewAdapter);
        this.f1065u.setCurrentItem(this.f1067x);
        this.f1065u.setVisibility(4);
        this.f1065u.setOffscreenPageLimit(2);
        this.f1065u.addOnPageChangeListener(photoViewAdapter);
        if (!this.f1069z) {
            this.s.setVisibility(8);
        }
        if (!this.f1068y) {
            this.f1064t.setVisibility(8);
        } else {
            this.f1064t.setOnClickListener(this);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void l() {
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.lxj.xpopup.util.e, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e eVar;
        if (view == this.f1064t) {
            Context context = getContext();
            String[] strArr = {"STORAGE"};
            e eVar2 = e.f1117i;
            if (eVar2 == null) {
                ?? obj = new Object();
                e.f1117i = obj;
                obj.f1120a = context;
                obj.c(strArr);
                eVar = obj;
            } else {
                eVar2.f1120a = context;
                eVar2.c(strArr);
                eVar = e.f1117i;
            }
            eVar.b = new b3.e(1, this);
            eVar.f1121e = new ArrayList();
            eVar.d = new ArrayList();
            if (Build.VERSION.SDK_INT < 23) {
                ((ArrayList) eVar.f1121e).addAll((LinkedHashSet) eVar.c);
                eVar.d();
                return;
            }
            for (String str : (LinkedHashSet) eVar.c) {
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission((Context) eVar.f1120a, str) != 0) {
                    ((ArrayList) eVar.d).add(str);
                } else {
                    ((ArrayList) eVar.f1121e).add(str);
                }
            }
            if (((ArrayList) eVar.d).isEmpty()) {
                eVar.d();
                return;
            }
            eVar.f1122f = new ArrayList();
            eVar.f1123g = new ArrayList();
            Context context2 = (Context) eVar.f1120a;
            int i3 = XPermission$PermissionActivity.f1094a;
            Intent intent = new Intent(context2, XPermission$PermissionActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("TYPE", 1);
            context2.startActivity(intent);
        }
    }

    public final void p() {
        ArrayList arrayList = this.w;
        if (arrayList.size() > 1) {
            int realPosition = getRealPosition();
            TextView textView = this.s;
            textView.setText((realPosition + 1) + "/" + arrayList.size());
        }
        if (this.f1068y) {
            this.f1064t.setVisibility(0);
        }
    }
}
