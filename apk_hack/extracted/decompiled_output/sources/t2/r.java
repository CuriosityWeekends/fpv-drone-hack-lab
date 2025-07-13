package t2;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CompoundButton;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.SettingActivity;
import com.lg.picturesubmitt.activity.TrinityActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3714a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r(int i3, Object obj) {
        this.f3714a = i3;
        this.b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
        switch (this.f3714a) {
            case 0:
                switch (compoundButton.getId()) {
                    case 2131230898:
                        MainActivityDecode mainActivityDecode = (MainActivityDecode) this.b;
                        if (mainActivityDecode.f662u0) {
                            mainActivityDecode.O0.setOnCheckedChangeListener(null);
                            ((MainActivityDecode) this.b).O0.setChecked(!z3);
                            MainActivityDecode mainActivityDecode2 = (MainActivityDecode) this.b;
                            mainActivityDecode2.O0.setOnCheckedChangeListener(mainActivityDecode2.K1);
                            MainActivityDecode mainActivityDecode3 = (MainActivityDecode) this.b;
                            mainActivityDecode3.y(mainActivityDecode3.getString(2131755182));
                            return;
                        } else if (mainActivityDecode.f673y0) {
                            mainActivityDecode.O0.setOnCheckedChangeListener(null);
                            ((MainActivityDecode) this.b).O0.setChecked(!z3);
                            MainActivityDecode mainActivityDecode4 = (MainActivityDecode) this.b;
                            mainActivityDecode4.O0.setOnCheckedChangeListener(mainActivityDecode4.K1);
                            MainActivityDecode mainActivityDecode5 = (MainActivityDecode) this.b;
                            mainActivityDecode5.y(mainActivityDecode5.getString(2131755319));
                            return;
                        } else if (z3) {
                            if (mainActivityDecode.V0) {
                                mainActivityDecode.f645o.setVisibility(8);
                            } else {
                                mainActivityDecode.f642n.setVisibility(8);
                            }
                            ((MainActivityDecode) this.b).f636l.setVisibility(4);
                            ((MainActivityDecode) this.b).f622g.setVisibility(4);
                            if (((MainActivityDecode) this.b).f674y1) {
                                ((MainActivityDecode) this.b).T.setVisibility(0);
                            } else {
                                ((MainActivityDecode) this.b).S.setVisibility(0);
                                ((MainActivityDecode) this.b).f648p.setVisibility(0);
                            }
                            ((MainActivityDecode) this.b).P0.setClickable(false);
                            return;
                        } else {
                            if (mainActivityDecode.f674y1) {
                                ((MainActivityDecode) this.b).R.a();
                                ((MainActivityDecode) this.b).T.setVisibility(8);
                            } else {
                                ((MainActivityDecode) this.b).Q.a();
                                ((MainActivityDecode) this.b).S.setVisibility(8);
                                ((MainActivityDecode) this.b).f648p.setVisibility(8);
                            }
                            MainActivityDecode mainActivityDecode6 = (MainActivityDecode) this.b;
                            if (mainActivityDecode6.V0) {
                                mainActivityDecode6.f645o.setVisibility(0);
                            } else {
                                mainActivityDecode6.f642n.setVisibility(0);
                            }
                            ((MainActivityDecode) this.b).f636l.setVisibility(0);
                            ((MainActivityDecode) this.b).f622g.setVisibility(0);
                            ((MainActivityDecode) this.b).P0.setClickable(true);
                            return;
                        }
                    case 2131230900:
                        if (z3) {
                            ((MainActivityDecode) this.b).Q0.setVisibility(0);
                            ((MainActivityDecode) this.b).M0.setVisibility(0);
                            ((MainActivityDecode) this.b).N0.setVisibility(0);
                            return;
                        }
                        ((MainActivityDecode) this.b).Q0.setVisibility(8);
                        ((MainActivityDecode) this.b).M0.setVisibility(8);
                        ((MainActivityDecode) this.b).N0.setVisibility(8);
                        return;
                    case 2131230901:
                        ((MainActivityDecode) this.b).U0 = z3;
                        return;
                    case 2131230905:
                        if (z3) {
                            ((MainActivityDecode) this.b).A.setVisibility(0);
                            ((MainActivityDecode) this.b).f633k.setVisibility(0);
                            ((MainActivityDecode) this.b).f675z.setVisibility(0);
                            if (((MainActivityDecode) this.b).f671x1) {
                                MainActivityDecode mainActivityDecode7 = (MainActivityDecode) this.b;
                                if (mainActivityDecode7.V0) {
                                    mainActivityDecode7.f645o.setVisibility(0);
                                    ((MainActivityDecode) this.b).O.setShow(true);
                                    ((MainActivityDecode) this.b).P.setShow(true);
                                } else {
                                    mainActivityDecode7.f642n.setVisibility(0);
                                    ((MainActivityDecode) this.b).M.setShow(true);
                                    ((MainActivityDecode) this.b).N.setShow(true);
                                }
                                ((MainActivityDecode) this.b).f622g.setVisibility(0);
                                ((MainActivityDecode) this.b).f636l.setVisibility(0);
                                ((MainActivityDecode) this.b).x(true);
                            } else {
                                MainActivityDecode mainActivityDecode8 = (MainActivityDecode) this.b;
                                if (mainActivityDecode8.V0) {
                                    mainActivityDecode8.f645o.setVisibility(8);
                                } else {
                                    mainActivityDecode8.f642n.setVisibility(8);
                                }
                                ((MainActivityDecode) this.b).f622g.setVisibility(8);
                                ((MainActivityDecode) this.b).f636l.setVisibility(8);
                            }
                            ((MainActivityDecode) this.b).f613c0.c(false);
                            return;
                        }
                        MainActivityDecode mainActivityDecode9 = (MainActivityDecode) this.b;
                        mainActivityDecode9.x(mainActivityDecode9.f671x1);
                        MainActivityDecode mainActivityDecode10 = (MainActivityDecode) this.b;
                        if (mainActivityDecode10.f662u0) {
                            mainActivityDecode10.f662u0 = false;
                            if (mainActivityDecode10.V0) {
                                mainActivityDecode10.P.setGravity(false);
                                ((MainActivityDecode) this.b).P.setStopUI(false);
                                ((MainActivityDecode) this.b).O.setStopUI(false);
                            } else {
                                mainActivityDecode10.N.setGravity(false);
                            }
                            MainActivityDecode mainActivityDecode11 = (MainActivityDecode) this.b;
                            mainActivityDecode11.F.setBackground(mainActivityDecode11.getDrawable(2131558468));
                        }
                        ((MainActivityDecode) this.b).A.setVisibility(8);
                        ((MainActivityDecode) this.b).f633k.setVisibility(8);
                        MainActivityDecode mainActivityDecode12 = (MainActivityDecode) this.b;
                        if (mainActivityDecode12.V0) {
                            mainActivityDecode12.f645o.setVisibility(8);
                        } else {
                            mainActivityDecode12.f642n.setVisibility(8);
                        }
                        ((MainActivityDecode) this.b).f622g.setVisibility(8);
                        ((MainActivityDecode) this.b).f636l.setVisibility(8);
                        ((MainActivityDecode) this.b).f675z.setVisibility(4);
                        ((MainActivityDecode) this.b).f613c0.c(true);
                        return;
                    case 2131230916:
                        ((MainActivityDecode) this.b).Y.setProgress(0.0f);
                        ((MainActivityDecode) this.b).W.setScaleValue(1.0f);
                        if (z3) {
                            ((MainActivityDecode) this.b).X.setVisibility(0);
                            return;
                        }
                        Log.d("MainActivityDecode", "isChecked--" + z3);
                        ((MainActivityDecode) this.b).X.setVisibility(8);
                        return;
                    default:
                        return;
                }
            case 1:
                switch (compoundButton.getId()) {
                    case 2131230898:
                        MainActivityNew mainActivityNew = (MainActivityNew) this.b;
                        if (mainActivityNew.f727t0) {
                            mainActivityNew.N0.setOnCheckedChangeListener(null);
                            ((MainActivityNew) this.b).N0.setChecked(!z3);
                            MainActivityNew mainActivityNew2 = (MainActivityNew) this.b;
                            mainActivityNew2.N0.setOnCheckedChangeListener(mainActivityNew2.J1);
                            MainActivityNew mainActivityNew3 = (MainActivityNew) this.b;
                            mainActivityNew3.y(mainActivityNew3.getString(2131755182));
                            return;
                        } else if (mainActivityNew.f738x0) {
                            mainActivityNew.N0.setOnCheckedChangeListener(null);
                            ((MainActivityNew) this.b).N0.setChecked(!z3);
                            MainActivityNew mainActivityNew4 = (MainActivityNew) this.b;
                            mainActivityNew4.N0.setOnCheckedChangeListener(mainActivityNew4.J1);
                            MainActivityNew mainActivityNew5 = (MainActivityNew) this.b;
                            mainActivityNew5.y(mainActivityNew5.getString(2131755319));
                            return;
                        } else if (z3) {
                            if (mainActivityNew.U0) {
                                mainActivityNew.f713o.setVisibility(8);
                            } else {
                                mainActivityNew.f710n.setVisibility(8);
                            }
                            ((MainActivityNew) this.b).f704l.setVisibility(4);
                            ((MainActivityNew) this.b).f690g.setVisibility(4);
                            if (((MainActivityNew) this.b).f739x1) {
                                ((MainActivityNew) this.b).T.setVisibility(0);
                            } else {
                                ((MainActivityNew) this.b).S.setVisibility(0);
                                ((MainActivityNew) this.b).f716p.setVisibility(0);
                            }
                            ((MainActivityNew) this.b).O0.setClickable(false);
                            return;
                        } else {
                            if (mainActivityNew.f739x1) {
                                ((MainActivityNew) this.b).R.a();
                                ((MainActivityNew) this.b).T.setVisibility(8);
                            } else {
                                ((MainActivityNew) this.b).Q.a();
                                ((MainActivityNew) this.b).S.setVisibility(8);
                                ((MainActivityNew) this.b).f716p.setVisibility(8);
                            }
                            MainActivityNew mainActivityNew6 = (MainActivityNew) this.b;
                            if (mainActivityNew6.U0) {
                                mainActivityNew6.f713o.setVisibility(0);
                            } else {
                                mainActivityNew6.f710n.setVisibility(0);
                            }
                            ((MainActivityNew) this.b).f704l.setVisibility(0);
                            ((MainActivityNew) this.b).f690g.setVisibility(0);
                            ((MainActivityNew) this.b).O0.setClickable(true);
                            return;
                        }
                    case 2131230900:
                        if (z3) {
                            ((MainActivityNew) this.b).P0.setVisibility(0);
                            ((MainActivityNew) this.b).L0.setVisibility(0);
                            ((MainActivityNew) this.b).M0.setVisibility(0);
                            return;
                        }
                        ((MainActivityNew) this.b).P0.setVisibility(8);
                        ((MainActivityNew) this.b).L0.setVisibility(8);
                        ((MainActivityNew) this.b).M0.setVisibility(8);
                        return;
                    case 2131230901:
                        ((MainActivityNew) this.b).T0 = z3;
                        return;
                    case 2131230905:
                        if (z3) {
                            ((MainActivityNew) this.b).A.setVisibility(0);
                            ((MainActivityNew) this.b).f701k.setVisibility(0);
                            ((MainActivityNew) this.b).f743z.setVisibility(0);
                            if (((MainActivityNew) this.b).f736w1) {
                                MainActivityNew mainActivityNew7 = (MainActivityNew) this.b;
                                if (mainActivityNew7.U0) {
                                    mainActivityNew7.f713o.setVisibility(0);
                                    ((MainActivityNew) this.b).O.setShow(true);
                                    ((MainActivityNew) this.b).P.setShow(true);
                                } else {
                                    mainActivityNew7.f710n.setVisibility(0);
                                    ((MainActivityNew) this.b).M.setShow(true);
                                    ((MainActivityNew) this.b).N.setShow(true);
                                }
                                ((MainActivityNew) this.b).f690g.setVisibility(0);
                                ((MainActivityNew) this.b).f704l.setVisibility(0);
                                ((MainActivityNew) this.b).x(true);
                            } else {
                                MainActivityNew mainActivityNew8 = (MainActivityNew) this.b;
                                if (mainActivityNew8.U0) {
                                    mainActivityNew8.f713o.setVisibility(8);
                                } else {
                                    mainActivityNew8.f710n.setVisibility(8);
                                }
                                ((MainActivityNew) this.b).f690g.setVisibility(8);
                                ((MainActivityNew) this.b).f704l.setVisibility(8);
                            }
                            ((MainActivityNew) this.b).f681c0.c(false);
                            return;
                        }
                        MainActivityNew mainActivityNew9 = (MainActivityNew) this.b;
                        mainActivityNew9.x(mainActivityNew9.f736w1);
                        MainActivityNew mainActivityNew10 = (MainActivityNew) this.b;
                        if (mainActivityNew10.f727t0) {
                            mainActivityNew10.f727t0 = false;
                            if (mainActivityNew10.U0) {
                                mainActivityNew10.P.setGravity(false);
                                ((MainActivityNew) this.b).P.setStopUI(false);
                                ((MainActivityNew) this.b).O.setStopUI(false);
                            } else {
                                mainActivityNew10.N.setGravity(false);
                            }
                            MainActivityNew mainActivityNew11 = (MainActivityNew) this.b;
                            mainActivityNew11.F.setBackground(mainActivityNew11.getDrawable(2131558468));
                        }
                        ((MainActivityNew) this.b).A.setVisibility(8);
                        ((MainActivityNew) this.b).f701k.setVisibility(8);
                        MainActivityNew mainActivityNew12 = (MainActivityNew) this.b;
                        if (mainActivityNew12.U0) {
                            mainActivityNew12.f713o.setVisibility(8);
                        } else {
                            mainActivityNew12.f710n.setVisibility(8);
                        }
                        ((MainActivityNew) this.b).f690g.setVisibility(8);
                        ((MainActivityNew) this.b).f704l.setVisibility(8);
                        ((MainActivityNew) this.b).f743z.setVisibility(4);
                        ((MainActivityNew) this.b).f681c0.c(true);
                        return;
                    case 2131230916:
                        ((MainActivityNew) this.b).Y.setProgress(0.0f);
                        ((MainActivityNew) this.b).W.setScaleValue(1.0f);
                        if (z3) {
                            ((MainActivityNew) this.b).X.setVisibility(0);
                            return;
                        }
                        Log.d("MainActivityNew", "isChecked--" + z3);
                        ((MainActivityNew) this.b).X.setVisibility(8);
                        return;
                    default:
                        return;
                }
            case 2:
                switch (compoundButton.getId()) {
                    case 2131230898:
                        MainActivityRTSP mainActivityRTSP = (MainActivityRTSP) this.b;
                        if (mainActivityRTSP.f785q0) {
                            mainActivityRTSP.K0.setOnCheckedChangeListener(null);
                            ((MainActivityRTSP) this.b).K0.setChecked(!z3);
                            MainActivityRTSP mainActivityRTSP2 = (MainActivityRTSP) this.b;
                            mainActivityRTSP2.K0.setOnCheckedChangeListener(mainActivityRTSP2.f772k1);
                            MainActivityRTSP mainActivityRTSP3 = (MainActivityRTSP) this.b;
                            mainActivityRTSP3.C(mainActivityRTSP3.getString(2131755182));
                            return;
                        } else if (mainActivityRTSP.f792u0) {
                            mainActivityRTSP.K0.setOnCheckedChangeListener(null);
                            ((MainActivityRTSP) this.b).K0.setChecked(!z3);
                            MainActivityRTSP mainActivityRTSP4 = (MainActivityRTSP) this.b;
                            mainActivityRTSP4.K0.setOnCheckedChangeListener(mainActivityRTSP4.f772k1);
                            MainActivityRTSP mainActivityRTSP5 = (MainActivityRTSP) this.b;
                            mainActivityRTSP5.C(mainActivityRTSP5.getString(2131755319));
                            return;
                        } else if (z3) {
                            if (mainActivityRTSP.Q0) {
                                mainActivityRTSP.f781o.setVisibility(8);
                            } else {
                                mainActivityRTSP.f779n.setVisibility(8);
                            }
                            ((MainActivityRTSP) this.b).f773l.setVisibility(4);
                            ((MainActivityRTSP) this.b).f759g.setVisibility(4);
                            ((MainActivityRTSP) this.b).R.setVisibility(0);
                            ((MainActivityRTSP) this.b).f783p.setVisibility(0);
                            ((MainActivityRTSP) this.b).L0.setClickable(false);
                            return;
                        } else {
                            mainActivityRTSP.Q.a();
                            ((MainActivityRTSP) this.b).R.setVisibility(8);
                            ((MainActivityRTSP) this.b).f783p.setVisibility(8);
                            MainActivityRTSP mainActivityRTSP6 = (MainActivityRTSP) this.b;
                            if (mainActivityRTSP6.Q0) {
                                mainActivityRTSP6.f781o.setVisibility(0);
                            } else {
                                mainActivityRTSP6.f779n.setVisibility(0);
                            }
                            ((MainActivityRTSP) this.b).f773l.setVisibility(0);
                            ((MainActivityRTSP) this.b).f759g.setVisibility(0);
                            ((MainActivityRTSP) this.b).L0.setClickable(true);
                            return;
                        }
                    case 2131230900:
                        if (z3) {
                            ((MainActivityRTSP) this.b).M0.setVisibility(0);
                            ((MainActivityRTSP) this.b).I0.setVisibility(0);
                            ((MainActivityRTSP) this.b).J0.setVisibility(0);
                            return;
                        }
                        ((MainActivityRTSP) this.b).M0.setVisibility(8);
                        ((MainActivityRTSP) this.b).I0.setVisibility(8);
                        ((MainActivityRTSP) this.b).J0.setVisibility(8);
                        return;
                    case 2131230901:
                        int i3 = MainActivityRTSP.f746n1;
                        ((MainActivityRTSP) this.b).getClass();
                        return;
                    case 2131230905:
                        if (z3) {
                            ((MainActivityRTSP) this.b).A.setVisibility(0);
                            ((MainActivityRTSP) this.b).f770k.setVisibility(0);
                            ((MainActivityRTSP) this.b).f800z.setVisibility(0);
                            if (((MainActivityRTSP) this.b).f751c1) {
                                MainActivityRTSP mainActivityRTSP7 = (MainActivityRTSP) this.b;
                                if (mainActivityRTSP7.Q0) {
                                    mainActivityRTSP7.f781o.setVisibility(0);
                                    ((MainActivityRTSP) this.b).O.setShow(true);
                                    ((MainActivityRTSP) this.b).P.setShow(true);
                                } else {
                                    mainActivityRTSP7.f779n.setVisibility(0);
                                    ((MainActivityRTSP) this.b).M.setShow(true);
                                    ((MainActivityRTSP) this.b).N.setShow(true);
                                }
                                ((MainActivityRTSP) this.b).f759g.setVisibility(0);
                                ((MainActivityRTSP) this.b).f773l.setVisibility(0);
                                ((MainActivityRTSP) this.b).B(true);
                            } else {
                                MainActivityRTSP mainActivityRTSP8 = (MainActivityRTSP) this.b;
                                if (mainActivityRTSP8.Q0) {
                                    mainActivityRTSP8.f781o.setVisibility(8);
                                } else {
                                    mainActivityRTSP8.f779n.setVisibility(8);
                                }
                                ((MainActivityRTSP) this.b).f759g.setVisibility(8);
                                ((MainActivityRTSP) this.b).f773l.setVisibility(8);
                            }
                            ((MainActivityRTSP) this.b).c.setStopSendUdp(false);
                            return;
                        }
                        MainActivityRTSP mainActivityRTSP9 = (MainActivityRTSP) this.b;
                        mainActivityRTSP9.B(mainActivityRTSP9.f751c1);
                        MainActivityRTSP mainActivityRTSP10 = (MainActivityRTSP) this.b;
                        if (mainActivityRTSP10.f785q0) {
                            mainActivityRTSP10.f785q0 = false;
                            if (mainActivityRTSP10.Q0) {
                                mainActivityRTSP10.P.setGravity(false);
                                ((MainActivityRTSP) this.b).P.setStopUI(false);
                                ((MainActivityRTSP) this.b).O.setStopUI(false);
                            } else {
                                mainActivityRTSP10.N.setGravity(false);
                            }
                            MainActivityRTSP mainActivityRTSP11 = (MainActivityRTSP) this.b;
                            mainActivityRTSP11.F.setBackground(mainActivityRTSP11.getDrawable(2131558468));
                        }
                        ((MainActivityRTSP) this.b).A.setVisibility(8);
                        ((MainActivityRTSP) this.b).f770k.setVisibility(8);
                        MainActivityRTSP mainActivityRTSP12 = (MainActivityRTSP) this.b;
                        if (mainActivityRTSP12.Q0) {
                            mainActivityRTSP12.f781o.setVisibility(8);
                        } else {
                            mainActivityRTSP12.f779n.setVisibility(8);
                        }
                        ((MainActivityRTSP) this.b).f759g.setVisibility(8);
                        ((MainActivityRTSP) this.b).f773l.setVisibility(8);
                        ((MainActivityRTSP) this.b).f800z.setVisibility(4);
                        ((MainActivityRTSP) this.b).c.setStopSendUdp(true);
                        return;
                    case 2131230916:
                        ((MainActivityRTSP) this.b).f754e0.setProgress(0.0f);
                        ((MainActivityRTSP) this.b).f750c0.setScaleValue(1.0f);
                        if (z3) {
                            ((MainActivityRTSP) this.b).f752d0.setVisibility(0);
                            return;
                        }
                        Log.d("MainActivityRTSP", "isChecked--" + z3);
                        ((MainActivityRTSP) this.b).f752d0.setVisibility(8);
                        return;
                    default:
                        return;
                }
            case 3:
                SharedPreferences.Editor editor = (SharedPreferences.Editor) ((SettingActivity) this.b).c.c;
                editor.putBoolean("isRightMode", z3);
                editor.commit();
                return;
            case 4:
                int id = compoundButton.getId();
                TrinityActivity trinityActivity = (TrinityActivity) this.b;
                switch (id) {
                    case 2131230898:
                        if (z3) {
                            if (trinityActivity.f858q0) {
                                trinityActivity.C.performClick();
                            }
                            if (trinityActivity.J0) {
                                trinityActivity.f849n.setVisibility(8);
                            } else {
                                trinityActivity.f846m.setVisibility(8);
                            }
                            trinityActivity.f840k.setVisibility(4);
                            trinityActivity.f826f.setVisibility(4);
                            trinityActivity.N.setVisibility(0);
                            trinityActivity.f852o.setVisibility(0);
                            trinityActivity.q.setClickable(false);
                            return;
                        }
                        trinityActivity.M.a();
                        trinityActivity.N.setVisibility(8);
                        trinityActivity.f852o.setVisibility(8);
                        if (trinityActivity.J0) {
                            trinityActivity.f849n.setVisibility(0);
                        } else {
                            trinityActivity.f846m.setVisibility(0);
                        }
                        trinityActivity.f840k.setVisibility(0);
                        trinityActivity.f826f.setVisibility(0);
                        trinityActivity.q.setClickable(true);
                        return;
                    case 2131230900:
                        if (z3) {
                            trinityActivity.E0.setVisibility(0);
                            trinityActivity.C0.setVisibility(0);
                            return;
                        }
                        trinityActivity.E0.setVisibility(8);
                        trinityActivity.C0.setVisibility(8);
                        return;
                    case 2131230901:
                        trinityActivity.I0 = z3;
                        return;
                    case 2131230916:
                        trinityActivity.S.setProgress(0.0f);
                        trinityActivity.Q.setScaleValue(1.0f);
                        if (z3) {
                            trinityActivity.R.setVisibility(0);
                            return;
                        }
                        Log.d("TrinityActivity", "isChecked--" + z3);
                        trinityActivity.R.setVisibility(8);
                        return;
                    default:
                        return;
                }
            default:
                v2.b bVar = (v2.b) this.b;
                if (z3) {
                    bVar.d.a(4);
                } else {
                    bVar.d.a(5);
                }
                bVar.a();
                return;
        }
    }
}
