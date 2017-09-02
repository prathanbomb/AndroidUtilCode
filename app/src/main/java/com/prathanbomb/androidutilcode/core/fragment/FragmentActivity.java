package com.prathanbomb.androidutilcode.core.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseBackActivity;
import com.prathanbomb.framework.util.FragmentUtils;

import java.util.ArrayList;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 17/02/01
 *     desc  : Fragment工具类Demo
 * </pre>
 */
public class FragmentActivity extends BaseBackActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, FragmentActivity.class);
        context.startActivity(starter);
    }

    public Fragment rootFragment;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_fragment));
    }

    @Override
    public void doBusiness() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Demo0Fragment.newInstance());
        rootFragment = FragmentUtils.addFragments(getSupportFragmentManager(), fragments, R.id.fragment_container, 0);
    }

    @Override
    public void onWidgetClick(View view) {

    }


    @Override
    public void onBackPressed() {
        if (!FragmentUtils.dispatchBackPress(getSupportFragmentManager())) {
            super.onBackPressed();
        }
    }
}