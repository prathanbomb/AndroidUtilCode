package com.prathanbomb.framework.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.AnimRes

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/09/23
 * desc  : Activity相关工具类
</pre> *
 */
class ActivityUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        /**
         * 判断是否存在Activity
         *
         * @param packageName 包名
         * @param className   activity全路径类名
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isActivityExists(packageName: String,
                             className: String): Boolean {
            val intent = Intent()
            intent.setClassName(packageName, className)
            return !(Utils.app.packageManager.resolveActivity(intent, 0) == null ||
                    intent.resolveActivity(Utils.app.packageManager) == null ||
                    Utils.app.packageManager.queryIntentActivities(intent, 0).size == 0)
        }

        /**
         * 启动Activity
         *
         * @param cls activity类
         */
        fun startActivity(cls: Class<*>) {
            val context = Utils.app
            startActivity(context, null, context.packageName, cls.name, null)
        }

        /**
         * 启动Activity
         *
         * @param cls     activity类
         * @param options 跳转动画
         */
        fun startActivity(cls: Class<*>,
                          options: Bundle) {
            val context = Utils.app
            startActivity(context, null, context.packageName, cls.name, options)
        }

        /**
         * 启动Activity
         *
         * @param activity activity
         * @param cls      activity类
         */
        fun startActivity(activity: Activity,
                          cls: Class<*>) {
            startActivity(activity, null, activity.packageName, cls.name, null)
        }

        /**
         * 启动Activity
         *
         * @param activity activity
         * @param cls      activity类
         * @param options  跳转动画
         */
        fun startActivity(activity: Activity,
                          cls: Class<*>,
                          options: Bundle) {
            startActivity(activity, null, activity.packageName, cls.name, options)
        }

        /**
         * 启动Activity
         *
         * @param activity  activity
         * @param cls       activity类
         * @param enterAnim 入场动画
         * @param exitAnim  出场动画
         */
        fun startActivity(activity: Activity,
                          cls: Class<*>,
                          @AnimRes enterAnim: Int,
                          @AnimRes exitAnim: Int) {
            startActivity(activity, null, activity.packageName, cls.name, null)
            activity.overridePendingTransition(enterAnim, exitAnim)
        }

        /**
         * 启动Activity
         *
         * @param extras extras
         * @param cls    activity类
         */
        fun startActivity(extras: Bundle,
                          cls: Class<*>) {
            val context = Utils.app
            startActivity(context, extras, context.packageName, cls.name, null)
        }

        /**
         * 启动Activity
         *
         * @param extras  extras
         * @param cls     activity类
         * @param options 跳转动画
         */
        fun startActivity(extras: Bundle,
                          cls: Class<*>,
                          options: Bundle) {
            val context = Utils.app
            startActivity(context, extras, context.packageName, cls.name, options)
        }

        /**
         * 启动Activity
         *
         * @param extras   extras
         * @param activity activity
         * @param cls      activity类
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          cls: Class<*>) {
            startActivity(activity, extras, activity.packageName, cls.name, null)
        }

        /**
         * 启动Activity
         *
         * @param extras   extras
         * @param activity activity
         * @param cls      activity类
         * @param options  跳转动画
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          cls: Class<*>,
                          options: Bundle) {
            startActivity(activity, extras, activity.packageName, cls.name, options)
        }

        /**
         * 启动Activity
         *
         * @param extras    extras
         * @param activity  activity
         * @param cls       activity类
         * @param enterAnim 入场动画
         * @param exitAnim  出场动画
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          cls: Class<*>,
                          @AnimRes enterAnim: Int,
                          @AnimRes exitAnim: Int) {
            startActivity(activity, extras, activity.packageName, cls.name, null)
            activity.overridePendingTransition(enterAnim, exitAnim)
        }

        /**
         * 启动Activity
         *
         * @param pkg 包名
         * @param cls 全类名
         */
        fun startActivity(pkg: String,
                          cls: String) {
            startActivity(Utils.app, null, pkg, cls, null)
        }

        /**
         * 启动Activity
         *
         * @param pkg     包名
         * @param cls     全类名
         * @param options 动画
         */
        fun startActivity(pkg: String,
                          cls: String,
                          options: Bundle) {
            startActivity(Utils.app, null, pkg, cls, options)
        }

        /**
         * 启动Activity
         *
         * @param activity activity
         * @param pkg      包名
         * @param cls      全类名
         */
        fun startActivity(activity: Activity,
                          pkg: String,
                          cls: String) {
            startActivity(activity, null, pkg, cls, null)
        }

        /**
         * 启动Activity
         *
         * @param activity activity
         * @param pkg      包名
         * @param cls      全类名
         * @param options  动画
         */
        fun startActivity(activity: Activity,
                          pkg: String,
                          cls: String,
                          options: Bundle) {
            startActivity(activity, null, pkg, cls, options)
        }

        /**
         * 启动Activity
         *
         * @param activity  activity
         * @param pkg       包名
         * @param cls       全类名
         * @param enterAnim 入场动画
         * @param exitAnim  出场动画
         */
        fun startActivity(activity: Activity,
                          pkg: String,
                          cls: String,
                          @AnimRes enterAnim: Int,
                          @AnimRes exitAnim: Int) {
            startActivity(activity, null, pkg, cls, null)
            activity.overridePendingTransition(enterAnim, exitAnim)
        }

        /**
         * 启动Activity
         *
         * @param extras extras
         * @param pkg    包名
         * @param cls    全类名
         */
        fun startActivity(extras: Bundle,
                          pkg: String,
                          cls: String) {
            startActivity(Utils.app, extras, pkg, cls, null)
        }

        /**
         * 启动Activity
         *
         * @param extras  extras
         * @param pkg     包名
         * @param cls     全类名
         * @param options 动画
         */
        fun startActivity(extras: Bundle,
                          pkg: String,
                          cls: String,
                          options: Bundle) {
            startActivity(Utils.app, extras, pkg, cls, options)
        }

        /**
         * 启动Activity
         *
         * @param activity activity
         * @param extras   extras
         * @param pkg      包名
         * @param cls      全类名
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          pkg: String,
                          cls: String) {
            startActivity(activity, extras, pkg, cls, null)
        }

        /**
         * 启动Activity
         *
         * @param extras   extras
         * @param activity activity
         * @param pkg      包名
         * @param cls      全类名
         * @param options  动画
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          pkg: String,
                          cls: String,
                          options: Bundle) {
            startActivity(activity, extras, pkg, cls, options)
        }

        /**
         * 启动Activity
         *
         * @param extras    extras
         * @param pkg       包名
         * @param cls       全类名
         * @param enterAnim 入场动画
         * @param exitAnim  出场动画
         */
        fun startActivity(extras: Bundle,
                          activity: Activity,
                          pkg: String,
                          cls: String,
                          @AnimRes enterAnim: Int,
                          @AnimRes exitAnim: Int) {
            startActivity(activity, extras, pkg, cls, null)
            activity.overridePendingTransition(enterAnim, exitAnim)
        }

        private fun startActivity(context: Context,
                                  extras: Bundle?,
                                  pkg: String,
                                  cls: String,
                                  options: Bundle?) {
            val intent = Intent(Intent.ACTION_VIEW)
            if (extras != null) intent.putExtras(extras)
            intent.component = ComponentName(pkg, cls)
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                context.startActivity(intent, options)
            } else {
                context.startActivity(intent)
            }
        }

        /**
         * 获取launcher activity
         *
         * @param packageName 包名
         * @return launcher activity
         */
        fun getLauncherActivity(packageName: String): String {
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val pm = Utils.app.packageManager
            val info = pm.queryIntentActivities(intent, 0)
            for (aInfo in info) {
                if (aInfo.activityInfo.packageName == packageName) {
                    return aInfo.activityInfo.name
                }
            }
            return "no " + packageName
        }


        /**
         * 获取栈顶Activity
         *
         * @return 栈顶Activity
         */
        val topActivity: Activity
            get() {
                if (Utils.sTopActivityWeakRef != null) {
                    val activity = Utils.sTopActivityWeakRef!!.get()
                    if (activity != null) {
                        return activity
                    }
                }
                return Utils.sActivityList[Utils.sActivityList.size - 1]
            }

        /**
         * 结束所有activity
         */
        fun finishAllActivities() {
            val activityList = Utils.sActivityList
            for (i in activityList.indices.reversed()) {
                activityList[i].finish()
                activityList.removeAt(i)
            }
        }
    }
}
