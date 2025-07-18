package androidx.core.accessibilityservice;

import a1.i;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
    }

    @NonNull
    public static String capabilityToString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        return "UNKNOWN";
                    }
                    return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
                }
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            }
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    }

    @NonNull
    public static String feedbackTypeToString(int i3) {
        StringBuilder l5 = i.l("[");
        while (i3 > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i3);
            i3 &= ~numberOfTrailingZeros;
            if (l5.length() > 1) {
                l5.append(", ");
            }
            if (numberOfTrailingZeros != 1) {
                if (numberOfTrailingZeros != 2) {
                    if (numberOfTrailingZeros != 4) {
                        if (numberOfTrailingZeros != 8) {
                            if (numberOfTrailingZeros == 16) {
                                l5.append("FEEDBACK_GENERIC");
                            }
                        } else {
                            l5.append("FEEDBACK_VISUAL");
                        }
                    } else {
                        l5.append("FEEDBACK_AUDIBLE");
                    }
                } else {
                    l5.append("FEEDBACK_HAPTIC");
                }
            } else {
                l5.append("FEEDBACK_SPOKEN");
            }
        }
        l5.append("]");
        return l5.toString();
    }

    @Nullable
    public static String flagToString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 16) {
                            if (i3 != 32) {
                                return null;
                            }
                            return "FLAG_REQUEST_FILTER_KEY_EVENTS";
                        }
                        return "FLAG_REPORT_VIEW_IDS";
                    }
                    return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                }
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            }
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        return "DEFAULT";
    }

    public static int getCapabilities(@NonNull AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }

    @Nullable
    public static String loadDescription(@NonNull AccessibilityServiceInfo accessibilityServiceInfo, @NonNull PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
