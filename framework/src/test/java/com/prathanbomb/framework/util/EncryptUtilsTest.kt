package com.prathanbomb.framework.util

import com.google.common.truth.Truth.assertThat
import com.prathanbomb.framework.util.EncodeUtils.base64Encode
import com.prathanbomb.framework.util.EncryptUtils.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * <pre>
 * author: prathanbomb
 * blog  : http://prathanbomb.com
 * time  : 2016/08/06
 * desc  : EncryptUtils单元测试
</pre> *
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = intArrayOf(23))
class EncryptUtilsTest {

    private val prathanbombMD2 = "15435017570D8A73449E25C4622E17A4"
    private val prathanbombMD5 = "AAC25CD336E01C8655F4EC7875445A60"
    private val prathanbombSHA1 = "C606ACCB1FEB669E19D080ADDDDBB8E6CDA5F43C"
    private val prathanbombSHA224 = "F4C5C0E8CF56CAC4D06DB6B523F67621859A9D79BDA4B2AC03097D5F"
    private val prathanbombSHA256 = "8BD80AE90DFBA112786367BEBDDEE60A638EF5B82682EDF8F3D3CA8E6BFEF648"
    private val prathanbombSHA384 = "BF831E5221FC108D6A72ACB888BA3EB0C030A5F01BA2F739856BE70681D86F992B85E0D461101C74BAEDA895BD422557"
    private val prathanbombSHA512 = "D59D31067F614ED3586F85A31FEFDB7F33096316DA26EBE0FF440B241C8560D96650F100D78C512560C976949EFA89CB5D5589DCF68C7FAADE98F03BCFEC2B45"

    @Test
    @Throws(Exception::class)
    fun testEncryptMD2() {
        assertThat(encryptMD2ToString("prathanbomb")).isEqualTo(prathanbombMD2)
        assertThat(encryptMD2ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombMD2)
        assertThat(encryptMD2("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombMD2))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptMD5() {
        assertThat(encryptMD5ToString("prathanbomb")).isEqualTo(prathanbombMD5)
        assertThat(encryptMD5ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombMD5)
        assertThat(encryptMD5("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombMD5))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptSHA1() {
        assertThat(encryptSHA1ToString("prathanbomb")).isEqualTo(prathanbombSHA1)
        assertThat(encryptSHA1ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombSHA1)
        assertThat(encryptSHA1("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombSHA1))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptSHA224() {
        assertThat(encryptSHA224ToString("prathanbomb")).isEqualTo(prathanbombSHA224)
        assertThat(encryptSHA224ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombSHA224)
        assertThat(encryptSHA224("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombSHA224))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptSHA256() {
        assertThat(encryptSHA256ToString("prathanbomb")).isEqualTo(prathanbombSHA256)
        assertThat(encryptSHA256ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombSHA256)
        assertThat(encryptSHA256("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombSHA256))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptSHA384() {
        assertThat(encryptSHA384ToString("prathanbomb")).isEqualTo(prathanbombSHA384)
        assertThat(encryptSHA384ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombSHA384)
        assertThat(encryptSHA384("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombSHA384))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptSHA512() {
        assertThat(encryptSHA512ToString("prathanbomb")).isEqualTo(prathanbombSHA512)
        assertThat(encryptSHA512ToString("prathanbomb".toByteArray())).isEqualTo(prathanbombSHA512)
        assertThat(encryptSHA512("prathanbomb".toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombSHA512))
    }

    //use this site to test https://www.freeformatter.com/hmac-generator.html
    private val prathanbombHmacMD5 = "2BA3FDABEE222522044BEC0CE5D6B490"
    private val prathanbombHmacSHA1 = "88E83EFD915496860C83739BE2CF4752B2AC105F"
    private val prathanbombHmacSHA224 = "E392D83D1030323FB2E062E8165A3AD38366E53DF19EA3290961E153"
    private val prathanbombHmacSHA256 = "A59675F13FC9A6E06D8DC90D4DC01DB9C991B0B95749D2471E588BF311DA2C67"
    private val prathanbombHmacSHA384 = "9FC2F49C7EDE698EA59645B3BEFBBE67DCC7D6623E03D4D03CDA1324F7B6445BC428AB42F6A962CF79AFAD1302C3223D"
    private val prathanbombHmacSHA512 = "FC55AD54B95F55A8E32EA1BAD7748C157F80679F5561EC95A3EAD975316BA85363CB4AF6462D695F742F469EDC2D577272BE359A7F9E9C7018FDF4C921E1B3CF"
    private val prathanbombHmackey = "prathanbomb"

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacMD5() {
        assertThat(encryptHmacMD5ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacMD5)
        assertThat(encryptHmacMD5ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacMD5)
        assertThat(encryptHmacMD5("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacMD5))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacSHA1() {
        assertThat(encryptHmacSHA1ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA1)
        assertThat(encryptHmacSHA1ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacSHA1)
        assertThat(encryptHmacSHA1("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacSHA1))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacSHA224() {
        assertThat(encryptHmacSHA224ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA224)
        assertThat(encryptHmacSHA224ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacSHA224)
        assertThat(encryptHmacSHA224("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacSHA224))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacSHA256() {
        assertThat(encryptHmacSHA256ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA256)
        assertThat(encryptHmacSHA256ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacSHA256)
        assertThat(encryptHmacSHA256("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacSHA256))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacSHA384() {
        assertThat(encryptHmacSHA384ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA384)
        assertThat(encryptHmacSHA384ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacSHA384)
        assertThat(encryptHmacSHA384("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacSHA384))
    }

    @Test
    @Throws(Exception::class)
    fun testEncryptHmacSHA512() {
        assertThat(encryptHmacSHA512ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA512)
        assertThat(encryptHmacSHA512ToString("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(prathanbombHmacSHA512)
        assertThat(encryptHmacSHA512("prathanbomb".toByteArray(), prathanbombHmackey.toByteArray())).isEqualTo(ConvertUtils.hexString2Bytes(prathanbombHmacSHA512))
    }


    private val dataDES = "0008DB3345AB0223"
    private val keyDES = "6801020304050607"
    private val resDES = "1F7962581118F360"
    private val bytesDataDES = ConvertUtils.hexString2Bytes(dataDES)
    private val bytesKeyDES = ConvertUtils.hexString2Bytes(keyDES)
    private val bytesResDES = ConvertUtils.hexString2Bytes(resDES)

    @Test
    @Throws(Exception::class)
    fun testEncryptDES() {
        assertThat(encryptDES(bytesDataDES, bytesKeyDES)).isEqualTo(bytesResDES)
        assertThat(encryptDES2HexString(bytesDataDES, bytesKeyDES)).isEqualTo(resDES)
        assertThat(encryptDES2Base64(bytesDataDES, bytesKeyDES)).isEqualTo(base64Encode(bytesResDES))
    }

    @Test
    @Throws(Exception::class)
    fun testDecryptDES() {
        assertThat(decryptDES(bytesResDES, bytesKeyDES)).isEqualTo(bytesDataDES)
        assertThat(decryptHexStringDES(resDES, bytesKeyDES)).isEqualTo(bytesDataDES)
        assertThat(decryptBase64DES(base64Encode(bytesResDES), bytesKeyDES)).isEqualTo(bytesDataDES)
    }

    internal var data3DES = "1111111111111111"
    internal var key3DES = "111111111111111111111111111111111111111111111111"
    internal var res3DES = "F40379AB9E0EC533"
    internal var bytesDataDES3 = ConvertUtils.hexString2Bytes(data3DES)
    internal var bytesKeyDES3 = ConvertUtils.hexString2Bytes(key3DES)
    internal var bytesResDES3 = ConvertUtils.hexString2Bytes(res3DES)

    @Test
    @Throws(Exception::class)
    fun testEncrypt3DES() {
        assertThat(encrypt3DES(bytesDataDES3, bytesKeyDES3)).isEqualTo(bytesResDES3)
        assertThat(encrypt3DES2HexString(bytesDataDES3, bytesKeyDES3)).isEqualTo(res3DES)
        assertThat(encrypt3DES2Base64(bytesDataDES3, bytesKeyDES3)).isEqualTo(base64Encode(bytesResDES3))
    }

    @Test
    @Throws(Exception::class)
    fun testDecrypt3DES() {
        assertThat(decrypt3DES(bytesResDES3, bytesKeyDES3)).isEqualTo(bytesDataDES3)
        assertThat(decryptHexString3DES(res3DES, bytesKeyDES3)).isEqualTo(bytesDataDES3)
        assertThat(decryptBase64_3DES(base64Encode(bytesResDES3), bytesKeyDES3)).isEqualTo(bytesDataDES3)
    }

    private val dataAES = "11111111111111111111111111111111"
    private val keyAES = "11111111111111111111111111111111"
    private val resAES = "E56E26F5608B8D268F2556E198A0E01B"
    private val bytesDataAES = ConvertUtils.hexString2Bytes(dataAES)
    private val bytesKeyAES = ConvertUtils.hexString2Bytes(keyAES)
    private val bytesResAES = ConvertUtils.hexString2Bytes(resAES)

    @Test
    @Throws(Exception::class)
    fun testEncryptAES() {
        assertThat(encryptAES(bytesDataAES, bytesKeyAES)).isEqualTo(bytesResAES)
        assertThat(encryptAES2HexString(bytesDataAES, bytesKeyAES)).isEqualTo(resAES)
        assertThat(encryptAES2Base64(bytesDataAES, bytesKeyAES)).isEqualTo(base64Encode(bytesResAES))
    }

    @Test
    @Throws(Exception::class)
    fun testDecryptAES() {
        assertThat(decryptAES(bytesResAES, bytesKeyAES)).isEqualTo(bytesDataAES)
        assertThat(decryptHexStringAES(resAES, bytesKeyAES)).isEqualTo(bytesDataAES)
        assertThat(decryptBase64AES(base64Encode(bytesResAES), bytesKeyAES)).isEqualTo(bytesDataAES)
    }

    internal var path = com.prathanbomb.framework.util.TestUtils.TEST_PATH + "encrypt" + com.prathanbomb.framework.util.TestUtils.FILE_SEP
    internal var md5 = "7F138A09169B250E9DCB378140907378"

    @Test
    @Throws(Exception::class)
    fun testEncryptMD5File() {
        //        assertThat(encryptMD5File2String(new File(path + "MD5.txt"))).isEqualTo(md5);
    }
}