package com.prathanbomb.androidutilcode.core.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.Config;
import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.AppUtils;
import com.prathanbomb.framework.util.SpanUtils;
import com.prathanbomb.framework.util.ToastUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/10/13
 *     desc  : App工具类Demo
 * </pre>
 */

public class AppActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, AppActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_app;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_app));

        findViewById(R.id.btn_install_app).setOnClickListener(this);
        findViewById(R.id.btn_install_app_silent).setOnClickListener(this);
        findViewById(R.id.btn_uninstall_app).setOnClickListener(this);
        findViewById(R.id.btn_uninstall_app_silent).setOnClickListener(this);
        findViewById(R.id.btn_launch_app).setOnClickListener(this);
        findViewById(R.id.btn_exit_app).setOnClickListener(this);
        findViewById(R.id.btn_get_app_details_settings).setOnClickListener(this);
        TextView tvAboutApp = (TextView) findViewById(R.id.tv_about_app);
        tvAboutApp.setText(
                new SpanUtils()
                        .append("app icon: ").appendImage(AppUtils.Companion.getAppIcon(), SpanUtils.ALIGN_CENTER).appendLine()
                        .appendLine(AppUtils.Companion.getAppInfo().toString())
                        .appendLine("isAppRoot: " + AppUtils.Companion.isAppRoot())
                        .appendLine("isAppDebug: " + AppUtils.Companion.isAppDebug())
                        .appendLine("AppSignatureSHA1: " + AppUtils.Companion.getAppSignatureSHA1())
                        .append("isAppForeground: " + AppUtils.Companion.isAppForeground())
                        .create());
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_install_app:
                if (AppUtils.Companion.isInstallApp(Config.TEST_PKG)) {
                    ToastUtils.Companion.showShort(R.string.app_install_tips);
                } else {
                    AppUtils.Companion.installApp(Config.getTestApkPath(), "com.prathanbomb.androidutilcode.provider");
                }
                break;
            case R.id.btn_install_app_silent:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (AppUtils.Companion.isInstallApp(Config.TEST_PKG)) {
                            ToastUtils.Companion.showShortSafe(R.string.app_install_tips);
                        } else {
                            if (AppUtils.Companion.installAppSilent(Config.getTestApkPath())) {
                                ToastUtils.Companion.showShortSafe(R.string.install_successfully);
                            } else {
                                ToastUtils.Companion.showShortSafe(R.string.install_unsuccessfully);
                            }
                        }
                    }
                }).start();
                break;
            case R.id.btn_uninstall_app:
                if (AppUtils.Companion.isInstallApp(Config.TEST_PKG)) {
                    AppUtils.Companion.uninstallApp(Config.TEST_PKG);
                } else {
                    ToastUtils.Companion.showShort(R.string.app_uninstall_tips);
                }
                break;
            case R.id.btn_uninstall_app_silent:
                if (AppUtils.Companion.isInstallApp(Config.TEST_PKG)) {
                    if (AppUtils.Companion.uninstallAppSilent(Config.TEST_PKG, false)) {
                        ToastUtils.Companion.showShort(R.string.uninstall_successfully);
                    } else {
                        ToastUtils.Companion.showShort(R.string.uninstall_unsuccessfully);
                    }
                } else {
                    ToastUtils.Companion.showShort(R.string.app_uninstall_tips);
                }
                break;
            case R.id.btn_launch_app:
                AppUtils.Companion.launchApp(this.getPackageName());
                break;
            case R.id.btn_exit_app:
                AppUtils.Companion.exitApp();
                break;
            case R.id.btn_get_app_details_settings:
                AppUtils.Companion.getAppDetailsSettings();
                break;
        }
    }
}
