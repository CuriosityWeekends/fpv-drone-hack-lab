package androidx.appcompat.app;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j2, double d, double d5) {
        float f4;
        float f5;
        double d6;
        double d7 = (0.01720197f * (((float) (j2 - UTC_2000)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(f5 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f5) * 3.4906598739326E-4d) + (Math.sin(d7) * 0.03341960161924362d) + d7 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d7) * 0.0053d) + ((float) Math.round((f4 - J0) - d6)) + J0 + ((-d5) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d8 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d8))) / (Math.cos(asin) * Math.cos(d8));
        if (sin3 >= 1.0d) {
            this.state = 1;
            this.sunset = -1L;
            this.sunrise = -1L;
        } else if (sin3 <= -1.0d) {
            this.state = 0;
            this.sunset = -1L;
            this.sunrise = -1L;
        } else {
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.sunset = Math.round((sin2 + acos) * 8.64E7d) + UTC_2000;
            long round = Math.round((sin2 - acos) * 8.64E7d) + UTC_2000;
            this.sunrise = round;
            if (round < j2 && this.sunset > j2) {
                this.state = 0;
            } else {
                this.state = 1;
            }
        }
    }
}
