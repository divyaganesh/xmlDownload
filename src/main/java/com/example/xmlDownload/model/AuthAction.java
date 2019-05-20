package com.example.xmlDownload.model;

public class AuthAction {
	
	private String Name;
	private String AllowedFor;
	private String DisabledFor;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAllowedFor() {
		return AllowedFor;
	}
	public void setAllowedFor(String allowedFor) {
		AllowedFor = allowedFor;
	}
	public String getDisabledFor() {
		return DisabledFor;
	}
	public void setDisabledFor(String disabledFor) {
		DisabledFor = disabledFor;
	}
	
	

}
