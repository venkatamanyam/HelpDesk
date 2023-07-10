package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class EmployeeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk;
	
	
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
	
	
	
	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

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
		return "EmployeeInfo [pk=" + pk + ", userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", mobilenumber=" + mobilenumber + ", userRole=" + userRole
				+ ",  country=" + country + ", state=" + state + ", city=" + city
				+ ", location=" + location + "]";
	}

	

	
	
	
}
