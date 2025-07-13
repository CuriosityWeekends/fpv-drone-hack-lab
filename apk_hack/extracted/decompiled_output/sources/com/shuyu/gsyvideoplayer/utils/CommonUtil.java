package com.shuyu.gsyvideoplayer.utils;

import a1.i;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.util.Formatter;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CommonUtil {
    public static void deleteFile(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (String str2 : file.list()) {
                StringBuilder l5 = i.l(str);
                l5.append(File.separator);
                l5.append(str2);
                deleteFile(l5.toString());
            }
            file.delete();
        }
    }

    public static int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActionBarHeight(Activity activity) {
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static Activity getActivityContext(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof TintContextWrapper) {
            return scanForActivity(((TintContextWrapper) context).getBaseContext());
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return scanForActivity(((ContextWrapper) context).getBaseContext());
    }

    public static AppCompatActivity getAppCompActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (!(context instanceof ContextThemeWrapper)) {
            return null;
        }
        return getAppCompActivity(((ContextThemeWrapper) context).getBaseContext());
    }

    public static boolean getCurrentScreenLand(Activity activity) {
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 1 || activity.getWindowManager().getDefaultDisplay().getRotation() == 3) {
            return true;
        }
        return false;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getTextSpeed(long j2) {
        if (j2 >= 0 && j2 < 1024) {
            return j2 + " KB/s";
        } else if (j2 >= 1024 && j2 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return Long.toString(j2 / 1024) + " KB/s";
        } else if (j2 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && j2 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return Long.toString(j2 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + " MB/s";
        } else {
            return "";
        }
    }

    public static void hideNavKey(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(3074);
        } else {
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(2562);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static void hideSupportActionBar(Context context, boolean z3, boolean z5) {
        AppCompatActivity appCompActivity;
        ActionBar supportActionBar;
        if (z3 && (appCompActivity = getAppCompActivity(context)) != null && (supportActionBar = appCompActivity.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (z5) {
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).getWindow().setFlags(1024, 1024);
            } else if (context instanceof Activity) {
                ((Activity) context).getWindow().setFlags(1024, 1024);
            } else {
                getAppCompActivity(context).getWindow().setFlags(1024, 1024);
            }
        }
    }

    public static boolean isWifiConnected(Context context) {
        if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            return true;
        }
        return false;
    }

    public static int px2dip(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof TintContextWrapper) {
            return scanForActivity(((TintContextWrapper) context).getBaseContext());
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return scanForActivity(((ContextWrapper) context).getBaseContext());
    }

    public static void showNavKey(Context context, int i3) {
        ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(i3);
    }

    @SuppressLint({"RestrictedApi"})
    public static void showSupportActionBar(Context context, boolean z3, boolean z5) {
        AppCompatActivity appCompActivity;
        ActionBar supportActionBar;
        if (z3 && (appCompActivity = getAppCompActivity(context)) != null && (supportActionBar = appCompActivity.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (z5) {
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).getWindow().clearFlags(1024);
            } else if (context instanceof Activity) {
                ((Activity) context).getWindow().clearFlags(1024);
            } else {
                getAppCompActivity(context).getWindow().clearFlags(1024);
            }
        }
    }

    public static String stringForTime(int i3) {
        if (i3 > 0 && i3 < 86400000) {
            int i5 = i3 / 1000;
            int i6 = i5 % 60;
            int i7 = (i5 / 60) % 60;
            int i8 = i5 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            if (i8 > 0) {
                return formatter.format("%d:%02d:%02d", Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(i6)).toString();
            }
            return formatter.format("%02d:%02d", Integer.valueOf(i7), Integer.valueOf(i6)).toString();
        }
        return "00:00";
    }
}
