package com.prathanbomb.utilcode.util;

import com.prathanbomb.framework.util.StringUtils;

import org.junit.Test;

import static com.prathanbomb.framework.util.StringUtils.*;
import static com.google.common.truth.Truth.assertThat;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/08/16
 *     desc  : StringUtils单元测试
 * </pre>
 */
public class StringUtilsTest {

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(isEmpty("")).isTrue();
        assertThat(isEmpty(null)).isTrue();
        assertThat(isEmpty(" ")).isFalse();
    }

    @Test
    public void testIsSpace() throws Exception {
        assertThat(isSpace("")).isTrue();
        assertThat(isSpace(null)).isTrue();
        assertThat(isSpace(" ")).isTrue();
        assertThat(isSpace("　 \n\t\r")).isTrue();
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(StringUtils.equals(null, null)).isEqualTo(true);
        assertThat(StringUtils.equals("prathanbomb", "prathanbomb")).isEqualTo(true);
        assertThat(StringUtils.equals("prathanbomb", "prathanbomb")).isEqualTo(false);
    }

    @Test
    public void testEqualsIgnoreCase() throws Exception {
        assertThat(equalsIgnoreCase(null, null)).isEqualTo(true);
        assertThat(equalsIgnoreCase(null, "prathanbomb")).isEqualTo(false);
        assertThat(equalsIgnoreCase("prathanbomb", "prathanbomb")).isEqualTo(true);
        assertThat(equalsIgnoreCase("prathanbomb", "prathanbomb")).isEqualTo(true);
        assertThat(equalsIgnoreCase("prathanbomb", "blank")).isEqualTo(false);
    }

    @Test
    public void testNull2Length0() throws Exception {
        assertThat(null2Length0(null)).isEqualTo("");
    }

    @Test
    public void testLength() throws Exception {
        assertThat(length(null)).isEqualTo(0);
        assertThat(length("")).isEqualTo(0);
        assertThat(length("prathanbomb")).isEqualTo(6);
    }

    @Test
    public void testUpperFirstLetter() throws Exception {
        assertThat(upperFirstLetter("prathanbomb")).isEqualTo("prathanbomb");
        assertThat(upperFirstLetter("prathanbomb")).isEqualTo("prathanbomb");
        assertThat(upperFirstLetter("1prathanbomb")).isEqualTo("1prathanbomb");
    }

    @Test
    public void testLowerFirstLetter() throws Exception {
        assertThat(lowerFirstLetter("prathanbomb")).isEqualTo("prathanbomb");
        assertThat(lowerFirstLetter("prathanbomb")).isEqualTo("prathanbomb");
        assertThat(lowerFirstLetter("1prathanbomb")).isEqualTo("1prathanbomb");
    }

    @Test
    public void testReverse() throws Exception {
        assertThat(reverse("prathanbomb")).isEqualTo("jknalb");
        assertThat(reverse("blank")).isEqualTo("knalb");
        assertThat(reverse("测试中文")).isEqualTo("文中试测");
        assertThat(reverse(null)).isNull();
    }

    @Test
    public void testToDBC() throws Exception {
        assertThat(toDBC("　，．＆")).isEqualTo(" ,.&");
    }

    @Test
    public void testToSBC() throws Exception {
        assertThat(toSBC(" ,.&")).isEqualTo("　，．＆");
    }
}