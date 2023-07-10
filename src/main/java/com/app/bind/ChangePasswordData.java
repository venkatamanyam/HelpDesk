package com.app.bind;

import org.springframework.stereotype.Component;

@Component
public class ChangePasswordData {

	private String oldpassword;
	private String newpassword;
	
	
	public ChangePasswordData(String oldpassword, String newpassword) {
		super();
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
	}
	
	public ChangePasswordData() {
		super();
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
}
