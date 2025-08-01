package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;
    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;
    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface DisplayOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface NavigationMode {
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z3);
    }

    @Deprecated
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i3, long j2);
    }

    @Deprecated
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(@StringRes int i3);

        public abstract Tab setContentDescription(CharSequence charSequence);

        public abstract Tab setCustomView(int i3);

        public abstract Tab setCustomView(View view);

        public abstract Tab setIcon(@DrawableRes int i3);

        public abstract Tab setIcon(Drawable drawable);

        public abstract Tab setTabListener(TabListener tabListener);

        public abstract Tab setTag(Object obj);

        public abstract Tab setText(int i3);

        public abstract Tab setText(CharSequence charSequence);
    }

    @Deprecated
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface TabListener {
        void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction);

        void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction);

        void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction);
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    @Deprecated
    public abstract void addTab(Tab tab);

    @Deprecated
    public abstract void addTab(Tab tab, int i3);

    @Deprecated
    public abstract void addTab(Tab tab, int i3, boolean z3);

    @Deprecated
    public abstract void addTab(Tab tab, boolean z3);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean closeOptionsMenu() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean collapseActionView() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchMenuVisibilityChanged(boolean z3) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Nullable
    @Deprecated
    public abstract Tab getSelectedTab();

    @Nullable
    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int i3);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    @Nullable
    public abstract CharSequence getTitle();

    public abstract void hide();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    @Deprecated
    public abstract void removeTab(Tab tab);

    @Deprecated
    public abstract void removeTabAt(int i3);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab tab);

    public abstract void setBackgroundDrawable(@Nullable Drawable drawable);

    public abstract void setCustomView(int i3);

    public abstract void setCustomView(View view);

    public abstract void setCustomView(View view, LayoutParams layoutParams);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDefaultDisplayHomeAsUpEnabled(boolean z3) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean z3);

    public abstract void setDisplayOptions(int i3);

    public abstract void setDisplayOptions(int i3, int i5);

    public abstract void setDisplayShowCustomEnabled(boolean z3);

    public abstract void setDisplayShowHomeEnabled(boolean z3);

    public abstract void setDisplayShowTitleEnabled(boolean z3);

    public abstract void setDisplayUseLogoEnabled(boolean z3);

    public void setElevation(float f4) {
        if (f4 == 0.0f) {
            return;
        }
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int i3) {
        if (i3 == 0) {
            return;
        }
        throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean z3) {
        if (!z3) {
            return;
        }
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setHomeActionContentDescription(@StringRes int i3) {
    }

    public void setHomeAsUpIndicator(@DrawableRes int i3) {
    }

    public void setHomeButtonEnabled(boolean z3) {
    }

    public abstract void setIcon(@DrawableRes int i3);

    public abstract void setIcon(Drawable drawable);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener);

    public abstract void setLogo(@DrawableRes int i3);

    public abstract void setLogo(Drawable drawable);

    @Deprecated
    public abstract void setNavigationMode(int i3);

    @Deprecated
    public abstract void setSelectedNavigationItem(int i3);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setShowHideAnimationEnabled(boolean z3) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public abstract void setSubtitle(int i3);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(@StringRes int i3);

    public abstract void setTitle(CharSequence charSequence);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setWindowTitle(CharSequence charSequence) {
    }

    public abstract void show();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setHomeActionContentDescription(@Nullable CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(@Nullable Drawable drawable) {
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i5) {
            super(i3, i5);
            this.gravity = 8388627;
        }

        public LayoutParams(int i3, int i5, int i6) {
            super(i3, i5);
            this.gravity = i6;
        }

        public LayoutParams(int i3) {
            this(-2, -1, i3);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }
}
