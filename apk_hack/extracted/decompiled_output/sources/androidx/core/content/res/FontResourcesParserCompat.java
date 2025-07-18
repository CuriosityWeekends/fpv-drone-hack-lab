package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface FetchStrategy {
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class FontFileResourceEntry {
        @NonNull
        private final String mFileName;
        private boolean mItalic;
        private int mResourceId;
        private int mTtcIndex;
        private String mVariationSettings;
        private int mWeight;

        public FontFileResourceEntry(@NonNull String str, int i3, boolean z3, @Nullable String str2, int i5, int i6) {
            this.mFileName = str;
            this.mWeight = i3;
            this.mItalic = z3;
            this.mVariationSettings = str2;
            this.mTtcIndex = i5;
            this.mResourceId = i6;
        }

        @NonNull
        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @Nullable
        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray typedArray, int i3) {
        return typedArray.getType(i3);
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i3) {
        if (i3 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i3);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (getType(obtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
                    int resourceId = obtainTypedArray.getResourceId(i5, 0);
                    if (resourceId != 0) {
                        arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(toByteArrayList(resources.getStringArray(i3)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    @Nullable
    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    @Nullable
    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, DEFAULT_TIMEOUT_MILLIS);
        String string4 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                skip(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(readFont(xmlPullParser, resources));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) {
        boolean z3;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i3 = R.styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i5 = obtainAttributes.getInt(i3, NORMAL_WEIGHT);
        int i6 = R.styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        if (1 == obtainAttributes.getInt(i6, 0)) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i7 = R.styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i8 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i8);
        int i9 = obtainAttributes.getInt(i7, 0);
        int i10 = R.styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i10, 0);
        String string2 = obtainAttributes.getString(i10);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i5, z3, string, i9, resourceId);
    }

    private static void skip(XmlPullParser xmlPullParser) {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i3--;
                }
            } else {
                i3++;
            }
        }
    }

    private static List<byte[]> toByteArrayList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull
        private final FontRequest mRequest;
        private final int mStrategy;
        @Nullable
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i3, int i5, @Nullable String str) {
            this.mRequest = fontRequest;
            this.mStrategy = i3;
            this.mTimeoutMs = i5;
            this.mSystemFontFamilyName = str;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.mRequest;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i3, int i5) {
            this(fontRequest, i3, i5, null);
        }
    }
}
