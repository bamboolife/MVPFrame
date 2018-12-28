package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;

import am.widget.smoothinputlayout.SmoothInputLayout;
import butterknife.BindView;

/**
 * 聊天界面实现方式一
 */
public class SmoothInputActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, TextWatcher, SmoothInputLayout.OnVisibilityChangeListener {
    @BindView(R.id.sil_lyt_content)
    SmoothInputLayout lytContent;
    @BindView(R.id.sil_ibtn_voice)
    View btnVoice;
    @BindView(R.id.sil_edt_input)
    EditText edtInput;
    @BindView(R.id.sil_ibtn_emoji)
    View btnEmoji;
    @BindView(R.id.sil_btn_send_voice)
    View btnSendVoice;
    @BindView(R.id.sil_ibtn_more)
    View btnMore;
    @BindView(R.id.sil_ibtn_send)
    View btnSend;
    @BindView(R.id.sil_lyt_emoji)
    View vEmoji;
    @BindView(R.id.sil_lyt_more)
    View vMore;
     @BindView(R.id.sil_v_list)
     View mList;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_smooth_input_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        lytContent.setOnVisibilityChangeListener(this);
        btnVoice.setOnClickListener(this);
        edtInput.addTextChangedListener(this);
        btnEmoji.setOnClickListener(this);
        btnSendVoice.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        edtInput.setOnTouchListener(this);
        mList.setOnTouchListener(this);
    }

    @Override
    public void onVisibilityChange(int visibility) {
        if (visibility == View.GONE) {
            btnEmoji.setSelected(false);
        } else {
            btnEmoji.setSelected(vEmoji.getVisibility() == View.VISIBLE);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().trim().length() > 0) {
            btnMore.setVisibility(View.GONE);
            btnSend.setVisibility(View.VISIBLE);
        } else {
            btnMore.setVisibility(View.VISIBLE);
            btnSend.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sil_ibtn_voice:
                btnMore.setSelected(false);
                btnEmoji.setSelected(false);
                if (btnVoice.isSelected()) {
                    btnVoice.setSelected(false);
                    showInputWidget();
                } else {
                    btnVoice.setSelected(true);
                    lytContent.closeInputPane();
                    lytContent.closeKeyboard(true);
                    showVoiceWidget();
                }
                break;
            case R.id.sil_btn_send_voice:
                Toast.makeText(getApplicationContext(), R.string.smoothinputlayout_voice,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.sil_ibtn_emoji:
                btnMore.setSelected(false);
                if (btnEmoji.isSelected()) {
                    btnEmoji.setSelected(false);
                    showInput();
                } else {
                    btnEmoji.setSelected(true);
                    showEmoji();
                }
                break;
            case R.id.sil_ibtn_more:
                btnEmoji.setSelected(false);
                btnVoice.setSelected(false);
                if (btnMore.isSelected()) {
                    btnMore.setSelected(false);
                    showInput();
                } else {
                    btnMore.setSelected(true);
                    showMore();
                }
                break;
            case R.id.sil_ibtn_send:
                sendMessage();
                break;
        }
    }
    /**
     * 显示输入控件
     */
    private void showInputWidget() {
        edtInput.setVisibility(View.VISIBLE);
        btnEmoji.setVisibility(View.VISIBLE);
        btnSendVoice.setVisibility(View.GONE);
        afterTextChanged(edtInput.getText());
        showInput();
    }

    /**
     * 显示语音控件
     */
    private void showVoiceWidget() {
        edtInput.setVisibility(View.GONE);
        btnEmoji.setVisibility(View.GONE);
        btnSendVoice.setVisibility(View.VISIBLE);
        btnMore.setVisibility(View.VISIBLE);
        btnSend.setVisibility(View.GONE);
    }

    /**
     * 显示输入面板
     */
    private void showInput() {
        lytContent.showKeyboard();
        afterTextChanged(edtInput.getText());
    }

    /**
     *  显示Emoji面板
     */
    private void showEmoji() {
        vEmoji.setVisibility(View.VISIBLE);
        vMore.setVisibility(View.GONE);
        lytContent.showInputPane(true);
    }

    /**
     * 显示更多面板
     */
    private void showMore() {
        edtInput.setVisibility(View.VISIBLE);
        btnEmoji.setVisibility(View.VISIBLE);
        btnSendVoice.setVisibility(View.GONE);
        vEmoji.setVisibility(View.GONE);
        vMore.setVisibility(View.VISIBLE);
        lytContent.showInputPane(false);
    }

    private void sendMessage() {
        Toast.makeText(getApplicationContext(), edtInput.getText().toString().trim(),
                Toast.LENGTH_SHORT).show();
        edtInput.setText(null);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.sil_v_list:
                btnVoice.setSelected(false);
                btnEmoji.setSelected(false);
                btnMore.setSelected(false);
                lytContent.closeKeyboard(true);
                lytContent.closeInputPane();
                break;
            case R.id.sil_edt_input:
                btnVoice.setSelected(false);
                btnEmoji.setSelected(false);
                btnMore.setSelected(false);
                afterTextChanged(edtInput.getText());
                break;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (lytContent.isInputPaneOpen()) {
            lytContent.closeInputPane();
            return;
        }
        super.onBackPressed();
    }
}
