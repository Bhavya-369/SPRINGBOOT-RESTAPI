package com.suri.alpha.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDTO {
	
	@NotNull(message = "name should not be blank")
	private String userName;
	@Size(max = 10, min = 10, message = "mobile number must be 10 digits")
	private String mobile;
	
	
	public UserDTO() {}
	
	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public UserDTO( String userName,String mobile) {
		this.userName = userName;
		this.mobile = mobile;
	}




	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobile=" + mobile + "]";
	}

}
