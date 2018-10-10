package com.service.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
	
	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("DelayTime")
	private String delayTime;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}
	
	

}
