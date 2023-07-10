package com.app.bind;

import org.springframework.stereotype.Component;

@Component
public class TicketBindData {
	
	private String title;
	private String description;
	private String seveority;
	private String remarks;
	private String maintype;
	private String subtype;
	private String risedByuserorg;
	private String country;
	private String state;
	private String city;
	private String location;
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeveority() {
		return seveority;
	}
	public void setSeveority(String seveority) {
		this.seveority = seveority;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getRisedByuserorg() {
		return risedByuserorg;
	}
	public void setRisedByuserorg(String risedByuserorg) {
		this.risedByuserorg = risedByuserorg;
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
	
}
