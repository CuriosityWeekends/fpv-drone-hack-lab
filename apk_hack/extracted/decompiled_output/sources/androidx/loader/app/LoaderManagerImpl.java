package androidx.loader.app;

import a1.i;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    @NonNull
    private final LifecycleOwner mLifecycleOwner;
    @NonNull
    private final LoaderViewModel mLoaderViewModel;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        @Nullable
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        @NonNull
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        public LoaderInfo(int i3, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.mId = i3;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            loader.registerListener(i3, this);
        }

        @MainThread
        public Loader<D> destroy(boolean z3) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z3) {
                    loaderObserver.reset();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((loaderObserver != null && !loaderObserver.hasDeliveredData()) || z3) {
                this.mLoader.reset();
                return this.mPriorLoader;
            }
            return this.mLoader;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            this.mLoader.dump(i.h(str, "  "), fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                this.mObserver.dump(i.h(str, "  "), printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @NonNull
        public Loader<D> getLoader() {
            return this.mLoader;
        }

        public boolean isCallbackWaitingForData() {
            LoaderObserver<D> loaderObserver;
            if (!hasActiveObservers() || (loaderObserver = this.mObserver) == null || loaderObserver.hasDeliveredData()) {
                return false;
            }
            return true;
        }

        public void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
            }
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.mLoader.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v(LoaderManagerImpl.TAG, "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (LoaderManagerImpl.DEBUG) {
                Log.w(LoaderManagerImpl.TAG, "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @NonNull
        @MainThread
        public Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.mObserver;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class LoaderObserver<D> implements Observer<D> {
        @NonNull
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;
        @NonNull
        private final Loader<D> mLoader;

        public LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        public boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D d) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(d));
            }
            this.mCallback.onLoadFinished(this.mLoader, d);
            this.mDeliveredData = true;
        }

        @MainThread
        public void reset() {
            if (this.mDeliveredData) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v(LoaderManagerImpl.TAG, "  Resetting: " + this.mLoader);
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();
        private boolean mCreatingLoader = false;

        @NonNull
        public static LoaderViewModel getInstance(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i3 = 0; i3 < this.mLoaders.size(); i3++) {
                    LoaderInfo valueAt = this.mLoaders.valueAt(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i3));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        public <D> LoaderInfo<D> getLoader(int i3) {
            return this.mLoaders.get(i3);
        }

        public boolean hasRunningLoaders() {
            int size = this.mLoaders.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mLoaders.valueAt(i3).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        public void markForRedelivery() {
            int size = this.mLoaders.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mLoaders.valueAt(i3).markForRedelivery();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mLoaders.valueAt(i3).destroy(true);
            }
            this.mLoaders.clear();
        }

        public void putLoader(int i3, @NonNull LoaderInfo loaderInfo) {
            this.mLoaders.put(i3, loaderInfo);
        }

        public void removeLoader(int i3) {
            this.mLoaders.remove(i3);
        }

        public void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    public LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance(viewModelStore);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> createAndInstallLoader(int i3, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.mLoaderViewModel.startCreatingLoader();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i3, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                }
                LoaderInfo loaderInfo = new LoaderInfo(i3, bundle, onCreateLoader, loader);
                if (DEBUG) {
                    Log.v(TAG, "  Created new loader " + loaderInfo);
                }
                this.mLoaderViewModel.putLoader(i3, loaderInfo);
                this.mLoaderViewModel.finishCreatingLoader();
                return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.mLoaderViewModel.finishCreatingLoader();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int i3) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (DEBUG) {
                    Log.v(TAG, "destroyLoader in " + this + " of " + i3);
                }
                LoaderInfo loader = this.mLoaderViewModel.getLoader(i3);
                if (loader != null) {
                    loader.destroy(true);
                    this.mLoaderViewModel.removeLoader(i3);
                    return;
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int i3) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i3);
            if (loader != null) {
                return loader.getLoader();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int i3, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i3);
                if (DEBUG) {
                    Log.v(TAG, "initLoader in " + this + ": args=" + bundle);
                }
                if (loader == null) {
                    return createAndInstallLoader(i3, bundle, loaderCallbacks, null);
                }
                if (DEBUG) {
                    Log.v(TAG, "  Re-using existing loader " + loader);
                }
                return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int i3, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        Loader<D> loader;
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (DEBUG) {
                    Log.v(TAG, "restartLoader in " + this + ": args=" + bundle);
                }
                LoaderInfo<D> loader2 = this.mLoaderViewModel.getLoader(i3);
                if (loader2 != null) {
                    loader = loader2.destroy(false);
                } else {
                    loader = null;
                }
                return createAndInstallLoader(i3, bundle, loaderCallbacks, loader);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
