package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.timepicker.TimePickerView;
import java.lang.reflect.Field;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;
    private final TextWatcher minuteTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setMinute(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setMinute(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final TextWatcher hourTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setHour(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setHour(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = chipTextInputComboView2;
        int i3 = R.id.material_label;
        ((TextView) chipTextInputComboView.findViewById(i3)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i3)).setText(resources.getString(R.string.material_timepicker_hour));
        int i5 = R.id.selection_type;
        chipTextInputComboView.setTag(i5, 12);
        chipTextInputComboView2.setTag(i5, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        chipTextInputComboView2.addInputFilter(timeModel.getHourInputValidator());
        chipTextInputComboView.addInputFilter(timeModel.getMinuteInputValidator());
        this.hourEditText = chipTextInputComboView2.getTextInput().getEditText();
        this.minuteEditText = chipTextInputComboView.getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection));
        initialize();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private static void setCursorDrawableColor(EditText editText, @ColorInt int i3) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i5 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawable = AppCompatResources.getDrawable(context, i5);
            drawable.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawable, drawable});
        } catch (Throwable unused) {
        }
    }

    private void setTime(TimeModel timeModel) {
        removeTextWatchers();
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.minute));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(format);
        this.hourTextInput.setText(format2);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i3, boolean z3) {
                int i5;
                if (i3 == R.id.material_clock_period_pm_button) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                TimePickerTextInputPresenter.this.time.setPeriod(i5);
            }
        });
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        int i3;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup == null) {
            return;
        }
        if (this.time.period == 0) {
            i3 = R.id.material_clock_period_am_button;
        } else {
            i3 = R.id.material_clock_period_pm_button;
        }
        materialButtonToggleGroup.check(i3);
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild == null) {
            this.timePickerView.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.timePickerView.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i3) {
        boolean z3;
        this.time.selection = i3;
        ChipTextInputComboView chipTextInputComboView = this.minuteTextInput;
        boolean z5 = false;
        if (i3 == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.hourTextInput;
        if (i3 == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
        updateSelection();
    }

    public void resetChecked() {
        boolean z3;
        ChipTextInputComboView chipTextInputComboView = this.minuteTextInput;
        boolean z5 = false;
        if (this.time.selection == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.hourTextInput;
        if (this.time.selection == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}
