package com.prathanbomb.framework.util

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/16
 * desc  : 字符串相关工具类
</pre> *
 */
class StringUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        /**
         * 判断字符串是否为null或长度为0
         *
         * @param s 待校验字符串
         * @return `true`: 空<br></br> `false`: 不为空
         */
        fun isEmpty(s: CharSequence?): Boolean {
            return s == null || s.isEmpty()
        }

        /**
         * 判断字符串是否为null或全为空格
         *
         * @param s 待校验字符串
         * @return `true`: null或全空格<br></br> `false`: 不为null且不全空格
         */
        fun isTrimEmpty(s: String?): Boolean {
            return s == null || s.trim { it <= ' ' }.isEmpty()
        }

        /**
         * 判断字符串是否为null或全为空白字符
         *
         * @param s 待校验字符串
         * @return `true`: null或全空白字符<br></br> `false`: 不为null且不全空白字符
         */
        fun isSpace(s: String?): Boolean {
            if (s == null) return true
            var i = 0
            val len = s.length
            while (i < len) {
                if (!Character.isWhitespace(s[i])) {
                    return false
                }
                ++i
            }
            return true
        }

        /**
         * 判断两字符串是否相等
         *
         * @param a 待校验字符串a
         * @param b 待校验字符串b
         * @return `true`: 相等<br></br>`false`: 不相等
         */
        fun equals(a: CharSequence?, b: CharSequence?): Boolean {
            if (a === b) return true
            val length: Int = a!!.length
            if (b != null && length == b.length) {
                return if (a is String && b is String) {
                    a == b
                } else {
                    (0 until length).none { a[it] != b[it] }
                }
            }
            return false
        }

        /**
         * 判断两字符串忽略大小写是否相等
         *
         * @param a 待校验字符串a
         * @param b 待校验字符串b
         * @return `true`: 相等<br></br>`false`: 不相等
         */
        fun equalsIgnoreCase(a: String?, b: String?): Boolean {
            return a?.equals(b!!, ignoreCase = true) ?: (b == null)
        }

        /**
         * null转为长度为0的字符串
         *
         * @param s 待转字符串
         * @return s为null转为长度为0字符串，否则不改变
         */
        fun null2Length0(s: String?): String {
            return s ?: ""
        }

        /**
         * 返回字符串长度
         *
         * @param s 字符串
         * @return null返回0，其他返回自身长度
         */
        fun length(s: CharSequence?): Int {
            return s?.length ?: 0
        }

        /**
         * 首字母大写
         *
         * @param s 待转字符串
         * @return 首字母大写字符串
         */
        fun upperFirstLetter(s: String): String? {
            return if (isEmpty(s) || !Character.isLowerCase(s[0])) s else (s[0].toInt() - 32).toChar().toString() + s.substring(1)
        }

        /**
         * 首字母小写
         *
         * @param s 待转字符串
         * @return 首字母小写字符串
         */
        fun lowerFirstLetter(s: String): String? {
            return if (isEmpty(s) || !Character.isUpperCase(s[0])) s else (s[0].toInt() + 32).toChar().toString() + s.substring(1)
        }

        /**
         * 反转字符串
         *
         * @param s 待反转字符串
         * @return 反转字符串
         */
        fun reverse(s: String): String {
            val len = length(s)
            if (len <= 1) return s
            val mid = len shr 1
            val chars = s.toCharArray()
            var c: Char
            for (i in 0 until mid) {
                c = chars[i]
                chars[i] = chars[len - i - 1]
                chars[len - i - 1] = c
            }
            return String(chars)
        }

        /**
         * 转化为半角字符
         *
         * @param s 待转字符串
         * @return 半角字符串
         */
        fun toDBC(s: String): String? {
            if (isEmpty(s)) return s
            val chars = s.toCharArray()
            var i = 0
            val len = chars.size
            while (i < len) {
                when {
                    chars[i].toInt() == 12288 -> chars[i] = ' '
                    chars[i].toInt() in 65281..65374 -> chars[i] = (chars[i].toInt() - 65248).toChar()
                    else -> chars[i] = chars[i]
                }
                i++
            }
            return String(chars)
        }

        /**
         * 转化为全角字符
         *
         * @param s 待转字符串
         * @return 全角字符串
         */
        fun toSBC(s: String): String? {
            if (isEmpty(s)) return s
            val chars = s.toCharArray()
            var i = 0
            val len = chars.size
            while (i < len) {
                when {
                    chars[i] == ' ' -> chars[i] = 12288.toChar()
                    chars[i].toInt() in 33..126 -> chars[i] = (chars[i].toInt() + 65248).toChar()
                    else -> chars[i] = chars[i]
                }
                i++
            }
            return String(chars)
        }
    }
}
