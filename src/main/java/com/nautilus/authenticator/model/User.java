package com.nautilus.authenticator.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@NotBlank
	private final String phoneNumber;
	
	private String email;
	
	@NotBlank
	private String password;
	
	public User(@JsonProperty("phonenumber") String phoneNumber, 
			@JsonProperty("email") String email, 
			@JsonProperty("password") String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
}
