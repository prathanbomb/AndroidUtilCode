package com.prathanbomb.framework.util

import com.google.common.truth.Truth.assertThat
import com.prathanbomb.framework.util.EncodeUtils.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/12
 * desc  : EncodeUtils单元测试
</pre> *
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class EncodeUtilsTest {

    internal var urlEncodeString = "%E5%93%88%E5%93%88%E5%93%88"
    internal var html = "<html>" +
            "<head>" +
            "<title>我的第一个 HTML 页面</title>" +
            "</head>" +
            "<body>" +
            "<p>body 元素的内容会显示在浏览器中。</p>" +
            "<p>title 元素的内容会显示在浏览器的标题栏中。</p>" +
            "</body>" +
            "</html>"
    internal var encodeHtml = "&lt;html&gt;&lt;head&gt;&lt;title&gt;我的第一个 HTML 页面&lt;/title&gt;&lt;/head&gt;&lt;body&gt;&lt;p&gt;body 元素的内容会显示在浏览器中。&lt;/p&gt;&lt;p&gt;title 元素的内容会显示在浏览器的标题栏中。&lt;/p&gt;&lt;/body&gt;&lt;/html&gt;"

    @Test
    @Throws(Exception::class)
    fun testUrlEncode() {
        assertThat(urlEncode("哈哈哈")).isEqualTo(urlEncodeString)
        assertThat(urlEncode("哈哈哈", "UTF-8")).isEqualTo(urlEncodeString)
    }

    @Test
    @Throws(Exception::class)
    fun testUrlDecode() {
        assertThat(urlDecode(urlEncodeString)).isEqualTo("哈哈哈")
        assertThat(urlDecode(urlEncodeString, "UTF-8")).isEqualTo("哈哈哈")
    }

    @Test
    @Throws(Exception::class)
    fun testBase64EncodeAndDecode() {
        assertThat(base64Decode(base64Encode("prathanbomb")))
                .isEqualTo("prathanbomb".toByteArray())
        assertThat(base64Decode(base64Encode2String("prathanbomb".toByteArray())))
                .isEqualTo("prathanbomb".toByteArray())
        assertThat(base64Encode2String("prathanbomb".toByteArray()))
                .isEqualTo("Ymxhbmtq")
        assertThat(base64Encode("prathanbomb".toByteArray()))
                .isEqualTo("Ymxhbmtq".toByteArray())
    }

    @Test
    @Throws(Exception::class)
    fun testHtmlEncode() {
        assertThat(htmlEncode(html)).isEqualTo(encodeHtml)
    }

    @Test
    @Throws(Exception::class)
    fun testHtmlDecode() {
        assertThat(htmlDecode(encodeHtml).toString()).isEqualTo(html)
    }
}