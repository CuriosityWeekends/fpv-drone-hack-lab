package com.lg.picturesubmitt.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;
import h3.b;
import t2.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ViewPhotoDetailActivity extends BaseActivity {
    public static final /* synthetic */ int c = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427387);
        String stringExtra = getIntent().getStringExtra("Path");
        findViewById(2131231440).setOnClickListener(new a(this, 4));
        PhotoView photoView = (PhotoView) findViewById(2131231244);
        Bitmap decodeFile = BitmapFactory.decodeFile(stringExtra);
        Log.d("ViewPhotoDetailActivity", "bitmap.getWidth()=" + decodeFile.getWidth() + " bitmap.getHeight()=" + decodeFile.getHeight());
        if (decodeFile.getWidth() == 7680) {
            photoView.setImageDrawable(new BitmapDrawable(Bitmap.createScaledBitmap(decodeFile, 3840, 2160, false)));
        } else {
            photoView.setImageURI(Uri.parse(stringExtra));
        }
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        b.f().c(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            b.f().c(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
