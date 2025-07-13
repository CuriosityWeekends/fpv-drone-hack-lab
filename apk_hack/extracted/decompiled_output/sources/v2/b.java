package v2;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import t2.r;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3887a;
    public final RelativeLayout b;
    public final d c;
    public a d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f3888e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f3889f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f3890g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f3891h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f3892i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f3893j;

    public b(Context context) {
        this.f3887a = context;
        View inflate = View.inflate(context, 2131427408, null);
        this.c = new d(context, inflate, -1, -1, 2131820549);
        ((RadioButton) inflate.findViewById(2131231280)).toggle();
        ((RadioButton) inflate.findViewById(2131231283)).toggle();
        ((RadioButton) inflate.findViewById(2131231278)).toggle();
        ((RadioGroup) inflate.findViewById(2131231302)).setOnCheckedChangeListener(this);
        ((RadioGroup) inflate.findViewById(2131231300)).setOnCheckedChangeListener(this);
        ((CheckBox) inflate.findViewById(2131230919)).setOnCheckedChangeListener(new r(5, this));
        inflate.findViewById(2131230858).setOnClickListener(this);
        inflate.findViewById(2131230869).setOnClickListener(this);
        inflate.findViewById(2131230883).setOnClickListener(this);
        ((RadioGroup) inflate.findViewById(2131231303)).setOnCheckedChangeListener(this);
        this.f3888e = (RelativeLayout) inflate.findViewById(2131231311);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(2131231114);
        this.b = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f3893j = (TextView) inflate.findViewById(2131231511);
        this.f3892i = (TextView) inflate.findViewById(2131231498);
        this.f3890g = (TextView) inflate.findViewById(2131231496);
        this.f3891h = (TextView) inflate.findViewById(2131231497);
        this.f3889f = (TextView) inflate.findViewById(2131231491);
    }

    public final void a() {
        Dialog dialog;
        d dVar = this.c;
        if (dVar != null && (dialog = dVar.b) != null && dialog.isShowing()) {
            dVar.b.dismiss();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
        int id = radioGroup.getId();
        Context context = this.f3887a;
        switch (id) {
            case 2131231300:
                switch (i3) {
                    case 2131231278:
                        this.d.a(5);
                        break;
                    case 2131231279:
                        this.d.a(4);
                        break;
                }
                a();
                return;
            case 2131231301:
            default:
                return;
            case 2131231302:
                if (i3 != 2131231280) {
                    if (i3 == 2131231285) {
                        this.f3893j.setText(context.getString(2131755373));
                        this.f3888e.setVisibility(8);
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f3893j.setText(context.getString(2131755154));
                this.f3888e.setVisibility(0);
                this.b.setVisibility(8);
                return;
            case 2131231303:
                switch (i3) {
                    case 2131231281:
                        this.d.a(3);
                        this.f3892i.setText(context.getString(2131755365));
                        this.f3890g.setTextColor(ContextCompat.getColor(context, 2131034173));
                        this.f3891h.setTextColor(ContextCompat.getColor(context, 2131034173));
                        this.f3889f.setTextColor(ContextCompat.getColor(context, 2131034172));
                        break;
                    case 2131231283:
                        this.d.a(1);
                        this.f3892i.setText(context.getString(2131755370));
                        this.f3890g.setTextColor(ContextCompat.getColor(context, 2131034172));
                        this.f3891h.setTextColor(ContextCompat.getColor(context, 2131034173));
                        this.f3889f.setTextColor(ContextCompat.getColor(context, 2131034173));
                        break;
                    case 2131231284:
                        this.d.a(2);
                        this.f3892i.setText(context.getString(2131755372));
                        this.f3890g.setTextColor(ContextCompat.getColor(context, 2131034173));
                        this.f3891h.setTextColor(ContextCompat.getColor(context, 2131034172));
                        this.f3889f.setTextColor(ContextCompat.getColor(context, 2131034173));
                        break;
                }
                a();
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id != 2131230858) {
            if (id != 2131230869) {
                if (id == 2131230883) {
                    a();
                    return;
                }
                return;
            }
            this.d.a(7);
            a();
            return;
        }
        this.d.a(6);
        a();
    }
}
