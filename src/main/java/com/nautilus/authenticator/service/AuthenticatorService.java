package com.nautilus.authenticator.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.nautilus.authenticator.common.AuthenticatorCommon;
import com.nautilus.authenticator.common.RestAuthServices;
import com.nautilus.authenticator.common.RestUserServices;
import com.nautilus.authenticator.model.Authenticator;
import com.nautilus.authenticator.model.User;

@Service
public class AuthenticatorService {

	private HashMap<String,String> servicePhoneNumber = new HashMap<String,String>();
	private AuthenticatorCommon commonsFuction = new AuthenticatorCommon();
	
	@Autowired
	public AuthenticatorService() {
		servicePhoneNumber.put("1154793754", "yuman.montero@nautilus.team");
		
	}
	
	
	
	public String autorizateClientByPhoneNumber(User user) 
	{
		RestUserServices userService = new RestUserServices();
		RestAuthServices authService = new RestAuthServices();
		Map<String, String> params = new HashMap<String, String>();
		
		/*get email by number service*/
		/*params.put("mobile", user.getPhoneNumber());
		try {
			String result = commonsFuction.restTemplate().getForObject(userService.getHost()+userService.getPort()+
					userService.getEndpoint()+"{mobile}", String.class);
		}catch (Exception e) {
			e.printStackTrace();
		}*/

		/*get email by number service mock*/
		servicePhoneNumber.get(user.getPhoneNumber());
		/*generate code verifier and code challenge*/
		Authenticator authenticator = new Authenticator();
	
		/*get secret from auth0 services*/
		try {
			params.put("response_type", "code");
			params.put("code_challenge", authenticator.getCodeChallenge());
			params.put("code_challenge_method", "S256");
			params.put("client_id", authService.getClient());
			params.put("redirect_uri", "http://localhost:3000/callback");
			params.put("scope", "openid");
			//params.put("state", "xyzABC123x");
			
			/*
			System.out.println("https://"+authService.getDomain()+"/authorize?response_type=code&code_challenge="+authenticator.getCodeChallenge()+"&"
					+ "code_challenge_method=S256&client_id="+authService.getClient()+"&redirect_uri=http://localhost:3000/callback&scope=openid profile");
			*/
			/*String result = commonsFuction.restTemplate().getForObject( ""
					+ "https://"+authService.getDomain()+"/authorize?response_type={response_type}&code_challenge={code_challenge}&"
							+ "code_challenge_method={code_challenge_method}&client_id={client_id}&redirect_uri={redirect_uri}&scope={scope}"
							+ "&state={state}"  , String.class , params);*/
			
			RequestCallback requestCallback = null;
			
			ResponseEntity<Object> result = commonsFuction.restTemplate().execute("https://"+authService.getDomain()+"/authorize?response_type=code&code_challenge="+authenticator.getCodeChallenge()+"&"
					+ "code_challenge_method=S256&client_id="+authService.getClient()+"&redirect_uri=http://localhost:3000/callback&scope=openid&audience=appointments:api", HttpMethod.GET, requestCallback, commonsFuction.restTemplate().responseEntityExtractor(String.class), params);
			System.out.println(result.getStatusCode().toString());
			System.out.println(result.getHeaders().toString());
			System.out.println(result.getBody().toString());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*use secret and get user token with database authentication based*/
		
		
		
		return "null";
		
		
		
	}	
}
