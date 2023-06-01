package model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ChangePassword {
	private String password;
	private String newPassword;
	public ChangePassword(String password, String newPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
	}
	
	public ChangePassword() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String toString() {
		return "ChangePassword [password=" + password + ", newPassword=" + newPassword + "]";
	}
	
}
