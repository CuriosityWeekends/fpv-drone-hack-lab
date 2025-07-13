package com.lg.picturesubmitt.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import b3.e;
import b3.k;
import com.lg.picturesubmitt.widget.BorderScrollView;
import h3.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import x2.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ProtocolActivity extends BaseActivity {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f809f = 0;
    public TextView c;
    public BufferedReader d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f810e;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131427380);
        b.f().c(this);
        this.c = (TextView) findViewById(2131231460);
        findViewById(2131230837).setOnClickListener(new k(6, this));
        ((BorderScrollView) findViewById(2131230947)).setOnBorderListener(new e(29, this));
        String country = getResources().getConfiguration().locale.getCountry();
        Log.d("ProtocolActivity", "mPath=" + country);
        if (country.equals("CN")) {
            str = "protocol_ch.txt";
        } else {
            str = "protocol_en.txt";
        }
        try {
            this.d = new BufferedReader(new InputStreamReader(getAssets().open(str)));
            new a(this, this.d).execute(new Object[0]);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        BufferedReader bufferedReader = this.d;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }
}
