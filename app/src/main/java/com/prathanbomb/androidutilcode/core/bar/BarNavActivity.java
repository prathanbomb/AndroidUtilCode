package com.prathanbomb.androidutilcode.core.bar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.BarUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/10/13
 *     desc  : Activity工具类Demo
 * </pre>
 */
public class BarNavActivity extends BaseBackActivity {

    private TextView tvAboutNav;

    public static void start(Context context) {
        Intent starter = new Intent(context, BarNavActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_bar_nav;
    }


    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_bar));

        tvAboutNav = (TextView) findViewById(R.id.tv_about_nav);
        tvAboutNav.setText("navHeight: " + BarUtils.Companion.getNavBarHeight());
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        BarUtils.Companion.hideNavBar(this);
    }
}