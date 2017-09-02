package com.prathanbomb.androidutilcode.core.clean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.CleanUtils;
import com.prathanbomb.framework.util.ToastUtils;

import java.io.File;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/09/29
 *     desc  : Clean工具类Demo
 * </pre>
 */
public class CleanActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, CleanActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_clean;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_clean));

        Button btnCleanInternalCache = (Button) findViewById(R.id.btn_clean_internal_cache);
        Button btnCleanInternalFiles = (Button) findViewById(R.id.btn_clean_internal_files);
        Button btnCleanInternalDbs = (Button) findViewById(R.id.btn_clean_internal_databases);
        Button btnCleanInternalSP = (Button) findViewById(R.id.btn_clean_internal_sp);
        Button btnCleanExternalCache = (Button) findViewById(R.id.btn_clean_external_cache);
        btnCleanInternalCache.setOnClickListener(this);
        btnCleanInternalFiles.setOnClickListener(this);
        btnCleanInternalDbs.setOnClickListener(this);
        btnCleanInternalSP.setOnClickListener(this);
        btnCleanExternalCache.setOnClickListener(this);

        btnCleanInternalCache.setText(getCacheDir().getPath());
        btnCleanInternalFiles.setText(getFilesDir().getPath());
        btnCleanInternalDbs.setText(getFilesDir().getParent() + File.separator + "databases");
        btnCleanInternalSP.setText(getFilesDir().getParent() + File.separator + "shared_prefs");

        if (getExternalCacheDir() != null) {
            btnCleanExternalCache.setText(getExternalCacheDir().getAbsolutePath());
        }
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_internal_cache:
                ToastUtils.showShort("cleanInternalCache" + CleanUtils.Companion.cleanInternalCache());
                break;
            case R.id.btn_clean_internal_files:
                ToastUtils.showShort("cleanInternalFiles" + CleanUtils.Companion.cleanInternalFiles());
                break;
            case R.id.btn_clean_internal_databases:
                ToastUtils.showShort("cleanInternalDbs" + CleanUtils.Companion.cleanInternalDbs());
                break;
            case R.id.btn_clean_internal_sp:
                ToastUtils.showShort("cleanInternalSP" + CleanUtils.Companion.cleanInternalSP());
                break;
            case R.id.btn_clean_external_cache:
                ToastUtils.showShort("cleanExternalCache" + CleanUtils.Companion.cleanExternalCache());
                break;
        }
    }
}
