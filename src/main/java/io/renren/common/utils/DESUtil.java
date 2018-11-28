/*
 * <p>Copyright Foresee Science & Technology Co.</p>
 * @author <a href="mailto:chenqiang@foresee.com.cn">chenqiang</a>
 * $Id: DESUtil.java 4336 2009-07-19 03:21:39Z chenqiang@foresee.com.cn $
 */
package io.renren.common.utils;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.codec.Base64;

/**
 * <p>
 * 数据加密工具类。
 * </p>
 * 
 * @author <a href="mailto:chenqiang@foresee.com.cn">chenqiang</a>
 * @version $LastChangedRevision: 4336 $
 */
public class DESUtil {

	private static final Log log = LogFactory.getLog(DESUtil.class);

	private static byte[] encryptOrDecrypt(boolean encrypt, byte[] desKey,
			byte[] data) {
		if (data == null || data.length <= 0) {
			return null;
		}

		try {
			Cipher cipher;
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(desKey);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(dks);
			if (encrypt) {
				cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			} else {
				cipher = Cipher.getInstance("DES/ECB/NoPadding");
				// cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				cipher.init(Cipher.DECRYPT_MODE, key, sr);
			}

			return cipher.doFinal(data);
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
	}

	/**
	 * 返回加密后的数据。
	 * 
	 * @param data
	 *            数据
	 * @param desKey
	 *            数据加密key
	 * @return 加密后的数据
	 * @throws Exception
	 *             数据加密异常
	 */
	public static char[] encrypt(byte[] data, byte[] desKey) throws Exception {
		// return Base64.encode(encryptOrDecrypt(true, desKey, data));
		return new char[0];
	}

	/**
	 * 返回解密后的数据。
	 * 
	 * @param data
	 *            数据
	 * @param desKey
	 *            数据解密key
	 * @return 解密后的数据
	 * @throws Exception
	 *             数据解密异常
	 */
	public static byte[] decrypt(char[] data, byte[] desKey) throws Exception {
		// TODO:luoshifei data.toString
		return encryptOrDecrypt(
				false,
				desKey,
				Base64.decode(Arrays.toString(data).getBytes(
						"UTF-8")));
	}

	/**
	 * 返回加密后的数据。
	 * 
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @return 加密后的数据
	 * @throws Exception
	 *             数据加密异常
	 */
	public static String encrypt(String data, String key) throws Exception {
		return new String(Base64.encode(encryptOrDecrypt(true,
				key.getBytes("UTF-8"),
				data.getBytes("UTF-8"))),
				"UTF-8");
	}


	/**
	 * 返回解密后的数据。
	 * 
	 * @param data  数据
	 * @param key 密钥
	 * @return 解密后的数据
	 * @throws Exception
	 *             数据解密异常
	 */
	public static String decrypt(String data, String key) throws Exception {
		return new String(encryptOrDecrypt(false,
				key.getBytes("UTF-8"),
				Base64.decode(data.getBytes("UTF-8"))),
				"UTF-8").trim();
	}

	/**
	 * 返回加密数据压缩包。
	 * 
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @param zip
	 *            是否压缩
	 * @return 加密数据压缩包
	 * @throws Exception
	 *             加密数据压缩异常
	 */
	public static String encrypt(String data, byte[] key, boolean zip)
			throws Exception {
		if (data == null) {
			return null;
		}

		byte[] bytes;
		if (zip) {
			bytes = ZIPUtil.compress(data.getBytes("UTF-8"));
		} else {
			bytes = data.getBytes("UTF-8");
		}

		return new String(Base64.encode(encryptOrDecrypt(true, key, bytes)),
				"UTF-8");
	}

	/**
	 * 返回解密数据压缩包。
	 * 
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @param zip
	 *            是否压缩
	 * @return 解密数据压缩包
	 * @throws Exception
	 *             解密数据压缩异常
	 */
	public static String decrypt(String data, byte[] key, boolean zip)
			throws Exception {
		if (data == null) {
			return null;
		}

		byte[] bytes = encryptOrDecrypt(false, key,
				Base64.decode(data.getBytes("UTF-8")));
		if (zip) {
			bytes = ZIPUtil.decompress(bytes);
		}

		return new String(bytes, "UTF-8").trim();
	}

	/**
	 * 返回解密数据压缩包。
	 * 
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @param zip
	 *            是否压缩
	 * @return 解密数据压缩包
	 * @throws Exception
	 *             解密数据压缩异常
	 */
	public static String decrypt(String data, String key, boolean zip)
			throws Exception {
		return decrypt(data, key.getBytes("UTF-8"), zip);
	}

	/**
	 * 加密数据压缩包。
	 * 
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @param zip
	 *            是否解密
	 * @return 加密数据压缩包
	 * @throws Exception
	 *             加密数据压缩异常
	 */
	public static String encrypt(String data, String key, boolean zip)
			throws Exception {
		return encrypt(data, key.getBytes("UTF-8"), zip);
	}

}
