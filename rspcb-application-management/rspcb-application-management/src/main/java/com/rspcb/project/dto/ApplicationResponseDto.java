package com.rspcb.project.dto;

import java.time.LocalDate;

public class ApplicationResponseDto {
	private Long id;
	private String roho;
	private String industryType;
	private String applicationType;
	private String applicationFor;
	private LocalDate createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoho() {
		return roho;
	}
	public void setRoho(String roho) {
		this.roho = roho;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getApplicationFor() {
		return applicationFor;
	}
	public void setApplicationFor(String applicationFor) {
		this.applicationFor = applicationFor;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	

}
