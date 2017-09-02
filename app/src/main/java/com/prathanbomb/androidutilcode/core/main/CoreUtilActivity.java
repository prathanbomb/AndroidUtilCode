package com.prathanbomb.androidutilcode.core.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.androidutilcode.core.activity.ActivityActivity;
import com.prathanbomb.androidutilcode.core.app.AppActivity;
import com.prathanbomb.androidutilcode.core.bar.BarActivity;
import com.prathanbomb.androidutilcode.core.clean.CleanActivity;
import com.prathanbomb.androidutilcode.core.device.DeviceActivity;
import com.prathanbomb.androidutilcode.core.fragment.FragmentActivity;
import com.prathanbomb.androidutilcode.core.image.ImageActivity;
import com.prathanbomb.androidutilcode.core.keyboard.KeyboardActivity;
import com.prathanbomb.androidutilcode.core.log.LogActivity;
import com.prathanbomb.androidutilcode.core.network.NetworkActivity;
import com.prathanbomb.androidutilcode.core.phone.PhoneActivity;
import com.prathanbomb.androidutilcode.core.process.ProcessActivity;
import com.prathanbomb.androidutilcode.core.screen.ScreenActivity;
import com.prathanbomb.androidutilcode.core.sdcard.SDCardActivity;
import com.prathanbomb.androidutilcode.core.snackbar.SnackbarActivity;
import com.prathanbomb.androidutilcode.core.span.SpanActivity;
import com.prathanbomb.androidutilcode.core.toast.ToastActivity;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/09/29
 *     desc  : MainActivity
 * </pre>
 */
public class CoreUtilActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, CoreUtilActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_util_core;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.core_util));
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    public void coreUtilClick(View view) {

    }

    public void activityClick(View view) {
        startActivity(new Intent(this, ActivityActivity.class));
    }

    public void appClick(View view) {
        AppActivity.start(this);
    }

    public void barClick(View view) {
        BarActivity.start(this);
    }

    public void cleanClick(View view) {
        CleanActivity.start(this);
    }

    public void crashClick(View view) {
        throw new NullPointerException("crash test");
    }

    public void deviceClick(View view) {
        DeviceActivity.start(this);
    }

    public void fragmentClick(View view) {
        startActivity(new Intent(this, FragmentActivity.class));
    }

    public void imageClick(View view) {
        ImageActivity.start(this);
    }

    public void keyboardClick(View view) {
        KeyboardActivity.start(this);
    }

    public void logClick(View view) {
        LogActivity.start(this);
    }

    public void networkClick(View view) {
        NetworkActivity.start(this);
    }

//    public void permissionClick(View view) {
//        startActivity(new Intent(this, PermissionActivity.class));
//    }

    public void phoneClick(View view) {
        PhoneActivity.start(this);
    }

    public void processClick(View view) {
        ProcessActivity.start(this);
    }

    public void screenClick(View view) {
        ScreenActivity.start(this);
    }

    public void sdcardClick(View view) {
        SDCardActivity.start(this);
    }

    public void snackbarClick(View view) {
        SnackbarActivity.start(this);
    }

    public void spannableClick(View view) {
        SpanActivity.start(this);
    }

    public void toastClick(View view) {
        ToastActivity.start(this);
    }
}
