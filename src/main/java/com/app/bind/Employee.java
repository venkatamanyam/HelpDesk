package com.app.bind;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String userId;

	private String userName;

	private String userEmail;

	private String userPassword;

	private Long mobilenumber;

	private String userRole;

	private String userorg;

	private String country;
	
	private String state;
	
	private String city;
	
	private String location;

	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	


	public String getUserorg() {
		return userorg;
	}

	public void setUserorg(String userorg) {
		this.userorg = userorg;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", mobilenumber=" + mobilenumber + ", userRole=" + userRole + ", userOrg=" + userorg
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", location=" + location + "]";
	}

	
	

}
