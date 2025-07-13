package g1;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import g2.n;
import g2.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements b1.b {

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f1901a = new c0.b();
    public final n b = new n();
    public u c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b1.b
    public final Metadata a(b1.d dVar) {
        Object obj;
        boolean z3;
        int i3;
        long j2;
        ArrayList arrayList;
        long j5;
        long j6;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        int i6;
        int i7;
        boolean z8;
        boolean z9;
        boolean z10;
        long j7;
        long j8;
        boolean z11;
        boolean z12;
        List list;
        long j9;
        long j10;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i8;
        int i9;
        int i10;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        long j11;
        boolean z21;
        long j12;
        int i11 = 32;
        ByteBuffer byteBuffer = dVar.b;
        byteBuffer.getClass();
        u uVar = this.c;
        if (uVar == null || dVar.f126f != uVar.c()) {
            u uVar2 = new u(dVar.c);
            this.c = uVar2;
            uVar2.a(dVar.c - dVar.f126f);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        c0.b bVar = this.f1901a;
        bVar.w(array, limit);
        n nVar = this.b;
        nVar.k(array, limit);
        nVar.o(39);
        long g5 = (nVar.g(1) << 32) | nVar.g(32);
        nVar.o(20);
        int g6 = nVar.g(12);
        int g7 = nVar.g(8);
        bVar.z(14);
        if (g7 != 0) {
            if (g7 != 255) {
                long j13 = 1;
                long j14 = -9223372036854775807L;
                if (g7 != 4) {
                    if (g7 != 5) {
                        if (g7 != 6) {
                            obj = null;
                        } else {
                            u uVar3 = this.c;
                            long c = TimeSignalCommand.c(bVar, g5);
                            obj = new TimeSignalCommand(c, uVar3.b(c));
                        }
                    } else {
                        u uVar4 = this.c;
                        long o5 = bVar.o();
                        if ((bVar.n() & 128) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        List emptyList = Collections.emptyList();
                        if (!z12) {
                            int n5 = bVar.n();
                            if ((n5 & 128) != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if ((n5 & 64) != 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if ((n5 & 32) != 0) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if ((n5 & 16) != 0) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z18 && !z20) {
                                j11 = TimeSignalCommand.c(bVar, g5);
                            } else {
                                j11 = -9223372036854775807L;
                            }
                            if (!z18) {
                                int n6 = bVar.n();
                                ArrayList arrayList2 = new ArrayList(n6);
                                for (int i12 = 0; i12 < n6; i12++) {
                                    int n7 = bVar.n();
                                    if (!z20) {
                                        j12 = TimeSignalCommand.c(bVar, g5);
                                    } else {
                                        j12 = -9223372036854775807L;
                                    }
                                    arrayList2.add(new b(n7, j12, uVar4.b(j12)));
                                }
                                emptyList = arrayList2;
                            }
                            if (z19) {
                                long n8 = bVar.n();
                                if ((n8 & 128) != 0) {
                                    z21 = true;
                                } else {
                                    z21 = false;
                                }
                                j14 = ((((n8 & 1) << 32) | bVar.o()) * 1000) / 90;
                            } else {
                                z21 = false;
                            }
                            int s = bVar.s();
                            int n9 = bVar.n();
                            z16 = z21;
                            i8 = s;
                            list = emptyList;
                            i10 = bVar.n();
                            i9 = n9;
                            z13 = z17;
                            j10 = j14;
                            j9 = j11;
                            z15 = z20;
                            z14 = z18;
                        } else {
                            list = emptyList;
                            j9 = -9223372036854775807L;
                            j10 = -9223372036854775807L;
                            z13 = false;
                            z14 = false;
                            z15 = false;
                            z16 = false;
                            i8 = 0;
                            i9 = 0;
                            i10 = 0;
                        }
                        obj = new SpliceInsertCommand(o5, z12, z13, z14, z15, j9, uVar4.b(j9), list, z16, j10, i8, i9, i10);
                    }
                } else {
                    int n10 = bVar.n();
                    ArrayList arrayList3 = new ArrayList(n10);
                    int i13 = 0;
                    while (i13 < n10) {
                        long o6 = bVar.o();
                        if ((bVar.n() & 128) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        if (!z3) {
                            int n11 = bVar.n();
                            if ((n11 & 128) != 0) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if ((n11 & 64) != 0) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if ((n11 & i11) != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z9) {
                                j7 = bVar.o();
                            } else {
                                j7 = -9223372036854775807L;
                            }
                            if (!z9) {
                                int n12 = bVar.n();
                                ArrayList arrayList5 = new ArrayList(n12);
                                int i14 = 0;
                                while (i14 < n12) {
                                    arrayList5.add(new c(bVar.n(), bVar.o()));
                                    i14++;
                                    i13 = i13;
                                }
                                i3 = i13;
                                arrayList4 = arrayList5;
                            } else {
                                i3 = i13;
                            }
                            if (z10) {
                                long n13 = bVar.n();
                                if ((n13 & 128) != 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                j2 = 1;
                                j8 = ((((n13 & 1) << 32) | bVar.o()) * 1000) / 90;
                            } else {
                                j2 = 1;
                                j8 = -9223372036854775807L;
                                z11 = false;
                            }
                            j6 = j8;
                            z7 = z11;
                            arrayList = arrayList4;
                            z5 = z8;
                            z6 = z9;
                            j5 = j7;
                            i5 = bVar.s();
                            i6 = bVar.n();
                            i7 = bVar.n();
                        } else {
                            i3 = i13;
                            j2 = j13;
                            arrayList = arrayList4;
                            j5 = -9223372036854775807L;
                            j6 = -9223372036854775807L;
                            z5 = false;
                            z6 = false;
                            z7 = false;
                            i5 = 0;
                            i6 = 0;
                            i7 = 0;
                        }
                        arrayList3.add(new d(o6, z3, z5, z6, arrayList, j5, z7, j6, i5, i6, i7));
                        i13 = i3 + 1;
                        j13 = j2;
                        i11 = 32;
                    }
                    obj = new SpliceScheduleCommand(arrayList3);
                }
            } else {
                long o7 = bVar.o();
                int i15 = g6 - 4;
                byte[] bArr = new byte[i15];
                bVar.b(bArr, 0, i15);
                obj = new PrivateCommand(o7, bArr, g5);
            }
        } else {
            obj = new Object();
        }
        if (obj == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(obj);
    }
}
