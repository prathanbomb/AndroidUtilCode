package com.prathanbomb.androidutilcode;

import com.prathanbomb.androidutilcode.base.BaseApplication;
import com.prathanbomb.subutil.util.ThreadPoolUtils;
import com.prathanbomb.framework.util.CrashUtils;
import com.prathanbomb.framework.util.FileIOUtils;
import com.prathanbomb.framework.util.FileUtils;
import com.prathanbomb.framework.util.LogUtils;
import com.prathanbomb.framework.util.Utils;
import com.squareup.leakcanary.LeakCanary;

import java.io.IOException;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/10/12
 *     desc  : 工具类测试App
 * </pre>
 */
public class UtilsApp extends BaseApplication {

    private static UtilsApp sInstance;

    public static UtilsApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Utils.Companion.init(this);
        com.prathanbomb.subutil.util.Utils.init(this);
        initLeakCanary();
        initLog();
        initCrash();
        initAssets();
    }

    private void initLeakCanary() {
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    // init it in ur application
    public void initLog() {
        LogUtils.Config config = LogUtils.Companion.getConfig()
                .setLogSwitch(BuildConfig.DEBUG)// 设置log总开关，包括输出到控制台和文件，默认开
                .setConsoleSwitch(BuildConfig.DEBUG)// 设置是否输出到控制台开关，默认开
                .setGlobalTag(null)// 设置log全局标签，默认为空
                // 当全局标签不为空时，我们输出的log全部为该tag，
                // 为空时，如果传入的tag为空那就显示类名，否则显示tag
                .setLogHeadSwitch(true)// 设置log头信息开关，默认为开
                .setLog2FileSwitch(false)// 打印log时是否存到文件的开关，默认关
                .setDir("")// 当自定义路径为空时，写入应用的/cache/log/目录中
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setConsoleFilter(LogUtils.V)// log的控制台过滤器，和logcat过滤器同理，默认Verbose
                .setFileFilter(LogUtils.V);// log文件过滤器，和logcat过滤器同理，默认Verbose
        LogUtils.Companion.d(config.toString());
    }

    private void initCrash() {
        CrashUtils.Companion.init();
    }

    private void initAssets() {
        if (!FileUtils.Companion.isFileExists(com.prathanbomb.androidutilcode.Config.getTestApkPath())) {
            ThreadPoolUtils poolUtils = new ThreadPoolUtils(ThreadPoolUtils.SingleThread, 1);
            poolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        FileIOUtils.Companion.writeFileFromIS(Config.getTestApkPath(), getAssets().open("test_install"), false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
