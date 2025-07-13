package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String str) {
            this.mGroup = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mGroup.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }
    }

    public NotificationChannelGroupCompat(@NonNull String str) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(str);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> list) {
        String group;
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : list) {
            NotificationChannel i3 = b.i(notificationChannel);
            String str = this.mId;
            group = i3.getGroup();
            if (str.equals(group)) {
                arrayList.add(new NotificationChannelCompat(i3));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannelGroup getNotificationChannelGroup() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            return null;
        }
        b.B();
        NotificationChannelGroup k5 = b.k(this.mId, this.mName);
        if (i3 >= 28) {
            k5.setDescription(this.mDescription);
        }
        return k5;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    @RequiresApi(28)
    public NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NotificationChannelGroupCompat(@androidx.annotation.NonNull android.app.NotificationChannelGroup r4, @androidx.annotation.NonNull java.util.List<android.app.NotificationChannel> r5) {
        /*
            r3 = this;
            java.lang.String r0 = androidx.core.app.b.o(r4)
            r3.<init>(r0)
            java.lang.CharSequence r0 = androidx.core.app.b.m(r4)
            r3.mName = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L19
            java.lang.String r2 = android.support.v4.media.session.a.s(r4)
            r3.mDescription = r2
        L19:
            if (r0 < r1) goto L2c
            boolean r5 = android.support.v4.media.session.a.y(r4)
            r3.mBlocked = r5
            java.util.List r4 = androidx.core.app.b.p(r4)
            java.util.List r4 = r3.getChannelsCompat(r4)
            r3.mChannels = r4
            goto L32
        L2c:
            java.util.List r4 = r3.getChannelsCompat(r5)
            r3.mChannels = r4
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationChannelGroupCompat.<init>(android.app.NotificationChannelGroup, java.util.List):void");
    }
}
