package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    @Nullable
    private SnackbarRecord currentSnackbar;
    @Nullable
    private SnackbarRecord nextSnackbar;
    @NonNull
    private final Object lock = new Object();
    @NonNull
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.handleTimeout((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Callback {
        void dismiss(int i3);

        void show();
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SnackbarRecord {
        @NonNull
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        public SnackbarRecord(int i3, Callback callback) {
            this.callback = new WeakReference<>(callback);
            this.duration = i3;
        }

        public boolean isSnackbar(@Nullable Callback callback) {
            if (callback != null && this.callback.get() == callback) {
                return true;
            }
            return false;
        }
    }

    private SnackbarManager() {
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord snackbarRecord, int i3) {
        Callback callback = snackbarRecord.callback.get();
        if (callback != null) {
            this.handler.removeCallbacksAndMessages(snackbarRecord);
            callback.dismiss(i3);
            return true;
        }
        return false;
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        if (snackbarRecord != null && snackbarRecord.isSnackbar(callback)) {
            return true;
        }
        return false;
    }

    private boolean isNextSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null && snackbarRecord.isSnackbar(callback)) {
            return true;
        }
        return false;
    }

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord snackbarRecord) {
        int i3 = snackbarRecord.duration;
        if (i3 == -2) {
            return;
        }
        if (i3 <= 0) {
            if (i3 == -1) {
                i3 = SHORT_DURATION_MS;
            } else {
                i3 = LONG_DURATION_MS;
            }
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.handler;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i3);
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    public void dismiss(Callback callback, int i3) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.currentSnackbar, i3);
                } else if (isNextSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.nextSnackbar, i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void handleTimeout(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            try {
                if (this.currentSnackbar != snackbarRecord) {
                    if (this.nextSnackbar == snackbarRecord) {
                    }
                }
                cancelSnackbarLocked(snackbarRecord, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isCurrent(Callback callback) {
        boolean isCurrentSnackbarLocked;
        synchronized (this.lock) {
            isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    public boolean isCurrentOrNext(Callback callback) {
        boolean z3;
        synchronized (this.lock) {
            try {
                if (!isCurrentSnackbarLocked(callback) && !isNextSnackbarLocked(callback)) {
                    z3 = false;
                }
                z3 = true;
            } finally {
            }
        }
        return z3;
    }

    public void onDismissed(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    this.currentSnackbar = null;
                    if (this.nextSnackbar != null) {
                        showNextSnackbarLocked();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onShown(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    scheduleTimeoutLocked(this.currentSnackbar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void pauseTimeout(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (!snackbarRecord.paused) {
                        snackbarRecord.paused = true;
                        this.handler.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void restoreTimeoutIfPaused(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (snackbarRecord.paused) {
                        snackbarRecord.paused = false;
                        scheduleTimeoutLocked(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void show(int i3, Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    snackbarRecord.duration = i3;
                    this.handler.removeCallbacksAndMessages(snackbarRecord);
                    scheduleTimeoutLocked(this.currentSnackbar);
                    return;
                }
                if (isNextSnackbarLocked(callback)) {
                    this.nextSnackbar.duration = i3;
                } else {
                    this.nextSnackbar = new SnackbarRecord(i3, callback);
                }
                SnackbarRecord snackbarRecord2 = this.currentSnackbar;
                if (snackbarRecord2 != null && cancelSnackbarLocked(snackbarRecord2, 4)) {
                    return;
                }
                this.currentSnackbar = null;
                showNextSnackbarLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
