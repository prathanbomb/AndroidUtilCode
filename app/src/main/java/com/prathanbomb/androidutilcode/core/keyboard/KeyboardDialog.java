package com.prathanbomb.androidutilcode.core.keyboard;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.framework.util.KeyboardUtils;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2017/06/01
 *     desc  :
 * </pre>
 */
public class KeyboardDialog implements View.OnClickListener {

    private WeakReference<Activity> mActivityWeakReference;

    public KeyboardDialog(Activity activity) {
        mActivityWeakReference = new WeakReference<>(activity);
    }

    private AlertDialog dialog;
    private EditText etInput;

    public void show(){
        final Activity activity = mActivityWeakReference.get();
        if (activity != null) {
            final View dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_keyboard, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            etInput = (EditText) dialogView.findViewById(R.id.et_input);
            dialog = builder.setView(dialogView).create();
            dialog.setCanceledOnTouchOutside(false);
            dialogView.findViewById(R.id.btn_hide_soft_input).setOnClickListener(this);
            dialogView.findViewById(R.id.btn_show_soft_input).setOnClickListener(this);
            dialogView.findViewById(R.id.btn_toggle_soft_input).setOnClickListener(this);
            dialogView.findViewById(R.id.btn_close_dialog).setOnClickListener(this);
            dialog.show();
            KeyboardUtils.Companion.showSoftInput(activity);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hide_soft_input:
                KeyboardUtils.Companion.hideSoftInput(etInput);
                break;
            case R.id.btn_show_soft_input:
                KeyboardUtils.Companion.showSoftInput(etInput);
                break;
            case R.id.btn_toggle_soft_input:
                KeyboardUtils.Companion.toggleSoftInput();
                break;
            case R.id.btn_close_dialog:
                KeyboardUtils.Companion.hideSoftInput(etInput);
                dialog.dismiss();
                break;
        }
    }
}
