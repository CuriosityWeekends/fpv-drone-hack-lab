package pl.droidsonroids.gif;

import androidx.core.view.PointerIconCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public enum d {
    NO_ERROR(0, 0),
    OPEN_FAILED(1, 101),
    /* JADX INFO: Fake field, exist only in values array */
    READ_FAILED(2, 102),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_GIF_FILE(3, 103),
    /* JADX INFO: Fake field, exist only in values array */
    NO_SCRN_DSCR(4, 104),
    /* JADX INFO: Fake field, exist only in values array */
    NO_IMAG_DSCR(5, 105),
    /* JADX INFO: Fake field, exist only in values array */
    NO_COLOR_MAP(6, 106),
    /* JADX INFO: Fake field, exist only in values array */
    WRONG_RECORD(7, 107),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_TOO_BIG(8, 108),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_ENOUGH_MEM(9, 109),
    /* JADX INFO: Fake field, exist only in values array */
    CLOSE_FAILED(10, 110),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(11, 111),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(12, 112),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(13, 113),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(14, 1000),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(15, PointerIconCompat.TYPE_CONTEXT_MENU),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(16, PointerIconCompat.TYPE_HAND),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(17, PointerIconCompat.TYPE_HELP),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(18, 1004),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(19, 1005),
    UNKNOWN(20, -1);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f3298a;
    public int b;

    d(int i3, int i5) {
        this.b = i5;
        this.f3298a = r2;
    }
}
