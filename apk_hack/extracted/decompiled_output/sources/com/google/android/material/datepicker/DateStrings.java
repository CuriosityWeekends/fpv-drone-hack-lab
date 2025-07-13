package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l5, @Nullable Long l6) {
        return getDateRangeString(l5, l6, null);
    }

    public static String getDateString(long j2) {
        return getDateString(j2, null);
    }

    public static String getMonthDay(long j2) {
        return getMonthDay(j2, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j2) {
        return getMonthDayOfWeekDay(j2, Locale.getDefault());
    }

    public static String getYearMonth(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - TimeZone.getDefault().getOffset(j2), 36);
    }

    public static String getYearMonthDay(long j2) {
        return getYearMonthDay(j2, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j2) {
        return getYearMonthDayOfWeekDay(j2, Locale.getDefault());
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l5, @Nullable Long l6, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l5 == null && l6 == null) {
            return Pair.create(null, null);
        }
        if (l5 == null) {
            return Pair.create(null, getDateString(l6.longValue(), simpleDateFormat));
        }
        if (l6 == null) {
            return Pair.create(getDateString(l5.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l5.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l6.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l5.longValue())), simpleDateFormat.format(new Date(l6.longValue())));
        } else if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.create(getMonthDay(l5.longValue(), Locale.getDefault()), getMonthDay(l6.longValue(), Locale.getDefault()));
            }
            return Pair.create(getMonthDay(l5.longValue(), Locale.getDefault()), getYearMonthDay(l6.longValue(), Locale.getDefault()));
        } else {
            return Pair.create(getYearMonthDay(l5.longValue(), Locale.getDefault()), getYearMonthDay(l6.longValue(), Locale.getDefault()));
        }
    }

    public static String getDateString(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j2);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j2));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j2);
        }
        return getYearMonthDay(j2);
    }

    public static String getMonthDay(long j2, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j2));
            return format;
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j2));
    }

    public static String getMonthDayOfWeekDay(long j2, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j2));
            return format;
        }
        return UtcDates.getFullFormat(locale).format(new Date(j2));
    }

    public static String getYearMonthDay(long j2, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j2));
            return format;
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j2));
    }

    public static String getYearMonthDayOfWeekDay(long j2, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j2));
            return format;
        }
        return UtcDates.getFullFormat(locale).format(new Date(j2));
    }
}
