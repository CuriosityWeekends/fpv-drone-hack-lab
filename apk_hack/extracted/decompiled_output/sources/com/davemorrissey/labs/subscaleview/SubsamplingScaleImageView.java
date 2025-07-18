package com.davemorrissey.labs.subscaleview;

import a1.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, Integer.valueOf((int) ORIENTATION_180), Integer.valueOf((int) ORIENTATION_270), -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3, 4);

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z3) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z3;
        }

        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                    }
                } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    if (this.preview) {
                        subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                    } else {
                        subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                    }
                }
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF pointF, int i3) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f4, int i3) {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i3);

        void onScaleChanged(float f4, int i3);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        private ScaleAndTranslate(float f4, PointF pointF) {
            this.scale = f4;
            this.vTranslate = pointF;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile != null) {
                        tile.loading = false;
                        return null;
                    }
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                if (imageRegionDecoder.isReady()) {
                    subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return decodeRegion;
                }
                tile.loading = false;
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                return null;
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
            } else {
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder make = decoderFactory.make();
                this.decoder = make;
                Point init = make.init(context, this.source);
                int i3 = init.x;
                int i5 = init.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i3, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i5, subsamplingScaleImageView.sRegion.bottom);
                    i3 = subsamplingScaleImageView.sRegion.width();
                    i5 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i3, i5, exifOrientation};
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e5);
                this.exception = e5;
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            int i3 = R.styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i3) && (string = obtainStyledAttributes.getString(i3)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            int i5 = R.styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            int i6 = R.styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i6)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = R.styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i7)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i7, true));
            }
            int i8 = R.styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i8)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i8, true));
            }
            int i9 = R.styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i9)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i9, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f4) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f4 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f4);
        int sHeight = (int) (sHeight() * f4);
        if (sWidth != 0 && sHeight != 0) {
            int i3 = 1;
            if (sHeight() <= sHeight && sWidth() <= sWidth) {
                round = 1;
            } else {
                round = Math.round(sHeight() / sHeight);
                int round2 = Math.round(sWidth() / sWidth);
                if (round >= round2) {
                    round = round2;
                }
            }
            while (true) {
                int i5 = i3 * 2;
                if (i5 < round) {
                    i3 = i5;
                } else {
                    return i3;
                }
            }
        } else {
            return 32;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z3;
        if (getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady())) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!this.readySent && z3) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z3;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f4, float f5, float f6, float f7) {
        float f8 = f4 - f5;
        float f9 = f6 - f7;
        return (float) Math.sqrt((f9 * f9) + (f8 * f8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        boolean z3;
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f4 = this.scale;
        if (f4 > min * 0.9d && f4 != this.minScale) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            min = minScale();
        }
        float f5 = min;
        int i3 = this.doubleTapZoomStyle;
        if (i3 == 3) {
            setScaleAndCenter(f5, pointF);
        } else if (i3 != 2 && z3 && this.panEnabled) {
            if (i3 == 1) {
                new AnimationBuilder(f5, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
            }
        } else {
            new AnimationBuilder(f5, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i3, long j2, float f4, float f5, long j5) {
        if (i3 != 1) {
            if (i3 == 2) {
                return easeInOutQuad(j2, f4, f5, j5);
            }
            throw new IllegalStateException(i.e(i3, "Unexpected easing type: "));
        }
        return easeOutQuad(j2, f4, f5, j5);
    }

    private float easeInOutQuad(long j2, float f4, float f5, long j5) {
        float f6 = ((float) j2) / (((float) j5) / 2.0f);
        if (f6 < 1.0f) {
            return ((f5 / 2.0f) * f6 * f6) + f4;
        }
        float f7 = f6 - 1.0f;
        return ((((f7 - 2.0f) * f7) - 1.0f) * ((-f5) / 2.0f)) + f4;
    }

    private float easeOutQuad(long j2, float f4, float f5, long j5) {
        float f6 = ((float) j2) / ((float) j5);
        return i.b(f6, 2.0f, (-f5) * f6, f4);
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i3 = rect.top;
            int i5 = this.sHeight;
            rect2.set(i3, i5 - rect.right, rect.bottom, i5 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i6 = this.sWidth;
            int i7 = this.sHeight;
            rect2.set(i6 - rect.right, i7 - rect.bottom, i6 - rect.left, i7 - rect.top);
        } else {
            int i8 = this.sWidth;
            rect2.set(i8 - rect.bottom, rect.left, i8 - rect.top, rect.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z3, ScaleAndTranslate scaleAndTranslate) {
        float paddingLeft;
        float max;
        int max2;
        float max3;
        if (this.panLimit == 2 && isReady()) {
            z3 = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth = sWidth() * limitedScale;
        float sHeight = sHeight() * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z3) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float f4 = 0.5f;
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            paddingLeft = getPaddingLeft() / (getPaddingRight() + getPaddingLeft());
        } else {
            paddingLeft = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f4 = getPaddingTop() / (getPaddingBottom() + getPaddingTop());
        }
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z3) {
            max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
            max3 = Math.max(0.0f, (getHeight() - sHeight) * f4);
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            scaleAndTranslate.scale = limitedScale;
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.scale = limitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public int getExifOrientation(Context context, String str) {
        int i3 = 0;
        if (str.startsWith("content")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i5 = cursor.getInt(0);
                        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i5)) && i5 != -1) {
                            i3 = i5;
                        } else {
                            String str2 = TAG;
                            Log.w(str2, "Unsupported orientation: " + i5);
                        }
                    }
                    if (cursor == null) {
                        return i3;
                    }
                } catch (Exception unused) {
                    Log.w(TAG, "Could not get orientation of image from media store");
                    if (cursor == null) {
                        return 0;
                    }
                }
                cursor.close();
                return i3;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 1 && attributeInt != 0) {
                    if (attributeInt == 6) {
                        return 90;
                    }
                    if (attributeInt == 3) {
                        return ORIENTATION_180;
                    }
                    if (attributeInt == 8) {
                        return ORIENTATION_270;
                    }
                    String str3 = TAG;
                    Log.w(str3, "Unsupported EXIF orientation: " + attributeInt);
                    return 0;
                }
                return 0;
            } catch (Exception unused2) {
                Log.w(TAG, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    @NonNull
    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i3 = this.orientation;
        if (i3 == -1) {
            return this.sOrientation;
        }
        return i3;
    }

    private synchronized void initialiseBaseLayer(@NonNull Point point) {
        try {
            debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
            ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
            this.satTemp = scaleAndTranslate;
            fitToBounds(true, scaleAndTranslate);
            int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
            this.fullImageSampleSize = calculateInSampleSize;
            if (calculateInSampleSize > 1) {
                this.fullImageSampleSize = calculateInSampleSize / 2;
            }
            if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y) {
                this.decoder.recycle();
                this.decoder = null;
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
            } else {
                initialiseTileMap(point);
                for (Tile tile : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                    execute(new TileLoadTask(this, this.decoder, tile));
                }
                refreshRequiredTiles(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void initialiseTileMap(Point point) {
        boolean z3;
        int i3;
        int i5;
        Point point2 = point;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i6 = this.fullImageSampleSize;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            int sWidth = sWidth() / i7;
            int sHeight = sHeight() / i8;
            int i9 = sWidth / i6;
            int i10 = sHeight / i6;
            while (true) {
                if (i9 + i7 + 1 > point2.x || (i9 > getWidth() * 1.25d && i6 < this.fullImageSampleSize)) {
                    i7++;
                    sWidth = sWidth() / i7;
                    i9 = sWidth / i6;
                    point2 = point;
                }
            }
            while (true) {
                if (i10 + i8 + 1 > point2.y || (i10 > getHeight() * 1.25d && i6 < this.fullImageSampleSize)) {
                    i8++;
                    sHeight = sHeight() / i8;
                    i10 = sHeight / i6;
                    point2 = point;
                }
            }
            ArrayList arrayList = new ArrayList(i7 * i8);
            for (int i11 = 0; i11 < i7; i11++) {
                for (int i12 = 0; i12 < i8; i12++) {
                    Tile tile = new Tile();
                    tile.sampleSize = i6;
                    if (i6 == this.fullImageSampleSize) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    tile.visible = z3;
                    int i13 = i11 * sWidth;
                    int i14 = i12 * sHeight;
                    if (i11 == i7 - 1) {
                        i3 = sWidth();
                    } else {
                        i3 = (i11 + 1) * sWidth;
                    }
                    if (i12 == i8 - 1) {
                        i5 = sHeight();
                    } else {
                        i5 = (i12 + 1) * sHeight;
                    }
                    tile.sRect = new Rect(i13, i14, i3, i5);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                }
            }
            this.tileMap.put(Integer.valueOf(i6), arrayList);
            if (i6 == 1) {
                return;
            }
            i6 /= 2;
            point2 = point;
        }
    }

    private boolean isBaseLayerReady() {
        boolean z3 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z3 = false;
                    }
                }
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public PointF limitedSCenter(float f4, float f5, float f6, @NonNull PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f4, f5, f6);
        pointF.set((((((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft()) - vTranslateForSCenter.x) / f6, (((((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2) + getPaddingTop()) - vTranslateForSCenter.y) / f6);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f4) {
        return Math.min(this.maxScale, Math.max(minScale(), f4));
    }

    private float minScale() {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i3 = this.minimumScaleType;
        if (i3 != 2 && i3 != 4) {
            if (i3 == 3) {
                float f4 = this.minScale;
                if (f4 > 0.0f) {
                    return f4;
                }
            }
            return Math.min((getWidth() - paddingRight) / sWidth(), (getHeight() - paddingTop) / sHeight());
        }
        return Math.max((getWidth() - paddingRight) / sWidth(), (getHeight() - paddingTop) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        try {
            debug("onPreviewLoaded", new Object[0]);
            if (this.bitmap == null && !this.imageLoadedSent) {
                Rect rect = this.pRegion;
                if (rect != null) {
                    this.bitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.pRegion.height());
                } else {
                    this.bitmap = bitmap;
                }
                this.bitmapIsPreview = true;
                if (checkReady()) {
                    invalidate();
                    requestLayout();
                }
                return;
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap;
        try {
            debug("onTileLoaded", new Object[0]);
            checkReady();
            checkImageLoaded();
            if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            invalidate();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i3, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        try {
            debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(this.orientation));
            int i10 = this.sWidth;
            if (i10 > 0 && (i9 = this.sHeight) > 0 && (i10 != i3 || i9 != i5)) {
                reset(false);
                Bitmap bitmap = this.bitmap;
                if (bitmap != null) {
                    if (!this.bitmapIsCached) {
                        bitmap.recycle();
                    }
                    this.bitmap = null;
                    OnImageEventListener onImageEventListener = this.onImageEventListener;
                    if (onImageEventListener != null && this.bitmapIsCached) {
                        onImageEventListener.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = i3;
            this.sHeight = i5;
            this.sOrientation = i6;
            checkReady();
            if (!checkImageLoaded() && (i7 = this.maxTileWidth) > 0 && i7 != Integer.MAX_VALUE && (i8 = this.maxTileHeight) > 0 && i8 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
            }
            invalidate();
            requestLayout();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r1 != 262) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onTouchEventInternal(@androidx.annotation.NonNull android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 1194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f4;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (this.sPendingCenter != null && (f4 = this.pendingScale) != null) {
                this.scale = f4.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i3) {
        return (int) (this.density * i3);
    }

    private void refreshRequiredTiles(boolean z3) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z3) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z3) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z3);
        }
    }

    private void reset(boolean z3) {
        OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z3, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z3) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private void sendStateChanged(float f4, PointF pointF, int i3) {
        OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f5 = this.scale;
            if (f5 != f4) {
                onStateChangedListener.onScaleChanged(f5, i3);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (SubsamplingScaleImageView.this.zoomEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null) {
                    SubsamplingScaleImageView.this.setGestureDetector(context);
                    if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                        SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                        SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                        SubsamplingScaleImageView.this.isQuickScaling = true;
                        SubsamplingScaleImageView.this.isZooming = true;
                        SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                        SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                        SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                        SubsamplingScaleImageView.this.quickScaleMoved = false;
                        return false;
                    }
                    SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                if (SubsamplingScaleImageView.this.panEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f4) > 500.0f || Math.abs(f5) > 500.0f) && !SubsamplingScaleImageView.this.isZooming))) {
                    PointF pointF = new PointF((f4 * 0.25f) + SubsamplingScaleImageView.this.vTranslate.x, (f5 * 0.25f) + SubsamplingScaleImageView.this.vTranslate.y);
                    new AnimationBuilder(new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.scale, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f4, f5);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        fArr[3] = f7;
        fArr[4] = f8;
        fArr[5] = f9;
        fArr[6] = f10;
        fArr[7] = f11;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        float viewToSourceX = viewToSourceX(0.0f);
        float viewToSourceX2 = viewToSourceX(getWidth());
        float viewToSourceY = viewToSourceY(0.0f);
        float viewToSourceY2 = viewToSourceY(getHeight());
        if (viewToSourceX <= tile.sRect.right && tile.sRect.left <= viewToSourceX2 && viewToSourceY <= tile.sRect.bottom && tile.sRect.top <= viewToSourceY2) {
            return true;
        }
        return false;
    }

    @NonNull
    private PointF vTranslateForSCenter(float f4, float f5, float f6) {
        int width = (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        int height = (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2) + getPaddingTop();
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f6;
        this.satTemp.vTranslate.set(width - (f4 * f6), height - (f5 * f6));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 - pointF.y) / this.scale;
    }

    @Nullable
    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    @Nullable
    public AnimationBuilder animateScale(float f4) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f4);
    }

    @Nullable
    public AnimationBuilder animateScaleAndCenter(float f4, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f4, pointF);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    @Nullable
    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (!isReady()) {
            return;
        }
        float sWidth = this.scale * sWidth();
        float sHeight = this.scale * sHeight();
        int i3 = this.panLimit;
        if (i3 == 3) {
            rectF.top = Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
            rectF.left = Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
            rectF.bottom = Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - sHeight));
            rectF.right = Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - sWidth));
        } else if (i3 == 2) {
            rectF.top = Math.max(0.0f, -(this.vTranslate.y - getHeight()));
            rectF.left = Math.max(0.0f, -(this.vTranslate.x - getWidth()));
            rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight);
            rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth);
        } else {
            rectF.top = Math.max(0.0f, -this.vTranslate.y);
            rectF.left = Math.max(0.0f, -this.vTranslate.x);
            rectF.bottom = Math.max(0.0f, (sHeight + this.vTranslate.y) - getHeight());
            rectF.right = Math.max(0.0f, (sWidth + this.vTranslate.x) - getWidth());
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final ImageViewState getState() {
        if (this.vTranslate != null && this.sWidth > 0 && this.sHeight > 0) {
            return new ImageViewState(getScale(), getCenter(), getOrientation());
        }
        return null;
    }

    public boolean hasImage() {
        if (this.uri == null && this.bitmap == null) {
            return false;
        }
        return true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        Bitmap bitmap;
        float f4;
        int i5;
        int i6;
        boolean z3;
        boolean z5;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (!checkReady()) {
                return;
            }
            preDraw();
            Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f5 = this.scale;
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                this.vTranslateBefore.set(this.vTranslate);
                long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                if (currentTimeMillis > this.anim.duration) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                long min = Math.min(currentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                if (!z3 && this.anim.scaleStart != this.anim.scaleEnd) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                fitToBounds(z5);
                sendStateChanged(f5, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z3);
                if (z3) {
                    if (this.anim.listener != null) {
                        try {
                            this.anim.listener.onComplete();
                        } catch (Exception e5) {
                            Log.w(TAG, "Error thrown by animation listener", e5);
                        }
                    }
                    this.anim = null;
                }
                invalidate();
            }
            if (this.tileMap != null && isBaseLayerReady()) {
                int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z6 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z6 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z6) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (!tile2.loading && tile2.bitmap != null) {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugLinePaint);
                                }
                            } else if (tile2.loading && this.debug) {
                                canvas.drawText("LOADING", tile2.vRect.left + px(5), tile2.vRect.top + px(35), this.debugTextPaint);
                                if (tile2.visible && this.debug) {
                                    canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + px(5), tile2.vRect.top + px(15), this.debugTextPaint);
                                }
                            }
                            if (tile2.visible) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + px(5), tile2.vRect.top + px(15), this.debugTextPaint);
                            }
                        }
                    }
                }
                i3 = 35;
            } else {
                i3 = 35;
                if (this.bitmap != null) {
                    float f6 = this.scale;
                    if (this.bitmapIsPreview) {
                        f6 *= this.sWidth / bitmap.getWidth();
                        f4 = this.scale * (this.sHeight / this.bitmap.getHeight());
                    } else {
                        f4 = f6;
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f6, f4);
                    this.matrix.postRotate(getRequiredRotation());
                    Matrix matrix = this.matrix;
                    PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.matrix;
                        float f7 = this.scale;
                        matrix2.postTranslate(this.sWidth * f7, f7 * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new RectF();
                        }
                        RectF rectF = this.sRect;
                        if (this.bitmapIsPreview) {
                            i5 = this.bitmap.getWidth();
                        } else {
                            i5 = this.sWidth;
                        }
                        float f8 = i5;
                        if (this.bitmapIsPreview) {
                            i6 = this.bitmap.getHeight();
                        } else {
                            i6 = this.sHeight;
                        }
                        rectF.set(0.0f, 0.0f, f8, i6);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                }
            }
            if (this.debug) {
                StringBuilder sb = new StringBuilder("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.scale)));
                sb.append(" (");
                sb.append(String.format(locale, "%.2f", Float.valueOf(minScale())));
                sb.append(" - ");
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.maxScale)));
                sb.append(")");
                canvas.drawText(sb.toString(), px(5), px(15), this.debugTextPaint);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.y)), px(5), px(30), this.debugTextPaint);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), px(5), px(45), this.debugTextPaint);
                Anim anim2 = this.anim;
                if (anim2 != null) {
                    PointF sourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                    PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                    PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                    canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, px(10), this.debugLinePaint);
                    this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, px(20), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, px(25), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
                }
                if (this.vCenterStart != null) {
                    this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                    PointF pointF2 = this.vCenterStart;
                    canvas.drawCircle(pointF2.x, pointF2.y, px(20), this.debugLinePaint);
                }
                if (this.quickScaleSCenter != null) {
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(i3), this.debugLinePaint);
                }
                if (this.quickScaleVStart != null && this.isQuickScaling) {
                    this.debugLinePaint.setColor(-16711681);
                    PointF pointF3 = this.quickScaleVStart;
                    canvas.drawCircle(pointF3.x, pointF3.y, px(30), this.debugLinePaint);
                }
                this.debugLinePaint.setColor(-65281);
            }
        }
    }

    public void onImageLoaded() {
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i5) {
        boolean z3;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i5);
        boolean z5 = false;
        if (mode != 1073741824) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (mode2 != 1073741824) {
            z5 = true;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z3 && z5) {
                size = sWidth();
                size2 = sHeight();
            } else if (z5) {
                size2 = (int) ((sHeight() / sWidth()) * size);
            } else if (z3) {
                size = (int) ((sWidth() / sHeight()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onReady() {
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i5));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (Exception e5) {
                Log.w(TAG, "Error thrown by animation listener", e5);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        } else if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        } else {
            if (this.vTranslateStart == null) {
                this.vTranslateStart = new PointF(0.0f, 0.0f);
            }
            if (this.vTranslateBefore == null) {
                this.vTranslateBefore = new PointF(0.0f, 0.0f);
            }
            if (this.vCenterStart == null) {
                this.vCenterStart = new PointF(0.0f, 0.0f);
            }
            float f4 = this.scale;
            this.vTranslateBefore.set(this.vTranslate);
            boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
            sendStateChanged(f4, this.vTranslateBefore, 2);
            if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z3) {
        this.debug = z3;
    }

    public final void setDoubleTapZoomDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setDoubleTapZoomDuration(int i3) {
        this.doubleTapZoomDuration = Math.max(0, i3);
    }

    public final void setDoubleTapZoomScale(float f4) {
        this.doubleTapZoomScale = f4;
    }

    public final void setDoubleTapZoomStyle(int i3) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i3))) {
            this.doubleTapZoomStyle = i3;
            return;
        }
        throw new IllegalArgumentException(i.e(i3, "Invalid zoom style: "));
    }

    public void setEagerLoadingEnabled(boolean z3) {
        this.eagerLoadingEnabled = z3;
    }

    public void setExecutor(@NonNull Executor executor) {
        if (executor != null) {
            this.executor = executor;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setMaxScale(float f4) {
        this.maxScale = f4;
    }

    public void setMaxTileSize(int i3) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i3;
    }

    public final void setMaximumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinScale(float f4) {
        this.minScale = f4;
    }

    public final void setMinimumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinimumScaleType(int i3) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i3))) {
            this.minimumScaleType = i3;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(i.e(i3, "Invalid scale type: "));
    }

    public void setMinimumTileDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i3);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public final void setOrientation(int i3) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i3))) {
            this.orientation = i3;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException(i.e(i3, "Invalid orientation: "));
    }

    public final void setPanEnabled(boolean z3) {
        PointF pointF;
        this.panEnabled = z3;
        if (!z3 && (pointF = this.vTranslate) != null) {
            pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
            this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i3) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i3))) {
            this.panLimit = i3;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(i.e(i3, "Invalid pan limit: "));
    }

    public final void setQuickScaleEnabled(boolean z3) {
        this.quickScaleEnabled = z3;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f4, @Nullable PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f4);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i3) {
        if (Color.alpha(i3) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i3);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z3) {
        this.zoomEnabled = z3;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, rect3.top);
            }
        }
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i3, boolean z3) {
        OnImageEventListener onImageEventListener;
        try {
            debug("onImageLoaded", new Object[0]);
            int i5 = this.sWidth;
            if (i5 > 0) {
                if (this.sHeight > 0) {
                    if (i5 == bitmap.getWidth()) {
                        if (this.sHeight != bitmap.getHeight()) {
                        }
                    }
                    reset(false);
                }
            }
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null && !this.bitmapIsCached) {
                bitmap2.recycle();
            }
            if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = z3;
            this.bitmap = bitmap;
            this.sWidth = bitmap.getWidth();
            this.sHeight = bitmap.getHeight();
            this.sOrientation = i3;
            boolean checkReady = checkReady();
            boolean checkImageLoaded = checkImageLoaded();
            if (checkReady || checkImageLoaded) {
                invalidate();
                requestLayout();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    @Nullable
    public final PointF sourceToViewCoord(float f4, float f5) {
        return sourceToViewCoord(f4, f5, new PointF());
    }

    @Nullable
    public final PointF viewToSourceCoord(float f4, float f5) {
        return viewToSourceCoord(f4, f5, new PointF());
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public void setMaxTileSize(int i3, int i5) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i5;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF, @NonNull PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF, @NonNull PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withOrigin(int i3) {
            this.origin = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withPanLimited(boolean z3) {
            this.panLimited = z3;
            return this;
        }

        public void start() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.anim != null && SubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e5) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e5);
                }
            }
            int width = (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2) + SubsamplingScaleImageView.this.getPaddingLeft();
            int height = (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2) + SubsamplingScaleImageView.this.getPaddingTop();
            float limitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            SubsamplingScaleImageView.this.anim = new Anim();
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(width, height);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.origin = this.origin;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f4 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f5 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f4, f5));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((scaleAndTranslate.vTranslate.x - f4) + this.vFocus.x, (scaleAndTranslate.vTranslate.y - f5) + this.vFocus.y);
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public AnimationBuilder withDuration(long j2) {
            this.duration = j2;
            return this;
        }

        @NonNull
        public AnimationBuilder withEasing(int i3) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i3))) {
                this.easing = i3;
                return this;
            }
            throw new IllegalArgumentException(i.e(i3, "Unknown easing type: "));
        }

        @NonNull
        public AnimationBuilder withInterruptible(boolean z3) {
            this.interruptible = z3;
            return this;
        }

        @NonNull
        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f4) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f4, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f4, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            this.bitmapIsCached = imageSource2.isCached();
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
                return;
            } else if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
                return;
            } else {
                this.sRegion = imageSource.getSRegion();
                Uri uri2 = imageSource.getUri();
                this.uri = uri2;
                if (uri2 == null && imageSource.getResource() != null) {
                    this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
                }
                if (!imageSource.getTile() && this.sRegion == null) {
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                    return;
                } else {
                    execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                    return;
                }
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    @Nullable
    public final PointF sourceToViewCoord(float f4, float f5, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f4), sourceToViewY(f5));
        return pointF;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f4, float f5, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f4), viewToSourceY(f5));
        return pointF;
    }

    private void fitToBounds(boolean z3) {
        boolean z5;
        if (this.vTranslate == null) {
            this.vTranslate = new PointF(0.0f, 0.0f);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z3, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z5 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
