package com.prathanbomb.androidutilcode.core.device;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.DeviceUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog : http://prathanbomb.com
 *     time : 2016/09/27
 *     desc : Device工具类Demo
 * </pre>
 */
public class DeviceActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, DeviceActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_device;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_device));

        findViewById(R.id.btn_shutdown).setOnClickListener(this);
        findViewById(R.id.btn_reboot).setOnClickListener(this);
        findViewById(R.id.btn_reboot_to_recovery).setOnClickListener(this);
        findViewById(R.id.btn_reboot_to_bootloader).setOnClickListener(this);
        TextView tvAboutDevice = findViewById(R.id.tv_about_device);
        tvAboutDevice.setText("isRoot: " + DeviceUtils.Companion.isDeviceRooted()
                + "\ngetSDKVersion: " + DeviceUtils.Companion.getSdkVersion()
                + "\ngetAndroidID: " + DeviceUtils.Companion.getAndroidID()
                + "\ngetMacAddress: " + DeviceUtils.Companion.getMacAddress()
                + "\ngetManufacturer: " + DeviceUtils.Companion.getManufacturer()
                + "\ngetModel: " + DeviceUtils.Companion.getModel()
        );
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_shutdown:
                DeviceUtils.Companion.shutdown();
                break;
            case R.id.btn_reboot:
                DeviceUtils.Companion.reboot();
                break;
            case R.id.btn_reboot_to_recovery:
                DeviceUtils.Companion.reboot2Recovery();
                break;
            case R.id.btn_reboot_to_bootloader:
                DeviceUtils.Companion.reboot2Bootloader();
                break;
        }
    }
}