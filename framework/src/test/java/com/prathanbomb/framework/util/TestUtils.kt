package com.prathanbomb.framework.util

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

import java.io.File

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/21
 * desc  : 单元测试工具类
</pre> *
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TestUtils {

    //    @Test
    @Throws(Exception::class)
    fun readme2Eng() {
        formatCN()
        val readmeCN = File(File(System.getProperty("user.dir")).absolutePath + FILE_SEP + "README-CN.md")
        val readmeEng = File(File(System.getProperty("user.dir")).absolutePath + FILE_SEP + "README.md")
        val list = FileIOUtils.readFile2List(readmeCN, "UTF-8")
        val sb = StringBuilder("![logo][logo]" + LINE_SEP + LINE_SEP +
                "[![auc][aucsvg]][auc] [![api][apisvg]][api] [![build][buildsvg]][build] [![Insight][insightsvg]][insight] [![License][licensesvg]][license]" + LINE_SEP + LINE_SEP +
                "## [README of Chinese][readme-cn.md]" + LINE_SEP + LINE_SEP +
                "## API" + LINE_SEP + LINE_SEP)
        val lines = list.subList(8, list.size)
        for (line in lines) {
            if (line.contains("* ###")) {
                if (line.contains("Utils")) {
                    val utilsName = line.substring(line.indexOf("[") + 1, line.indexOf("Utils"))
                    sb.append("* ### About ").append(utilsName).append(line.substring(line.indexOf("→")))
                } else {
                    sb.append("* ### About Log→[update_log.md][update_log.md]")
                }
            } else if (line.contains(": ") && !line.contains("[")) {
                sb.append(line.substring(0, line.indexOf(':')).trim { it <= ' ' })
            } else if (line.contains("* 做")) {
                sb.append("* **I'm so sorry for that the code is annotated with Chinese.**")
            } else if (line.contains("* QQ") || line.contains("* 我的")) {
                continue
            } else {
                sb.append(line)
            }
            sb.append(LINE_SEP)
        }
        FileIOUtils.writeFileFromString(readmeEng, sb.toString())
    }

    @Throws(Exception::class)
    fun formatCN() {
        val readmeCN = File(File(System.getProperty("user.dir")).absolutePath + FILE_SEP + "README-CN.md")
        val list = FileIOUtils.readFile2List(readmeCN, "UTF-8")
        val sb = StringBuilder()
        for (i in 0..3) {
            sb.append(list[i]).append(LINE_SEP)
        }
        val space = " "
        var i = 4
        val len = list.size
        while (i < len) {
            var line = list[i]
            if (line.contains("* ###") && line.contains("Utils")) {
                sb.append(line).append(LINE_SEP)
                var maxLen = 0
                line = list[++i]
                // 获取需填充最大空格数
                run {
                    var j = i
                    while (line != "") {
                        if (line == "```") {
                            line = list[++j]
                            continue
                        }
                        maxLen = Math.max(maxLen, line.replace(" ", "").replace(",", ", ").indexOf(':'))
                        line = list[++j]
                    }
                }
                line = list[i]
                while (line != "") {
                    if (line == "```") {
                        sb.append("```").append(LINE_SEP)
                        line = list[++i]
                        continue
                    }
                    val noSpaceLine = line.replace(" ", "")
                    val l = maxLen - line.replace(" ", "").replace(",", ", ").indexOf(':')
                    var spaces = ""
                    for (j in 0..l - 1) {
                        spaces += space
                    }
                    val temp = noSpaceLine.substring(0, noSpaceLine.indexOf(':')) + spaces + ": " + noSpaceLine.substring(noSpaceLine.indexOf(':') + 1) + LINE_SEP
                    sb.append(temp.replace(",", ", "))
                    line = list[++i]
                }
            } else {
                sb.append(line)
            }
            sb.append(LINE_SEP)
            ++i
        }
        FileIOUtils.writeFileFromString(readmeCN, sb.toString(), false)
    }

    @Test
    @Throws(Exception::class)
    fun test() {

    }

    companion object {

        internal val FILE_SEP = System.getProperty("file.separator")

        internal val LINE_SEP = System.getProperty("line.separator")

        internal val TEST_PATH: String

        init {
            var projectPath = System.getProperty("user.dir")
            if (!projectPath.contains("utilcode")) {
                projectPath += FILE_SEP + "utilcode"
            }
            TEST_PATH = projectPath + FILE_SEP + "src" + FILE_SEP + "test" + FILE_SEP + "res"
        }

        fun init() {
            Utils.init(RuntimeEnvironment.application)
        }
    }
}