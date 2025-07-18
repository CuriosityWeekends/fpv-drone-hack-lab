package androidx.core.os;

import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            try {
                if (this.mIsCanceled) {
                    return;
                }
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                OnCancelListener onCancelListener = this.mOnCancelListener;
                Object obj = this.mCancellationSignalObj;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.mCancelInProgress = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((android.os.CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.mCancelInProgress = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        Object obj;
        synchronized (this) {
            try {
                if (this.mCancellationSignalObj == null) {
                    android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                    this.mCancellationSignalObj = cancellationSignal;
                    if (this.mIsCanceled) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.mCancellationSignalObj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z3;
        synchronized (this) {
            z3 = this.mIsCanceled;
        }
        return z3;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener == onCancelListener) {
                    return;
                }
                this.mOnCancelListener = onCancelListener;
                if (this.mIsCanceled && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            } finally {
            }
        }
    }

    public void throwIfCanceled() {
        if (!isCanceled()) {
            return;
        }
        throw new OperationCanceledException();
    }
}
