package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String maintype;
	
	private String subtype;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	@Override
	public String toString() {
		return "TicketCategory [Id=" + Id + ", maintype=" + maintype + ", subtype=" + subtype + "]";
	}
	
	
}
