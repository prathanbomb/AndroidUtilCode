package com.prathanbomb.utilcode.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.prathanbomb.framework.util.ConvertUtils.hexString2Bytes;
import static com.prathanbomb.framework.util.EncodeUtils.base64Encode;
import static com.prathanbomb.framework.util.EncryptUtils.decrypt3DES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptAES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptBase64AES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptBase64DES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptBase64_3DES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptDES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptHexString3DES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptHexStringAES;
import static com.prathanbomb.framework.util.EncryptUtils.decryptHexStringDES;
import static com.prathanbomb.framework.util.EncryptUtils.encrypt3DES;
import static com.prathanbomb.framework.util.EncryptUtils.encrypt3DES2Base64;
import static com.prathanbomb.framework.util.EncryptUtils.encrypt3DES2HexString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptAES;
import static com.prathanbomb.framework.util.EncryptUtils.encryptAES2Base64;
import static com.prathanbomb.framework.util.EncryptUtils.encryptAES2HexString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptDES;
import static com.prathanbomb.framework.util.EncryptUtils.encryptDES2Base64;
import static com.prathanbomb.framework.util.EncryptUtils.encryptDES2HexString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacMD5;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacMD5ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA1;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA1ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA224;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA224ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA256;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA256ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA384;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA384ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA512;
import static com.prathanbomb.framework.util.EncryptUtils.encryptHmacSHA512ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptMD2;
import static com.prathanbomb.framework.util.EncryptUtils.encryptMD2ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptMD5;
import static com.prathanbomb.framework.util.EncryptUtils.encryptMD5ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA1;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA1ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA224;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA224ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA256;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA256ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA384;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA384ToString;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA512;
import static com.prathanbomb.framework.util.EncryptUtils.encryptSHA512ToString;
import static com.google.common.truth.Truth.assertThat;

/**
 * <pre>
 *     author: prathanbomb
 *     blog  : http://prathanbomb.com
 *     time  : 2016/08/06
 *     desc  : EncryptUtils单元测试
 * </pre>
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 23)
public class EncryptUtilsTest {

    private String prathanbombMD2    = "15435017570D8A73449E25C4622E17A4";
    private String prathanbombMD5    = "AAC25CD336E01C8655F4EC7875445A60";
    private String prathanbombSHA1   = "C606ACCB1FEB669E19D080ADDDDBB8E6CDA5F43C";
    private String prathanbombSHA224 = "F4C5C0E8CF56CAC4D06DB6B523F67621859A9D79BDA4B2AC03097D5F";
    private String prathanbombSHA256 = "8BD80AE90DFBA112786367BEBDDEE60A638EF5B82682EDF8F3D3CA8E6BFEF648";
    private String prathanbombSHA384 =
            "BF831E5221FC108D6A72ACB888BA3EB0C030A5F01BA2F739856BE70681D86F992B85E0D461101C74BAEDA895BD422557";
    private String prathanbombSHA512 =
            "D59D31067F614ED3586F85A31FEFDB7F33096316DA26EBE0FF440B241C8560D96650F100D78C512560C976949EFA89CB5D5589DCF68C7FAADE98F03BCFEC2B45";

    @Test
    public void testEncryptMD2() throws Exception {
        assertThat(encryptMD2ToString("prathanbomb")).isEqualTo(prathanbombMD2);
        assertThat(encryptMD2ToString("prathanbomb".getBytes())).isEqualTo(prathanbombMD2);
        assertThat(encryptMD2("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombMD2));
    }

    @Test
    public void testEncryptMD5() throws Exception {
        assertThat(encryptMD5ToString("prathanbomb")).isEqualTo(prathanbombMD5);
        assertThat(encryptMD5ToString("prathanbomb".getBytes())).isEqualTo(prathanbombMD5);
        assertThat(encryptMD5("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombMD5));
    }

    @Test
    public void testEncryptSHA1() throws Exception {
        assertThat(encryptSHA1ToString("prathanbomb")).isEqualTo(prathanbombSHA1);
        assertThat(encryptSHA1ToString("prathanbomb".getBytes())).isEqualTo(prathanbombSHA1);
        assertThat(encryptSHA1("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombSHA1));
    }

    @Test
    public void testEncryptSHA224() throws Exception {
        assertThat(encryptSHA224ToString("prathanbomb")).isEqualTo(prathanbombSHA224);
        assertThat(encryptSHA224ToString("prathanbomb".getBytes())).isEqualTo(prathanbombSHA224);
        assertThat(encryptSHA224("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombSHA224));
    }

    @Test
    public void testEncryptSHA256() throws Exception {
        assertThat(encryptSHA256ToString("prathanbomb")).isEqualTo(prathanbombSHA256);
        assertThat(encryptSHA256ToString("prathanbomb".getBytes())).isEqualTo(prathanbombSHA256);
        assertThat(encryptSHA256("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombSHA256));
    }

    @Test
    public void testEncryptSHA384() throws Exception {
        assertThat(encryptSHA384ToString("prathanbomb")).isEqualTo(prathanbombSHA384);
        assertThat(encryptSHA384ToString("prathanbomb".getBytes())).isEqualTo(prathanbombSHA384);
        assertThat(encryptSHA384("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombSHA384));
    }

    @Test
    public void testEncryptSHA512() throws Exception {
        assertThat(encryptSHA512ToString("prathanbomb")).isEqualTo(prathanbombSHA512);
        assertThat(encryptSHA512ToString("prathanbomb".getBytes())).isEqualTo(prathanbombSHA512);
        assertThat(encryptSHA512("prathanbomb".getBytes())).isEqualTo(hexString2Bytes(prathanbombSHA512));
    }

    //use this site to test https://www.freeformatter.com/hmac-generator.html
    private String prathanbombHmacMD5    = "2BA3FDABEE222522044BEC0CE5D6B490";
    private String prathanbombHmacSHA1   = "88E83EFD915496860C83739BE2CF4752B2AC105F";
    private String prathanbombHmacSHA224 = "E392D83D1030323FB2E062E8165A3AD38366E53DF19EA3290961E153";
    private String prathanbombHmacSHA256 = "A59675F13FC9A6E06D8DC90D4DC01DB9C991B0B95749D2471E588BF311DA2C67";
    private String prathanbombHmacSHA384 =
            "9FC2F49C7EDE698EA59645B3BEFBBE67DCC7D6623E03D4D03CDA1324F7B6445BC428AB42F6A962CF79AFAD1302C3223D";
    private String prathanbombHmacSHA512 =
            "FC55AD54B95F55A8E32EA1BAD7748C157F80679F5561EC95A3EAD975316BA85363CB4AF6462D695F742F469EDC2D577272BE359A7F9E9C7018FDF4C921E1B3CF";
    private String prathanbombHmackey    = "prathanbomb";

    @Test
    public void testEncryptHmacMD5() throws Exception {
        assertThat(encryptHmacMD5ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacMD5);
        assertThat(encryptHmacMD5ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacMD5);
        assertThat(encryptHmacMD5("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacMD5));
    }

    @Test
    public void testEncryptHmacSHA1() throws Exception {
        assertThat(encryptHmacSHA1ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA1);
        assertThat(encryptHmacSHA1ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacSHA1);
        assertThat(encryptHmacSHA1("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacSHA1));
    }

    @Test
    public void testEncryptHmacSHA224() throws Exception {
        assertThat(encryptHmacSHA224ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA224);
        assertThat(encryptHmacSHA224ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacSHA224);
        assertThat(encryptHmacSHA224("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacSHA224));
    }

    @Test
    public void testEncryptHmacSHA256() throws Exception {
        assertThat(encryptHmacSHA256ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA256);
        assertThat(encryptHmacSHA256ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacSHA256);
        assertThat(encryptHmacSHA256("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacSHA256));
    }

    @Test
    public void testEncryptHmacSHA384() throws Exception {
        assertThat(encryptHmacSHA384ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA384);
        assertThat(encryptHmacSHA384ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacSHA384);
        assertThat(encryptHmacSHA384("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacSHA384));
    }

    @Test
    public void testEncryptHmacSHA512() throws Exception {
        assertThat(encryptHmacSHA512ToString("prathanbomb", prathanbombHmackey)).isEqualTo(prathanbombHmacSHA512);
        assertThat(encryptHmacSHA512ToString("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(prathanbombHmacSHA512);
        assertThat(encryptHmacSHA512("prathanbomb".getBytes(), prathanbombHmackey.getBytes())).isEqualTo(hexString2Bytes(prathanbombHmacSHA512));
    }


    private String dataDES      = "0008DB3345AB0223";
    private String keyDES       = "6801020304050607";
    private String resDES       = "1F7962581118F360";
    private byte[] bytesDataDES = hexString2Bytes(dataDES);
    private byte[] bytesKeyDES  = hexString2Bytes(keyDES);
    private byte[] bytesResDES  = hexString2Bytes(resDES);

    @Test
    public void testEncryptDES() throws Exception {
        assertThat(encryptDES(bytesDataDES, bytesKeyDES)).isEqualTo(bytesResDES);
        assertThat(encryptDES2HexString(bytesDataDES, bytesKeyDES)).isEqualTo(resDES);
        assertThat(encryptDES2Base64(bytesDataDES, bytesKeyDES)).isEqualTo(base64Encode
                (bytesResDES));
    }

    @Test
    public void testDecryptDES() throws Exception {
        assertThat(decryptDES(bytesResDES, bytesKeyDES)).isEqualTo(bytesDataDES);
        assertThat(decryptHexStringDES(resDES, bytesKeyDES)).isEqualTo(bytesDataDES);
        assertThat(decryptBase64DES(base64Encode(bytesResDES), bytesKeyDES)).isEqualTo
                (bytesDataDES);
    }

    String data3DES      = "1111111111111111";
    String key3DES       = "111111111111111111111111111111111111111111111111";
    String res3DES       = "F40379AB9E0EC533";
    byte[] bytesDataDES3 = hexString2Bytes(data3DES);
    byte[] bytesKeyDES3  = hexString2Bytes(key3DES);
    byte[] bytesResDES3  = hexString2Bytes(res3DES);

    @Test
    public void testEncrypt3DES() throws Exception {
        assertThat(encrypt3DES(bytesDataDES3, bytesKeyDES3)).isEqualTo(bytesResDES3);
        assertThat(encrypt3DES2HexString(bytesDataDES3, bytesKeyDES3)).isEqualTo(res3DES);
        assertThat(encrypt3DES2Base64(bytesDataDES3, bytesKeyDES3)).isEqualTo(base64Encode
                (bytesResDES3));
    }

    @Test
    public void testDecrypt3DES() throws Exception {
        assertThat(decrypt3DES(bytesResDES3, bytesKeyDES3)).isEqualTo(bytesDataDES3);
        assertThat(decryptHexString3DES(res3DES, bytesKeyDES3)).isEqualTo(bytesDataDES3);
        assertThat(decryptBase64_3DES(base64Encode(bytesResDES3), bytesKeyDES3)).isEqualTo
                (bytesDataDES3);
    }

    private String dataAES      = "11111111111111111111111111111111";
    private String keyAES       = "11111111111111111111111111111111";
    private String resAES       = "E56E26F5608B8D268F2556E198A0E01B";
    private byte[] bytesDataAES = hexString2Bytes(dataAES);
    private byte[] bytesKeyAES  = hexString2Bytes(keyAES);
    private byte[] bytesResAES  = hexString2Bytes(resAES);

    @Test
    public void testEncryptAES() throws Exception {
        assertThat(encryptAES(bytesDataAES, bytesKeyAES)).isEqualTo(bytesResAES);
        assertThat(encryptAES2HexString(bytesDataAES, bytesKeyAES)).isEqualTo(resAES);
        assertThat(encryptAES2Base64(bytesDataAES, bytesKeyAES)).isEqualTo(base64Encode
                (bytesResAES));
    }

    @Test
    public void testDecryptAES() throws Exception {
        assertThat(decryptAES(bytesResAES, bytesKeyAES)).isEqualTo(bytesDataAES);
        assertThat(decryptHexStringAES(resAES, bytesKeyAES)).isEqualTo(bytesDataAES);
        assertThat(decryptBase64AES(base64Encode(bytesResAES), bytesKeyAES)).isEqualTo
                (bytesDataAES);
    }

    String path = TestUtils.TEST_PATH + "encrypt" + TestUtils.FILE_SEP;
    String md5  = "7F138A09169B250E9DCB378140907378";

    @Test
    public void testEncryptMD5File() throws Exception {
//        assertThat(encryptMD5File2String(new File(path + "MD5.txt"))).isEqualTo(md5);
    }
}