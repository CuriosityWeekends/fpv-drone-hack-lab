package com.shuyu.gsyvideoplayer.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RawDataSourceProvider implements IMediaDataSource {
    private AssetFileDescriptor mDescriptor;
    private byte[] mMediaBytes;

    public RawDataSourceProvider(AssetFileDescriptor assetFileDescriptor) {
        this.mDescriptor = assetFileDescriptor;
    }

    public static RawDataSourceProvider create(Context context, Uri uri) {
        try {
            return new RawDataSourceProvider(context.getApplicationContext().getContentResolver().openAssetFileDescriptor(uri, "r"));
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private byte[] readBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() {
        AssetFileDescriptor assetFileDescriptor = this.mDescriptor;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.mDescriptor = null;
        this.mMediaBytes = null;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() {
        long length = this.mDescriptor.getLength();
        if (this.mMediaBytes == null) {
            this.mMediaBytes = readBytes(this.mDescriptor.createInputStream());
        }
        return length;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j2, byte[] bArr, int i3, int i5) {
        byte[] bArr2 = this.mMediaBytes;
        if (1 + j2 >= bArr2.length) {
            return -1;
        }
        if (i5 + j2 >= bArr2.length) {
            int length = (int) (bArr2.length - j2);
            if (length > bArr.length) {
                length = bArr.length;
            }
            i5 = length - 1;
        }
        System.arraycopy(bArr2, (int) j2, bArr, i3, i5);
        return i5;
    }
}
