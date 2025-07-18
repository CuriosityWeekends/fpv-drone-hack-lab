package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int INVALID_ITEM_POSITION = -1;
    @Nullable
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;
    @Nullable
    private ColorStateList iconTint;
    private boolean isShifting;
    @Nullable
    private MenuItemImpl itemData;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    @Nullable
    private Drawable wrappedIconDrawable;

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.itemPosition = -1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.icon = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.defaultMargin = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    if (NavigationBarItemView.this.icon.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.tryUpdateBadgeBounds(navigationBarItemView.icon);
                    }
                }
            });
        }
    }

    private void calculateTextScaleFactors(float f4, float f5) {
        this.shiftAmount = f4 - f5;
        this.scaleUpFactor = (f5 * 1.0f) / f4;
        this.scaleDownFactor = (f4 * 1.0f) / f5;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View view) {
        ImageView imageView = this.icon;
        if (view != imageView || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i3 = 0;
        for (int i5 = 0; i5 < indexOfChild; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i3++;
            }
        }
        return i3;
    }

    private int getSuggestedIconHeight() {
        int i3;
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null) {
            i3 = badgeDrawable.getMinimumHeight() / 2;
        } else {
            i3 = 0;
        }
        return this.icon.getMeasuredWidth() + Math.max(i3, ((FrameLayout.LayoutParams) this.icon.getLayoutParams()).topMargin) + i3;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = badgeDrawable.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        int max = Math.max(minimumWidth, layoutParams.leftMargin);
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.icon.getMeasuredWidth() + max;
    }

    private boolean hasBadge() {
        if (this.badgeDrawable != null) {
            return true;
        }
        return false;
    }

    private static void setViewLayoutParams(@NonNull View view, int i3, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        layoutParams.gravity = i5;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(@NonNull View view, float f4, float f5, int i3) {
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setVisibility(i3);
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View view) {
        if (!hasBadge()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
        }
        this.badgeDrawable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (!hasBadge()) {
            return;
        }
        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
    }

    private static void updateViewPaddingBottom(@NonNull View view, int i3) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return this.labelGroup.getMeasuredHeight() + getSuggestedIconHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), this.labelGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i3) {
        CharSequence title;
        int i5;
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, title);
        }
        if (menuItemImpl.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.badgeDrawable = badgeDrawable;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z3) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z3) {
        TextView textView = this.largeLabel;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.largeLabel;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.smallLabel;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.smallLabel;
        textView4.setPivotY(textView4.getBaseline());
        int i3 = this.labelVisibilityMode;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        setViewLayoutParams(this.icon, this.defaultMargin, 17);
                        this.largeLabel.setVisibility(8);
                        this.smallLabel.setVisibility(8);
                    }
                } else {
                    ViewGroup viewGroup = this.labelGroup;
                    updateViewPaddingBottom(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    if (z3) {
                        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                        TextView textView5 = this.smallLabel;
                        float f4 = this.scaleUpFactor;
                        setViewScaleValues(textView5, f4, f4, 4);
                    } else {
                        setViewLayoutParams(this.icon, this.defaultMargin, 49);
                        TextView textView6 = this.largeLabel;
                        float f5 = this.scaleDownFactor;
                        setViewScaleValues(textView6, f5, f5, 4);
                        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                    }
                }
            } else {
                if (z3) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    ViewGroup viewGroup2 = this.labelGroup;
                    updateViewPaddingBottom(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            }
        } else if (this.isShifting) {
            if (z3) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                ViewGroup viewGroup3 = this.labelGroup;
                updateViewPaddingBottom(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.largeLabel.setVisibility(0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.labelGroup;
            updateViewPaddingBottom(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z3) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f6 = this.scaleUpFactor;
                setViewScaleValues(textView7, f6, f6, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView8 = this.largeLabel;
                float f7 = this.scaleDownFactor;
                setViewScaleValues(textView8, f7, f7, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z3);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.smallLabel.setEnabled(z3);
        this.largeLabel.setEnabled(z3);
        this.icon.setEnabled(z3);
        if (z3) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i3) {
        setItemBackground(i3 == 0 ? null : ContextCompat.getDrawable(getContext(), i3));
    }

    public void setItemPosition(int i3) {
        this.itemPosition = i3;
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.labelVisibilityMode != i3) {
            this.labelVisibilityMode = i3;
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z3) {
        if (this.isShifting != z3) {
            this.isShifting = z3;
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z3, char c) {
    }

    public void setTextAppearanceActive(@StyleRes int i3) {
        TextViewCompat.setTextAppearance(this.largeLabel, i3);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i3) {
        TextViewCompat.setTextAppearance(this.smallLabel, i3);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}
