package com.rspcb.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dropdown_master")
public class DropdownMaster {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type; // ROHO, INDUSTRY, APPTYPE, APPFOR
	private String value; // Delhi, IT, License, Factory
	public DropdownMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DropdownMaster(long id, String type, String value) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
