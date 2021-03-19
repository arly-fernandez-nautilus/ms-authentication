package com.nautilus.authenticator.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;


@Configuration
@ConfigurationProperties("com.auth0")
@Repository
public class RestAuthServices {
	
	private String domain = "dev-hju79n6o.us.auth0.com";
	private String client ="1MAiweVMAX24xo7bjNxMDSGbH1j1niC6";
	
	public RestAuthServices() {

	}
	
	public RestAuthServices(String domain, String client) {
		super();
		this.domain = domain;
		this.client = client;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	
	
}
