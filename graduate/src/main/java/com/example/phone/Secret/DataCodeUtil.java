package com.example.phone.Secret;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Random;


@Component
public class DataCodeUtil {

	public static String dataEncode(String rowData) {
		try {
			byte[] dataByte = rowData.getBytes();
			byte[] tempData = Mima.compressForGzip(dataByte);

			byte[] tempDataByte = new byte[tempData.length + 2];
			Random ran = new Random();
			tempDataByte[0] = (byte) ran.nextInt(250);
			tempDataByte[1] = (byte) (tempDataByte[0] ^ 0x07);  // 0x0B
			for (int i = 0; i < tempData.length; i++) {
				tempDataByte[i + 2] = (byte) (tempDataByte[0] ^ 57 ^ tempData[i]);  // 118
			}

			// GZip压缩数据然后在base64加密
			BASE64Encoder encoder = new BASE64Encoder();

			String base64Data = encoder.encode(tempDataByte);//Base64(new String(tempDataByte));//Base64.encodeToString(tempDataByte, Base64.DEFAULT);
			return base64Data.replace("+", "%2B");
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}

	/**
	 * 数据解密
	 */
	public static String dataDeCode(String zipData) {
		try {
			if (zipData == null || zipData.equals("")) {
				return "";
			}

			// base64 解密
			zipData = zipData.replace("%2B", "+");

			byte[] dataByte = Base64.decode(zipData);// Base64.decode(zipData, Base64.DEFAULT);
			// 异或 数据

			// Gzip 解压数据
			byte[] gzipData = Mima.decompressForGzip(DecryptRadom(dataByte, 57));
			return new String(gzipData);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static byte[] DecryptRadom(byte[] Data, int key) {
		byte[] randomData = new byte[Data.length - 2];
		byte radom = 0;
		byte Validation = 0;
		for (int i = 0; i < Data.length; i++) {
			if (i == 0) {
				radom = Data[i];
			} else if (i == 1) {
				Validation = (byte) (radom ^ Data[i]);

			} else {
				randomData[i - 2] = (byte) (Data[i] ^ key ^ radom);
			}
		}

		return randomData;
	}
	// 加密
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}



}
