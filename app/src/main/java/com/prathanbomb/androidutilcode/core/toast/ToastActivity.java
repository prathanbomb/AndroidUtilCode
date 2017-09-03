package com.prathanbomb.androidutilcode.core.toast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.SpanUtils;
import com.prathanbomb.framework.util.ToastUtils;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/09/29
 *     desc  : Toast工具类Demo
 * </pre>
 */
public class ToastActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, ToastActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_toast;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_toast));

        findViewById(R.id.btn_show_short_toast_safe).setOnClickListener(this);
        findViewById(R.id.btn_show_short_toast).setOnClickListener(this);
        findViewById(R.id.btn_show_long_toast_safe).setOnClickListener(this);
        findViewById(R.id.btn_show_long_toast).setOnClickListener(this);
        findViewById(R.id.btn_show_green_font).setOnClickListener(this);
        findViewById(R.id.btn_show_custom_bg).setOnClickListener(this);
        findViewById(R.id.btn_show_span).setOnClickListener(this);
        findViewById(R.id.btn_show_custom_view).setOnClickListener(this);
        findViewById(R.id.btn_show_middle).setOnClickListener(this);
        findViewById(R.id.btn_cancel_toast).setOnClickListener(this);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        resetToast();
        switch (view.getId()) {
            case R.id.btn_show_short_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.Companion.showShortSafe(R.string.toast_short_safe);
                    }
                }).start();
                break;
            case R.id.btn_show_short_toast:
                ToastUtils.Companion.showShort(R.string.toast_short);
                break;
            case R.id.btn_show_long_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.Companion.showLongSafe(R.string.toast_long_safe);
                    }
                }).start();
                break;
            case R.id.btn_show_long_toast:
                ToastUtils.Companion.showLong(R.string.toast_long);
                break;
            case R.id.btn_show_green_font:
                ToastUtils.Companion.setMessageColor(Color.GREEN);
                ToastUtils.Companion.showLong(R.string.toast_green_font);
                break;
            case R.id.btn_show_custom_bg:
                ToastUtils.Companion.setBgResource(R.drawable.shape_round_rect);
                ToastUtils.Companion.showLong(R.string.toast_custom_bg);
                break;
            case R.id.btn_show_span:
                ToastUtils.Companion.showLong(new SpanUtils()
                        .appendLine(getString(R.string.toast_span))
                        .setFontSize(24, true)
                        .setIconMargin(R.mipmap.ic_launcher, 32, SpanUtils.ALIGN_CENTER)
                        .append(" ").setFontSize(0)
                        .create()
                );
                break;
            case R.id.btn_show_custom_view:
                MyToast.showMyToast(getString(R.string.toast_custom_view));
                break;
            case R.id.btn_show_middle:
                ToastUtils.Companion.setGravity(Gravity.CENTER, 0, 0);
                ToastUtils.Companion.showLong(R.string.toast_middle);
                break;
            case R.id.btn_cancel_toast:
                ToastUtils.Companion.cancel();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        resetToast();
        super.onDestroy();
    }

    private void resetToast() {
        ToastUtils.Companion.setMessageColor(0xFFFFFFFF);
        ToastUtils.Companion.setBgResource(-1);
        ToastUtils.Companion.setView(null);
        ToastUtils.Companion.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, getResources().getDimensionPixelSize(R.dimen.offset_64));
    }
}
