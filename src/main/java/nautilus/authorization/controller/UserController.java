package nautilus.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
		return userService.findByPhone(userDto.getPhoneNumber(), userDto.getSecretCode());
	}

}
