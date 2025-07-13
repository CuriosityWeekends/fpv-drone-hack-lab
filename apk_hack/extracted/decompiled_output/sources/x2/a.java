package x2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.lg.picturesubmitt.activity.ProtocolActivity;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final ProtocolActivity f3963a;
    public final BufferedReader b;

    public a(Context context, BufferedReader bufferedReader) {
        this.b = bufferedReader;
        this.f3963a = (ProtocolActivity) context;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 100; i3++) {
            try {
                String readLine = this.b.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        Log.d("AsyncTextLoadTask", "onPostExecute ");
        ProtocolActivity protocolActivity = this.f3963a;
        protocolActivity.c.append(str);
        protocolActivity.f810e = false;
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        super.onPreExecute();
    }
}
