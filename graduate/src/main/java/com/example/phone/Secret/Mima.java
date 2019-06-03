package com.example.phone.Secret;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * 瀵嗙爜宸ュ叿绫�
 * 
 * @author jiaugame2
 * 
 */
public class Mima {

	/**
	 * 鍔犲瘑
	 * 
	 * @param s
	 *            鍔犲瘑瀛楃涓�
	 * @param key
	 *            瀵嗗寵
	 * @return 鍔犲瘑鍚庣殑瀛楃涓�
	 */
	public static String jiaMi(String s, int key) {
		String str = "";
		int ch;
		if (s.equals(""))
			return "";
		if (!s.equals(null)) {
			for (int i = 0; i < s.length(); i++) {
				ch = s.codePointAt(i);
				ch = ch ^ key; // 0x87;
				str += getHexStr4(ch); // (char)ch;
			}
		}
		return str.replace("000", "*").replace("00", "$").replace("$1", "p")
				.replace("$2", "w").replace("$3", "g").replace("$4", "h")
				.replace("$5", "i").replace("$6", "j").replace("$7", "k")
				.replace("$8", "m").replace("$9", "n").replace("*7", "s");

	}

	/**
	 * 瑙ｅ瘑
	 * 
	 * @param s
	 *            鍔犲瘑鍚庣殑瀛楃涓�
	 * @param key
	 *            瀵嗗寵
	 * @return 瑙ｅ瘑鍚庣殑瀛楃涓�
	 */
	public static String jieMi(String s, int key) {
		String str = "", strChar;
		if (s.equals(""))
			return "";
		try {
			s = s.replace("m", "$8").replace("n", "$9").replace("k", "$7")
					.replace("j", "$6").replace("i", "$5").replace("h", "$4")
					.replace("g", "$3").replace("w", "$2").replace("p", "$1")
					.replace("s", "*7").replace("*", "000").replace("$", "00");
			for (int i = 0; i + 3 < s.length(); i += 4) {
				strChar = "" + s.charAt(i) + s.charAt(i + 1) + s.charAt(i + 2)
						+ s.charAt(i + 3);
				str = str + (char) (Integer.parseInt(strChar, 16) ^ key);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = "";
		}

		return str;
	}

	/**
	 * 鑾峰彇16杩涘埗瀛楃涓�
	 * 
	 * @param n
	 *            瑕佽浆鎹�16杩涘埗鐨勬暟鍊�
	 * @return 杞崲涓�16杩涘埗鍚庣殑瀛楃涓�
	 */
	private static String getHexStr4(int n) {
		String str = ("0000" + Integer.toHexString(n));
		return str.substring(str.length() - 4, str.length());
	}

	/**
	 * 鑾峰彇MD5鍔犲瘑鍚庣殑鍔犲瘑瀛楃涓�
	 * 
	 * @param s
	 *            瑕佸姞瀵嗙殑鍘熷瓧绗︿覆
	 * @return MD5鍔犲瘑鍚庣殑瀛楃涓�
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	
//	  private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
//
//	    public static String encryptDES(String encryptString, String encryptKey)
//	            throws Exception {
//
//	        IvParameterSpec zeroIv = new IvParameterSpec(iv);
//	        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
//	        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//	        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
//	        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
//
//
//
//
////	        String result = Base64.encodeToString(encryptedData, Base64.DEFAULT);   //new String(encryptedData);
//	        result = result.replace("\n", "").replace("+", "%2B");
//
//	        return result;
//	    }
	  
		
		/**
	     * Gzip 压缩数据
	     *
	     * @param unGzipStr
	     * @return
	     */
	    public static byte[] compressForGzip(byte[] unGzipdata) {

	        
	        try {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            GZIPOutputStream gzip = new GZIPOutputStream(baos);
	            gzip.write(unGzipdata);
	            gzip.close();
	            byte[] encode = baos.toByteArray();
	            baos.flush();
	            baos.close();
	            return encode;//Base64.encodeToString(encode, Base64.DEFAULT);//new String(Base64.encode(encode,encode.length));
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	    
	    /**
	     * Gzip解压数据
	     *
	     * @param gzipStr
	     * @return
	     */
	    public static byte[] decompressForGzip(byte[] dataByte) {
	        
	        try {
	            ByteArrayOutputStream out = new ByteArrayOutputStream();
	            ByteArrayInputStream in = new ByteArrayInputStream(dataByte);
	            GZIPInputStream gzip = new GZIPInputStream(in);
	            byte[] buffer = new byte[1024];
	            int n = 0;
	            while ((n = gzip.read(buffer, 0, buffer.length)) > 0) {
	                out.write(buffer, 0, n);
	            }
	            gzip.close();
	            in.close();
	            out.close();
	            return out.toByteArray();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    	return null;
	    }
	    
	    


}
