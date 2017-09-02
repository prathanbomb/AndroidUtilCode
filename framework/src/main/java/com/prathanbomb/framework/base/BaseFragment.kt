package com.prathanbomb.framework.base

import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.prathanbomb.framework.util.KeyboardUtils

/**
 * Created by prathanbomb on 3/8/2017 AD.
 */

open class BaseFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        setupUI(view!!)
    }

    private fun setupUI(view: View) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                KeyboardUtils.clickBlankArea2HideSoftInput(activity)
                false
            }
        }
        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            (0 until view.childCount)
                    .map { view.getChildAt(it) }
                    .forEach { setupUI(it) }
        }
    }

}
