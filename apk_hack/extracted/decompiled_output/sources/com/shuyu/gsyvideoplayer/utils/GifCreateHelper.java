package com.shuyu.gsyvideoplayer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import n3.b;
import n3.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifCreateHelper {
    private int mDelay;
    private int mFrequencyCount;
    private b mGSYVideoGifSaveListener;
    private List<String> mPicList;
    private StandardGSYVideoPlayer mPlayer;
    private int mSampleSize;
    private boolean mSaveShotBitmapSuccess;
    private int mScaleSize;
    private Timer mTimer;
    private TaskLocal mTimerTask;
    private File mTmpPath;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class TaskLocal extends TimerTask {
        private TaskLocal() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (GifCreateHelper.this.mSaveShotBitmapSuccess) {
                GifCreateHelper.this.mSaveShotBitmapSuccess = false;
                GifCreateHelper.this.startSaveBitmap();
            }
        }
    }

    public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, b bVar) {
        this(standardGSYVideoPlayer, bVar, 0, 1, 5, 50);
    }

    public static /* synthetic */ b access$500(GifCreateHelper gifCreateHelper) {
        gifCreateHelper.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSaveBitmap() {
        File file = this.mTmpPath;
        this.mPlayer.saveFrame(new File(file, "GSY-TMP-FRAME" + System.currentTimeMillis() + ".tmp"), new e() { // from class: com.shuyu.gsyvideoplayer.utils.GifCreateHelper.2
            @Override // n3.e
            public void result(boolean z3, File file2) {
                GifCreateHelper.this.mSaveShotBitmapSuccess = true;
                if (z3) {
                    Debuger.printfError(" SUCCESS CREATE FILE " + file2.getAbsolutePath());
                    GifCreateHelper.this.mPicList.add(file2.getAbsolutePath());
                }
            }
        });
    }

    public void cancelTask() {
        TaskLocal taskLocal = this.mTimerTask;
        if (taskLocal != null) {
            taskLocal.cancel();
            this.mTimerTask = null;
        }
    }

    public void createGif(File file, List<String> list, int i3, int i5, int i6, b bVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        AnimatedGifEncoder animatedGifEncoder = new AnimatedGifEncoder();
        animatedGifEncoder.start(byteArrayOutputStream);
        animatedGifEncoder.setRepeat(0);
        animatedGifEncoder.setDelay(i3);
        int i7 = 0;
        while (i7 < list.size()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i5;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(list.get(i7), options);
            double d = i6;
            double d5 = options.outWidth / d;
            double d6 = options.outHeight / d;
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(list.get(i7), options);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(decodeFile, (int) d5, (int) d6);
            animatedGifEncoder.addFrame(extractThumbnail);
            decodeFile.recycle();
            extractThumbnail.recycle();
            i7++;
            list.size();
            bVar.a();
        }
        animatedGifEncoder.finish();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.flush();
            fileOutputStream.flush();
            byteArrayOutputStream.close();
            fileOutputStream.close();
            bVar.b();
        } catch (IOException e5) {
            e5.printStackTrace();
            bVar.b();
        }
    }

    public void startGif(File file) {
        this.mTmpPath = file;
        cancelTask();
        this.mPicList.clear();
        TaskLocal taskLocal = new TaskLocal();
        this.mTimerTask = taskLocal;
        this.mTimer.schedule(taskLocal, 0L, this.mFrequencyCount);
    }

    public void stopGif(final File file) {
        cancelTask();
        this.mSaveShotBitmapSuccess = true;
        new Thread(new Runnable() { // from class: com.shuyu.gsyvideoplayer.utils.GifCreateHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (GifCreateHelper.this.mPicList.size() > 2) {
                    GifCreateHelper gifCreateHelper = GifCreateHelper.this;
                    File file2 = file;
                    List<String> list = gifCreateHelper.mPicList;
                    int i3 = GifCreateHelper.this.mDelay;
                    int i5 = GifCreateHelper.this.mSampleSize;
                    int i6 = GifCreateHelper.this.mScaleSize;
                    GifCreateHelper.access$500(GifCreateHelper.this);
                    gifCreateHelper.createGif(file2, list, i3, i5, i6, null);
                    return;
                }
                GifCreateHelper.access$500(GifCreateHelper.this);
                throw null;
            }
        }).start();
    }

    public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, b bVar, int i3, int i5, int i6, int i7) {
        this.mSaveShotBitmapSuccess = true;
        this.mTimer = new Timer();
        this.mPicList = new ArrayList();
        this.mPlayer = standardGSYVideoPlayer;
        this.mDelay = i3;
        this.mSampleSize = i5;
        this.mScaleSize = i6;
        this.mFrequencyCount = i7;
    }
}
