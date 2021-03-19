package com.nautilus.authenticator.common;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AuthenticatorCommon {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		
		if (restTemplate == null) 
		{
			RestTemplateBuilder builder = new RestTemplateBuilder();
			restTemplate = builder
		            .setConnectTimeout(Duration.ofMillis(3000))
		            .setReadTimeout(Duration.ofMillis(3000))
		            .build();
		}
		
		return restTemplate;
	}
	
	public String generateCodeVerifier() {
		SecureRandom sr = new SecureRandom();
		byte[] code = new byte[32];
		sr.nextBytes(code);
		return Base64.encodeBase64URLSafeString(code);
	}
	
	public String generateCodeChallenge(String codeVerifier) {
		try {
			byte[] bytes = codeVerifier.getBytes("US-ASCII");
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes, 0, bytes.length);
			byte[] digest = md.digest();
			return Base64.encodeBase64URLSafeString(digest);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	
	

}
