package com.summary.common.utils.phonemask;

import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import static com.summary.common.utils.phonemask.Utils.notDigitRegex;

public class PhoneMaskManager {
    private String mask = null;
    private String region = "";
    private ValueListener valueListener = null;
    private View.OnFocusChangeListener onFocusChangeListener = null;
    private String maskSymbol = "#";

    private PhoneMaskWatcher phoneMaskWatcher = null;

    public PhoneMaskManager withMask(String mask) {
        this.mask = mask;
        return this;
    }

    public PhoneMaskManager withRegion(String region) {
        this.region = region;
        return this;
    }

    public PhoneMaskManager withValueListener(ValueListener valueListener) {
        this.valueListener = valueListener;
        return this;
    }

    public PhoneMaskManager withOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.onFocusChangeListener = onFocusChangeListener;
        return this;
    }

    public PhoneMaskManager withMaskSymbol(String maskSymbol) {
        this.maskSymbol = maskSymbol;
        return this;
    }

    public String getPhone() {
        return phoneMaskWatcher.getPhone();
    }


    public PhoneMaskManager bindTo(final EditText editText) {
        Utils.validatePresetup(editText, mask);
        editText.setInputType(InputType.TYPE_CLASS_PHONE);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (editText.getText().toString().isEmpty()) {
                        editText.setText(region);
                    }
                } else {
                    String input = notDigitRegex.matcher(editText.getText().toString()).replaceAll("");
                    String region = notDigitRegex.matcher(PhoneMaskManager.this.region).replaceAll("");
                    if (input.equals(region)) {
                        editText.setText("");
                    }
                }

                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(v, hasFocus);
                }
            }
        });
        phoneMaskWatcher = new PhoneMaskWatcher(mask, region, valueListener, maskSymbol, editText);
        editText.addTextChangedListener(phoneMaskWatcher);
        return this;
    }
}