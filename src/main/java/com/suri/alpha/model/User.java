package com.suri.alpha.model;

import org.springframework.stereotype.Component;


public class User {
	private String userName;
	private String mobile;
	
	
	public User(String userName, String mobile) {
		
		this.userName = userName;
		this.mobile = mobile;
	}
	   public User() {}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobile=" + mobile + "]";
	}
	
	
	

}
