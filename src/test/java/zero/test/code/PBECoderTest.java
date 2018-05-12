package zero.test.code;
import static org.junit.Assert.*;

import org.junit.Test;

import util.PBECoder;
 
/**
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class PBECoderTest {
 
	@Test
	public void test() throws Exception {
		String inputStr = "hisahfsiauodhfiosuahfiso";
		System.err.println("原文: " + inputStr);
		byte[] input = inputStr.getBytes();
 
		String pwd = "12345678";
		System.err.println("密码: " + pwd);
 
		byte[] salt = PBECoder.initSalt();
		System.out.println(new String(salt));
		byte[] salt1 = PBECoder.initSalt();
		System.out.println(new String(salt1));
		byte[] data = PBECoder.encrypt(input, pwd, salt);
 
		System.err.println("加密后: " + PBECoder.encryptBASE64(data));
		
		byte[] output = PBECoder.decrypt(data, pwd, salt);
		String outputStr = new String(output);
 
		System.err.println("解密后: " + outputStr);
		assertEquals(inputStr, outputStr);
	}
 
}
