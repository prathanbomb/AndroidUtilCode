package com.prathanbomb.framework.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Parcel
import android.os.Parcelable
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File
import java.io.Serializable
import java.util.*

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2017/05/26
 * desc  :
</pre> *
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class CacheUtilsTest {

    private val path1 = TestUtils.TEST_PATH + TestUtils.FILE_SEP + "cache" + TestUtils.FILE_SEP + "cache1" + TestUtils.FILE_SEP
    private val path2 = TestUtils.TEST_PATH + TestUtils.FILE_SEP + "cache" + TestUtils.FILE_SEP + "cache2" + TestUtils.FILE_SEP
    private val file1 = File(path1)
    private val file2 = File(path2)

    private var mCacheUtils1: CacheUtils? = null
    private var mCacheUtils2: CacheUtils? = null

    private val mBytes = "CacheUtils".toByteArray()
    private val mString = "CacheUtils"
    private val mJSONObject = JSONObject()
    private val mJSONArray = JSONArray()
    private val mParcelableTest = ParcelableTest("prathanbomb", "CacheUtils")
    private val mSerializableTest = SerializableTest("prathanbomb", "CacheUtils")
    private val mBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565)
    private val mDrawable = BitmapDrawable(Utils.getApp().resources, mBitmap)

    init {
        try {
            mJSONObject.put("class", "CacheUtils")
            mJSONObject.put("author", "prathanbomb")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            mJSONArray.put(0, mJSONObject)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        if (mCacheUtils1 == null) {
            mCacheUtils1 = CacheUtils.getInstance(file1)
            mCacheUtils1!!.put("bytes1", mBytes, 60 * CacheUtils.SEC)
            mCacheUtils1!!.put("string1", mString, 60 * CacheUtils.MIN)
            mCacheUtils1!!.put("jsonObject1", mJSONObject, 24 * CacheUtils.HOUR)
            mCacheUtils1!!.put("jsonArray1", mJSONArray, 365 * CacheUtils.DAY)
            mCacheUtils1!!.put("bitmap1", mBitmap, 60 * CacheUtils.SEC)
            mCacheUtils1!!.put("drawable1", mDrawable, 60 * CacheUtils.SEC)
            mCacheUtils1!!.put("parcelable1", mParcelableTest, 60 * CacheUtils.SEC)
            mCacheUtils1!!.put("serializable1", mSerializableTest, 60 * CacheUtils.SEC)
        }
        if (mCacheUtils2 == null) {
            mCacheUtils2 = CacheUtils.getInstance(file2)
            mCacheUtils2!!.put("bytes2", mBytes)
            mCacheUtils2!!.put("string2", mString)
            mCacheUtils2!!.put("jsonObject2", mJSONObject)
            mCacheUtils2!!.put("jsonArray2", mJSONArray)
            mCacheUtils2!!.put("parcelable2", mParcelableTest)
            mCacheUtils2!!.put("serializable2", mSerializableTest)
            mCacheUtils2!!.put("bitmap2", mBitmap)
            mCacheUtils2!!.put("drawable2", mDrawable)
        }
    }

    @Test
    @Throws(Exception::class)
    fun getBytes() {
        Assert.assertEquals(mString, String(mCacheUtils1!!.getBytes("bytes1")!!))
        Assert.assertEquals(mString, String(mCacheUtils1!!.getBytes("bytes1", null)!!))
        Assert.assertNull(mCacheUtils1!!.getBytes("bytes2", null))

        Assert.assertEquals(mString, String(mCacheUtils2!!.getBytes("bytes2")!!))
        Assert.assertEquals(mString, String(mCacheUtils2!!.getBytes("bytes2", null)!!))
        Assert.assertNull(mCacheUtils2!!.getBytes("bytes1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getString() {
        Assert.assertEquals(mString, mCacheUtils1!!.getString("string1"))
        Assert.assertEquals(mString, mCacheUtils1!!.getString("string1", null))
        Assert.assertNull(mCacheUtils1!!.getString("string2", null))

        Assert.assertEquals(mString, mCacheUtils2!!.getString("string2"))
        Assert.assertEquals(mString, mCacheUtils2!!.getString("string2", null))
        Assert.assertNull(mCacheUtils2!!.getString("string1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getJSONObject() {
        Assert.assertEquals(mJSONObject.toString(), mCacheUtils1!!.getJSONObject("jsonObject1")!!.toString())
        Assert.assertEquals(mJSONObject.toString(), mCacheUtils1!!.getJSONObject("jsonObject1", null)!!.toString())
        Assert.assertNull(mCacheUtils1!!.getJSONObject("jsonObject2", null))

        Assert.assertEquals(mJSONObject.toString(), mCacheUtils2!!.getJSONObject("jsonObject2")!!.toString())
        Assert.assertEquals(mJSONObject.toString(), mCacheUtils2!!.getJSONObject("jsonObject2", null)!!.toString())
        Assert.assertNull(mCacheUtils2!!.getJSONObject("jsonObject1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getJSONArray() {
        Assert.assertEquals(mJSONArray.toString(), mCacheUtils1!!.getJSONArray("jsonArray1")!!.toString())
        Assert.assertEquals(mJSONArray.toString(), mCacheUtils1!!.getJSONArray("jsonArray1", null)!!.toString())
        Assert.assertNull(mCacheUtils1!!.getJSONArray("jsonArray2", null))


        Assert.assertEquals(mJSONArray.toString(), mCacheUtils2!!.getJSONArray("jsonArray2")!!.toString())
        Assert.assertEquals(mJSONArray.toString(), mCacheUtils2!!.getJSONArray("jsonArray2", null)!!.toString())
        Assert.assertNull(mCacheUtils2!!.getJSONArray("jsonArray1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getBitmap() {
        Assert.assertTrue(mCacheUtils1!!.getString("bitmap1") == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertTrue(mCacheUtils1!!.getString("bitmap1", null) == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertNull(mCacheUtils1!!.getString("bitmap2", null))

        Assert.assertTrue(mCacheUtils2!!.getString("bitmap2") == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertTrue(mCacheUtils2!!.getString("bitmap2", null) == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertNull(mCacheUtils2!!.getString("bitmap1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getDrawable() {
        Assert.assertTrue(mCacheUtils1!!.getString("drawable1") == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertTrue(mCacheUtils1!!.getString("drawable1", null) == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertNull(mCacheUtils1!!.getString("drawable2", null))

        Assert.assertTrue(mCacheUtils2!!.getString("drawable2") == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertTrue(mCacheUtils2!!.getString("drawable2", null) == "Bitmap (100 x 100) compressed as PNG with quality 100")
        Assert.assertNull(mCacheUtils2!!.getString("drawable1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getParcel() {
        Assert.assertTrue(mCacheUtils1!!.getParcelable("parcelable1", ParcelableTest.CREATOR) == mParcelableTest)
        Assert.assertTrue(mCacheUtils1!!.getParcelable("parcelable1", ParcelableTest.CREATOR, null) == mParcelableTest)
        Assert.assertNull(mCacheUtils1!!.getParcelable("parcelable2", ParcelableTest.CREATOR, null))

        Assert.assertTrue(mCacheUtils2!!.getParcelable("parcelable2", ParcelableTest.CREATOR) == mParcelableTest)
        Assert.assertTrue(mCacheUtils2!!.getParcelable("parcelable2", ParcelableTest.CREATOR, null) == mParcelableTest)
        Assert.assertNull(mCacheUtils2!!.getParcelable("parcelable1", ParcelableTest.CREATOR, null))
    }

    @Test
    @Throws(Exception::class)
    fun getSerializable() {
        Assert.assertTrue(mCacheUtils1!!.getSerializable("serializable1") == mSerializableTest)
        Assert.assertTrue(mCacheUtils1!!.getSerializable("serializable1", null) == mSerializableTest)
        Assert.assertNull(mCacheUtils1!!.getSerializable("parcelable2", null))

        Assert.assertTrue(mCacheUtils2!!.getSerializable("serializable2") == mSerializableTest)
        Assert.assertTrue(mCacheUtils2!!.getSerializable("serializable2", null) == mSerializableTest)
        Assert.assertNull(mCacheUtils2!!.getSerializable("parcelable1", null))
    }

    @Test
    @Throws(Exception::class)
    fun getCacheSize() {
        Assert.assertEquals(FileUtils.getDirLength(file1), mCacheUtils1!!.cacheSize)

        Assert.assertEquals(FileUtils.getDirLength(file2), mCacheUtils2!!.cacheSize)
    }

    @Test
    @Throws(Exception::class)
    fun getCacheCount() {
        Assert.assertEquals(8, mCacheUtils1!!.cacheCount.toLong())

        Assert.assertEquals(8, mCacheUtils2!!.cacheCount.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun remove() {
        Assert.assertNotNull(mCacheUtils1!!.getString("string1"))
        mCacheUtils1!!.remove("string1")
        Assert.assertNull(mCacheUtils1!!.getString("string1"))

        Assert.assertNotNull(mCacheUtils2!!.getString("string2"))
        mCacheUtils2!!.remove("string2")
        Assert.assertNull(mCacheUtils2!!.getString("string2"))
    }

    @Test
    @Throws(Exception::class)
    fun clear() {
        Assert.assertNotNull(mCacheUtils1!!.getBytes("bytes1"))
        Assert.assertNotNull(mCacheUtils1!!.getString("string1"))
        Assert.assertNotNull(mCacheUtils1!!.getJSONObject("jsonObject1"))
        Assert.assertNotNull(mCacheUtils1!!.getJSONArray("jsonArray1"))
        Assert.assertNotNull(mCacheUtils1!!.getString("bitmap1"))
        Assert.assertNotNull(mCacheUtils1!!.getString("drawable1"))
        Assert.assertNotNull(mCacheUtils1!!.getParcelable("parcelable1", ParcelableTest.CREATOR))
        Assert.assertNotNull(mCacheUtils1!!.getSerializable("serializable1"))
        mCacheUtils1!!.clear()
        Assert.assertNull(mCacheUtils1!!.getBytes("bytes1"))
        Assert.assertNull(mCacheUtils1!!.getString("string1"))
        Assert.assertNull(mCacheUtils1!!.getJSONObject("jsonObject1"))
        Assert.assertNull(mCacheUtils1!!.getJSONArray("jsonArray1"))
        Assert.assertNull(mCacheUtils1!!.getString("bitmap1"))
        Assert.assertNull(mCacheUtils1!!.getString("drawable1"))
        Assert.assertNull(mCacheUtils1!!.getParcelable("parcelable1", ParcelableTest.CREATOR))
        Assert.assertNull(mCacheUtils1!!.getSerializable("serializable1"))


        Assert.assertNotNull(mCacheUtils2!!.getBytes("bytes2"))
        Assert.assertNotNull(mCacheUtils2!!.getString("string2"))
        Assert.assertNotNull(mCacheUtils2!!.getJSONObject("jsonObject2"))
        Assert.assertNotNull(mCacheUtils2!!.getJSONArray("jsonArray2"))
        Assert.assertNotNull(mCacheUtils2!!.getString("bitmap2"))
        Assert.assertNotNull(mCacheUtils2!!.getString("drawable2"))
        Assert.assertNotNull(mCacheUtils2!!.getParcelable("parcelable2", ParcelableTest.CREATOR))
        Assert.assertNotNull(mCacheUtils2!!.getSerializable("serializable2"))
        mCacheUtils2!!.clear()
        Assert.assertNull(mCacheUtils2!!.getBytes("bytes2"))
        Assert.assertNull(mCacheUtils2!!.getString("string2"))
        Assert.assertNull(mCacheUtils2!!.getJSONObject("jsonObject2"))
        Assert.assertNull(mCacheUtils2!!.getJSONArray("jsonArray2"))
        Assert.assertNull(mCacheUtils2!!.getString("bitmap2"))
        Assert.assertNull(mCacheUtils2!!.getString("drawable2"))
        Assert.assertNull(mCacheUtils2!!.getParcelable("parcelable2", ParcelableTest.CREATOR))
        Assert.assertNull(mCacheUtils2!!.getSerializable("serializable2"))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mCacheUtils1!!.clear()
        mCacheUtils2!!.clear()
    }


    internal class ParcelableTest : Parcelable {
        var author: String
        var className: String

        constructor(author: String, className: String) {
            this.author = author
            this.className = className
        }

        constructor(`in`: Parcel) {
            author = `in`.readString()
            className = `in`.readString()
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(author)
            dest.writeString(className)
        }

        override fun describeContents(): Int {
            return 0
        }

        override fun equals(obj: Any?): Boolean {
            return obj is ParcelableTest && obj.author == author && obj.className == className
        }

        override fun hashCode(): Int {
            var result = author.hashCode()
            result = 31 * result + className.hashCode()
            return result
        }

        companion object {

            val CREATOR: Parcelable.Creator<ParcelableTest> = object : Parcelable.Creator<ParcelableTest> {
                override fun createFromParcel(`in`: Parcel): ParcelableTest {
                    return ParcelableTest(`in`)
                }

                override fun newArray(size: Int): Array<ParcelableTest?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }

    internal class SerializableTest(var author: String, var className: String) : Serializable {

        override fun equals(obj: Any?): Boolean {
            return obj is SerializableTest && obj.author == author && obj.className == className
        }

        override fun hashCode(): Int {
            var result = author.hashCode()
            result = 31 * result + className.hashCode()
            return result
        }

        companion object {

            private const val serialVersionUID = -5806706668736895024L
        }
    }

    companion object {

        init {
            TestUtils.init()
        }

        private val map: LinkedHashMap<String, String>? = null
    }
}

