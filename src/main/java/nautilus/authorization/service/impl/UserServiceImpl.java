package nautilus.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nautilus.authorization.model.User;
import nautilus.authorization.repository.UserRepository;
import nautilus.authorization.service.UserService;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByPhone(String phone) {
		log.info("#phone: {}" , phone);
		return userRepository.findByPhone(phone);
	}

}
