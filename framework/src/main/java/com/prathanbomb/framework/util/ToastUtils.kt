package com.prathanbomb.framework.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.widget.TextViewCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

import java.lang.ref.WeakReference

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/09/29
 * desc  : 吐司相关工具类
</pre> *
 */
class ToastUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        private val DEFAULT_COLOR = 0xFEFFFFFF.toInt()
        private val HANDLER = Handler(Looper.getMainLooper())
        private var sToast: Toast? = null
        private var sViewWeakReference: WeakReference<View>? = null
        private var gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
        private var xOffset = 0
        private var yOffset = (64 * Utils.app.resources.displayMetrics.density + 0.5).toInt()
        private var backgroundColor = DEFAULT_COLOR
        var bgResource = -1
        var messageColor = DEFAULT_COLOR

        /**
         * 设置吐司位置
         *
         * @param gravity 位置
         * @param xOffset x偏移
         * @param yOffset y偏移
         */
        fun setGravity(gravity: Int, xOffset: Int, yOffset: Int) {
            ToastUtils.gravity = gravity
            ToastUtils.xOffset = xOffset
            ToastUtils.yOffset = yOffset
        }

        /**
         * 设置吐司view
         *
         * @param layoutId 视图
         */
        fun setView(@LayoutRes layoutId: Int): View {
            val inflate = Utils.app.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val toastView = inflate.inflate(layoutId, null)
            sViewWeakReference = WeakReference(toastView)
            return toastView
        }

        /**
         * 设置吐司view
         *
         * @param view 视图
         */
        fun setView(view: View?): View? {
            sViewWeakReference = if (view == null) null else WeakReference(view)
            return view
        }

        /**
         * 获取吐司view
         *
         * @return view
         */
        val view: View?
            get() {
                val view = viewFromWR
                if (view != null) {
                    return view
                }
                return if (sToast != null) {
                    sToast!!.view
                } else null
            }

        /**
         * 设置背景颜色
         *
         * @param backgroundColor 背景色
         */
        fun setBgColor(@ColorInt backgroundColor: Int) {
            ToastUtils.backgroundColor = backgroundColor
        }

        /**
         * 安全地显示短时吐司
         *
         * @param text 文本
         */
        fun showShortSafe(text: CharSequence) {
            HANDLER.post { show(text, Toast.LENGTH_SHORT) }
        }

        /**
         * 安全地显示短时吐司
         *
         * @param resId 资源Id
         */
        fun showShortSafe(@StringRes resId: Int) {
            HANDLER.post { show(resId, Toast.LENGTH_SHORT) }
        }

        /**
         * 安全地显示短时吐司
         *
         * @param resId 资源Id
         * @param args  参数
         */
        fun showShortSafe(@StringRes resId: Int, vararg args: Any) {
            HANDLER.post { show(resId, Toast.LENGTH_SHORT, *args) }
        }

        /**
         * 安全地显示短时吐司
         *
         * @param format 格式
         * @param args   参数
         */
        fun showShortSafe(format: String, vararg args: Any) {
            HANDLER.post { show(format, Toast.LENGTH_SHORT, *args) }
        }

        /**
         * 安全地显示长时吐司
         *
         * @param text 文本
         */
        fun showLongSafe(text: CharSequence) {
            HANDLER.post { show(text, Toast.LENGTH_LONG) }
        }

        /**
         * 安全地显示长时吐司
         *
         * @param resId 资源Id
         */
        fun showLongSafe(@StringRes resId: Int) {
            HANDLER.post { show(resId, Toast.LENGTH_LONG) }
        }

        /**
         * 安全地显示长时吐司
         *
         * @param resId 资源Id
         * @param args  参数
         */
        fun showLongSafe(@StringRes resId: Int, vararg args: Any) {
            HANDLER.post { show(resId, Toast.LENGTH_LONG, *args) }
        }

        /**
         * 安全地显示长时吐司
         *
         * @param format 格式
         * @param args   参数
         */
        fun showLongSafe(format: String, vararg args: Any) {
            HANDLER.post { show(format, Toast.LENGTH_LONG, *args) }
        }

        /**
         * 显示短时吐司
         *
         * @param text 文本
         */
        fun showShort(text: CharSequence) {
            show(text, Toast.LENGTH_SHORT)
        }

        /**
         * 显示短时吐司
         *
         * @param resId 资源Id
         */
        fun showShort(@StringRes resId: Int) {
            show(resId, Toast.LENGTH_SHORT)
        }

        /**
         * 显示短时吐司
         *
         * @param resId 资源Id
         * @param args  参数
         */
        fun showShort(@StringRes resId: Int, vararg args: Any) {
            show(resId, Toast.LENGTH_SHORT, *args)
        }

        /**
         * 显示短时吐司
         *
         * @param format 格式
         * @param args   参数
         */
        fun showShort(format: String, vararg args: Any) {
            show(format, Toast.LENGTH_SHORT, *args)
        }

        /**
         * 显示长时吐司
         *
         * @param text 文本
         */
        fun showLong(text: CharSequence) {
            show(text, Toast.LENGTH_LONG)
        }

        /**
         * 显示长时吐司
         *
         * @param resId 资源Id
         */
        fun showLong(@StringRes resId: Int) {
            show(resId, Toast.LENGTH_LONG)
        }

        /**
         * 显示长时吐司
         *
         * @param resId 资源Id
         * @param args  参数
         */
        fun showLong(@StringRes resId: Int, vararg args: Any) {
            show(resId, Toast.LENGTH_LONG, *args)
        }

        /**
         * 显示长时吐司
         *
         * @param format 格式
         * @param args   参数
         */
        fun showLong(format: String, vararg args: Any) {
            show(format, Toast.LENGTH_LONG, *args)
        }

        /**
         * 安全地显示短时自定义吐司
         */
        fun showCustomShortSafe(@LayoutRes layoutId: Int): View {
            val view = setView(layoutId)
            HANDLER.post { show("", Toast.LENGTH_SHORT) }
            return view
        }

        /**
         * 安全地显示长时自定义吐司
         */
        fun showCustomLongSafe(@LayoutRes layoutId: Int): View {
            val view = setView(layoutId)
            HANDLER.post { show("", Toast.LENGTH_LONG) }
            return view
        }

        /**
         * 显示短时自定义吐司
         */
        fun showCustomShort(@LayoutRes layoutId: Int): View {
            val view = setView(layoutId)
            show("", Toast.LENGTH_SHORT)
            return view
        }

        /**
         * 显示长时自定义吐司
         */
        fun showCustomLong(@LayoutRes layoutId: Int): View {
            val view = setView(layoutId)
            show("", Toast.LENGTH_LONG)
            return view
        }

        /**
         * 安全地显示短时自定义吐司
         */
        fun showCustomShortSafe(view: View): View {
            setView(view)
            HANDLER.post { show("", Toast.LENGTH_SHORT) }
            return view
        }

        /**
         * 安全地显示长时自定义吐司
         */
        fun showCustomLongSafe(view: View): View {
            setView(view)
            HANDLER.post {
                setView(view)
                show("", Toast.LENGTH_LONG)
            }
            return view
        }

        /**
         * 显示短时自定义吐司
         */
        fun showCustomShort(view: View): View {
            setView(view)
            show("", Toast.LENGTH_SHORT)
            return view
        }

        /**
         * 显示长时自定义吐司
         */
        fun showCustomLong(view: View): View {
            setView(view)
            show("", Toast.LENGTH_LONG)
            return view
        }

        /**
         * 显示吐司
         *
         * @param resId    资源Id
         * @param duration 显示时长
         */
        private fun show(@StringRes resId: Int, duration: Int) {
            show(Utils.app.resources.getText(resId).toString(), duration)
        }

        /**
         * 显示吐司
         *
         * @param resId    资源Id
         * @param duration 显示时长
         * @param args     参数
         */
        private fun show(@StringRes resId: Int, duration: Int, vararg args: Any) {
            show(String.format(Utils.app.resources.getString(resId), *args), duration)
        }

        /**
         * 显示吐司
         *
         * @param format   格式
         * @param duration 显示时长
         * @param args     参数
         */
        private fun show(format: String, duration: Int, vararg args: Any) {
            show(String.format(format, *args), duration)
        }

        /**
         * 显示吐司
         *
         * @param text     文本
         * @param duration 显示时长
         */
        private fun show(text: CharSequence, duration: Int) {
            cancel()
            val view = viewFromWR
            if (view != null) {
                sToast = Toast(Utils.app)
                sToast!!.view = view
                sToast!!.duration = duration
            } else {
                sToast = Toast.makeText(Utils.app, text, duration)
                // solve the font of toast
                val tvMessage = sToast!!.view.findViewById<View>(android.R.id.message) as TextView
                TextViewCompat.setTextAppearance(tvMessage, android.R.style.TextAppearance)
                tvMessage.setTextColor(messageColor)
            }
            val toastView = sToast!!.view
            if (bgResource != -1) {
                toastView.setBackgroundResource(bgResource)
            } else if (backgroundColor != DEFAULT_COLOR) {
                toastView.setBackgroundColor(backgroundColor)
            }
            sToast!!.setGravity(gravity, xOffset, yOffset)
            sToast!!.show()
        }

        /**
         * 取消吐司显示
         */
        fun cancel() {
            if (sToast != null) {
                sToast!!.cancel()
                sToast = null
            }
        }

        /**
         * 如果自定义View的Context为Activity级别，需要调用releaseView，否则会内存泄露
         */
        internal fun releaseView() {
            if (sToast != null) {
                sToast!!.view = null
            }
        }

        private val viewFromWR: View?
            get() {
                if (sViewWeakReference != null) {
                    val view = sViewWeakReference!!.get()
                    if (view != null) {
                        return view
                    }
                }
                return null
            }
    }

    /**
     * 设置背景资源
     *
     * @param bgResource 背景资源
     */
    fun setBgResource(@DrawableRes bgResource: Int) {
        ToastUtils.bgResource = bgResource
    }

    /**
     * 设置消息颜色
     *
     * @param messageColor 颜色
     */
    fun setMessageColor(@ColorInt messageColor: Int) {
        ToastUtils.messageColor = messageColor
    }
}