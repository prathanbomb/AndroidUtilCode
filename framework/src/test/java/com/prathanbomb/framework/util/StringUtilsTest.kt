package com.prathanbomb.framework.util

import com.google.common.truth.Truth.assertThat
import com.prathanbomb.framework.util.StringUtils.*
import org.junit.Test

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/16
 * desc  : StringUtils单元测试
</pre> *
 */
class StringUtilsTest {

    @Test
    @Throws(Exception::class)
    fun testIsEmpty() {
        assertThat(isEmpty("")).isTrue()
        assertThat(isEmpty(null)).isTrue()
        assertThat(isEmpty(" ")).isFalse()
    }

    @Test
    @Throws(Exception::class)
    fun testIsSpace() {
        assertThat(isSpace("")).isTrue()
        assertThat(isSpace(null)).isTrue()
        assertThat(isSpace(" ")).isTrue()
        assertThat(isSpace("　 \n\t\r")).isTrue()
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        assertThat(StringUtils.equals(null, null)).isEqualTo(true)
        assertThat(StringUtils.equals("prathanbomb", "prathanbomb")).isEqualTo(true)
        assertThat(StringUtils.equals("prathanbomb", "prathanbomb")).isEqualTo(false)
    }

    @Test
    @Throws(Exception::class)
    fun testEqualsIgnoreCase() {
        assertThat(equalsIgnoreCase(null, null)).isEqualTo(true)
        assertThat(equalsIgnoreCase(null, "prathanbomb")).isEqualTo(false)
        assertThat(equalsIgnoreCase("prathanbomb", "prathanbomb")).isEqualTo(true)
        assertThat(equalsIgnoreCase("prathanbomb", "prathanbomb")).isEqualTo(true)
        assertThat(equalsIgnoreCase("prathanbomb", "blank")).isEqualTo(false)
    }

    @Test
    @Throws(Exception::class)
    fun testNull2Length0() {
        assertThat(null2Length0(null)).isEqualTo("")
    }

    @Test
    @Throws(Exception::class)
    fun testLength() {
        assertThat(length(null)).isEqualTo(0)
        assertThat(length("")).isEqualTo(0)
        assertThat(length("prathanbomb")).isEqualTo(6)
    }

    @Test
    @Throws(Exception::class)
    fun testUpperFirstLetter() {
        assertThat(upperFirstLetter("prathanbomb")).isEqualTo("prathanbomb")
        assertThat(upperFirstLetter("prathanbomb")).isEqualTo("prathanbomb")
        assertThat(upperFirstLetter("1prathanbomb")).isEqualTo("1prathanbomb")
    }

    @Test
    @Throws(Exception::class)
    fun testLowerFirstLetter() {
        assertThat(lowerFirstLetter("prathanbomb")).isEqualTo("prathanbomb")
        assertThat(lowerFirstLetter("prathanbomb")).isEqualTo("prathanbomb")
        assertThat(lowerFirstLetter("1prathanbomb")).isEqualTo("1prathanbomb")
    }

    @Test
    @Throws(Exception::class)
    fun testReverse() {
        assertThat(reverse("prathanbomb")).isEqualTo("jknalb")
        assertThat(reverse("blank")).isEqualTo("knalb")
        assertThat(reverse("测试中文")).isEqualTo("文中试测")
        assertThat(reverse(null)).isNull()
    }

    @Test
    @Throws(Exception::class)
    fun testToDBC() {
        assertThat(toDBC("　，．＆")).isEqualTo(" ,.&")
    }

    @Test
    @Throws(Exception::class)
    fun testToSBC() {
        assertThat(toSBC(" ,.&")).isEqualTo("　，．＆")
    }
}