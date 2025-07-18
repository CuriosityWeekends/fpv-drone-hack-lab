package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class OpReorderer {
    final Callback mCallback;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i3, int i5, int i6, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z3 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd == 8) {
                if (z3) {
                    return size;
                }
            } else {
                z3 = true;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i3, AdapterHelper.UpdateOp updateOp, int i5, AdapterHelper.UpdateOp updateOp2) {
        int i6;
        int i7 = updateOp.itemCount;
        int i8 = updateOp2.positionStart;
        if (i7 < i8) {
            i6 = -1;
        } else {
            i6 = 0;
        }
        int i9 = updateOp.positionStart;
        if (i9 < i8) {
            i6++;
        }
        if (i8 <= i9) {
            updateOp.positionStart = i9 + updateOp2.itemCount;
        }
        int i10 = updateOp2.positionStart;
        if (i10 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i10 + i6;
        list.set(i3, updateOp2);
        list.set(i5, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i3, int i5) {
        AdapterHelper.UpdateOp updateOp = list.get(i3);
        AdapterHelper.UpdateOp updateOp2 = list.get(i5);
        int i6 = updateOp2.cmd;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 4) {
                    swapMoveUpdate(list, i3, updateOp, i5, updateOp2);
                    return;
                }
                return;
            }
            swapMoveRemove(list, i3, updateOp, i5, updateOp2);
            return;
        }
        swapMoveAdd(list, i3, updateOp, i5, updateOp2);
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i3, AdapterHelper.UpdateOp updateOp, int i5, AdapterHelper.UpdateOp updateOp2) {
        boolean z3;
        int i6 = updateOp.positionStart;
        int i7 = updateOp.itemCount;
        boolean z5 = false;
        if (i6 < i7) {
            if (updateOp2.positionStart == i6 && updateOp2.itemCount == i7 - i6) {
                z3 = false;
                z5 = true;
            } else {
                z3 = false;
            }
        } else if (updateOp2.positionStart == i7 + 1 && updateOp2.itemCount == i6 - i7) {
            z3 = true;
            z5 = true;
        } else {
            z3 = true;
        }
        int i8 = updateOp2.positionStart;
        if (i7 < i8) {
            updateOp2.positionStart = i8 - 1;
        } else {
            int i9 = updateOp2.itemCount;
            if (i7 < i8 + i9) {
                updateOp2.itemCount = i9 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i5);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i10 = updateOp.positionStart;
        int i11 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i10 <= i11) {
            updateOp2.positionStart = i11 + 1;
        } else {
            int i12 = updateOp2.itemCount;
            if (i10 < i11 + i12) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i10 + 1, (i11 + i12) - i10, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z5) {
            list.set(i3, updateOp2);
            list.remove(i5);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z3) {
            if (updateOp3 != null) {
                int i13 = updateOp.positionStart;
                if (i13 > updateOp3.positionStart) {
                    updateOp.positionStart = i13 - updateOp3.itemCount;
                }
                int i14 = updateOp.itemCount;
                if (i14 > updateOp3.positionStart) {
                    updateOp.itemCount = i14 - updateOp3.itemCount;
                }
            }
            int i15 = updateOp.positionStart;
            if (i15 > updateOp2.positionStart) {
                updateOp.positionStart = i15 - updateOp2.itemCount;
            }
            int i16 = updateOp.itemCount;
            if (i16 > updateOp2.positionStart) {
                updateOp.itemCount = i16 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i17 = updateOp.positionStart;
                if (i17 >= updateOp3.positionStart) {
                    updateOp.positionStart = i17 - updateOp3.itemCount;
                }
                int i18 = updateOp.itemCount;
                if (i18 >= updateOp3.positionStart) {
                    updateOp.itemCount = i18 - updateOp3.itemCount;
                }
            }
            int i19 = updateOp.positionStart;
            if (i19 >= updateOp2.positionStart) {
                updateOp.positionStart = i19 - updateOp2.itemCount;
            }
            int i20 = updateOp.itemCount;
            if (i20 >= updateOp2.positionStart) {
                updateOp.itemCount = i20 - updateOp2.itemCount;
            }
        }
        list.set(i3, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i5, updateOp);
        } else {
            list.remove(i5);
        }
        if (updateOp3 != null) {
            list.add(i3, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.positionStart = r1
            goto L20
        Ld:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.positionStart = r5
            goto L41
        L2b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.mCallback
            int r1 = r1 + r3
            java.lang.Object r3 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.obtainUpdateOp(r2, r1, r5, r3)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
