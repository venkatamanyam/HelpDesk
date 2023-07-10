package com.app.bind;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
	
	private String userId;
	private String userPassword;
	
	
	
	



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	


	public LoginRequest(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}



	public LoginRequest() {
		super();
	}
	

}
