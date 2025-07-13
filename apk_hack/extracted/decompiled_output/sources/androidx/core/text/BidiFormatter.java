package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE;
    static final BidiFormatter DEFAULT_RTL_INSTANCE;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final String LRM_STRING;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class DirectionalityEstimator {
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];

        static {
            for (int i3 = 0; i3 < DIR_TYPE_CACHE_SIZE; i3++) {
                DIR_TYPE_CACHE[i3] = Character.getDirectionality(i3);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z3) {
            this.text = charSequence;
            this.isHtml = z3;
            this.length = charSequence.length();
        }

        private static byte getCachedDirectionality(char c) {
            if (c < DIR_TYPE_CACHE_SIZE) {
                return DIR_TYPE_CACHE[c];
            }
            return Character.getDirectionality(c);
        }

        private byte skipEntityBackward() {
            char charAt;
            int i3 = this.charIndex;
            do {
                int i5 = this.charIndex;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i6 = i5 - 1;
                this.charIndex = i6;
                charAt = charSequence.charAt(i6);
                this.lastChar = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.charIndex = i3;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i3 = this.charIndex;
                if (i3 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i3 + 1;
                    charAt = charSequence.charAt(i3);
                    this.lastChar = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte skipTagBackward() {
            char charAt;
            int i3 = this.charIndex;
            while (true) {
                int i5 = this.charIndex;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i6 = i5 - 1;
                this.charIndex = i6;
                char charAt2 = charSequence.charAt(i6);
                this.lastChar = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i7 = this.charIndex;
                        if (i7 > 0) {
                            CharSequence charSequence2 = this.text;
                            int i8 = i7 - 1;
                            this.charIndex = i8;
                            charAt = charSequence2.charAt(i8);
                            this.lastChar = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.charIndex = i3;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipTagForward() {
            char charAt;
            int i3 = this.charIndex;
            while (true) {
                int i5 = this.charIndex;
                if (i5 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i5 + 1;
                    char charAt2 = charSequence.charAt(i5);
                    this.lastChar = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i6 = this.charIndex;
                            if (i6 < this.length) {
                                CharSequence charSequence2 = this.text;
                                this.charIndex = i6 + 1;
                                charAt = charSequence2.charAt(i6);
                                this.lastChar = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.charIndex = i3;
                    this.lastChar = '<';
                    return (byte) 13;
                }
            }
        }

        public byte dirTypeBackward() {
            char charAt = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c = this.lastChar;
                if (c == '>') {
                    return skipTagBackward();
                }
                if (c == ';') {
                    return skipEntityBackward();
                }
                return cachedDirectionality;
            }
            return cachedDirectionality;
        }

        public byte dirTypeForward() {
            char charAt = this.text.charAt(this.charIndex);
            this.lastChar = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex = Character.charCount(codePointAt) + this.charIndex;
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c = this.lastChar;
                if (c == '<') {
                    return skipTagForward();
                }
                if (c == '&') {
                    return skipEntityForward();
                }
                return cachedDirectionality;
            }
            return cachedDirectionality;
        }

        public int getEntryDir() {
            this.charIndex = 0;
            int i3 = 0;
            int i5 = 0;
            int i6 = 0;
            while (this.charIndex < this.length && i3 == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != 0) {
                    if (dirTypeForward != 1 && dirTypeForward != 2) {
                        if (dirTypeForward != 9) {
                            switch (dirTypeForward) {
                                case 14:
                                case 15:
                                    i6++;
                                    i5 = -1;
                                    break;
                                case 16:
                                case 17:
                                    i6++;
                                    i5 = 1;
                                    break;
                                case 18:
                                    i6--;
                                    i5 = 0;
                                    break;
                            }
                        }
                    } else if (i6 == 0) {
                        return 1;
                    }
                } else if (i6 == 0) {
                    return -1;
                }
                i3 = i6;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i5 != 0) {
                return i5;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (i3 == i6) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i3 == i6) {
                            return 1;
                        }
                        break;
                    case 18:
                        i6++;
                        continue;
                }
                i6--;
            }
            return 0;
        }

        public int getExitDir() {
            this.charIndex = this.length;
            int i3 = 0;
            int i5 = 0;
            while (this.charIndex > 0) {
                byte dirTypeBackward = dirTypeBackward();
                if (dirTypeBackward != 0) {
                    if (dirTypeBackward != 1 && dirTypeBackward != 2) {
                        if (dirTypeBackward != 9) {
                            switch (dirTypeBackward) {
                                case 14:
                                case 15:
                                    if (i5 == i3) {
                                        return -1;
                                    }
                                    i3--;
                                    break;
                                case 16:
                                case 17:
                                    if (i5 == i3) {
                                        return 1;
                                    }
                                    i3--;
                                    break;
                                case 18:
                                    i3++;
                                    break;
                                default:
                                    if (i5 != 0) {
                                        break;
                                    } else {
                                        i5 = i3;
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else if (i3 == 0) {
                        return 1;
                    } else {
                        if (i5 == 0) {
                            i5 = i3;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                } else {
                    if (i5 == 0) {
                        i5 = i3;
                    }
                }
            }
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = textDirectionHeuristicCompat;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean z3, int i3, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z3;
        this.mFlags = i3;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static boolean isRtlLocale(Locale locale) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            if (!isRtl || getExitDir(charSequence) == -1) {
                return RLM_STRING;
            }
            return "";
        }
        return "";
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            if (!isRtl || getEntryDir(charSequence) == -1) {
                return RLM_STRING;
            }
            return "";
        }
        return "";
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z3) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z3).toString();
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z3) {
            if (z3) {
                return BidiFormatter.DEFAULT_RTL_INSTANCE;
            }
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z3) {
            this.mIsRtlContext = z3;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z3) {
            if (z3) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder(boolean z3) {
            initialize(z3);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z3) {
        return new Builder(z3).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z3) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z3) {
            spannableStringBuilder.append((CharSequence) markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z3) {
            spannableStringBuilder.append((CharSequence) markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z3) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z3);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z3) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z3);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
