package com.nautilus.authenticator.model;

import org.springframework.stereotype.Repository;

import com.nautilus.authenticator.common.AuthenticatorCommon;

@Repository 
public class Authenticator {

	
	private final String codeVerifier;
	private final String codeChallenge;
	
	public Authenticator() {
		super();	
		AuthenticatorCommon auth = new AuthenticatorCommon();
		this.codeVerifier = auth.generateCodeVerifier();
		this.codeChallenge = auth.generateCodeChallenge(this.codeVerifier);
	}
	public String getCodeVerifier() {
		return codeVerifier;
	}
	public String getCodeChallenge() {
		return codeChallenge;
	}
}
