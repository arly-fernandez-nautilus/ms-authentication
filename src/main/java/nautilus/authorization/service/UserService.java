package nautilus.authorization.service;

import nautilus.authorization.dto.TokenDto;
import nautilus.authorization.dto.UserDto;

public interface UserService {

	TokenDto findByPhone(UserDto userDto);
	
}
