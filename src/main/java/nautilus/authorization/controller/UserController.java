package nautilus.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nautilus.authorization.dto.TokenDto;
import nautilus.authorization.dto.UserDto;
import nautilus.authorization.service.UserService;

@RestController
@RequestMapping("/authorization")
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping
	public TokenDto getUser(@RequestBody UserDto userDto) {
		return userService.findByPhone(userDto);
	}
	
}
