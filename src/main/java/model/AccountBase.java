package model;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;


/**
 * person 实体类
 * 
 * @author Dice
 *
 */
public class AccountBase {
	Log log=LogFactory.getLog(getClass());
	private int id;
	private String name;
	private String kind;
	private String account;
	private String password;
	private String annotation;
	private String username;
	private byte[] salt;

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AccountBase [id=" + id + ", name=" + name + ", kind=" + kind + ", account=" + account + ", password="
				+ password + ", annotation=" + annotation + ", username=" + username + "]";
	}

	public void deCode() throws Exception {
//		if (password == null || password.isEmpty()) {
//		
//		}else {
//			byte[] inputdata = PBECoder.decryptBASE64(password);
//			byte[] output = PBECoder.decrypt(inputdata, username, salt);
//			String outputStr = new String(output);
//			this.password = outputStr;
//		}
	}

}
