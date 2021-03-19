package com.nautilus.authenticator.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
	
	@NotBlank
	private final String code;
	private final List<String> programmerMessage;
	private final List<String> userMessage;
	
	
	
	public Status(@JsonProperty("code") String code, 
			@JsonProperty("programmermessage") List<String> programmerMessage, 
	@JsonProperty("usermessage")List<String> userMessage) {
		super();
		this.code = code;
		this.programmerMessage = programmerMessage;
		this.userMessage = userMessage;
	}
	public String getCode() {
		return code;
	}
	public List<String> getProgrammerMessage() {
		return programmerMessage;
	}
	public List<String> getUserMessage() {
		return userMessage;
	}
	
	
}
