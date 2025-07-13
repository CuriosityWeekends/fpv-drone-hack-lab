package t2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.lg.picturesubmitt.activity.FFMPEGPlayActivity;
import com.lg.picturesubmitt.widget.FFSurfaceView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends FFSurfaceView {
    public final /* synthetic */ FFMPEGPlayActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FFMPEGPlayActivity fFMPEGPlayActivity, Context context) {
        super(context);
        this.b = fFMPEGPlayActivity;
    }

    @Override // com.lg.picturesubmitt.widget.FFSurfaceView
    public final void a(Canvas canvas) {
        Bitmap decodeFile;
        FFMPEGPlayActivity fFMPEGPlayActivity = this.b;
        if (!TextUtils.isEmpty(fFMPEGPlayActivity.f555j) && (decodeFile = BitmapFactory.decodeFile(fFMPEGPlayActivity.f555j)) != null && canvas != null) {
            canvas.drawBitmap(decodeFile, (Rect) null, new RectF(0.0f, 0.0f, getWidth(), getHeight()), (Paint) null);
        }
    }
}
