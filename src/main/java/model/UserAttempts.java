package model;

import java.util.Date;

public class UserAttempts {
	private int ID;
	private String username;
	private int attempts;
	private Date lastModified;
	private String lastIP;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getLastIP() {
		return lastIP;
	}
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}
	@Override
	public String toString() {
		return "UserAttempts [ID=" + ID + ", userName=" + username + ", attempts=" + attempts + ", lastModified="
				+ lastModified + ", lastIP=" + lastIP + "]";
	}
	
}
