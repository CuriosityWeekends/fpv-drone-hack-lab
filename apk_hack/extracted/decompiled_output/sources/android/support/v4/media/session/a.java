package android.support.v4.media.session;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Notification.MessagingStyle.Message b(CharSequence charSequence, long j2, Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j2, person);
    }

    public static /* synthetic */ Notification.MessagingStyle c(Person person) {
        return new Notification.MessagingStyle(person);
    }

    public static /* synthetic */ Person.Builder e() {
        return new Person.Builder();
    }

    public static /* bridge */ /* synthetic */ Person j(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ Person k(Object obj) {
        return (Person) obj;
    }
}
