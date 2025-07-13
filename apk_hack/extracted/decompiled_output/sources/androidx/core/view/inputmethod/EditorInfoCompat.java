package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @RequiresApi(30)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Impl30 {
        private Impl30() {
        }

        public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i3) {
            CharSequence initialSelectedText;
            initialSelectedText = editorInfo.getInitialSelectedText(i3);
            return initialSelectedText;
        }

        public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i3, int i5) {
            CharSequence initialTextAfterCursor;
            initialTextAfterCursor = editorInfo.getInitialTextAfterCursor(i3, i5);
            return initialTextAfterCursor;
        }

        public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i3, int i5) {
            CharSequence initialTextBeforeCursor;
            initialTextBeforeCursor = editorInfo.getInitialTextBeforeCursor(i3, i5);
            return initialTextBeforeCursor;
        }

        public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i3) {
            editorInfo.setInitialSurroundingSubText(charSequence, i3);
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 25) {
            strArr = editorInfo.contentMimeTypes;
            if (strArr == null) {
                return EMPTY_STRING_ARRAY;
            }
            return strArr;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray == null) {
            return EMPTY_STRING_ARRAY;
        }
        return stringArray;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i3) {
        int i5;
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialSelectedText(editorInfo, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return null;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        if (i6 > i7) {
            i5 = i7;
        } else {
            i5 = i6;
        }
        if (i6 <= i7) {
            i6 = i7;
        }
        int i8 = bundle.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i9 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i10 = i6 - i5;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i9 - i8 != i10 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i3 & 1) != 0) {
            return charSequence.subSequence(i8, i9);
        }
        return TextUtils.substring(charSequence, i8, i9);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i3, int i5) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextAfterCursor(editorInfo, i3, i5);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i3, charSequence.length() - i6);
        if ((i5 & 1) != 0) {
            return charSequence.subSequence(i6, min + i6);
        }
        return TextUtils.substring(charSequence, i6, min + i6);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i3, int i5) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextBeforeCursor(editorInfo, i3, i5);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i3, i6);
        if ((i5 & 1) != 0) {
            return charSequence.subSequence(i6 - min, i6);
        }
        return TextUtils.substring(charSequence, i6 - min, i6);
    }

    public static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        if (!containsKey2) {
            return 0;
        }
        return 2;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i3, int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i3));
        }
        return Character.isLowSurrogate(charSequence.charAt(i3));
    }

    private static boolean isPasswordInputType(int i3) {
        int i5 = i3 & 4095;
        return i5 == 129 || i5 == 225 || i5 == 18;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i3) {
        int i5;
        int i6;
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText(editorInfo, charSequence, i3);
            return;
        }
        int i7 = editorInfo.initialSelStart;
        int i8 = editorInfo.initialSelEnd;
        if (i7 > i8) {
            i5 = i8 - i3;
        } else {
            i5 = i7 - i3;
        }
        if (i7 > i8) {
            i6 = i7 - i3;
        } else {
            i6 = i8 - i3;
        }
        int length = charSequence.length();
        if (i3 >= 0 && i5 >= 0 && i6 <= length) {
            if (isPasswordInputType(editorInfo.inputType)) {
                setSurroundingText(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                setSurroundingText(editorInfo, charSequence, i5, i6);
                return;
            } else {
                trimLongSurroundingText(editorInfo, charSequence, i5, i6);
                return;
            }
        }
        setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i3, int i5) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i3);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i5);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i3, int i5) {
        int i6;
        CharSequence subSequence;
        int i7 = i5 - i3;
        if (i7 > 1024) {
            i6 = 0;
        } else {
            i6 = i7;
        }
        int i8 = 2048 - i6;
        int min = Math.min(charSequence.length() - i5, i8 - Math.min(i3, (int) (i8 * 0.8d)));
        int min2 = Math.min(i3, i8 - min);
        int i9 = i3 - min2;
        if (isCutOnSurrogate(charSequence, i9, 0)) {
            i9++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i5 + min) - 1, 1)) {
            min--;
        }
        int i10 = min2 + i6 + min;
        if (i6 != i7) {
            subSequence = TextUtils.concat(charSequence.subSequence(i9, i9 + min2), charSequence.subSequence(i5, min + i5));
        } else {
            subSequence = charSequence.subSequence(i9, i10 + i9);
        }
        setSurroundingText(editorInfo, subSequence, min2, i6 + min2);
    }
}
