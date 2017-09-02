package com.prathanbomb.framework.util

import org.junit.Test

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2017/05/24
 * desc  :
</pre> *
 */
class FileIOUtilsTest {

    internal var path = TestUtils.TEST_PATH + TestUtils.FILE_SEP + "file" + TestUtils.FILE_SEP
    internal var path1 = TestUtils.TEST_PATH + TestUtils.FILE_SEP + "file1" + TestUtils.FILE_SEP

    @Test
    @Throws(Exception::class)
    fun writeFileFromIS() {
        //        assertTrue(FileIOUtils.writeFileFromIS(path + "NEW.txt", new FileInputStream(path + "UTF8.txt"), false));
        //        assertTrue(FileIOUtils.writeFileFromIS(path + "NEW.txt", new FileInputStream(path + "UTF8.txt"), true));
    }

    @Test
    @Throws(Exception::class)
    fun writeFileFromBytes() {
        //        String p = path + "test.txt";
        //        String p1 = path + "copy.zip";
        //        byte[] data = new byte[(1 << 20) * 100];
        //        long st, end;
        //        FileUtils.deleteFile(p);
        //
        //        st = System.currentTimeMillis();
        //        for (int i = 0; i < 100; i++) {
        //            FileIOUtils.writeFileFromBytesByStream(p, data, true);
        //        }
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
        //        FileUtils.deleteFile(p);
        //
        //        st = System.currentTimeMillis();
        //        for (int i = 0; i < 100; i++) {
        //            FileIOUtils.writeFileFromBytesByChannel(p, data, true);
        //        }
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
        //        FileUtils.deleteFile(p);
        //
        //        st = System.currentTimeMillis();
        //        for (int i = 0; i < 100; i++) {
        //            FileIOUtils.writeFileFromBytesByMap(p, data, true, false);
        //        }
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
        //        FileUtils.deleteFile(p);
    }

    @Test
    @Throws(Exception::class)
    fun writeFileFromString() {

    }

    @Test
    @Throws(Exception::class)
    fun readFile2List() {

    }

    @Test
    @Throws(Exception::class)
    fun readFile2String() {

    }

    @Test
    @Throws(Exception::class)
    fun readFile2Bytes() {
        //        String p = path + "test.app.zip";
        //        long st, end;
        //        st = System.currentTimeMillis();
        //        FileIOUtils.readFile2BytesByStream(p);
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
        //        st = System.currentTimeMillis();
        //        FileIOUtils.readFile2BytesByChannel(p);
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
        //        st = System.currentTimeMillis();
        //        FileIOUtils.readFile2BytesByMap(p);
        //        end = System.currentTimeMillis();
        //        System.out.println(end - st);
    }

}