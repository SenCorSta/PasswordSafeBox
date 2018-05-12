package model;

public class Users {
	private String username;
	private String password;
	private String darkPassword;
	private int enabled;
	private int accountNonExpired;
	private int accountNonLocked;
	private int credentialsNonExpired;

	public int getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(int accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public int getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(int accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public int getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(int credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}

	public String getDarkPassword() {
		return darkPassword;
	}

	public void setDarkPassword(String darkPassword) {
		this.darkPassword = darkPassword;
	}
	
	
}
