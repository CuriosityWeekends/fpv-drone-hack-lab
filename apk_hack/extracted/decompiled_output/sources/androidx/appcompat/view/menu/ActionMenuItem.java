package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ActionMenuItem implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private final int mGroup;
    private Drawable mIconDrawable;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;
    private int mShortcutNumericModifiers = 4096;
    private int mShortcutAlphabeticModifiers = 4096;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private int mFlags = 16;

    public ActionMenuItem(Context context, int i3, int i5, int i6, int i7, CharSequence charSequence) {
        this.mContext = context;
        this.mId = i5;
        this.mGroup = i3;
        this.mOrdering = i7;
        this.mTitle = charSequence;
    }

    private void applyIconTint() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            if (this.mHasIconTint || this.mHasIconTintMode) {
                Drawable wrap = DrawableCompat.wrap(drawable);
                this.mIconDrawable = wrap;
                Drawable mutate = wrap.mutate();
                this.mIconDrawable = mutate;
                if (this.mHasIconTint) {
                    DrawableCompat.setTintList(mutate, this.mIconTintList);
                }
                if (this.mHasIconTintMode) {
                    DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mIconDrawable;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            return this.mTitle;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            this.mContext.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.mFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.mFlags & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        this.mFlags = (z3 ? 1 : 0) | (this.mFlags & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        int i3;
        int i5 = this.mFlags & (-3);
        if (z3) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        this.mFlags = i3 | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        int i3;
        int i5 = this.mFlags & (-17);
        if (z3) {
            i3 = 16;
        } else {
            i3 = 0;
        }
        this.mFlags = i3 | i5;
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z3) {
        int i3;
        int i5 = this.mFlags & (-5);
        if (z3) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        this.mFlags = i3 | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.mShortcutNumericChar = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c5) {
        this.mShortcutNumericChar = c;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c5);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i3) {
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        int i3 = 8;
        int i5 = this.mFlags & 8;
        if (z3) {
            i3 = 0;
        }
        this.mFlags = i5 | i3;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i3) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i3) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.mTitle = this.mContext.getResources().getString(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, i3);
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c5, int i3, int i5) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c5);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i3) {
        throw new UnsupportedOperationException();
    }
}
