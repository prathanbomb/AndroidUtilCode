package com.prathanbomb.androidutilcode.core.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseFragment;
import com.prathanbomb.framework.util.FragmentUtils;

import java.util.Random;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 17/02/02
 *     desc  :
 * </pre>
 */
public class Demo1Fragment extends BaseFragment {

    public static Demo1Fragment newInstance() {
        Bundle args = new Bundle();
        Demo1Fragment fragment = new Demo1Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView tvAboutFragment;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_demo1;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        Random random = new Random();
        FragmentUtils.Companion.setBackgroundColor(this, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        view.findViewById(R.id.btn_show_about_fragment).setOnClickListener(this);
        view.findViewById(R.id.btn_hide_show).setOnClickListener(this);
        tvAboutFragment = (TextView) view.findViewById(R.id.tv_about_fragment);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        tvAboutFragment.setText("");
        switch (view.getId()) {
            case R.id.btn_show_about_fragment:
                tvAboutFragment.setText("lastAdd: " + FragmentUtils.Companion.getLastAddFragment(getFragmentManager()).getClass().getSimpleName()
                        + "\nlastAddInStack: " + (FragmentUtils.Companion.getLastAddFragmentInStack(getFragmentManager()) != null ? FragmentUtils.Companion.getLastAddFragmentInStack(getFragmentManager()).getClass().getSimpleName() : "null")
                        + "\ntopShow: " + FragmentUtils.Companion.getTopShowFragment(getFragmentManager()).getClass().getSimpleName()
                        + "\ntopShowInStack: " + (FragmentUtils.Companion.getTopShowFragmentInStack(getFragmentManager()) != null ? FragmentUtils.Companion.getTopShowFragmentInStack(getFragmentManager()).getClass().getSimpleName() : "null")
                        + "\n---all of fragments---\n"
                        + FragmentUtils.Companion.getAllFragments(getFragmentManager()).toString()
                        + "\n----------------------\n\n"
                        + "---stack top---\n"
                        + FragmentUtils.Companion.getAllFragmentsInStack(getFragmentManager()).toString()
                        + "\n---stack bottom---\n\n"
                );
                break;
            case R.id.btn_hide_show:
                FragmentUtils.Companion.hideAllShowFragment(((FragmentActivity) getActivity()).rootFragment);
                break;
        }
    }

//    @Override
//    public boolean onBackClick() {
//        LogUtils.d("onBackClick");
//        FragmentUtils.showFragment(((FragmentActivity) getActivity()).rootFragment);
//        FragmentUtils.popFragment(getFragmentManager());
//        return true;
//    }
}
