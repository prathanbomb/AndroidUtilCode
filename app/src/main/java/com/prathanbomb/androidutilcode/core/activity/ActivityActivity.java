package com.prathanbomb.androidutilcode.core.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.Config;
import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.androidutilcode.core.image.ImageActivity;
import com.prathanbomb.framework.util.ActivityUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/10/13
 *     desc  : Activity工具类Demo
 * </pre>
 */
public class ActivityActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, ActivityActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_activity;
    }


    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_activity));

        findViewById(R.id.btn_launch_image_activity).setOnClickListener(this);
        findViewById(R.id.btn_finish_all_activity).setOnClickListener(this);
        TextView tvAboutActivity = (TextView) findViewById(R.id.tv_about_activity);
        tvAboutActivity.setText("Is ImageActivity Exists: " + ActivityUtils.Companion.isActivityExists(Config.PKG, ImageActivity.class.getName())
                + "\ngetLauncherActivity: " + ActivityUtils.Companion.getLauncherActivity(Config.PKG)
                + "\ngetTopActivity: " + ActivityUtils.Companion.getTopActivity()
        );
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_launch_image_activity:
                ActivityUtils.Companion.startActivity(Config.PKG, ImageActivity.class.getName());
                break;
            case R.id.btn_finish_all_activity:
                ActivityUtils.Companion.finishAllActivities();
                break;
        }
    }
}