package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final Context mContext;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;
    private final List<MenuBuilder> mPendingMenus = new ArrayList();
    final List<CascadingMenuInfo> mShowingMenus = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !CascadingMenuPopup.this.mShowingMenus.get(0).window.isModal()) {
                View view = CascadingMenuPopup.this.mShownAnchorView;
                if (view != null && view.isShown()) {
                    for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.mShowingMenus) {
                        cascadingMenuInfo.window.show();
                    }
                    return;
                }
                CascadingMenuPopup.this.dismiss();
            }
        }
    };
    private final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.mShowingMenus.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (menuBuilder == CascadingMenuPopup.this.mShowingMenus.get(i3).menu) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                return;
            }
            int i5 = i3 + 1;
            if (i5 < CascadingMenuPopup.this.mShowingMenus.size()) {
                cascadingMenuInfo = CascadingMenuPopup.this.mShowingMenus.get(i5);
            }
            CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        CascadingMenuPopup.this.mShouldCloseImmediately = true;
                        cascadingMenuInfo2.menu.close(false);
                        CascadingMenuPopup.this.mShouldCloseImmediately = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private int mRawDropDownGravity = 0;
    private int mDropDownGravity = 0;
    private boolean mForceShowIcon = false;
    private int mLastPosition = getInitialMenuPosition();

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i3) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i3;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i3, @StyleRes int i5, boolean z3) {
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i3;
        this.mPopupStyleRes = i5;
        this.mOverflowOnly = z3;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.mAnchorView);
        menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(@NonNull MenuBuilder menuBuilder) {
        int size = this.mShowingMenus.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (menuBuilder == this.mShowingMenus.get(i3).menu) {
                return i3;
            }
        }
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menuBuilder.getItem(i3);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View findParentViewForSubmenu(@NonNull CascadingMenuInfo cascadingMenuInfo, @NonNull MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i3;
        int firstVisiblePosition;
        MenuItem findMenuItemForSubmenu = findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder);
        if (findMenuItemForSubmenu == null) {
            return null;
        }
        ListView listView = cascadingMenuInfo.getListView();
        ListAdapter adapter = listView.getAdapter();
        int i5 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i3 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i3 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i5 < count) {
                if (findMenuItemForSubmenu == menuAdapter.getItem(i5)) {
                    break;
                }
                i5++;
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 == -1 || (firstVisiblePosition = (i5 + i3) - listView.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(firstVisiblePosition);
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) {
            return 1;
        }
        return 0;
    }

    private int getNextMenuPosition(int i3) {
        List<CascadingMenuInfo> list = this.mShowingMenus;
        ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
        if (this.mLastPosition == 1) {
            if (listView.getWidth() + iArr[0] + i3 <= rect.right) {
                return 1;
            }
            return 0;
        } else if (iArr[0] - i3 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void showMenu(@NonNull MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View view;
        boolean z3;
        int i3;
        int i5;
        int width;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.mOverflowOnly, ITEM_LAYOUT);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(menuBuilder));
        }
        int measureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow createPopupWindow = createPopupWindow();
        createPopupWindow.setAdapter(menuAdapter);
        createPopupWindow.setContentWidth(measureIndividualMenuWidth);
        createPopupWindow.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() > 0) {
            List<CascadingMenuInfo> list = this.mShowingMenus;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = findParentViewForSubmenu(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            createPopupWindow.setTouchModal(false);
            createPopupWindow.setEnterTransition(null);
            int nextMenuPosition = getNextMenuPosition(measureIndividualMenuWidth);
            if (nextMenuPosition == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mLastPosition = nextMenuPosition;
            if (Build.VERSION.SDK_INT >= 26) {
                createPopupWindow.setAnchorView(view);
                i5 = 0;
                i3 = 0;
            } else {
                int[] iArr = new int[2];
                this.mAnchorView.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.mDropDownGravity & 7) == 5) {
                    iArr[0] = this.mAnchorView.getWidth() + iArr[0];
                    iArr2[0] = view.getWidth() + iArr2[0];
                }
                i3 = iArr2[0] - iArr[0];
                i5 = iArr2[1] - iArr[1];
            }
            if ((this.mDropDownGravity & 5) == 5) {
                if (z3) {
                    width = i3 + measureIndividualMenuWidth;
                    createPopupWindow.setHorizontalOffset(width);
                    createPopupWindow.setOverlapAnchor(true);
                    createPopupWindow.setVerticalOffset(i5);
                } else {
                    measureIndividualMenuWidth = view.getWidth();
                    width = i3 - measureIndividualMenuWidth;
                    createPopupWindow.setHorizontalOffset(width);
                    createPopupWindow.setOverlapAnchor(true);
                    createPopupWindow.setVerticalOffset(i5);
                }
            } else {
                if (z3) {
                    width = i3 + view.getWidth();
                    createPopupWindow.setHorizontalOffset(width);
                    createPopupWindow.setOverlapAnchor(true);
                    createPopupWindow.setVerticalOffset(i5);
                }
                width = i3 - measureIndividualMenuWidth;
                createPopupWindow.setHorizontalOffset(width);
                createPopupWindow.setOverlapAnchor(true);
                createPopupWindow.setVerticalOffset(i5);
            }
        } else {
            if (this.mHasXOffset) {
                createPopupWindow.setHorizontalOffset(this.mXOffset);
            }
            if (this.mHasYOffset) {
                createPopupWindow.setVerticalOffset(this.mYOffset);
            }
            createPopupWindow.setEpicenterBounds(getEpicenterBounds());
        }
        this.mShowingMenus.add(new CascadingMenuInfo(createPopupWindow, menuBuilder, this.mLastPosition));
        createPopupWindow.show();
        ListView listView = createPopupWindow.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            createPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.mShowingMenus.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i3];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.mShowingMenus;
        return list.get(list.size() - 1).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() <= 0 || !this.mShowingMenus.get(0).window.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        int findIndexOfAddedMenu = findIndexOfAddedMenu(menuBuilder);
        if (findIndexOfAddedMenu < 0) {
            return;
        }
        int i3 = findIndexOfAddedMenu + 1;
        if (i3 < this.mShowingMenus.size()) {
            this.mShowingMenus.get(i3).menu.close(false);
        }
        CascadingMenuInfo remove = this.mShowingMenus.remove(findIndexOfAddedMenu);
        remove.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately) {
            remove.window.setExitTransition(null);
            remove.window.setAnimationStyle(0);
        }
        remove.window.dismiss();
        int size = this.mShowingMenus.size();
        if (size > 0) {
            this.mLastPosition = this.mShowingMenus.get(size - 1).position;
        } else {
            this.mLastPosition = getInitialMenuPosition();
        }
        if (size == 0) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, true);
            }
            ViewTreeObserver viewTreeObserver = this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                }
                this.mTreeObserver = null;
            }
            this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
            this.mOnDismissListener.onDismiss();
        } else if (z3) {
            this.mShowingMenus.get(0).menu.close(false);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.mShowingMenus.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                cascadingMenuInfo = this.mShowingMenus.get(i3);
                if (!cascadingMenuInfo.window.isShowing()) {
                    break;
                }
                i3++;
            } else {
                cascadingMenuInfo = null;
                break;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i3 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.getListView().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            addMenu(subMenuBuilder);
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onOpenSubMenu(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@NonNull View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z3) {
        this.mForceShowIcon = z3;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i3) {
        if (this.mRawDropDownGravity != i3) {
            this.mRawDropDownGravity = i3;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i3) {
        this.mHasXOffset = true;
        this.mXOffset = i3;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z3) {
        this.mShowTitle = z3;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i3) {
        this.mHasYOffset = true;
        this.mYOffset = i3;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        boolean z3;
        if (isShowing()) {
            return;
        }
        for (MenuBuilder menuBuilder : this.mPendingMenus) {
            showMenu(menuBuilder);
        }
        this.mPendingMenus.clear();
        View view = this.mAnchorView;
        this.mShownAnchorView = view;
        if (view != null) {
            if (this.mTreeObserver == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z3) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z3) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            MenuPopup.toMenuAdapter(cascadingMenuInfo.getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
