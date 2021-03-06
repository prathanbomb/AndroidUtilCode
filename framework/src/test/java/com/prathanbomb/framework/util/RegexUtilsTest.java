package com.prathanbomb.framework.util;

import org.junit.Test;

import java.util.Arrays;

import static com.prathanbomb.framework.util.RegexUtils.*;
import static com.google.common.truth.Truth.assertThat;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/08/16
 *     desc  : RegularUtils单元测试
 * </pre>
 */
public class RegexUtilsTest {

    @Test
    public void testIsMobileSimple() throws Exception {
        assertThat(isMobileSimple("11111111111")).isTrue();
    }

    @Test
    public void testIsMobileExact() throws Exception {
        assertThat(isMobileExact("11111111111")).isFalse();
        assertThat(isMobileExact("13888880000")).isTrue();
    }

    @Test
    public void testIsTel() throws Exception {
        assertThat(isTel("033-88888888")).isTrue();
        assertThat(isTel("033-7777777")).isTrue();
        assertThat(isTel("0444-88888888")).isTrue();
        assertThat(isTel("0444-7777777")).isTrue();
        assertThat(isTel("033 88888888")).isTrue();
        assertThat(isTel("033 7777777")).isTrue();
        assertThat(isTel("0444 88888888")).isTrue();
        assertThat(isTel("0444 7777777")).isTrue();
        assertThat(isTel("03388888888")).isTrue();
        assertThat(isTel("0337777777")).isTrue();
        assertThat(isTel("044488888888")).isTrue();
        assertThat(isTel("04447777777")).isTrue();

        assertThat(isTel("133-88888888")).isFalse();
        assertThat(isTel("033-666666")).isFalse();
        assertThat(isTel("0444-999999999")).isFalse();
    }

    @Test
    public void testIsIDCard() throws Exception {
        assertThat(isIDCard18("33698418400112523x")).isTrue();
        assertThat(isIDCard18("336984184001125233")).isTrue();
        assertThat(isIDCard18("336984184021125233")).isFalse();
    }

    @Test
    public void testIsEmail() throws Exception {
        assertThat(isEmail("prathanbomb@qq.com")).isTrue();
        assertThat(isEmail("prathanbomb@qq")).isFalse();
    }

    @Test
    public void testIsURL() throws Exception {
        assertThat(isURL("http://prathanbomb.com")).isTrue();
        assertThat(isURL("https:blank")).isFalse();
    }

    @Test
    public void testIsChz() throws Exception {
        assertThat(isZh("我")).isTrue();
        assertThat(isZh("wo")).isFalse();
    }

    @Test
    public void testIsUsername() throws Exception {
        assertThat(isUsername("小明233333")).isTrue();
        assertThat(isUsername("小明")).isFalse();
        assertThat(isUsername("小明233333_")).isFalse();
    }

    @Test
    public void testIsDate() throws Exception {
        assertThat(isDate("2016-08-16")).isTrue();
        assertThat(isDate("2016-02-29")).isTrue();
        assertThat(isDate("2015-02-29")).isFalse();
        assertThat(isDate("2016-8-16")).isFalse();
    }

    @Test
    public void testIsIP() throws Exception {
        assertThat(isIP("255.255.255.0")).isTrue();
        assertThat(isIP("256.255.255.0")).isFalse();
    }

    @Test
    public void testIsMatch() throws Exception {
        assertThat(isMatch("\\d?", "1")).isTrue();
        assertThat(isMatch("\\d?", "a")).isFalse();
    }

    @Test
    public void testGetMatches() throws Exception {
        // 贪婪
        System.out.println(getMatches("b.*j", "prathanbomb prathanbomb"));
        // 懒惰
        System.out.println(getMatches("b.*?j", "prathanbomb prathanbomb"));
    }

    @Test
    public void testGetSplits() throws Exception {
        System.out.println(Arrays.asList(getSplits("1 2 3", " ")));
    }

    @Test
    public void testGetReplace() throws Exception {
        System.out.println(getReplaceFirst("1 2 3", " ", ", "));
    }

    @Test
    public void testGetReplaceAll() throws Exception {
        System.out.println(getReplaceAll("1 2 3", " ", ", "));
    }
}