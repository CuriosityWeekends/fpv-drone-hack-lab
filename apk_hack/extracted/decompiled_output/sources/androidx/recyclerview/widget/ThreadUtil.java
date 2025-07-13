package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
interface ThreadUtil<T> {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface BackgroundCallback<T> {
        void loadTile(int i3, int i5);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i3);

        void updateRange(int i3, int i5, int i6, int i7, int i8);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface MainThreadCallback<T> {
        void addTile(int i3, TileList.Tile<T> tile);

        void removeTile(int i3, int i5);

        void updateItemCount(int i3, int i5);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
