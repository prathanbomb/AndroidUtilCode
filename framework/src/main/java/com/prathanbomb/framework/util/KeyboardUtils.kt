package com.prathanbomb.framework.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/02
 * desc  : 键盘相关工具类
</pre> *
 */
class KeyboardUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        /*
      避免输入法面板遮挡
      <p>在manifest.xml中activity中设置</p>
      <p>android:windowSoftInputMode="adjustPan"</p>
     */

        /**
         * 动态显示软键盘
         *
         * @param activity activity
         */
        fun showSoftInput(activity: Activity) {
            var view = activity.currentFocus
            if (view == null) view = View(activity)
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
        }

        /**
         * 动态显示软键盘
         *
         * @param view 视图
         */
        fun showSoftInput(view: View) {
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.requestFocus()
            val imm = Utils.app.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
        }

        /**
         * 动态隐藏软键盘
         *
         * @param activity activity
         */
        fun hideSoftInput(activity: Activity) {
            var view = activity.currentFocus
            if (view == null) view = View(activity)
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        /**
         * 动态隐藏软键盘
         *
         * @param view 视图
         */
        fun hideSoftInput(view: View) {
            val imm = Utils.app.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        /**
         * 切换键盘显示与否状态
         */
        fun toggleSoftInput() {
            val imm = Utils.app.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        /**
         * 点击屏幕空白区域隐藏软键盘
         *
         * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
         *
         * 需重写dispatchTouchEvent
         *
         * 参照以下注释代码
         */
        fun clickBlankArea2HideSoftInput(activity: Activity) {
            val view = activity.currentFocus
            if (view != null) {
                val inputMethodManager = activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                        activity.currentFocus!!.windowToken, 0)
            }
        }
    }
}
