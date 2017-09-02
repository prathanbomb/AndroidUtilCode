package com.prathanbomb.androidutilcode.core.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.PhoneUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/10/13
 *     desc  : Phone工具类Demo
 * </pre>
 */
public class PhoneActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, PhoneActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_phone;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_phone));

        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_send_sms).setOnClickListener(this);
        findViewById(R.id.btn_send_sms_silent).setOnClickListener(this);
        TextView tvAboutPhone = (TextView) findViewById(R.id.tv_about_phone);
        tvAboutPhone.setText("isPhone: " + PhoneUtils.Companion.isPhone()
                + "\ngetIMEI: " + PhoneUtils.Companion.getImei()
                + "\ngetIMSI: " + PhoneUtils.Companion.getImsi()
                + "\ngetPhoneType: " + PhoneUtils.Companion.getPhoneType()
                + "\nisSimCardReady: " + PhoneUtils.Companion.isSimCardReady()
                + "\ngetSimOperatorName: " + PhoneUtils.Companion.getSimOperatorName()
                + "\ngetSimOperatorByMnc: " + PhoneUtils.Companion.getSimOperatorByMnc()
                + "\n获取手机状态信息: " + PhoneUtils.Companion.getPhoneStatus()
        );
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dial:
                PhoneUtils.Companion.dial("10000");
                break;
            case R.id.btn_call:
                PhoneUtils.Companion.call("10000");
                break;
            case R.id.btn_send_sms:
                PhoneUtils.Companion.sendSms("10000", "test");
                break;
            case R.id.btn_send_sms_silent:
                PhoneUtils.Companion.sendSmsSilent("10000", "test");
                break;
        }
    }
}
