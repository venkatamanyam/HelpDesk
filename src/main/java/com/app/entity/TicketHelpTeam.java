package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketHelpTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer userId;

	private String userName;
	
	
	
	private String userorg;
	
	private String teammembertype;
	
	private String maintype;
	
	private String subtype;
	
    private String country;
	
	private String state;
	
	private String city;
	
	private String location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getUserorg() {
		return userorg;
	}

	public void setUserorg(String userorg) {
		this.userorg = userorg;
	}

	public String getTeammembertype() {
		return teammembertype;
	}

	public void setTeammembertype(String teammembertype) {
		this.teammembertype = teammembertype;
	}

	public String getMaintype() {
		return maintype;
	}

	public void setMaintype(String maintype) {
		this.maintype = maintype;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
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
		return "TicketHelpTeam [id=" + id + ", userId=" + userId + ", userName=" + userName + ",  userorg=" + userorg + ", teammembertype=" + teammembertype + ", maintype=" + maintype
				+ ", subtype=" + subtype + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", location=" + location + ", getId()=" + getId() + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ",  getUserorg()="
				+ getUserorg() + ", getTeammembertype()=" + getTeammembertype() + ", getMaintype()=" + getMaintype()
				+ ", getSubtype()=" + getSubtype() + ", getCountry()=" + getCountry() + ", getState()=" + getState()
				+ ", getCity()=" + getCity() + ", getLocation()=" + getLocation() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
