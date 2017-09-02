package com.prathanbomb.framework.util


import com.google.common.truth.Truth.assertThat
import com.prathanbomb.framework.constant.MemoryConstants
import com.prathanbomb.framework.constant.TimeConstants
import org.junit.Test


/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/13
 * desc  : ConvertUtils单元测试
</pre> *
 */
class ConvertUtilsTest {

    internal var mBytes = byteArrayOf(0x00, 0x08, 0xdb.toByte(), 0x33, 0x45, 0xab.toByte(), 0x02, 0x23)
    internal var hexString = "0008DB3345AB0223"

    @Test
    @Throws(Exception::class)
    fun testBytes2HexString() {
        assertThat(ConvertUtils.bytes2HexString(mBytes)).isEqualTo(hexString)
    }

    @Test
    @Throws(Exception::class)
    fun testHexString2Bytes() {
        assertThat(ConvertUtils.hexString2Bytes(hexString)).isEqualTo(mBytes)
    }

    internal var mChars1 = charArrayOf('0', '1', '2')
    internal var mBytes1 = byteArrayOf(48, 49, 50)

    @Test
    @Throws(Exception::class)
    fun testChars2Bytes() {
        assertThat(ConvertUtils.chars2Bytes(mChars1)).isEqualTo(mBytes1)
    }

    @Test
    @Throws(Exception::class)
    fun testBytes2Chars() {
        assertThat(ConvertUtils.bytes2Chars(mBytes1)).isEqualTo(mChars1)
    }

    @Test
    @Throws(Exception::class)
    fun testByte2Unit() {
        assertThat(ConvertUtils.byte2MemorySize(MemoryConstants.GB.toLong(), MemoryConstants.MB) - 1024).isWithin(0.001)
    }

    @Test
    @Throws(Exception::class)
    fun testByte2FitSize() {
        assertThat(ConvertUtils.byte2FitMemorySize((1024 * 1024 * 3 + 1024 * 100).toLong())).isEqualTo("3.098MB")
    }

    @Test
    @Throws(Exception::class)
    fun testMillis2FitTimeSpan() {
        val millis = (TimeConstants.DAY * 6 + TimeConstants.HOUR * 6
                + TimeConstants.MIN * 6 + TimeConstants.SEC * 6 + 6).toLong()
        println(ConvertUtils.millis2FitTimeSpan(millis, 7))
        println(ConvertUtils.millis2FitTimeSpan(millis, 4))
        println(ConvertUtils.millis2FitTimeSpan(millis, 3))
        println(ConvertUtils.millis2FitTimeSpan(millis * 4, 5))
    }

    @Test
    @Throws(Exception::class)
    fun testBytes2Bits() {
        println(ConvertUtils.bytes2Bits(byteArrayOf(0x7F, 0xFA.toByte())))
    }

    @Test
    @Throws(Exception::class)
    fun testBits2Bytes() {
        println(ConvertUtils.bytes2HexString(ConvertUtils.bits2Bytes("111111111111010")))
    }

    @Test
    @Throws(Exception::class)
    fun testInputStream2BytesAndBytes2InputStream() {
        val string = "this is test string"
        assertThat(String(ConvertUtils.inputStream2Bytes(
                ConvertUtils.bytes2InputStream(string.toByteArray(charset("UTF-8"))))!!))
                .isEqualTo(string)
    }

    @Test
    @Throws(Exception::class)
    fun testInputStream2StringAndString2InputStream() {
        val string = "this is test string"
        assertThat(ConvertUtils.inputStream2String(
                ConvertUtils.string2InputStream(string, "UTF-8"), "UTF-8")).isEqualTo(string)
    }
}