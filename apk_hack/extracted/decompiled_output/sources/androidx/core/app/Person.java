package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    @Nullable
    String mKey;
    @Nullable
    CharSequence mName;
    @Nullable
    String mUri;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Builder {
        @Nullable
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        @Nullable
        String mKey;
        @Nullable
        CharSequence mName;
        @Nullable
        String mUri;

        public Builder() {
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean z3) {
            this.mIsBot = z3;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat iconCompat) {
            this.mIcon = iconCompat;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean z3) {
            this.mIsImportant = z3;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            this.mKey = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String str) {
            this.mUri = str;
            return this;
        }

        public Builder(Person person) {
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }
    }

    public Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        CharSequence name;
        Icon icon;
        IconCompat iconCompat;
        String uri;
        String key;
        boolean isBot;
        boolean isImportant;
        Icon icon2;
        Builder builder = new Builder();
        name = person.getName();
        Builder name2 = builder.setName(name);
        icon = person.getIcon();
        if (icon != null) {
            icon2 = person.getIcon();
            iconCompat = IconCompat.createFromIcon(icon2);
        } else {
            iconCompat = null;
        }
        Builder icon3 = name2.setIcon(iconCompat);
        uri = person.getUri();
        Builder uri2 = icon3.setUri(uri);
        key = person.getKey();
        Builder key2 = uri2.setKey(key);
        isBot = person.isBot();
        Builder bot = key2.setBot(isBot);
        isImportant = person.isImportant();
        return bot.setImportant(isImportant).build();
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        IconCompat iconCompat;
        Bundle bundle2 = bundle.getBundle(ICON_KEY);
        Builder name = new Builder().setName(bundle.getCharSequence(NAME_KEY));
        if (bundle2 != null) {
            iconCompat = IconCompat.createFromBundle(bundle2);
        } else {
            iconCompat = null;
        }
        return name.setIcon(iconCompat).setUri(bundle.getString(URI_KEY)).setKey(bundle.getString(KEY_KEY)).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        boolean z3;
        boolean z5;
        Builder key = new Builder().setName(persistableBundle.getString(NAME_KEY)).setUri(persistableBundle.getString(URI_KEY)).setKey(persistableBundle.getString(KEY_KEY));
        z3 = persistableBundle.getBoolean("isBot");
        Builder bot = key.setBot(z3);
        z5 = persistableBundle.getBoolean("isImportant");
        return bot.setImportant(z5).build();
    }

    @Nullable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    public String getKey() {
        return this.mKey;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    @Nullable
    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String str = this.mUri;
        if (str != null) {
            return str;
        }
        if (this.mName != null) {
            return "name:" + ((Object) this.mName);
        }
        return "";
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        Person.Builder name;
        Icon icon;
        Person.Builder icon2;
        Person.Builder uri;
        Person.Builder key;
        Person.Builder bot;
        Person.Builder important;
        android.app.Person build;
        name = android.support.v4.media.session.a.e().setName(getName());
        if (getIcon() != null) {
            icon = getIcon().toIcon();
        } else {
            icon = null;
        }
        icon2 = name.setIcon(icon);
        uri = icon2.setUri(getUri());
        key = uri.setKey(getKey());
        bot = key.setBot(isBot());
        important = bot.setImportant(isImportant());
        build = important.build();
        return build;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence(NAME_KEY, this.mName);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            bundle = iconCompat.toBundle();
        } else {
            bundle = null;
        }
        bundle2.putBundle(ICON_KEY, bundle);
        bundle2.putString(URI_KEY, this.mUri);
        bundle2.putString(KEY_KEY, this.mKey);
        bundle2.putBoolean(IS_BOT_KEY, this.mIsBot);
        bundle2.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return bundle2;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        String str;
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.mName;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        persistableBundle.putString(NAME_KEY, str);
        persistableBundle.putString(URI_KEY, this.mUri);
        persistableBundle.putString(KEY_KEY, this.mKey);
        persistableBundle.putBoolean("isBot", this.mIsBot);
        persistableBundle.putBoolean("isImportant", this.mIsImportant);
        return persistableBundle;
    }
}
