package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i3, i5, i6, componentName, intentArr, intent, i7, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = getMenuItemWrapper(menuItemArr2[i8]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i3));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i3));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i3, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i5) {
        return this.mWrappedObject.performIdentifierAction(i3, i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i5) {
        return this.mWrappedObject.performShortcut(i3, keyEvent, i5);
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        internalRemoveGroup(i3);
        this.mWrappedObject.removeGroup(i3);
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        internalRemoveItem(i3);
        this.mWrappedObject.removeItem(i3);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z3, boolean z5) {
        this.mWrappedObject.setGroupCheckable(i3, z3, z5);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z3) {
        this.mWrappedObject.setGroupEnabled(i3, z3);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z3) {
        this.mWrappedObject.setGroupVisible(i3, z3);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.mWrappedObject.setQwertyMode(z3);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i5, int i6, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i5, int i6, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i5, int i6, int i7) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3, i5, i6, i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i5, int i6, int i7) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3, i5, i6, i7));
    }
}
