package com.nautilus.authenticator.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nautilus.authenticator.model.User;
import com.nautilus.authenticator.service.AuthenticatorService;

@RequestMapping("api/v1/authenticator")
@RestController
public class AuthenticatorController {
	
	
	private final AuthenticatorService authenticatorService;
	
	@Autowired
	public AuthenticatorController() {
		authenticatorService= new AuthenticatorService();
	}
	
	@PostMapping
	public void autorizeUser(@RequestBody @Valid @NotNull User user) {
		authenticatorService.autorizateClientByPhoneNumber(user);
	}
	
}
