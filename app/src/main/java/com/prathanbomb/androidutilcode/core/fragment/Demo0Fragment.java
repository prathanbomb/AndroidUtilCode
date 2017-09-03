package com.prathanbomb.androidutilcode.core.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prathanbomb.androidutilcode.R;
import com.prathanbomb.androidutilcode.base.BaseFragment;
import com.prathanbomb.framework.util.FragmentUtils;
import com.prathanbomb.framework.util.ToastUtils;

import java.util.Random;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 17/02/02
 *     desc  :
 * </pre>
 */
public class Demo0Fragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {

    private Demo0Fragment               demo0Fragment;
    private FragmentUtils.SharedElement sharedElement;
    Button    btnShowAboutFragment;
    ImageView ivSharedElement;
    TextView  tvAboutFragment;

    public static Demo0Fragment newInstance() {
        Bundle args = new Bundle();
        Demo0Fragment fragment = new Demo0Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_demo0;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        Random random = new Random();
        FragmentUtils.Companion.setBackgroundColor(this, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        btnShowAboutFragment = (Button) view.findViewById(R.id.btn_show_about_fragment);
        btnShowAboutFragment.setOnClickListener(this);
        view.findViewById(R.id.btn_add_hide).setOnClickListener(this);
        view.findViewById(R.id.btn_add_show).setOnClickListener(this);
        view.findViewById(R.id.btn_add_child).setOnClickListener(this);
        view.findViewById(R.id.btn_pop_to_root).setOnClickListener(this);
        view.findViewById(R.id.btn_pop_add).setOnClickListener(this);
        view.findViewById(R.id.btn_hide_show).setOnClickListener(this);
        view.findViewById(R.id.btn_replace).setOnClickListener(this);
        ivSharedElement = (ImageView) view.findViewById(R.id.iv_shared_element);
        tvAboutFragment = (TextView) view.findViewById(R.id.tv_about_fragment);
        demo0Fragment = this;
        sharedElement = new FragmentUtils.SharedElement(ivSharedElement, getString(R.string.fragment_transition));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setExitTransition(new Fade());
        }
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
                        + "\ntopShow: " + (FragmentUtils.Companion.getTopShowFragment(getFragmentManager()) != null ? FragmentUtils.Companion.getTopShowFragment(getFragmentManager()).getClass().getSimpleName() : "null")
                        + "\ntopShowInStack: " + (FragmentUtils.Companion.getTopShowFragmentInStack(getFragmentManager()) != null ? FragmentUtils.Companion.getTopShowFragmentInStack(getFragmentManager()).getClass().getSimpleName() : "null")
                        + "\n---all of fragments---\n"
                        + FragmentUtils.Companion.getAllFragments(getFragmentManager()).toString()
                        + "\n----------------------\n\n"
                        + "---stack top---\n"
                        + FragmentUtils.Companion.getAllFragmentsInStack(getFragmentManager()).toString()
                        + "\n---stack bottom---\n\n"
                );
                break;
            case R.id.btn_add_hide:
                FragmentUtils.Companion.hideAddFragment(getFragmentManager(),
                        demo0Fragment,
                        addSharedElement(Demo1Fragment.newInstance()),
                        R.id.fragment_container,
                        false,
                        true,
                        sharedElement);
                break;
            case R.id.btn_add_show:
                FragmentUtils.Companion.addFragment(getFragmentManager(),
                        addSharedElement(Demo1Fragment.newInstance()),
                        R.id.fragment_container,
                        false,
                        false,
                        sharedElement);
                break;
            case R.id.btn_add_child:
                FragmentUtils.Companion.addFragment(getChildFragmentManager(),
                        Demo2Fragment.newInstance(),
                        R.id.child_fragment_container,
                        false,
                        true);
                break;
            case R.id.btn_pop_to_root:
                FragmentUtils.Companion.popToFragment(getFragmentManager(),
                        Demo1Fragment.class,
                        true);
                break;
            case R.id.btn_pop_add:
                FragmentUtils.Companion.popAddFragment(getFragmentManager(),
                        addSharedElement(Demo2Fragment.newInstance()),
                        R.id.fragment_container,
                        true,
                        sharedElement);
                break;
            case R.id.btn_hide_show:
                Fragment fragment1 = FragmentUtils.Companion.findFragment(getFragmentManager(), Demo1Fragment.class);
                if (fragment1 != null) {
                    FragmentUtils.Companion.hideShowFragment(this, fragment1);
                } else {
                    ToastUtils.Companion.showLong("please add demo1 first!");
                }
                break;
            case R.id.btn_replace:
                ((FragmentActivity) getActivity()).rootFragment = FragmentUtils.Companion.replaceFragment(this, addSharedElement(Demo3Fragment.newInstance()), false, sharedElement);
                break;
        }
    }

    private Fragment addSharedElement(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(new DetailTransition());
            fragment.setEnterTransition(new Fade());
            fragment.setSharedElementReturnTransition(new DetailTransition());
        }
        return fragment;
    }

    @Override
    public boolean onBackClick() {
//        FragmentUtils.popToFragment(getFragmentManager(), Demo1Fragment.class, true);
        return false;
    }
}
