package nautilus.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nautilus.authorization.dto.TokenDto;
import nautilus.authorization.model.User;
import nautilus.authorization.repository.UserRepository;
import nautilus.authorization.service.UserService;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public TokenDto findByPhone(String phone) {
		log.info("#phone: {}" , phone);
		User user = userRepository.findByPhone(phone);
		log.info("#user: {}" , user);
		
		TokenDto tokenDto = TokenDto.builder().token("xxxxxxxxxx".concat(null!=user?user.getName():"Not-Found")).build();
		
		return tokenDto;
	}

}
