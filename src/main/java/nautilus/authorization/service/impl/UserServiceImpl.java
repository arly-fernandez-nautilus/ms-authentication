package nautilus.authorization.service.impl;

import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.TokenHolder;
import com.auth0.net.AuthRequest;
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
	public TokenDto findByPhone(String phone, String pwd) {
		log.info("#phone: {}" , phone);
		User user = userRepository.findByPhone(phone);
		log.info("#user: {}" , user);

		AuthAPI auth = new AuthAPI("danielespinola.us.auth0.com", "K7R3zSZKhwnqEcKJRjmQmzcoIL7o9r5M", "xKxOTcsJFWo8SofXn4FYo0fn43ou6knPpEPmHIjOw_gxmghSDVy9PrjIHl0baTM7");
		String secretCodeDecoded = Utils.decrypt(pwd);
		AuthRequest request = auth.login(user.getEmail(), secretCodeDecoded)
				.setAudience("https://pepe.com/pepe")
				.setScope("read:users");

		TokenDto tokenDto = null;
		try {
			TokenHolder holder = request.execute();
			tokenDto = TokenDto.builder().token(holder.getAccessToken()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokenDto;
	}



}
