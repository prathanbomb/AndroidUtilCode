package com.prathanbomb.androidutilcode;

import com.prathanbomb.framework.util.Utils;

import java.io.File;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2017/05/10
 *     desc  :
 * </pre>
 */
public class Config {
    public static final String PKG      = "com.prathanbomb.androidutilcode";
    public static final String TEST_PKG = "com.prathanbomb.testinstall";
    public static final String GITHUB   = "https://github.com/prathanbomb/AndroidUtilCode";
    public static final String BLOG     = "http://www.jianshu.com/u/46702d5c6978";

    private static String testApkPath;

    public static String getTestApkPath() {
        if (testApkPath == null)
            testApkPath = Utils.Companion.getApp().getCacheDir().getAbsolutePath() + File.separatorChar + "apk" + File.separatorChar + "test_install.apk";
        return testApkPath;
    }
}