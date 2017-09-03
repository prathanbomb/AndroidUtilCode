package com.prathanbomb.framework.constant

import android.support.annotation.IntDef

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2017/03/13
 * desc  : 时间相关常量
</pre> *
 */
object TimeConstants {

    /**
     * 毫秒与毫秒的倍数
     */
    const val MSEC = 1
    /**
     * 秒与毫秒的倍数
     */
    const val SEC = 1000
    /**
     * 分与毫秒的倍数
     */
    const val MIN = 60000
    /**
     * 时与毫秒的倍数
     */
    const val HOUR = 3600000
    /**
     * 天与毫秒的倍数
     */
    const val DAY = 86400000

    @IntDef(MSEC.toLong(), SEC.toLong(), MIN.toLong(), HOUR.toLong(), DAY.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class Unit
}
