package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.summary.common.base.BaseActivity;
import com.summary.common.utils.phonemask.PhoneMaskManager;
import com.summary.common.utils.phonemask.ValueListener;
import com.summary.common.view.UIXEditText;
import com.summary.sundy.R;

import butterknife.BindView;

public class XEditTextActivity extends BaseActivity {
    @BindView(R.id.text_edit_text)
    EditText defaultText;
    @BindView(R.id.clear_marker_edit_text)
    UIXEditText clearXEdit;
    @BindView(R.id.custom_edit_text)
    UIXEditText customXEdit;
    @BindView(R.id.show_separator_edit_text)
    UIXEditText showXEdit;
    @BindView(R.id.text1)
    TextView textView1;
    @BindView(R.id.text2)
    TextView textView2;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_xedit_text_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new PhoneMaskManager()
                .withMask(" (###) ###-##-##")
                .withRegion("+7")
                .withValueListener(new ValueListener() {
                    @Override
                    public void onPhoneChanged(String phone) {
                        Log.i("log_text", "onPhoneChanged: phone=" + phone);
                    }
                })
                .bindTo(defaultText);
        customXEdit.setPattern(new int[]{4, 4, 4, 4});
        clearXEdit.setOnXTextChangeListener(new UIXEditText.OnXTextChangeListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView1.setText(clearXEdit.getTrimmedString());
            }
        });
        customXEdit.setOnXTextChangeListener(new UIXEditText.OnXTextChangeListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView2.setText(customXEdit.getTrimmedString());
            }
        });
        showXEdit.setSeparator(" ");
        showXEdit.setPattern(new int[]{3, 4, 4});
    }
}
