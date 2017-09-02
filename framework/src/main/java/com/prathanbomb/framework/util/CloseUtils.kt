package com.prathanbomb.framework.util

import java.io.Closeable
import java.io.IOException

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/10/09
 * desc  : 关闭相关工具类
</pre> *
 */
class CloseUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        /**
         * 关闭IO
         *
         * @param closeables closeables
         */
        fun closeIO(vararg closeables: Closeable) {
            closeables
                    .forEach {
                        try {
                            it.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
        }

        /**
         * 安静关闭IO
         *
         * @param closeables closeables
         */
        fun closeIOQuietly(vararg closeables: Closeable) {
            closeables
                    .forEach {
                        try {
                            it.close()
                        } catch (ignored: IOException) {
                        }
                    }
        }
    }
}
