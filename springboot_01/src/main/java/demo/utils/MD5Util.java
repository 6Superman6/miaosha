package demo.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
	private static final String salt = "1a2b3c4d";      // 默认的salt值

	//将form表单输入的密码转化为md5加密密码
	public static String inputPassToFormPass(String inputPass) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4); // 先变一下
//		System.out.println(str);  // 123456----->12123456c3
		return md5(str);  // md5加密
	}

	//将md5加密的密码转化为数据库密码
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}
	
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		String dbPass = formPassToDBPass(formPass, saltDB);
		return dbPass;
	}
	
	public static void main(String[] args) {
//		System.out.println(inputPassToFormPass("123456")); //d3b1294a61a07da9b49b6e22b2cbd7f9
		System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d")); //b7797cce01b4b131b433b6acf4add449

	}
	
}
