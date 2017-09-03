package com.prathanbomb.framework.constant

import android.support.annotation.IntDef

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2017/03/13
 * desc  : 存储相关常量
</pre> *
 */
object MemoryConstants {

    /**
     * Byte与Byte的倍数
     */
    const val BYTE = 1
    /**
     * KB与Byte的倍数
     */
    const val KB = 1024
    /**
     * MB与Byte的倍数
     */
    const val MB = 1048576
    /**
     * GB与Byte的倍数
     */
    const val GB = 1073741824

    @IntDef(BYTE.toLong(), KB.toLong(), MB.toLong(), GB.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class Unit
}
