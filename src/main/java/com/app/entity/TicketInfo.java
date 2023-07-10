package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
public class TicketInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer ticketId;
	private String title;
	private String description;
	private String seveority;
	private String priority;
	private String remarks;
	
	@CreatedDate()
	private LocalDate createddate;
	
	@LastModifiedDate
	private LocalDate updateddate;
	
    private LocalDate closedddate;
    
	private String maintype;
	private String subtype;
	private String status;
	private String ticketcreatedbyuid;
	private Integer assignedtouid;
	private String ticketfilename;
	private String ticketstoredlocation;
	
	private String country;
	private String state;
	private String city;
	private String location;
	private String risedByuserorg;
	private String risedByusergroup;
	

	
	
	public String getTicketfilename() {
		return ticketfilename;
	}
	public void setTicketfilename(String ticketfilename) {
		this.ticketfilename = ticketfilename;
	}
	public String getTicketstoredlocation() {
		return ticketstoredlocation;
	}
	public void setTicketstoredlocation(String ticketstoredlocation) {
		this.ticketstoredlocation = ticketstoredlocation;
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTicketcreatedbyuid() {
		return ticketcreatedbyuid;
	}
	public void setTicketcreatedbyuid(String ticketcreatedbyuid) {
		this.ticketcreatedbyuid = ticketcreatedbyuid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDate getCreateddate() {
		return createddate;
	}
	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}
	public LocalDate getCloseddate() {
		return closedddate;
	}
	public void setCloseddate(LocalDate closeddate) {
		this.closedddate = closeddate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAssignedtouid() {
		return assignedtouid;
	}
	public void setAssignedtouid(Integer assignedtouid) {
		this.assignedtouid = assignedtouid;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
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
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDate getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}
	public LocalDate getClosedddate() {
		return closedddate;
	}
	public void setClosedddate(LocalDate closedddate) {
		this.closedddate = closedddate;
	}
	public String getRisedByuserorg() {
		return risedByuserorg;
	}
	public void setRisedByuserorg(String risedByuserorg) {
		this.risedByuserorg = risedByuserorg;
	}
	public String getRisedByusergroup() {
		return risedByusergroup;
	}
	public void setRisedByusergroup(String risedByusergroup) {
		this.risedByusergroup = risedByusergroup;
	}
	@Override
	public String toString() {
		return "TicketInfo [id=" + id + ", ticketId=" + ticketId + ", title=" + title + ", description=" + description
				+ ", seveority=" + seveority + ", priority=" + priority + ", remarks=" + remarks + ", createddate="
				+ createddate + ", closeddate=" + closedddate + ", maintype=" + maintype + ", subtype=" + subtype
				+ ", status=" + status + ", ticketcreatedbyuid=" + ticketcreatedbyuid + ", assignedtouid="
				+ assignedtouid + ", ticketfilename=" + ticketfilename + ", ticketstoredlocation="
				+ ticketstoredlocation + "]";
	}
	
	
	
	
}
