package nautilus.authorization.service;

import nautilus.authorization.dto.TokenDto;

public interface UserService {

	TokenDto findByPhone(String phone);
	
}
