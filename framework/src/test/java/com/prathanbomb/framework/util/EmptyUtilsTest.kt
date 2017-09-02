package com.prathanbomb.framework.util

import android.annotation.TargetApi
import android.os.Build
import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import android.util.SparseLongArray
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.*

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/09/28
 * desc  : EmptyUtils单元测试
</pre> *
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = intArrayOf(23))
class EmptyUtilsTest {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Test
    @Throws(Exception::class)
    fun isEmpty() {
        val string = ""
        val string1 = " "
        val arr = arrayOf<IntArray>()
        val arr1: IntArray? = null
        val list = LinkedList<Int>()
        val map = HashMap<String, Int>()
        val sa = SparseArray<String>()
        val sba = SparseBooleanArray()
        val sia = SparseIntArray()
        val sla = SparseLongArray()

        assertThat(EmptyUtils.isEmpty(string)).isTrue()
        assertThat(EmptyUtils.isEmpty(string1)).isFalse()
        assertThat(EmptyUtils.isEmpty(arr)).isTrue()
        assertThat(EmptyUtils.isEmpty(arr1)).isTrue()
        assertThat(EmptyUtils.isEmpty(list)).isTrue()
        assertThat(EmptyUtils.isEmpty(map)).isTrue()
        assertThat(EmptyUtils.isEmpty(sa)).isTrue()
        assertThat(EmptyUtils.isEmpty(sba)).isTrue()
        assertThat(EmptyUtils.isEmpty(sia)).isTrue()
        assertThat(EmptyUtils.isEmpty(sla)).isTrue()

        assertThat(!EmptyUtils.isNotEmpty(string)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(string1)).isFalse()
        assertThat(!EmptyUtils.isNotEmpty(arr)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(arr1)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(list)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(map)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(sa)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(sba)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(sia)).isTrue()
        assertThat(!EmptyUtils.isNotEmpty(sla)).isTrue()
    }
}