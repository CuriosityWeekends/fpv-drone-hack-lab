package android.support.v4.media;

import a1.i;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface BitmapKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface TextKey {
    }

    static {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put(METADATA_KEY_TITLE, 1);
        arrayMap.put(METADATA_KEY_ARTIST, 1);
        arrayMap.put(METADATA_KEY_DURATION, 0);
        arrayMap.put(METADATA_KEY_ALBUM, 1);
        arrayMap.put(METADATA_KEY_AUTHOR, 1);
        arrayMap.put(METADATA_KEY_WRITER, 1);
        arrayMap.put(METADATA_KEY_COMPOSER, 1);
        arrayMap.put(METADATA_KEY_COMPILATION, 1);
        arrayMap.put(METADATA_KEY_DATE, 1);
        arrayMap.put(METADATA_KEY_YEAR, 0);
        arrayMap.put(METADATA_KEY_GENRE, 1);
        arrayMap.put(METADATA_KEY_TRACK_NUMBER, 0);
        arrayMap.put(METADATA_KEY_NUM_TRACKS, 0);
        arrayMap.put(METADATA_KEY_DISC_NUMBER, 0);
        arrayMap.put(METADATA_KEY_ALBUM_ARTIST, 1);
        arrayMap.put(METADATA_KEY_ART, 2);
        arrayMap.put(METADATA_KEY_ART_URI, 1);
        arrayMap.put(METADATA_KEY_ALBUM_ART, 2);
        arrayMap.put(METADATA_KEY_ALBUM_ART_URI, 1);
        arrayMap.put(METADATA_KEY_USER_RATING, 3);
        arrayMap.put(METADATA_KEY_RATING, 3);
        arrayMap.put(METADATA_KEY_DISPLAY_TITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON, 2);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        arrayMap.put(METADATA_KEY_MEDIA_ID, 1);
        arrayMap.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        arrayMap.put(METADATA_KEY_MEDIA_URI, 1);
        arrayMap.put(METADATA_KEY_ADVERTISEMENT, 0);
        arrayMap.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat[] newArray(int i3) {
                return new MediaMetadataCompat[i3];
            }
        };
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.mBundle = bundle2;
        MediaSessionCompat.ensureClassLoader(bundle2);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj != null) {
            Parcel obtain = Parcel.obtain();
            MediaMetadataCompatApi21.writeToParcel(obj, obtain, 0);
            obtain.setDataPosition(0);
            MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
            obtain.recycle();
            createFromParcel.mMetadataObj = obj;
            return createFromParcel;
        }
        return null;
    }

    public boolean containsKey(String str) {
        return this.mBundle.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.mBundle.getParcelable(str);
        } catch (Exception e5) {
            Log.w(TAG, "Failed to retrieve a key as Bitmap.", e5);
            return null;
        }
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public MediaDescriptionCompat getDescription() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i3 = 0;
            int i5 = 0;
            while (i3 < 3) {
                String[] strArr = PREFERRED_DESCRIPTION_ORDER;
                if (i5 >= strArr.length) {
                    break;
                }
                int i6 = i5 + 1;
                CharSequence text2 = getText(strArr[i5]);
                if (!TextUtils.isEmpty(text2)) {
                    charSequenceArr[i3] = text2;
                    i3++;
                }
                i5 = i6;
            }
        }
        int i7 = 0;
        while (true) {
            String[] strArr2 = PREFERRED_BITMAP_ORDER;
            uri = null;
            if (i7 < strArr2.length) {
                bitmap = getBitmap(strArr2[i7]);
                if (bitmap != null) {
                    break;
                }
                i7++;
            } else {
                bitmap = null;
                break;
            }
        }
        int i8 = 0;
        while (true) {
            String[] strArr3 = PREFERRED_URI_ORDER;
            if (i8 < strArr3.length) {
                String string2 = getString(strArr3[i8]);
                if (!TextUtils.isEmpty(string2)) {
                    uri2 = Uri.parse(string2);
                    break;
                }
                i8++;
            } else {
                uri2 = null;
                break;
            }
        }
        String string3 = getString(METADATA_KEY_MEDIA_URI);
        if (!TextUtils.isEmpty(string3)) {
            uri = Uri.parse(string3);
        }
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri2);
        builder.setMediaUri(uri);
        Bundle bundle = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        MediaDescriptionCompat build = builder.build();
        this.mDescription = build;
        return build;
    }

    public long getLong(String str) {
        return this.mBundle.getLong(str, 0L);
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj == null) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String str) {
        try {
            return RatingCompat.fromRating(this.mBundle.getParcelable(str));
        } catch (Exception e5) {
            Log.w(TAG, "Failed to retrieve a key as Rating.", e5);
            return null;
        }
    }

    public String getString(String str) {
        CharSequence charSequence = this.mBundle.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence getText(String str) {
        return this.mBundle.getCharSequence(str);
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeBundle(this.mBundle);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        private Bitmap scaleBitmap(Bitmap bitmap, int i3) {
            float f4 = i3;
            float min = Math.min(f4 / bitmap.getWidth(), f4 / bitmap.getHeight());
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true);
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (arrayMap.containsKey(str) && arrayMap.get(str).intValue() != 2) {
                throw new IllegalArgumentException(i.i("The ", str, " key cannot be used to put a Bitmap"));
            }
            this.mBundle.putParcelable(str, bitmap);
            return this;
        }

        public Builder putLong(String str, long j2) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (arrayMap.containsKey(str) && arrayMap.get(str).intValue() != 0) {
                throw new IllegalArgumentException(i.i("The ", str, " key cannot be used to put a long"));
            }
            this.mBundle.putLong(str, j2);
            return this;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (arrayMap.containsKey(str) && arrayMap.get(str).intValue() != 3) {
                throw new IllegalArgumentException(i.i("The ", str, " key cannot be used to put a Rating"));
            }
            this.mBundle.putParcelable(str, (Parcelable) ratingCompat.getRating());
            return this;
        }

        public Builder putString(String str, String str2) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (arrayMap.containsKey(str) && arrayMap.get(str).intValue() != 1) {
                throw new IllegalArgumentException(i.i("The ", str, " key cannot be used to put a String"));
            }
            this.mBundle.putCharSequence(str, str2);
            return this;
        }

        public Builder putText(String str, CharSequence charSequence) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (arrayMap.containsKey(str) && arrayMap.get(str).intValue() != 1) {
                throw new IllegalArgumentException(i.i("The ", str, " key cannot be used to put a CharSequence"));
            }
            this.mBundle.putCharSequence(str, charSequence);
            return this;
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.mBundle);
            this.mBundle = bundle;
            MediaSessionCompat.ensureClassLoader(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i3) {
            this(mediaMetadataCompat);
            for (String str : this.mBundle.keySet()) {
                Object obj = this.mBundle.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i3 || bitmap.getWidth() > i3) {
                        putBitmap(str, scaleBitmap(bitmap, i3));
                    }
                }
            }
        }
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
