package nautilus.authorization.service;

import nautilus.authorization.model.User;

public interface UserService {

	User findByPhone(String phone);
	
}
