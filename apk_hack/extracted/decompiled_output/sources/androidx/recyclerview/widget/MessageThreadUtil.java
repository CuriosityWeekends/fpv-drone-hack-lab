package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;
        final MessageQueue mQueue = new MessageQueue();
        private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
        private Runnable mMainThreadRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem next = AnonymousClass1.this.mQueue.next();
                while (next != null) {
                    int i3 = next.what;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                            } else {
                                AnonymousClass1.this.val$callback.removeTile(next.arg1, next.arg2);
                            }
                        } else {
                            AnonymousClass1.this.val$callback.addTile(next.arg1, (TileList.Tile) next.data);
                        }
                    } else {
                        AnonymousClass1.this.val$callback.updateItemCount(next.arg1, next.arg2);
                    }
                    next = AnonymousClass1.this.mQueue.next();
                }
            }
        };

        public AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.val$callback = mainThreadCallback;
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i3, TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage(2, i3, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i3, int i5) {
            sendMessage(SyncQueueItem.obtainMessage(3, i3, i5));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i3, int i5) {
            sendMessage(SyncQueueItem.obtainMessage(1, i3, i5));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;
        final MessageQueue mQueue = new MessageQueue();
        private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
        AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
        private Runnable mBackgroundRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem next = AnonymousClass2.this.mQueue.next();
                    if (next == null) {
                        AnonymousClass2.this.mBackgroundRunning.set(false);
                        return;
                    }
                    int i3 = next.what;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                                } else {
                                    AnonymousClass2.this.val$callback.recycleTile((TileList.Tile) next.data);
                                }
                            } else {
                                AnonymousClass2.this.val$callback.loadTile(next.arg1, next.arg2);
                            }
                        } else {
                            AnonymousClass2.this.mQueue.removeMessages(2);
                            AnonymousClass2.this.mQueue.removeMessages(3);
                            AnonymousClass2.this.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        }
                    } else {
                        AnonymousClass2.this.mQueue.removeMessages(1);
                        AnonymousClass2.this.val$callback.refresh(next.arg1);
                    }
                }
            }
        };

        public AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.val$callback = backgroundCallback;
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i3, int i5) {
            sendMessage(SyncQueueItem.obtainMessage(3, i3, i5));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i3) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i3, (Object) null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i3, int i5, int i6, int i7, int i8) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i3, i5, i6, i7, i8, null));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class MessageQueue {
        private SyncQueueItem mRoot;

        public synchronized SyncQueueItem next() {
            SyncQueueItem syncQueueItem = this.mRoot;
            if (syncQueueItem == null) {
                return null;
            }
            this.mRoot = syncQueueItem.next;
            return syncQueueItem;
        }

        public synchronized void removeMessages(int i3) {
            SyncQueueItem syncQueueItem;
            while (true) {
                try {
                    syncQueueItem = this.mRoot;
                    if (syncQueueItem == null || syncQueueItem.what != i3) {
                        break;
                    }
                    this.mRoot = syncQueueItem.next;
                    syncQueueItem.recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (syncQueueItem != null) {
                SyncQueueItem syncQueueItem2 = syncQueueItem.next;
                while (syncQueueItem2 != null) {
                    SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                    if (syncQueueItem2.what == i3) {
                        syncQueueItem.next = syncQueueItem3;
                        syncQueueItem2.recycle();
                    } else {
                        syncQueueItem = syncQueueItem2;
                    }
                    syncQueueItem2 = syncQueueItem3;
                }
            }
        }

        public synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            SyncQueueItem syncQueueItem2 = this.mRoot;
            if (syncQueueItem2 == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            while (true) {
                SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                if (syncQueueItem3 != null) {
                    syncQueueItem2 = syncQueueItem3;
                } else {
                    syncQueueItem2.next = syncQueueItem;
                    return;
                }
            }
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        public static SyncQueueItem obtainMessage(int i3, int i5, int i6, int i7, int i8, int i9, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                try {
                    syncQueueItem = sPool;
                    if (syncQueueItem == null) {
                        syncQueueItem = new SyncQueueItem();
                    } else {
                        sPool = syncQueueItem.next;
                        syncQueueItem.next = null;
                    }
                    syncQueueItem.what = i3;
                    syncQueueItem.arg1 = i5;
                    syncQueueItem.arg2 = i6;
                    syncQueueItem.arg3 = i7;
                    syncQueueItem.arg4 = i8;
                    syncQueueItem.arg5 = i9;
                    syncQueueItem.data = obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return syncQueueItem;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                try {
                    SyncQueueItem syncQueueItem = sPool;
                    if (syncQueueItem != null) {
                        this.next = syncQueueItem;
                    }
                    sPool = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static SyncQueueItem obtainMessage(int i3, int i5, int i6) {
            return obtainMessage(i3, i5, i6, 0, 0, 0, null);
        }

        public static SyncQueueItem obtainMessage(int i3, int i5, Object obj) {
            return obtainMessage(i3, i5, 0, 0, 0, 0, obj);
        }
    }
}
