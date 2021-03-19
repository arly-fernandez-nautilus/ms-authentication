package nautilus.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nautilus.authorization.dto.TokenDto;
import nautilus.authorization.dto.UserDto;
import nautilus.authorization.model.User;
import nautilus.authorization.repository.UserRepository;
import nautilus.authorization.service.UserService;
import nautilus.authorization.util.Utils;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public TokenDto findByPhone(UserDto userDto) {
		log.info("#userDto: {}" , userDto);
		User user = userRepository.findByPhone(userDto.getPhoneNumber());
		log.info("#user: {}" , user);
		
		String secretCodeDecoded = Utils.decrypt(userDto.getSecretCode());
		log.info("#secretCodeDecoded: {}" , secretCodeDecoded);
		
		TokenDto tokenDto = TokenDto.builder().token(secretCodeDecoded).build();
		
		return tokenDto;
	}
	
	

}
