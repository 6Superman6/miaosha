package demo.utils;

import java.util.UUID;

public class UUIDUtil {

	/**
	 * 一个独一无二的uuid
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", ""); // 把原生的-去掉
	}
}
