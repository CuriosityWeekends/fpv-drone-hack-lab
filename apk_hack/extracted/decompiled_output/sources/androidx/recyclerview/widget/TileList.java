package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> cls, int i3) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i3));
        }

        public boolean containsPosition(int i3) {
            int i5 = this.mStartPosition;
            if (i5 <= i3 && i3 < i5 + this.mItemCount) {
                return true;
            }
            return false;
        }

        public T getByPosition(int i3) {
            return this.mItems[i3 - this.mStartPosition];
        }
    }

    public TileList(int i3) {
        this.mTileSize = i3;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i3) {
        if (i3 >= 0 && i3 < this.mTiles.size()) {
            return this.mTiles.valueAt(i3);
        }
        return null;
    }

    public T getItemAt(int i3) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i3)) {
            int indexOfKey = this.mTiles.indexOfKey(i3 - (i3 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i3);
    }

    public Tile<T> removeAtPos(int i3) {
        Tile<T> tile = this.mTiles.get(i3);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i3);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
