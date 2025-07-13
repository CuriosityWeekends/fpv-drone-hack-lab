package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    @Nullable
    private final Long fixedTimeMs;
    @Nullable
    private final TimeZone fixedTimeZone;

    private TimeSource(@Nullable Long l5, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l5;
        this.fixedTimeZone = timeZone;
    }

    public static TimeSource fixed(long j2, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j2), timeZone);
    }

    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    public static TimeSource fixed(long j2) {
        return new TimeSource(Long.valueOf(j2), null);
    }

    public Calendar now(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l5 = this.fixedTimeMs;
        if (l5 != null) {
            calendar.setTimeInMillis(l5.longValue());
        }
        return calendar;
    }
}
