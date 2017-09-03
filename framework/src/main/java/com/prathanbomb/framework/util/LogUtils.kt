package com.prathanbomb.framework.util

import android.os.Environment
import android.support.annotation.IntDef
import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.zip.DataFormatException
import java.util.zip.Deflater
import java.util.zip.Inflater
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/09/21
 * desc  : Log相关工具类
</pre> *
 */
class LogUtils private constructor() {

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(V.toLong(), D.toLong(), I.toLong(), W.toLong(), E.toLong(), A.toLong())
    private annotation class TYPE

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }


    class Config internal constructor() {
        init {
            if (defaultDir.isNullOrEmpty()) {
                defaultDir = if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState() && Utils.app.externalCacheDir != null)
                    Utils.app.externalCacheDir.toString() + FILE_SEP + "log" + FILE_SEP
                else {
                    Utils.app.cacheDir.toString() + FILE_SEP + "log" + FILE_SEP
                }
            }
        }

        fun setLogSwitch(logSwitch: Boolean): Config {
            LogUtils.sLogSwitch = logSwitch
            return this
        }

        fun setConsoleSwitch(consoleSwitch: Boolean): Config {
            LogUtils.sLog2ConsoleSwitch = consoleSwitch
            return this
        }

        fun setGlobalTag(tag: String): Config {
            if (isSpace(tag)) {
                LogUtils.sGlobalTag = ""
                sTagIsSpace = true
            } else {
                LogUtils.sGlobalTag = tag
                sTagIsSpace = false
            }
            return this
        }

        fun setLogHeadSwitch(logHeadSwitch: Boolean): Config {
            LogUtils.sLogHeadSwitch = logHeadSwitch
            return this
        }

        fun setLog2FileSwitch(log2FileSwitch: Boolean): Config {
            LogUtils.sLog2FileSwitch = log2FileSwitch
            return this
        }

        fun setDir(dir: String): Config {
            if (isSpace(dir)) {
                LogUtils.dir = null
            } else {
                LogUtils.dir = if (dir.endsWith(FILE_SEP)) dir else dir + FILE_SEP
            }
            return this
        }

        fun setDir(dir: File?): Config {
            LogUtils.dir = if (dir == null) null else dir.absolutePath + FILE_SEP
            return this
        }

        fun setBorderSwitch(borderSwitch: Boolean): Config {
            LogUtils.sLogBorderSwitch = borderSwitch
            return this
        }

        fun setConsoleFilter(@TYPE consoleFilter: Int): Config {
            LogUtils.sConsoleFilter = consoleFilter
            return this
        }

        fun setFileFilter(@TYPE fileFilter: Int): Config {
            LogUtils.sFileFilter = fileFilter
            return this
        }

        override fun toString(): String {
            return ("switch: " + sLogSwitch
            +LINE_SEP + "console: " + sLog2ConsoleSwitch
            +LINE_SEP + "tag: " + if (sTagIsSpace) "null" else sGlobalTag
            +LINE_SEP + "head: " + sLogHeadSwitch
            +LINE_SEP + "file: " + sLog2FileSwitch
            +LINE_SEP + "dir: " + if (dir == null) defaultDir else dir
            +LINE_SEP + "border: " + sLogBorderSwitch
            +LINE_SEP + "consoleFilter: " + T[sConsoleFilter - V]
            +LINE_SEP + "fileFilter: " + T[sFileFilter - V])
        }
    }

    companion object {

        const val V = Log.VERBOSE
        const val D = Log.DEBUG
        const val I = Log.INFO
        const val W = Log.WARN
        const val E = Log.ERROR
        const val A = Log.ASSERT

        private val T = charArrayOf('V', 'D', 'I', 'W', 'E', 'A')

        private val FILE = 0x10
        private val JSON = 0x20
        private val XML = 0x30
        private var executor: ExecutorService? = null
        private var defaultDir: String? = null// log默认存储目录
        private var dir: String? = null       // log存储目录

        private var sLogSwitch = true // log总开关，默认开
        private var sLog2ConsoleSwitch = true // logcat是否打印，默认打印
        private var sGlobalTag: String? = null // log标签
        private var sTagIsSpace = true // log标签是否为空白
        private var sLogHeadSwitch = true // log头部开关，默认开
        private var sLog2FileSwitch = false// log写入文件开关，默认关
        private var sLogBorderSwitch = true // log边框开关，默认开
        private var sConsoleFilter = V    // log控制台过滤器
        private var sFileFilter = V    // log文件过滤器

        val config = Config()
        private val FILE_SEP = System.getProperty("file.separator")
        private val LINE_SEP = System.getProperty("line.separator")
        private val TOP_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════"
        private val LEFT_BORDER = "║ "
        private val BOTTOM_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════"
        private val MAX_LEN = 4000
        private val FORMAT = SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault())

        private val NULL_TIPS = "Log with null object."
        private val NULL = "null"
        private val ARGS = "args"

        fun v(contents: Any) {
            log(V, sGlobalTag, contents)
        }

        fun v(tag: String, vararg contents: Any) {
            log(V, tag, *contents)
        }

        fun d(contents: Any) {
            log(D, sGlobalTag, contents)
        }

        fun d(tag: String, vararg contents: Any) {
            log(D, tag, *contents)
        }

        fun i(contents: Any) {
            log(I, sGlobalTag, contents)
        }

        fun i(tag: String, vararg contents: Any) {
            log(I, tag, *contents)
        }

        fun w(contents: Any) {
            log(W, sGlobalTag, contents)
        }

        fun w(tag: String, vararg contents: Any) {
            log(W, tag, *contents)
        }

        fun e(contents: Any) {
            log(E, sGlobalTag, contents)
        }

        fun e(tag: String, vararg contents: Any) {
            log(E, tag, *contents)
        }

        fun a(contents: Any) {
            log(A, sGlobalTag, contents)
        }

        fun a(tag: String, vararg contents: Any) {
            log(A, tag, *contents)
        }

        fun file(contents: Any) {
            log(FILE or D, sGlobalTag, contents)
        }

        fun file(@TYPE type: Int, contents: Any) {
            log(FILE or type, sGlobalTag, contents)
        }

        fun file(tag: String, contents: Any) {
            log(FILE or D, tag, contents)
        }

        fun file(@TYPE type: Int, tag: String, contents: Any) {
            log(FILE or type, tag, contents)
        }

        fun json(contents: String) {
            log(JSON or D, sGlobalTag, contents)
        }

        fun json(@TYPE type: Int, contents: String) {
            log(JSON or type, sGlobalTag, contents)
        }

        fun json(tag: String, contents: String) {
            log(JSON or D, tag, contents)
        }

        fun json(@TYPE type: Int, tag: String, contents: String) {
            log(JSON or type, tag, contents)
        }

        fun xml(contents: String) {
            log(XML or D, sGlobalTag, contents)
        }

        fun xml(@TYPE type: Int, contents: String) {
            log(XML or type, sGlobalTag, contents)
        }

        fun xml(tag: String, contents: String) {
            log(XML or D, tag, contents)
        }

        fun xml(@TYPE type: Int, tag: String, contents: String) {
            log(XML or type, tag, contents)
        }

        private fun log(type: Int, tag: String?, vararg contents: Any) {
            if (!sLogSwitch || !sLog2ConsoleSwitch && !sLog2FileSwitch) return
            val type_low = type and 0x0f
            val type_high = type and 0xf0
            if (type_low < sConsoleFilter && type_low < sFileFilter) return
            val tagAndHead = processTagAndHead(tag)
            val body = processBody(type_high, *contents)
            if (sLog2ConsoleSwitch && type_low >= sConsoleFilter) {
                print2Console(type_low, tagAndHead[0], tagAndHead[1] + body)
            }
            if (sLog2FileSwitch || type_high == FILE) {
                if (type_low >= sFileFilter) print2File(type_low, tagAndHead[0], tagAndHead[2] + body)
            }
        }

        private fun processTagAndHead(tag: String?): Array<String> {
            var tag = tag
            if (!sTagIsSpace && !sLogHeadSwitch) {
                tag = sGlobalTag
            } else {
                val targetElement = Throwable().stackTrace[3]
                var className = targetElement.className
                val classNameInfo = className.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (classNameInfo.isNotEmpty()) {
                    className = classNameInfo[classNameInfo.size - 1]
                }
                if (className.contains("$")) {
                    className = className.split("\\$".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
                }
                if (sTagIsSpace) {
                    tag = if (isSpace(tag)) className else tag
                }
                if (sLogHeadSwitch) {
                    val head = Formatter()
                            .format("%s, %s(%s.java:%d)",
                                    Thread.currentThread().name,
                                    targetElement.methodName,
                                    className,
                                    targetElement.lineNumber)
                            .toString()
                    return arrayOf(tag!!, head + LINE_SEP, " [$head]: ")
                }
            }
            return arrayOf(tag!!, "", ": ")
        }

        private fun processBody(type: Int, vararg contents: Any): String {
            var body = NULL_TIPS
            if (contents.isNotEmpty()) {
                if (contents.size == 1) {
                    val `object` = contents[0]
                    body = `object`.toString()
                    if (type == JSON) {
                        body = formatJson(body)
                    } else if (type == XML) {
                        body = formatXml(body)
                    }
                } else {
                    val sb = StringBuilder()
                    var i = 0
                    val len = contents.size
                    while (i < len) {
                        val content = contents[i]
                        sb.append(ARGS)
                                .append("[")
                                .append(i)
                                .append("]")
                                .append(" = ")
                                .append(content.toString())
                                .append(LINE_SEP)
                        ++i
                    }
                    body = sb.toString()
                }
            }
            return body
        }

        private fun formatJson(json: String): String {
            var json = json
            try {
                if (json.startsWith("{")) {
                    json = JSONObject(json).toString(4)
                } else if (json.startsWith("[")) {
                    json = JSONArray(json).toString(4)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return json
        }

        private fun formatXml(xml: String): String {
            var xml = xml
            try {
                val xmlInput = StreamSource(StringReader(xml))
                val xmlOutput = StreamResult(StringWriter())
                val transformer = TransformerFactory.newInstance().newTransformer()
                transformer.setOutputProperty(OutputKeys.INDENT, "yes")
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4")
                transformer.transform(xmlInput, xmlOutput)
                xml = xmlOutput.writer.toString().replaceFirst(">".toRegex(), ">" + LINE_SEP)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return xml
        }

        private fun print2Console(type: Int, tag: String, msg: String) {
            var msg = msg
            if (sLogBorderSwitch) {
                print(type, tag, TOP_BORDER)
                msg = addLeftBorder(msg)
            }
            val len = msg.length
            val countOfSub = len / MAX_LEN
            if (countOfSub > 0) {
                print(type, tag, msg.substring(0, MAX_LEN))
                var sub: String
                var index = MAX_LEN
                for (i in 1 until countOfSub) {
                    sub = msg.substring(index, index + MAX_LEN)
                    print(type, tag, if (sLogBorderSwitch) LEFT_BORDER + sub else sub)
                    index += MAX_LEN
                }
                sub = msg.substring(index, len)
                print(type, tag, if (sLogBorderSwitch) LEFT_BORDER + sub else sub)
            } else {
                print(type, tag, msg)
            }
            if (sLogBorderSwitch) print(type, tag, BOTTOM_BORDER)
        }

        private fun print(type: Int, tag: String, msg: String) {
            Log.println(type, tag, msg)
        }

        private fun addLeftBorder(msg: String): String {
            if (!sLogBorderSwitch) return msg
            val sb = StringBuilder()
            val lines = msg.split(LINE_SEP.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (line in lines) {
                sb.append(LEFT_BORDER).append(line).append(LINE_SEP)
            }
            return sb.toString()
        }

        private fun print2File(type: Int, tag: String, msg: String) {
            val now = Date(System.currentTimeMillis())
            val format = FORMAT.format(now)
            val date = format.substring(0, 5)
            val time = format.substring(6)
            val fullPath = (if (dir == null) defaultDir else dir) + date + ".txt"
            if (!createOrExistsFile(fullPath)) {
                Log.e(tag, "log to $fullPath failed!")
                return
            }
            val sb = StringBuilder()
            sb.append(time)
                    .append(T[type - V])
                    .append("/")
                    .append(tag)
                    .append(msg)
                    .append(LINE_SEP)
            val content = sb.toString()
            if (executor == null) {
                executor = Executors.newSingleThreadExecutor()
            }
            executor!!.execute {
                var bw: BufferedWriter? = null
                try {
                    bw = BufferedWriter(FileWriter(fullPath, true))
                    bw.write(content)
                    Log.d(tag, "log to $fullPath success!")
                } catch (e: IOException) {
                    e.printStackTrace()
                    Log.e(tag, "log to $fullPath failed!")
                } finally {
                    try {
                        if (bw != null) {
                            bw.close()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
        }

        private fun createOrExistsFile(filePath: String): Boolean {
            val file = File(filePath)
            if (file.exists()) return file.isFile
            if (!createOrExistsDir(file.parentFile)) return false
            return try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
                false
            }

        }

        private fun createOrExistsDir(file: File?): Boolean {
            return file != null && if (file.exists()) file.isDirectory else file.mkdirs()
        }

        private fun isSpace(s: String?): Boolean {
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

        fun compress(input: ByteArray): ByteArray {
            val bos = ByteArrayOutputStream()
            val compressor = Deflater(1)
            try {
                compressor.setInput(input)
                compressor.finish()
                val buf = ByteArray(2048)
                while (!compressor.finished()) {
                    val count = compressor.deflate(buf)
                    bos.write(buf, 0, count)
                }
            } finally {
                compressor.end()
            }
            return bos.toByteArray()
        }

        fun uncompress(input: ByteArray): ByteArray {
            val bos = ByteArrayOutputStream()
            val decompressor = Inflater()
            try {
                decompressor.setInput(input)
                val buf = ByteArray(2048)
                while (!decompressor.finished()) {
                    var count = 0
                    try {
                        count = decompressor.inflate(buf)
                    } catch (e: DataFormatException) {
                        e.printStackTrace()
                    }

                    bos.write(buf, 0, count)
                }
            } finally {
                decompressor.end()
            }
            return bos.toByteArray()
        }
    }

}
