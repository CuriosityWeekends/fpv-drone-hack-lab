package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning = false;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    public TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.hourLayoutComboView = chipTextInputComboView;
        this.minuteLayoutComboView = chipTextInputComboView2;
        this.time = timeModel;
    }

    private void moveSelection(int i3) {
        boolean z3;
        ChipTextInputComboView chipTextInputComboView = this.minuteLayoutComboView;
        boolean z5 = false;
        if (i3 == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.hourLayoutComboView;
        if (i3 == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
        this.time.selection = i3;
    }

    private boolean onHourKeyPress(int i3, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null || i3 < 7 || i3 > 16 || keyEvent.getAction() != 1 || editText.getSelectionStart() != 2 || text.length() != 2) {
            return false;
        }
        moveSelection(12);
        return true;
    }

    private boolean onMinuteKeyPress(int i3, KeyEvent keyEvent, EditText editText) {
        if (i3 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            moveSelection(10);
            return true;
        }
        return false;
    }

    public void bind() {
        TextInputLayout textInput = this.hourLayoutComboView.getTextInput();
        TextInputLayout textInput2 = this.minuteLayoutComboView.getTextInput();
        EditText editText = textInput.getEditText();
        EditText editText2 = textInput2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z3;
        if (i3 == 5) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            moveSelection(12);
        }
        return z3;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        boolean onHourKeyPress;
        if (this.keyListenerRunning) {
            return false;
        }
        this.keyListenerRunning = true;
        EditText editText = (EditText) view;
        if (this.time.selection == 12) {
            onHourKeyPress = onMinuteKeyPress(i3, keyEvent, editText);
        } else {
            onHourKeyPress = onHourKeyPress(i3, keyEvent, editText);
        }
        this.keyListenerRunning = false;
        return onHourKeyPress;
    }
}
