package com.app.bind;

import org.springframework.stereotype.Component;

@Component
public class ConfirmPasswordData {

	private String confirmpassword;
	private String newpassword;
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public ConfirmPasswordData() {
		super();
	}
	public ConfirmPasswordData(String confirmpassword, String newpassword) {
		super();
		this.confirmpassword = confirmpassword;
		this.newpassword = newpassword;
	}
	
	@Override
	public String toString() {
		return "ConfirmPasswordData [confirmpassword=" + confirmpassword + ", newpassword=" + newpassword + "]";
	}
	
	
}
