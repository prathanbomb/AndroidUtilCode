package com.prathanbomb.androidutilcode.sub.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.androidutilcode.sub.location.LocationActivity;
import com.prathanbomb.androidutilcode.sub.pinyin.PinyinActivity;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/09/29
 *     desc  : MainActivity
 * </pre>
 */
public class SubUtilActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SubUtilActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_util_sub;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.sub_util));
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    public void locationClick(View view) {
        LocationActivity.start(this);
    }

    public void pinyinClick(View view) {
        PinyinActivity.start(this);
    }
}
