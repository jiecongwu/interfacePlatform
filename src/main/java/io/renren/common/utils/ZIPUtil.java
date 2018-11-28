/*
 * <p>Copyright Foresee Science & Technology Co.</p>
 * @author <a href="mailto:chenqiang@foresee.com.cn">chenqiang</a>
 * $Id: ZIPUtil.java 4336 2009-07-19 03:21:39Z chenqiang@foresee.com.cn $
 */
package io.renren.common.utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.springframework.security.crypto.codec.Base64;

/**
 * <p>
 * ZIPѹ�����ѹ�����。
 * </p>
 * 
 * @author <a href="mailto:chenqiang@foresee.com.cn">chenqiang</a>
 * @version $LastChangedRevision: 4336 $
 */
public class ZIPUtil {
	private static final int BUFFER_SIZE = 2048;

	/**
	 * ��ѹ��BASE64֮���ѹ�����。
	 * 
	 * @param encdata
	 *            BASE64֮���ѹ�����
	 * @param codebyB64
	 *            是否使用base64加密
	 * @return ��ѹ��֮������
	 * @throws IOException
	 *             IO�쳣
	 */
	public static String decompress(String encdata, boolean codebyB64)
			throws IOException {
		if (encdata == null) {
			return null;
		}
		if (codebyB64) {
			return new String(decompress(Base64.decode(encdata.getBytes(Charset
					.defaultCharset()))), Charset.defaultCharset());
		} else {
			return new String(decompress(encdata.getBytes(Charset
					.defaultCharset())), Charset.defaultCharset());
		}
	}

	/**
	 * ѹ���ַ����。
	 * 
	 * @param data
	 *            �ַ����
	 * @param codebyB64
	 *            是否使用base64加密
	 * @return ѹ��֮�����ݵ�BASE64�����ַ�
	 * @throws IOException
	 *             IO�쳣
	 */
	public static String compress(String data, boolean codebyB64)
			throws IOException {
		if (data == null) {
			return null;
		}
		if (codebyB64) {
			return new String(Base64.encode(compress(data.getBytes(Charset
					.defaultCharset()))), Charset.defaultCharset());
		} else {
			return new String(
					compress(data.getBytes(Charset.defaultCharset())),
					Charset.defaultCharset());
		}
	}

	/**
	 * ѹ���ֽ�������ʽ�����。
	 * 
	 * @param data
	 *            �ֽ�������ʽ�����
	 * @return ѹ��֮����ֽ�����
	 * @throws IOException
	 *             IO�쳣
	 */
	public static byte[] compress(byte[] data) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = null;
		DeflaterOutputStream deflaterOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			deflaterOutputStream = new DeflaterOutputStream(
					byteArrayOutputStream);
			deflaterOutputStream.write(data);
			deflaterOutputStream.close();
			return byteArrayOutputStream.toByteArray();
		} finally {
			if (deflaterOutputStream != null) {
				deflaterOutputStream.close();
			}
			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
		}
	}

	/**
	 * ��ѹ���ֽ�������ʽ�����。
	 * 
	 * @param encdata
	 *            �ֽ�������ʽ�����
	 * @return ��ѹ��֮����ֽ�����
	 * @throws IOException
	 *             IO�쳣
	 */
	public static byte[] decompress(byte[] encdata) throws IOException {
		if (encdata == null) {
			return null;
		}

		InputStream inputStream = null;
		InflaterInputStream inflaterInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			inputStream = new ByteArrayInputStream(encdata);
			inflaterInputStream = new InflaterInputStream(inputStream);
			byteArrayOutputStream = new ByteArrayOutputStream();

			int count;
			byte[] data = new byte[BUFFER_SIZE];
			while ((count = inflaterInputStream.read(data, 0, BUFFER_SIZE)) != -1) {
				byteArrayOutputStream.write(data, 0, count);
			}

			return byteArrayOutputStream.toByteArray();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (inflaterInputStream != null) {
				inflaterInputStream.close();
			}
			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
		}
	}
}
